package cs110.model;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Getter
public class TextData {

    private String text;

    public TextData(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file).useDelimiter("\\Z");
        text = sc.next();
        sc.close();
    }

    public String getText() {
        return text;
    }
}
