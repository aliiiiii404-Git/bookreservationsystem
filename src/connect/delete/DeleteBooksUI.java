package connect.delete;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBooksUI extends JFrame {
    private JTextField titleField;
    public DeleteBooksUI() {
        setTitle("删除的书籍信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("书籍标题:");
        lblTitle.setBounds(30, 20, 80, 25);
        panel.add(lblTitle);

        titleField = new JTextField();
        titleField.setBounds(120, 20, 200, 25);
        panel.add(titleField);

        JButton btnSubmit = new JButton("提交");
        btnSubmit.setBounds(120, 220, 80, 25);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText(); // Get text from titleField
                boolean deleted = DeleteBookFromDatabase.deleteBookByTitle(title); // Assuming a method to delete book by title
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "书籍从 needbooks 数据库删除成功.");
                } else {
                    JOptionPane.showMessageDialog(null, "未找到匹配的书籍或删除失败.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeleteBooksUI deleteBooksUI = new DeleteBooksUI();
                deleteBooksUI.setVisible(true);
            }
        });
    }
}
