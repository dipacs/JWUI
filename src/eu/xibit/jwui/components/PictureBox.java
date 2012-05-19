package eu.xibit.jwui.components;

import eu.xibit.jwui.Link;

public final class PictureBox extends AComponent {

    private Image image = null;
    private EPictureSizeMode sizeMode = EPictureSizeMode.Stretch;
    private Color backColor = null;
    private Link link = null;
    private Border border = null;




    public PictureBox() {
        super();
    }

    


    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public EPictureSizeMode getSizeMode() {
        return this.sizeMode;
    }

    public void setSizeMode(EPictureSizeMode sizeMode) {
        this.sizeMode = sizeMode;
    }


    public Color getBackColor() {
        return this.backColor;
    }

    public void setBackColor(Color color) {
        this.backColor = color;
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }


    public Border getBorder() {
        return this.border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public double getWidth() {
        return super.getWidth();
    }

    public void setWidth(double width) {
        super.setWidth(width);
    }

    public double getHeight() {
        return super.getHeight();
    }

    public void setHeight(double width) {
        super.setHeight(width);
    }



    public String render() {
        String style = "";
        if (this.image != null) {
            if (this.getWidth() < 0.0) {
                this.setWidth(this.image.getWidth());
            }
            if (this.getHeight() < 0.0) {
                this.setHeight(this.image.getHeight());
            }
        }
        style += this.renderSizeStyle();
        style = style + "overflow:visible;";

        // adding background color
        if (this.backColor != null) {
            style += "background-color:#" + this.backColor.toHexStringRGB() + ";";
        }

        // adding border
        if (this.border != null) {
            style += this.border.toCss();
        }

        if (this.sizeMode != EPictureSizeMode.Normal) {
            style += "text-align:center;vertical-align:middle;";
        }

        String res = "<div style=\"" + style + "\">\n";
        
        if (this.image != null) {
            if (this.link != null) {
                res += "<a href=\"" + this.link.toString() + "\"";
                if (this.link.isInNewTab()) {
                    res += " target=\"_blank\"";
                }
                res += ">";
            }

            String imgStyle = "width:100%;height:100%;background-image:url('" + this.image.getUrl() + "');overflow:hidden;background-repeat:no-repeat;";

            if (this.sizeMode == EPictureSizeMode.Normal) {
                // nothing to do
            } else if (this.sizeMode == EPictureSizeMode.Center) {
                imgStyle += "background-position:center center;";
            } else if (this.sizeMode == null || this.sizeMode == EPictureSizeMode.Stretch) {
                imgStyle += "background-position:center center;background-size:100% 100%;";
            } else if (this.sizeMode == EPictureSizeMode.FitWidth) {
                imgStyle += "background-position:center center;background-size:100% auto;";
            } else if (this.sizeMode == EPictureSizeMode.FitHeight) {
                imgStyle += "background-position:center center;background-size:auto 100%;";
            } else if (this.sizeMode == EPictureSizeMode.Fill) {
                imgStyle += "background-position:center center;background-size:cover;";
            } else if (this.sizeMode == EPictureSizeMode.Zoom) {
                imgStyle += "background-position:center center;background-size:contain;";
            }

            res += "<div style=\"" + imgStyle + "\"></div>";

            if (this.link != null) {
                res += "</a>";  
            }
        }

        res += "</div>\n";
        return res;
    }

}
