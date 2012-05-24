package eu.xibit.jwui.components;

public class Border {

    private final EBorderStyle style;
    private final Color color;
    private final int width;
    private int radius = 0;




    public Border(EBorderStyle style, Color color, int width) {
        super();
        this.style = style;
        this.color = color;
        this.width = width;
    }




    public EBorderStyle getStyle() {
        return this.style;
    }

    public Color getColor() {
        return this.color;
    }

    public int getWidth() {
        return this.width;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }



    public String toCss() {
        if (this.style == null) {
            return "";
        }

        String res = "border-style:" + this.style.toCss() + ";";

        if (this.color != null) {
            res += "border-color:#" + this.color.toHexStringRGB() + ";";
        } else {
            res += "border-color:#000000;";
        }

        if (this.width > 0) {
            res += "border-width:" + Integer.toString(this.width) + "px;";
        } else {
            res += "border-width:1px";
        }
        
        if (radius > 0) {
            res += "-webkit-border-radius:" + radius + "px;"
                    + "-moz-border-radius:" + radius + "px;"
                    + "border-radius:" + radius + "px;";
        }

        return res;
    }

}