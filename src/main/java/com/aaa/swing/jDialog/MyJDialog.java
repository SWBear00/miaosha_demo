package com.aaa.swing.jDialog;

import javax.swing.*;
import java.awt.*;

/**
 * JDialog类:弹出框
 */
public class MyJDialog extends JDialog {

    public MyJDialog(Frame owner) {
        //实例化一个JDialog类对象，制定对话框的父窗体、窗体标题、类型
        super(owner,"第一个jdialog窗体",true);
        //创建一个容器
        Container pane = getContentPane();
        //容器中添加弹出框
        pane.add(new JLabel("这是一个对话框"));
        //设置对话框大小
        setBounds(120,120,100,100);
    }
}

