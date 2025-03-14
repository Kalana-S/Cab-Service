<%@ page import="java.sql.*, com.mycompany.simple.maven.util.DatabaseUtil" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.mycompany.simple.maven.model.Customer" %>
<%@ page import="com.mycompany.simple.maven.model.Location" %>
<%@ page import="com.mycompany.simple.maven.model.Vehicle" %>


<%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Booking</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
     <h2>Welcome, <%= (customer != null) ? customer.getName() : "Guest" %></h2>
      <% if (customer == null) { %>
            <p style="color: red;">Session expired or not set. Please log in again.</p>
            <a href="customerLogin.jsp">Login</a>
        <% } else { %>
            <p>Your email: <%= customer.getEmail() %></p>
            <p>Your NIC: <%= customer.getNic() %></p>
            <p>Your Mobile: <%= customer.getMobileNo() %></p>
        <% } %>
    
    <form action="addBooking" method="post">
        
        <label>Start Location:</label>
        <input type="text" value="Colombo" readonly><br>
        
        <label>End Location:</label>
        <input type="hidden" name="endLocation" id="endLocation">
        <select name="location" id="location">
            <%
                Connection conn = DatabaseUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM location");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getInt("location_number") %>" 
                        data-distance="<%= rs.getInt("distance") %>" 
                        data-price="<%= rs.getInt("price") %>">
                    <%= rs.getString("end_location_name") %>
                </option>
            <% } %>
        </select><br>

        <label>Distance:</label>
        <input type="text" id="distance" name="price" readonly><br>

        <label>Price:</label>
        <input type="text" id="price" readonly><br>

        <label>Vehicle Type:</label>
        <input type="hidden" name="vehicleName" id="vehicleName">
        <select id="vehicleType">
            <option value="">-- Select Vehicle Type --</option>
            <%
                ps = conn.prepareStatement("SELECT DISTINCT vehicle_type FROM vehicle");
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getString("vehicle_type") %>"><%= rs.getString("vehicle_type") %></option>
            <% } %>
        </select><br>

        <label>Vehicle Name:</label>
        <select name="vehicle" id="vehicle">
            <option value="">-- Select Vehicle --</option>
            <%  
                ps = conn.prepareStatement("SELECT * FROM vehicle");
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getInt("vehicle_number") %>" 
                        data-type="<%= rs.getString("vehicle_type") %>" 
                        data-added-value="<%= rs.getDouble("added_value") %>">
                    <%= rs.getString("vehicle_name") %>
                </option>
            <% } %>
        </select><br>
        
        <label>New Price:</label>
        <input type="text" id="newPrice" name="newPrice" readonly><br>

        <label>Booking Date:</label>
        <input type="date" name="bookingDate" id="bookingDate" required><br>

        <label>Return Date:</label>
        <input type="date" name="returnDate" id="returnDate" required><br>

        <label>Total Days:</label>
        <input type="text" id="totalDays" name="totalDays" readonly><br>

        <label>Total Price:</label>
        <input type="text" id="totalPrice" name="totalPrice" readonly><br>

        <button type="submit">Add Booking</button>
    </form>

    <script>
        $(document).ready(function () {

            $("#location").change(function () {
                var selectedOption = $(this).find(':selected');
                $("#distance").val(selectedOption.data("distance"));
                $("#price").val(selectedOption.data("price"));
                calculateTotalPrice();
                calculateNewPrice();
            });

             $("#vehicleType").change(function () {
                var selectedType = $(this).val();

                $("#vehicle option").each(function () {
                    if ($(this).data("type") === selectedType || $(this).val() === "") {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });

                $("#vehicle").val("");
                calculateNewPrice();
            });

            $("#bookingDate, #returnDate").change(function () {
                calculateTotalDays();
                calculateTotalPrice();
                calculateNewPrice();
            });

            function calculateTotalDays() {
                var bookingDate = new Date($("#bookingDate").val());
                var returnDate = new Date($("#returnDate").val());

                if (bookingDate && returnDate && returnDate >= bookingDate) {
                    var timeDiff = returnDate.getTime() - bookingDate.getTime();
                    var daysDiff = timeDiff / (1000 * 3600 * 24);
                    $("#totalDays").val(daysDiff);
                } else {
                    $("#totalDays").val("");
                }
            }

            function calculateTotalPrice() {
                var basePrice = parseFloat($("#price").val()) || 0;
                var addedValue = parseFloat($("#vehicle").find(':selected').data("added-value")) || 1;
                var totalDays = parseInt($("#totalDays").val()) || 0;

                if (basePrice && addedValue) {
                    var totalPrice = (basePrice * addedValue) + (totalDays * 200);
                    $("#totalPrice").val(totalPrice.toFixed(2));
                } else {
                    $("#totalPrice").val("");
                }
            }

            function calculateNewPrice() {
                var basePrice = parseFloat($("#price").val()) || 0;
                var addedValue = parseFloat($("#vehicle").find(':selected').data("added-value")) || 1;

                if (basePrice && addedValue) {
                    var newPrice = basePrice * addedValue;
                    $("#newPrice").val(newPrice.toFixed(2));
                } else {
                    $("#newPrice").val("");
                }
            }
            
            $("#vehicle").change(function () {
                calculateTotalPrice();
                calculateNewPrice();
            });
            $("#location").change(function () {
                $("#endLocation").val($(this).find(":selected").text());
            });

            $("#vehicle").change(function () {
                $("#vehicleName").val($(this).find(":selected").text());
            });
        });
    </script>
</body>
</html>
