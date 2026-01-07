<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>prescription</title>
</head>
<body>
    <h2>Create Prescription</h2>
    <button onclick="createPrescription()">Create Prescription</button>
    <a href="#" onclick="logout()">Logout</a>

    <script>
        function createPrescription(){
            fetch("http:localhost:4002/api/prescription",{
                method: "POST",
                headers: {"Content-Type" : "application/json" },
                body: JSON.stringify({
                    customerId: 1,
                    prescribedBy: "Dr.Mani"
                })
            })
            .then(response => response.json())
            .then(data => {
                alert("Prescription ID: " + data.id);
                sessionStorage.setItem("prescriptionId", data,id);
            });
        }
        function logout() {
            sessionStorage.clear();
            window.location.href = "login.jsp";
        }
    </script>
</body>
</html>