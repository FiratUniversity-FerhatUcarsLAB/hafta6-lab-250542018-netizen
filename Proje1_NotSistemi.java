/*
 * Ad Soyad: Akın Ağaçbacak
 * Ogrenci No: 250542018
 * Tarih: 24/11/2025
 * Aciklama: Proje 1 - Ogrenci Not Degerlendirme Sistem
 *
 * Bu Program öğrenciden alınan vize, final ve ödev notlarının ortalamasını bulur
 * ve öğrencinin durumunu detaylı bir şekilde yazdırır.
 */

import java.util.Scanner;

public class Proje1_NotSistemi {

    //Ortalama hesaplayan metot
    public static double calculateAverage(int vize_notu ,int final_notu,int odev_notu){
        return vize_notu*0.3+final_notu*0.4+odev_notu*0.3;
    }

    //Geçme Durumunuzu kontrol eden metot
    public static boolean isPassingGrade(double ortalama){
        return (ortalama>=50) ? true : false;
    }

    //Notunuzu Harf olarak bulan metot
    public static char getLetterGrade(double ortalama){
        if(90<=ortalama && ortalama<=100)
            return 'A';
        else if(80<=ortalama && ortalama<=89)
            return 'B';
        else if(70<=ortalama && ortalama<=79)
            return 'C';
        else if(60<=ortalama && ortalama<=69)
            return 'D';
        else
            return 'F';
    }

    //Onur listesine girip girmediğinizi kontrol eden metot
    public static boolean isHonorList(double ortalama,int vize_notu,int final_notu,int odev_notu){
        return  (ortalama>=85 && vize_notu>70 && final_notu>70 && odev_notu>70) ? true : false;
    }

    //Bütünlemeye Kalma Hakkınızın olup olmadığını söyleyen metot
    public static boolean hasRetakeRight(double ortalama){
        return (ortalama >= 40 && ortalama < 50) ? true : false;
    }


    //İşlemlerimizin Gerçekleştiği main metot
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===OGRENCI NOT RAPORU===");

        System.out.print("Vize Notunuzu Giriniz: ");
        int vize_notu = input.nextInt();
        System.out.print("Final Notunuzu Giriniz: ");
        int final_notu = input.nextInt();
        System.out.print("Ödev notunuzu Giriniz: ");
        int odev_notu = input.nextInt();

        double avarage= calculateAverage(vize_notu,final_notu,odev_notu);

        System.out.print("----------------------------------------------\n");

        System.out.printf("Ortalama     : %.2f\n",avarage);
        System.out.printf("Harf Notu    : %c\n",getLetterGrade(avarage));
        System.out.printf("Durum        : %s\n", isPassingGrade(avarage) ? "GECTİ" : "KALDI");
        System.out.printf("Onur Listesi : %s\n",hasRetakeRight(avarage) ? "EVET" : "HAYIR");
        System.out.printf("Butunleme    : %s\n", hasRetakeRight(avarage) ? "VAR" : "YOK");

    }
}
