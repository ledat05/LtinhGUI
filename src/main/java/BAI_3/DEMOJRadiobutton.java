/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI_3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class DEMOJRadiobutton extends JFrame{
    private JLabel lbSo1,lbSo2,lbPhepTinh,lbKetqua;
    private JTextField txtSo1,txtSo2,txtKq;
    private JRadioButton rdCong,rdTru,rdNhan,rdChia;
    private JButton btTinh;
    
    public DEMOJRadiobutton(){
        setTitle("DemoRadio");
        pack();
        taogiaodien();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private void taogiaodien() {
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(4,2,5,5));
        p1.add(lbSo1=new JLabel("Số 1"));
        p1.add(txtSo1=new JTextField(""));
        p1.add(lbSo2=new JLabel("Số 2"));
        p1.add(txtSo2=new JTextField(""));
        
        JPanel p2=new JPanel();
        p2.add(rdCong=new JRadioButton("+"));
        p2.add(rdTru=new JRadioButton("-"));
        p2.add(rdNhan=new JRadioButton("*"));
        p2.add(rdChia=new JRadioButton("/"));
        
        p1.add(lbPhepTinh=new JLabel("Phép tính"));
        p1.add(p2);
        p1.add(lbKetqua=new JLabel("Ket Qua"));
        p1.add(txtKq=new JTextField(""));
        
        p2.add(btTinh=new JButton("Tính"));
        
                add(p1);
                add(btTinh=new JButton("Tính"),BorderLayout.SOUTH);
           }
    public static void main(String[] args) {
       DEMOJRadiobutton frm = new DEMOJRadiobutton();
        frm.setVisible(true);
     }
}
