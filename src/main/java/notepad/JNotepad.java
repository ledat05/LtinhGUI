package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class JNotepad extends JFrame {

    private JMenuBar menuBar;
    private JMenu mFile, mEdit, mView, itemZoom;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemCloseTab, itemCloseWin, itemExit;
    private JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSearchwithBing, itemFind, itemFindnext, itemFindprevious, itemReplace, itemGoto, itemSelectall, itemTimedate, itemFont;
    private JCheckBoxMenuItem itemWordWrap, itemStatusbar;
    private JMenuItem itemZoomin, itemZoomOut, itemRestoredefaultzoom;

    private JTextArea txtEditor;
    
    private JToolBar toolBar;
    private JButton btNew,btOpen,btSave;
    
    private JFontDialog fontDlg;

    public JNotepad(String title) {
        super(title);
        createMenu();
        processEvent();
        createGui();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        menuBar = new JMenuBar();

        menuBar.add(mFile = new JMenu("File"));
        menuBar.add(mEdit = new JMenu("Edit"));
        menuBar.add(mView = new JMenu("View"));

        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open"));
        mFile.add(itemSave = new JMenuItem("Save"));
        mFile.add(itemSaveAs = new JMenuItem("Save As..."));
        mFile.add(new JSeparator());
        mFile.add(itemPageSetup = new JMenuItem("Page Setup..."));
        mFile.add(itemPrint = new JMenuItem("Print"));
        mFile.add(new JSeparator());
        mFile.add(itemCloseTab = new JMenuItem("Close tab"));
        mFile.add(itemCloseWin = new JMenuItem("Close Windows"));
        mFile.add(itemExit = new JMenuItem("Exit"));

        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        itemCloseTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        itemCloseWin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));

        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));
        mEdit.add(itemDelete = new JMenuItem("Delete"));
        mEdit.add(new JSeparator());
        mEdit.add(itemSearchwithBing = new JMenuItem("Search with Bing"));
        mEdit.add(new JSeparator());
        mEdit.add(itemFind = new JMenuItem("Find"));
        mEdit.add(itemFindnext = new JMenuItem("Find next"));
        mEdit.add(itemFindprevious = new JMenuItem("Find previous"));
        mEdit.add(itemReplace = new JMenuItem("Replace"));
        mEdit.add(itemGoto = new JMenuItem("Go to"));
        mEdit.add(new JSeparator());
        mEdit.add(itemSelectall = new JMenuItem("Select all"));
        mEdit.add(itemTimedate = new JMenuItem("Time/Date"));
        mEdit.add(new JSeparator());
        mEdit.add(itemFont = new JMenuItem("Font"));

        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        itemSearchwithBing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindnext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        itemFindprevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        itemTimedate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

        mView.add(itemZoom = new JMenu("Zoom"));
        itemZoom.add(itemZoomin = new JMenuItem("Zoom In"));
        itemZoom.add(itemZoomOut = new JMenuItem("Zoom Out"));
        itemZoom.add(itemRestoredefaultzoom = new JMenuItem("Restore Default Zoom"));
        mView.add(itemStatusbar = new JCheckBoxMenuItem("Status Bar"));
        mView.add(itemWordWrap = new JCheckBoxMenuItem("Word Wrap"));

        itemZoomin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
        itemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
        itemRestoredefaultzoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK));
        setJMenuBar(menuBar);
    }

    private void processEvent() {
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        
        itemFont.addActionListener((ActionEvent e) -> {
            
             {
                fontDlg = new JFontDialog(this,true);
                fontDlg.setVisible(true);
            }
        });
    }

    private void createGui() {
        txtEditor = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtEditor);
        add(scrollPane);
        txtEditor.setLineWrap(true);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public static void main(String[] args) {
        System.out.println("Khởi động JNotepad...");
        JNotepad app = new JNotepad("Notepad");
        app.setVisible(true);
        System.out.println("JNotepad đã hiển thị.");
    }

    public JTextArea getTxtEditor() {
        return txtEditor;
    }

    
}
