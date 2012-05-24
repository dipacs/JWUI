/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui.components;

/**
 *
 * @author dipacs
 */
public class ColorBackground extends ABackground {
    
    private final Color color;

    public ColorBackground(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    @Override
    public String toCss() {
        String res = "";

        if (this.color != null) {
            res += "background-color:#" + this.color.toHexStringRGB() + ";";
        }

        return res;
    }
    
}
