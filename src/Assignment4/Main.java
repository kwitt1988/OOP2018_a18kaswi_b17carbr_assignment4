package Assignment4;

import Assignment4.Controller.TetrisController;
import Assignment4.View.GuiGameView;

class Main {
    public static void main(String[] args) {
        new GuiGameView(new TetrisController());
    }
}