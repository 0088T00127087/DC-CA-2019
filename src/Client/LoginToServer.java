/*
 * Created by JFormDesigner on Tue May 14 21:37:10 BST 2019
 */

package Client;

import Classes.User;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Joe Enright
 */
public class LoginToServer extends JFrame  {

    EchoClientHelper2 helper;
    User user;

    public LoginToServer() {
        initComponents();
    }

    public LoginToServer(EchoClientHelper2 helper){
      this.helper = helper;
      initComponents();
    }

    private void loginBtnActionPerformed()  {
        // send username to server
        String username = usernameTxtBox.getText();
        String password = passWordTxtBox.getText();

        //String msg = "hello world";


        try {


            // helper.getEcho(msg);
            helper.sendUserName(username);
            helper.sendPassword(password);

            int msgType;

           msgType = helper.getMessageType();

           System.out.println("LogInServer MsgType = : " + msgType);

            if (msgType == 400) {
                JOptionPane.showMessageDialog(null, "Error -400", "Error", JOptionPane.ERROR_MESSAGE);
//                FileManagerGUI fm = new FileManagerGUI();
//                fm.setVisible(true);
//                this.dispose();
            }
            else if (msgType == 100) {
                JOptionPane.showMessageDialog(null, "Created User -100", "Error", JOptionPane.ERROR_MESSAGE);
                FileManagerGUI fm = new FileManagerGUI();
                fm.setVisible(true);
                this.dispose();
            }



        }

        catch (IOException e){
            e.printStackTrace();
        }
    }







    private void testBtnActionPerformed() {
        String msg = "Exit";

        try{
            helper.getEcho(msg);

            this.dispose();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joe
        usernameTxtBox = new JTextField();
        passWordTxtBox = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        loginBtn = new JButton();
        exitBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("User Name");

        //---- label2 ----
        label2.setText("Password");

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.addActionListener(e -> loginBtnActionPerformed());

        //---- exitBtn ----
        exitBtn.setText("Exit");
        exitBtn.addActionListener(e -> testBtnActionPerformed());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(exitBtn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                            .addComponent(loginBtn)
                            .addGap(86, 86, 86))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(passWordTxtBox, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(usernameTxtBox, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                            .addContainerGap(78, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(usernameTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(passWordTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(loginBtn)
                        .addComponent(exitBtn))
                    .addContainerGap(71, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joe
    private JTextField usernameTxtBox;
    private JTextField passWordTxtBox;
    private JLabel label1;
    private JLabel label2;
    private JButton loginBtn;
    private JButton exitBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
