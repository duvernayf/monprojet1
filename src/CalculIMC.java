/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class CalculIMC extends java.awt.Frame {

    /**
     * Creates new form CalculIMC
     */
    public CalculIMC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        tfPoids = new java.awt.TextField();
        label3 = new java.awt.Label();
        tfTaille = new java.awt.TextField();
        label4 = new java.awt.Label();
        tfIMC = new java.awt.TextField();
        tfInterpretation = new java.awt.TextField();
        btnCalculer = new java.awt.Button();
        btnNouveau = new java.awt.Button();
        btnFermer = new java.awt.Button();

        setMinimumSize(new java.awt.Dimension(300, 200));
        setName("frmMain"); // NOI18N
        setSize(new java.awt.Dimension(300, 200));
        setTitle("Calcul de l’IMC ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Poids  (en kg)");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        tfPoids.setName("tfPoids"); // NOI18N
        tfPoids.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                ValidationTextListener(evt);
            }
        });
        add(tfPoids, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 80, -1));
        tfPoids.getAccessibleContext().setAccessibleName("tfPoids");

        label3.setText("Taille (en m)");
        add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        tfTaille.setName("tfTaille"); // NOI18N
        tfTaille.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                ValidationTextListener(evt);
            }
        });
        add(tfTaille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 80, -1));
        tfTaille.getAccessibleContext().setAccessibleName("tfTaille");

        label4.setText("Votre IMC");
        add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        tfIMC.setEditable(false);
        tfIMC.setName("tfIMC"); // NOI18N
        add(tfIMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 80, -1));
        tfIMC.getAccessibleContext().setAccessibleName("tfIMC");

        tfInterpretation.setEditable(false);
        tfInterpretation.setName("tfInterpretation"); // NOI18N
        add(tfInterpretation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 260, 20));
        tfInterpretation.getAccessibleContext().setAccessibleName("tfInterpretation");

        btnCalculer.setLabel("Calculer");
        btnCalculer.setName("btnCalculer"); // NOI18N
        btnCalculer.setEnabled(false);
        btnCalculer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculerActionPerformed(evt);
            }
        });
        add(btnCalculer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 70, -1));
        btnCalculer.getAccessibleContext().setAccessibleName("btnCalculer");

        btnNouveau.setLabel("Nouveau");
        btnNouveau.setName("btnNouveau"); // NOI18N
        btnNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauActionPerformed(evt);
            }
        });
        add(btnNouveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 70, -1));
        btnNouveau.getAccessibleContext().setAccessibleName("btnNouveau");

        btnFermer.setLabel("Fermer");
        btnFermer.setName("btnFermer"); // NOI18N
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });
        add(btnFermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 70, -1));
        btnFermer.getAccessibleContext().setAccessibleName("btnFermer");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void ValidationTextListener(java.awt.event.TextEvent evt) {//GEN-FIRST:event_ValidationTextListener
        btnCalculer.setEnabled(donneeValide());
    }//GEN-LAST:event_ValidationTextListener

    private static final String MALNUTRITION = "Vous souffrez de malnutrition.";
    private static final double MALNUTRITION_IMC = 16.5;
    private static final String MAIGREUR = "Vous êtes maigre.";
    private static final double MAIGREUR_IMC = 18.5;
    private static final String NORMAL = "Votre corpulence est normale. ";
    private static final double NORMAL_IMC = 25;
    private static final String SURPOIDS = "Vous êtes en surpoids";
    
    private void btnCalculerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculerActionPerformed
        double poids = Double.parseDouble(tfPoids.getText());                                          
        double taille = Double.parseDouble(tfTaille.getText());
        double imc = poids / Math.pow(taille, 2);
        tfIMC.setText(imc + "");
        if (imc < MALNUTRITION_IMC) {
            tfInterpretation.setText(MALNUTRITION);
        }else if (imc < MAIGREUR_IMC){
            tfInterpretation.setText(MAIGREUR);
        }else if (imc < NORMAL_IMC){
            tfInterpretation.setText(NORMAL);
        }else{
            tfInterpretation.setText(SURPOIDS);
        }
    }//GEN-LAST:event_btnCalculerActionPerformed

    private void btnNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauActionPerformed
        tfIMC.setText("");
        tfInterpretation.setText("");
        tfPoids.setText("");
        tfTaille.setText("");
    }//GEN-LAST:event_btnNouveauActionPerformed

    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFermerActionPerformed

    private boolean donneeValide(){
        String poids = tfPoids.getText();
        String taille = tfTaille.getText();
        if (Validation.isDoubleValid(poids) && Validation.isDoubleValid(taille))
            return (Double.parseDouble(poids) > 0 && Double.parseDouble(taille) > 0);
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculIMC().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCalculer;
    private java.awt.Button btnFermer;
    private java.awt.Button btnNouveau;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.TextField tfIMC;
    private java.awt.TextField tfInterpretation;
    private java.awt.TextField tfPoids;
    private java.awt.TextField tfTaille;
    // End of variables declaration//GEN-END:variables
}
