package connect.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import connect.add.AddBookUI;
import connect.add.AddPricesFromSupplierUI;
import connect.add.AddSuppliersFromDatabaseUI;
import connect.alter.alterBooksInDatabaseUI;
import connect.alter.alterPrice;
import connect.alter.alterPriceUI;
import connect.alter.alterSupplier;
import connect.alter.alterSupplierUI;
import connect.delete.DeleteBooksUI;
import connect.delete.DeletePricesFromSupplierUI;
import connect.delete.DeleteSuppliersUI;
import connect.query.QueryBooksFromDatabase;
import connect.query.QueryPricesFromSuppliers;
import connect.query.QuerySuppliersFromDatabase;
public class AdminMenuGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton queryBooksButton;
    private JButton querySuppliersButton;
    private JButton queryPricesButton;
    private JButton alterBooksButton;
    private JButton alterSuppliersButton;
    private JButton alterPricesButton;
    private JButton deleteBooksButton;
    private JButton deleteSuppliersButton;
    private JButton deletePricesButton;
    private JButton addBooksButton;
    private JButton addSuppliersButton;
    private JButton addPricesButton;

    public AdminMenuGUI() {
        super("管理员操作界面");
        setSize(400, 400); // 增加高度以适应更多按钮
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3)); // 调整为4行3列的网格布局

        queryBooksButton = new JButton("查询当前所需书目");
        querySuppliersButton = new JButton("查询书本商");
        queryPricesButton = new JButton("查询书目价格");

        alterBooksButton = new JButton("修改当前所需书目");
        alterSuppliersButton = new JButton("修改书本商");
        alterPricesButton = new JButton("修改书目价格");

        deleteBooksButton = new JButton("删除当前所需书目");
        deleteSuppliersButton = new JButton("删除对应书本商");
        deletePricesButton = new JButton("删除对应书目价格");

        addBooksButton = new JButton("增加当前所需书目");
        addSuppliersButton = new JButton("增加对应书本商");
        addPricesButton = new JButton("增加对应书目价格");

        // 将按钮按照网格布局添加到窗口中
        add(queryBooksButton);
        add(querySuppliersButton);
        add(queryPricesButton);
        add(alterBooksButton);
        add(alterSuppliersButton);
        add(alterPricesButton);
        add(deleteBooksButton);
        add(deleteSuppliersButton);
        add(deletePricesButton);
        add(addBooksButton);
        add(addSuppliersButton);
        add(addPricesButton);
        // 添加按钮的事件监听器
        queryBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用数据库方法查询书目列表，并显示
                String bookList = QueryBooksFromDatabase.queryBooksFromDatabase(); // 假设这是查询书目的方法
                JOptionPane.showMessageDialog(null, "书目列表：" + bookList);
            }
        });
        querySuppliersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用数据库方法查询书目商家，并显示
                String supplierList = QuerySuppliersFromDatabase.queryBooksFromDatabase(); // 假设这是查询书目商家的方法
                JOptionPane.showMessageDialog(null, "书目商家：" + supplierList);
            }
        });
        queryPricesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用数据库方法查询书目价格，并显示
                String priceList = 	QueryPricesFromSuppliers.queryBooksFromDatabase(); // 假设这是查询书目价格的方法
                JOptionPane.showMessageDialog(null, "书目价格：" + priceList);
            }
        });

        alterBooksButton.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
             // 关闭当前窗口
             setVisible(false);
             // 创建并显示输入书籍信息的界面
             SwingUtilities.invokeLater(new Runnable() {
                 public void run() {
                	alterBooksInDatabaseUI a = new alterBooksInDatabaseUI();
                     a.setVisible(true);
                 }
             });
         }
     });

        alterSuppliersButton.addActionListener(new ActionListener() {
         	 public void actionPerformed(ActionEvent e) {
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                    	alterSupplierUI a = new alterSupplierUI();
                         a.setVisible(true);
                     }
                 });
             }
         });
        alterPricesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 关闭当前窗口
             //   setVisible(false);
                // 创建并显示输入书籍信息的界面
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                   	alterPriceUI a= new alterPriceUI();
                        a.setVisible(true);
                    }
                });
            }
        });
        deleteBooksButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // 关闭当前窗口
                 setVisible(false);
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                    	 DeleteBooksUI a = new DeleteBooksUI();
                         a.setVisible(true);
                     }
                 });
             }
         });

        deleteSuppliersButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // 关闭当前窗口
                 setVisible(false);
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                    	 DeleteSuppliersUI a = new DeleteSuppliersUI();
                         a.setVisible(true);
                     }
                 });
             }
         });

        deletePricesButton.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
             // 关闭当前窗口
             setVisible(false);
             // 创建并显示输入书籍信息的界面
             SwingUtilities.invokeLater(new Runnable() {
                 public void run() {
                	 DeletePricesFromSupplierUI a = new DeletePricesFromSupplierUI();
                     a.setVisible(true);
                 }
             });
         }
     });

        addBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 关闭当前窗口
                setVisible(false);
                // 创建并显示输入书籍信息的界面
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        AddBookUI a = new AddBookUI();
                        a.setVisible(true);
                    }
                });
            }
        });
        addSuppliersButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // 关闭当前窗口
                 setVisible(false);
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                    	 AddSuppliersFromDatabaseUI a = new AddSuppliersFromDatabaseUI();
                         a.setVisible(true);
                     }
                 });
             }
         });
        addPricesButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // 关闭当前窗口
                 setVisible(false);
                 // 创建并显示输入书籍信息的界面
                 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                     	AddPricesFromSupplierUI a = new AddPricesFromSupplierUI();
                         a.setVisible(true);
                     }
                 });
             }
         });

        // 设置窗口可见
        setVisible(true);
    }

    public  void a (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminMenuGUI(); // 启动管理员操作界面
            }
        });
    }
}
