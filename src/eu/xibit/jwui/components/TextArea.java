package eu.xibit.jwui.components;

public class TextArea extends AComponent {

    private String name;
    private String text = "";
    private boolean enabled = true;
    private boolean readonly = false;




    public TextArea() {
        super();
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        if (this.text == null) {
            this.text = "";
        }
    }


    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }


    public boolean isReadonly() {
        return this.readonly;
    }

    public void setReadonly(boolean value) {
        this.readonly = value;
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
        String nm = "";
        if (this.name != null) {
            nm = this.name;
        }
        String res = "<textarea name=\"" + this.name + "\"";

        if (!this.enabled) {
            res += " disabled=\"true\"";
        }

        if (this.readonly) {
            res += " readonly=\"true\"";
        }

        res+= "style=\"";
        res += this.renderSizeStyle();
        res += "\"";


        res += ">\n";

        if (this.text != null) {
            res += this.text;
        }

        res += "</textarea>\n";

        return res;
    }

}