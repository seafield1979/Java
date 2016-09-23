/*
* コレクションテスト
*/
import java.util.*;

class TestCollection{
    public static void main(String args[]){
      System.out.println("Test Collection!!\n");
        // 第１引数を整数に変換する
        int mode = 0;
        mode = Integer.parseInt(args[1]);
        
        CollectionClass collection = new CollectionClass();
        switch(mode) {
            case 1:
                collection.testArray1();
                break;
            case 12:
                collection.testArray2();
                break;
            case 13:
                //collection.testArray3();
                break;
            case 2:
                collection.testLinkedList1();
                break;
            case 22:
                collection.testLinkedList2();
                break;
            case 3:
                collection.testHashSet1();
                break;
            case 32:
                collection.testHashSet2();
                break;
            case 4:
                collection.testHashMap();
                break;
            case 42:
                collection.testTreeMap();
                break;
            case 5:
                collection.testIterator();
                break;
            case 10:
                ExCollection5 collection2 = new ExCollection5();
                collection2.test1();
                break;
        }
    }
}


class CollectionClass {
    // ArrayListのテスト
    public void testArray1(){
        try {
            // 初期容量が100の配列
            ArrayList<String> list1 = new ArrayList<String>(100);

            // 要素の追加
            for (int i=0; i<10; i++) {
                list1.add(i, "hoge" + String.valueOf(i));
            }
            // 要素数(インデックスで参照できる)
            System.out.println("size:" + String.valueOf(list1.size()));

            // 値の読み出し
            for (int i=0; i<10; i++) {
                String str = (String)list1.get(i);
                System.out.println(str);
            }

            // イテレータ
            // System.out.println("\niterator");
            // for (Iterator<String> it = list1.iterator(); it.hasNext();) {
            //     String str = it.next();
            //     System.out.println(str);
            // }

            // 破棄
            list1.clear();

            System.out.println("size:" + String.valueOf(list1.size()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testArray2() {
        try {
            // 初期容量が100の配列
            ArrayList<String> list1 = new ArrayList<String>(100);

            // 要素の追加
            for (int i=0; i<10; i++) {
                list1.add(i, "hoge" + String.valueOf(i));
            }

            // 要素の削除
            list1.remove(5);

            // 要素数(インデックスで参照できる)
            System.out.println("size:" + String.valueOf(list1.size()));
            
            // 値の読み出し
            for (int i=0; i<list1.size(); i++) {
                String str = (String)list1.get(i);
                System.out.println(str);
            }

            // 値の設定
            for (int i=0; i<list1.size(); i++) {
                list1.set(i, "oge" + String.valueOf(i));
            }

            // 値の読み出し
            for (int i=0; i<list1.size(); i++) {
                String str = (String)list1.get(i);
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }       
    }

    // LinkedListのテスト
    // popやpush等のキュー用のメソッドが用意されているので待ち行列として使える
    // スタックとして使用する (先入先出し)
    public void testLinkedList1() {
        try {
            // private ArrayList<Rule> list = new ArrayList<Rule>();
            LinkedList<String> list1 = new LinkedList<String>();

            // 要素の最後に要素追加
            for (int i=0; i<10; i++) {
                list1.push("hoge" + String.valueOf(i));
            }
            
            // 要素の取り出し
            for (int i=0; i<5; i++) {
                String str = (String)list1.pop();
                System.out.println("pop:" + str);
            }

            // 要素を最後から順に取り出し
            for (int i=0; i<list1.size(); i++) {
                System.out.println(list1.get(i));
            }

            // 破棄
            list1.clear();
            System.out.println("size:" + String.valueOf(list1.size()));
        } catch (Exception e) {
            System.out.println(e);
        }       
    }

    // LinkedListをキューとして使用する (先入先出し)
    public void testLinkedList2() {
        try {
            // private ArrayList<Rule> list = new ArrayList<Rule>();
            LinkedList<String> list1 = new LinkedList<String>();

            // 要素の末尾に要素追加
            for (int i=0; i<10; i++) {
                list1.addLast("hoge" + String.valueOf(i));
            }
            
            // 要素の取り出し
            for (int i=0; i<list1.size(); i++) {
                String str = (String)list1.poll();
                System.out.println("pop:" + str);
            }

            for (int i=0; i<list1.size(); i++) {
                System.out.println(list1.get(i));
            }

            // 破棄
            list1.clear();
            System.out.println("size:" + String.valueOf(list1.size()));
        } catch (Exception e) {
            System.out.println(e);
        }       
    }

    // HashSet をテスト
    // Integer型の値を保持するSetを作成
    public void testHashSet1() {
        try {
            HashSet<Integer> hs1 = new HashSet<Integer>();

            // 要素を追加
            for (int i=0; i<100; i++) {
                int rand = (int)(Math.random()*100);
                Integer val = new Integer(rand);
                if (hs1.contains(val)) {
                    System.out.println(String.valueOf(val) + " is already exist.");
                } else {
                    hs1.add(new Integer(rand));
                }
            }
            // 要素を表示
            Iterator<Integer> it = hs1.iterator();
            while (it.hasNext()) {
                System.out.println(String.valueOf(it.next()));
            }
            System.out.println("size:" + String.valueOf(hs1.size()));

        } catch (Exception e) {
            
        }
    }

    // HashSetのテスト
    // String型の値を保持するSet
    public void testHashSet2() {
        try {
            HashSet<String> hs1 = new HashSet<String>();

            // 要素を追加
            for (int i=0; i<100; i++) {
                int rand = (int)(Math.random()*100);
                String str = "hoge" + String.valueOf(rand);
                if (hs1.contains(str)) {
                    System.out.println(str + " is already exist.");
                } else {
                    hs1.add(str);
                }
            }
            // 要素を表示
            Iterator<String> it = hs1.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("size:" + String.valueOf(hs1.size()));

        } catch (Exception e) {
            
        }
    }

    // HashMapのテスト
    public void testHashMap() {
        try {
            HashMap<String,String> map1 = new HashMap<String,String>();

            // いろいろ追加
            String[][] names = {{"hoge1", "111"},
                    {"hoge2", "222"},
                    {"hoge3", "333"}, 
                    {"hoge4", "444"},
                    {"hoge5", "555"}};
            for (String[] array : names) {
                map1.put(array[0], array[1]);
            }

            // 全表示
            for (String key : map1.keySet()) {
                System.out.println(key + "=" + map1.get(key));
            }

            // Mapの結合
            System.out.println("\nconnect map");
            HashMap<String,String> map21 = this.getHashMap("hoge", 10);
            HashMap<String,String> map22 = this.getHashMap("mage", 10);
            map21.putAll(map22);

            for (String key : map21.keySet()) {
                System.out.println(key + "=" + map21.get(key));
            }

            // 要素の削除
            // keyのオブジェクトに一致したものを削除する
            System.out.println("\nremove object");
            map21.remove("hoge3");
            map21.remove("hoge5");
            map21.remove("hoge7");
            map21.remove("hoge9");

            for (String key : map21.keySet())  {
                System.out.println(key + "=" + map21.get(key));
            }

            // valueのセットを表示する
            System.out.println("\nvalues");;
            for (String value : map21.values()) {
                System.out.println("value=" + value);
            }
        } catch (Exception e) {
            
        }
    }

    // 適当なHashMapを作って返す
    static HashMap<String,String> getHashMap(String keyName, int size) {
        HashMap<String,String> map = new HashMap<String,String>();
        for (int i=0; i<size; i++) {
            String key = keyName + String.valueOf(i);
            String value = String.valueOf((int)(Math.random()*100));
            map.put(key, value);
        }
        return map;
    }

    // 適当なTreeMapを作って返す
    static TreeMap<String,String> getTreeMap(String keyName, int size) {
        TreeMap<String,String> map = new TreeMap<String,String>();
        for (int i=0; i<size; i++) {
            String key = keyName + String.valueOf(i);
            String value = String.valueOf((int)(Math.random()*100));
            map.put(key, value);
        }
        return map;
    }

    // TreeMapのテスト
    // TreeMapはキーの並びを整列してくれる
    public void testTreeMap() {
        try {
            TreeMap<String,String> map1 = new TreeMap<String,String>();

            // いろいろ追加
            String[][] names = {{"hoge1", "111"},
                    {"hoge2", "222"},
                    {"hoge3", "333"}, 
                    {"hoge4", "444"},
                    {"hoge5", "555"}};
            for (String[] array : names) {
                map1.put(array[0], array[1]);
            }

            // 全表示
            for (String key : map1.keySet()) {
                System.out.println(key + "=" + map1.get(key));
            }

            // Mapの結合
            System.out.println("\nconnect map");
            TreeMap<String,String> map21 = this.getTreeMap("hoge", 10);
            TreeMap<String,String> map22 = this.getTreeMap("mage", 10);
            map21.putAll(map22);

            for (String key : map21.keySet()) {
                System.out.println(key + "=" + map21.get(key));
            }

            // 要素の削除
            // keyのオブジェクトに一致したものを削除する
            System.out.println("\nremove object");
            map21.remove("hoge3");
            map21.remove("hoge5");
            map21.remove("hoge7");
            map21.remove("hoge9");

            for (String key : map21.keySet())  {
                System.out.println(key + "=" + map21.get(key));
            }

            // valueのセットを表示する
            System.out.println("\nvalues");;
            for (String value : map21.values()) {
                System.out.println("value=" + value);
            }
        } catch (Exception e) {
            
        }
    }

    // Iteratorのテスト
    // コレクションの要素を順番に処理したい場合などに利用
    public void testIterator() {
        Set<Integer> hs1 = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            hs1.add(new Integer(i));
        }
        System.out.println("削除前" + hs1);

        for (Iterator<Integer> i = hs1.iterator(); i.hasNext();) {
            Integer val = i.next();
            i.remove();
            // System.out.println("value:" + String.valueOf(val));
        }
        System.out.println("削除後" + hs1);
    }
}

class ExCollection5 {
    public static void test1() {
        ExCollection5 exObject = new ExCollection5();
        exObject.showFeature(new HashSet<Integer>(), "HashSet");  //(1)
        exObject.showFeature(new TreeSet<Integer>(), "TreeSet");  //(2)
        exObject.showFeature(new LinkedHashSet<Integer>(), "LinkedHashSet");  //(3)
    }

    //(4)Setインタフェース型を引数に取る
    void showFeature(Set<Integer> exSet, String s) {
        int[] intArray = {5, 8, 2, 9, 1};  //(5)代入する要素の配列
        //(6)各クラスに要素を代入
        for(int i = 0; i < intArray.length; i++) {
            exSet.add(new Integer(intArray[i]));
        }
        //(7)各クラスの要素を表示
        System.out.println(s + " = " + exSet);
    }
}