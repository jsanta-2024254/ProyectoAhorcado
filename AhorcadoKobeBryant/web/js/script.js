let palabrita;
let cant_errores = 0;
let cant_aciertos = 0;
let tiempo; // tiempo restante
let intervalo; // control del temporizador
let pistaActual = ""; 

const palabras = [];

const btn = id("jugar");
const imagen = id("imagen");
const btn_pista = id("pista"); 
const tiempoElem = id("tiempo"); 
const pistaElem = id("texto_pista"); 

const btn_letras = document.querySelectorAll("#letras button");

function obtener_random(num_min, num_max) {
  const amplitud_valores = num_max - num_min;
  const valor_al_azar = Math.floor(Math.random() * amplitud_valores) + num_min;
  return valor_al_azar;
}

function id(str) {
  return document.getElementById(str);
}

function iniciar(event) {
  imagen.src = "Image/kobe0.png";
  btn.disabled = true;
  cant_errores = 0;
  cant_aciertos = 0;
  pistaElem.innerHTML = "";
  tiempo = 60;
  btn_pista.disabled = false;

  tiempoElem.style.display = "inline-flex";

  // Reiniciar temporizador
  clearInterval(intervalo);
  intervalo = setInterval(actualizarTiempo, 1000);
  tiempoElem.innerHTML = tiempo;

  tiempoElem.classList.remove("tiempo-low");

  const parrafo = id("palabra_a_adivinar");
  parrafo.innerHTML = "";

  const cant_palabras = palabras.length;
  const valor_al_azar = obtener_random(0, cant_palabras);

  palabrita = palabras[valor_al_azar].palabra;
  pistaActual = palabras[valor_al_azar].pista; // guardamos la pista en variable
  console.log("Palabra elegida:", palabrita);

  const cant_letras = palabrita.length;

  for (let i = 0; i < btn_letras.length; i++) {
    btn_letras[i].disabled = false;
  }

  for (let i = 0; i < cant_letras; i++) {
    const span = document.createElement("span");
    parrafo.appendChild(span);
  }

  id("resultado").innerHTML = ""; 
}

// Manejo de letras
for (let i = 0; i < btn_letras.length; i++) {
  btn_letras[i].addEventListener("click", click_letras);
}

function click_letras(event) {
  const spans = document.querySelectorAll("#palabra_a_adivinar span");
  const button = event.target;
  button.disabled = true;
  const letra = button.innerHTML.toLowerCase();
  const palabra = palabrita.toLowerCase();

  let acerto = false;
  for (let i = 0; i < palabra.length; i++) {
    if (letra === palabra[i]) {
      spans[i].innerHTML = letra;
      cant_aciertos++;
      acerto = true;
    }
  }

  if (!acerto) {
    cant_errores++;
    const source = `Image/kobe${cant_errores}.png`;
    imagen.src = source;
  }

  if (cant_errores === 6) {
    id("resultado").innerHTML = "Perdiste, la palabra era " + palabrita;
    game_over();
  } else if (cant_aciertos === palabrita.length) {
    id("resultado").innerHTML = "Ganaste, anotaste el game winner  Mamba Forever";
    game_over();
  }
}

// Función para finalizar partida
function game_over() {
  for (let i = 0; i < btn_letras.length; i++) {
    btn_letras[i].disabled = true;
  }
  btn.disabled = false;
  clearInterval(intervalo);

  tiempoElem.style.display = "none";
}

// Temporizador
function actualizarTiempo() {
  tiempo--;
  tiempoElem.innerHTML = tiempo;

  // ⚠️ Efecto visual cuando queda poco tiempo
  if (tiempo <= 10) {
    tiempoElem.style.color = "red";
    tiempoElem.style.fontWeight = "bold";
  } else {
    tiempoElem.style.color = "white";
    tiempoElem.style.fontWeight = "normal";
  }

  if (tiempo <= 0) {
    id("resultado").innerHTML = "Se acabó el tiempo, la palabra era " + palabrita;
    game_over();
  }
}

// Mostrar pista
btn_pista.addEventListener("click", () => {
  pistaElem.innerHTML = "Pista: " + pistaActual; //  usamos la variable
  btn_pista.disabled = true; // solo una pista por partida
});

// Iniciar juego
btn.addEventListener("click", iniciar);

// 👉 Al inicio, desactivar letras
for (let i = 0; i < btn_letras.length; i++) {
  btn_letras[i].disabled = true;
}
btn.disabled = false;
