interface interface01 {
	int hoge = 100;
	void test1();
	boolean test2(int val1);
}

class implClass1 implements interface01 {
	// interface01の実装
	public void test1() {
		System.out.println("hoge:" + hoge);
	}
	public boolean test2(int val1) {
		if (val1 > 100) {
			System.out.println(val1 + " is bigger than 100");
			return true;
		} else {
			System.out.println(val1 + " is less than 100 or equal");
			return true;
		}
	}
}


class test1{
	public static void main(String args[]){
		// 引数を出力
		 for (String s : args) {
            System.out.println(s);
        }

		implClass1 c1 = new implClass1();
		c1.test1();
		c1.test2(50);
		c1.test2(200);
	}
}

