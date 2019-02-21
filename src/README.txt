JAVA基础：
1.方法重载是指一个类中可以定义多个名称相同，参数不同(个数或类型同)的多个方法；调用时会根据不同的参数选择不同的方法。
1.1 参数个数不同
	void info() {
		System.out.println("My name is tom");
	}
	void info(String name) {
		System.out.println("My name is " + name);
	}
1.2 参数类型不同
	void max(int a, int b) {
		System.out.println("int:"+(a>b?a:b));
	}
	void max(short a, short b) {
		System.out.println("short:"+(a>b?a:b));
	}
1.3 编译会报方法名重复错误
	String info() {
		System.out.println("My name is tom");
	}
2.为了便于管理大型软件系统中数目众多的类，解决类的命名冲突问题，引入包（package）机制，提供类的多重命名空间。
