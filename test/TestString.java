/* 文字列のテスト 
    Stringクラス

*/

class TestString1 {
    public static void main(String args[]) {
        TestString strTest1 = new TestString();

        int mode = 0;
        if (args.length >= 2) {
            mode = Integer.parseInt(args[1]);
        }
        System.out.println(String.valueOf(mode));

        switch (mode) {
            case 1:
                strTest1.test1();
                break;
            case 2:
                strTest1.test2();
                break;
            case 3:
                strTest1.test3();
                break;
            case 4:
                strTest1.test4();
                break;
            case 5:
                strTest1.test5();
                break;
            case 6:
                strTest1.test6();
                break;
        }
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

    // Stringのメソッド
    public void test5() {
        String str = "01234567890";
        String str2 = "this is an apple!";

        // 文字列が同じかどうかチェックする equals(Object)
        System.out.println("- equals");
        boolean ret = "hoge".equals("hoge");
        System.out.println(ret);

        // 指定位置の文字を抜き出す  charAt(int:pos)
        System.out.println("- charAt");
        for (int i=0; i<str.length(); i++) {
            System.out.println(String.valueOf(str.charAt(i)));
        }

        // 文字列の切り出し substring(int:start,int:end)
        System.out.println("- substring");
        String substr = str.substring(3,6);
        System.out.println(substr);

        // 検索文字列が見つかった位置を返す indexOf(String:searchStr)
        System.out.println("- indexOf");
        int pos = str.indexOf("67");
        System.out.println(str.substring(pos));

        pos = str.indexOf("hoge");  // 見つからない文字列
        System.out.println(String.valueOf(pos));  // -1

        // 文字列の結合 concat(String)
        System.out.println("- concat");
        String concat1 = str.concat("_concat!");
        System.out.println(concat1);

        // 先頭、末尾の文字列が一致しているかをチェック endsWith(String) startWith(String)
        System.out.println("- startsWith, endsWith");
        System.out.println(String.valueOf(str.startsWith("012")));
        System.out.println(String.valueOf(str.endsWith("890")));

    }

    // StringBuffer
    public void test6() {
        // StringBuffer生成
        StringBuffer strbuf1 = new StringBuffer();
        StringBuffer strbuf2 = new StringBuffer("01234567890");

        // 文字列を追加する append
        System.out.println("- append");
        StringBuffer strbuf3 = new StringBuffer("hoge");
        strbuf3.append(" hoge!");
        System.out.println(strbuf3);

        strbuf3.append(100);
        System.out.println(strbuf3);

        // 指定位置を削除する delete(int:start, int:end);
        System.out.println("- delete");
        strbuf3.delete(1,3);
        System.out.println(strbuf3);

        // 文字列（その他）を挿入する insert(int:start, String:addStr);
        System.out.println("- insert");
        StringBuffer strbuf4 = new StringBuffer("01234567890");
        strbuf4.insert(0, "hoge_");
        System.out.println(strbuf4);

        // 指定範囲の文字列を置き換える
        System.out.println("- replace");
        StringBuffer strbuf5 = new StringBuffer("01234567890");
        strbuf5.replace(3,5, "_hoge_");
        System.out.println(strbuf5);

        // バッファ数を返す capacity()
        System.out.println("- capacity");
        System.out.println(String.valueOf(strbuf2.capacity()));
    }

    public void disp() {
        System.out.println(str1);
        for (int i=0; i<strs.length; i++) {
            System.out.printf("%s %d\n",strs[i],i);
        }
    }
}
