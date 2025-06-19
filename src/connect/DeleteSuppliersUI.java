package connect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSuppliersUI extends JFrame {
    private JTextField titleField;
    public DeleteSuppliersUI() {
        setTitle("删除的供货商信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("供货商姓名:");
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
                String Sname = titleField.getText(); // Get text from titleField
                boolean deleted = DeleteSuppliersFromDatabase.deleteSuppliersByTitle(Sname); // Assuming a method to delete book by title
                if (deleted) {
                    JOptionPane.showMessageDialog(null, "供应商从 suppliers 数据库删除成功.");
                } else {
                    JOptionPane.showMessageDialog(null, "未找到匹配的供应商或删除失败.");
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeleteSuppliersUI deleteSuppliersUI = new DeleteSuppliersUI();
                deleteSuppliersUI.setVisible(true);
            }
        });
    }
}
