/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui.components;

/**
 *
 * @author dipacs
 */
public final class Stop {
    
    private final double position;
    private final Color color;

    public Stop(double position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getPosition() {
        return position;
    }
    
}
