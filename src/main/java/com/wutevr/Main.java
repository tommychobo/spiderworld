package com.wutevr;

public class Main{
    public static void main(String[] args){
        // Set the pixel width and height
        int pixelWidth = 1000;
        int pixelHeight = 800;

        Display display = new Display(pixelWidth, pixelHeight);
        
        display.setVisible(true);
    }
}