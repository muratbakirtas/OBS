public class DersAlanOgrenciler {

    private int ogrID;
    private int dersID;


    public DersAlanOgrenciler(int ogrID,int dersID){
        this.dersID=dersID;
        this.ogrID=ogrID;
    }

    public DersAlanOgrenciler() {

    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public int getDersID() {
        return dersID;
    }

    public void setOgrID(int ogrID) {
        this.ogrID = ogrID;
    }

    public int getOgrID() {
        return ogrID;
    }
}
