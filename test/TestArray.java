class TestArray {
    public static void main(String[] args) {
        System.out.println("Test Array!!");

        int mode = 0;
        if (args.length > 1) {
            mode = Integer.parseInt(args[1]);
        }

        TestArray testArray1 = new TestArray();
        switch (mode) {
            case 1:
                testArray1.test1();
                break;
            case 2:
                testArray1.test2();
                break;
            default:
                System.out.println("out of test mode " + String.valueOf(mode));
        }
    }
    public static void dispIntArray(String name, int[] array) {
        System.out.println(name);
        for (int val : array) {
            System.out.print(String.valueOf(val) + " ");
        }
        System.out.println("");
    }

    // ただの配列のテスト
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
        System.out.println(array.length);

        // 配列の要素をコピー
        // cloneを使う
        int[] cloneSrc = {1,2,3,4,5};
        int[] cloneDst = cloneSrc.clone();
        this.dispIntArray("cloneSrc", cloneSrc);
        this.dispIntArray("cloneDst", cloneDst);

        // arrayCopyを使う
        // コピー本、コピー先の開始位置、コピー要素数を指定可能
        int[] arrayCopySrc = {1,2,3,4,5,6,7,8,9,10};
        int[] arrayCopyDst = new int[5];
        System.arraycopy(arrayCopySrc, 3, arrayCopyDst, 0, 5);
        this.dispIntArray("arrayCopyDst", arrayCopyDst);

        // 多次元配列
        // 要素の数は揃っていなくてもOK
        // 型名 配列変数名[][];
        // 配列変数名 = new 型名[要素数][];
        int seiseki[][] = new int[2][];
        int array21[] = new int[10];
        int array22[] = new int[20];
        seiseki[0] = array21;
        seiseki[1] = array22;
         
        // 多次元配列の初期値あり初期化
        int num[][] = {{10, 8, 5}, {9, 16, 4, 11}, {3, 7, 5}};
        System.out.println("num[][]");
        int count = 0;
        for (int[] nameArray : names) {
            count++;
            this.dispIntArray("num" + String.valueOf(count), nameArray);
        }
    }

    public void test2() {

    }
}