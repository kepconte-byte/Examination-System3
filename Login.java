import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public Login() {
        setTitle("Examination Management System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(loginPanel);

        // Initialize components manually if not using GUI designer






        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = new String(passwordField.getPassword());

                // Simple authentication (replace with database validation)
                if (user.equals("admin") || pass.equals("admin123")) {

                    JOptionPane.showMessageDialog(Login. this, "Welcome!");
                    dispose();
                    new Dashboard().setVisible(true);


                } else {


                    JOptionPane.showMessageDialog(Login.this,"Invalid username or password");
                    passwordField.setText("");

                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
