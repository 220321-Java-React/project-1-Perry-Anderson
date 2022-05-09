const url = "http://localhost:3000"

document.getElementById("getReimbButton").addEventListener("click", getReimb);
document.getElementById("addReimbButton").addEventListener("click", addReimb);

function statusTranslate(statusInt){
    if (statusInt == 1 ){
        return "Pending";
    }else if (statusInt == 2){
        return "Approved"
    }else if (statusInt == 3){
        return "Denied"
    }else{
        return "error"
    }
}

function typeTranslate(typeInt){
    if (typeInt == 1 ){
        return "Vaccation";
    }else if (typeInt == 2){
        return "Travel"
    }else if (typeInt == 3){
        return "Other"
    }else{
        alert("error");
    }
}

function reverseTypeTranslate(typeString){
    if (typeString == "vaccation"){
        return 1;
    }else if(typeString == "travel"){
        return 2;
    }else if(typeString == "other"){
        return 3;
    }else{
        alert("error");
    }
}
async function getReimb() {

    let response = await fetch(url + "/admin/getReimb", {credentials: "include"});

    console.log(response);
   
    if(response.status === 200) { 
        let data = await response.json();
        console.log(data);
        
        for(let reimb of data){
        if (sessionStorage.getItem("user") == reimb.authorId){
            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = reimb.id
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3)

            let cell4 = document.createElement("td");
            cell4.innerHTML = statusTranslate(reimb.statusId);
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = typeTranslate(reimb.typeId)
            row.appendChild(cell5);
            
            document.getElementById("reimbBody").appendChild(row);

        }
    }
    } else {
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }
}

async function addReimb(){
    let reimbAmount = document.getElementById("reimbAmount").value
    let reimbDate = document.getElementById("reimbDate").value
    let reimbType = document.getElementById("reimbType").value
    
    let reimb = {
        amount: reimbAmount,
        submitted: reimbDate,
        authorId : parseInt(sessionStorage.getItem("user")),
        statusId: 1,
        typeId : reverseTypeTranslate(reimbType)
    }

    console.log(reimb)

    let response = await fetch(url + "/user/addReimb", {
        method: "POST",
        body: JSON.stringify(reimb),
        credentials: "include"
    });
   
    let data = await response.json();
  
}
