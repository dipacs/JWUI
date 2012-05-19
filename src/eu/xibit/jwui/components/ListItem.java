package eu.xibit.jwui.components;

public final class ListItem {

    private final String text;
    private final String value;
    private boolean selected = false;
    private boolean enabled = true;




    public ListItem(String text, String value) {
        super();
        this.text = text;
        this.value = value;
    }




    public String getText() {
        return this.text;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = false;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public String toHtml() {
        String res = "<option value=\"";
        if (this.value != null) {
            res += this.value;
        }
        res += "\"";

        if (!this.enabled) {
            res += " disabled=\"true\"";
        }

        if (this.selected) {
            res += " selected=\"true\"";
        }
        res += ">";

        if (this.text != null) {
            res += this.text;
        }

        res += "</option>\n";

        return res;
    }

}