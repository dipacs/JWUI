package eu.xibit.jwui.components;

/**
 * The AUserControl class can be used as a base class of your own composit component. You can define it's 
 * content setting it's root component.
 * 
 * @author dipacs
 */
public abstract class AUserControl extends AComponent {

    private AComponent root = null;
    private EOverflowType horizontalOverflow = EOverflowType.Visible;
    private EOverflowType verticalOverflow = EOverflowType.Visible;
    private Border border = null;
    private Background background = null;
    
    
    

    /**
     * Creates a new instance of AUserControl.
     */
    protected AUserControl() {
        super();
    }




    /**
     * Returns the root commponent of this user control.
     * 
     * @return 
     * The root commponent of this user control.
     */
    protected AComponent getRootComponent() {
        return this.root;
    }

    /**
     * Sets the root component of this user control.
     * 
     * @param root 
     * The new root component of this user control.
     */
    protected void setRootComponent(AComponent root) {
        this.root = root;
    }


    /**
     * Returns the horizontal overflow of this user control.
     * <p>
     * The horizontal overflow property defines what must be happend when a contained content is outside of 
     * the edges of this user control.
     * </p>
     * 
     * @see EOverflowType
     * 
     * @return 
     * The horizontal overflow of this user control.
     */
    protected EOverflowType getHorizontalOverflow() {
        return this.horizontalOverflow;
    }

    /**
     * Sets the horizontal overflow of this control.
     * <p>
     * The horizontal overflow property defines what must be happend when a contained content is outside of 
     * the edges of this control.
     * </p>
     * 
     * @see EOverflowType
     * 
     * @param hOverflow 
     * The new value of the horizontal overflow property.
     * 
     * @throws NullPointerException
     * If the given value is null.
     */
    protected void setHorizontalOverflow(EOverflowType hOverflow) {
        if (hOverflow == null) {
            throw new NullPointerException("The hOverflow parameter can not be null.");
        }
        this.horizontalOverflow = hOverflow;
    }

    
    /**
     * Returns the vertical overflow of this control.
     * <p>
     * The vertical overflow property defines what must be happend when a contained content is outside of 
     * the edges of this control.
     * </p>
     * 
     * @see EOverflowType
     * 
     * @return 
     * The vertical overflow of this user control.
     */
    protected EOverflowType getVerticalOverflow() {
        return this.horizontalOverflow;
    }

    /**
     * Sets the vertical overflow of this control.
     * <p>
     * The vertical overflow property defines what must be happend when a contained content is outside of 
     * the edges of this control.
     * </p>
     * 
     * @see EOverflowType
     * 
     * @param hOverflow 
     * The new value of the vertical overflow property.
     * 
     * @throws NullPointerException
     * If the given value is null.
     */
    protected void setVerticalOverflow(EOverflowType vOverflow) {
        if (vOverflow == null) {
            throw new NullPointerException("The vOverflow parameter can not be null.");
        }
        this.verticalOverflow = vOverflow;
    }

    
    /**
     * Returns the border style of this user control.
     * 
     * @return 
     * The border style of this control. Null means no broder.
     */
    protected Border getBorder() {
        return this.border;
    }

    /**
     * Sets the border style of this control.
     * 
     * @param border 
     * The new border style of this control. Null means no border.
     */
    protected void setBorder(Border border) {
        this.border = border;
    }

    /**
     * Returns the background style of this user control.
     * 
     * @return 
     * The background style of this control. Null means no background.
     */
    protected Background getBackground() {
        return this.background;
    }

    /**
     * Sets the background style of this control.
     * 
     * @param background 
     * The new background style of this control. Null means no background.
     */
    protected void setBackground(Background background) {
        this.background = background;
    }





    @Override
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