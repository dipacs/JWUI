/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.xibit.jwui.components;

/**
 *
 * @author dipacs
 */
public class ImageBackground extends ABackground {
    
    private final Image image;
    private EHAlign horizontalAlign = EHAlign.Left;
    private EVAlign verticalAlign = EVAlign.Top;
    private boolean horizontalRepeat = true;
    private boolean verticalRepeat = true;

    
    
    
    public ImageBackground(Image image) {
        this.image = image;
    }

    
    
    
    public Image getImage() {
        return image;
    }

    public EHAlign getHorizontalAlign() {
        return horizontalAlign;
    }

    public void setHorizontalAlign(EHAlign horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public boolean isHorizontalRepeat() {
        return horizontalRepeat;
    }

    public void setHorizontalRepeat(boolean horizontalRepeat) {
        this.horizontalRepeat = horizontalRepeat;
    }

    public EVAlign getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(EVAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public boolean isVerticalRepeat() {
        return verticalRepeat;
    }

    public void setVerticalRepeat(boolean verticalRepeat) {
        this.verticalRepeat = verticalRepeat;
    }
    
    @Override
    public String toCss() {
        String res = "";

        if (this.image != null) {
            if (this.image.getUrl() != null) {
                res += "background-image:url('" + this.image.getUrl() + "');";
            }
        }

        res += "background-position:";
        if (this.horizontalAlign != null) {
            res += " " + this.horizontalAlign.toString();
        } else {
            res += " center";
        }
        if (this.verticalAlign != null) {
            res += " " + this.verticalAlign.toString();
        } else {
            res += " center";
        }
        res += ";";

        if (this.horizontalRepeat && this.verticalRepeat) {
            res += "repeat:repeat;";
        } else if (this.horizontalRepeat) {
            res += "repeat:repeat-x;";
        } else if (this.verticalRepeat) {
            res += "repeat:repeat-y;";
        } else {
            res += "repeat:no-repeat;";
        }

        res += "background-size:100% 100%;";

        return res;
    }
    
}
