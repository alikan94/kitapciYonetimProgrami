package kitapciYonetimi;

import java.util.HashMap;
import java.util.Map;

public class Kitap {
    private int kitapNo;
    private String isim;
    private String yazar;
    private double fiyat;

    static Map<Integer,Kitap> tumKitaplarMapi = new HashMap<>();

    public Kitap() {
    }

    public Kitap(int kitapNo, String isim, String yazar, double fiyat) {
        this.kitapNo = kitapNo;
        this.isim = isim;
        this.yazar = yazar;
        this.fiyat = fiyat;
    }

    public int getKitapNo() {
        return kitapNo;
    }

    public void setKitapNo(int kitapNo) {
        this.kitapNo = kitapNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "kitapNo=" + kitapNo +
                ", isim='" + isim + '\'' +
                ", yazar='" + yazar + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
