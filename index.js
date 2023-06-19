
// Get the username from localStorage
const username = localStorage.getItem("username");

// Check if the username exists
if (username) {
  const elementsToShow = [
    "profileIcon",
    "icon2",
    "logout"
  ];

  const elementsToHide = [
    "sign",
    "icon",
    "icon1",
    "login"
  ];

  function toggleElementsVisibility(elements, displayValue) {
    elements.forEach((elementId) => {
      const element = document.getElementById(elementId);
      element.style.display = displayValue;
    });
  }

  // Update visibility of elements to show
  toggleElementsVisibility(elementsToShow, "block");
  toggleElementsVisibility(elementsToHide, "none");


  // Update the username element with the username value
  const loggedInUsername = document.getElementById("loggedInUsername");
  loggedInUsername.textContent = username;
  loggedInUsername.style.display = "block";

  const sellerCardDetails = document.getElementsByClassName("seller__card__details");
  for (let i = 0; i < sellerCardDetails.length; i++) {
    sellerCardDetails[i].style.display = "block";
  }


  // Add click event listener to the logout button
  const logoutButton = document.getElementById("logout");
  logoutButton.addEventListener("click", function() {

    alert("You have been logged out successfully")
    // Reverse the process when logout button is clicked
    toggleElementsVisibility(elementsToShow, "none");
    toggleElementsVisibility(elementsToHide, "block");

    // Clear the username from localStorage
    localStorage.removeItem("username");

    // Reset the username element
    loggedInUsername.textContent = "";
    loggedInUsername.style.display = "none";

    for (let i = 0; i < sellerCardDetails.length; i++) {
      sellerCardDetails[i].style.display = "none";
    }
  });
}
else{
  const shopNowButton = document.getElementById("shop");
  shopNowButton.addEventListener("click", function() {
    alert("Please Login to Continue");
    window.location.href = "login.html";
  });
}

function redirectToFinalPage(productName, price, originalPrice, button) {
  
  const cardDetails = button.parentNode; 

  const quantityInput = cardDetails.querySelector('input[type="number"]');
  const colorSelect = cardDetails.querySelector('select');
  
  const quantity = quantityInput.value;
  const color = colorSelect.value;
  if (quantity === "") {
    alert("Please select a quantity.");
    return;
  }

const url = `finalPage.html?productName=${encodeURIComponent(productName)}&price=${encodeURIComponent(price)}&originalPrice=${encodeURIComponent(originalPrice)}&quantity=${encodeURIComponent(quantity)}&color=${encodeURIComponent(color)}`;
  window.location.href = url;


  quantityInput.value = "";
colorSelect.value = "";

}
 var navBar = document.querySelector('.nav__bar');
var navBarOffset = navBar.offsetTop;

window.addEventListener('scroll', function() {
  if (window.pageYOffset >= navBarOffset) {
    navBar.classList.add('fixed');
  } else {
    navBar.classList.remove('fixed');
  }
});

   function showOverlay(src) {
      const overlay = document.querySelector('.product__overlay');
      const overlayImg = document.getElementById('overlayImg');

      overlayImg.src = src;
      overlay.classList.add('active');
      document.body.style.overflow = 'hidden';
    }

    function hideOverlay() {
      const overlay = document.querySelector('.product__overlay');

      overlay.classList.remove('active');
      document.body.style.overflow = 'auto';
    }

