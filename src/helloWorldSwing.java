import javax.swing.*;


public class helloWorldSwing {

    private static void createAndShowGUI(){

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame=new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label =new JLabel("Hello world");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
