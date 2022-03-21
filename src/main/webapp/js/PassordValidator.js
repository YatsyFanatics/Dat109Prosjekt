export default class PassordValidator {


    event;
    constructor(event) {
        this.event = event;
        this.sjekkPassordStyrke = this.sjekkPassordStyrke.bind(this);
        this.sjekkPassordErLik = this.sjekkPassordErLik.bind(this);
        this.sjekkPassordStyrke(this.event);
        this.sjekkPassordErLik(this.event);
    }


    sjekkPassordStyrke(event) {
        const validity = event.validity;
        const event2 = document.getElementById("passordRepetert");

        event.addEventListener("input", (e) => {
            if (validity.valid) {
                if (event.value != event2.value) {
                    event2.setCustomValidity("Repetert passord er feil!");
                } else {
                    event2.setCustomValidity("");
                }
                if (event.value.length < 14) {
                    event.className = "mediumPassword";
                } else {
                    event.className = "Password";
                }
            } else {
                event2.setCustomValidity("repeter passord");
                event.className = "password";
            };
        });

    }

    sjekkPassordErLik(event) {
        const event2 = document.getElementById("passordRepetert");
        const validity2 = event.validity;

        event2.addEventListener("input", (e) => {
            if (validity2.valid) {
                if (event.value != event2.value) {
                    event2.setCustomValidity("Repetert passord er feil!");
                } else {
                    event2.setCustomValidity("");
                }
            } else {
                event2.setCustomValidity("repeter passord");
            };
        });

    }


}
