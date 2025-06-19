package connect.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import connect.DatabaseConnector;
public class AdminLoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton; // 新增注册按钮

    public AdminLoginGUI() {
        super("管理员登录和注册");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField(10);
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(10);

        loginButton = new JButton("登录");
        registerButton = new JButton("注册"); // 初始化注册按钮

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // 空的占位
        add(loginButton);
        add(new JLabel()); // 空的占位
        add(registerButton); // 将注册按钮添加到界面

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // 验证管理员登录
                if (validateAdmin(username, password)) {
                	
                	
                	
                	
                    Arrays.fill(passwordChars, ' '); // 清空密码字符数组
                    dispose(); // 关闭登录窗口
                    openAdminMenu(); // 打开管理员操作界面
                } else {
                    Arrays.fill(passwordChars, ' '); // 清空密码字符数组
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // 验证输入是否合法
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "用户名和密码不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 注册管理员
                if (registerAdmin(username, password)) {
                    Arrays.fill(passwordChars, ' '); // 清空密码字符数组
                    JOptionPane.showMessageDialog(null, "注册成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Arrays.fill(passwordChars, ' '); // 清空密码字符数组
                    JOptionPane.showMessageDialog(null, "注册失败，用户名已存在", "注册失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    // 验证管理员登录
    private boolean validateAdmin(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValid = false;

        try {
            conn = DatabaseConnector.getConnection(); // 获取数据库连接

            // SQL 查询语句
            String sql = "SELECT * FROM admin_users WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // 执行查询
            rs = stmt.executeQuery();

            // 检查是否有匹配的管理员
            if (rs.next()) {
                isValid = true; // 找到匹配的管理员
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isValid;
    }

    // 注册新管理员
    private boolean registerAdmin(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;

        try {
            conn = DatabaseConnector.getConnection(); // 获取数据库连接
            // SQL 插入语句
            String sql = "INSERT INTO admin_users (username, password) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // 执行插入
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                isSuccess = true; // 注册成功
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return isSuccess;
    }

    

    private void openAdminMenu() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminMenuGUI(); // 打开管理员操作界面
            }
        });
    }

    public static void main(String[] args) {
        new AdminLoginGUI();
    }
}
