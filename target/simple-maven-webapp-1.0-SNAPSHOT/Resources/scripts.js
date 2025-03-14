$(document).ready(function () {
    function calculateTotalDays() {
        var bookingDate = new Date($("#bookingDate").val());
        var returnDate = new Date($("#returnDate").val());

        if (!isNaN(bookingDate.getTime()) && !isNaN(returnDate.getTime()) && returnDate >= bookingDate) {
            var daysDiff = Math.ceil((returnDate - bookingDate) / (1000 * 3600 * 24)); // Convert to days
            $("#totalDays").val(daysDiff);
        } else {
            $("#totalDays").val(""); // Clear if invalid
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

    // When location changes, update distance and price
    $("#location").change(function () {
        var selectedOption = $(this).find(':selected');
        var distance = selectedOption.data("distance");
        var price = selectedOption.data("price");

        $("#distance").val(distance);
        $("#price").val(price);
        $("#endLocation").val(selectedOption.text()); // Update hidden input

        calculateTotalPrice();
        calculateNewPrice();
    });

    // When vehicle type changes, filter vehicles
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

    // When vehicle changes, update added value
    $("#vehicle").change(function () {
        $("#vehicleName").val($(this).find(":selected").text());
        calculateTotalPrice();
        calculateNewPrice();
    });

    // Update calculations on date change
    $("#bookingDate, #returnDate").change(function () {
        calculateTotalDays();
        calculateTotalPrice();
    });
});
