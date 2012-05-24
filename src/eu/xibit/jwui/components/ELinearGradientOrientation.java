/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui.components;

/**
 *
 * @author dipacs
 */
public enum ELinearGradientOrientation {
    
    LEFT_TOP("left top", "left top, right bottom"),
    LEFT("left", "left top, right top"),
    LEFT_BOTTOM("left bottom", "left bottom, right top"),
    BOTTOM("bottom", "left bottom, left top"),
    RIGHT_BOTTOM("right bottom", "right bottom, left top"),
    RIGHT("right", "right top, left top"),
    RIGHT_TOP("right top", "right top, left bottom"),
    TOP("top", "left top, left bottom");
    
    private final String value;
    private final String fullValue;
    
    private ELinearGradientOrientation(String value, String fullValue) {
        this.value = value;
        this.fullValue = fullValue;
    }
    
    public final String toCSS() {
        return this.value;
    }
    
    public final String toFullCss() {
        return fullValue;
    }
    
}
