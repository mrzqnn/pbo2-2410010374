# Tugas Pertemuan 6: Validasi Input dan Kegunaan

**Mata Kuliah:** Pemrograman Berbasis Objek 2 (TIF1508)
**Nama:** M. Rizqon
**NPM:** 2410010374
**Kelas:** 5B
**Proyek:** `p06-validasi-input`

## Isi Proyek

- `FormAnggotaPerpustakaan.java` dan `FormAnggotaPerpustakaan.form`
- `Validator.java`
- `UjiValidator.java`

## 1. Lembar Peer Review

Lembar peer review yang saya terima dari teman: [LEMBAR_PER_REVIEW.docx](LEMBAR_PER_REVIEW.docx)

**Peninjau:** Adib Bara Taufani | **Pemilik form:** M. Rizqon (2410010374) | **Tanggal:** 31 Oktober 2026

| No | Heuristik | Temuan | Skor | Saran |
|----|-----------|--------|------|-------|
| 1 | Visibilitas status sistem | Ringkasan "3 isian perlu diperbaiki" terlihat. | 0 | Pertahankan ringkasan status. |
| 2 | Kesesuaian dengan dunia nyata | Istilah NPM, program studi, dan jenis anggota mudah dipahami. | 0 | Pertahankan istilah yang digunakan. |
| 3 | Kendali dan kebebasan pengguna | Tombol Batal tersedia; perilaku konfirmasi belum diuji. | BV | Coba Batal lalu No; pastikan data tetap ada. |
| 4 | Konsistensi dan standar | Label, isian, serta pesan kesalahan menggunakan pola konsisten. | 0 | Pertahankan konsistensi. |
| 5 | Pencegahan kesalahan | Validasi menandai data salah. Filter ketikan dan persetujuan belum diuji langsung. | BV | Coba huruf pada NPM/HP serta tombol Daftar tanpa persetujuan. |
| 6 | Mengenali, bukan mengingat | Label dan pilihan prodi/jenis anggota tersedia pada form. | 0 | Pertahankan label yang jelas. |
| 7 | Fleksibilitas dan efisiensi | Pintasan keyboard dan urutan Tab belum diuji langsung. | BV | Coba Alt+N dan navigasi Tab. |
| 8 | Desain estetis dan minimalis | Ukuran form lebih besar dari versi sebelumnya dan ruang kosong masih cukup lebar. | 1 | Ringkaskan ukuran/jarak tanpa memotong pesan dan alamat. |
| 9 | Membantu memperbaiki kesalahan | Pesan NPM, email, dan HP terbaca lengkap serta menjelaskan aturan. | 0 | Pertahankan pesan yang spesifik. |
| 10 | Bantuan dan dokumentasi | Contoh email terlihat pada pesan; tooltip NPM belum diperiksa langsung. | BV | Arahkan mouse ke NPM untuk memeriksa petunjuk. |

Skala: 0 = bukan masalah; 1 = kosmetik; 2 = minor; 3 = mayor; 4 = kritis. BV = belum diverifikasi, bukan skor keparahan.

## 2. Tabel Temuan dan Perbaikan

Tidak ada temuan dengan skor 3 atau 4. Satu-satunya temuan bernilai skor adalah skor 1 (kosmetik).

| No | Temuan dari teman | Skor | Perbaikan yang saya lakukan | Commit |
|----|-------------------|------|-----------------------------|--------|
| 1 | Ukuran form lebih besar dan ruang kosong terlalu lebar (heuristik 8) | 1 | ........................................... | `xxxxxxx` |
| 2 | Konfirmasi Batal, filter ketikan, Alt+N/Tab, dan tooltip NPM belum diverifikasi (BV) | BV | Sudah saya uji sendiri pada Praktikum 4 (lihat bagian 5) | - |

## 3. Tangkapan Layar Form dengan Pesan Kesalahan

![Form dengan pesan kesalahan](images/form-pesan-kesalahan.png)

## 4. Tangkapan Layar Jendela Navigator

Jendela Navigator memperlihatkan label pesan `npmPesanLabel`, `namaPesanLabel`, `prodiPesanLabel`, `emailPesanLabel`, dan `hpPesanLabel`.

![Jendela Navigator](images/navigator.png)

## 5. Jawaban Eksperimen Praktikum 4

1. Huruf tidak muncul di isian NPM. Penyebabnya `evt.consume();` di dalam `if (!Character.isDigit(evt.getKeyChar()) || penuh)`, yang membatalkan karakter bukan angka.
2. Pesan muncul saat Tab ditekan (fokus meninggalkan isian), karena event `focusLost` memanggil `periksaEmail()`.
3. Tidak ada pesan karena `namaFieldFocusLost` hanya memeriksa jika isian tidak kosong (`!isBlank()`). Isian kosong baru diperiksa saat Daftar diklik.
4. Isian NPM yang mendapat fokus, karena `salah.get(0).requestFocusInWindow()` mengarahkan fokus ke kesalahan pertama.
5. Isian Nama lengkap yang mendapat fokus. Properti yang mengaturnya adalah `displayedMnemonic` (N) bersama `labelFor` pada label Nama.
6. Ya, data tetap ada, karena jika jawaban bukan `YES_OPTION`, `batal()` langsung `return` sehingga `kosongkan()` tidak dipanggil.

## 6. Deklarasi Penggunaan AI

**Alat yang digunakan:** Claude (Anthropic).

**Keperluan:**
- Membantu memahami isi modul dan daftar yang harus dikumpulkan.
- Membantu menyusun draf jawaban eksperimen Praktikum 4, deklarasi ini, dan README.
- Memeriksa kelengkapan file yang harus ada di repository (termasuk file `.form`).

Seluruh kode program saya tulis dan uji sendiri. Hasil dari AI saya baca, verifikasi dengan menjalankan program, dan sesuaikan sebelum dikumpulkan.
