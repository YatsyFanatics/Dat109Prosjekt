"use strict";

class OpprettSpill{
    tabell;
    rad;
    kol;
    textnode;
    
    constructor(rootEl) {
        this.root = rootEl;
        this.leggTilSpiller = this.leggTilSpiller.bind(this);
        const buttonEl = this.root.getElementsByTagName("button")[0];
        buttonEl.addEventListener("click", this.leggTilSpiller);
    }
    
    leggTilSpiller(){
    this.tabell = document.getElementsByTagName("tabell").item(0);
    this.rad = document.createElement("tr");
    this.kol = document.createElement("td");
    this.textnode = document.createTextNode(document.getElementById("inputId").nodeValue);
    this.kol.appendChild(textnode);
    this.rad.appendChild(kol);
    this.tabell.appendChild(rad);       
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
    new OpprettSpill(rootElm);
}
    
document.addEventListener('DOMContentLoaded',init);