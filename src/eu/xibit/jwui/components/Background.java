package eu.xibit.jwui.components;

public final class Background {

    private Color color = null;
    private Image image = null;
    private EHAlign horizontalAlign = EHAlign.Left;
    private EVAlign verticalAlign = EVAlign.Top;
    private boolean horizontalRepeat = true;
    private boolean verticalRepeat = true;




    public Background() {
        super();
    }




    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }



    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    
    public EHAlign getHorizontalAlign() {
        return this.horizontalAlign;
    }

    public void setHorizontalAlign(EHAlign horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }



    public EVAlign getVerticalAlign() {
        return this.verticalAlign;
    }

    public void setVerticalAlign(EVAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    

    public boolean isHorizontalRepeat() {
        return this.horizontalRepeat;
    }

    public void setHorizontalRepeat(boolean horizontalRepeat) {
        this.horizontalRepeat = horizontalRepeat;
    }



    public boolean isVerticalRepeat() {
        return this.verticalRepeat;
    }

    public void setVerticalRepeat(boolean verticalRepeat) {
        this.verticalRepeat = verticalRepeat;
    }



    public String getCssStyle() {
        String res = "";

        if (this.color != null) {
            res += "background-color:#" + this.color.toHexStringRGB() + ";";
        }

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