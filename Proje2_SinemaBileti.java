/*
 * Ad Soyad: Akın Ağaçbacak
 * Ogrenci No: 250542018
 * Tarih: 25/11/2025
 * Aciklama: Proje 2 - Sinema Bileti
 *
 *Farklı tarife, format ve indirim seçeneklerini değerlendirerek 
 *detaylı bilet dökümü ve toplam tutarı kullanıcıya sunan bir fiyatlandırma sistemidir.
 */


import java.util.Scanner;

public class Proje2_SinemaBileti {

    public static boolean isWeekend(int gun) {
        switch (gun){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return false;
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static boolean isMatinee(int hour) {
        return (hour < 12);
    }

    public static int calculateBasePrice(int day, int hour) {
        boolean isWeekend = isWeekend(day);
        boolean isMatinee = isMatinee(hour);

        if (isWeekend) {
            if (isMatinee) return 55;
            else return 85;
        } else {
            if (isMatinee) return 45;
            else return 65;
        }
    }

    public static int calculateDiscount(int yas, int meslek, int gun) {

        if (yas > 65) return 30;
        if (yas < 12) return 25;

        if (meslek == 1) {
            return 20;
        } else if (meslek == 2) {
            return 15;
        }

        return 0;
    }

    public static int getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25; // 3D
            case 3: return 35; // IMAX
            case 4: return 50; // 4DX
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int basePrice, int discount, int formatExtra) {
        double discountedPrice = basePrice * (100 - discount) / 100.0;
        return discountedPrice + formatExtra;
    }

    public static void generateTicketInfo(int day, int hour, int age, int work, int movieGenre) {
        int basePrice = calculateBasePrice(day, hour);
        int discount = calculateDiscount(age, work, day);
        int formatExtra = getFormatExtra(movieGenre);

        // İndirim miktarını hesaplar
        double discountAmount = basePrice * discount / 100.0;
        double finalPrice = calculateFinalPrice(basePrice, discount, formatExtra);

        System.out.println("\n============BİLET BİLGİSİ=============");
        System.out.printf("Temel Fiyat      : %d TL\n", basePrice);
        System.out.printf("İndirim Oranı    : %% %d\n", discount);
        System.out.printf("İndirim Miktarı  : %.2f TL\n", discountAmount);
        System.out.printf("İndirimli Fiyat  : %.2f TL\n", (basePrice - discountAmount));
        System.out.printf("Ekstra Ücret     : %d TL\n", formatExtra);
        System.out.println("--------------------------------------");
        System.out.printf("TOPLAM           : %.2f TL\n", finalPrice);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("============Sinema Bileti=============");
        System.out.print("Gun (1-7)       : ");
        int gun = input.nextInt();
        System.out.print("Saat (8-23)     : ");
        int saat = input.nextInt();
        System.out.print("Yas             : ");
        int yas = input.nextInt();
        System.out.print("Meslek (1-3)    : ");
        int meslek = input.nextInt();
        System.out.print("Film Turu (1-4) : ");
        int filmTuru = input.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);
    }
}
