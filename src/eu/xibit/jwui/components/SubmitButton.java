package eu.xibit.jwui.components;

public final class SubmitButton extends AComponent {

    private String name = "";
    private boolean enabled = true;
    private String text = "Submit";




    public SubmitButton() {
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

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        if (this.text == null) {
            this.text = "";
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
        String n = this.name;
        if (n == null) {
            n = "";
        }
        String disa = "false";
        if (!this.enabled) {
            disa = "true";
        }
        String val = this.text;
        if (val == null) {
            val = "Submit";
        }
        String res = "<input type=\"submit\" name=\"" + n + "\"";
        if (!this.enabled) {
            res += " disabled=\"" + disa + "\"";
        }
        res += " value=\"" + val + "\" style=\"";
        res += this.renderSizeStyle();
        res += "\"/>";

        return res;
    }

}