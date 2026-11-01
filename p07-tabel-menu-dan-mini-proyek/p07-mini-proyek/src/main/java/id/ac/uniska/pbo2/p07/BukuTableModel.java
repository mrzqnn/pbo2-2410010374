package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Menghubungkan daftar Buku dengan JTable.
 * JTable bertanya kepada model: berapa baris, berapa kolom, dan apa isi setiap sel.
 */
public class BukuTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"Kode", "Judul", "Penulis", "Tahun Terbit", "Status"};
    private final List<Buku> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    /** Kolom tahun bertipe Integer agar diurutkan sebagai angka, bukan sebagai teks. */
    @Override
    public Class<?> getColumnClass(int kolom) {
        return kolom == 3 ? Integer.class : Object.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = daftar.get(baris);
        return switch (kolom) {
            case 0 -> b.kode();
            case 1 -> b.judul();
            case 2 -> b.penulis();
            case 3 -> b.tahunTerbit();
            default -> b.status();
        };
    }

    public Buku get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris); // tampilkan baris baru
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }

    /** Jumlah buku berstatus Tersedia di seluruh katalog. */
    public int jumlahTersedia() {
        int jumlah = 0;
        for (Buku b : daftar) {
            if (b.status() == StatusBuku.TERSEDIA) {
                jumlah++;
            }
        }
        return jumlah;
    }
    
    public boolean kodeDipakai(String kode, int barisDiabaikan) {
    for (int i = 0; i < getRowCount(); i++) {
        if (i == barisDiabaikan) {
            continue;
        }

        if (get(i).kode().equalsIgnoreCase(kode.trim())) {
            return true;
        }
    }
    return false;
}
}
