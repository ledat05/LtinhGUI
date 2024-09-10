package BAI_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class MayTinhDonGian extends JFrame {

    private JTextField txtDisplay;
    private JButton btReset;
    private JButton[] bt = new JButton[16];
    private String[] str = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"};

    public MayTinhDonGian() {
        setTitle("Máy Tính");
        pack();
        taogiaodien();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taogiaodien() {
        JPanel p1 = new JPanel();
        p1.add(txtDisplay = new JTextField());
        txtDisplay.setPreferredSize(new Dimension(200, 30));
        p1.add(btReset = new JButton("C"));
        btReset.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    txtDisplay.setText("");
                }
            });

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(str[i]);
            p2.add(bt[i]);
            

            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtDisplay.setText(txtDisplay.getText() + e.getActionCommand());
                }
            });

            setLayout(new BorderLayout());
            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            
        }
    }

    public static void main(String[] args) {
        MayTinhDonGian frm = new MayTinhDonGian();
        frm.setVisible(true);
    }
}
