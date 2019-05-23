/*
 * Created by JFormDesigner on Thu May 23 15:44:23 BST 2019
 */

package Client;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Joe
 */
public class FileManagerGUI extends JFrame {
    public FileManagerGUI() {
        initComponents();
    }

    private void exitBtnActionPerformed() {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joe
        exitBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- exitBtn ----
        exitBtn.setText("Exit");
        exitBtn.addActionListener(e -> exitBtnActionPerformed());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(243, 243, 243)
                    .addComponent(exitBtn)
                    .addContainerGap(237, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(exitBtn)
                    .addContainerGap(178, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joe
    private JButton exitBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
