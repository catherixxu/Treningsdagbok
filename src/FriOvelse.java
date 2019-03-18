//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class FriOvelse extends Ovelse {
    private int id;
    private String navn;
    private String beskrivelse;

    public FriOvelse(int id, String navn, String beskrivelse) {
        super(id, navn);
        this.setBeskrivelse(beskrivelse);
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

    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
