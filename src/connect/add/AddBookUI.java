package connect.add;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookUI extends JFrame {
    private JTextField titleField;
    private JTextField publisherField;
    private JTextField authorField;
    private JTextField owner1Field;
    private JTextField owner2Field;
    private JTextField owner3Field;
    private JTextField booknumberField;

    public AddBookUI() {
        setTitle("插入书籍信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 320);
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

        JLabel lblPublisher = new JLabel("出版社:");
        lblPublisher.setBounds(30, 50, 80, 25);
        panel.add(lblPublisher);

        publisherField = new JTextField();
        publisherField.setBounds(120, 50, 200, 25);
        panel.add(publisherField);

        JLabel lblAuthor = new JLabel("作者:");
        lblAuthor.setBounds(30, 80, 80, 25);
        panel.add(lblAuthor);

        authorField = new JTextField();
        authorField.setBounds(120, 80, 200, 25);
        panel.add(authorField);

        JLabel lblOwner1 = new JLabel("所有者1:");
        lblOwner1.setBounds(30, 110, 80, 25);
        panel.add(lblOwner1);

        owner1Field = new JTextField();
        owner1Field.setBounds(120, 110, 200, 25);
        panel.add(owner1Field);

        JLabel lblOwner2 = new JLabel("所有者2:");
        lblOwner2.setBounds(30, 140, 80, 25);
        panel.add(lblOwner2);

        owner2Field = new JTextField();
        owner2Field.setBounds(120, 140, 200, 25);
        panel.add(owner2Field);

        JLabel lblOwner3 = new JLabel("所有者3:");
        lblOwner3.setBounds(30, 170, 80, 25);
        panel.add(lblOwner3);

        owner3Field = new JTextField();
        owner3Field.setBounds(120, 170, 200, 25);
        panel.add(owner3Field);

        JLabel lblnumber = new JLabel("书籍数量:");
        lblnumber.setBounds(30, 200, 80, 25);
        panel.add(lblnumber);

        booknumberField = new JTextField();
        booknumberField.setBounds(120, 200, 100, 25);
        panel.add(booknumberField);

        JButton btnSubmit = new JButton("提交");
        btnSubmit.setBounds(120, 240, 80, 25);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String title = titleField.getText();
            	String publisher = publisherField.getText();
            	String author = authorField.getText();
            	int booknumber = Integer.parseInt(booknumberField.getText());
            	String owner1 = owner1Field.getText();
            	String owner2 = owner2Field.getText();
            	String owner3 = owner3Field.getText();

            	AddBooksToDatabase.addNeedBook(title, publisher, author, booknumber, owner1, owner2, owner3);

                
                AddBooksToDatabase.addNeedBook(title, publisher, author, booknumber, owner1, owner2, owner3);
                JOptionPane.showMessageDialog(null, "书籍已成功添加！");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddBookUI ex = new AddBookUI();
                ex.setVisible(true);
            }
        });
    }
}


