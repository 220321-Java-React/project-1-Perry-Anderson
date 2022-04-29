const url = "http://localhost:3000";

document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);
document.getElementById("loginButton").addEventListener("click", loginFunction);

async function getEmployees(){
    let response = await fetch(url + "/employees");
    console.log(response);
    
    if(response.status === 200){
        let data = await response.json();
        console.log(data);
        for(let employee of data){
            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = employee.employee_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = employee.first_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = employee.last_name;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = employee.role.role_title;
            row.appendChild(cell4);

            document.getElementById("employeeBody").appendChild(row);
        }

    }else{
        alert("Failure on getEmployees Request");
    }

}

async function loginFunction(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    
    let user = {
        username:usern,
        password:userp
    }
    

    let response = await fetch(url + "/login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(response.status);
  
    let data = await response.json();
    console.log(data);
    if(response.status === 202){
        window.location.href = "http://127.0.0.1:5500/project-1-Perry-Anderson/FrontEnd/admin.html";
    }else{
        document.getElementById("loginRow").innerText="Login Failed Refresh the Page";
    }
}

