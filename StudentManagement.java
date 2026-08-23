import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagement extends JFrame implements ActionListener {

    // Components
    JTextField idField, nameField, ageField;
    JComboBox<String> courseBox;
    JButton addButton, updateButton, deleteButton, clearButton;
    JTable table;
    DefaultTableModel model;

    StudentManagement() {

        // Window
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(190, 20, 350, 30);
        panel.add(title);

        // Student ID
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 80, 100, 25);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 80, 180, 25);
        panel.add(idField);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 120, 100, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 120, 180, 25);
        panel.add(nameField);

        // Course
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(380, 80, 100, 25);
        panel.add(courseLabel);

        String[] courses = {
                "AI & ML",
                "Computer Science",
                "Data Science",
                "Cyber Security"
        };

        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(480, 80, 150, 25);
        panel.add(courseBox);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(380, 120, 100, 25);
        panel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(480, 120, 150, 25);
        panel.add(ageField);

        // Buttons
        addButton = new JButton("Add");
        addButton.setBounds(50, 170, 100, 30);
        addButton.addActionListener(this);
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(165, 170, 100, 30);
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(280, 170, 100, 30);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(395, 170, 100, 30);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        // Table
        String[] columns = {"ID", "Name", "Course", "Age"};

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 230, 580, 180);
        panel.add(scrollPane);

        // Click table row
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                int row = table.getSelectedRow();

                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                courseBox.setSelectedItem(model.getValueAt(row, 2).toString());
                ageField.setText(model.getValueAt(row, 3).toString());
            }
        });

        add(panel);

        setVisible(true);
    }

    // Button actions
    @Override
    public void actionPerformed(ActionEvent e) {

        // ADD
        if (e.getSource() == addButton) {

            String id = idField.getText();
            String name = nameField.getText();
            String course = courseBox.getSelectedItem().toString();
            String age = ageField.getText();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields!"
                );

                return;
            }

            model.addRow(new Object[]{
                    id,
                    name,
                    course,
                    age
            });

            JOptionPane.showMessageDialog(
                    this,
                    "Student Added Successfully!"
            );

            clearFields();
        }

        // UPDATE
        else if (e.getSource() == updateButton) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a student!"
                );

                return;
            }

            model.setValueAt(idField.getText(), row, 0);
            model.setValueAt(nameField.getText(), row, 1);
            model.setValueAt(courseBox.getSelectedItem(), row, 2);
            model.setValueAt(ageField.getText(), row, 3);

            JOptionPane.showMessageDialog(
                    this,
                    "Student Updated Successfully!"
            );

            clearFields();
        }

        // DELETE
        else if (e.getSource() == deleteButton) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a student!"
                );

                return;
            }

            model.removeRow(row);

            JOptionPane.showMessageDialog(
                    this,
                    "Student Deleted Successfully!"
            );

            clearFields();
        }

        // CLEAR
        else if (e.getSource() == clearButton) {

            clearFields();
        }
    }

    // Clear input fields
    void clearFields() {

        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseBox.setSelectedIndex(0);

        table.clearSelection();
    }

    // Main method
    public static void main(String[] args) {

        new StudentManagement();
    }
}
