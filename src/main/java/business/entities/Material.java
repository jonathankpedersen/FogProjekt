package business.entities;

public class Material {
    int materiale_Id;
    String navn;
    String enhed;
    double pris_pr_enhed;
    String description;

    //Sæt længder ind på materialer

    public Material(int materiale_Id, String navn, String enhed, double pris_pr_enhed, String description) {
        this.materiale_Id = materiale_Id;
        this.navn = navn;
        this.enhed = enhed;
        this.pris_pr_enhed = pris_pr_enhed;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMateriale_Id() {
        return materiale_Id;
    }

    public void setMateriale_Id(int materiale_Id) {
        this.materiale_Id = materiale_Id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEnhed() {
        return enhed;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }

    public double getPris_pr_enhed() {
        return pris_pr_enhed;
    }

    public void setPris_pr_enhed(double pris_pr_enhed) {
        this.pris_pr_enhed = pris_pr_enhed;
    }
}
