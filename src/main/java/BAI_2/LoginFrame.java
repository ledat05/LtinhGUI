
package BAI_2;

import BAI_2.LoginFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class LoginFrame extends JFrame {

    private JLabel lbUser, lbPass;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btLogin, btReset;

    public LoginFrame(String title) {
        super(title);
        taogiaodien();
        pack();
        //sukien();
        //setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void taogiaodien() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,2,5,5));
        p.add(lbUser = new JLabel("User"));
        p.add(txtUser=new JTextField());
        p.add(lbPass=new JLabel("Pass"));
        p.add(txtPass=new JPasswordField());
        
        p.add(btLogin=new JButton("Login"));
        p.add(btReset=new JButton("Reset"));
        
    add(p);
    }
     public static void main(String[] args) {
       LoginFrame frm = new LoginFrame("LoginFrame");
        frm.setVisible(true);
     }

    
     
    
}
