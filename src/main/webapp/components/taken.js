function addTask() {
    var inputFieldValue = document.getElementById("inputField").value;
    
    var data = {
        taak: inputFieldValue
    };
    
    fetch("Ipass/resource/TaakResource", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(function(response) {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error("Er is een fout opgetreden bij het verwerken van het verzoek.");
        }
    })
    .then(function(response) {
        if (response.success) {
            var taskList = document.getElementById("taskList");
            var taskItem = document.createElement("p");
            taskItem.textContent = inputFieldValue;
            taskList.appendChild(taskItem);
        } else {
            console.log("doet het niet");
        }
    })
    .catch(function(error) {
        console.error(error);
    });
}

document.getElementById("todo-form").addEventListener("submit", function(event) {
    event.preventDefault();
    
    addTask();
});
