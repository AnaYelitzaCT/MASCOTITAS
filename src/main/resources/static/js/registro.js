const btn = document.getElementById('button');

document.getElementById('form')
 .addEventListener('submit', function(event) {
   event.preventDefault();
  let name = document.getElementById('name');// es el componente nombre pero no es el valor del campo nombre
  let numtel = document.getElementById('phone');// es el componente nombre pero no es el valor del campo nombre
  let mail = document.getElementById('email');
  let contra1 = document.getElementById('contraseña1');
  let contra2 = document.getElementById('contraseña2');
  console.log(contra1.value);
  console.log(contra2.value);
  // comienzan validaciones
  if(/[\d]/.test(name.value)===true){
    alert('Porfavor coloque un nombre sin numeros ');
    //enviamos la variable que hace referencia al componente
    cleanAndFocus(name);
   // document.getElementById("name").value = "";
    //document.getElementById("name").focus();
  }
  else if(/[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(name.value) === true) {
    alert('Por favor, coloca un nombre sin caracteres especiales.');
    cleanAndFocus(name);
  }else if(numtel.value.length !=10){
    alert('Porfavor coloque un número de telefono valido');
    cleanAndFocus(numtel);
  }else if(contra1.value != contra2.value || contra1.value === "" || contra2.value === ""){
    alert('Verifique que las contaseñas sean iguales');
    contra1.value = "";
    contra2.value = "";
  }
  else{
    btn.value = 'Registrando...';
    
    let json = JSON.stringify({"Nombre": name.value,"Telefono": phone.value,
    "Email": email.value, "Contraseña": contraseña1.value});
    localStorage.setItem("Usuario", json); 
    //  obtención de localStorage
    let localStorageGet = localStorage.getItem("Usuario");
    console.log(localStorageGet);
       alert('Usuario registrado!');
       document.getElementById('form').reset();
  }
   
});

function cleanAndFocus(component){
  component.value ="";
  component.focus();
}