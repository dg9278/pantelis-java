/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
Programmer: David Guo
Date: 2019-07-30
Program Name: EmployeeForm
Program Description: Creates an application that uses associative arrays and 
*array lists to track the user inputted employee records of a maximum 200
*employees in the fields ID, name, salary and starting date.
*Has options to display all records, as well as remove employees by ID.
*/
public class EmployeeForm extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeForm
     */
    
    // Create array list of employee objects
    ArrayList<EmployeeObject> employeeList = new ArrayList<>();
     // Create assoiate array of employee objects
    EmployeeObject[] employeeTotal = new EmployeeObject[200];
    // Create index to track number and position of employees
    int employeeIndex = 0;
    
    // Create class employee object
    public class EmployeeObject {
        // Define properties ID, first name, last name, annual salary and start date
        public String ID;
        public String firstName;
        public String lastName;
        public String annualSalary;
        public String startDate;
        
        // Constructor
        public EmployeeObject(String idInput, String firstNameInput, String lastNameInput, 
                String annualSalaryInput, String startDateInput) {
            // Assign values
            ID = idInput;
            firstName = firstNameInput;
            lastName = lastNameInput;
            annualSalary = annualSalaryInput;
            startDate = startDateInput;
                              
        }
        
        // Overriden toString method for display
        @Override
        public String toString() {
            
            // Return custom line with all information labelled and separated by '|'
            return("ID: " + ID + " | Name: " + firstName + " " + lastName +
                    " | Annual Salary: $" +  (annualSalary)  +
                    " | Start Date: " + startDate);
           
        }
    }
    
    // Create method for adding employees
    /* Pre: User has inputted necessary ID, first name, last name, annual salary, 
    * and starting date. An employee class and constructor must be created. 
    * An array and arrayList of employees is needed to be read from.
    * Post: Both the array and arrayList must contain a new employeeObject object
    * with the user inputted properties.
    */
    public ArrayList employeeAdd(String ID, String firstName, String lastName, 
                String AnnualSalary, String startDate) {
             
        // Create object from constructor
        EmployeeObject employee = new EmployeeObject(ID, firstName,lastName, 
                AnnualSalary, startDate);
         
        // Add user inputted employee Object to array
        employeeTotal[employeeIndex] = employee;
        
        // Increment index
        employeeIndex += 1;
            
        // Add the stored object to an arrayList
        employeeList.add(employee);
    
        // Return the array list of employees
        return employeeList;
    }
     
   /* Pre: An arrayList of employees has been created.
    * Post: All properties of each employeeObject object has been displayed in
    * the text area.
    */
    // Create method for displaying all employee information
    public void employeeDisplay(ArrayList employeeList) {
        // Clear the text area
       employeeDisplayArea.setText("");
        // Loop through each object in th array list with 'i'
        for (Object i: employeeList) {
            // Display each element on a different line using the custom object to string method
            employeeDisplayArea.append((i.toString()) + "\n");
        }
    }   
    
    /* Pre: User has inputted necessary ID. An employee class and constructor 
    * must be created. An array and arrayList of employees is needed to be read from.
    * Post: Both the array and arrayList must not contain the employeeObject object
    * with the user inputted ID property.
    */
    // Create method for removing an employee
    // Parse the inputted id and the employee array list as a list of EmployeeObject objects
    public static ArrayList employeeRemove(ArrayList<EmployeeObject> employeeList, String idInput) {
        // Parse through each object in the list of employees
          for (EmployeeObject i: employeeList) {
            // If the ID property of the specified object matches the inputted id, remove the object
            if(i.ID.equals(idInput)) {
            employeeList.remove(i);
            // Exit the loop to prevent concurrent modification
            break;
            }

        }
     // Return the array list of employees
     return employeeList;
    }
    public EmployeeForm() {
        initComponents();
        }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeDisplayArea = new javax.swing.JTextArea();
        idInput = new javax.swing.JTextField();
        firstNameInput = new javax.swing.JTextField();
        lastNameInput = new javax.swing.JTextField();
        annualSalaryInput = new javax.swing.JTextField();
        startDateInput = new javax.swing.JTextField();
        addEmployee = new javax.swing.JButton();
        RemoveEmployee = new javax.swing.JButton();
        listEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Employee Records");

        jLabel2.setText("ID #");

        jLabel3.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Annual Salary:");

        jLabel6.setText("Start Date:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Enter an ID# and press remove to ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("delete an Employee's Records.");

        employeeDisplayArea.setColumns(20);
        employeeDisplayArea.setRows(5);
        jScrollPane1.setViewportView(employeeDisplayArea);

        addEmployee.setText("Add");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        RemoveEmployee.setText("Remove");
        RemoveEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveEmployeeActionPerformed(evt);
            }
        });

        listEmployee.setText("List");
        listEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addEmployee)
                            .addComponent(RemoveEmployee)
                            .addComponent(listEmployee)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(28, 28, 28)
                                    .addComponent(lastNameInput))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(26, 26, 26)
                                    .addComponent(firstNameInput))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(startDateInput, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                        .addComponent(annualSalaryInput)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(addEmployee)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(RemoveEmployee)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(annualSalaryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(listEmployee)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEmployeeActionPerformed
        // Call the employeeDisplay method if the list button is pressed
        employeeDisplay(employeeList);
    }//GEN-LAST:event_listEmployeeActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        // Handles add button press
        // Declaring variables to be passed as parameters
        String firstName, lastName, id, annualSalary, startDate;
                
        // Input validation to ensure that all fields are filled out
        if (firstNameInput.getText().equals("") || lastNameInput.getText().equals("") 
                || idInput.getText().equals("") || annualSalaryInput.getText().equals("") || startDateInput.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please ensure that all fields are filled out.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
        
            // Get user input
            firstName = firstNameInput.getText();
            lastName = lastNameInput.getText();
            id = idInput.getText();
            annualSalary = annualSalaryInput.getText();
            startDate = startDateInput.getText();
            
            // Call the employeeAdd method, and pass the user inputs as parameters
            employeeList = employeeAdd(id, firstName,  lastName, annualSalary, startDate);
            
            // Clear each text field
            firstNameInput.setText("");
            lastNameInput.setText("");
            idInput.setText("");
            annualSalaryInput.setText("");
            startDateInput.setText("");
        }
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void RemoveEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveEmployeeActionPerformed
        // Handles remove button press
        
        // Declaring ID variable to be passed as a parameter
        String id;
        // Store the initial size of the employee array list to check if an employee removed
        int employeeTracker = employeeList.size();
        
        // Input vaidation to ensure that the ID field is filled out
        if (idInput.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please enter an ID.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            // Get user input
            id = idInput.getText();
            
            // Call the employeeRemove method and pass the user inputted ID, and employee array list as parameters
            employeeList = employeeRemove(employeeList, id);
            
            // Check if an employee has been removed
            if (employeeList.size() == employeeTracker) {
                // If not, display a message to user
                 JOptionPane.showMessageDialog(this,"This employee does not exist.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_RemoveEmployeeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RemoveEmployee;
    private javax.swing.JButton addEmployee;
    private javax.swing.JTextField annualSalaryInput;
    private javax.swing.JTextArea employeeDisplayArea;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameInput;
    private javax.swing.JButton listEmployee;
    private javax.swing.JTextField startDateInput;
    // End of variables declaration//GEN-END:variables
}
