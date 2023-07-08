// Functie om in te loggen
function login() {
    // Haal de gebruikersnaam en wachtwoord op uit het formulier
    const username = document.forms["loginform"]["username"].value;
    const password = document.forms["loginform"]["password"].value;

    // Maak een HTTP POST-verzoek naar de inlog-API
    return fetch('/restservices/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
        .then(response => {
            // Controleer de status van het antwoord
            if (response.ok) {
                // Inloggen is gelukt, ontvang de JWT-token van het antwoord
                return response.json().then(data => {
                    const token = data.token;

                    // Sla de JWT-token op in de lokale opslag
                    localStorage.setItem('token', token);

                    // Doorgaan naar de gewenste pagina (bijv. agenda.html)
                    window.location.href = 'taakverdeel.html';
                });
            } else {
                // Inloggen is mislukt, toon een foutmelding
                return Promise.reject('Fout bij het inloggen. Controleer uw gebruikersnaam en wachtwoord.');
            }
        })
        .catch(error => {
            // Vang eventuele fouten op
            alert(error);
        });
}

// Eventlistener voor de login knop
document.getElementById('login').addEventListener('click', login);
