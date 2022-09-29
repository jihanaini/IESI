/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class PeminjamanController {
    
        public void showFormPeminjaman() {
        Perpustakaan.formPeminjaman = new FormPeminjaman();
    }
    
        public void cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        try {
            ArrayList<Buku> listBuku = bukuProvider.selectBuku(judul);
            if(listBuku.isEmpty())
            {
                DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
            } 
            else Perpustakaan.formPeminjaman.tampilPinjaman(listBuku);
        } catch(Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
        
    }
        public void pinjam(ArrayList<BukuDipinjam> bukuList){}

}
