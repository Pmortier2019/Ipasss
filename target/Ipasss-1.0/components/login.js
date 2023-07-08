// Functie om in te loggen
function login() {
    const username = document.forms["loginform"]["username"].value;
    const password = document.forms["loginform"]["password"].value;
    return fetch('https://ipass-pieter.azurewebsites.net/restservices/login', {
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
            if (response.ok) {
                return response.json().then(data => {
                    const token = data.token;
                    localStorage.setItem('token', token);
                    window.location.href = 'taakverdeel.html';
                });
            } else {
                return Promise.reject('Fout bij het inloggen. Controleer uw gebruikersnaam en wachtwoord.');
            }
        })
        .catch(error => {
            alert(error);
        });
}

// Eventlistener voor de login knop
document.getElementById('login').addEventListener('click', login);
document.getElementById('register').addEventListener('click', () => {
    window.location.href = 'register.html';
});
