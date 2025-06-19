package connect.GUI;
import javax.swing.*;

import connect.DatabaseConnector;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDemandGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField booknameField;
    private JTextField booknumberField;

    public TeacherDemandGUI() {
        super("老师需求书目");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel booknameLabel = new JLabel("所需书目名:");
        booknameField = new JTextField(10);
        JLabel booknumberLabel = new JLabel("书目数量:");
        booknumberField = new JTextField(10);

        panel.add(booknameLabel);
        panel.add(booknameField);
        panel.add(booknumberLabel);
        panel.add(booknumberField);

        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookname = booknameField.getText();
                int booknumber = Integer.parseInt(booknumberField.getText()); // 转换为整数

                // 将数据插入数据库
                addNeedBook(bookname, booknumber);

                JOptionPane.showMessageDialog(null, "需求已提交:\n书目名: " + bookname + "\n书目数量: " + booknumber,
                        "提交成功", JOptionPane.INFORMATION_MESSAGE);

                dispose(); // 关闭窗口
            }
        });

        panel.add(new JLabel()); // 占位，保持布局整齐
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    // 添加书目需求到数据库
    private void addNeedBook(String bookname, int booknumber) {
        String sql = "INSERT INTO needbooks (title, booknumber) VALUES (?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, bookname);
            pstmt.setInt(2, booknumber);
            pstmt.executeUpdate();

            System.out.println("成功将书目需求添加到数据库。");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据插入失败，请重试。", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // 在主方法中启动 GUI
        SwingUtilities.invokeLater(() -> new TeacherDemandGUI());
    }
}

        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookname = booknameField.getText();
                int booknumber = Integer.parseInt(booknumberField.getText());
                // 在这里添加提交逻辑，例如将书目名和数量保存到文件或数据库中
                JOptionPane.showMessageDialog(null, "需求已提交:\n书目名: " + bookname + "\n书目数量: " + booknumber,
                        "提交成功", JOptionPane.INFORMATION_MESSAGE);
                // 这里可以添加关闭窗口的逻辑
                dispose();
            }
        });
        panel.add(new JLabel()); // 占位，保持布局整齐
        panel.add(submitButton);
        add(panel);
        setVisible(true);
    }}

   

