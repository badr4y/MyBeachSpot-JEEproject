// Get form elements
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const confirmPasswordInput = document.getElementById('confirm-password');
const form = document.querySelector('form');

// Validate form
function validateForm(event) {
  event.preventDefault();
  
  // Check that password and confirm password fields match
  if (passwordInput.value !== confirmPasswordInput.value) {
    const errorMessage = document.createElement('p');
    errorMessage.className = 'error-message';
    errorMessage.textContent = 'Passwords do not match.';
    form.appendChild(errorMessage);
  } else {
    // Submit form if validation passes
    form.submit();
  }
}

// Add event listener to form
form.addEventListener('submit', validateForm);
