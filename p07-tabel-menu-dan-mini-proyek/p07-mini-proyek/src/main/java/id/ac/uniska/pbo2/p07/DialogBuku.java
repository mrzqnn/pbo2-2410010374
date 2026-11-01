package id.ac.uniska.pbo2.p07;

import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import javax.swing.*;

public class DialogBuku extends javax.swing.JDialog {
  private Buku hasil;

  public DialogBuku(java.awt.Frame pemilik, String judul, Buku awal) {
    super(pemilik, judul, true);
    initComponents();
    formPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 8, 16));
    bawahPanel.setBorder(BorderFactory.createEmptyBorder(0, 16, 16, 16));
    pesanLabel.setForeground(FlatLaf.isLafDark() ? new Color(0xFF8A80) : new Color(0xC62828));
    pesanLabel.setPreferredSize(new java.awt.Dimension(450, 24));
    if (awal != null) {
      kodeField.setText(awal.kode());
      judulField.setText(awal.judul());
      penulisField.setText(awal.penulis());
      tahunField.setText(String.valueOf(awal.tahunTerbit()));
      statusCombo.setSelectedItem(awal.status());
    }
    getRootPane().setDefaultButton(simpanButton);
    pack();
    setLocationRelativeTo(pemilik);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel = new javax.swing.JPanel();
        labelPanel = new javax.swing.JPanel();
        kodeLabel = new javax.swing.JLabel();
        judulLabel = new javax.swing.JLabel();
        penulisLabel = new javax.swing.JLabel();
        tahunLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        isianPanel = new javax.swing.JPanel();
        kodeField = new javax.swing.JTextField();
        judulField = new javax.swing.JTextField();
        penulisField = new javax.swing.JTextField();
        tahunField = new javax.swing.JTextField();
        statusCombo = new javax.swing.JComboBox<>();
        bawahPanel = new javax.swing.JPanel();
        pesanLabel = new javax.swing.JLabel();
        tombolPanel = new javax.swing.JPanel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DialogBuku");
        setResizable(false);

        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 8, 16));
        formPanel.setLayout(new java.awt.BorderLayout(8, 8));

        labelPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));

        kodeLabel.setText("Kode");
        kodeLabel.setLabelFor(kodeField);
        labelPanel.add(kodeLabel);

        judulLabel.setText("Judul");
        judulLabel.setLabelFor(judulField);
        labelPanel.add(judulLabel);

        penulisLabel.setText("Penulis");
        penulisLabel.setLabelFor(penulisField);
        labelPanel.add(penulisLabel);

        tahunLabel.setText("Tahun terbit");
        tahunLabel.setLabelFor(tahunField);
        labelPanel.add(tahunLabel);

        statusLabel.setText("Status");
        statusLabel.setLabelFor(statusCombo);
        labelPanel.add(statusLabel);

        formPanel.add(labelPanel, java.awt.BorderLayout.WEST);

        isianPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 8));

        kodeField.setColumns(28);
        isianPanel.add(kodeField);

        judulField.setColumns(28);
        isianPanel.add(judulField);

        penulisField.setColumns(28);
        isianPanel.add(penulisField);

        tahunField.setColumns(28);
        isianPanel.add(tahunField);

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(StatusBuku.values()));
        isianPanel.add(statusCombo);

        formPanel.add(isianPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);

        bawahPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 16, 16));
        bawahPanel.setLayout(new java.awt.BorderLayout(8, 8));

        pesanLabel.setText(" ");
        bawahPanel.add(pesanLabel, java.awt.BorderLayout.NORTH);

        tombolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 0));

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(batalButton);

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        tombolPanel.add(simpanButton);

        bawahPanel.add(tombolPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(bawahPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void batalButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
    dispose();
  }//GEN-LAST:event_batalButtonActionPerformed

  private void simpanButtonActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
    simpan();
  }//GEN-LAST:event_simpanButtonActionPerformed

  private void tolak(String pesan, JTextField isian) {
    pesanLabel.setText(pesan);
    isian.requestFocusInWindow();
  }

  private void simpan() {
    String kode = kodeField.getText().trim(), judul = judulField.getText().trim();
    if (kode.isEmpty()) {
      tolak("Kode wajib diisi", kodeField);
      return;
    }
    if (judul.isEmpty()) {
      tolak("Judul wajib diisi", judulField);
      return;
    }
    int tahun;
    try {
      tahun = Integer.parseInt(tahunField.getText().trim());
    } catch (NumberFormatException ex) {
      tolak("Tahun terbit harus berupa angka", tahunField);
      return;
    }
    int sekarang = java.time.Year.now().getValue();
    if (tahun < 1900 || tahun > sekarang) {
      tolak("Tahun terbit harus 1900 sampai " + sekarang, tahunField);
      return;
    }
    hasil =
        new Buku(
            kode,
            judul,
            penulisField.getText().trim(),
            tahun,
            (StatusBuku) statusCombo.getSelectedItem());
    dispose();
  }

  public Buku tampilkan() {
    setVisible(true);
    return hasil;
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JPanel bawahPanel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel isianPanel;
    private javax.swing.JTextField judulField;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JTextField kodeField;
    private javax.swing.JLabel kodeLabel;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JTextField penulisField;
    private javax.swing.JLabel penulisLabel;
    private javax.swing.JLabel pesanLabel;
    private javax.swing.JButton simpanButton;
    private javax.swing.JComboBox<StatusBuku> statusCombo;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField tahunField;
    private javax.swing.JLabel tahunLabel;
    private javax.swing.JPanel tombolPanel;
    // End of variables declaration//GEN-END:variables
}
