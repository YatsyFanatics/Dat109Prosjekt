package model.test;

import model.Bruker;
import model.Poengtabell;
import model.Yatzyspill;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

//Masse nullpointers så får ikke testa en dritt
public class SpillTest {

        Yatzyspill yatzyspill;
        Poengtabell poengtabell;
        Bruker Erik;
        Bruker Jorgen;
        Bruker Eivind;
        Bruker[] spillere = new Bruker[3];
    @BeforeEach
    public void reset(){

        Erik = new Bruker("Erik", "Erik", "ASD", "asd@asd.no", "123123123");
        Jorgen = new Bruker("Jorgen", "Jorgen", "ASD", "asdasd@sad.no", "321321321");
        Eivind = new Bruker("Eivind", "Eivind", "Sasd", "sadsad@sad.no", "123321123");
        spillere[0] = Erik;
        spillere[1] = Jorgen;
        spillere[2] = Eivind;
        yatzyspill = new Yatzyspill(1, Erik, spillere);
        poengtabell = new Poengtabell(3);
        yatzyspill.startSpill();
    }

    @Test
    public void spillSattopp(){

        assertEquals(Erik.getBrukernavn(),yatzyspill.getAdmin());
        assertEquals(yatzyspill.getSpillid(), 1);
        assertEquals(yatzyspill.getSpillerSinTur(), Eivind.getBrukernavn());
    }

    @Test
    public void testSpillrunde(){

    }

    @Test
    public void testVinner(){

        yatzyspill.setVinner(Erik);
        yatzyspill.regnUtVinner();
    }

    @Test
    public void testPurre(){}

    @Test
    public void testKick(){}
}
