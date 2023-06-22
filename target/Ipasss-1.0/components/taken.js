document.addEventListener('DOMContentLoaded', () => {
  const todoForm = document.getElementById('todo-form');
  const todoInput = document.getElementById('todo-input');
  const todoList = document.getElementById('todo-list');

  const addTodo = (task) => {
      const listItem = document.createElement('li');
      listItem.textContent = task;

      listItem.addEventListener('click', () => {
          listItem.classList.toggle('completed');
      });

      todoList.appendChild(listItem);
  };

  todoForm.addEventListener('submit', (e) => {
      e.preventDefault();

      const newTask = todoInput.value;
      addTodo(newTask);

      fetch('', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({ task: newTask })
      })
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.log(error));

      todoInput.value = '';
  });

  fetch('')
  .then(response => response.json())
  .then(data => {
      data.forEach(todo => {
          addTodo(todo.task);
      });
  })
  .catch(error => console.log(error));
});