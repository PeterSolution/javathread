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
//        JFrame frame = new JFrame("Prosty interfejs graficzny");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//
//        // Ustalenie BorderLayout dla głównego kontenera
//        frame.setLayout(new BorderLayout(0, 0)); // Ustawienie marginesów na 0
//
//        // Dodanie dwóch labeli na górze z odstępem 10 pikseli
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Ustawienie odstępów
//        JLabel label1 = new JLabel("Pierwszy Label");
//        JLabel label2 = new JLabel("Drugi Label");
//        topPanel.add(label1);
//        topPanel.add(label2);
//        frame.add(topPanel, BorderLayout.NORTH);
//
//        // Dodanie pola tekstowego na środku ekranu
//        JTextField textField = new JTextField(20);
//        textField.setHorizontalAlignment(JTextField.CENTER); // Wyśrodkowanie tekstu
//        frame.add(textField, BorderLayout.CENTER);
//
//        // Dodanie przycisku na dole ekranu z odstępem 20 pikseli
//        JButton button = new JButton("Dodaj tekst");
//        JPanel bottomPanel = new JPanel();
//        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Ustawienie odstępów
//        bottomPanel.add(button);
//        frame.add(bottomPanel, BorderLayout.SOUTH);
//
//        frame.setVisible(true);


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
        frame.setSize(600, 600);
        JPanel mp=new JPanel();
        mp.setLayout(new BoxLayout(mp,BoxLayout.Y_AXIS));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("IP to: ");
        top.add(label);
        JLabel labelip = new JLabel(ips);
        top.add(labelip);
        mp.add(top);

        JPanel mid=new JPanel();
        mid.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextArea area=new JTextArea();
        area.setPreferredSize(new Dimension(300,300));
        mid.add(area);
        mp.add(mid);

        JPanel bot = new JPanel();
        JButton b1 = new JButton("Modificate text");
        JButton b2 = new JButton("Save text");
        JPanel botpanel = new JPanel();
        botpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botpanel.add(b1);
        botpanel.add(b2);
        mp.add(botpanel);

        frame.add(mp);
        frame.pack();
        frame.setVisible(true);


        ExecutorService writter= Executors.newFixedThreadPool(2);
        ExecutorService reader=Executors.newFixedThreadPool(2);
        ksiazka ksiazka1=new ksiazka();

//        int port=2234;
//
//        try {
//            Socket s1=new Socket(ips,port);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


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
