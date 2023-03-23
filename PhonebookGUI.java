import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PhonebookGUI extends JFrame {

    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, numberField;
    private JButton addButton, editButton, deleteButton;

    private ArrayList<Entry> entries;

    public PhonebookGUI() {
        super("Phonebook");

        // Initialize entries list
        entries = new ArrayList<>();

        // Initialize UI components
        panel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Name", "Number"}, 0);
        table = new JTable(tableModel);
        nameField = new JTextField();
        numberField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Set up table
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Set up form panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Number:"));
        formPanel.add(numberField);
        panel.add(formPanel, BorderLayout.NORTH);

        // Set up button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add event listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String number = numberField.getText().trim();
                if (!name.isEmpty() && !number.isEmpty()) {
                    entries.add(new Entry(name, number));
                    updateTable();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(PhonebookGUI.this, "Name and number fields cannot be empty.");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if (rowIndex >= 0) {
                    Entry entry = entries.get(rowIndex);
                    String name = nameField.getText().trim();
                    String number = numberField.getText().trim();
                    if (!name.isEmpty() && !number.isEmpty()) {
                        entry.setName(name);
                        entry.setNumber(number);
                        updateTable();
                        clearForm();
                    } else {
                        JOptionPane.showMessageDialog(PhonebookGUI.this, "Name and number fields cannot be empty.");
                    }
                } else {
                    JOptionPane.showMessageDialog(PhonebookGUI.this, "Please select an entry to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if (rowIndex >= 0) {
                    entries.remove(rowIndex);
                    updateTable();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(PhonebookGUI.this, "Please select an entry to delete.");
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int rowIndex = table.getSelectedRow();
            if (rowIndex >= 0) {
                Entry entry = entries.get(rowIndex);
                nameField.setText(entry.getName());
                numberField.setText(entry.getNumber());
            }
        });

        // Set up frame
        setContentPane(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void updateTable() {
        tableModel.setRowCount(0);
        for (Entry entry : entries) {
            tableModel.addRow(new Object[]{entry.getName(), entry.getNumber()});
        }
    }
    
    private void clearForm() {
        nameField.setText("");
        numberField.setText("");
    }
    
    private static class Entry {
        private String name;
        private String number;
    
        public Entry(String name, String number) {
            this.name = name;
            this.number = number;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getNumber() {
            return number;
        }
    
        public void setNumber(String number) {
            this.number = number;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhonebookGUI();
            }
        });
    }}    