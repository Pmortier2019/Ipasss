// Functie om het registerformulier in te dienen
function register() {
    // Haal de invoerwaarden op uit het formulier
    const naam = document.getElementById("inputNaam").value;
    const rol = document.getElementById("inputRol").value;
    const geslacht = document.getElementById("inputGeslacht").value;
    const username = document.getElementById("inputUsername").value;
    const password = document.getElementById("inputPassword").value;

    if (!naam || !rol || !geslacht || !username || !password) {
        alert("Vul alle velden in.");
        return Promise.reject("Vul alle velden in.");
    }

    const user = {
        naam: naam,
        rol: rol,
        geslacht: geslacht,
        aantal: "0",
        id: "",
        username: username,
        password: password
    };

    // Stuur het gebruikerobject naar de backend voor registratie
    return fetch("https://ipass-pieter.azurewebsites.net/restservices/personen/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(response => {
            if (response.ok) {
                console.log("Gebruiker succesvol geregistreerd.");
                alert("Gebruiker succesvol geregistreerd.");
                // Doorgaan naar de gewenste pagina (bijv. login.html)
                window.location.href = "index.html";
            } else {
                throw new Error("Er is een fout opgetreden bij het registreren van de gebruiker.");
            }
        })
        .catch(error => {
            console.error(error);
            alert("Er is een fout opgetreden bij het registreren van de gebruiker.");
        });
}

// Eventlistener voor het registerformulier
document.getElementById("registerform").addEventListener("submit", event => {
    event.preventDefault();

    register();
});
