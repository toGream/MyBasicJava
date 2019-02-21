package org.zhongyiliang.cn;

/**
 * 类的继承
 * @author Administrator
 *
 */
class Human {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Student extends Human{
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
public class Test{
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Tom");
		student.setAge(18);
		student.setSchool("SCH");
		System.out.println(student);
	}
}
