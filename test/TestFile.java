import java.io.*;
/*
 ファイルの入出力を行うには幾つかのパターンがある
 文字列を読む
 1. File でファイルを開く
    FileReaderにFileオブジェクトを渡しファイルを開く
    BufferedReader で1行づつ文字列を入力
 2. FileReaderでファイルを開く
    BufferedReader で1行づつ文字列を入力
 
 データ(バイナリ)を読む 
 1. File でファイルを開く
    InputStream オブジェクト生成 (with File)
    BufferedInputStream オブジェクトを生成 (with FileInputStream)
 2. FileInputStream オブジェクト生成 (with File)
    BufferedInputStream オブジェクトを生成 (with FileInputStream)

 文字を書きこむ
 1. File でファイルを開く
    FileWriter オブジェクトを生成 (with File)
    BufferedWriter で１行づつ文字列を出力
*/


public class TestFile {
    public static void main(String[] args) {
        System.out.println("File IO Test");

        // 第１引数を整数に変換する
        int mode = 0;
        try {
            mode = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        FileClass file1 = new FileClass();
        switch (mode) {
            case 0:
                file1.readChar("test_files/hoge.txt");
                break;
            case 1:
                // 文字列の読み込み
                file1.readText("test_files/hoge.txt");
                break;
            case 2:
                // 文字列の書き込み
                file1.writeText("test_files/hoge_w.txt");
                break;
            case 3:
                // RandomAccessFileを使ったバイナリファイルの読み込み
                file1.readBinary("test_files/hoge_w2.dat");
                break;
            case 4:
                // RandomAccessFileクラスでバイナリの書き込み
                file1.writeBinary("test_files/hoge_w2.dat");
                break;
            default:
                System.out.println("No test " + String.valueOf(mode));
        }
    }
} 

class FileClass {
    // テキストファイルを１文字づつ出力
    // FileReader read()
    public void readChar(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);

            int ch;
            while (-1 != (ch = fr.read())) {
                System.out.println((char)ch);
            }
            fr.close();
        } catch(FileNotFoundException e) { 
          System.out.println(e);
        } catch(IOException e) {
          System.out.println(e);
        }
    }

    // 文字列を読み込む
    // FileReader & BufferedReader readLine()
    public void readText(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            // 1行づつ読み込む
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch(FileNotFoundException e) { 
          System.out.println(e);
        } catch(IOException e) {
          System.out.println(e);
        }
    }
    
    // テキストをファイルに書き込む
    // FileWriter write()
    public void writeText(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);

            // 書き込み処理
            fw.write("こんにちは");

            // ファイルを閉じる
            fw.close();
        } catch(FileNotFoundException e) { 
          System.out.println(e);
        } catch(IOException e) {
          System.out.println(e);
        }
    }

    // バイナリファイルを読み込み
    // RandomAccessFile
    public void readBinary(String filePath) {
        try {
            // 入力ストリームの生成
            RandomAccessFile raf = new RandomAccessFile(filePath, "r");
            
            // 4byteづつ読み込む
            for (int i=0; i<raf.length() / 4; i++) {
                int val = raf.readInt();
                String hex = String.format("%08x ", val);
                System.out.print(hex);
                if (i>0 && (i%8)==7) {
                    System.out.println("");
                }
            }

            // 先頭に戻る seek(シーク位置)
            raf.seek(0);
            for (int i=0; i<8; i++) {
                int val = raf.readInt();
                String hex = String.format("%08x ", val);
                System.out.print(hex);
                if (i>0 && (i%8)==7) {
                    System.out.println("");
                }
            }

            // 後始末
            raf.close();
        } catch(FileNotFoundException e) { 
          System.out.println(e);
        } catch(IOException e) {
          System.out.println(e);
        }
    }

    // ファイルにバイナリを書き込む
    // RandomAccessFile
    public void writeBinary(String fileName) {
        try {
            System.out.println("writeBinary2");
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            // 書き込み
            for (int i=0; i<256; i++) {
                raf.writeInt(i);
            }

            raf.close();
        } catch(FileNotFoundException e) { 
          System.out.println(e);
        } catch(IOException e) {
          System.out.println(e);
        }
    }
}
