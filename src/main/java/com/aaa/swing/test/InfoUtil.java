package com.aaa.swing.test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class InfoUtil {
    private Point oldP; // 上一次坐标,拖动窗口时用
    private TipWindow tw = null; // 提示框
    private ImageIcon img = null; // 图像组件
    private JLabel imgLabel = null; // 背景图片标签
    private JPanel headPan = null;
    private JPanel feaPan = null;
    private JPanel btnPan = null;
    private JLabel title = null; // 栏目名称
    private JLabel head = null; // 蓝色标题
    private JLabel close = null; // 关闭按钮
    private JTextArea feature = null; // 内容
    private JScrollPane jfeaPan = null;
    private JLabel releaseLabel = null; // 发布时间
    private JButton sure = null;
    private String titleT = null;
    private String word = null;
    private String time = null;

    // private SimpleDateFormat sdf = new
    // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void init() {
        // 新建300x220的消息提示框
        tw = new TipWindow(300, 180);
        //一个 Icon 接口的实现，它根据 Image 绘制 Icon。
        // img = new ImageIcon("./background.gif");//根据指定的 URL 创建一个 ImageIcon。
        img = new ImageIcon(InfoUtil.class.getResource("/static/img/qq.jpg"));//设置背景图片

                imgLabel = new JLabel(img);//创建具有指定图像的 JLabel 实例


        // 设置各个面板的布局以及面板中控件的边界
        headPan = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        title = new JLabel("告警提示:");
        head = new JLabel(titleT);
        close = new JLabel(" x");
        //JTextArea 是一个显示纯文本的多行区域。它作为一个轻量级组件，提供与 java.awt.TextArea 类的源兼容性，理应如此
        feature = new JTextArea(word);//文本信息
        //JScrollPane 管理视口、可选的垂直和水平滚动条以及可选的行和列标题视口
        jfeaPan = new JScrollPane(feature);
        // releaseLabel = new JLabel("发布于  " + time);
        sure = new JButton("关闭");//创建一个带文本的按钮。
        sure.setHorizontalAlignment(SwingConstants.CENTER);//设置图标和文本的水平对齐方式。 SwingConstants 通常用于在屏幕上定位或定向组件的常量的集合。
//        sure.setOpaque(true);
//        sure.setBackground(Color.ORANGE);
        // 将各个面板设置为透明，否则看不到背景图片 getContentPane() 返回此对话框的 contentPane 对象。 。contentPane 应该是所有 JDialog 子组件的父级
        ((JPanel) tw.getContentPane()).setOpaque(false);
        //输出false，表示是透明的
        System.err.println( ((JPanel)tw.getContentPane()).isOpaque());
        headPan.setOpaque(false);
        feaPan.setOpaque(false);
        btnPan.setOpaque(false);


        // 设置JDialog的整个背景图片
        tw.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        System.out.println(img.getIconHeight());
        //headPan.setPreferredSize(new Dimension(300,10));

        // 设置提示框的边框,宽度和颜色
        //重量级”组件（指委托给主机系统上的同位体或本地组件的组件）用较暗的、更重的框来显示
        tw.getRootPane().setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        title.setPreferredSize(new Dimension(260, 26));
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setFont(new Font("宋体", Font.PLAIN, 12));
        title.setForeground(Color.black);

        close.setFont(new Font("Arial", Font.BOLD, 15));
        close.setPreferredSize(new Dimension(20, 20));
        close.setVerticalTextPosition(JLabel.CENTER);
        close.setHorizontalTextPosition(JLabel.CENTER);
        close.setCursor(new Cursor(12));
        close.setToolTipText("关闭");

        head.setPreferredSize(new Dimension(250, 35));
        head.setVerticalTextPosition(JLabel.CENTER);
        head.setHorizontalTextPosition(JLabel.CENTER);
        head.setFont(new Font("宋体", Font.PLAIN, 14));
        head.setForeground(Color.black);

        feature.setEditable(false);
        feature.setForeground(Color.BLACK);
        feature.setFont(new Font("宋体", Font.PLAIN, 14));
        feature.setBackground(new Color(255, 255, 255));
        // 设置文本域自动换行
        feature.setLineWrap(true);
        //白色边框内容块大小
        jfeaPan.setPreferredSize(new Dimension(280, 100));//300,180
        jfeaPan.setBorder(null);
        jfeaPan.setBackground(Color.black);

        // releaseLabel.setForeground(Color.DARK_GRAY);
        // releaseLabel.setFont(new Font("宋体", Font.PLAIN, 12));

        // 为了隐藏文本域，加个空的JLabel将他挤到下面去
        JLabel jsp = new JLabel();
        jsp.setPreferredSize(new Dimension(300, 25));

        sure.setPreferredSize(new Dimension(60, 30));
        // 设置标签鼠标手形
        sure.setCursor(new Cursor(12));

        headPan.add(title);
        //headPan.add(head);
        //headPan.add(close);

        //feaPan.add(jsp);
        feaPan.add(jfeaPan);
        //feaPan.add(releaseLabel);

        btnPan.add(sure);

        tw.add(headPan, BorderLayout.NORTH);
        tw.add(feaPan, BorderLayout.CENTER);
        tw.add(btnPan, BorderLayout.SOUTH);
    }

    public void handle() {
        // 为更新按钮增加相应的事件
        sure.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // JOptionPane.showMessageDialog(tw, "谢谢，再见");
                tw.close();
            }

            public void mouseEntered(MouseEvent e) {
                sure.setBorder(BorderFactory.createLineBorder(Color.gray));
            }

            public void mouseExited(MouseEvent e) {
                sure.setBorder(null);
            }
        });
        // 增加鼠标拖动事件
        title.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                Point newP = new Point(e.getXOnScreen(), e.getYOnScreen());
                int x = tw.getX() + (newP.x - oldP.x);
                int y = tw.getY() + (newP.y - oldP.y);
                tw.setLocation(x, y);
                oldP = newP;
            }
        });
        // 鼠标按下时初始坐标,供拖动时计算用
        title.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldP = new Point(e.getXOnScreen(), e.getYOnScreen());
            }
        });
        // 右上角关闭按钮事件
        close.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tw.close();
            }

            public void mouseEntered(MouseEvent e) {
                close.setBorder(BorderFactory.createLineBorder(Color.gray));
            }

            public void mouseExited(MouseEvent e) {
                close.setBorder(null);
            }
        });
    }

    public void show(String titleT, String word) {
        this.titleT = titleT;
        this.word = word;
        // time = sdf.format(new Date());
        init();
        handle();
        tw.setAlwaysOnTop(true);
        tw.setUndecorated(true);
        tw.setResizable(false);
        tw.setVisible(true);
        tw.run();
    }

    public void close() {
        tw.close();
    }
    public static void main(String[] args) {
        InfoUtil util= new InfoUtil();
        util.show("我是中国人","hehe额鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅鹅");
    }
}