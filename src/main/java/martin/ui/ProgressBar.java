package martin.ui;/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import martin.Tone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* 
 * main.java.UIin.java.ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class ProgressBar extends JPanel
        implements MouseListener {
    //Where member variables are declared:
    public static JProgressBar progressBar;

    private long pausedAt = 0;

    public ProgressBar() {

        //TODO:fix
        ImageIcon leftButtonIcon = new ImageIcon();// createImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = new ImageIcon();// createImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = new ImageIcon();// createImageIcon("images/left.gif");

        progressBar = new JProgressBar(0, MainFrame.getLocation(Tone.sequencer.getMicrosecondLength()));
        progressBar.setValue(MainFrame.getLocation(0));
        progressBar.setStringPainted(true);

        progressBar.setLayout(new GridLayout(1, 1));
        progressBar.setOpaque(true); //content panes must be opaque

        progressBar.addMouseListener(this);


        add(progressBar);
//
//        b1 = new JButton("Start/Continue", leftButtonIcon);
//        b1.setVerticalTextPosition(AbstractButton.CENTER);
//        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//        b1.setMnemonic(KeyEvent.VK_S);
//        b1.setActionCommand("start");
//
//        b2 = new JButton("Stop", middleButtonIcon);
//        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
//        b2.setHorizontalTextPosition(AbstractButton.CENTER);
//        b2.setMnemonic(KeyEvent.VK_P);
//        b2.setActionCommand("Stop");
//
//        b3 = new JButton("Pause", rightButtonIcon);
//        //Use the default text position of CENTER, TRAILING (RIGHT).
//        b3.setMnemonic(KeyEvent.VK_E);
//        b3.setActionCommand("enable");
//        b3.setEnabled(false);
//
//        //Listen for actions on buttons 1 and 3.
//        b1.addActionListener(this);
//        b3.addActionListener(this);
//        b2.addActionListener(this);
//
//        //TODO:change
//        b1.setToolTipText("Click this button to disable the middle button.");
//        b2.setToolTipText("This middle button does nothing when you click it.");
//        b3.setToolTipText("Click this button to enable the middle button.");

        //Add Components to this container, using the default FlowLayout.
//        add(b2);
//        add(b3);

    }

    public void actionPerformed(ActionEvent e) {
//        if ("start".equals(e.getActionCommand())) {
//            b2.setEnabled(false);
//            b1.setEnabled(false);
//            b3.setEnabled(true);
//
//            thread3 = new Thread(() -> {
//                // We are doing the same thing as with the MyRunnableImplementation class
////                for (int i = 0; i < 5; i++) {
//                long start = System.nanoTime();
////                main.java.martin.Tone.main(new String[]{String.valueOf(pausedAt)});
//
//                main.java.martin.Tone.play(pausedAt);
//
//                System.out.println(TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS));
//
//                System.out.println(Thread.currentThread().getName() +
//                        "\twith Runnable: Inner class Runnable runs...");
////                }
//            }, "Thread 3");
//            thread3.start();
//
//
//        } else if ("Stop".equals(e.getActionCommand())){
//            pausedAt = 0;
//            System.out.println("Stopped: " + pausedAt);
//
//            main.java.UIin.java.LabelPanel.lbl.setText("Time: " + String.valueOf(pausedAt));
//            main.java.UIin.java.MainFrame.progressBar.setValue(main.java.UIin.java.MainFrame.getLocation(pausedAt));
//
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//        }  else{
//            b2.setEnabled(true);
//            b1.setEnabled(true);
//            b3.setEnabled(false);
//
//            pausedAt = main.java.martin.Tone.sequencer.getMicrosecondPosition();
//
//            main.java.LabelPanelLabelPanel.lbl.setText("Time: " + String.valueOf(main.java.martin.Tone.sequencer.getMicrosecondPosition()));
//            main.java.UIin.java.MainFrame.progressBar.setValue(main.java.martin.ui.MainFrame.MainFrame.getLocation(main.java.martin.Tone.sequencer.getMicrosecondPosition()));
//            System.out.println(pausedAt);
//
//            main.java.martin.Tone.sequencer.stop();
////            thread3.interrupt();
//        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ProgressBar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double newPosition = mouseEvent.getPoint().getX() / progressBar.getSize().getWidth();
        Tone.sequencer.setMicrosecondPosition(Math.round(newPosition * Tone.sequencer.getMicrosecondLength()));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
