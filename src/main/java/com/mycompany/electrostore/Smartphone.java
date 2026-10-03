package com.mycompany.electrostore;

public class Smartphone extends Produk {
    private int kapasitasBaterai;

    public Smartphone(String nama, String merk, double harga, int kapasitasBaterai) {
        super(nama, merk, harga);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public int getKapasitasBaterai() {
        return this.kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Smartphone] Nama: %-18s | Merk: %-10s | Harga: Rp%-12.2f | Baterai: %d mAh%n",
                getNama(), getMerk(), getHarga(), this.kapasitasBaterai);
    }

    @Override
    public void caraPinjam() {
        System.out.println("-> Info Garansi: Garansi Resmi Smartphone 1 Tahun.");
    }
}