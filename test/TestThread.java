/**
 * スレッドのテスト
 */
import java.io.*;


class TestThread {
    public static void main(String[] args) {
        System.out.println("Thread Test");

        // 第１引数を整数に変換する
        int mode = 0;
        try {
            mode = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        switch (mode) {
            case 1:
            {
                // Threadクラスのサブクラス
                ThreadClass thread1 = new ThreadClass();
                thread1.start();
                thread1.test2();
                break;
            }
            case 2:
            {
                // Runnableインターフェイスを実装してThreadクラスのコンストラクタに渡す
                MyRunnable runnable = new MyRunnable();
                Thread thread1 = new Thread(runnable);
                Thread thread2 = new Thread(runnable);
                thread1.start();
                thread2.start();
                break;
            }

            case 3:
            {
                // synchronized を使ったスレッド間同期処理
                SynchronizedClass sc = new SynchronizedClass();
                SynchronizedThread1 thread1 = new SynchronizedThread1(sc,1);
                SynchronizedThread1 thread2 = new SynchronizedThread1(sc,1);
                thread1.start();
                thread2.start();
                break;
            }
            case 4:
            {
                // wait,notifyAll を使ったスレッド間同期処理
                WaitClass wc = new WaitClass();
                WaitThread1 thread1 = new WaitThread1(wc, 0);
                WaitThread1 thread2 = new WaitThread1(wc, 1);
                thread1.start();
                thread2.start();
                break;
            }
            default:
                System.out.println("no test " + String.valueOf(mode));
        }
    }
}

/**
* Threadのテスト
* 2つのThreadを同時に実行する
* Thread クラスを継承したクラスのrunメソッドにスレットとして実行したい処理を記述し、
* オブジェクトを作成後 startメソッドで実行する
*/
class ThreadClass extends Thread {
    // スレッドとして実行したい処理
    public void run() {
        for (int i=0; i<100; i++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("test1 " + String.valueOf(i));
        }
    }
    // 通常の処理（メインスレッド）として実行する
    public void test2() {
        for (int i=0; i<100; i++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("test2 " + String.valueOf(i));
        }
    }
}


/**
 * Runnableインターフェースをimplementsしたクラスでrunメソッドに処理を記述する
 * このクラスをThreadクラスのコンストラクタに渡してやる。あとはそのThreadオブジェクトをstartするだけ
 */
class MyRunnable implements Runnable {
    public void run() {
        for (int i=0; i<100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("Runnable run " + String.valueOf(i));
        }
    }
}


// 複数のスレッドから利用されるクラス
// 特定の処理を行っている間は他のスレッドから呼び出して欲しくないメソッドには synchronized をつけて、同時アクセスされないようにする
class SynchronizedClass {
    // synchronized にするオブジェクトは型は問わない
    public static String lockKey = "ロックキー";

    // synchronized メソッドでブロックするパターン
    // synchronized をつけることでこのメソッドにアクセスできるのは常に１つのスレッド
    synchronized public void synchronizedBlock1() {
        System.out.print("start!");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {

        }
        System.out.println("end!");
    }

    // synchronized オブジェクトでブロックするパターン
    public void synchronizedBlock2() {
        synchronized (lockKey) {
            System.out.print("start 2!");
            try {
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException e) {

            }
            System.out.println("end 2!");
        }
    }
}

class SynchronizedThread1 extends Thread {
    SynchronizedClass sc = null;
    int type = 0;

    // コンストラクタで共有のSynchronizedClassオブジェクトを取得する
    SynchronizedThread1(SynchronizedClass sc, int type) {
        this.sc = sc;
        this.type = type;
    }
    
    public void run() {
        if (type == 0) {
            for (int i=0; i<100; i++) {
                sc.synchronizedBlock1();
            }
        } else {
            for (int i=0; i<100; i++) {
                sc.synchronizedBlock2();
            }
        }
    }
}

// waitとnotifyAll
class WaitClass {
    // 動作モード 0: block1も2も実行中でない
    //          1: block1が実行中
    //          2: block2が実行中
    public int mode = 0;

    public synchronized void block1(String threadName) {
        // mode = 1ならblock2が実行中なので待機
        if (mode == 1) {
            try {
                System.out.println(threadName + " wait");
                wait();
                System.out.println(threadName + " awake");
            } catch (InterruptedException e) {

            }
        }
        try {
            System.out.println("block1");
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        mode = 1;
        notifyAll();
    }

    public synchronized void block2(String threadName) {
        if (mode != 1) {
            try {
                System.out.println(threadName + " wait");
                wait();
                System.out.println(threadName + " awake");
            } catch (InterruptedException e) {

            }
        }
        try {
            System.out.println("block2");
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        mode = 2;
        notifyAll();
    }
}

class WaitThread1 extends Thread {
    WaitClass wc;
    String name;
    int type;

    WaitThread1(WaitClass wc, int type) {
        this.wc = wc;
        this.name = "Thread" + String.valueOf(type+1);
        this.type = type;
    }

    public void run() {
        for (int i=0; i<10; i++) {
            if (type == 0) {
                wc.block1(this.name);
            } else if (type == 1) {
                wc.block2(this.name);
            }
        }
    }
}
