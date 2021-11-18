'use strict';

let updateBttn = document.querySelector('#make-order');
let updateDrink = document.querySelector('#drink-order');
let updateFood = document.querySelector('#food-order');
let tabelNo = document.querySelector('#table-number');
let partyId = document.querySelector('party-id');


let postData = (food, drink, table, party) => {

    let newObject = {
        "drinkId": drink,
        "foodId": food,
        "tableId": table,
        "tavTabId": party
    };

    postFetch(newObject);

    return newObject
};

let postFetch = (object) => {
    fetch("http://localhost:8083/createPenguin", {
        method: "POST",
        headers: {
            "Content-type": "application/JSON",
        },
        body: JSON.stringify(object),
    }).then((response) => {
        if (response.status !== 201) {
            console.error(`Status: ${response.status}`);
            return;
        }
        console.log(response);
    })
}

updateBttn.addEventListener('click', () => {
    let drinkVal = updateDrink.value;
    let foodVal = updateFood.value;
    let tableNumber = tabelNo.value;
    let partyIdNo = partyId.value;
    postData(foodVal, drinkVal, tableNumber, partyIdNo)
})