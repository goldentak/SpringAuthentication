document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); 

    const email = document.querySelector(".email").value.trim();
    const password = document.querySelector(".password").value.trim();
    const errorMessage = document.querySelector(".error-message");

    if (!validateEmail(email)) {
        errorMessage.textContent = "Enter valid email";
        return;
    }

    if (password.length < 8) {
        errorMessage.textContent = "Password must be at least 8 characters long";
        return;
    }

    const requestData = {
        email: email,
        password: password
    };

    console.log(" Ready for sending:", requestData);

    fetch("http://localhost:8081/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestData)
    })
    .then(response => {
        console.log("Status:", response.status);
        if (!response.ok) {
            throw new Error("Authentication error");
        }
        return response.text();
    })
    .then(data => {
        console.log("Server response:", data);
        
        window.location.assign("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");

    })
    .catch(error => {
        errorMessage.textContent = "Error: invalid Email or Password";
        console.error("Error:", error);
    });
});


function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

document.querySelector(".toggle-password").addEventListener("click", function() {
    const passwordField = document.querySelector(".password");
    passwordField.type = passwordField.type === "password" ? "text" : "password";
});
