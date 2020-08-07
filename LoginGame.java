package logingame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginGame {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button1, button2, button3;
    private static JLabel accountLabel;
    private static FileWriter fileWriter;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Tic-Tac-Toe Login");
        frame.setSize(380, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(30, 20, 80, 25);

        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(110, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(110, 50, 165, 25);
        panel.add(passwordText);

        button1 = new JButton("Login");
        button1.setBounds(30, 100, 80, 25);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getActionCommand() == button1.getActionCommand()) {
                    try {
                        fileWriter = new FileWriter("AdminUser.txt");
                        fileWriter.write(userLabel.getText() + " : " + userText.getText());
                        fileWriter.write(passwordLabel.getText() + " : " + passwordText.getText());
                        fileWriter.close();
                    } catch (Exception e) {
                    }
                }
                TicTacToeGame second = new TicTacToeGame();
                second.setVisible(true);
                frame.dispose();
            }
        });

        panel.add(button1);

        accountLabel = new JLabel("Don't have a Tic-Tac-Toe account?");
        accountLabel.setBounds(30, 140, 200, 25);
        panel.add(accountLabel);

        button2 = new JButton("Create New Account");
        button2.setBounds(30, 160, 180, 25);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewGameAccount third = new NewGameAccount();
                third.setVisible(true);
                frame.dispose();
            }
        });
        panel.add(button2);

        button3 = new JButton("ADMIN ONLY");
        button3.setBounds(30, 240, 120, 25);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            Admin fourth = new Admin();
            fourth.setVisible(true);
            frame.dispose();
            }
            });

        panel.add(button3);
        frame.setVisible(true);

        SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                new LoginGame();
            }
        }
        );
    }
}
