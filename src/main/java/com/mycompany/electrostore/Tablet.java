package com.mycompany.electrostore;

public class Tablet extends Produk implements DapatDinilai {
    private double ukuranLayar;

    public Tablet(String nama, String merk, double harga, double ukuranLayar) {
        super(nama, merk, harga);
        this.ukuranLayar = ukuranLayar;
    }

    public double getUkuranLayar() {
        return this.ukuranLayar;
    }

    public void setUkuranLayar(double ukuranLayar) {
        this.ukuranLayar = ukuranLayar;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Tablet]     Nama: %-18s | Merk: %-10s | Harga: Rp%-10.0f | Layar: %.1f Inci%n",
                getNama(), getMerk(), getHarga(), this.ukuranLayar);
    }

    @Override
    public void garansi() {
        System.out.println("   -> Info Garansi: Garansi Resmi Tablet 1 Tahun.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("   -> [RATING ULASAN] Tablet ini mendapat ulasan " + bintang + "/5 Bintang dari pengguna.");
    }
}