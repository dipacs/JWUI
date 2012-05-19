package eu.xibit.jwui.components;

import eu.xibit.jwui.Link;

public class Button extends AComponent {

    private String text = "Button";
    private Link link = null;
    private boolean enabled = true;




    public Button() {
        super();
    }




    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        if (this.text == null) {
            this.text = "";
        } else {
            this.text = text;
        }
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(double width) {
        super.setHeight(width);
    }

    

    @Override
    public String render() {
        String res = "";
        if (this.link != null) {
            res = "<a href=\"";
            if (this.link.getUrl() != null) {
                res += this.link.getUrl();
            }
            res += "\"";

            if (this.link.isInNewTab()) {
                res += " target=\"_blank\"";
            }
            res += ">";
        }

        res += "<input type=\"button\" value=\"" + this.text + "\"";
        if (!this.enabled) {
            res += " disabled=\"true\"";
        }
        res += " style=\"" + this.renderSizeStyle() + "\"";
        res += "/>";

        if (this.link != null) {
            res += "</a>\n";
        }

        return res;
    }

}