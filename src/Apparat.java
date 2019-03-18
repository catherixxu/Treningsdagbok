//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public class Apparat {
    private int id;
    private String navn;
    private String beskrivelse;

    public Apparat(int id, String navn, String beskrivelse) {
        this.setId(id);
        this.setNavn(navn);
        this.setBeskrivelse(beskrivelse);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse() {
        return this.beskrivelse;
    }
}
