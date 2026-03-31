import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private JPanel dashboardPanel;
    private JButton createExamButton;
    private JButton enterScoresButton;
    private JButton viewResultsButton;
    private JButton logoutButton;
    private JLabel welcomeLabel;

    public Dashboard() {
        setTitle("Examination Management - Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(dashboardPanel);

        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);

        welcomeLabel = new JLabel("Welcome to Examination Management System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setBounds(50, 30, 400, 30);
        dashboardPanel.add(welcomeLabel);

        // Button Listeners
        createExamButton.addActionListener(e -> {
            new ExamForm().setVisible(true);
        });

        enterScoresButton.addActionListener(e -> {
            new ScoreEntry().setVisible(true);
        });

        viewResultsButton.addActionListener(e -> {
            new ResultsForm().setVisible(true);
        });

        logoutButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });

    }

    static void main() {
        new Dashboard().setVisible(true);
    }
}
