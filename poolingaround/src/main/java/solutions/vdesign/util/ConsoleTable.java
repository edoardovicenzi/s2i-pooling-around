package solutions.vdesign.util;

import java.util.*;

public class ConsoleTable {
    private int DEFAULT_WRAPPER_PADDING_SPACES = 2;
    private int DEFAULT_PADDING_SPACES = 15;

    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String[]> rows = new ArrayList<>();
    private ArrayList<Integer> fieldsWidths = new ArrayList<>();

    public ConsoleTable() {

    }

    public ConsoleTable(ArrayList<String> headers, ArrayList<String[]> rows) {
        for (int i = 0; i < headers.size(); i++) {
            this.fieldsWidths.add(DEFAULT_PADDING_SPACES);
        }
        init(headers, rows, this.fieldsWidths);
    }

    public ConsoleTable(ArrayList<String> headers, ArrayList<String[]> rows, ArrayList<Integer> fieldsWidths) {
        init(headers, rows, fieldsWidths);
    }

    // Utility
    private void init(ArrayList<String> headers, ArrayList<String[]> rows, ArrayList<Integer> fieldsWidths) {
        try {
            if (headers.size() != fieldsWidths.size()) {
                throw new Exception("Headers count must match custom fields width count.");
            } else {
                for (String[] row : rows) {
                    if (row.length != headers.size()) {
                        throw new Exception("Row(s) fields count mismatch with headers");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.fieldsWidths = fieldsWidths;
        this.headers = headers;
        this.rows = rows;

    }

    // Setters
    public ConsoleTable clearHeaders(){
        this.headers = new ArrayList<String>();
        this.fieldsWidths = new ArrayList<Integer>();
        return this;
    }

    public ConsoleTable addHeader(String newHeader) {
        this.headers.add(newHeader);
        this.fieldsWidths.add(DEFAULT_PADDING_SPACES);
        return this;
    }

    public ConsoleTable addHeader(String newHeader, Integer customWidth) {
        this.headers.add(newHeader);
        this.fieldsWidths.add(customWidth);
        return this;
    }

    public ConsoleTable addRow(String[] row) {
        this.rows.add(row);
        return this;
    }

    // Getters

    public String getTableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSeparator());
        sb.append(getHeaderRow());
        sb.append(getSeparator());

        for (String[] row : this.rows) {
            sb.append(this.getFormattedRow(row));
        }

        if (!this.rows.isEmpty()){
            sb.append(getSeparator());
        }

        return sb.toString();
    }

    public String getSeparator() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.headers.size(); i++) {
            sb.append("+");
            sb.append("-"
                    .repeat(this.headers.get(i).length() + this.fieldsWidths.get(i) + DEFAULT_WRAPPER_PADDING_SPACES));
        }

        sb.append("+%n");
        return String.format(sb.toString());
    }

    public String getFormatAlignment() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.headers.size(); i++) {
            int totalPadding = this.headers.get(i).length() + this.fieldsWidths.get(i);
            sb.append("| ");
            sb.append("%-" + totalPadding + "s");
            sb.append(" ");
        }

        sb.append("|%n");
        return sb.toString();
    }

    public String getFormattedRow(String[] row) {
        return String.format(this.getFormatAlignment(), (Object[]) row);
    }

    public String getHeaderRow() {
        return String.format(this.getFormatAlignment(), this.headers.toArray());
    }

    public void showDebug() {

        for (String header : this.headers) {
            System.out.print("| " + header + " ");
        }

        System.out.println();

        System.out.println(this.getFormatAlignment());

        for (Integer width : this.fieldsWidths) {
            System.out.print("| " + width + " ");
        }

        System.out.println();
    }

    public static void printBanner(String label){
        printBanner(label, 150);
    }

    public static void printBanner(String label, int padding){

        StringBuilder paddedString = new StringBuilder(label);
        for (int i = 0; i < padding - label.length(); i++) {
            paddedString.append(" ");
        }

        ConsoleTable userTable = new ConsoleTable();
        userTable.addHeader(paddedString.toString(), 0);
        System.out.println(userTable.getTableString());
        userTable.clearHeaders();
    }

}
