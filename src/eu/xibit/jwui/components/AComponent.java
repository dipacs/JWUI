package eu.xibit.jwui.components;

public abstract class AComponent {

    private static int ActId = 1;

    public static String getNextId() {
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
    private String onKeyDownScript = null;
    private String onKeyPressScript = null;
    private String onKeyUpScript = null;
    private String onClickScript = null;
    private String onDoubleClickScript = null;
    private String onMouseDownScript = null;
    private String onMouseMoveScript = null;
    private String onMouseUpScript = null;
    private String onMouseOutScript = null;
    private String onMouseOverScript = null;




    public AComponent() {
        super();
        this.id = AComponent.getNextId();
    }




    public final String getId() {
        return this.id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    
    protected double getWidth() {
        return this.width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    protected double getHeight() {
        return this.height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public final EHAlign getHorizontalAlign() {
        return this.horizontalAlign;
    }

    public final void setHorizontalAlign(EHAlign horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public final EVAlign getVerticalAlign() {
        return this.verticalAlign;
    }

    public final void setVerticalAlign(EVAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
    }



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

    public final boolean isVisible() {
        return this.visible;
    }

    public final void setVisible(boolean value) {
        this.visible = value;
    }



    public abstract String render();

}