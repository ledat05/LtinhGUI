/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class ComboBoxExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JComboBox Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new FlowLayout());

            // Tạo JComboBox
            JComboBox<String> comboBox = new JComboBox<>();

            // Thư mục gốc để lấy danh sách thư mục con
            File rootDirectory = new File("C:\\your_directory"); // Thay đổi đường dẫn đến thư mục của bạn

            // Lấy danh sách thư mục và thêm vào JComboBox
            if (rootDirectory.isDirectory()) {
                File[] directories = rootDirectory.listFiles(File::isDirectory);
                if (directories != null) {
                    for (File dir : directories) {
                        comboBox.addItem(dir.getName()); // Thêm tên thư mục vào JComboBox
                    }
                }
            }

            frame.add(comboBox);
            frame.setVisible(true);
        });
    }
}


