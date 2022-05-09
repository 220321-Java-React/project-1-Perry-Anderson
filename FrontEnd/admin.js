const url = "http://localhost:3000"

document.getElementById("getReimbButton").addEventListener("click", getReimb);

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
        return "error"
    }
}
async function getReimb() {

    let response = await fetch(url + "/admin/getReimb", {credentials: "include"});

    console.log(response);
   
    if(response.status === 200) { 
        let data = await response.json();
        console.log(data);
        
        for(let reimb of data){
           
            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = reimb.id
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.amount
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimb.authorId
             row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = statusTranslate(reimb.statusId);
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = typeTranslate(reimb.typeId)
            row.appendChild(cell6);
            
            document.getElementById("reimbBody").appendChild(row);

        }
   

    } else {
        alert("uh oh your session is inactive. Maybe not logged in? :/");
    }


}
