import java.util.ArrayList;


public class Ders {
    private int id;
    private String name;
    private ArrayList<Ogrenci> ogrenciList;
    private int ogrenciID;


    public Ders(int id, String name) {
        this.id = id;
        this.name = name;
        this.ogrenciList = new ArrayList<>();

    }

    public Ders() {
        this.ogrenciList = new ArrayList<>();


    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void ogrenciEkle(Ogrenci o){ this.ogrenciList.add(o);}
    public void ogrenciSil(Ogrenci o) { this.ogrenciList.remove(o);}
    public void ogrenciListesiGor() {
        for (int x=0; x<ogrenciList.size();x++)
        System.out.println(ogrenciList.get(x).getOgrİd()+"-"+ogrenciList.get(x).getOgrAdi());}

    public ArrayList<Ogrenci> getOgrenciList() {
        return ogrenciList;
    }

    public void setOgrenciList(ArrayList<Ogrenci> ogrenciList) {
        this.ogrenciList = ogrenciList;
    }

    public void setOgrenciID(int ogrenciID) {
        this.ogrenciID = ogrenciID;
    }

    public int getOgrenciID() {
        return ogrenciID;
    }
}




