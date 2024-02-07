package com.wutevr;

public class Main{
    public static void main(String[] args){
        // Set the pixel width and height
        int pixelWidth = 800;
        int pixelHeight = 600;

        // Create a display with a 60 Hz refresh rate
        //Display dis = new Display(pixelWidth, pixelHeight, 60);

        // Set visibility
        //dis.setVisible(true);
        Display display = new Display(pixelWidth, pixelHeight, 60);
    }
}