package connect.alter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alterSupplierUI extends JFrame {
    private JTextField snameField;
    private JTextField contactmethodField;

    public alterSupplierUI() {
        setTitle("修改供应商联系方式");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblSname = new JLabel("供应商名:");
        lblSname.setBounds(30, 20, 80, 25);
        panel.add(lblSname);

        snameField = new JTextField();
        snameField.setBounds(120, 20, 200, 25);
        panel.add(snameField);

        JLabel lblContactMethod = new JLabel("联系方式:");
        lblContactMethod.setBounds(30, 50, 80, 25);
        panel.add(lblContactMethod);

        contactmethodField = new JTextField();
        contactmethodField.setBounds(120, 50, 200, 25);
        panel.add(contactmethodField);

        JButton btnSubmit = new JButton("提交");
        btnSubmit.setBounds(120, 220, 80, 25);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sname = snameField.getText();
                String contactmethod = contactmethodField.getText();
                
                // 调用供应商信息更新方法
                alterSupplier.altersupplier(Sname, contactmethod);
                
                JOptionPane.showMessageDialog(null, "供应商信息修改成功");
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                alterSupplierUI ex = new alterSupplierUI();
                ex.setVisible(true);
            }
        });
    }
}



