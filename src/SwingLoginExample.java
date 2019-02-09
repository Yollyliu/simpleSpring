import javax.swing.*;

public class SwingLoginExample {

    private static void placeComponents(JPanel panel){

        panel.setLayout(null);

        JLabel welcome=new JLabel("Welcome to Swing");
        welcome.setBounds(85,5,180,25);
        panel.add(welcome);

        JLabel userLabel=new JLabel("User:");
        userLabel.setBounds(30,40,80,25);
        panel.add(userLabel);


        JLabel pswLabel=new JLabel("PassWord:");
        pswLabel.setBounds(30,80,80,25);
        panel.add(pswLabel);

        JTextField userField=new JTextField(20);
        userField.setBounds(120,40,80,25);
        panel.add(userField);

        JTextField pswField=new JTextField(20);
        pswField.setBounds(120,80,80,25);
        panel.add(pswField);

        JButton cancelButton=new JButton("cancel");
        cancelButton.setBounds(50,120,70,25);
        panel.add(cancelButton);


        JButton loginButton=new JButton("Login");
        loginButton.setBounds(180,120,70,25);
        panel.add(loginButton);


    }

    public static void main(String[] args) {

        JFrame jFrame=new JFrame("Swing Login Example");
        jFrame.setSize(350,180);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel=new JPanel();
        jFrame.add(jPanel);
        placeComponents(jPanel);
        jFrame.setVisible(true);


    }
}
