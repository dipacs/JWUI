package eu.xibit.jwui.components;

public final class FileUpload extends AComponent {

    private String name = "";
    private String mimeType = null;




    public FileUpload() {
        super();
    }




    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
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
        String res = "<input type=\"file\" name=\"" + this.name + "\"";
        if (this.mimeType != null) {
            res += " accept=\"" + this.mimeType + "\"";
        }

        res += " style=\"";
        res += this.renderSizeStyle();
        res += "\"/>\n";

        return res;
    }

}