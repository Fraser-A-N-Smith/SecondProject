'use strict'

let orderId = document.querySelector("#order-id");
console.log(orderId);
let foodOrder = document.querySelector("#food-order");
console.log(foodOrder);
let drinkOrder = document.querySelector("#drink-order");
console.log(drinkOrder);
let tableNumber = document.querySelector("#table-number");
console.log(tableNumber);
let partyId = document.querySelector("#party-id");
console.log(partyId);
let submitChange = document.querySelector("#make-order")
console.log(submitChange);

let postData = (id1, food, drink, table, party) => {

    let newObject = {
        "drinkId": drink,

        "foodId": food,

        "tableId": table,
        "tabTavId": party
    };


    postFetch(newObject, id1);

    return newObject
};

let postFetch = (object, id) => {
    fetch(`http://localhost:9000/order/update/${id}`, {
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
    let idVal = orderId.value;
    console.log(idVal);
    let foodVal = foodOrder.value;
    console.log(foodVal);
    let drinkVal = drinkOrder.value;
    console.log(drinkVal);
    let tableVal = tableNumber.value;
    console.log(tableVal);
    let partyVal = partyId.value;
    console.log(partyVal);
    postData(idVal, foodVal, drinkVal, tableVal, partyVal)
})