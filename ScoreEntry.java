import javax.swing.*;
import java.awt.event.*;

public class ScoreEntry extends JFrame {
    private JPanel scorePanel;
    private JComboBox<String> examComboBox;
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField scoreField;
    private JButton saveScoreButton;
    private JButton calculateGradeButton;
    private JLabel gradeLabel;

    public ScoreEntry() {
        setTitle("Enter Student Scores");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



        setContentPane(scorePanel);

        calculateGradeButton.addActionListener(e -> calculateGrade());

        saveScoreButton.addActionListener(e -> {
            if (validateScoreEntry()) {
                String exam = (String) examComboBox.getSelectedItem();
                String id = studentIdField.getText();
                String name = studentNameField.getText();
                String score = scoreField.getText();
                String grade = gradeLabel.getText();

                JOptionPane.showMessageDialog(this,
                        "Score Saved Successfully!\n\n" +
                                "Exam: " + exam + "\n" +
                                "Student: " + name + " (ID: " + id + ")\n" +
                                "Score: " + score + "\n" +
                                grade);
            }
        });
    }

    private void calculateGrade() {
        try {
            double score = Double.parseDouble(scoreField.getText());
            String grade;

            // Grading system (customize as needed)
            if (score >= 90) grade = "A+";
            else if (score >= 85) grade = "A";
            else if (score >= 80) grade = "A-";
            else if (score >= 75) grade = "B+";
            else if (score >= 70) grade = "B";
            else if (score >= 65) grade = "B-";
            else if (score >= 60) grade = "C+";
            else if (score >= 55) grade = "C";
            else if (score >= 50) grade = "C-";
            else grade = "F";

            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid score!");
        }
    }

    private boolean validateScoreEntry() {
        if (studentIdField.getText().isEmpty() || studentNameField.getText().isEmpty() ||
                scoreField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return false;
        }
        return true;
    }

    static void main() {
        new  ScoreEntry();
    }
}
