package cs110.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
public class CsvData {

    public List<Record> getRecords() {
        return records;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    private static class Record {

        private int id;
        private String name;
        private float price;
        public Record(int id, String name, float price){
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    private List<Record> records;

    public CsvData(File file) throws IOException {
        records = new LinkedList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String[] res = sc.nextLine().split(",");
            Record record = new Record(
                Integer.parseInt(res[0]),
                res[1],
                Float.parseFloat(res[2])
            );
            records.add(record);
        }
        sc.close();
    }
}
