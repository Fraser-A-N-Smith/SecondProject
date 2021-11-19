'use strict'

let deletes = document.querySelector("#make-table");
console.log(deletes);
let delId = document.querySelector("#tableId")
console.log(delId);


let deleteRequest = (type) => {

    fetch(`http://localhost:9000/user/delete/${type}`, {
        method: `DELETE`
    }).then((response) => {
        if (response.status !== 204) {
            console.error(`Status : ${response.statusText}`);
            return;
        }
        //
        console.log("pingu is dead");
    })
}

deletes.addEventListener('click', () => {

    let delVal = delId.value;
    console.log("button clicked");
    console.log(delVal);
    deleteRequest(delVal)
})