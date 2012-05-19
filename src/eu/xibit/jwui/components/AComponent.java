package eu.xibit.jwui.components;

/**
 * This class is the base class of all the JWUI components.
 * You can inherite from this class if you want to create a custom component.
 * <p>
 * Note that this is a low-level way of creating components. This way is useful if you want to create a totally new 
 * component, which can't be created as compositing already exists components. If you just want to composit already exists components to create your own, 
 * use <code>AUserControl</code>.
 * </p>
 * 
 * @author dipacs
 */
public abstract class AComponent {

    private static int ActId = 1;

    private static String getNextId() {
        String res = "id" + Integer.toString(AComponent.ActId);
        AComponent.ActId = AComponent.ActId + 1;
        return res;
    }

    
    
    
    private String id;
    private double width = -1.0;
    private double height = -1.0;
    private boolean visible = true;
    private EHAlign horizontalAlign = EHAlign.Left;
    private EVAlign verticalAlign = EVAlign.Top;




    /**
     * Creates a new instance of AComponent, and generates a new id for it.
     */
    protected AComponent() {
        super();
        this.id = AComponent.getNextId();
    }




    /**
     * Returns the id of this component. This id can be used from JavaScript to access this component.
     * 
     * @return 
     * The id of this component.
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Sets the id of this component to the given string. This id can be used from JavaScript to access this component.
     * 
     * @param id 
     * The new id of this component.
     */
    public final void setId(String id) {
        this.id = id;
    }

    
    /**
     * Returns the width of the component.
     * <p>
     * This is a multi function number. See the following table to reference:
     * <ul>
     * <li>width &lt; 0 --> undefined (autosize)</li>
     * <li>width = 0 --> 0 pixel</li>
     * <li>0 &lt; width &lt; 1 --> percent</li>
     * <li>width &gt; 1 --> pixels</li>
     * </ul>
     * </p>
     * 
     * @return The width of the component.
     */
    protected double getWidth() {
        return this.width;
    }

    /**
     * Sets the width of this component.
     * <p>
     * This is a multi function number. See the following table to reference:
     * <ul>
     * <li>width &lt; 0 --> undefined (autosize)</li>
     * <li>width = 0 --> 0 pixel</li>
     * <li>0 &lt; width &lt; 1 --> percent</li>
     * <li>width &gt; 1 --> pixels</li>
     * </ul>
     * </p>
     * 
     * @param width 
     * The new width of the component.
     */
    protected void setWidth(double width) {
        this.width = width;
    }

    /**
     * Returns the height of this component.
     * <p>
     * This is a multi function number. See the following table to reference:
     * <ul>
     * <li>width &lt; 0 --> undefined (autosize)</li>
     * <li>width = 0 --> 0 pixel</li>
     * <li>0 &lt; width &lt; 1 --> percent</li>
     * <li>width &gt; 1 --> pixels</li>
     * </ul>
     * </p>
     * 
     * @return 
     * The height of this component.
     */
    protected double getHeight() {
        return this.height;
    }

    /**
     * Sets the height of this component.
     * <p>
     * This is a multi function number. See the following table to reference:
     * <ul>
     * <li>width &lt; 0 --> undefined (autosize)</li>
     * <li>width = 0 --> 0 pixel</li>
     * <li>0 &lt; width &lt; 1 --> percent</li>
     * <li>width &gt; 1 --> pixels</li>
     * </ul>
     * </p>
     * 
     * @param height 
     * The new height of this component.
     */
    protected void setHeight(double height) {
        this.height = height;
    }

    /**
     * Returns the horizontal alignment of this component.
     * 
     * @return 
     * The horizontal alignment of this component.
     */
    public final EHAlign getHorizontalAlign() {
        return this.horizontalAlign;
    }

    /**
     * Sets the horizontal alignment of this component.
     * 
     * @param horizontalAlign 
     * The new horizontal alignemt of this component.
     */
    public final void setHorizontalAlign(EHAlign horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    /**
     * Returns the vertical alignment of this component.
     * 
     * @return 
     * The vertical alignment of this component.
     */
    public final EVAlign getVerticalAlign() {
        return this.verticalAlign;
    }

    /**
     * Sets the vertical alignment of this component.
     * 
     * @param verticalAlign 
     * The new vertical alignemt of this component.
     */
    public final void setVerticalAlign(EVAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
    }



    /**
     * Returns the css style which contains the style of this component, and which can be inserted in the style parameter
     * of the html tag.
     * 
     * @return 
     * The css style which contains the style of this component as String.
     */
    protected final String renderSizeStyle() {
        String res = "";

        // horizontal align
        if (this.horizontalAlign == EHAlign.Center) {
            res += "margin-left:auto;margin-right:auto;";
        } else if (this.horizontalAlign == EHAlign.Right) {
            res += "margin-left:auto;margin-right:0px;";
        }

        // vertical align
        if (this.verticalAlign == EVAlign.Middle) {
            res += "margin-top:auto;margin-bottom:auto;";
        } else if (this.verticalAlign == EVAlign.Bottom) {
            res += "margin-top:auto;margin-bottom:0px;";
        }
        
        // rendering width css
        if (this.width >= 0.0) {
            if (this.width == 0.0) {
                res += "width:0px;";
            } else if (this.width >= 1.0) {
                res += "width:" + Integer.toString((int)this.width) + "px;";
            } else {
                res += "width:" + Double.toString((this.width * 100.0)) + "%;";
            }
        }

        // rendering height css
        if (this.height >= 0.0) {
            if (this.height == 0.0) {
                res += "height:0px;";
            } else if (this.height >= 1.0) {
                res += "height:" + Integer.toString((int)this.height) + "px;";
            } else {
                res += "height:" + Double.toString((this.height * 100.0)) + "%;";
            }
        }

        return res;
    }

    /**
     * Indicates if this component is visible or not.
     * 
     * @return 
     * True if this component is visible, otherwise false.
     */
    public final boolean isVisible() {
        return this.visible;
    }

    /**
     * Sets the visible property of this component.
     * 
     * @param value 
     * The new value of the visible property.
     */
    public final void setVisible(boolean value) {
        this.visible = value;
    }



    /**
     * This method is invoked by the JWUI core when the resulting html is built.
     * <p>
     * You need to overwrite this method, to return as String which represents your control in HTML. The resulting HTML
     * will be inserted to the final HTML file.
     * </p>
     * 
     * @return The HTML String which fully represents this control.
     */
    public abstract String render();

}