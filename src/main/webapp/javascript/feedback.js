const form = document.getElementById("feedback-form");
const message = document.getElementById("message");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  const name = form.elements["name"].value;
  const email = form.elements["email"].value;
  const rating = form.elements["rating"].value;
  const comments = form.elements["comments"].value;

  // Validate form data
  if (!name || !email || !rating || !comments) {
    message.classList.remove("success");
    message.classList.add("error");
    message.textContent = "Please fill out all fields.";
    return;
  }

  // Submit form data to server
  fetch("submit-feedback.php", {
    method: "POST",
    body: JSON.stringify({
      name: name,
      email: email,
      rating:
