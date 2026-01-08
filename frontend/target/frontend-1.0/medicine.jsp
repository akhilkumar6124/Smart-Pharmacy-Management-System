<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medicine Management</title>
</head>
<body>
    <h2>Medicines</h2>
    <input type="text" id="search" placeholder="Search medicine"/>
    <button onclick=search()>Search</button>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody id="medicineTable"></tbody>
    </table>
    <a href="#" onclick="logout()">Logout</a>

    <script>
        function loadMedicine() {
            fetch("http:localhost:4001/api/medicines")
                .then(response => response.json())
                .then(data => {
                    let rows = "";
                    data.forEach(m => {
                        rows += `<tr>
                            <td>${m.name}</td>
                            <td>${m.category}</td>
                            <td>${m.price}</td>
                            <td>${m.quantity}</td>
                        </tr>`;
                    })
                    document.getElementById("medicineTable").innerHTML = rows;
                });
        }
        function search(){
            let q = document.getElementById("search").value;
            fetch(`http:localhost:4001/api/medicines/search?q=${q}`)
                .then(response => response.json())
                .then(loadmedicines);
        }
        function logout() {
            sessionStorage.clear();
            window.location.href = "login.jsp";
        }
        loadMedicine();
    </script>
</body>
</html>