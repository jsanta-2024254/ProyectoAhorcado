<%@page import="java.util.List"%>
<%@page import="modelo.Palabra"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Obtenemos la lista de palabras desde el request (enviada por el servlet)
    List<Palabra> listaPalabras = (List<Palabra>) request.getAttribute("listaPalabras");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Ahorcado Arcade Kobe Bryant Edition</title>
  <link rel="stylesheet" href="css/estilo.css" />
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
        <%-- Botones de letras --%>
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

  <!-- 🚀 Insertamos las palabras desde request en JavaScript -->
  <script>
    const palabras = [
    <% if (listaPalabras != null && !listaPalabras.isEmpty()) {
           for (int i = 0; i < listaPalabras.size(); i++) {
               Palabra p = listaPalabras.get(i);
               String coma = (i < listaPalabras.size() - 1) ? "," : "";
    %>
      { palabra: "<%= p.getPalabra() %>", pista: "<%= p.getPista() %>" }<%= coma %>
    <%     }
         } %>
    ];

    console.log("Palabras cargadas desde request:", palabras);

    if (!palabras || palabras.length === 0) {
        alert("No hay palabras disponibles en la base de datos");
    }
  </script>

  <!-- Script del juego -->
  <script src="js/script.js"></script>
</body>
</html>
