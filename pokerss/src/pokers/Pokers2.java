package pokers;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Pokers2 extends javax.swing.JFrame {
  private Kaulins[] kaulins=new Kaulins[5];
    private int[] punkti=new int[5];
    kombinacijas komb;
    private JLabel[] laukums = new JLabel[13];
    private int gajiensk = 0;
    private int punktikop = 0;
    boolean[] parbaud = new boolean[13];
    private int cikgajieni = 0;
    Method method;
    String[]nosaukumi ={
        "Vieninieki","Divneiki","Trijnieki","Četrinieki","Piecinieki","Sešinieki","Trīs vienādi","Četri vienādi","Pilna māja","Īsais taisnais","Garais taisnais","Chance","Yahtzee"
    };
    JButton[]kombpogas = new JButton[13];
    
    public Pokers2() {
        initComponents();
        for(int i=0;i<5;i++){
            kaulins[i]=new Kaulins();
            kaulins[i].setPreferredSize(new java.awt.Dimension(35,35));
            kaulins[i].setFont(new java.awt.Font("Tahoma", 1, 18));
            jPanel1.add(kaulins[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(200+40*i, 47, -1, -1));
            kaulins[i].setEnabled(false);
        }
        for(int i=0;i<13;i++){
            laukums[i] = new JLabel(nosaukumi[i] + ": 0");
            laukums[i].setPreferredSize(new java.awt.Dimension(120, 18));
            laukums[i].setFont(new java.awt.Font("Tahoma", 0, 14));
            jPanel3.add(laukums[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24*i, -1, -1));
            kombpogas[i] = new JButton();
            kombpogas[i].setText(nosaukumi[i]);
            kombpogas[i].setEnabled(false);
            jPanel1.add(kombpogas[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35*i, -1, -1));
            kombpogas[i].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(int i=0;i<13;i++){
                    kombpogas[i].setEnabled(false);
                }
                for(int i=0;i<5;i++){
                    kaulins[i].setEnabled(true);
                    kaulins[i].setSelected(false);
                }
                try {
                    JButton poga=(JButton)evt.getSource();
                    poga.setForeground(Color.red);
                    poga.setEnabled(false);
                    gajiensk = 0;
                    jToggleButton1.setEnabled(true);
                    int kartNr=Arrays.asList(nosaukumi).indexOf(poga.getText());
                    parbaud[kartNr] = true;
                    method  = kombinacijas.class.getDeclaredMethod("cik" + (kartNr + 1));
                    int x=(Integer)method.invoke(komb);
                    punktikop = punktikop + x;
                    punktiKopa.setText(punktikop + "");
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(Pokers2.class.getName()).log(Level.SEVERE, null, ex);
                }
                cikgajieni++;
                if(cikgajieni == 13) spele_beigta();
            }
        });
        }
        pack();
    }
    public void spele_beigta(){
        JOptionPane.showMessageDialog(this, "Jūs ieguvāt " + punktikop + " punktus!");
                System.exit(0);
    }

    public Kaulins[] metiens() {
        for(int i=0;i<13;i++){
            if(kombpogas[i].getForeground()!=Color.red)        
                kombpogas[i].setEnabled(true);
        }
        if(cikgajieni == 0){
            for(int i=0;i<13;i++){
                kombpogas[i].setEnabled(true);
            }
        }
        for(int i=0;i<5;i++){
            if(!kaulins[i].isSelected() || gajiensk==0){
                kaulins[i].mest();
            }
            punkti[i] = kaulins[i].getN();
        }
        if(gajiensk==0){
            for(int i=0;i<5;i++){
                kaulins[i].setEnabled(true);
                kaulins[i].setSelected(false);
            }
        }
        komb = new kombinacijas(punkti);
        
        for(int i=1;i<14;i++){
            try {
                Method method  = kombinacijas.class.getDeclaredMethod("cik" + i);
                int x=(Integer)method.invoke(komb);
                if(parbaud[i-1] == false)laukums[i-1].setText(nosaukumi[i-1] + ": " + x);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Pokers2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kaulins;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        punktiKopa = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Punkti kopā:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));
        getContentPane().add(punktiKopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 30, 20));

        jToggleButton1.setText("Mest");
        jToggleButton1.setAlignmentY(0.0F);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 160, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        metiens();
        
        if(gajiensk == 2){
            gajiensk = 0;
            jToggleButton1.setEnabled(false);
            for(int i=0;i<5;i++){
                    kaulins[i].setEnabled(true);
                    kaulins[i].setSelected(false);
            }
        }
        else{
            gajiensk++;
            jToggleButton1.setEnabled(true);
            jToggleButton1.setSelected(false);
            for(int i=0;i<5;i++){
                kaulins[i].setEnabled(true);
            }
        }
        if(gajiensk == 0){
            
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pokers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokers2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel punktiKopa;
    // End of variables declaration//GEN-END:variables
}
