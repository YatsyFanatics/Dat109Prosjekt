"use strict";

class OpprettSpill{
//    tabell;
//    rad;
//    kol;
//    textnode;
    
    constructor(rootEl) {
        this.root = rootEl;
        this.leggTilSpiller = this.leggTilSpiller.bind(this);
        const buttonEl = this.root.getElementsByTagName("button")[0];
        buttonEl.addEventListener("click", this.leggTilSpiller);
    }
    
    leggTilSpiller(){
        console.log("fant den");
        let tabell = document.getElementById("tabell");
/*        let input = document.getElementById("inputId").innerHTML;*/
        let textnode = document.createTextNode(document.getElementById("inputId").childNodes[0].textContent);
        let nyRad = tabell.insertRow();
        let nyKol = nyRad.insertCell();
        nyKol.appendChild(textnode);   
    }  
}

//function leggTilSpiller(){
//    console.log("fant den");
//    let tabell = document.getElementById("tabell");
///*    tabell = document.getElementsByTagName("tabell").item(0);*/
//    let rad = document.createElement("tr");
//    let kol = document.createElement("td");
//    let textnode = document.createTextNode(document.getElementById("inputId").nodeValue);
//    kol.appendChild(textnode);
//    rad.appendChild(kol);
//    tabell.appendChild(rad);       
//    }  

function init() {
    const rootElm =  document.getElementById("root");
    new OpprettSpill(rootElm);
}
    
document.addEventListener('DOMContentLoaded',init);