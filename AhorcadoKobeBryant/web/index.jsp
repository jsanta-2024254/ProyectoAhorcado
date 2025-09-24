<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Ahorcado Kobe</title>
    <link rel="stylesheet" href="./css/estilo.css"> 
</head>
<body>
    <div class="box">
        <div class="container">
            <div class="top-header">
                <span> Login - Kobe ahorcado legacy edition</span>
                <header>Iniciar Sesión</header>
            </div>

            <!-- Mensaje de error dinámico -->
            <p class="error">${mensajeError}</p>

            <!-- FORMULARIO -->
            <form action="Validar" method="post">
                <div class="input-field">
                    <input type="text" name="user_name" class="input" placeholder="Usuario" required>
                    <i class="bx bx-user"></i>
                </div>
                <div class="input-field">
                    <input type="password" name="user_password" class="input" placeholder="Contraseña" required>
                    <i class="bx bx-lock-alt"></i>
                </div>
                <div class="input-field">
                    <input type="submit" class="submit" value="Ingresar">
                </div>

                <div class="bottom">
                    <div class="left">
                        <input type="checkbox" id="check">
                        <label for="check"> Recordarme</label>
                    </div>
                    <div class="right">
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
