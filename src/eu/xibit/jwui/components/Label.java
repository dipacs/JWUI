package eu.xibit.jwui.components;

import eu.xibit.jwui.Link;

public final class Label extends AComponent {

    private String text;
    private EFontFamily fontFamily = EFontFamily.Tahoma;
    private EHTextAlign textAlign = EHTextAlign.Justify;
    private boolean bold = false;
    private boolean italic = false;
    private boolean underline = false;
    private Color foreColor = Color.Black;
    private Color backColor = null;
    private int fontSize = 16;
    private Link link = null;




    public Label() {
        super();
    }




    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public EFontFamily getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(EFontFamily fontFamily) {
        if (fontFamily == null) {
            throw new NullPointerException("The fontFamily parameter can not be null.");
        }
        this.fontFamily = fontFamily;
    }


    public boolean isBold() {
        return this.bold;
    }

    public void setBold(boolean value) {
        this.bold = value;
    }


    public boolean isItalic() {
        return this.italic;
    }

    public void setItalic(boolean value) {
        this.italic = value;
    }


    public boolean isUnderline() {
        return this.underline;
    }

    public void setUnderline(boolean value) {
        this.underline = value;
    }


    public Color getForeColor() {
        return this.foreColor;
    }

    public void setForeColor(Color color) {
        this.foreColor = color;
    }


    public Color getBackColor() {
        return this.backColor;
    }

    public void setBackColor(Color color) {
        this.backColor = color;
    }


    public int getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }


    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public EHTextAlign getTextAlign() {
        return this.textAlign;
    }

    public void setTextAlign(EHTextAlign textAlign) {
        this.textAlign = textAlign;
    }

    @Override
    public  double getWidth() {
        return super.getWidth();
    }

    @Override
    public  void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public  double getHeight() {
        return super.getHeight();
    }

    @Override
    public  void setHeight(double width) {
        super.setHeight(width);
    }






    @Override
    public  String render() {
        String style = this.renderSizeStyle();
        boolean isSizeDefined = !style.equals("");

        if (isSizeDefined) {
            style += "overflow:visible;";
        }
        

        // adding font family
        if (this.fontFamily != null) {
            style += "font-family:" + this.fontFamily.getFamily() + ";";
        }

        // adding font size
        style += "font-size:" + Integer.toString(this.fontSize) + "px;";

        // adding background color
        if (this.backColor != null) {
            style += "background-color:#" + this.backColor.toHexStringRGB() + ";";
        }

        // align
        //style += "text-align:" + this.horizontalTextAlign.toString() + ";vertical-align:" + this.verticalTextAlign.toString() + ";";

        // div start
        String res = "<table cellspacing=\"0\" cellpadding=\"0\"><tr><td style=\"" + style + "\"";

        if (this.textAlign != null) {
            res += " align=\"" + this.textAlign.toString() + "\"";
        }

        res += ">";

        // bold start
        if (this.bold) {
            res += "<b>";
        }

        // italic start
        if (this.italic) {
            res += "<i>";
        }

        // underline start
        if (this.underline) {
            res += "<u>";
        }

        // fore color start
        if (this.foreColor != null) {
            res += "<font color=\"#" + this.foreColor.toHexStringRGB() + "\">"; 
        }

        if (this.link != null) {
            res += "<a href=\"" + this.link.getUrl() + "\"";
            if (this.link.isInNewTab()) {
                res += " target=\"_blank\"";
            }

            String linkStyle = "";
            // adding font family
            if (this.fontFamily != null) {
                linkStyle += "font-family:" + this.fontFamily.getFamily() + ";";
            }

            // adding font size
            linkStyle += "font-size:" + Integer.toString(this.fontSize) + "px;";

            // adding fore color
            if (this.getForeColor() != null) {
                linkStyle += "color:#" + this.getForeColor().toHexStringRGB() + ";";
            }

            if (this.isBold()) {
                linkStyle += "font-weight:bold;";
            } else {
                linkStyle += "font-weight:normal;";
            }

            if (this.isUnderline()) {
                linkStyle += "text-decoration:underline;";
            } else {
                linkStyle += "text-decoration:none;";
            }

            if (this.isItalic()) {
                linkStyle += "font-style:italic;";
            } else {
                linkStyle += "font-style:normal;";
            }
            
            res += " style=\"" + linkStyle + "\"";

            res += ">";
        }

        // text
        if (this.text != null) {
            res += this.text; 
        }

        if (this.link != null) {
            res += "</a>";
        }

        // fore color end
        if (this.foreColor != null) {
            res += "</font>"; 
        }

        // underline end
        if (this.underline) {
            res += "</u>";
        }

        // italic end
        if (this.italic) {
            res += "</i>";
        }

        // bold end
        if (this.bold) {
            res += "</b>";
        }

        // div end
        res += "</td></tr></table>\n";
        return res;
    }

}