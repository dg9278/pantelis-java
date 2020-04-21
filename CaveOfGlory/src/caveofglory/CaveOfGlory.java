package caveofglory;
/**
 * @author Adam Holan, James Hepburn, David Guo
 * @date 8/8/2019
 * @course ICS4U
 * Description: A Java GUI-Text based adventure game
 */


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CaveOfGlory extends javax.swing.JFrame {

    // Instatiate a new player
    player p = new player();

    // Instantiate image icons
    ImageIcon afterStart = new ImageIcon("afterStart.png");
    ImageIcon crossroads = new ImageIcon("crossroads.jpg");
    ImageIcon afterCrossroads = new ImageIcon("afterCrossroads.jpg");
    ImageIcon after2ndBattle = new ImageIcon("after2ndBattle.png");
    ImageIcon afterLava = new ImageIcon("afterLava.jpg");
    ImageIcon lake = new ImageIcon("lake.png");
    ImageIcon lastBattle = new ImageIcon("lastBattle.jpg");
    ImageIcon treasure = new ImageIcon("treasure.jpg");
    ImageIcon home = new ImageIcon("home.jpg");

    public static String[] ok = {"Ok"};
    public static String[] battle = {"Attack", "Defend"};
    public static String[] next = {"Next"};
    public static String[] option1 = {"Stay here", "Explore the cave"};
    public static String[] exit = {"Exit"};
    public static String[] answerToZurd = {"Uh, it's, uh, I'm, um-"};
    public static String[] fight = {"Let's fight!"};
    public static String[] option2 = {"Find a way out of the cave", "Search for the treasure"};
    public static String[] option3 = {"The left path", "The right path"};
    public static String[] option4 = {"Flee", "Battle the goblin"};
    public static String[] option5 = {"Run across quickly", "Jump from platform to platform"};
    public static String[] option6 = {"Keep walking", "Relax and take a swim"};
    public static String[] option7 = {"Potion A", "Potion B"};
    public static String[] wish = {"I wish to go home"};

    public CaveOfGlory() {
        initComponents();
        goblin1.setVisible(false);
        goblin2.setVisible(false);
        goblin3.setVisible(false);
        goblin4.setVisible(false);
    }
    
    public class player {
    int attack = 2;
    int health = 30;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        goblin1 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        goblin2 = new javax.swing.JLabel();
        goblin3 = new javax.swing.JLabel();
        goblin4 = new javax.swing.JLabel();
        lbPlayerHealth = new javax.swing.JLabel();
        lbEnemyHealth = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Westwood LET", 0, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Cave of Glory");
        getContentPane().add(title);
        title.setBounds(110, 50, 293, 62);

        goblin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caveofglory/goblin1.png"))); // NOI18N
        getContentPane().add(goblin1);
        goblin1.setBounds(380, 180, 120, 130);

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart);
        btnStart.setBounds(230, 180, 60, 33);

        goblin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caveofglory/goblin2.png"))); // NOI18N
        getContentPane().add(goblin2);
        goblin2.setBounds(60, 130, 100, 160);

        goblin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caveofglory/goblin3.png"))); // NOI18N
        getContentPane().add(goblin3);
        goblin3.setBounds(270, 150, 110, 150);

        goblin4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caveofglory/goblin4.png"))); // NOI18N
        getContentPane().add(goblin4);
        goblin4.setBounds(170, 120, 148, 175);

        lbPlayerHealth.setBackground(new java.awt.Color(255, 255, 255));
        lbPlayerHealth.setForeground(new java.awt.Color(255, 255, 255));
        lbPlayerHealth.setText("Your Health: ");
        getContentPane().add(lbPlayerHealth);
        lbPlayerHealth.setBounds(30, 30, 120, 16);

        lbEnemyHealth.setBackground(new java.awt.Color(255, 255, 255));
        lbEnemyHealth.setForeground(new java.awt.Color(255, 255, 255));
        lbEnemyHealth.setText("Enemy's Health: ");
        getContentPane().add(lbEnemyHealth);
        lbEnemyHealth.setBounds(380, 30, 100, 16);

        background.setForeground(new java.awt.Color(255, 255, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caveofglory/startMenu.jpg"))); // NOI18N
        background.setText("");
        background.setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().add(background);
        background.setBounds(0, 0, 520, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void fight(String name, int eAttack, int eHealth) {

        // Display health labels
        lbPlayerHealth.setVisible(true);
        lbEnemyHealth.setVisible(true);

        // Show health for each entity
        lbPlayerHealth.setText("Your Health: " + p.health);
        lbEnemyHealth.setText("Enemy's Health: " + eHealth);

        while (p.health > 0 && eHealth > 0) {

            // First option, display the option to attack / defend
            int c = JOptionPane.showOptionDialog(null, "What will you do?", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, battle, battle[0]);

            // If the user chooses attack
            if (c == 0) {

                // Decrease the enemy's health
                eHealth -= p.attack;

                // Display how much damage the user dealt
                int a = JOptionPane.showOptionDialog(null, "You dealt " + p.attack + " damage!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);

                // This code determines if the enemy will hit. The user always hits because otherwise it's really no fun.
                if ((Math.random() * 10) > 5) {

                    // If the enemy hits, deal damage
                    int ea = JOptionPane.showOptionDialog(null, "The enemy dealt " + eAttack + " damage!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
                    p.health -= eAttack;

                    // If they missed, tell the user        
                } else {
                    int em = JOptionPane.showOptionDialog(null, "The enemy missed!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
                }

                // If the user decides to defend   
            } else if (c == 1) {

                // "You braced yourself" message
                int a = JOptionPane.showOptionDialog(null, "You braced yourself for an attack!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);

                // Determines if the enemy attacks or misses. Only does 1 damage anyway.
                if ((Math.random() * 10) > 5) {
                    int ea = JOptionPane.showOptionDialog(null, "The enemy dealt " + eAttack / eAttack + " damage!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
                    p.health -= eAttack / eAttack;
                } else {
                    int em = JOptionPane.showOptionDialog(null, "The enemy missed!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
                }
            }

            // Show health for each entity
            lbPlayerHealth.setText("Your Health: " + p.health);
            lbEnemyHealth.setText("Enemy's Health: " + eHealth);
        }

        // If the user won, level him up! This gives the user a sense of progression
        if (p.health > 0 && eHealth <= 0) {
            int w = JOptionPane.showOptionDialog(null, "You Win!!!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
            int l = JOptionPane.showOptionDialog(null, "Level UP! Health and Attack Increased!", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
            p.attack += 2;
            p.health += 5;

            // If the user dies, tell them they died and quit.    
        } else {
            int f = JOptionPane.showOptionDialog(null, "You Died. Better luck next time.", name, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ok, ok[0]);
            System.exit(0);
        }

        // Hide health labels for outiside of combat
        lbPlayerHealth.setVisible(false);
        lbEnemyHealth.setVisible(false);
    }

    public void option1EitherChoice() {

        // Show the first goblin
        goblin1.setVisible(true);

        // Display dialogue with the goblin
        int e = JOptionPane.showOptionDialog(null, "Hey!!! Who are you?! What are you doing here?!", "Zurd", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answerToZurd, answerToZurd[0]);
        int f = JOptionPane.showOptionDialog(null, "Silence! You are trespassing in my cave, how dare you?! I'll tell you what, if you fight me and win, I'll help you out.", "Zurd", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fight, fight[0]);

        // Insert Fight
        fight("Zurd", 2, 10);

        // Advance story
        int g = JOptionPane.showOptionDialog(null, "You were a great opponent so I will tell you a secret: buried deep within this cave is a treasure. To find it you will need to defeat 3 montsouris goblins, each worse than the last. I must go now. Choose wisely.", "Zurd", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[0]);
        System.out.print(g);

        // Make goblin invisible
        goblin1.setVisible(false);

        // If you choose to find an exit you die (0), choose to find trasure progress(1)
        if (g == 0) {
            option2Choice1();
        } else if (g == 1) {
            option2Choice2();
        }
    }

    public void option2Choice1() {

        // Die, close game
        int h = JOptionPane.showOptionDialog(null, "You searched for days with no luck. You eventually ran into another goblin but were too weak to fight it so you were eaten alive. Maybe you should have chosen another path.", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option2Choice2() {

        // Advance story
        int i = JOptionPane.showOptionDialog(null, "You decide to search for the treasure. After an hour, you come across a crossroads.", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        background.setIcon(crossroads);
        int j = JOptionPane.showOptionDialog(null, "Huh, it looks like the path splits into two. Which path should I take?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option3, option3[0]);

        // Left path(0) kills you, right(1) does not
        if (j == 0) {
            option3Choice1();
        } else if (j == 1) {
            option3Choice2();
        }
    }

    public void option3Choice1() {

        // Die and close game
        int k = JOptionPane.showOptionDialog(null, "This path led straight down into a 90 foot drop where you fell to your death. Maybe you should have chosen another path", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option3Choice2() {

        // Display new sprites
        background.setIcon(afterCrossroads);
        goblin2.setVisible(true);

        // Advance story
        int l = JOptionPane.showOptionDialog(null, "Hmm, I'll take the right path ... I think I see something ... That must be the next goblin, what should I do?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option4, option4[0]);

        // Fleeing(0) kills you, battling(1) takes you into a battle 
        // Hint: Fleeing will always kill you
        if (l == 0) {
            option4Choice1();
        } else if (l == 1) {
            option4Choice2();
        }
    }

    public void option4Choice1() {

        // Kill player and close game 
        int m = JOptionPane.showOptionDialog(null, "You fled the battle but were so distraught that you couldn’t remember the way out. You got lost and eventually died of dehydration. Maybe you should have chosen another path", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option4Choice2() {

        // Advance story
        int n = JOptionPane.showOptionDialog(null, "Hey, you there!! Are you the first goblin I must face in order to find the great treasure?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int o = JOptionPane.showOptionDialog(null, "Yes it is I, Freg. I am your first challenge. I must warn you, very few have ever beaten me. Goodluck, mortal.", "Freg", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fight, fight[0]);

        // Battle against Freg
        fight("Freg", 5, 15);

        // Advance story and load up new sprites
        int p = JOptionPane.showOptionDialog(null, "Wow, you did it. I can't believe it. You won't beat the next goblin though, he is much stronger than you or I.", "Freg", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        goblin2.setVisible(false);
        background.setIcon(after2ndBattle);
        int q = JOptionPane.showOptionDialog(null, "After your victory, you set off in search of the 2nd goblin. You walked and walked until you reached...", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int r = JOptionPane.showOptionDialog(null, "Is that lava?? This is the only way though so I guess I will have to cross. How should I do this?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option5, option5[0]);

        // Running(0) lets you progress, hopping the rocks(1) kills you
        if (r == 1) {
            option5Choice2();
        } else if (r == 0) {
            option5Choice1();
        }
    }

    public void option5Choice2() {

        // Kill user and close
        int s = JOptionPane.showOptionDialog(null, "You decided to jump from platform to platform. Sadly, you missed a platform and burned to death. Maybe you should have chosen another path", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option5Choice1() {

        // Load up new sprites and continue story
        background.setIcon(afterLava);
        goblin3.setVisible(true);
        int t = JOptionPane.showOptionDialog(null, "You ran across the path quickly and thankfully, survived unharmed. Off in the distance you see your next opponent, Klorx.", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int u = JOptionPane.showOptionDialog(null, "You there!! I am in search of the treasure and you are my next opponent! Let's do this!!", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int v = JOptionPane.showOptionDialog(null, "HAHA. You want to fight me? You're going down!", "Klorx", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fight, fight[0]);

        // Fight Klorx
        fight("Klorx", 7, 15);

        // Advance story and display new sprites
        int w = JOptionPane.showOptionDialog(null, "What?!?! How did you do that?! Get out of my way!", "Klorx", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        goblin3.setVisible(false);
        background.setIcon(lake);
        int x = JOptionPane.showOptionDialog(null, "I guess I better get going ... Wow, look at that. That lake is so beautiful. Maybe I should take a rest here.", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option6, option6[0]);

        // Swimming(0) kills you, which is kind of obvious. Just keep walking(1)
        if (x == 1) {
            option6Choice1();
        } else if (x == 0) {
            option6Choice2();
        }
    }

    public void option6Choice1() {

        // kill user and close game
        int y = JOptionPane.showOptionDialog(null, "You decide to go for a swim but a shark comes out of nowhere and bites off your leg. You bleed to death. Maybe you should have chosen another path", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option6Choice2() {

        // Display new sprites and advance story
        background.setIcon(lastBattle);
        goblin4.setVisible(true);
        int z = JOptionPane.showOptionDialog(null, "Eh, I am not too tired yet. I'll keep going, I think I see the last goblin anyways.", "you", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int zA = JOptionPane.showOptionDialog(null, "Who goes there?! How could such a tiny mortal make it this far?! This all ends now", "Vex", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fight, fight[0]);

        // Fight Vex
        fight("Vex", 10, 20);

        // Advance story
        int zB = JOptionPane.showOptionDialog(null, "How on earth did you do that?! This is insane, no one has ever beaten me! Fine though, the treasure is right down there.", "Vex", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        background.setIcon(treasure);
        goblin4.setVisible(false);
        int zC = JOptionPane.showOptionDialog(null, "You rush over to the treasure chest and open it. Inside there are 2 potions and a note that reads: One will kill and the other grants a wish. Choose wisely.", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int zD = JOptionPane.showOptionDialog(null, "Wow, what should I do? If I choose wrong I could die but if I choose the right one I could wish to go home and I'll have all this gold.", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option7, option7[0]);

        // Potion A(0) kills you, Potion B(1) takes you back home and ends the game
        if (zD == 0) {
            option7Choice1();
        } else if (zD == 1) {
            option7Choice2();
        }
    }

    public void option7Choice1() {

        // Kill the user and close the game. So close too.
        int zE = JOptionPane.showOptionDialog(null, "You chose potion A. Sadly, it was filled with poison and you died instantly. Maybe you should have chosen another path", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    public void option7Choice2() {

        // Finish the story and close the game
        int zF = JOptionPane.showOptionDialog(null, "You chose the right potion. Now take your gold and make your wish ...", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, wish, wish[0]);
        background.setIcon(home);
        int zG = JOptionPane.showOptionDialog(null, "You have won the game! Congratulations!", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        System.exit(0);
    }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        // Display necessary sprites and advance story
        background.setIcon(afterStart);
        title.setVisible(false);
        btnStart.setVisible(false);

        int a = JOptionPane.showOptionDialog(null, "... What ... what happened? ... How did I get here?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
        int b = JOptionPane.showOptionDialog(null, "... I guess I am all alone ... What should I do?", "You", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option1, option1[0]);

        // Both options make you fight the goblin for the sake of progression
        if (b == 0) {
            int c = JOptionPane.showOptionDialog(null, "You stayed where you were and eventually fell asleep. When you woke up, you came face to THIS", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
            option1EitherChoice();
        } else if (b == 1) {
            int d = JOptionPane.showOptionDialog(null, "You explored the cave and after a while, you came face to THIS", "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]);
            option1EitherChoice();
        }


    }//GEN-LAST:event_btnStartActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaveOfGlory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaveOfGlory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaveOfGlory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaveOfGlory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CaveOfGlory c = new CaveOfGlory();
                c.setVisible(true);

                // This is to fix a bug that caused the window to start off as (0, 0) px
                c.setSize(535, 370);

                // This is to disable health from showing up outside combat
                c.lbPlayerHealth.setVisible(false);
                c.lbEnemyHealth.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel goblin1;
    private javax.swing.JLabel goblin2;
    private javax.swing.JLabel goblin3;
    private javax.swing.JLabel goblin4;
    private javax.swing.JLabel lbEnemyHealth;
    private javax.swing.JLabel lbPlayerHealth;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
