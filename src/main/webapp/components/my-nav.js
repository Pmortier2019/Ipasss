
const navContainer = document.getElementById('my-nav-container');

const navBar = document.createElement('nav');
const navList = document.createElement('ul');
const navItems = ['Home', 'Over ons', 'Diensten', 'Contact'];

// Voeg de navigatie-items toe aan de lijst
navItems.forEach((item) => {
  const listItem = document.createElement('li');
  const link = document.createElement('a');
  link.textContent = item;
  listItem.appendChild(link);
  navList.appendChild(listItem);
});

// Voeg de navigatielijst toe aan de navigatiebalk
navBar.appendChild(navList);

// Voeg de navigatiebalk toe aan het containerelement
navContainer.appendChild(navBar);
