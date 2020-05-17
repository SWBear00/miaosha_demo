package com.aaa.swing.icon;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {

    public MyImageIcon(){
        Container pane = getContentPane();//定义容器
        //创建标签
        JLabel  label = new JLabel("这是一个JFrame窗体", JLabel.CENTER);
        //获取图片的URL,以当前文件所在文件夹为基准
        URL url = MyImageIcon.class.getResource("/static/img/qq.jpg");
        System.out.println(url.toString());

        ImageIcon imageIcon = new ImageIcon(url);//实例化Icon对象
        //为标签设置图片
        label.setIcon(imageIcon);
        //设置文字放置在标签中
        label.setHorizontalAlignment(SwingConstants.CENTER);
        //设置标签为不透明状态
        label.setOpaque(true);
        //将标签添加到容器中
        pane.add(label);
        //设置窗体大小
        setSize(250,100);
        //设置窗体可见
        setVisible(true);
        //设置窗体关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyImageIcon();
    }
}
