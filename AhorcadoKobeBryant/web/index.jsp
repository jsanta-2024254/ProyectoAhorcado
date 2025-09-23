<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login - Ahorcado Kobe</title>
    <link rel="stylesheet" href="./css/estilo.css">
</head>
<body class="login-body">
    <div class="login-container">
        <h2>Iniciar Sesión</h2>
        
        <!-- Mensaje de error dinámico -->
        <p class="error">${mensajeError}</p>
        
        <!-- Formulario al servlet -->
        <form action="Validacion" method="post">
            <input type="text" name="usuario" placeholder="Usuario" required>
            <input type="password" name="clave" placeholder="Contraseña" required>
            <button type="submit">Ingresar</button>
        </form>
    </div>
</body>
</html>
