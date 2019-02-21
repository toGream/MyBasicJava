package org.zhongyiliang.cn;

class Animals{
	private String name;
	Animals(String name){
		this.name = name;
	}
	public void enjoy() {
		System.out.println("叫声......");
	}
}
class Cats extends Animals{
	private String eyesColor;
	Cats(String name, String eyesColor){
		super(name);
		this.eyesColor = eyesColor;
	}
	public void enjoy() {
		System.out.println("猫叫声......");
	}
}
class Dogs extends Animals{
	private String eyesColor;
	Dogs(String name, String eyesColor){
		super(name);
		this.eyesColor = eyesColor;
	}
	public void enjoy() {
		System.out.println("狗叫声......");
	}
}
class Lady{
	private String name;
	private Animals pet;
	Lady(String name, Animals pet){
		this.name = name;
		this.pet = pet;
	}
	public void myPetEnjoy() {
		this.pet.enjoy();
	}
}

public class TestPolymorphicBean {
	public static void main(String[] args) {
		Cats c = new Cats("catname","blue");
		Dogs d = new Dogs("dogname","black");
		Lady l1 = new Lady("l1",c);
		Lady l2 = new Lady("l2",d);
		l1.myPetEnjoy();
		l2.myPetEnjoy();
	}
}
