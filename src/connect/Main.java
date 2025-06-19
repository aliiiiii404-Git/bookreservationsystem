package connect;
import javax.swing.*;

import connect.GUI.AdminLoginGUI;
import connect.GUI.TeacherLoginGUI;

import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class Main extends JFrame {
    private JButton adminButton;
    private JButton teacherButton;
    public Main() {
        super("教材征订系统");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        adminButton = new JButton("我是管理员");
        teacherButton = new JButton("我是老师");

        add(adminButton);
        add(teacherButton);

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminLoginGUI adminLogin = new AdminLoginGUI();
                adminLogin.setVisible(true);
            }
        });

        teacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeacherLoginGUI teacherLogin = new TeacherLoginGUI();
                teacherLogin.setVisible(true);
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
        


