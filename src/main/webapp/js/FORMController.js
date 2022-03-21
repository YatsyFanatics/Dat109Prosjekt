

import PassordValidator from "./PassordValidator.js";
class FORMController {
    id;

    constructor(id) {

        this.id = id;
        this.run = this.run.bind(this);

    }
    run() {

        const btRef = document.getElementById(this.id);
        this.PassordValidator = new PassordValidator(btRef);
    }
}
let passord = new FORMController("passord");

document.addEventListener("DOMContentLoaded", passord.run, true); 
