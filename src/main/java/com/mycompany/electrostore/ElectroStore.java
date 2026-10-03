package com.mycompany.electrostore;

import java.util.Scanner;

public class ElectroStore {

    public static void cariProduk(String nama, Produk[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.println(" Hasil Pencarian Nama: '" + nama + "'");
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                daftar[i].garansi();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Produk dengan nama tersebut tidak ditemukan.");
    }

    public static void cariProduk(String merk, boolean isMerk, Produk[] daftar, int jumlah) {
        System.out.println("\n--------------------------------------------------");
        System.out.println(" Hasil Pencarian Merk: '" + merk + "'");
        System.out.println("--------------------------------------------------");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getMerk().equalsIgnoreCase(merk)) {
                System.out.print(">> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("[-] Produk dengan merk tersebut tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produk[] daftarProduk = new Produk[20];
        int jumlahProduk = 0;
        boolean isRunning = true;

        daftarProduk[jumlahProduk++] = new Laptop("ThinkPad L14", "Lenovo", 12500000, 16);
        daftarProduk[jumlahProduk++] = new Laptop("ProBook 630 G8", "HP", 11000000, 8);
        daftarProduk[jumlahProduk++] = new Smartphone("Galaxy S23", "Samsung", 13000000, 3900);
        daftarProduk[jumlahProduk++] = new Smartphone("Redmi Note 12", "Xiaomi", 2500000, 5000);
        daftarProduk[jumlahProduk++] = new Tablet("iPad Air 5", "Apple", 10500000, 10.9);
        daftarProduk[jumlahProduk++] = new Smartwatch("Galaxy Watch 5", "Samsung", 3800000, true);

        while (isRunning) {
            System.out.println("\n==================================================");
            System.out.println("     ELECTROSTORE ADVANCED INVENTORY SYSTEM (CLI) ");
            System.out.println("==================================================");
            System.out.println(" [1] Tambah Produk Baru");
            System.out.println(" [2] Lihat Seluruh Inventaris");
            System.out.println(" [3] Cari Produk (Fitur Overloading)");
            System.out.println(" [4] Filter Kategori Produk");
            System.out.println(" [5] Edit Harga Produk");
            System.out.println(" [6] Laporan Aset & Analisis Gudang");
            System.out.println(" [7] Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih Menu Opsi (1-7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahProduk < daftarProduk.length) {
                        System.out.println("\n>>> FORM TAMBAH PRODUK BARU <<<");
                        System.out.println("1. Tambah Laptop");
                        System.out.println("2. Tambah Smartphone");
                        System.out.println("3. Tambah Tablet");
                        System.out.println("4. Tambah Smartwatch");
                        System.out.print("Pilih Jenis Perangkat (1-4): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Produk  : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Merk Produk  : ");
                        String merk = scanner.nextLine();
                        System.out.print("Masukkan Harga (Rp)   : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Kapasitas RAM (GB)    : ");
                            int ram = scanner.nextInt();
                            scanner.nextLine();
                            daftarProduk[jumlahProduk++] = new Laptop(nama, merk, harga, ram);
                        } else if (jenis == 2) {
                            System.out.print("Kapasitas Baterai(mAh): ");
                            int baterai = scanner.nextInt();
                            scanner.nextLine();
                            daftarProduk[jumlahProduk++] = new Smartphone(nama, merk, harga, baterai);
                        } else if (jenis == 3) {
                            System.out.print("Ukuran Layar (Inci)   : ");
                            double layar = scanner.nextDouble();
                            scanner.nextLine();
                            daftarProduk[jumlahProduk++] = new Tablet(nama, merk, harga, layar);
                        } else if (jenis == 4) {
                            System.out.print("Tahan Air (true/false): ");
                            boolean tahanAir = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarProduk[jumlahProduk++] = new Smartwatch(nama, merk, harga, tahanAir);
                        } else {
                            System.out.println("[-] Pilihan jenis perangkat tidak valid!");
                            break;
                        }
                        System.out.println("[+] SUKSES: Produk baru berhasil ditambahkan ke sistem.");
                    } else {
                        System.out.println("[-] ERROR: Kapasitas gudang inventaris sudah penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n>>> DAFTAR INVENTARIS PRODUK TERSIMPAN <<<");
                    if (jumlahProduk == 0) {
                        System.out.println("[-] Belum ada produk yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahProduk; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarProduk[i].tampilkanInfo();
                            daftarProduk[i].garansi();
                            System.out.println();
                        }
                        System.out.println("--------------------------------------------------");
                        System.out.println("* Total Objek Berhasil Dibuat: " + Produk.totalProdukBerhasilDibuat);
                    }
                    System.out.print("\nTekan Enter untuk kembali ke menu...");
                    scanner.nextLine();
                }

                case 3 -> {
                    System.out.println("\n>>> FITUR PENCARIAN PRODUK (OVERLOADING) <<<");
                    System.out.println("1. Cari Berdasarkan Nama Produk");
                    System.out.println("2. Cari Berdasarkan Merk Produk");
                    System.out.print("Pilih Metode Cari (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Kata Kunci Nama: ");
                        String namaCari = scanner.nextLine();
                        cariProduk(namaCari, daftarProduk, jumlahProduk);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Kata Kunci Merk: ");
                        String merkCari = scanner.nextLine();
                        cariProduk(merkCari, true, daftarProduk, jumlahProduk);
                    } else {
                        System.out.println("[-] Pilihan mode pencarian tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 4 -> {
                    System.out.println("\n>>> FILTER KATEGORI PRODUK <<<");
                    System.out.println("1. Tampilkan Khusus Laptop");
                    System.out.println("2. Tampilkan Khusus Smartphone");
                    System.out.println("3. Tampilkan Khusus Tablet");
                    System.out.println("4. Tampilkan Khusus Smartwatch");
                    System.out.print("Pilih Filter (1-4): ");
                    int filter = scanner.nextInt();
                    scanner.nextLine();

                    boolean ada = false;
                    System.out.println("\n--- Hasil Filter ---");
                    for (int i = 0; i < jumlahProduk; i++) {
                        if (filter == 1 && daftarProduk[i] instanceof Laptop) {
                            daftarProduk[i].tampilkanInfo();
                            ada = true;
                        } else if (filter == 2 && daftarProduk[i] instanceof Smartphone) {
                            daftarProduk[i].tampilkanInfo();
                            ada = true;
                        } else if (filter == 3 && daftarProduk[i] instanceof Tablet) {
                            daftarProduk[i].tampilkanInfo();
                            ada = true;
                        } else if (filter == 4 && daftarProduk[i] instanceof Smartwatch) {
                            daftarProduk[i].tampilkanInfo();
                            ada = true;
                        }
                    }
                    if (!ada) System.out.println("[-] Tidak ada produk dalam kategori ini.");
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 5 -> {
                    System.out.println("\n>>> EDIT HARGA PRODUK <<<");
                    for (int i = 0; i < jumlahProduk; i++) {
                        System.out.println((i + 1) + ". " + daftarProduk[i].getNama() + " - Rp" + daftarProduk[i].getHarga());
                    }
                    System.out.print("Pilih nomor produk yang ingin diubah harganya: ");
                    int noProduk = scanner.nextInt();
                    scanner.nextLine();

                    if (noProduk > 0 && noProduk <= jumlahProduk) {
                        System.out.print("Masukkan Harga Baru (Rp): ");
                        double hargaBaru = scanner.nextDouble();
                        scanner.nextLine();

                        daftarProduk[noProduk - 1].setHarga(hargaBaru);
                        System.out.println("[+] SUKSES: Harga produk berhasil diperbarui.");
                    } else {
                        System.out.println("[-] Nomor produk tidak ditemukan!");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 6 -> {
                    System.out.println("\n>>> LAPORAN ANALISIS ASET GUDANG <<<");
                    if (jumlahProduk == 0) {
                        System.out.println("[-] Tidak ada data aset.");
                    } else {
                        double totalAset = 0;
                        Produk termahal = daftarProduk[0];
                        Produk termurah = daftarProduk[0];

                        for (int i = 0; i < jumlahProduk; i++) {
                            double harga = daftarProduk[i].getHarga();
                            totalAset += harga;
                            if (harga > termahal.getHarga()) termahal = daftarProduk[i];
                            if (harga < termurah.getHarga()) termurah = daftarProduk[i];
                        }

                        System.out.println("--------------------------------------------------");
                        System.out.printf(" Total Unit Tersimpan     : %d Unit%n", jumlahProduk);
                        System.out.printf(" Total Nilai Aset Gudang  : Rp%.2f%n", totalAset);
                        System.out.printf(" Rata-rata Harga Perangkat: Rp%.2f%n", (totalAset / jumlahProduk));
                        System.out.println("--------------------------------------------------");
                        System.out.println(" [+] Produk Termahal : " + termahal.getNama() + " (Rp" + termahal.getHarga() + ")");
                        System.out.println(" [+] Produk Termurah : " + termurah.getNama() + " (Rp" + termurah.getHarga() + ")");
                        System.out.println("--------------------------------------------------");
                    }
                    System.out.print("\nTekan Enter untuk kembali...");
                    scanner.nextLine();
                }

                case 7 -> {
                    System.out.println("\n==================================================");
                    System.out.println(" TERIMA KASIH TELAH MENGGUNAKAN ELECTROSTORE SYSTEM");
                    System.out.println("==================================================");
                    isRunning = false;
                }

                default -> System.out.println("[-] Opsi menu tidak valid. Pilih angka 1-7.");
            }
        }
        scanner.close();
    }
}