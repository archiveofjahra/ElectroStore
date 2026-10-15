package com.mycompany.electrostore;

public abstract class Produk {
    private String nama;
    private String merk;
    private double harga;

    public static int totalProdukBerhasilDibuat = 0;

    public Produk(String nama, String merk, double harga) {
        this.nama = nama;
        this.merk = merk;
        setHarga(harga);
        totalProdukBerhasilDibuat++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid!");
            this.harga = 1000;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %-20s | Merk: %-10s | Harga: Rp%.0f", this.nama, this.merk, this.harga);
    }

    public abstract void garansi();
}