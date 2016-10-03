
// デフォルトのenum
enum  Enum1 {
    HOGE1,
    HOGE2,
    HOGE3
}

// 整数値を返すことができるEnum。ちょっと面倒臭い
enum IntEnum { 
    Int1(1),
    Int2(2),
    Int3(3),
    ;

    private final int id;

    private IntEnum(final int id) {
        this.id = id;
    }

    public int getInt() {
        return this.id;
    }
    public String getMessage() {
        return String.valueOf(this.id);
    }
}

class TestEnum {
    public static void main(String[] args) {
        System.out.println("Text enum!!");

        int mode = 0;
        if (args.length >= 1) {
            try {
                mode = Integer.parseInt(args[1]);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        TestEnum enum1 = new TestEnum();
        switch(mode) {
            case 1:
                enum1.test1();
                break;
            case 2:
                enum1.test2();
                break;
            default:    
        }
    }

    public void test1() {
        Enum1 e1 = Enum1.HOGE2;
        System.out.println("e1=" + String.valueOf(e1));

        // switchで値の確認
        switch(e1) {
            case HOGE1:
                System.out.println("hoge1");
                break;
            case HOGE2:
                System.out.println("hoge2");
                break;
            case HOGE3:
                System.out.println("hoge3");
                break;
        }
    }

    public void test2() {
        System.out.println("Int1=" + IntEnum.Int1.getMessage());
        System.out.println("Int2=" + IntEnum.Int2.getMessage());
        System.out.println("Int3=" + IntEnum.Int3.getMessage());
    }
}