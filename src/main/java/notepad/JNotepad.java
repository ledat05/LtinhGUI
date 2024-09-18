/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.JNotepad to edit this template
 */
package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame{
    private JMenuBar menuBar;
    private JMenu mFile,mEdit,mFormat,mView,mHelp;
    private JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemPageSetup,itemPrint,itemExit,itemFront;
    private JMenuItem itemUdo,
    private JCheckBoxMenuItem itemWordWrap;
    private JTextArea txtEditor;
    public JNotepad(String title){
        super(title);
        createMenu();
        processEvent();
        createGui();
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        menuBar= new JMenuBar();
        
        menuBar.add(mFile=new JMenu("File"));
        menuBar.add(mEdit=new JMenu("Edit"));
        menuBar.add(mFormat=new JMenu("Format"));
        menuBar.add(mView=new JMenu("View"));
        menuBar.add(mHelp=new JMenu("Help"));
        
        mFile.add(itemNew= new JMenuItem("New"));
        mFile.add(itemOpen= new JMenuItem("Open"));
        mFile.add(itemSave= new JMenuItem("Save"));
        mFile.add(itemSaveAs= new JMenuItem("Save As..."));
        mFile.add(new JSeparator());
        mFile.add(itemPageSetup= new JMenuItem("PageSetup..."));
        mFile.add(itemPrint= new JMenuItem("Print"));
        mFile.add(itemExit= new JMenuItem("Exit"));
        
        //Format
        mFormat.add(itemWordWrap=new JCheckBoxMenuItem("Word Wrap",true));
        mFormat.add(itemFront=new JMenuItem("Font..."));
        
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK));
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        setJMenuBar(menuBar);
    }
    public static void main(String[] args) {
       JNotepad app = new JNotepad("NotePad");
        app.setVisible(true);
     
    }

    private void processEvent() {
        itemExit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if(JOptionPane.showConfirmDialog(null,"Are you to exit?")==JOptionPane.YES_OPTION)
             {
                 System.exit(0);
             }
         }   
        });
    }

    private void createGui() {
        txtEditor=new JTextArea();
        JScrollPane scrollPane= new JScrollPane(txtEditor);
        add(scrollPane);
        txtEditor.setLineWrap(true);
        txtEditor.setFont(new Font("Arial",Font.PLAIN,20));
    }
}
