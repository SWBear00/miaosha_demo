package com.aaa.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * 边界布局管理器
 */
public class BorderLayoutPosition extends JFrame {
    //定义组件摆放位置的数组
    String[] border = {BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.WEST,BorderLayout.EAST};
    //定义按钮的名称数组
    String[] bottonName ={"center button","North button","South button","West button","East button"};

    //定义构造方法


    public BorderLayoutPosition() throws HeadlessException {
        //定义标题
        setTitle("这个窗体使用边界布局管理器");
        //定义一个容器
        Container c = getContentPane();
        //设置容器为边界布局管理器
        setLayout(new BorderLayout());
        for (int i = 0; i <border.length ; i++) {
            c.add(border[i],new JButton(bottonName[i]));
        }

        //设置窗体大小
        setSize(1500,1000);
        //设置窗体可见
        setVisible(true);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new BorderLayoutPosition();
    }
}
