/*
 * Created by JFormDesigner on Tue May 14 20:25:20 BST 2019
 */

package Client;

import Classes.ServerInstance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Joe Enright
 */
public class ConnectToServer extends JFrame {

    ServerInstance server;
    String hostname = "";
    String portNum ="";



    public ConnectToServer() {

        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void pushBtnActionPerformed() {
        JOptionPane.showMessageDialog(null, "", " ", JOptionPane.INFORMATION_MESSAGE);
    }

    private void connectBtnActionPerformed() {
       try{
           hostname = hostnameTxtBox.getText();
           portNum = portNumTxtBox.getText();
           server = new ServerInstance(hostname, portNum);

           EchoClientHelper2 helper = new EchoClientHelper2(server);



           this.setVisible(false);
           LoginToServer loginWindow = new LoginToServer(helper);
           loginWindow.setVisible(true);
       }
       catch(IOException e){
           e.printStackTrace();
       }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joe Enright
        connectBtn = new JButton();
        hostnameTxtBox = new JTextField();
        portNumTxtBox = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- connectBtn ----
        connectBtn.setText("Connect");
        connectBtn.addActionListener(e -> connectBtnActionPerformed());

        //---- hostnameTxtBox ----
        hostnameTxtBox.setText("localhost");

        //---- portNumTxtBox ----
        portNumTxtBox.setText("7");

        //---- label1 ----
        label1.setText("Host Name");

        //---- label2 ----
        label2.setText("Port Number");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                    .addComponent(portNumTxtBox, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hostnameTxtBox, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(69, 250, Short.MAX_VALUE)
                            .addComponent(connectBtn)))
                    .addContainerGap(69, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(hostnameTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(portNumTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                    .addComponent(connectBtn)
                    .addGap(76, 76, 76))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joe Enright
    private JButton connectBtn;
    private JTextField hostnameTxtBox;
    private JTextField portNumTxtBox;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
