package connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherLoginGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public TeacherLoginGUI() {
        super("教师登录");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField(10);

        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(10);

        loginButton = new JButton("登录");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // 空的占位
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("teacher") && password.equals("123")) {
                    dispose(); // 关闭登录窗口
                    openteacherDemandGUI(); // 打开需求书目界面
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private void openteacherDemandGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeacherDemandGUI();
            }
        });
    }}
