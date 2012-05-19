package eu.xibit.jwui.components;

import eu.xibit.jwui.Link;

public final class ImageButton extends AComponent {

    private Image normalImage = null;
    private Image overImage = null;
    private Image downImage = null;
    private Link link = null;

    

    public Image getNormalImage() {
        return this.normalImage;
    }

    public void setNormalImage(Image normalImage) {
        this.normalImage = normalImage;
    }

    public Image getOverImage() {
        return this.overImage;
    }

    public void setOverImage(Image overImage) {
        this.overImage = overImage;
    }

    public Image getDownImage() {
        return this.downImage;
    }

    public void setDownImage(Image downImage) {
        this.downImage = downImage;
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }



    @Override
    public String render() {
        String style = "";
        if (this.normalImage != null) {
            if (this.getWidth() < 0.0) {
                this.setWidth(this.normalImage.getWidth());
            }
            if (this.getHeight() < 0.0) {
                this.setHeight(this.normalImage.getHeight());
            }
        }
        style += this.renderSizeStyle();
        style = style + "overflow:visible;";

        String res = "<div style=\"" + style + "\">\n";
        
        if (this.normalImage != null) {
            if (this.link != null) {
                res += "<a href=\"" + this.link.toString() + "\"";
                if (this.link.isInNewTab()) {
                    res += " target=\"_blank\"";
                }
                res += ">";
            }

            String imgStyle = "width:100%;height:100%;background-image:url('" + this.normalImage.getUrl() + "');overflow:hidden;background-repeat:no-repeat;";

            imgStyle += "background-position:center center;background-size:100% 100%;";

            String id = this.getId();
            String overScript = "";
            if (this.overImage != null) {
                overScript = "document.getElementById('" + id + "').style.backgroundImage = 'url(\\'" + this.overImage.getUrl() + "\\')';";
            }

            String outScript = "";
            if (this.normalImage != null) {
                outScript = "document.getElementById('" + id + "').style.backgroundImage = 'url(\\'" + this.normalImage.getUrl() + "\\')';";
            }
            String downScript = "";
            if (this.downImage != null) {
                downScript = "document.getElementById('" + id + "').style.backgroundImage = 'url(\\'" + this.downImage.getUrl() + "\\')';";
            }
            String upScript = "";
            if (this.overImage != null) {
                upScript = "document.getElementById('" + id + "').style.backgroundImage = 'url(\\'" + this.overImage.getUrl() + "\\')';";
            }

            res += "<div id=\"" + this.getId() + "\" style=\"" + imgStyle + "\" onmousedown=\"javascript:" + downScript + "\"  onmouseup=\"javascript:" + upScript + "\"  onmouseover=\"javascript:" + overScript + "\"  onmouseout=\"javascript:" + outScript + "\"></div>";

            if (this.link != null) {
                res += "</a>";  
            }
        }

        res += "</div>\n";
        return res;
    }

}