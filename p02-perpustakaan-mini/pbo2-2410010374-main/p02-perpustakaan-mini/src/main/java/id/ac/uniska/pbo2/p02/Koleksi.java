/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p02;

/**
 *
 * @author ASUS
 */
public abstract class Koleksi implements BisaDipinjam {
    // Default value variabel
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private StatusKoleksi status = StatusKoleksi.TERSEDIA;
    
    protected Koleksi(String kode, String judul, int tahunTerbit) {
        if (judul == null || judul.isBlank()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong!");
        }
        
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public int getTahunTerbit() {
        return tahunTerbit;
    }
    
    public StatusKoleksi getStatus() {
        return status;
    }
    
    // Mengubah status dan mengecek apakah dipinjam
    public boolean pinjam() {
        if (status == StatusKoleksi.DIPINJAM) {
            return false;
        }
        status = StatusKoleksi.DIPINJAM;
        return true;
    }
    
    // Mengembalikan dan mengubah status menjadi tersedia
    public void kembalikan() {
        status = StatusKoleksi.TERSEDIA;
    }
    
    // Keterangan singkat
    public abstract String keterangan();
    
    // Override method bawaan toString untuk studi kasus ini.
    @Override
    public String toString() {
        return "[" + status + "] " + kode + " " + judul + " (" + tahunTerbit + "), " + keterangan();
    }
}
