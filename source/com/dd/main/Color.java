package com.dd.main;

public class Color {
    private String Black = "\u001B[30m";
    private String Red = "\u001B[31m";
    private String Green = "\u001B[32m";
    private String Yellow = "\u001B[33m";
    private String Blue = "\u001B[34m";
    private String Magenta = "\u001B[35m";
    private String Cyan = "\u001B[36m";
    private String White = "\u001B[37m";
    private String Default = "\u001B[0m";

    /* Color types
    30 black
    31 red
    32 green
    33 yellow
    34 blue
    35 magenta
    36 cyan
    37 white
    40 black background
    41 red background
    42 green background
    43 yellow background
    44 blue background
    45 magenta background
    46 cyan background
    47 white background
    1 make bright (usually just bold)
    21 stop bright (normalizes boldness)
    4 underline
    24 stop underline
    0 clear all formatting
    */

    public String getBlack() {
        return Black;
    }

    public void setBlack(String black) {
        Black = black;
    }

    public String getRed() {
        return Red;
    }

    public void setRed(String red) {
        Red = red;
    }

    public String getGreen() {
        return Green;
    }

    public String getYellow() {
        return Yellow;
    }

    public String getBlue() {
        return Blue;
    }

    public String getMagenta() {
        return Magenta;
    }

    public String getCyan() {
        return Cyan;
    }

    public String getWhite() {
        return White;
    }

    public String getDefault() {
        return Default;
    }
}
