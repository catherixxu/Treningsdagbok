//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class ApparatOvelse extends Ovelse {
    private int id;
    private String navn;
    private int antallKilo;
    private int antallSett;
    private int apparatID;

    public ApparatOvelse(int id, String navn, int antallKilo, int antallSett, int apparatID) {
        super(id, navn);
        this.setAntallKilo(antallKilo);
        this.setAntallSett(antallSett);
        this.setApparatID(apparatID);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAntallKilo() {
        return this.antallKilo;
    }

    public void setAntallKilo(int antallKilo) {
        this.antallKilo = antallKilo;
    }

    public int getAntallSett() {
        return this.antallSett;
    }

    public void setAntallSett(int antallSett) {
        this.antallSett = antallSett;
    }

    public int getApparatID() {
        return this.apparatID;
    }

    public void setApparatID(int apparatID) {
        this.apparatID = apparatID;
    }
}
