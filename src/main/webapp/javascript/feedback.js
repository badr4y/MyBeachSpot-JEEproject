$(document).ready(function() {
    // Attach an event listener to the form submit button
    $("#feedbackForm").submit(function(event) {
        event.preventDefault();

        // Disable the submit button to prevent multiple submissions
        $("button[type='submit']").prop("disabled", true);

        // Show a loading spinner
        $(".spinner-border").removeClass("d-none");

        // Make an AJAX request to submit the form data
        $.ajax({
            type: "POST",
            url: "/submitFeedback",
            data: $(this).serialize(),
            success: function(response) {
                // Hide the loading spinner
                $(".spinner-border").addClass("d-none");

                // Clear the form inputs
                $("#name").val("");
                $("#email").val("");
                $("#rating").val("");
                $("#feedback").val("");

                // Show a success message
                $("#successMessage").removeClass("d-none");

                // Re-enable the submit button
                $("button[type='submit']").prop("disabled", false);
            },
            error: function() {
                // Hide the loading spinner
                $(".spinner-border").addClass("d-none");

                // Show an error message
                $("#errorMessage").removeClass("d-none");

                // Re-enable the submit button
                $("button[type='submit']").prop("disabled", false);
            }
        });
    });
});