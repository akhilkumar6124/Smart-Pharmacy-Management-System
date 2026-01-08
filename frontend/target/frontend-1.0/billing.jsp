<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Billing</title>
</head>
<body>
    <h2>Generate Bill</h2>
    <button onclick="generateBill()">Generate</button>
    <p id="result"></p>
    <a href="#" onclick="logout()">Logout</a>

    <script>
        function generateBill(){
            let prescriptionId = sessionStorage.getItem("prescriptionId")
            fetch(`http://localhost:4003/api/bills/${prescriptionId}`,{
                method: "POST"
            })
            .then(response => response.json())
            .then(bill => {
                document.getElementById("result").innerHTML = "Total Amount: $"+bill.totalAmount;
            });
        }
        function logout() {
            sessionStorage.clear();
            window.location.href = "login.jsp";
        }
    </script>
</body>
</html>