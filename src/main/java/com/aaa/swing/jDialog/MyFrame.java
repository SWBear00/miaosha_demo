package com.aaa.swing.jDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    public MyFrame() throws HeadlessException {
        System.out.println("开始创建-------------");
        //定义一个容器
        Container pane = getContentPane();
        //使用该窗体取消布局管理设置
        pane.setLayout(null);
        //在窗体中这只标签
        JLabel label = new JLabel("这是一个JFrame窗体");

        this.setSize(300,500);
        //将标签文字置于标签中间位置
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVisible(true);
        pane.add(label);
        //定义一个按钮
        JButton button = new JButton("弹出对话框");
        //定义按钮的尺寸
        button.setBounds(10,10,100,21);
        //为按钮添加点击事件
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //使myJDialog窗体可见
                        new MyJDialog(MyFrame.this).setVisible(true);
                    }
                }
        );
        //将按钮添加到容器中
        pane.add(button);
        System.out.println("结束创建-------------");

    }

    public void createMyFrame(String name){
        System.out.println("开始创建-------------");
        MyFrame myFrame = new MyFrame();
        myFrame.setTitle(name);
        //定义一个容器
        Container pane = myFrame.getContentPane();
        //使用该窗体取消布局管理设置
        pane.setLayout(null);
        //在窗体中这只标签
        JLabel label = new JLabel("这是一个JFrame窗体");

        myFrame.setSize(300,500);
        //将标签文字置于标签中间位置
        label.setHorizontalAlignment(SwingConstants.CENTER);
        myFrame.setVisible(true);
        pane.add(label);
        //定义一个按钮
        JButton button = new JButton("弹出对话框");
        //定义按钮的尺寸
        button.setBounds(10,10,100,21);
        //为按钮添加点击事件
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //使myJDialog窗体可见
                        new MyJDialog(MyFrame.this).setVisible(true);
                    }
                }
        );
        //将按钮添加到容器中
        pane.add(button);
        System.out.println("结束创建-------------");

    }
    public static void main(String[] args) {
       // new MyFrame().createMyFrame("这是一个JFrame窗体");
        new MyFrame();
    }
}
