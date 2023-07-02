import { login } from "components/loginService.js";

document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    login(username, password)
        .then(function(data) {
            if (data.token) {
                localStorage.setItem("jwtToken", data.token);
                window.location.href = "/protected";
            } else {
                alert(data.message);
            }
        })
        .catch(function(error) {
            console.error("Error:", error);
        });
});
