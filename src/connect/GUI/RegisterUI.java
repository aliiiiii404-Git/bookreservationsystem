package connect.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connect.DatabaseConnector;
public class RegisterUI extends JFrame {
    private JTextField empIdField;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JTextField departmentField;
    private JTextField joinDateField;
    private JButton registerButton;
    private DatabaseConnector connector;
    public RegisterUI() {
        setTitle("教师注册");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建数据库连接
        connector = new DatabaseConnector();
        // 创建组件
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        JLabel empIdLabel = new JLabel("教师编号:");
        empIdField = new JTextField();
        JLabel nameLabel = new JLabel("姓名:");
        nameField = new JTextField();
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField();
        JLabel departmentLabel = new JLabel("部门:");
        departmentField = new JTextField();
        JLabel joinDateLabel = new JLabel("加入日期(YYYY-MM-DD):");
        joinDateField = new JTextField();
        registerButton = new JButton("注册");
        // 添加组件到面板
        panel.add(empIdLabel);
        panel.add(empIdField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(departmentLabel);
        panel.add(departmentField);
        panel.add(joinDateLabel);
        panel.add(joinDateField);
        panel.add(registerButton);
        // 注册按钮点击事件处理
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerTeacher();
            }
        });

        // 将面板添加到窗口
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // 注册教师到数据库
    private void registerTeacher() {
        String empId = empIdField.getText().trim();
        String name = nameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String department = departmentField.getText().trim();
        String joinDateStr = joinDateField.getText().trim();
        // 简单的输入验证
        if (empId.isEmpty() || name.isEmpty() || password.isEmpty() || department.isEmpty() || joinDateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "所有字段都不能为空");
            return;
        }
        try {
            int empIdInt = Integer.parseInt(empId);
            Date joinDate = Date.valueOf(joinDateStr);
            Connection conn = connector.getConnection();
            String sql = "INSERT INTO teachers (emp_id, name, password, department, join_date) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, empIdInt);
                pstmt.setString(2, name);
                pstmt.setString(3, password);
                pstmt.setString(4, department);
                pstmt.setDate(5, joinDate);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "教师注册成功");
                // 清空输入框
                empIdField.setText("");
                nameField.setText("");
                passwordField.setText("");
                departmentField.setText("");
                joinDateField.setText("");
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "教师注册失败: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterUI();
            }
        });
    }
}
