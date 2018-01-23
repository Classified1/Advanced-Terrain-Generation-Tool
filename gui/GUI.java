package gui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import world.World;
import world.terrain.Generator;

public final class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private GUI() {
        initComponents();
    }
    
    private static GUI gui;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas2 = new gui.Canvas();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        worldMenu = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Advanced Terrain Generation Tool - Untitled World");
        setBounds(new java.awt.Rectangle(100, 100, 550, 900));
        setIconImage(getIconImage());

        canvas2.setBackground(new java.awt.Color(0, 0, 0));
        canvas2.setDoubleBuffered(false);
        canvas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvas2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout canvas2Layout = new javax.swing.GroupLayout(canvas2);
        canvas2.setLayout(canvas2Layout);
        canvas2Layout.setHorizontalGroup(
            canvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 993, Short.MAX_VALUE)
        );
        canvas2Layout.setVerticalGroup(
            canvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New world...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWorld(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Open existing world...");
        jMenuItem5.setEnabled(false);
        jMenu1.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        worldMenu.setText("World");

        jMenuItem7.setText("Generate terrain...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        worldMenu.add(jMenuItem7);
        worldMenu.add(jSeparator1);

        jMenuItem3.setText("Choose tile spritesheet...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        worldMenu.add(jMenuItem3);

        jMenuItem4.setText("Resize world...");
        jMenuItem4.setEnabled(false);
        worldMenu.add(jMenuItem4);

        jMenuBar1.add(worldMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newWorld(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWorld
        World.newWorld(512, 256);
        worldMenu.setEnabled(true);
    }//GEN-LAST:event_newWorld

    @Override
    public Image getIconImage() {
        try {
            return ImageIO.read(GUI.class.getResourceAsStream("/resources/favicon.png"));
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        String s = JOptionPane.showInputDialog(gui, "Parameters:", "Generate terrain", JOptionPane.QUESTION_MESSAGE);
        if (s == null) return; 
        s = s.trim();
        String params[] = s.split("\\s*,\\s*");
        if (params.length == 0) { System.out.println("No parameters found!"); return; }
        Generator g = Generator.getGenerator(params[0]);
        if (g == null) { System.err.println("Generator '"+params[0]+"' not found!"); return; }
        for (int i = 1; i < params.length; i++) {
            String spl[] = params[i].split("\\s*=\\s*");
            String name = spl[0]; String val = spl[1];
            g.setParameter(name, val);
            System.out.println(params[0]+" parameter: "+name+" = "+val);
        }
        g.generate(World.getWorld());
        canvas2.repaint();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int success = chooser.showOpenDialog(gui);
        if (success == JFileChooser.APPROVE_OPTION) {
            File chosen = chooser.getSelectedFile();
            World.getWorld().setSpritesheet(chosen);
            System.out.println("Set world spritesheet file to "+chosen.getAbsolutePath());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void canvas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MouseClicked
        canvas2.repaint();
    }//GEN-LAST:event_canvas2MouseClicked

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui = new GUI();
                gui.setVisible(true);
                World.newWorld(1024, 512);
            }
        });
    }
    
    protected static Canvas getCanvas() { return gui == null ? null : gui.canvas2; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.Canvas canvas2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu worldMenu;
    // End of variables declaration//GEN-END:variables
}
