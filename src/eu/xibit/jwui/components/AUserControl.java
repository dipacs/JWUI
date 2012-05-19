package eu.xibit.jwui.components;

public abstract class AUserControl extends AComponent {

    private AComponent root = null;
    private EOverflowType horizontalOverflow = EOverflowType.Visible;
    private EOverflowType verticalOverflow = EOverflowType.Visible;
    private Border border = null;
    private Background background = null;

    protected AUserControl() {
        super();
    }




    protected AComponent getRootComponent() {
        return this.root;
    }

    protected void setRootComponent(AComponent root) {
        this.root = root;
    }


    protected EOverflowType getHorizontalOverflow() {
        return this.horizontalOverflow;
    }

    protected void setHorizontalOverflow(EOverflowType hOverflow) {
        if (hOverflow == null) {
            throw new NullPointerException("The hOverflow parameter can not be null.");
        }
        this.horizontalOverflow = hOverflow;
    }

    
    protected EOverflowType getVerticalOverflow() {
        return this.horizontalOverflow;
    }

    protected void setVerticalOverflow(EOverflowType vOverflow) {
        if (vOverflow == null) {
            throw new NullPointerException("The vOverflow parameter can not be null.");
        }
        this.verticalOverflow = vOverflow;
    }

    
    protected Border getBorder() {
        return this.border;
    }

    protected void setBorder(Border border) {
        this.border = border;
    }

    protected Background getBackground() {
        return this.background;
    }

    protected void setBackground(Background background) {
        this.background = background;
    }





    public final String render() {
        String res = "<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"";

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

        if (this.getHeight() >= 0.0) {
            res += " height=\"";
            if (this.getHeight() == 0.0) {
                res += "0";
            } else if (this.getWidth() >= 1.0) {
                res += Integer.toString((int)this.getHeight());
            } else {
                res += Double.toString((this.getHeight() * 100.0)) + "%;";
            }
            res += "\"";
        }

        res += " style=\"";

        // size style
        //res += this.renderSizeStyle();

        
        // adding back color
        if (this.background != null) {
            res += this.background.getCssStyle();
        }

        // adding border
        if (this.border != null) {
            res += this.border.toCss();
        }
        

        res += "\" ";

        // id
        res += " id=\"" + this.getId() + "\"><tr><td";

        if (this.root != null) {
            res += " align=\"";
            if (this.root.getHorizontalAlign() != null) {
                res += this.root.getHorizontalAlign().toString();
            } else {
                res += "left";
            }
            res += "\"";
            res += " valign=\"";
            if (this.root.getVerticalAlign() != null) {
                res += this.root.getVerticalAlign().toString();
            } else {
                res += "top";
            }
            res += "\"";
        }

        res += " style=\"";

        // adding overflow style
        res += "overflow-x:" + this.horizontalOverflow.toCss() + ";";
        res += "overflow-y:" + this.verticalOverflow.toCss() + ";";
        
        res += "\"";

        res += ">\n";

        if (this.root != null) {
            if (this.root.isVisible()) {
                res += this.root.render();
            }
        } else {
            res += "&nbsp;";
        }

        res += "</td></tr></table>";

        return res;
    }

}