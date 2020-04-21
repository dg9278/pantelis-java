/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingefficiencies;

/*
Programmer: David Guo
Date: 2019-08-07
Program Name: SortingEfficienciesForm
Program Description: Creates an application that uses a 4 different sorting routines
* to sort a random array from -10000 to 10000 of a user selected size in either
* ascending or descending order. Uses various tracking metrics to display the
* efficiency of each sorting method.
*/
public class SortingEfficienciesForm extends javax.swing.JFrame {

    /**
     * Creates new form SortingEfficienciesForm
     */
    /* Pre: User has inputted an array size
    * Post: An array of random numbers from -1000 to 1000 of user inputted size
    */
    public static int[] generateArray(int range) {
        // Create new array
        int[] randomArray = new int[range];
        // Loop through the array
        for (int i = 0; i < range; i++) {
            // Add a random number suing math.random of range -1000 - 1000 inclusive
            int randomNumber = (int)(Math.random() * 20000)-(10000) + 1;
            // Add number to array
            randomArray[i] = randomNumber;
        }
        // Return array
        return randomArray;
    }
    
    /*Pre: Random array has been generated, and either descending or ascending 
    * sort option has been selected.
    * Post: Array has been sorted using selection.
    */
    private void selectionSort(int[] randomArray, int order) {
        // Declare tracking variables
        int loopNo = 0;
        int compNo = 0;
        int shiftNo = 0;
        long startTime = System.currentTimeMillis();
                
        // Increment tracking variables based on operation
        // Order = 0 calls ascending order
        if (order == 0) {
            // Loop through the array
             for (int bound = 0; bound < randomArray.length ; bound++) {
                loopNo++;
            // Loop through the array using second number
                for (int j = bound+1; j < randomArray.length  ; j++) {
                    loopNo++;
                    // Check if first number is larger
                    if (randomArray[j] < randomArray[bound]) {
                        compNo++;
                        // Swap the found second element iwth the first
                        // Use temp for switch
                        int temp = randomArray[bound];
                        randomArray[bound] = randomArray[j];
                        randomArray[j] = temp;
                        shiftNo++;
                    }
                }

            }
        }
        
        // Perform same operation in desending sort order
        else {
            for (int bound = 0; bound < randomArray.length; bound++) {
                loopNo++;
                for (int j = bound+1; j < randomArray.length  ; j++) {
                    loopNo++;
                    // Key change: switch if first number is smaller than second number
                    if (randomArray[j] > randomArray[bound]) {
                        compNo++;
                        int temp = randomArray[bound];
                        randomArray[bound] = randomArray[j];
                        randomArray[j] = temp;
                        shiftNo++;
                    }
                }
            }
        
        }
        // Calculate time elapsed
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        
        // Display sorted array
        sortedDisplay.setText("");
        for (int i: randomArray) {
            sortedDisplay.append(Integer.toString(i) + "\n");
        }
        // Display tracking results
        resultDisplay.append("Selection Sort \n");
        resultDisplay.append("Number of times the loop was executed: " + Integer.toString(loopNo) + "\n");
        resultDisplay.append("Number of times a comparison was made: " + Integer.toString(compNo) + "\n");
        resultDisplay.append("Number of times a value was shifted: " + Integer.toString(shiftNo) + "\n");
        resultDisplay.append("Number of milliseconds to complete sort: " + Long.toString(elapsedTime) + "\n");
    }
    
    /* Pre: Array of random integers has been created, and either ascending
    * or descending order sort option has been selected.
    * Post: Array has been sorted using bubble sort.
    */
    private void bubbleSort(int[] randomArray, int order) {
         // Declare tracking variables
        int loopNo = 0;
        int compNo = 0;
        int shiftNo = 0;
        long startTime = System.currentTimeMillis();
        // Order = 0 calls ascending order
        if (order == 0) {
            // Create temp variable
            int temp = 0;
            // Loop through array
            for(int bound = 0; bound < randomArray.length; bound++) {
                loopNo++;
               // Loop through array with second number, decrementing by the bubbled top numbers
               for(int j=1; j < (randomArray.length - bound); j++) {
                   loopNo++;
                  // Switch if first element with second if first is larger using temp
                  if(randomArray[j-1] > randomArray[j]) { 
                     compNo++;
                     temp = randomArray[j-1];
                     randomArray[j-1] = randomArray[j];
                     randomArray[j] = temp;
                     shiftNo++;
                    }
                }
            }
        }
        
        // Repeat operation using descending order
        else {
            int temp = 0;

            for(int bound = 0; bound < randomArray.length; bound++) {
                loopNo++;
               for(int j=1; j < (randomArray.length - bound); j++) {
                   loopNo++;
                  // Key change: switch if first number is smaller than second number
                  if(randomArray[j-1] < randomArray[j]) {
                    compNo++;
                    temp = randomArray[j-1];
                    randomArray[j-1] = randomArray[j];
                    randomArray[j] = temp;
                    shiftNo++;
                    }
                }
            }
            
        }
        // Display sorted array`
        sortedDisplay.setText("");
        for (int i: randomArray) {
            sortedDisplay.append(Integer.toString(i) + "\n");
        }
        
        // Calculate time used
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
       
        // Display efficiency results
        resultDisplay.append("Bubble Sort \n");
        resultDisplay.append("Number of times the loop was executed: " + Integer.toString(loopNo) + "\n");
        resultDisplay.append("Number of times a comparison was made: " + Integer.toString(compNo) + "\n");
        resultDisplay.append("Number of times a value was shifted: " + Integer.toString(shiftNo) + "\n");
        resultDisplay.append("Number of milliseconds to complete sort: " + Long.toString(elapsedTime) + "\n");
       
    }
    
    /* Pre: Array of random integers has been created, and either ascending
    * or descending order sort option has been selected.
    * Post: Array has been sorted using insertion sort.
    */
    private void insertionSort(int[] randomArray, int order) {
        // Declare tracking variables
        int loopNo = 0;
        int compNo = 0;
        int shiftNo = 0;
        long startTime = System.currentTimeMillis();

        // Order = 0 calls ascending order
        if (order == 0) {  
            // Loop through array
            for (int j = 1; j < randomArray.length; j++) {  
                loopNo++;
              /*While loop that switches the indicated smaller element with 
              * the previous larger one until it is in the correct position
              */
               while ((j > 0) && (randomArray[j -1]  > randomArray[j])){   
                   loopNo++;
                   compNo++;
                  // Switch elements using temp
                  int temp = randomArray[j]; 
                  randomArray[j] = randomArray[j-1];
                  randomArray[j-1] = temp;
                  shiftNo++;
                  // Decrement j to continue switching loop
                  j-= 1;
               }  
            }
        }
        // Repeat operation for descending order
        else {
             for (int j = 1; j < randomArray.length; j++) {  
                 loopNo++;
               // Key change: switch if first number is smaller than second number
               while ((j > 0) && (randomArray[j -1] < randomArray[j])){  
                   loopNo++;
                   compNo++;
                  int temp = randomArray[j]; 
                  randomArray[j] = randomArray[j-1];
                  randomArray[j-1] = temp;
                  shiftNo++;
                  j-= 1;
               }  
            }
        }
        
        // Display sorted array
        sortedDisplay.setText("");
        for (int i: randomArray) {
            sortedDisplay.append(Integer.toString(i) + "\n");
        }
        
        // Calculate time used
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
       
        // Display efficiency results
        resultDisplay.append("Insertion Sort  \n");
        resultDisplay.append("Number of times the loop was executed: " + Integer.toString(loopNo) + "\n");
        resultDisplay.append("Number of times a comparison was made: " + Integer.toString(compNo) + "\n");
        resultDisplay.append("Number of times a value was shifted: " + Integer.toString(shiftNo) + "\n");
        resultDisplay.append("Number of milliseconds to complete sort: " + Long.toString(elapsedTime) + "\n");
    }
    
    // Create a class to pass tracking variables through recursion
    class QuickSortTracker {
        int loopNo;
        int compNo;
        int shiftNo;
 
        QuickSortTracker(int loop, int comp, int shift) {
            loopNo = loop;
            compNo = comp;
            shiftNo = shift;
            
        }
    }
    /* Pre: Array of random integers has been generated, and ascending or 
    * descending sort option has been selected.
    * Post:  Array has been sorted using quick sort.
    */
    public void quickSortLauncher(int[] randomArray, int order) {
        // Create new tracker object
        QuickSortTracker tracker = new QuickSortTracker(0,0,0);
        int bottom = 0;
        int top = randomArray.length - 1;
        
        // Initialize start time
        long startTime = System.currentTimeMillis(); 
        // Handle ascending case
        if (order == 0) {
            // Pass tracker, and return updated variables
           QuickSortTracker displayTracker = quickSortAscending(randomArray, bottom, top, tracker);
           // Calculate time used
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            // Display efficiency results
            resultDisplay.append("Quick Sort \n");
            resultDisplay.append("Number of times the loop was executed: " + Integer.toString(tracker.loopNo) + "\n");
            resultDisplay.append("Number of times a comparison was made: " + Integer.toString(tracker.compNo) + "\n");
            resultDisplay.append("Number of times a value was shifted: " + Integer.toString(tracker.shiftNo) + "\n");
            resultDisplay.append("Number of milliseconds to complete sort: " + Long.toString(elapsedTime) + "\n");
        }
        else {
            // Pass tracker, and return updated variables
            QuickSortTracker displayTracker = quickSortDescending(randomArray, bottom, top, tracker);
             // Calculate time used
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
             // Display efficiency results
            resultDisplay.append("Quick Sort \n");
            resultDisplay.append("Number of times the loop was executed: " + Integer.toString(tracker.loopNo) + "\n");
            resultDisplay.append("Number of times a comparison was made: " + Integer.toString(tracker.compNo) + "\n");
            resultDisplay.append("Number of times a value was shifted: " + Integer.toString(tracker.shiftNo) + "\n");
            resultDisplay.append("Number of milliseconds to complete sort: " + Long.toString(elapsedTime) + "\n");
        }  
    }
    
    /* Pre: Method has been called from quickSortLauncher, and the bottom and top
    * variables have been created.
    * Post: A new subarray has been created for sorting.
    */
     public QuickSortTracker quickSortAscending(int[] randomArray, int bottom, int top, QuickSortTracker tracker) {
        
        // Check if bottom and top pointers have met.
        if (bottom < top) {
            tracker.compNo++;
            // Call the partition method and assign it to the partition index (pivot)
             // Set pivot the last element
            int pivot = randomArray[top];
            tracker.shiftNo++;
            // Decrement bottom
            int i = (bottom-1);

            // Loop trhough array
            for (int j = bottom; j < top; j++) {
                tracker.loopNo++;
                // If indicated element is less than the last element
                if (randomArray[j] <= pivot) {
                    tracker.compNo++;
                    // Increment bottom
                    i+= 1;

                    // Switch element so that it is on the correct side of the pivot
                    int temp = randomArray[i];
                    randomArray[i] = randomArray[j];
                    randomArray[j] = temp;
                    tracker.shiftNo++;
                }
            }

            // Set this new pivot as the last element
            int temp = randomArray[i+1];
            randomArray[i+1] = randomArray[top];
            randomArray[top] = temp;
            tracker.shiftNo++;
            
            int partitionRef = i+1;
            
            // Recursion until trivial case of partitioning a subarray with 1 or no elements
            // First handles bottom subarray
            quickSortAscending(randomArray, bottom, partitionRef - 1, tracker);
            // Second handles top subarray
            quickSortAscending(randomArray, partitionRef + 1, top, tracker);
            
        }
        // Display sorted array, as array cannot be passed through object
        // Slows down method
        sortedDisplay.setText("");
        for (int i: randomArray) {
            sortedDisplay.append(Integer.toString(i) + "\n");
        }
        return tracker;
    }  
         
    // Repeat operation on descending order
    public QuickSortTracker quickSortDescending(int[] randomArray, int bottom, int top, QuickSortTracker tracker) {
        if (bottom < top) {
            tracker.compNo++;
            int pivot = randomArray[top];
            tracker.shiftNo++;
            int i = (bottom-1);

            for (int j = bottom; j < top; j++) {
                tracker.loopNo++;
                // Key change: switch which side of the pivot the element is placed 
                if (randomArray[j] >= pivot) {
                    tracker.compNo++;
                    i+= 1;
                    
                    int temp = randomArray[i];
                    randomArray[i] = randomArray[j];
                    randomArray[j] = temp;
                    tracker.shiftNo++;
                }
            }

            int temp = randomArray[i+1];
            randomArray[i+1] = randomArray[top];
            randomArray[top] = temp;
            tracker.shiftNo++;
             
            int partitionRef = i+1;
            
            quickSortDescending(randomArray, bottom, partitionRef - 1, tracker);
            quickSortDescending(randomArray, partitionRef + 1, top, tracker);
            
        }
        
        sortedDisplay.setText("");
        for (int i: randomArray) {
            sortedDisplay.append(Integer.toString(i) + "\n");
        }
        return tracker;
        
    }  
  
    public SortingEfficienciesForm() {
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

        numberOfItems = new javax.swing.ButtonGroup();
        sortType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ten = new javax.swing.JRadioButton();
        oneHundred = new javax.swing.JRadioButton();
        oneThousand = new javax.swing.JRadioButton();
        tenThousand = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        ascendingSort = new javax.swing.JRadioButton();
        descendingSort = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orgDisplay = new javax.swing.JTextArea();
        sortButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultDisplay = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sortedDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sorting Efficiencies");

        jLabel2.setText("Enter the amount of Numbers in the List: ");

        numberOfItems.add(ten);
        ten.setText("10");

        numberOfItems.add(oneHundred);
        oneHundred.setText("100");

        numberOfItems.add(oneThousand);
        oneThousand.setText("1000");

        numberOfItems.add(tenThousand);
        tenThousand.setText("10000");

        jLabel3.setText("Sort Order");

        sortType.add(ascendingSort);
        ascendingSort.setText("Ascending");

        sortType.add(descendingSort);
        descendingSort.setText("Descending");

        jLabel4.setText("Original Numbers");

        orgDisplay.setColumns(20);
        orgDisplay.setRows(5);
        jScrollPane1.setViewportView(orgDisplay);

        sortButton.setText("Sort Numbers");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Sort Results:");

        resultDisplay.setColumns(20);
        resultDisplay.setRows(5);
        jScrollPane2.setViewportView(resultDisplay);

        jLabel6.setText("Sorted Numbers");

        sortedDisplay.setColumns(20);
        sortedDisplay.setRows(5);
        jScrollPane3.setViewportView(sortedDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descendingSort)
                            .addComponent(ascendingSort)
                            .addComponent(sortButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ten)
                        .addGap(18, 18, 18)
                        .addComponent(oneHundred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oneThousand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenThousand)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten)
                    .addComponent(oneHundred)
                    .addComponent(oneThousand)
                    .addComponent(tenThousand))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(ascendingSort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descendingSort)
                                .addGap(20, 20, 20)
                                .addComponent(sortButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        
        // Initial variable for array size
        int range = 0;
        // Initial state for ascending or descending
        int order = 2;
        
        // Handle user array size JRadio button presses
        if (ten.isSelected()) {
            range = 10;
        }
        if (oneHundred.isSelected()) {
            range = 100;
        }
        if (oneThousand.isSelected()) {
            range = 1000;
        }
        if (tenThousand.isSelected()) {
            range = 10000;
        }
        
        // Generate and display original random array
        int[] ogArray = generateArray(range);
        orgDisplay.setText("");
         for (int i: ogArray) {
            orgDisplay.append(Integer.toString(i) + "\n");
        }
              
        // Handle sorting method radio button presses
        // Assign 0 if ascending is selected, 1 if descending is selected
        if (ascendingSort.isSelected()) {
            order = 0;
        }
        else if (descendingSort.isSelected()) {
            order = 1;
        }
        
        // Clear result display
        resultDisplay.setText("");
        
        // Run through each sorting method
        selectionSort(ogArray, order);
        bubbleSort(ogArray, order);
        insertionSort(ogArray, order);
        quickSortLauncher(ogArray, order);
        

    }//GEN-LAST:event_sortButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SortingEfficienciesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortingEfficienciesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortingEfficienciesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortingEfficienciesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingEfficienciesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascendingSort;
    private javax.swing.JRadioButton descendingSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.ButtonGroup numberOfItems;
    private javax.swing.JRadioButton oneHundred;
    private javax.swing.JRadioButton oneThousand;
    private javax.swing.JTextArea orgDisplay;
    private javax.swing.JTextArea resultDisplay;
    private javax.swing.JButton sortButton;
    private javax.swing.ButtonGroup sortType;
    private javax.swing.JTextArea sortedDisplay;
    private javax.swing.JRadioButton ten;
    private javax.swing.JRadioButton tenThousand;
    // End of variables declaration//GEN-END:variables
}
