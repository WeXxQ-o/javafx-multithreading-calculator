package com.example.vlaknis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Platform;

public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea faktorialArea;
    @FXML
    private TextArea mocninaArea;
    @FXML
    private TextArea fibonachiArea;
    @FXML
    private ProgressBar faktorialBar;
    @FXML
    private ProgressBar mocninaBar;
    @FXML
    private ProgressBar fibonachiBar;


    @FXML
    protected void runAll() {
        try {
            Faktorial faktorial = new Faktorial(Integer.parseInt(textField.getText()));
            faktorial.start();
            faktorialArea.clear();
            faktorialBar.setProgress(0);

            Mocnina mocnina = new Mocnina(Integer.parseInt(textField.getText()));
            mocnina.start();
            mocninaArea.clear();
            mocninaBar.setProgress(0);

            Fibonachi fibonachi = new Fibonachi(Integer.parseInt(textField.getText()));
            fibonachi.start();
            fibonachiArea.clear();
            fibonachiBar.setProgress(0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public class Faktorial extends Thread {
        public int krok;

        public Faktorial(int krok) {
            this.krok = krok;
        }

        @Override
        public void run() {
            long faktorial = 1;
            for (int i = 1; i <= krok; i++) {
                faktorial *= i;
                long finalFaktorial = faktorial;
                int finalI = i;
                Platform.runLater(() -> {
                    faktorialArea.appendText(finalFaktorial + "\n");
                    faktorialBar.setProgress(finalI / (double) krok);
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }

    }

    public class Mocnina extends Thread {
        public int krok;
        int mocnina;

        public Mocnina(int krok) {
            this.krok = krok;
        }

        @Override
        public void run() {
            for (int i = 1; i <= krok; i++) {
                mocnina = (int) Math.pow(i, 2);
                int finalMocnina = mocnina;
                int finalI = i;
                Platform.runLater(() -> {
                    mocninaArea.appendText(finalMocnina + "\n");
                    mocninaBar.setProgress(finalI / (double) krok);
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }

    public class Fibonachi extends Thread {
        public int krok;
        long fibonachi;

        long a = 0;
        long b =1;

        public Fibonachi(int krok) {
            this.krok = krok;
        }

        @Override
        public void run() {
            for (int i = 0; i < krok; i++){
                fibonachi = a;

                long next = a + b;
                a = b;
                b = next;
                long finalFibonachi = fibonachi;
                int finalI = i;
                Platform.runLater(() -> {
                    fibonachiArea.appendText(finalFibonachi  + "\n");
                    fibonachiBar.setProgress((finalI + 1) / (double) krok);
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }
}
