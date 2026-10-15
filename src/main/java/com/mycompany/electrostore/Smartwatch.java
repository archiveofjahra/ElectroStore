package com.mycompany.electrostore;

public class Smartwatch extends Produk implements DapatDinilai {
    private boolean tahanAir;

    public Smartwatch(String nama, String merk, double harga, boolean tahanAir) {
        super(nama, merk, harga);
        this.tahanAir = tahanAir;
    }

    public boolean isTahanAir() {
        return this.tahanAir;
    }

    public void setTahanAir(boolean tahanAir) {
        this.tahanAir = tahanAir;
    }

    @Override
    public void tampilkanInfo() {
        String statusAir = isTahanAir() ? "Tahan Air" : "Tidak Tahan Air";
        System.out.printf("[Smartwatch] Nama: %-18s | Merk: %-10s | Harga: Rp%-10.0f | Fitur: %s%n",
                getNama(), getMerk(), getHarga(), statusAir);
    }

    @Override
    public void garansi() {
        System.out.println("   -> Info Garansi: Garansi Resmi Smartwatch 1 Tahun.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("   -> [RATING ULASAN] Smartwatch ini mendapat ulasan " + bintang + "/5 Bintang dari pengguna.");
    }
}