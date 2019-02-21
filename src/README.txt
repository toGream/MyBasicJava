JAVA基础：
1.方法重载是指一个类中可以定义多个名称相同，参数不同(个数或类型同)的多个方法；调用时会根据不同的参数选择不同的方法。
	--1.1 参数个数不同
		void info() {
			System.out.println("My name is tom");
		}
		void info(String name) {
			System.out.println("My name is " + name);
		}
	--1.2 参数类型不同
		void max(int a, int b) {
			System.out.println("int:"+(a>b?a:b));
		}
		void max(short a, short b) {
			System.out.println("short:"+(a>b?a:b));
		}
	--1.3 编译会报方法名重复错误
		String info() {
			System.out.println("My name is tom");
		}
		
2.为了便于管理大型软件系统中数目众多的类，解决类的命名冲突问题，引入包（package）机制，提供类的多重命名空间。
	--2.1 package命名（若缺省该语句，则指定为无名包）
		com.zhongyiliang.test1
		域名.公司名.部门名.项目名
	--2.2 Java编译器把包对应于文件系统的目录管理，package语句中，用‘.’来指明包（目录）的层次
		package com.zhongyiliang.test1
		则该文件中所在的类位于.\com\zhongyiliang\test目录下
	--2.3 访问同一个包中的类不需要引入
	--2.4 其他类需要访问另外一个不同父目录不同的类，
		另外一个class文件的最上层的父目录位于classpath（在环境变量中指定该目录）
	--2.5 执行一个类需要切换到包名父目录，并且需要写全包名.类
	            如果想在任意目录执行  包名.类需要指定classpath：所在包的父目录
	--2.6 jdk lib目录下rt.jar包含了jdk常用的类，其中java.lang目录下的类不需要使用import引入，直接可以使用。
	--2.7 把自己的类打成jar包
	    ----先定位到包的上层目录
	    ----命令: jar -cvf xxxxx.jar 需要打包的目录
	--2.8 把自己的类打成jar包后设置到classpath
	    ----jar父路径+xxxxx.jar

3.访问控制
       修饰符                    类内部            同一个包           子类        任何地方
  private    Yes     
  default    Yes     Yes  
  protected  Yes     Yes      Yes
  public     Yes     Yes      Yes   Yes 
  --3.1对应class的权限修饰只可以用public和default

4.类的继承
	--4.1 java中使用extends关键字实现类的继承机制
	--4.2   通过继承，子类自动拥有基类的（supperclass）的所有成员（成员变量和方法），
	                  除了private的。
	--4.3 java只允许单继承：一个类只能有一个基类，一个基类可以派生多个子类。	  
		备注1：所谓的继承就是子类包含了父类对象+自己的成员 ，new子类对象其实也就是调用了父类对象的成员。
		备注2：注意子类可以继承基类的所有成员   与  子类对于基类对象直接访问其成员变量的访问控制区别。

5.类的重写
    --5.1 子类中可以根据需要对基类中继承过来的方法进行重写：
                              重写方法必须与被重写方法具有相同的方法名称，参数列表和返回类型；
                              重写方法不能使用比被重写方法更严格的访问权限。
   	  
6.super关键字
    --6.1 super类似this关键字，this指向的是本身，而super指向的是父类。
    --6.2 当父类的方法已经实现了一部分功能时，就不需要重写父类的方法，在子类中定义一个父类相同的方法，
                              然后通过super调用父类方法，后面在写子类对应的逻辑。
       class FatherClass{
			public int value;
			public void f() {
				value = 100;
				System.out.println("FatherClass.value="+value);
			}
		}
		class ChildClass extends FatherClass{
			public int value;
			public void f() {
				super.f();
				value = 200;
				System.out.println("ChildClass.value="+value);
				System.out.println(value);
				System.out.println(super.value);
			}
		}                    

7. 继承中的构造方法
	--7.1 子类的构造过程中必须调用其基类的构造方法。
	--7.2 子类可以在自己的构造方法中使用super(argument_list)调用基类的构造方法
		----使用this(argument_list)调用本类的另外的构造方法
		----如果调用super，必须写在子类构造方法的第一行
	--7.3如果子类的构造方法中没有显示的调用基类构造方法，则系统默认调用基类无参数构造方法
	--7.4如果子类构造方法中既没有显示调用基类构造方法，而基类又没有无参数构造方法，则编译错误。	
		
8. 动态绑定|多态（动态绑定是指“在执行期间（而非编译期间）”判断所引用对象的实际类型，根据其实际类型调用其对应的方法）
	--8.1 多态
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
	--8.2多态的三个必要条件
		----要有继承
		----要有重写
		----父类引用指向子类对象，实际new 的那个对象就调用那个对象的方法		
		
9. 抽象类|不完整的类（用abstract关键字来修饰一个类时，这个类叫做抽象类；用abstract来修饰一个方法时，该方法叫做抽象方法。）
	--9.1 含有抽象方法的类必须被声明为抽象类，抽象类必须被继承，抽象方法必须被重写
	--9.2抽象类不能实例化
	--9.3抽象方法只需声明，而不需实现	
		
10. final关键字

11. 接口			