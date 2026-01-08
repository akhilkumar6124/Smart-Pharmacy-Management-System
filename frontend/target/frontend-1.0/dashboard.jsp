<%@ page language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <h2>Dashboard</h2>
    <a href="#" onclick="logout()">Logout</a>
    <script>
        let user = sessionStorage.getItem("user");
        if (user.role.name === "ADMIN") {
            document.write("<p>Admin Controls Enabled</p>");
        }
        if(!user){
            window.location.href="login.jsp";
        }else{
            user = JSON.parse(user);
            document.write("<p>Welcome,"+user.fullName+"</p>");
            document.write("<p>Role; "+user.role.name+"</p>");
        }
        function logout() {
            sessionStorage.clear();
            window.location.href = "login.jsp";
        }
    </script>
    <ul>
        <li><a href="#">Medicine Management</a></li>
        <li><a href="#">Prescription</a></li>
        <li><a href="#">Billing</a></li>
    </ul>
</body>
</html>