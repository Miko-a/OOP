package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login {
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin123";
    // String msg = " ";

    JTextField textUsername;                                 // text* put in this for global variable. so that can
    JTextField textPassword;                                 // be used in another class
    JLabel statusMessage = new JLabel(" ");            // status for login is success or not

    public static void main(String[] args) {
        login log = new login();
        log.go();
    }

    public void go() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel LabelUsername = new JLabel("Username: ");
        JLabel LabelPassword = new JLabel("Password: ");

        textUsername = new JTextField(20);
        textPassword = new JTextField(20);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new LoginListener());

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(new CancelListener());

        panel.add(LabelUsername);
        panel.add(textUsername);
        panel.add(LabelPassword);
        panel.add(textPassword);
        
        panel.add(buttonLogin);
        panel.add(buttonCancel);

        panel.add(statusMessage);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (DEFAULT_USERNAME.equals(textUsername.getText()) && DEFAULT_PASSWORD.equals(textPassword.getText())) {
                    statusMessage.setText("Login Granted! Good Luck.");
            } else 
                statusMessage.setText("You're username/password isn't correct.");
        }
    }

    class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            textUsername.setText(" ");
            textPassword.setText(" ");
            statusMessage.setText(" ");
            textUsername.requestFocus();
        }
    }
}

