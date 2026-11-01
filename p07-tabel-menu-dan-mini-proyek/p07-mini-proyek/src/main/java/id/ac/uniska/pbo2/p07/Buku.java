package id.ac.uniska.pbo2.p07;

/**
 * Data satu buku. Record dipakai karena data buku tidak diubah langsung;
 * perubahan dilakukan dengan mengganti object lama dengan object baru.
 */
public record Buku(String kode, String judul, String penulis, int tahunTerbit, StatusBuku status) {
}
