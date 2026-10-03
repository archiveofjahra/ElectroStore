package com.mycompany.electrostore;

public class Smartwatch extends Produk {
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
        String statusAir = this.tahanAir ? "Tahan Air" : "Tidak Tahan Air";
        System.out.printf("[Smartwatch] Nama: %-18s | Merk: %-10s | Harga: Rp%-12.2f | Fitur: %s%n",
                getNama(), getMerk(), getHarga(), statusAir);
    }

    @Override
    public void caraPinjam() {
        System.out.println("-> Info Garansi: Garansi Resmi Smartwatch 1 Tahun Replacement.");
    }
}