package eu.xibit.jwui.components;

import java.util.ArrayList;

public final class TableLayout extends AComponent {

    private final ArrayList<AComponent> components;
    private final ArrayList<Integer> colWidths;
    private final ArrayList<Integer> rowHeights;
    private int spacing = 0;
    private int padding = 0;




    public TableLayout(int colCount, int rowCount) {
        super();
        if (colCount < 1) {
            throw new IllegalArgumentException("The colCount parameter can not be smaller than 1.");
        }
        if (rowCount < 1) {
            throw new IllegalArgumentException("The rowCount parameter can not be smaller than 1.");
        }
        this.components = new ArrayList<AComponent>(colCount * rowCount);
        this.colWidths = new ArrayList<Integer>(colCount);
        this.rowHeights = new ArrayList<Integer>(rowCount);
    }




    public AComponent getComponent(int col, int row) {
        return this.components.get(row * this.colWidths.size() + col);
    }

    public void setComponent(AComponent component, int col, int row) {
        this.components.set(row * this.colWidths.size() + col, component);
    }



    public Integer getColWidth(int colIndex) {
        return this.colWidths.get(colIndex);
    }

    public void setColWidth(int colIndex, Integer value) {
        this.colWidths.set(colIndex, value);
    }



    public Integer getRowHeight(int rowIndex) {
        return this.rowHeights.get(rowIndex);
    }

    public void setRowHeight(int rowIndex, Integer value) {
        this.rowHeights.set(rowIndex, value);
    }



    public int getSpacing() {
        return this.spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }



    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
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
        String style = this.renderSizeStyle();

        String res = "<table style=\"" + style + "\" cellspacing=\"" + Integer.toString(this.spacing) + " cellpadding=\"" + Integer.toString(this.spacing) + "\""; 
        if (this.getWidth() >= 0.0) {
            res += " width=\"";
            if (this.getWidth() == 0.0) {
                res += "0";
            } else if (this.getWidth() >= 1.0) {
                res += Integer.toString((int)this.getWidth());
            } else {
                res += Double.toString((this.getWidth() * 100.0)) + "%;";
            }
            res += "\"";
        }
        if (this.getHeight() >= 0.0) {
            res += " height=\"";
            if (this.getHeight() == 0.0) {
                res += "0";
            } else if (this.getHeight() >= 1.0) {
                res += Integer.toString((int)this.getHeight());
            } else {
                res += Double.toString((this.getHeight() * 100.0)) + "%;";
            }
            res += "\"";
        }
        res += ">\n";

        int colCount = this.colWidths.size();
        int rowCount = this.rowHeights.size();
        AComponent component = null;
        Integer w = null;
        Integer h = null;
        for (int row = 0; row < rowCount; row++) {
            res += "<tr>\n";
            h = this.rowHeights.get(row);
            for (int col = 0; col < colCount; col++) {
                w = this.colWidths.get(col);
                component = this.components.get(row * colCount + col);
                res += "<td";
                if (w != null) {
                    res += " width=\"" + w.toString() + "\"";
                }
                if (h != null) {
                    res += " height=\"" + h.toString() + "\"";
                }
                if (component != null) {
                    if (component.getHorizontalAlign() != null) {
                        res += " align=\"" + component.getHorizontalAlign().toString() + "\"";
                    } else {
                        res += " align=\"left\"";
                    }
                    if (component.getVerticalAlign() != null) {
                        res += " valign=\"" + component.getVerticalAlign().toString() + "\"";
                    } else {
                        res += " valign=\"top\"";
                    }
                }
                res += ">\n";

                if (component != null) {
                    res += component.render() + "\n";
                } else {
                    res += "\n";
                }

                res += "</td>\n";
            }
            res += "</tr>\n";
        }

        res += "</table>\n";

        return res;
    }

}