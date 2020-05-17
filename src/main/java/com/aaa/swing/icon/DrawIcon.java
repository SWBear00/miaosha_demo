package com.aaa.swing.icon;

import javax.swing.*;
import java.awt.*;

/***
 * 图标的使用：Icon
 */
public class DrawIcon implements Icon {
    private  int width;
    private  int height;

    //定义构造方法
    public DrawIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        //绘制一个圆形
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    public static void main(String[] args) {
        DrawIcon icon = new DrawIcon(15,15);

        JLabel label = new JLabel("测试",icon,SwingConstants.CENTER);

        JFrame frame = new JFrame("Icon测试案例");

        //定义容器
        Container pane = frame.getContentPane();

        pane.add(label);

        frame.setSize(200,300);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
