// Nama: M. Rizqon
// NPM : 2410010374
package id.ac.uniska.pbo2.uts;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DaftarBelanjaModel extends AbstractTableModel {
    private static final String[] KOLOM = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private static final long BATAS_DISKON = 100000;

    private final List<Barang> daftar = new ArrayList<>();

    // ---- bagian TableModel ----
    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int column) {
        return KOLOM[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Barang b = daftar.get(row);
        switch (column) {
            case 0: return b.getNama();
            case 1: return b.getKategori();
            case 2: return formatRupiah(b.getHarga());
            case 3: return b.getJumlah();
            default: return formatRupiah(b.getSubtotal());
        }
    }

    // ---- data ----
    public void tambah(Barang barang) {
        daftar.add(barang);
        fireTableRowsInserted(daftar.size() - 1, daftar.size() - 1);
    }

    public boolean sudahAda(String nama) {
        for (Barang b : daftar) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    // ---- perhitungan ----
    public long hitungTotal() {
        long total = 0;
        for (Barang b : daftar) {
            total += b.getSubtotal();
        }
        return total;
    }

    public long hitungDiskon() {
        long total = hitungTotal();
        return total >= BATAS_DISKON ? total / 10 : 0; // pembagian long = dibulatkan ke bawah
    }

    public long hitungBayar() {
        return hitungTotal() - hitungDiskon();
    }

    public String ringkasan() {
        return "Total " + formatRupiah(hitungTotal())
                + ", diskon " + formatRupiah(hitungDiskon())
                + ", bayar " + formatRupiah(hitungBayar());
    }

    public static String formatRupiah(long nilai) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setGroupingSeparator('.');
        return "Rp" + new DecimalFormat("#,##0", simbol).format(nilai);
    }
}