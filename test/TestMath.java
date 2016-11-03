

class TestMath{
    public static final double RAD = 3.1415 / 180.0;

    public static void main(String args[]) {
        int mode = 0;
        if (args.length >= 1) {
            try {
                mode = Integer.parseInt(args[1]);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("mode:" + mode);
        
        switch (mode) {
            case 1:
                test1();
                break;
            case 2:
                test2();
                break;
            case 3:
                test3();
                break;
            case 4:
                test4();
                break;
        }
    }

    // sin
    public static void test1() {
        for (int i=0; i<360; i+=10) {
            System.out.println("value:" + i + " sin:" + Math.sin((double)i * RAD));
        }
    }

    // cos
    public static void test2() {
        for (int i=0; i<360; i+=10) {
            System.out.println("value:" + i + " cos:" + Math.cos((double)i * RAD));
        }
    }

    // 0->100 の値を 0->1.0->0に変換する
    public static void test3() {
        for (int i=0; i<=100; i++) {
            double v1 = ((double)i / (double)100) * 180;
            System.out.println("value:" + i + " sin:" + Math.sin(v1 * RAD));
        }
    }

    public static void test4() {
        double sin90 = Math.sin(90 * RAD);
        double cos90 = Math.cos(90 * RAD);
    
        System.out.println("sin90:" + sin90);
        System.out.println("cos90:" + cos90);
    }
}
