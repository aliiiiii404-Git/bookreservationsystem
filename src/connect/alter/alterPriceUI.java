package connect.alter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alterPriceUI extends JFrame {
    private JTextField supplierField;
    private JTextField titleField;
    private JTextField priceField;
    private JTextField bookIdField;

    public alterPriceUI() {
        setTitle("修改书籍信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblSupplier = new JLabel("书籍供应商:");
        panel.add(lblSupplier);

        supplierField = new JTextField(20);
        panel.add(supplierField);

        JLabel lblTitle = new JLabel("书目名:");
        panel.add(lblTitle);

        titleField = new JTextField(20);
        panel.add(titleField);

        JLabel lblPrice = new JLabel("价格:");
        panel.add(lblPrice);

        priceField = new JTextField(20);
        panel.add(priceField);

        JLabel lblBookId = new JLabel("书籍ID:");
        panel.add(lblBookId);

        bookIdField = new JTextField(10);
        panel.add(bookIdField);

        JButton btnSubmit = new JButton("提交");
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String supplier = supplierField.getText();
                    String title = titleField.getText();
                    Double price = Double.parseDouble(priceField.getText());
                    int id = Integer.parseInt(bookIdField.getText());
                    alterPrice.alterprice(supplier, title, price, id);
                    JOptionPane.showMessageDialog(null, "修改成功");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "请输入有效的价格和书籍ID。");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "修改失败：" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                alterPriceUI ex = new alterPriceUI();
                ex.setVisible(true);
            }
        });
    }
}
