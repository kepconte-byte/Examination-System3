import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExamForm extends JFrame {
    private JPanel examPanel;
    private JTextField examNameField;
    private JTextField subjectField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField maxMarksField;
    private JButton saveButton;
    private JButton clearButton;

    // Static list to store exams (simulating database)
    public static ArrayList<Exam> examList = new ArrayList<>();

    public ExamForm() {
        setTitle("Create & Schedule Exam");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(examPanel);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Exam newExam = new Exam(
                            examNameField.getText(),
                            subjectField.getText(),
                            dateField.getText(),
                            timeField.getText(),
                            Double.parseDouble(maxMarksField.getText())
                    );
                    examList.add(newExam);

                    JOptionPane.showMessageDialog(ExamForm.this,
                            "Exam scheduled successfully!\n\n" + newExam.toString());
                    clearFields();
                }
            }
        });

        clearButton.addActionListener(e -> clearFields());
    }

    private boolean validateFields() {
        if (examNameField.getText().isEmpty() || subjectField.getText().isEmpty() ||
                dateField.getText().isEmpty() || timeField.getText().isEmpty() ||
                maxMarksField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return false;
        }
        try {
            Double.parseDouble(maxMarksField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Maximum marks must be a number!");
            return false;
        }
        return true;
    }

    private void clearFields() {
        examNameField.setText("");
        subjectField.setText("");
        dateField.setText("");
        timeField.setText("");
        maxMarksField.setText("");
    }

    // Inner class for Exam data
    public static class Exam {
        String name, subject, date, time;
        double maxMarks;

        public Exam(String name, String subject, String date, String time, double maxMarks) {
            this.name = name;
            this.subject = subject;
            this.date = date;
            this.time = time;
            this.maxMarks = maxMarks;
        }

        @Override
        public String toString() {
            return "Exam: " + name + "\nSubject: " + subject +
                    "\nDate: " + date + " Time: " + time +
                    "\nMax Marks: " + maxMarks;
        }
    }

    static void main() {
        new ExamForm().setVisible(true);
    }
}
