package eu.xibit.jwui.components;

public class HiddenField extends AComponent {

    private String name = "";
    private String value = "";

    public HiddenField() {
        super();
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
        if (this.value == null) {
            this.value = "";
        }
    }



    @Override
    public String render() {
        String res = "<input type=\"hidden\" name=\"" + this.name + "\" value=\"" + this.value + "\"/>\n";
        return res;
    }

}