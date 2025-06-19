package connect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class AddPricesFromSupplierUI extends JFrame {
	    private JFrame frame;
	    private JTextField supplierField;
	    private JTextField titleField;
	    private JTextField priceField;
	    public AddPricesFromSupplierUI() {
	        frame = new JFrame();
	        frame.setTitle("添加书籍价格信息");
	        frame.setBounds(100, 100, 400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        JLabel lblSupplier = new JLabel("供应商：");
	        lblSupplier.setBounds(50, 30, 80, 20);
	        frame.getContentPane().add(lblSupplier);

	        supplierField = new JTextField();
	        supplierField.setBounds(150, 30, 200, 20);
	        frame.getContentPane().add(supplierField);
	        supplierField.setColumns(10);

	        JLabel lblTitle = new JLabel("书名：");
	        lblTitle.setBounds(50, 70, 80, 20);
	        frame.getContentPane().add(lblTitle);

	        titleField = new JTextField();
	        titleField.setBounds(150, 70, 200, 20);
	        frame.getContentPane().add(titleField);
	        titleField.setColumns(10);

	        JLabel lblPrice = new JLabel("价格：");
	        lblPrice.setBounds(50, 110, 80, 20);
	        frame.getContentPane().add(lblPrice);

	        priceField = new JTextField();
	        priceField.setBounds(150, 110, 200, 20);
	        frame.getContentPane().add(priceField);
	        priceField.setColumns(10);

	        JButton btnAddBook = new JButton("添加书籍");
	        btnAddBook.setBounds(150, 190, 100, 30);
	        frame.getContentPane().add(btnAddBook);

	        btnAddBook.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String supplier = supplierField.getText();
	                String title = titleField.getText();
	                double price = Double.parseDouble(priceField.getText());

	                // 调用添加书籍元组的方法
	                AddPricesFromSuppliers.addbookprices(supplier, title, price);
	            }
	        });
	    }
	    public void show() {
	        frame.setVisible(true);
	    }


	}

