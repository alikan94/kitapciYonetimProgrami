package kitapciYonetimi;

import java.util.*;

public class Methodlar {

    static Scanner scan = new Scanner(System.in);
    static int kitapNo = 1000;

    public static void feykKitapEkle() {

        Kitap ktp = new Kitap(kitapNoOlusturucu(),"Cin Ali","Ali Kan",3);
        Kitap ktp1 = new Kitap(kitapNoOlusturucu(),"Cin Ali Tatilde","Ali Kan",4);
        Kitap ktp2 = new Kitap(kitapNoOlusturucu(),"Cin Ali Evde","Ali Kan",5);
        Kitap ktp3 = new Kitap(kitapNoOlusturucu(),"Cin Ali Java Kursunda","Ali Kan",3);
        Kitap ktp4 = new Kitap(kitapNoOlusturucu(),"Cin Ali Okulda","Ali Kan",7);

        Kitap.tumKitaplarMapi.put(ktp.getKitapNo(),ktp);
        Kitap.tumKitaplarMapi.put(ktp1.getKitapNo(),ktp1);
        Kitap.tumKitaplarMapi.put(ktp2.getKitapNo(),ktp2);
        Kitap.tumKitaplarMapi.put(ktp3.getKitapNo(),ktp3);
        Kitap.tumKitaplarMapi.put(ktp4.getKitapNo(),ktp4);

        System.out.println(Kitap.tumKitaplarMapi);

    }


    public static void kitapEkle() {

        System.out.println("Kitap ekle menusu");
        int kitapNo = kitapNoOlusturucu();
        System.out.println("Kitap adini gir");
        String kitabinIsmi = scan.nextLine();
        System.out.println("Yazar ekle");
        String yazarIsmi = scan.nextLine();
        System.out.println("Fiyat ekle");
        double kitapFiyati = scan.nextDouble();

        Kitap ktp = new Kitap(kitapNo,kitabinIsmi,yazarIsmi,kitapFiyati);

        Kitap.tumKitaplarMapi.put(ktp.getKitapNo(),ktp);

    }

    private static int kitapNoOlusturucu() {

        return kitapNo++;
    }

    public static void noIleKitapBulYazdir() {

        // kitapobjesi > adamdan no al > tüm listede arat (aratmak için list lazim)> value list oluştur >
        // > döngü > equals (girilen no) > yazdir


        System.out.println("no gir");
        int aranacakNo = scan.nextInt();
        scan.nextLine();
        Kitap arancakKitap= new Kitap();

        Set<Map.Entry<Integer,Kitap>> tumKitaplarEntrySet = Kitap.tumKitaplarMapi.entrySet();
        List<Integer> tumKitaplarKeyList = new ArrayList<>();
        List<Kitap> tumKitaplarValueList = new ArrayList<>();

        // 1001=kitap 1002=kitap

        for (Map.Entry<Integer,Kitap> each: tumKitaplarEntrySet
             ) {
            tumKitaplarKeyList.add(each.getKey());
            tumKitaplarValueList.add(each.getValue());
        }

        boolean flag = false;
        for (int i = 0; i < tumKitaplarKeyList.size(); i++) {

            if (tumKitaplarKeyList.get(i)==aranacakNo){
                arancakKitap = tumKitaplarValueList.get(i);
                flag= false;
                break;
            } else flag= true;

        }
        if (flag){
            System.out.println(aranacakNo + " numarali kitap yok");
        } else {
            System.out.println("Aradıgın Kitap = " + arancakKitap);
        }

    }

    public static void bilgiIleKitapBulYazdir() {

        // kitapobjesi > isim mi, yazar mı> adamdan isim al > tüm listede arat (aratmak için list lazim)> value list oluştur >
        // > döngü > equals (girilen no) > yazdir

        System.out.println("Kitap ismi gir");
        String aranacakKitap = scan.nextLine();
        Kitap bulunanKitap= new Kitap();

        Set<Map.Entry<Integer,Kitap>> tumKitaplarEntrySet = Kitap.tumKitaplarMapi.entrySet();
        List<Integer> tumKitaplarKeyList = new ArrayList<>();
        List<Kitap> tumKitaplarValueList = new ArrayList<>();

        for (Map.Entry<Integer,Kitap> each: tumKitaplarEntrySet
        ) {
            tumKitaplarKeyList.add(each.getKey());
            tumKitaplarValueList.add(each.getValue());
        }

        // 1001=kitap 1002=kitar
        boolean flag = false;
        for (int i = 0; i < tumKitaplarValueList.size(); i++) {
            if (tumKitaplarValueList.get(i).getIsim().equals(aranacakKitap)){
                bulunanKitap=tumKitaplarValueList.get(i);
                flag=false;
                break;
            } else flag=true;
        }
        if (flag){
            System.out.println(aranacakKitap + " isimli kitap yok");
        } else {
            System.out.println("Aradıgın Kitap Bilgileri= " + bulunanKitap);
        }
    }

    public static void noIleKitapSil() {

        // listeyi yazdir > no al adamdan > keyset > döngü > eşleşirse sil

        tumKitaplariListeIleYazdir();

        System.out.println("Silinecek no gir");
        int silinecekNo = scan.nextInt();
        scan.nextLine();
        Kitap silinecekKitap= new Kitap();

        Set<Map.Entry<Integer,Kitap>> tumKitaplarEntrySet = Kitap.tumKitaplarMapi.entrySet();
        List<Integer> tumKitaplarKeyList = new ArrayList<>();
        List<Kitap> tumKitaplarValueList = new ArrayList<>();

        for (Map.Entry<Integer,Kitap> each: tumKitaplarEntrySet
        ) {
            tumKitaplarKeyList.add(each.getKey());
            tumKitaplarValueList.add(each.getValue());
        }

        boolean flag = false;
        for (int i = 0; i < tumKitaplarKeyList.size(); i++) {

            if (tumKitaplarKeyList.get(i)==silinecekNo){
                silinecekKitap = tumKitaplarValueList.get(i);
                flag= false;
                break;
            } else flag= true;

        }
        if (flag){
            System.out.println(silinecekNo + " numarali kitap yok");
        } else {
            System.out.println("Silinecek Kitap = " + silinecekKitap);
            System.out.println("Silinecek Kitap = " + Kitap.tumKitaplarMapi.remove(silinecekNo));

        }



    }

    public static void tumKitaplariListeIleYazdir() {

        Set<Map.Entry<Integer,Kitap>> tumKitaplarEntrySet = Kitap.tumKitaplarMapi.entrySet();
        List<Integer> tumKitaplarKeyList = new ArrayList<>();
        List<Kitap> tumKitaplarValueList = new ArrayList<>();

        for (Map.Entry<Integer,Kitap> each: tumKitaplarEntrySet
        ) {
            tumKitaplarKeyList.add(each.getKey());
            tumKitaplarValueList.add(each.getValue());
        }

        System.out.printf("%-6s%-25s%-20s%-6s\n","No","Kitap ismi", "Yazar", "Fiyat");

        for (int i = 0; i < tumKitaplarValueList.size(); i++) {
            System.out.printf("%-6d%-25s%-20s%-6s\n",tumKitaplarKeyList.get(i),tumKitaplarValueList.get(i).getIsim(),
                    tumKitaplarValueList.get(i).getYazar(), tumKitaplarValueList.get(i).getFiyat());

        }
    }

    public static void cikis() {

        System.out.println("Gule gule...");
        System.out.println("Bagi koparmayalim...");
    }
}
