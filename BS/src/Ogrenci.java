import java.util.ArrayList;

public class Ogrenci {
    private String ogrAdi;
    private int ogrİd;
    private String ogrCinsiyet;




    public Ogrenci(int ogrİd,String ogrAdi,String ogrCinsiyet){
        this.ogrİd=ogrİd;
        this.ogrAdi=ogrAdi;
        this.ogrCinsiyet=ogrCinsiyet;

        }

    public Ogrenci() {


    }

    public int getOgrİd() {
        return ogrİd;
    }

    public String getOgrAdi() {
        return ogrAdi;
    }

    public String getOgrCinsiyet() {
        return ogrCinsiyet;
    }

    public void setOgrAdi(String ogrAdi) {
        this.ogrAdi = ogrAdi;
    }

    public void setOgrCinsiyet(String ogrCinsiyet) {
        this.ogrCinsiyet = ogrCinsiyet;
    }

    public void setOgrİd(int ogrİd) {
        this.ogrİd = ogrİd;
    }



}
