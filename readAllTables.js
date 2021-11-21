'use strict';

// creating getAll

let parentDiv = document.querySelector('#parentDiv');
let getOrders = document.querySelector('#get-orders');

console.log(parentDiv);
console.log(getOrders);

let createCard = (obj) => {
    let newCard = document.createElement('div');
    let newCardBody = document.createElement('div');
    let newTitle = document.createElement('h4');
    let newText = document.createElement('p');

    newCard.classList = "card";
    newCardBody.classList = "card-body";
    newTitle.classList = "card-title";
    newText.classList = "card-text";

    newTitle.textContent = `Table : ${obj.id}`;
    newText.textContent = `Party Name : ${obj.partyName} , Party Tab : ${obj.partyTab} , Has Mage : ${obj.hasMagic}`;

    newCardBody.appendChild(newTitle);
    newCardBody.appendChild(newText);
    newCard.appendChild(newCardBody);
    parentDiv.appendChild(newCard);

}

let getAll = () => {

    fetch(`http://localhost:9000/user/readAll`).then((response) => {
        if (response.status !== 200) {
            console.error(`status : ${response.status}`);
            return;
        }
        response.json().then((data) => {
            for (let obj of data) {
                console.log(obj);
                createCard(obj);
            }
        }).catch((error) => {
            console.error(`${error}`);
        })
    })
}

getOrders.addEventListener('click', getAll);