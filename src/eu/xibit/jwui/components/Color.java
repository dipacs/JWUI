package eu.xibit.jwui.components;

public final class Color {

    public static Color Red = Color.CreateFromRGB(255, 0, 0);
    public static Color Lime = Color.CreateFromRGB(0, 255, 0);
    public static Color Blue = Color.CreateFromRGB(0, 0, 255);
    public static Color Green = Color.CreateFromRGB(0, 192, 0);
    public static Color Grass = Color.CreateFromRGB(140, 255, 0);
    public static Color Yellow = Color.CreateFromRGB(255, 255, 0);
    public static Color Cyan = Color.CreateFromRGB(0, 255, 255);
    public static Color Fuchsia = Color.CreateFromRGB(255, 0, 255);
    public static Color White = Color.CreateFromRGB(255, 255, 255);
    public static Color Black = Color.CreateFromRGB(0, 0, 0);
    public static Color SkyBlue = Color.CreateFromRGB(0, 128, 255);
    public static Color Orange = Color.CreateFromRGB(255, 128, 0);
    public static Color Purple = Color.CreateFromRGB(128, 0, 255);
    public static Color Pink = Color.CreateFromRGB(255, 0, 128);




    public static Color CreateFromRGBA(int red, int green, int blue, int alpha) {
        return new Color(red, green, blue, alpha);
    }

    public static Color CreateFromRGB(int red, int green, int blue) {
        return new Color(red, green, blue, 255);
    }

    public static Color GetMixedColorRGB(Color color1, Color color2, double fadePos) {
        int r = Color.MixInt(color1.red, color2.red, fadePos);
        int g = Color.MixInt(color1.green, color2.green, fadePos);
        int b = Color.MixInt(color1.blue, color2.blue, fadePos);
        return Color.CreateFromRGB(r, g, b);
    }

    public static Color GetMixedColorRGBA(Color color1, Color color2, double fadePos) {
        int r = Color.MixInt(color1.red, color2.red, fadePos);
        int g = Color.MixInt(color1.green, color2.green, fadePos);
        int b = Color.MixInt(color1.blue, color2.blue, fadePos);
        int a = Color.MixInt(color1.alpha, color2.alpha, fadePos);
        return Color.CreateFromRGBA(r, g, b, a);
    }

    private static int MixInt(int val1, int val2, double fadePos) {
        int res = val1;
        double fp = fadePos;

        if (fp > 1.0) {
            fp = 1.0;
        } else if (fp < 0.0) {
            fp = 0.0;
        }

        res = (int)(res + ((val2 - val1) * fp));

        if (res > 255) {
            res = 255;
        } else if (res < 0) {
            res = 0;
        }

        return res;
    }




    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;




    private Color(int r, int g, int b, int a) {
        super();
        // red
        if (r > 255) {
            this.red = 255;
        } else if (r < 0) {
            this.red = 0;
        } else {
            this.red = r;
        }

        // green
        if (g > 255) {
            this.green = 255;
        } else if (g < 0) {
            this.green = 0;
        } else {
            this.green = g;
        }

        // blue
        if (b > 255) {
            this.blue = 255;
        } else if (b < 0) {
            this.blue = 0;
        } else {
            this.blue = b;
        }

        // alpha
        if (a > 255) {
            this.alpha = 255;
        } else if (a < 0) {
            this.alpha = 0;
        } else {
            this.alpha = a;
        }
    }




    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public int getAlpha() {
        return this.alpha;
    }



    public String toHexStringRGB() {
        String rs = Integer.toHexString(this.red);
        if (rs.length() < 2) {
            rs = "0" + rs;
        }

        String gs = Integer.toHexString(this.green);
        if (gs.length() < 2) {
            gs = "0" + gs;
        }

        String bs = Integer.toHexString(this.blue);
        if (bs.length() < 2) {
            bs = "0" + bs;
        }

        return rs + gs + bs;
    }

    public String toHexStringRGBA() {
        String rs = Integer.toHexString(this.red);
        if (rs.length() < 2) {
            rs = "0" + rs;
        }

        String gs = Integer.toHexString(this.green);
        if (gs.length() < 2) {
            gs = "0" + gs;
        }

        String bs = Integer.toHexString(this.blue);
        if (bs.length() < 2) {
            bs = "0" + bs;
        }

        String as = Integer.toHexString(this.alpha);
        if (as.length() < 2) {
            as = "0" + as;
        }

        return rs + gs + bs + as;
    }

    public String toHexStringARGB() {
        String rs = Integer.toHexString(this.red);
        if (rs.length() < 2) {
            rs = "0" + rs;
        }

        String gs = Integer.toHexString(this.green);
        if (gs.length() < 2) {
            gs = "0" + gs;
        }

        String bs = Integer.toHexString(this.blue);
        if (bs.length() < 2) {
            bs = "0" + bs;
        }

        String as = Integer.toHexString(this.alpha);
        if (as.length() < 2) {
            as = "0" + as;
        }

        return as + rs + gs + bs;
    }

    @Override
    public String toString() {
        return "#" + this.toHexStringARGB();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Color)) {
            return false;
        }

        Color o = (Color)other;

        return (this.red == o.red 
                && this.green == o.green 
                && this.blue == o.blue 
                && this.alpha == o.alpha);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.red;
        hash = 43 * hash + this.green;
        hash = 43 * hash + this.blue;
        hash = 43 * hash + this.alpha;
        return hash;
    }


    public Color mix(Color otherColor, double fadePos) {
        return Color.GetMixedColorRGBA(this, otherColor, fadePos);
    }

}