// Functie om taken op te halen en weer te geven
function fetchTasks() {
    fetch("https://ipass-pieter.azurewebsites.net/restservices/taken")
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Er is een fout opgetreden bij het ophalen van de taken.");
            }
        })
        .then(taken => {
            const dataOutput = document.getElementById("data-output");
            let output = "";

            for (const taak of taken) {
                output += `
                    <tr>
                        <td>${taak.naam}</td>
                        <td>${taak.duur}</td>
                        <td>${taak.omschrijving}</td>
                        <td>${taak.id}</td>
                    </tr>
                `;
            }

            dataOutput.innerHTML = output;
        })
        .catch(error => {
            console.error(error);
        });
}

// Functie om de lijst met taken bij te werken
function refreshTaskList() {
    fetchTasks();
}

function addTask() {
    return new Promise((resolve, reject) => {
        const taskName = document.getElementById("inputName").value;
        const taskDuration = document.getElementById("inputDuration").value;
        const taskDescription = document.getElementById("inputDescription").value;
// Trim, geen lege invoervelden
        if (taskName.trim() === "" || taskDuration.trim() === "" || taskDescription.trim() === "") {
            reject(new Error("Vul alle invoervelden in."));
            return;
        }

        const durationValue = parseInt(taskDuration);
        if (isNaN(durationValue)) {
            alert("probeer opnieuw, voer bij duur een getal in")
            reject(new Error("Ongeldige invoer voor tijdsduur. Voer alleen getallen in."));
            return;
        }
        const task = {
            naam: taskName,
            duur: durationValue+ " minuten",
            omschrijving: taskDescription,
            id: ""
        };

        fetch("https://ipass-pieter.azurewebsites.net/restservices/taken/update-taken", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(task)
        })
            .then(response => {
                if (response.ok) {
                    resolve(response.json());
                } else {
                    throw new Error("Er is een fout opgetreden bij het verwerken van het verzoek.");
                }
            })
            .then(response => {
                if (response.success) {
                    resolve("Taak succesvol toegevoegd.");
                } else {
                    reject(new Error("Fout bij het toevoegen van de taak."));
                }
            })
            .catch(error => {
                reject(error);
            });
    });
}



// Eventlistener voor het formulier
document.getElementById("todo-form").addEventListener("submit", event => {
    event.preventDefault();

    addTask();

    // Reset de invoervelden
    document.getElementById("inputName").value = "";
    document.getElementById("inputDuration").value = "";
    document.getElementById("inputDescription").value = "";
});

// Haal taken op bij het laden van de pagina
refreshTaskList();
