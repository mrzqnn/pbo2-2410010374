# Peta Event

## Struktur file

| File | Peran |
|---|---|
| `KatalogBuku.java` / `.form` | Jendela utama (JFrame): tabel, tombol, menu, kolom cari, label status |
| `DialogBuku.java` / `.form` | Dialog modal untuk tambah/ubah buku, plus validasi input |
| `BukuTableModel.java` | Model tabel (`AbstractTableModel`), penyimpan data `List<Buku>` |
| `Buku.java` | Record data buku (kode, judul, penulis, tahunTerbit, status) |
| `StatusBuku.java` | Enum `TERSEDIA` / `DIPINJAM` |

## Peta event

### 1. Jendela utama (`KatalogBuku`)

#### Event dari pengguna

| Sumber | Event | Handler | Aksi |
|---|---|---|---|
| `tambahButton` | ActionEvent | `tambahButtonActionPerformed` | `tambah()` |
| `ubahButton` | ActionEvent | `ubahButtonActionPerformed` | `ubah()` |
| `hapusButton` | ActionEvent | `hapusButtonActionPerformed` | `hapus()` |
| `cariField` | KeyReleased | `cariFieldKeyReleased` | `saring()` |
| `bukuTable` | MouseClicked (2x klik pada baris terpilih) | `bukuTableMouseClicked` | `ubah()` |
| Menu Buku > Tambah | ActionEvent | `tambahItemActionPerformed` | `tambah()` |
| Menu Buku > Ubah | ActionEvent | `ubahItemActionPerformed` | `ubah()` |
| Menu Buku > Hapus | ActionEvent | `hapusItemActionPerformed` | `hapus()` |
| Menu File > Keluar | ActionEvent | `keluarItemActionPerformed` | `dispose()` |
| Menu Bantuan > Tentang | ActionEvent | `tentangItemActionPerformed` | `JOptionPane` info pembuat |

#### Event internal (listener di konstruktor)

| Sumber | Listener | Aksi |
|---|---|---|
| `bukuTable.getSelectionModel()` | `ListSelectionListener` | `perbaruiTombol()` |
| `sorter` | `RowSorterListener` | `perbaruiStatus()` + `perbaruiTombol()` |
| `model` | `TableModelListener` | `invokeLater` -> `perbaruiStatus()` + `perbaruiTombol()` |

### 2. Dialog tambah/ubah (`DialogBuku`)

| Sumber | Event | Handler | Aksi |
|---|---|---|---|
| `simpanButton` | ActionEvent | `simpanButtonActionPerformed` | `simpan()` |
| Tombol Enter | Default button | (sama dengan Simpan) | `simpan()` |
| `batalButton` | ActionEvent | `batalButtonActionPerformed` | `dispose()` (hasil = null) |
| Tombol close (X) | `DISPOSE_ON_CLOSE` | - | dialog ditutup (hasil = null) |

### 3. Event model (`BukuTableModel`)

| Method | Event yang dikirim | Efek |
|---|---|---|
| `tambah()` | `fireTableRowsInserted` | Baris baru muncul, status diperbarui |
| `ubah()` | `fireTableRowsUpdated` | Baris diperbarui |
| `hapus()` | `fireTableRowsDeleted` | Baris hilang |

## Alur validasi di `DialogBuku.simpan()`

1. Kode kosong -> "Kode wajib diisi"
2. Judul kosong -> "Judul wajib diisi"
3. Tahun bukan angka -> "Tahun terbit harus berupa angka"
4. Tahun di luar 1900 sampai tahun sekarang -> "Tahun terbit harus 1900 sampai ..."
5. Lolos semua -> `hasil` dibuat, dialog ditutup
6. Cek kode ganda dilakukan di `KatalogBuku` (bukan di dialog) lewat `model.kodeDipakai(...)`



