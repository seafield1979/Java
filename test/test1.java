class JSample2_1{
  public static void main(String args[]){
    char[] moji;
    moji = new char[2];

    moji[0] = 'A';
    moji[1] = 'm';

    for (int i = 0; i < 2; i++){
      System.out.println(moji[i]);
    }
  }
}


class Calc{
	int result;

	void plus(int val1, int val2){
	  result = val1 + val2;
	}
	void disp(){
		System.out.println("result=" + result);
	}
}

class ArrayTest{
	void test1(){
		int array[][] = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<array.length; i++){
			int[] array2 = array[i];
			for(int j=0; j<array2.length; j++){
				System.out.println(array2[j]);
			}
		}
	}
}

class test1{
	public static void main(String args[]){
		Calc calc = new Calc();
		calc.plus(1,2);
		calc.disp();

		ArrayTest array = new ArrayTest();
		array.test1();
	}
}