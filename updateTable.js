'use strict'

let tableNumber = document.querySelector("#table-id");
console.log(tableNumber);
let partyName = document.querySelector("#party-name");
console.log(partyName);
let partyTab = document.querySelector("#party-tab");
console.log(partyTab);
let mageBool = document.querySelector("#mage")
console.log(mageBool);
let submitChange = document.querySelector("#make-order")

let postData = (id, party, Tab, mage) => {

    let newObject = {
        "id": id,

        "partyName": party,

        "partyTab": Tab,
        "hasMagic": mage
    };


    postFetch(newObject, id);

    return newObject
};

let postFetch = (object, id) => {
    fetch(`http://localhost:9000/user/update/${id}`, {
        method: "PUT", // We are specifying we are POSTing data
        headers: {
            "Content-type": "application/JSON", // Telling the server we are sending JSON
        },
        body: JSON.stringify(object), // We will be creating an object and passing it in here
    }).then((response) => {
        if (response.status !== 201) {
            console.error(`Status: ${response.status}`);
            return;
        }
        console.log(response);
    });
};

submitChange.addEventListener('click', () => {
    let idVal = tableNumber.value;
    console.log(idVal);
    let partyVal = partyName.value;
    console.log(partyVal);
    let partyTabVal = partyTab.value;
    console.log(partyTabVal);
    let mageVal = mageBool.value;
    console.log(mageVal);
    postData(idVal, partyVal, partyTabVal, mageVal)
})