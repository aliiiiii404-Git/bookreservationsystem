package connect.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import connect.DatabaseConnector;
import connect.alter.alterBooksInDatabaseUI;
public class TeacherLoginGUI extends JFrame {
    private JTextField useremp_idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton; // 新增注册按钮

    public TeacherLoginGUI() {
        super("教师登录");
        setSize(300, 200); // 增加高度以容纳注册按钮
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2)); // 增加一个行来放置注册按钮
        
        JLabel usernameLabel = new JLabel("教工号:");
        useremp_idField = new JTextField(10);
        
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(10);
        
        loginButton = new JButton("登录");
        registerButton = new JButton("注册"); // 创建注册按钮
        
        add(usernameLabel);
        add(useremp_idField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // 空的占位
        add(loginButton);
        add(new JLabel()); // 空的占位
        add(registerButton); // 将注册按钮添加到界面中
        
        // 处理登录按钮点击事件
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int emp_id =Integer.parseInt(useremp_idField.getText());
                String password = new String(passwordField.getPassword());
                
                try {
                    // 获取数据库连接
                    Connection conn = DatabaseConnector.getConnection();
                    
                    // 准备查询
                    String query = "SELECT * FROM teachers WHERE emp_id = ? AND password = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, emp_id);
                    pstmt.setString(2, password);
                    
                    // 执行查询
                    ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        dispose(); // 关闭登录窗口
                        TeacherDemandGUI a= new TeacherDemandGUI ();
                        a.setVisible(true);// 打开需求书目界面
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    rs.close();
                    pstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "数据库连接错误", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // 处理注册按钮点击事件
        registerButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // 关闭当前窗口
                 setVisible(false);
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                    	 RegisterUI a = new RegisterUI();
                         a.setVisible(true);
                     }
                 });
             }
         });
        
        setVisible(true);
    }
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeacherLoginGUI();
            }
        });
    }
}

