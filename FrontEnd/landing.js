const url = "http://localhost:3000";


document.getElementById("loginButton").addEventListener("click", loginFunction);



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

   // console.log(response.status);
   console.log("HI");
  
    let data = await response.json();
    window.sessionStorage.setItem("user", data.userId);
  
    if(response.status === 202 && sessionStorage.getItem("user") == 1){
        window.location.href = "http://127.0.0.1:5500/project-1-Perry-Anderson/FrontEnd/admin.html";
    }else if (response.status == 202){
        window.location.href = "http://127.0.0.1:5500/project-1-Perry-Anderson/FrontEnd/user.html";
    }else{
        document.getElementById("loginRow").innerText="Login Failed Refresh the Page";
    }
}

