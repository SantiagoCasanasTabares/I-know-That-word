package myProject;

import javax.swing.*;
import java.awt.*;

public class IconNiveles implements Icon{

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = new ImageIcon(getClass().getResource("/Resources/niveles.png")).getImage();
        g.drawImage(image, x, y, c);
    }

    @Override
    public int getIconWidth() {
        return 320;
    }

    @Override
    public int getIconHeight() {
        return 200;
    }
}
