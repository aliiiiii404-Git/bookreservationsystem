package connect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSuppliersFromDatabaseUI extends JFrame {
    private JTextField supplierField;
    private JTextField contactField;

    public AddSuppliersFromDatabaseUI() {
        setTitle("添加新供应商信息");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel lblSupplier = new JLabel("供应商名称:");
        supplierField = new JTextField(20);

        JLabel lblContact = new JLabel("联系方式:");
        contactField = new JTextField(20);

        JButton btnAddSupplier = new JButton("添加供应商");

        btnAddSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supplierName = supplierField.getText();
                String contactMethod = contactField.getText();
                // 在这里调用添加供应商的方法，传入供应商名称和联系方式
                AddSuppliersFromDatabase.addsuppliers(supplierName, contactMethod);
            }
        });

        JPanel panelSupplier = new JPanel();
        panelSupplier.add(lblSupplier);
        panelSupplier.add(supplierField);

        JPanel panelContact = new JPanel();
        panelContact.add(lblContact);
        panelContact.add(contactField);

        JPanel panelButton = new JPanel();
        panelButton.add(btnAddSupplier);

        add(panelSupplier);
        add(panelContact);
        add(panelButton);

        pack();
        setVisible(true);}}


