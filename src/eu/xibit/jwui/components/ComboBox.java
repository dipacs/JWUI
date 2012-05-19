package eu.xibit.jwui.components;

import java.util.ArrayList;
import java.util.List;

public final class ComboBox extends AComponent {

    private String name = "";
    private final List<ListItem> items = new ArrayList<ListItem>();




    public ComboBox() {
        super();
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        if (this.name == null) {
            this.name = "";
        }
    }

    public List<ListItem> getItems() {
        return this.items;
    }

    @Override
    public  double getWidth() {
        return super.getWidth();
    }

    @Override
    public  void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public  double getHeight() {
        return super.getHeight();
    }

    @Override
    public  void setHeight(double width) {
        super.setHeight(width);
    }



    @Override
    public  String render() {
        String res = "<select style=\"";
        res += this.renderSizeStyle() + "\"";

        res += "\">\n";

        for (int i = 0; i < this.items.size(); i++) {
            res += this.items.get(i).toHtml() + "\n";     
        }

        res += "</select>";

        return res;
    }

}