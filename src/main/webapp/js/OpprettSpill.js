"use strict";

class OpprettSpill{
    
    constructor(rootEl) {
        this.root = rootEl;
        this.leggTilSpiller = this.leggTilSpiller.bind(this);
        const buttonEl = this.root.getElementsByTagName("button")[0];
        buttonEl.addEventListener("click", this.leggTilSpiller);
    }
    
    leggTilSpiller(){
    tabell = document.getElementsByTagName("tabell").item(0);
    rad = document.createElement("tr");
    kol = document.createElement("td");
    textnode = document.createTextNode(document.getElementById("inputId").nodeValue);
    kol.appendChild(textnode);
    rad.appendChild(kol);
    tabell.appendChild(rad);       
    }  
}

//function leggTilSpiller(){
//    tabell = document.getElementsByTagName("tabell").item(0);
//    rad = document.createElement("tr");
//    kol = document.createElement("td");
//    textnode = document.createTextNode(document.getElementById("inputId").nodeValue);
//    kol.appendChild(textnode);
//    rad.appendChild(kol);
//    tabell.appendChild(rad);       
//    }  

function init() {
    const rootElm =  document.getElementById("root");
    new FORMController(rootElm);
}
    
document.addEventListener('DOMContentLoaded',init);