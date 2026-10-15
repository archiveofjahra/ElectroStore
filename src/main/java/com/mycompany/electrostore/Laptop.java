package com.mycompany.electrostore;

public class Laptop extends Produk implements DapatDipinjam, DapatDinilai {
    private int ramGB;

    public Laptop(String nama, String merk, double harga, int ramGB) {
        super(nama, merk, harga);
        this.ramGB = ramGB;
    }

    public int getRamGB() {
        return this.ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Laptop]     Nama: %-18s | Merk: %-10s | Harga: Rp%-10.0f | RAM: %d GB%n",
                getNama(), getMerk(), getHarga(), this.ramGB);
    }

    @Override
    public void garansi() {
        System.out.println("   -> Info Garansi: Garansi Resmi Laptop 2 Tahun.");
    }

    @Override
    public void prosesSewaFisik() {
        System.out.println("   -> [PROSES SEWA] Laptop disiapkan lengkap dengan charger & tas resmi.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("   -> [RATING ULASAN] Laptop ini mendapat nilai " + bintang + "/5 Bintang dari pengguna.");
    }
}