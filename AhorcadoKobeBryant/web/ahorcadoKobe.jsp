<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <!-- Fuente deportiva -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Carter+One&display=swap" rel="stylesheet" />
  
  <!-- Estilos -->
  <link rel="stylesheet" href="css/estilo.css" />
  <title>Ahorcado Arcade Kobe Bryant Edition</title>
</head>
<body>
  <header>
    <h1>Ahorcado edición Kobe Bryant</h1>
    <div class="marcador">
      <button id="jugar">Obtener palabra</button>
      <button id="pista">Mostrar pista</button>
      <div id="tiempo" class="tiempo">60</div>
    </div>
  </header>

  <main>

    <img id="imagen" src="Image/kobe0.png" alt="Ahorcado estilo Kobe Bryant" />

    <div class="panel">

      <p id="palabra_a_adivinar"></p>

   
      <p id="resultado"></p>

     
     <p id="texto_pista"></p>

      <div id="letras">
        <button>a</button>
        <button>b</button>
        <button>c</button>
        <button>d</button>
        <button>e</button>
        <button>f</button>
        <button>g</button>
        <button>h</button>
        <button>i</button>
        <button>j</button>
        <button>k</button>
        <button>l</button>
        <button>m</button>
        <button>n</button>
        <button>ñ</button>
        <button>o</button>
        <button>p</button>
        <button>q</button>
        <button>r</button>
        <button>s</button>
        <button>t</button>
        <button>u</button>
        <button>v</button>
        <button>w</button>
        <button>x</button>
        <button>y</button>
        <button>z</button>
      </div>
    </div>
  </main>
  <script src="js/script.js"></script>
</body>
</html>
