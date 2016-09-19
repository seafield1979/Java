/* 文字列のテスト 
    Stringクラス

*/

class TestString1 {
    public static void main(String args[]) {
        TestString strTest1 = new TestString();
        strTest1.test1();
    }
}

class TestString {
    String str1;
    String strs[];

    TestString(){
        str1 = "hoge str1";
        strs = new String[10];
        for (int i=0; i<10; i++) {
            strs[i] = String.format("hoge_%03d", i);
        }
    }

    // 文字列の基本1
    public void test1() {
        String str1 = "hoge";
        str1 = "hoge1";
        String str2;
        str2 = "hoge2";
        String str3 = String.format("%s %d hoge2", str1, 100);
        String str4 = str1 + " " + str2;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }

    // 文字列の基本2
    // 文字列リテラルの正体はchar配列
    public void test2() {
        String _str1 = String.valueOf("abc");  // abcは char型の配列

        char[] charArray = {'a','b','c'};
        String _str2 = String.valueOf(charArray);  // 上記と同じ
        System.out.println(_str1);
        System.out.println(_str2);
    }

    // char[]とStringの相互変換
    public void test3() {
        // String -> char
        // String.toCharArray()を使用する
        String str = "Hello";
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
          System.out.println(ch);
        }

        // char -> String
        // String.valueOf()を使用する
        charArray[1] = 'a';
        String newStr = String.valueOf(charArray);
        System.out.println(newStr);
    }

    // 型の変換
    // 文字列　↔︎ 値
    public void test4() {
        // 文字列 -> 整数値
        int val1 = Integer.parseInt("123");

        // 整数値 -> 文字列
        String str1 = String.valueOf(100);

        System.out.printf("%d %s\n",val1, str1);
    }

    public void disp() {
        System.out.println(str1);
        for (int i=0; i<strs.length; i++) {
            System.out.printf("%s %d\n",strs[i],i);
        }
    }
}
