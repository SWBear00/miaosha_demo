package com.aaa.swing.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JDialog;
public class TipWindow extends JDialog{
    private static final long serialVersionUID = 8541659783234673950L;
    //Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。该类与组件的某个属性关联。
    //由 Component 类和 LayoutManager 接口定义的一些方法将返回 Dimension 对象。
    private static Dimension dim;
    private int x, y;
    private int width, height;
    private static Insets screenInsets;

    public TipWindow(int width, int height) {
        this.width = width;
        this.height = height;

        dim = Toolkit.getDefaultToolkit().getScreenSize();
        screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(
                this.getGraphicsConfiguration());
        x = (int) (dim.getWidth() - width - 3);//提示框和电脑右下角之间的距离
        y = (int) (dim.getHeight() - screenInsets.bottom - 3);
        initComponents();
    }

    public void run() {
        for (int i = 0; i <= height; i += 10) {
            try {
                this.setLocation(x, y - i);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
        // 此处代码用来实现让消息提示框5秒后自动消失
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close();
    }

    private void initComponents() {
        this.setSize(width, height);
        this.setLocation(x, y);
        // this.setBackground(Color.cyan);不设置背景颜色
    }

    public void close() {
        x = this.getX();
        y = this.getY();
        int ybottom = (int) dim.getHeight() - screenInsets.bottom;
        for (int i = 0; i <= ybottom - y; i += 10) {
            try {
                setLocation(x, y + i);
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
        dispose();
    }
}
