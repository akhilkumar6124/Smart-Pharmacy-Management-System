<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy login</title>
</head>
<body>
    <h2>Login</h2>
    <form id="loginForm">
        Username: <input type="text" id="username"/><br/>
        password: <input type="password" id="password"/><br/>
        <button type="button" onclick="login()">Login</button>
    </form>
    <p id="error"></p>
    <script>
        function login(){
            fetch("http:localhost:4000/api/auth/login",{
                methid:"POST",
                headers: {"Content-Type": "application/json" },
                body: JSON.stringify({
                    username: username.value,
                    password: password.value
                })
            })
            .then(response => {
                if(!response.ok) throw "Invalid login";
                return response.json();
            })
            .then(user => {
                sessionStorage.setItem("user", JSON.stringify(user));
                window.location.href = "dashboard.jsp";
            })
            .catch(err => {
                document.getElementById("error").innerHTML = err;
            })
        }
    </script>
</body>
</html>