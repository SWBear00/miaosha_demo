package com.aaa.swing.jframe;

import javax.swing.*;
import java.awt.*;

public class Example extends JFrame {

    /**
     * 定义一个 创建面板的方法
     * @param title
     */
    public void createJFrame(String title){
        //定义一个面板对象
        JFrame jFrame = new JFrame(title);
        //根据对象获取一个容器
        Container contentPane = jFrame.getContentPane();

        //创建一个JLabel标签
        JLabel label = new JLabel("这是一个JFrame窗体");

        //使标签上的文字居中
        label.setHorizontalAlignment(SwingConstants.CENTER);
        //将标签添加到容器中
        contentPane.add(label);
        //设置容器的背景颜色
        contentPane.setBackground(Color.GREEN);
        //使窗体可见
        jFrame.setVisible(true);
        jFrame.setSize(200,150);
        //设置窗体关闭的方式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Example().createJFrame("创建的第一个JFrame窗口类");
    }
}
