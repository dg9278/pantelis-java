/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reducefraction;

import javax.swing.JOptionPane;

/*
Programmer: David Guo
Date: 2019-08-06
Program Name: ReduceFractionForm
Program Description: Creates an application that uses a recursive GCD 
* function to reduce a fraction to the lowest terms.
*/
public class ReduceFractionForm extends javax.swing.JFrame {

    /* Pre: User has inputted both the numerator and denominator.
    * Post: Recursive method has calculated the GCD.
    */
    public static long greatestCommonDenominator(long num, long den) {
        // Base case where second number is 0
        if (den < 1) {
            return num;
        }
        // Recursive condition
        // First number is denominator  
        // Second number is the remainder of numerator/denominator
        // Passes these numbers when called from definition
        // Reduces numbers until one is 0
        else {
            return greatestCommonDenominator(den, num % den);
        }
    }
    
    /* Pre: User has inputted both the numeratora and denominator. Recursive 
    * GCD method has been defined.
    * Post: Fractino has been reduced and converted to a string.   
    */
    public static String reduceFraction(long num, long den) {
        // Declare initial string variable.
        String fraction;
        
        // Call GCD method and calculate GCD.
        long GCD = greatestCommonDenominator(num, den);
        
        // Divide numerator and denominator by GCD and display it as a fraction string
        fraction = Long.toString(num/GCD) + "/" + Long.toString(den/GCD);
        
        // Return fraction string
        return fraction;
    }
    
    
    public ReduceFractionForm() {
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
        reduce = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fractionDisplay = new javax.swing.JTextArea();
        numeratorInput = new javax.swing.JTextField();
        denominatorInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Fraction Reducer");

        jLabel2.setText("This program will reduce a fraction to lowest terms.");

        jLabel3.setText("Enter the numerator:");

        jLabel4.setText("Enter the denominator:");

        reduce.setText("Reduce Fraction To Lowest Terms");
        reduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceActionPerformed(evt);
            }
        });

        fractionDisplay.setColumns(20);
        fractionDisplay.setRows(5);
        jScrollPane1.setViewportView(fractionDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(reduce))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(denominatorInput, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(numeratorInput)))
                            .addComponent(jLabel2))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numeratorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(denominatorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(reduce)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reduceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceActionPerformed
        // Declare initial long variables
        long numerator, denominator;
        
        // Input validation to check user input is an integer
        try {
               numerator = Long.parseLong(numeratorInput.getText());
               denominator = Long.parseLong(denominatorInput.getText());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
        // Call and display result of the fraction reducer method
        fractionDisplay.setText(Long.toString(numerator) + "/" + 
                Long.toString(denominator) + " in lowest terms is: " 
                + reduceFraction(numerator, denominator));
               
    }//GEN-LAST:event_reduceActionPerformed

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
            java.util.logging.Logger.getLogger(ReduceFractionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReduceFractionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReduceFractionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReduceFractionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReduceFractionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField denominatorInput;
    private javax.swing.JTextArea fractionDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeratorInput;
    private javax.swing.JButton reduce;
    // End of variables declaration//GEN-END:variables
}
