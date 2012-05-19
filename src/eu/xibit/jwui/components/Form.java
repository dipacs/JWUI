package eu.xibit.jwui.components;

public final class Form extends AComponent {

    private String target = "";
    private AComponent rootComponent;




    public Form() {
        super();
    }




    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }



    public AComponent getRootComponent() {
        return this.rootComponent;
    }

    public void setRootComponent(AComponent rootComponent) {
        this.rootComponent = rootComponent;
    }





    @Override
    public final String render() {
        String style = this.renderSizeStyle();

        // adding horizontal overflow type
        /*style += "overflow-x:";
        if (this.hOverflow != null) {
            style += this.hOverflow.toCss();
        } else {
            style += "hidden";
        }
        style += ";";

        // adding vertical overflow type
        style += "overflow-y:";
        if (this.vOverflow != null) {
            style += this.vOverflow.toCss();
        } else {
            style += "hidden";
        }
        style += ";";*/
        
        // adding back color
        /*if (this.backColor != null) {
            style += "background-color:#" + this.backColor.toHexStringRGB() + ";";
        }*/

        // adding border
        /*if (this.border != null) {
            style += this.border.toCss();
        }*/

        String res = "<div style=\"" + style + "\">\n";

        // adding form 
        res += "<form action=\"";
        if (this.target != null) {
            res += this.target;
        }

        res += "\" method=\"post\" enctype=\"multipart/form-data\">\n";
        if (this.rootComponent != null) {
            res += this.rootComponent.render();
        }
        /*for (int i = 0 to this.childs.size()) {
            if (this.childs.get(i) != null) {
                if (this.childs.get(i){AComponent}.isVisible()) {
                    res = res + this.childs.get(i){AComponent}.render() + "\n";
                }
            }
        }*/
        res += "</form></div>\n";
        return res; 
    }

}