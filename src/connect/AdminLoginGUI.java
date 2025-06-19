package connect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLoginGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public  AdminLoginGUI() {
        super("管理员登录");
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

                // 在实际应用中，这里可以添加验证逻辑，例如检查管理员用户名和密码是否正确
                if (username.equals("admin") && password.equals("123")) {
                    dispose(); // 关闭登录窗口
                    openAdminMenu(); // 打开管理员操作界面
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
    private void openAdminMenu() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminMenuGUI(); // 打开管理员操作界面
            }
        });
    }}

