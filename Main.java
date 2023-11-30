import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String stingip="";
        InetAddress localip;
        try {
            localip=InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        stingip= String.valueOf(localip);
        int substringip=stingip.lastIndexOf('/')+1;
        String ips=stingip.substring(substringip,stingip.length());
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel("IP to: ");
        frame.getContentPane().add(label, BorderLayout.NORTH);
        JLabel labelip=new JLabel(ips);
        FlowLayout layout=new FlowLayout(10);
        frame.setLayout(layout);

        JButton b1=new JButton("Modificate text");
        JButton b2=new JButton("Save text");
        frame.add(b1);
        frame.add(b2);
        frame.add(labelip);
        frame.setVisible(true);

        frame.setSize(400,500);

        ExecutorService writter= Executors.newFixedThreadPool(2);
        ExecutorService reader=Executors.newFixedThreadPool(2);
        ksiazka ksiazka1=new ksiazka();

        int port=2234;

        try {
            Socket s1=new Socket(ips,port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        writter.submit(() ->{
//            while (true) {
//                ksiazka1.write("a");
//            }
//        });
//        reader.submit(()-> {
//            while (true) {
//                System.out.printf(ksiazka1.read());
//                System.out.printf("\n");
//            }
//        });

//        try {
//            reader.awaitTermination(10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            writter.awaitTermination(10,TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        writter.shutdown();
//        reader.shutdown();
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Test test = new Test();
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        executor.execute(() -> {
//            for (int i = 0; i < 10; i++) {
//                test.aaa();
//            }
//        });
//
//        executor.submit(() -> {
//            for (int i = 0; i < 10; i++) {
//                test.bbb();
//            }
//        });
//
//        executor.shutdown();
//    }
//}
//
//class Test {
//    public synchronized void aaa() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Funkcja aaa() została wywołana.");
//    }
//
//    public synchronized void bbb() {
//        System.out.println("Funkcja bbb() została wywołana.");
//    }
//}