/**
 * Created by shutaro on 2017/02/04.
 *
 * switch文のテスト
 */
public class Test1 {
    public static void main(String[] args) {
        if (args.length > 0) {
            switch(args[0]) {
                case "test1":
                    if (args.length > 1) {
                        int value = Integer.valueOf(args[1]);
                        test1(value);
                    } else {
                        test1(1);
                    }
                    break;
                case "test2":
                    if (args.length > 1) {
                        test2(args[1]);
                    } else {
                        test2("taro");
                    }
                    break;
                case "test3":
                    if (args.length > 1) {
                        test3(Integer.parseInt(args[1]));
                    } else {
                        test3(new Integer(1));
                    }
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 整数型のswitch文
     */
    private static void test1(int value) {
        switch(value) {
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            default:
                System.out.print("other");
                break;
        }
        System.out.print("\n");
    }

    /**
     * 文字列型のswitch文
     */
    private static void test2(String str) {
        if (str == null) {
            System.out.print("null!!\n");
            return;
        }
        switch(str) {
            case "taro":
                System.out.print("taro!!\n");
                break;
            case "miro":
                System.out.print("miro!!\n");
                break;
            case "ume":
                System.out.print("ume!!\n");
                break;
            default:
                System.out.print("other!!\n");
                break;
        }
    }

    /**
     * Integer型のswitch文
     */
    private static void test3(Integer value) {
        if (value == null) {
            return;
        }
        switch(value) {
            case 1:
                System.out.print("value is one! \n");
                break;
            case 2:
                System.out.print("value is two! \n");
                break;
            case 3:
                System.out.print("value is three! \n");
                break;
            default:
                System.out.print("value is other! \n");
        }
    }
}
