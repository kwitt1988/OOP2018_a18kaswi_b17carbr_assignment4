package Assignment4.GUI;

import javax.swing.*;

public class GuiStartScreen extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();

    GuiStartScreen(){
        frameSettings(mainFrame, mainPanel, 400, 800);
    }

    @Override
    void listeners() {

    }
}
