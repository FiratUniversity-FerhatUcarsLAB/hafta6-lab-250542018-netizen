/*
 * Ad Soyad: Akın Ağaçbacak
 * Ogrenci No: 250542018
 * Tarih: 27/11/2025
 * Aciklama: Proje 3 - Akıllı Restoran Sipari¸s Sistemi
 *
 *kullanıcıdan alınan yemek ve içecek seçimlerine göre ara toplamı hesaplayan;
 *ardından sırasıyla Combo, Happy Hour ve kalan tutar üzerinden Öğrenci indirimini uygulayarak net hesabı ve bahşiş önerisini sunan bir restoran sipariş sistemidir.
 */

import java.util.Scanner;

public class Proje3_RestoranSiparis {

    public static double getMainDishPrice(int secim){

       switch (secim){
           case 1:
               return 85;
           case 2:
               return 120;
           case 3:
               return 110;
           case 4:
               return 65;
       }
        return 0;
    }

    public static double getAppetizerPrice(int secim){
        switch (secim){
            case 1:
                return 25;
            case 2:
                return 45;
            case 3:
                return 55;
        }
        return 0;
    }

    public static double getDrinkPrice(int secim){
        switch (secim){
            case 1:
                return 15;
            case 2:
                return 12;
            case 3:
                return 35;
            case 4:
                return 25;
        }
        return 0;
    }

    public static double getDesserPrice(int secim){
        switch (secim){
            case 1:
                return 65;
            case 2:
                return 55;
            case 3:
                return 35;
        }
        return 0;
    }

    public static boolean  isComboOrder(boolean anaVar, boolean icecekVar, boolean tatlıVar){
        return (anaVar && icecekVar && tatlıVar )? true : false ;
    }

    public static boolean ishappyHour(int saat){
        return (saat>=14 && saat<17)? true : false;
    }

    public static double calculateDiscount(double tutar , boolean combo, boolean ogrenci , int saat,int icecek, int gun){
        double toplamIndirim = 0;

        double comboTutari = (combo) ? tutar * 0.15 : 0;
        toplamIndirim += comboTutari;


        double happyHourTutari = (ishappyHour(saat)) ? getDrinkPrice(icecek) * 0.20 : 0;
        toplamIndirim += happyHourTutari;


        double kalanTutar = tutar - comboTutari - happyHourTutari;
        double ogrenciTutari = 0;

        if(ogrenci && gun != 6 && gun != 7) {
            ogrenciTutari = kalanTutar * 0.10;
        }
        toplamIndirim += ogrenciTutari;

        return toplamIndirim;
    }

    public static double calculateServiceTip(double tutar){
        return tutar*0.1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int anaYemek, baslangic, icecek, tatli, saat, gun;
        String ogrencimi;

        System.out.println("====================ŞİPARİŞ SİSTEMİ========================");

        System.out.print("Ana Yemek(1-4)         : ");
        anaYemek = input.nextInt();
        System.out.print("Baslangic(0-3)         : ");
        baslangic = input.nextInt();
        System.out.print("Icecek(0-4)            : ");
        icecek = input.nextInt();
        System.out.print("Talı(0-4)              :");
        tatli = input.nextInt();
        System.out.print("Saat(8-23)             :");
        saat = input.nextInt();
        System.out.print("Ogrenci misiniz? (E/H) :");
        ogrencimi = input.next();
        System.out.print("Hangi Gün(1-7)         :");
        gun = input.nextInt();

        // Bu hesaplar calculateDiscount içinde zaten yapıldı ama ekrana ayrı ayrı yazdırmak için buraya da ekledik.
        double araToplam=0 , indirim=0;
        araToplam = getAppetizerPrice(baslangic) + getMainDishPrice(anaYemek) + getDrinkPrice(icecek) + getDesserPrice(tatli);
        boolean isCombo = isComboOrder(anaYemek != 0, icecek != 0, tatli != 0);
        boolean isOgrenci = ogrencimi.equalsIgnoreCase("e")? true: false;
        indirim = calculateDiscount(araToplam,isCombo,isOgrenci,saat,icecek,gun);
        double toplam = araToplam - indirim;

        System.out.println("=======================HESAP ÖZETİ===========================");

        System.out.printf("Ara Toplam          : %.2f\n",araToplam);
        System.out.printf("Combo İndirim       : %d\n",(isCombo)? 15 : 0);
        System.out.printf("Happy Hour(İçecek)  : %d\n",(ishappyHour(saat))? 20 : 0);
        System.out.printf("Öğrenci İndirimi    : %d\n",(isOgrenci)? 10 : 0);
        System.out.printf("indirim tutarı      :-%.2f\n",indirim);
        System.out.println("------------------------------------------------\n");
        System.out.printf("Toplam              : %.2f\n",toplam);
        System.out.printf("Bahşiş Önerisi      : %.2f TL\n", calculateServiceTip(toplam));
    }
}
