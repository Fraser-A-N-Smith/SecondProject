'use strict';

let inputBttn = document.querySelector("#submit");
console.log(inputBttn);
let prtyNm = document.querySelector("#party-name");
console.log(prtyNm);
let prtyTab = document.querySelector("#party-tab");
console.log(prtyTab);
let prtyMagic = document.querySelector("#mage");
console.log(prtyMagic);

let postData = (partyName1, partyTab1, hasMagic1) => {

    let newObj = {
        partyName: partyName1,
        partyTab: partyTab1,
        hasMagic: hasMagic1
    };

    postFetch(newObj);

    return newObj
}

let postFetch = (newObj) => {
    fetch("http://localhost:9000/user/create", {
        method: "POST",
        headers: {
            "Content-type": "application/JSON",
        },
        body: JSON.stringify(newObj),
    }).then((response) => {
        if (response.status !== 201) {
            console.error(`Status : ${response.status}`);
            return;
        }
        console.log(response);
    });
};

inputBttn.addEventListener('click', () => {
    let ptName = prtyNm.value;
    let ptTab = prtyTab.value;
    let mageYN = prtyMagic.value;
    postData(ptName, ptTab, mageYN);
})