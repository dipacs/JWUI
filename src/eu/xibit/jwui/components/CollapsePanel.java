package eu.xibit.jwui.components;

public class CollapsePanel extends AComponent {

    private String title = "Untitled";
    private Image expandedBackground = null;
    private Image collapsedBackground = null;
    private EFontFamily fontFamily = EFontFamily.Tahoma;
    private int fontSize = 14;
    private Color titleColor = Color.CreateFromRGB(0, 128, 255);
    private int titleHeight = -1;
    private AComponent contentRoot = null;
    private boolean collapsed = false;




    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getExpandedBackground() {
        return this.expandedBackground;
    }

    public void setExpandedBackground(Image expandedBackground) {
        this.expandedBackground = expandedBackground;
    }

    public Image getCollapsedBackground() {
        return this.collapsedBackground;
    }

    public void setCollapsedBackground(Image collapsedBackground) {
        this.collapsedBackground = collapsedBackground;
    }

    public EFontFamily getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(EFontFamily fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color getTitleColor() {
        return this.titleColor;
    }

    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    public int getTitleHeight() {
        return this.titleHeight;
    }

    public void setTitleHeight(int titleHeight) {
        this.titleHeight = titleHeight;
    }

    public AComponent getContentRoot() {
        return this.contentRoot;
    }

    public void setContentRoot(AComponent contentRoot) {
        this.contentRoot = contentRoot;
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
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
    public String render() {
        Panel titlePanel = new Panel();
        titlePanel.setWidth(0.99999);
        titlePanel.setHeight(0.99999);
        titlePanel.setId(titlePanel.getId() + "_title");
        Background bg = null;
        if (this.collapsed) {
            bg = new Background();
            bg.setImage(this.collapsedBackground);
        } else {
            bg = new Background();
            bg.setImage(this.expandedBackground);
        }
        titlePanel.setBackground(bg);

        String script = "<script type=\"text/javascript\">\n";
        script += "function toggleCollapsePanel_" + this.getId() + "() {\n";
        script += "if (document.getElementById('" + this.getId() + "_content').style.display == '') {\n";
        script += "document.getElementById('" + this.getId() + "_content').style.display = 'none';\n";
        if (this.collapsedBackground != null) {
            script += "document.getElementById('" + titlePanel.getId() + "').style.backgroundImage = 'url(\\'" + this.collapsedBackground.getUrl() + "\\')';\n";
        }
        script += "} else {\n";
        script += "document.getElementById('" + this.getId() + "_content').style.display = '';\n";
        if (this.expandedBackground != null) {
            script += "document.getElementById('" + titlePanel.getId() + "').style.backgroundImage = 'url(\\'" + this.expandedBackground.getUrl() + "\\')';\n";
        }
        script += "}\n";
        script += "}\n";
        script += "</script>\n";

        String res = "";
        res += script;
        res += "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"" + this.getId() + "\"";

        // width
        if (this.getWidth() >= 0.0) {
            res += " width=\"";
            if (this.getWidth() == 0.0) {
                res += "0";
            } else if (this.getWidth() >= 1.0) {
                res += Integer.toString((int)this.getWidth());
            } else {
                res += Double.toString((this.getWidth() * 100.0)) + "%;";
            }
            res += "\"";
        }

        // title
        res += "<tr><td";
        // title height
        if (this.titleHeight >= 0) {
            res += " height=\"";
            res += Integer.toString(this.titleHeight);
            res += "\"";
        }

        res += " align=\"center\" valign=\"middle\"";
        res += ">\n";

        res += "<span onClick=\"javascript:toggleCollapsePanel_" + this.getId() + "();\" style=\"cursor:pointer;\">\n";
        
        

        Label ttle = new Label();
        ttle.setText(this.title);
        ttle.setFontFamily(this.fontFamily);
        ttle.setFontSize(this.fontSize);
        ttle.setForeColor(this.titleColor);
        ttle.setHorizontalAlign(EHAlign.Center);
        ttle.setVerticalAlign(EVAlign.Middle);
        //title.setLink(new Link("#\" onClick=\"javascript:toggleCollapsePanel_" + this.getId() + "();"));
        titlePanel.setRootComponent(ttle);

        res += titlePanel.render();
        res += "</span>\n";

        res += "</td></tr>\n";

        // content
        res += "<tr id=\"" + this.getId() + "_content\"";
        if (this.collapsed) {
            res += " style=\"display:none;\"";
        }
        res += "><td";
        if (this.contentRoot != null) {
            res += " align=\"";
            if (this.contentRoot.getHorizontalAlign() != null) {
                res += this.contentRoot.getHorizontalAlign().toString();
            } else {
                res += "left";
            }
            res += "\" valign=\"";
            if (this.contentRoot.getVerticalAlign() != null) {
                res += this.contentRoot.getVerticalAlign().toString();
            } else {
                res += "top";
            }
            res += "\"";
        }
        res += ">\n";

        if (this.contentRoot != null) {
            res += this.contentRoot.render();
        }
        res += "</td></tr>\n";

        res += "</table>\n";

        return res;
    }

}