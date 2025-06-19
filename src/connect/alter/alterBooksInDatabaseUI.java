package connect.alter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alterBooksInDatabaseUI extends JFrame {
    private JTextField titleField;
    private JTextField publisherField;
    private JTextField authorField;
    private JTextField owner1Field;
    private JTextField owner2Field;
    private JTextField owner3Field;
    private JTextField bookIdField;
    private JTextField booknumberField;

    public alterBooksInDatabaseUI() {
        setTitle("修改书籍信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // Labels and TextFields for input fields
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

        JLabel lblBookId = new JLabel("书籍ID:");
        lblBookId.setBounds(30, 200, 80, 25);
        panel.add(lblBookId);

        bookIdField = new JTextField();
        bookIdField.setBounds(120, 200, 100, 25);
        panel.add(bookIdField);

        JLabel lblnumber = new JLabel("书籍数量:");
        lblnumber.setBounds(30, 230, 80, 25);
        panel.add(lblnumber);

        booknumberField = new JTextField();
        booknumberField.setBounds(120, 230, 100, 25);
        panel.add(booknumberField);

        // Submit button
        JButton btnSubmit = new JButton("提交");
        btnSubmit.setBounds(120, 260, 80, 25);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action performed when submit button is clicked
                String title = titleField.getText();
                String publisher = publisherField.getText();
                String author = authorField.getText();
                String owner1 = owner1Field.getText();
                String owner2 = owner2Field.getText();
                String owner3 = owner3Field.getText();
                int booknumber = Integer.parseInt(booknumberField.getText());
                int id = Integer.parseInt(bookIdField.getText());
                
                // Call method to alter books in database
                alterBooksInDatabase.alterbooks(title, publisher, author, owner1, owner2, owner3, booknumber, id);
                
                // Show success message
                JOptionPane.showMessageDialog(null, "修改操作完成");
            }
        });
    }

    public static void main(String[] args) {
        // Entry point of the program
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create instance of the UI and make it visible
                alterBooksInDatabaseUI ex = new alterBooksInDatabaseUI();
                ex.setVisible(true);
            }
        });
    }
}


