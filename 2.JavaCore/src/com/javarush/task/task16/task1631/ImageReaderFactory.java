package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader (ImageTypes imageTypes) throws IllegalArgumentException {
        ImageReader imageReader;

        if (imageTypes == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");

        }
        switch (imageTypes) {
            case BMP: {
                imageReader = new BmpReader();
                break;
            }
            case JPG: {
                imageReader = new JpgReader();
                break;
            }
            case PNG: {
                imageReader = new PngReader();
                break;
            }
            default: {
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }

        }

        return imageReader;
    }
}
