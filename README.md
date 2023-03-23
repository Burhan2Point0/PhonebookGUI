# PhonebookGUI
This Java code is an implementation of a phonebook application with a graphical user interface (GUI). The program allows the user to store and retrieve phone numbers and corresponding names, and perform basic operations such as adding, editing, and deleting entries. 

The GUI is created using the Java Swing library, which provides a set of components and tools for building graphical user interfaces in Java. The main component used in this code is a JTable, which is used to display the phonebook entries in a table format. 

The program uses an ArrayList to store the phonebook entries as objects of a custom Entry class. The Entry class has two fields, name and number, which represent the name and phone number of each entry. 

The PhonebookGUI class creates the GUI and handles user interaction. The updateTable() method is used to update the JTable with the current list of entries whenever an entry is added, edited, or deleted. The clearForm() method is used to reset the text fields after an operation is performed. 

The main() method creates an instance of the PhonebookGUI class and sets it to be visible. When the program is run, the GUI will be displayed and the user can interact with it to manage their phonebook entries. 
