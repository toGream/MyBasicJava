package org.zhongyiliang.cn;

/**
 * 测试类的访问控制
 * @author Administrator
 *
 */
public class TestAccess{
	public static void main(String[] args) {
		S s = new S();
		s.f();
	}
}

class T {
	private 	int n_private = 1;
				int n_friendly = 2;
    protected 	int n_protected = 3;
    public 		int n_public = 4;
}
class S extends T{
	public void f(){
		T t = new T();
		t.n_friendly = 10;
		System.out.println(t.n_friendly);
	}
}