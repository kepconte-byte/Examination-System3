
import javax.swing.*;
import java.awt.*;

public class ResultsForm extends JFrame {
    private JPanel resultsPanel;
    private JTextArea reportArea;
    private JButton generateButton;
    private JComboBox<String> reportTypeCombo;

    public ResultsForm() {
        setTitle("Results & Grade Reports");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setContentPane(resultsPanel);

        generateButton.addActionListener(e -> generateSampleReport());
    }

    private void generateSampleReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== EXAMINATION RESULTS REPORT ===\n\n");
        report.append("Generated: ").append(java.time.LocalDate.now()).append("\n\n");

        String type = (String) reportTypeCombo.getSelectedItem();

        switch(type) {
            case "All Exams Summary":
                report.append("Scheduled Exams:\n");
                if (ExamForm.examList.isEmpty()) {
                    report.append("No exams scheduled yet.\n");
                } else {
                    for (ExamForm.Exam exam : ExamForm.examList) {
                        report.append("- ").append(exam.name)
                                .append(" (").append(exam.subject).append(")\n");
                        report.append("  Date: ").append(exam.date)
                                .append(" | Max Marks: ").append(exam.maxMarks).append("\n\n");
                    }
                }
                break;

            case "Student-wise Report":
                report.append("Student Performance Summary:\n");
                report.append("--------------------------------\n");
                report.append("Sample Student Data:\n");
                report.append("ID: 2024-001 | Name: Juan Dela Cruz\n");
                report.append("  Programming 101: 85 (A)\n");
                report.append("  Database Systems: 92 (A+)\n");
                report.append("  Average: 88.5 | Status: PASSED\n\n");
                break;

            case "Grade Distribution":
                report.append("Grade Distribution Analysis:\n");
                report.append("--------------------------------\n");
                report.append("A+ (90-100): 5 students\n");
                report.append("A (85-89): 8 students\n");
                report.append("A- (80-84): 12 students\n");
                report.append("B+ (75-79): 10 students\n");
                report.append("B (70-74): 6 students\n");
                report.append("Below 70: 4 students\n");
                report.append("\nClass Average: 81.5%\n");
                break;
        }

        reportArea.setText(report.toString());
    }

    static void main() {
        new ResultsForm();
    }
}