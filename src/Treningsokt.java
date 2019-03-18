//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Date;

public class Treningsokt {
    private Date dato;
    private String tidspunkt;
    private int varighet;
    private int prestasjon;
    private int form;
    private String notat;

    public Treningsokt(Date dato, String tidspunkt, int varighet, int form, int prestasjon, String notat) {
        this.setDato(dato);
        this.setTidspunkt(tidspunkt);
        this.setVarighet(varighet);
        this.setForm(form);
        this.setPrestasjon(prestasjon);
        this.setNotat(notat);
    }

    public Date getDato() {
        return this.dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getTidspunkt() {
        return this.tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public int getVarighet() {
        return this.varighet;
    }

    public void setVarighet(int varighet) {
        this.varighet = varighet;
    }

    public int getForm() {
        return this.form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public int getPrestasjon() {
        return this.prestasjon;
    }

    public void setPrestasjon(int prestasjon) {
        this.prestasjon = prestasjon;
    }

    public String getNotat() {
        return this.notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }
}
