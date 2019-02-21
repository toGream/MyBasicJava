package org.zhongyiliang.cn;

/**
 * 方法重载
 * @author Administrator
 *
 */
public class OverloadBean {
	void info() {
		System.out.println("My name is tom");
	}
	
	void info(String name) {
		System.out.println("My name is " + name);
	}
	
	void max(int a, int b) {
		System.out.println("int:"+(a>b?a:b));
	}
	
	void max(short a, short b) {
		System.out.println("short:"+(a>b?a:b));
	}
	
	void max(float a, float b) {
		System.out.println("float:"+(a>b?a:b));
	}
	
	public static void main(String[] args) {
		OverloadBean p = new OverloadBean();
		p.info();
		p.info("jerry");
		p.max(2.1f, 3.0f);
		p.max(1, 2);
		p.max(100, 400);
		short a = 3;
		short b = 4;
		p.max(a, b);
	}
}
