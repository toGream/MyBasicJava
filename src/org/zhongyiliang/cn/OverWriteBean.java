package org.zhongyiliang.cn;

/**
 * 方法重写
 * @author Administrator
 *
 */
public class OverWriteBean {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.run();
		Dog d = new Dog();
		d.run();
	}
}
class Animal{
	public void run() {
		System.out.println("Animal......");
	}
}

class Cat extends Animal{

	@Override
	public void run() {
		System.out.println("Cat......");
	}
}

class Dog extends Animal{
	@Override
	public void run() {
		System.out.println("Dog......");
	}
}