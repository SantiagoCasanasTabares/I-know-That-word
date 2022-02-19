package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */

public class IconNiveles implements Icon{

    /**
     * paint the image Icon in an imagen object
     * @param c
     * @param g
     * @param x
     * @param y
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = new ImageIcon(getClass().getResource("/Resources/niveles.png")).getImage();
        g.drawImage(image, x, y, c);
    }

    /**
     * get Icon width
     * @return 320 (width)
     */
    @Override
    public int getIconWidth() {
        return 320;
    }

    /**
     * get Icon Height
     * @return 200 (Height)
     */
    @Override
    public int getIconHeight() {
        return 200;
    }
}
