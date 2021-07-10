package org.pipoware.velogui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Frame extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout = new BorderLayout();
    JSplitPane jSplitPane = new JSplitPane();
    JPanel jHighPanel = new JPanel();
    JScrollPane jScrollPane = new JScrollPane();
    JTextArea jMergedTextArea = new JTextArea();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JButton jMergeButton = new JButton();
    JPanel jRightPanel = new JPanel();
    JPanel jLeftPanel = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea jLeftTextArea = new JTextArea();
    JTextArea jRightTextArea = new JTextArea();
    BorderLayout borderLayout2 = new BorderLayout();
    TitledBorder titledBorder1;
    BorderLayout borderLayout3 = new BorderLayout();
    Border border1;
    BorderLayout borderLayout4 = new BorderLayout();
    Core m_core;

    /**Construct the frame*/
    public Frame(Core core) {
        m_core = core;
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**Component initialization*/
    private void jbInit() {
        //setIconImage(Toolkit.getDefaultToolkit().createImage(Frame.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"Java Code");
        border1 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"Velocity Code"),BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.setLayout(borderLayout);
        this.setSize(new Dimension(534, 509));
        this.setTitle("VeloGUI");
        jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane.setPreferredSize(new Dimension(452, 147));
        jHighPanel.setLayout(borderLayout1);
        jMergeButton.setText("Merge !");
        jMergeButton.addActionListener(e -> jMergeButton_actionPerformed());
        jPanel2.setLayout(gridLayout1);
        gridLayout1.setColumns(2);
        jLeftTextArea.setText("context.put(\"name\",\"Velocity\");");
        jRightTextArea.setText("Hello, $name is great !");
        jLeftPanel.setLayout(borderLayout2);
        jRightPanel.setLayout(borderLayout4);
        jScrollPane1.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"Java Code"),BorderFactory.createEmptyBorder(5,5,5,5)));
        jPanel1.setLayout(borderLayout3);
        jScrollPane2.setBorder(border1);
        contentPane.add(jSplitPane, BorderLayout.CENTER);
        jSplitPane.add(jHighPanel, JSplitPane.TOP);
        jHighPanel.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jLeftPanel, null);
        jLeftPanel.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jLeftTextArea, null);
        jPanel2.add(jRightPanel, null);
        jRightPanel.add(jScrollPane2, BorderLayout.CENTER);
        jScrollPane2.getViewport().add(jRightTextArea, null);
        jHighPanel.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(jMergeButton, BorderLayout.CENTER);
        jSplitPane.add(jScrollPane, JSplitPane.BOTTOM);
        jSplitPane.setDividerLocation(300);
        jScrollPane.getViewport().add(jMergedTextArea, null);
    }
    /**Overridden so we can exit when window is closed*/
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    void jMergeButton_actionPerformed() {
        jMergedTextArea.setText(m_core.getMerge(jLeftTextArea.getText(), jRightTextArea.getText()));
    }
}