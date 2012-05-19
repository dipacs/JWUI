package eu.xibit.jwui.components;

public final class PasswordBox extends AComponent {

    private String name = "";
    private boolean enabled = true;
    private int maxLength = -1;
    private boolean readonly = false;
    private String text = "";




    public PasswordBox () {
        super();
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int value) {
        this.maxLength = value;
    }

    public boolean isReadonly() {
        return this.readonly;
    }

    public void setReadonly(boolean value) {
        this.readonly = value;
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
        String res = "<input type=\"password\" name=\"" + this.name + "\" value=\"" + this.text + "\"";
        if (this.readonly) {
            res += " readonly=\"true\"";
        }
        if (!this.enabled) {
            res += " disabled=\"true\"";
        }
        if (this.maxLength > 0) {
            res += " maxlength=\"" + Integer.toString(this.maxLength) + "\"";
        }
        res += " style=\"" + this.renderSizeStyle() + "\"";
        res += " />";
        
        return res;
    }

}