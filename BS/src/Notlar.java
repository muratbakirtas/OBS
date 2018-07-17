import java.util.ArrayList;

public class Notlar {

    private int ogrID;
    private int dersID;

    private Double vizeler  ;

    private Double fnal;
    private Double ort;

    public Notlar(int dersID,int ogrID){
        this.dersID=dersID;
        this.ogrID=ogrID;
    }

    public int getOgrID() {
        return ogrID;
    }

    public int getDersID() {
        return dersID;
    }

    public void setOgrID(int ogrID) {
        this.ogrID = ogrID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public Double getVizeler() {
        return vizeler;
    }

    public void setVizeler(Double vizeler) {
        this.vizeler = vizeler;
    }

    public Double getFnal() {
        return fnal;
    }

    public void setFnal(Double fnal) {
        this.fnal = fnal;
    }

    public Double getOrt() {
        return ort;
    }

    public void setOrt(Double ort) {
        this.ort = ort;
    }
}
