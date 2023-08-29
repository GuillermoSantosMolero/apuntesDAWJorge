var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");
var simbolo = document.getElementById("simbolo");

// When the user clicks on the password field, show the message box
document.getElementById("psw").onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
document.getElementById("psw").onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
document.getElementById("psw").onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]{2,}/g;
  if(document.getElementById("psw").value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]{2,}/g;
  if(document.getElementById("psw").value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]{2,}/g;
  if(document.getElementById("psw").value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  //Validar simbolo
  var simbolos = /[_$@#]{1,}/g;
  if(document.getElementById("psw").value.match(simbolos)) {
    simbolo.classList.remove("invalid");
    simbolo.classList.add("valid");
  } else {
    simbolo.classList.remove("valid");
    simbolo.classList.add("invalid");
  }
  // Validate length
  if(document.getElementById("psw").value.length >6 &&document.getElementById("psw").value.length<13) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
  
}