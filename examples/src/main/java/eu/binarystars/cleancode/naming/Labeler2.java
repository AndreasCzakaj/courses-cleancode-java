package eu.binarystars.cleancode.naming;

public class Labeler2 {
    private ILabelPrinter printer;
    private String[] a;
    public void prAL() {
        for (int i = 0; i < a.length; i++) {
            printer.printLine(a[i]);
        }
    }
}
