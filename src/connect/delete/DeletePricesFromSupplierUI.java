package connect.delete;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
public class DeletePricesFromSupplierUI extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private JTextField titleField;
    public DeletePricesFromSupplierUI() {
        setTitle("删除的书目对应价格");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("输入序号:");
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
            	String idStr = titleField.getText();
            	try {
            	    Integer id = Integer.parseInt(idStr);
            	    boolean deleted = DeletePricesFromSupplier.deletePricesByid(idStr);
            	    if (deleted) {
            	        JOptionPane.showMessageDialog(null, "该价目从数据库删除成功.");
            	    } else {
            	        JOptionPane.showMessageDialog(null, "未找到匹配的价目或删除失败.");
            	    }
            	} catch (NumberFormatException ex) {
            	    JOptionPane.showMessageDialog(null, "输入的ID不是有效的整数.");
            	}
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeletePricesFromSupplierUI deletePricesFromSupplierUI = new DeletePricesFromSupplierUI();
                deletePricesFromSupplierUI.setVisible(true);
            }
        });
    }
}
