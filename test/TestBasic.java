class TestBasic {
    public static void main(String[] args) {
        System.out.println("Basic Test");

        TestLoop loop1 = new TestLoop();
        loop1.testFor();

        TestArray array1 = new TestArray();
        array1.test1();
    }
}


// ループテストクラス
class TestLoop {
    public void testFor() {
        // 指定回数繰り返し
        for (int i=0; i<10; i++) {
            System.out.printf("for %d\n", i);
        }

        // 配列の要素数
        int[] intArray1 = {10,20,30,40,50,60,70,80,90,100};

        for (int i=0; i < intArray1.length; i++) {
            System.out.printf("for array %d\n", intArray1[i]);
        }
    }

    public void testWhile() {

    }
}


/**
* 配列のテスト
*/
class TestArray {
    public void test1() {
        //配列の宣言方法
        //型 変数名[] = new 型[要素数];
        //型[] 変数名 = new 型[要素数];

        int intArray[] = new int[10];
        int[] intArray2 = new int[10];

        // 初期値あり配列
        int array[] = {1,2,3,4,5};

        // 配列長を取得
        // 配列変数名.length
        int array2[] = new int[5];
        System.out.println(array2.length);

        // 配列の要素をコピー
        // cloneを使う
        int[] cloneSrc = {1,2,3,4,5};
        int[] cloneDst = cloneSrc.clone();
        dispIntArray("cloneSrc", cloneSrc);
        dispIntArray("cloneDst", cloneDst);

        // arrayCopyを使う
        // コピー本、コピー先の開始位置、コピー要素数を指定可能
        int[] arrayCopySrc = {1,2,3,4,5,6,7,8,9,10};
        int[] arrayCopyDst = new int[5];
        System.arraycopy(arrayCopySrc, 3, arrayCopyDst, 0, 5);
        dispIntArray("arrayCopyDst", arrayCopyDst);

        // 多次元配列
        // 要素の数は揃っていなくてもOK
        // 型名 配列変数名[][];
        // 配列変数名 = new 型名[要素数][];
        int seiseki[][] = new int[2][];
        int arrayM1[] = new int[10];
        int arrayM2[] = new int[20];
        seiseki[0] = arrayM1;
        seiseki[1] = arrayM2;

        // 多次元配列の初期値あり初期化
        int num[][] = {{10, 8, 5}, {9, 16, 4, 11}, {3, 7, 5}};
    }

    void dispIntArray(String title, int[] array) {
        System.out.println(title);
        for (int i=0; i<array.length; i++) {
            System.out.printf("%d\n", array[i]);
        }
    }
}

