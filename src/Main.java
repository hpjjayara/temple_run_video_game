import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;


public class Main extends Application {
    Scanner sc = new Scanner(System.in);
    String competitor[][] = new String[20][6]; //create 2d string array
    int[] score = new int[competitor.length];
    int[] distance = new int[competitor.length];
    int[] coins = new int[competitor.length];
    int[] number = new int[competitor.length];
    String[][] storeData = new String[competitor.length][];


    public static void main(String[] args) {

        Application.launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {
        Scanner sc = new Scanner(System.in);
        String option = "z";
        while (!option.equalsIgnoreCase("Q")) { //select the options
            System.out.println("\n<<--------Welcome to Temple Run Game !!!-------->>");
            System.out.println("Enter \"A\" to add a competitor details :");
            System.out.println("Enter \"H\" to view competitor with the highest score :");
            System.out.println("Enter \"D\" to view competitor who ran the maximum distance :");
            System.out.println("Enter \"C\" to view competitor who collected the maximum number of gold coins :");
            System.out.println("Enter \"V\" to view all the competitor details :");
            System.out.println("Enter \"F\" to view  details of a specific player :");
            System.out.println("Enter \"W\" to view  all three winners :");
            System.out.println("Enter \"Z\" to view  a selected winner :");
            System.out.println("Enter \"Q\" to quit :");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
            option = sc.next();

            switch (option) {
                case "A":
                case "a":

                    System.out.println("Competitor Details");
                    addCompetitorDetails();
                    convertStringToInt(competitor, score, distance, coins, storeData, number);
              break;
                case "H":
                case "h":
                    try {
                        System.out.println("view competitor with the highest score");
                        System.out.println("HIGHEST SCORE WINNER :--->>");
                        String[] maxArray = getMax(score);
                        System.out.println("COMPETITOR'S NUMBER :-->" + maxArray[0]);
                        System.out.println("COMPETITOR'S NAME :-->" + maxArray[1]);
                        System.out.println("COMPETITOR'S SCORE :-->" + maxArray[2]);

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "D":
                case "d":
                    try {
                        System.out.println("view competitor who ran the maximum distance");
                        System.out.println("MAXIMUM DISTANCE WINNER :--->>");
                        String[] maxArray = getMax(distance);
                        System.out.println("COMPETITOR'S NUMBER :-->" + maxArray[0]);
                        System.out.println("COMPETITOR'S NAME :-->" + maxArray[1]);
                        System.out.println("COMPETITOR'S DISTANCE :-->" + maxArray[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "C":
                case "c":
                    try {
                        System.out.println("view competitor who collected the maximum number of gold coins");
                        System.out.println("MAXIMUM NUMBER OF GOLD COINS WINNER :--->>");
                        String[] maxArray = getMax(coins);
                        System.out.println("COMPETITOR'S NUMBER :-->" + maxArray[0]);
                        System.out.println("COMPETITOR'S NAME :-->" + maxArray[1]);
                        System.out.println("COMPETITOR'S COINS :-->" + maxArray[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "V":
                case "v":
                    try {
                        System.out.println("view all the competitor details");
                        viewCompetitorDetails();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "F":
                case "f":
                    try {
                        System.out.println("view  details of a specific player");
                        viewSpecificPlayerDetails(number);
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "W":
                case "w":
                    try {
                        System.out.println("view  all three winners");
                        viewWinners();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "Z":
                case "z":
                    try {
                        System.out.println("view  a selected winner");
                        viewSelectedWinner(number);
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "Q":
                case "q":
                    System.out.println("quit the program");
                    break;
            }
        }

    }


    // add competitors to array
    private void addCompetitorDetails() {

        for (int i = 0; i < competitor.length; ++i) {

            System.out.println("Competitor Number--\n" + (i + 1));
            competitor[i][0] = String.valueOf(i + 1);

            System.out.println("Competitor Name--");
            competitor[i][1] = sc.next();

            System.out.println("Competitor Age--");
            while (!sc.hasNextInt()) { //condition for user input not a integer
                System.out.println("Please Enter Integer!!!");
                sc.next();
            }
            competitor[i][2] = String.valueOf(sc.nextInt());

            System.out.println("Competitor's Score --");
            while (!sc.hasNextInt()) {
                System.out.println("Please Enter Integer!!!");
                sc.next();
            }
            competitor[i][3] = String.valueOf(sc.nextInt());

            System.out.println("Competitor's Reached Distance --");
            while (!sc.hasNextInt()) {
                System.out.println("Please Enter Integer!!!");
                sc.next();
            }
            competitor[i][4] = String.valueOf(sc.nextInt());

            System.out.println("Competitor's Collected coins --");
            while (!sc.hasNextInt()) {
                System.out.println("Please Enter Integer!!!");
                sc.next();
            }
            competitor[i][5] = String.valueOf(sc.nextInt());


        }
        //store competitors to array
        for (int i = 0; i < competitor.length; ++i) {
            storeData[i] = new String[competitor[i].length];
            for (int j = 0; j < competitor[i].length; ++j) {
                storeData[i][j] = competitor[i][j];
            }
        }
        System.out.println(Arrays.deepToString(storeData));


    }

    //string 2d array convert to  int 1d array
    private void convertStringToInt(String[][] competitor, int[] score, int[] distance, int[] coins, String[][] storeData, int[] number) {

        for (int i = 0; i < competitor.length; i++) {

            number[i] = Integer.parseInt(competitor[i][0]);
            score[i] = Integer.parseInt(competitor[i][3]);
            distance[i] = Integer.parseInt(competitor[i][4]);
            coins[i] = Integer.parseInt(competitor[i][5]);
        }


    }

    //get maximum value for score,distance,coins
    private String[] getMax(int[] array) {
        String[] maxArray = new String[3]; //create string array to store cNumber,name and maxValue
        int maxValue = 0;
        int cNumber = 0;
        String name = " ";

        for (int i = 0; i < array.length; i++) {

            if (array[i] > maxValue) {

                maxValue = array[i];
                cNumber = number[i];
                name = competitor[i][1];

            }
        }

        maxArray[0] = Integer.toString(cNumber);
        maxArray[1] = name;
        maxArray[2] = Integer.toString(maxValue);

        return maxArray;
    }

    //vew competitor's details in CLI and GUI
    private void viewCompetitorDetails() {

        Stage stage = new Stage();
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        vbox.setStyle("-fx-background-color: #000000");
        Scene scene = new Scene(vbox, 1000, 350);
        stage.setScene(scene);
        stage.setTitle("Temple Run Game");


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //button to view competitors
        Button addButton = new Button("View Competitor Details");
        addButton.setStyle("-fx-background-color:#b8b894");
        gridPane.add(addButton, 3, 1);
        //setOnAction
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //create 2d array for twenty buttons
                Button[][] btns = new Button[4][5];

                gridPane.setVisible(true);

                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns[i].length; j++) {
                        if ((i * btns[i].length + j + 1) < 10) { //buttons numbering
                            btns[i][j] = new Button("Competitor ----->> 0" + (i * btns[i].length + j + 1));
                        } else {
                            btns[i][j] = new Button("Competitor ----->> " + (i * btns[i].length + j + 1));
                        }

                        gridPane.setHgap(20);
                        gridPane.setVgap(20);

                        int arrayNumber = i * btns[i].length + j;


                        btns[i][j].setStyle("-fx-background-color:  #ebebe0");

                        //setOnAction
                        btns[i][j].setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {


                                System.out.println("Enter Competitor Number : " + (arrayNumber + 1));//print competitor number and view competitor details in console
                                for (int i = 0; i < competitor.length; i++) {
                                    if ((arrayNumber + 1) == number[i]) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("TEMPLE RUN GAME");
                                        alert.setHeaderText("Competitor details--> ");
                                        alert.setContentText("Competitor Number : " + competitor[i][0] + "\nCompetitor Name : " + competitor[i][1] + "\nCompetitor Age : " + competitor[i][2] + "\nCompetitor's Score : " + competitor[i][3] + "\nCompetitor's Reached Distance : " + competitor[i][4] + "\nCompetitor's Collected coins : " + competitor[i][5]);
                                        alert.showAndWait();


                                        System.out.println("Competitor-->" + (i + 1));

                                        System.out.println("Competitor Number : " + competitor[i][0]);
                                        System.out.println("Competitor Name : " + competitor[i][1]);
                                        System.out.println("Competitor Age : " + competitor[i][2]);
                                        System.out.println("Competitor's Score : " + competitor[i][3]);
                                        System.out.println("Competitor's Reached Distance : " + competitor[i][4]);
                                        System.out.println("Competitor's Collected coins : " + competitor[i][5]);
                                        System.out.println();

                                        break;

                                    } else if (i == competitor.length - 1) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("TEMPLE RUN GAME");
                                        alert.setHeaderText("Competitor details--> ");
                                        alert.setContentText("No Competitor");
                                        alert.showAndWait();

                                        System.out.println("No Competitor");
                                    }


                                    System.out.println();


                                }


                            }
                        });
                        gridPane.add(btns[i][j], j + 1, i + 3);


                    }
                }
            }

        });


        vbox.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.showAndWait();


    }

    // find to specific player
    private void viewSpecificPlayerDetails(int[] number) {

        System.out.println("Enter competitor\'s competitor number:");
        int comNumber = sc.nextInt();


        for (int i = 0; i < number.length; i++) {

            if (comNumber == number[i]) { //conditions for check user input number equal number array element
                System.out.println(" Is Found.\n");
                System.out.println("Competitor Number : " + competitor[i][0]);
                System.out.println("Competitor Name : " + competitor[i][1]);
                System.out.println("Competitor Age : " + competitor[i][2]);
                System.out.println("Competitor's Score : " + competitor[i][3]);
                System.out.println("Competitor's Reached Distance : " + competitor[i][4]);
                System.out.println("Competitor's Collected coins : " + competitor[i][5]);

                break;

            } else if (i == number.length - 1) {
                System.out.println("Is Not Found");
            }

        }

    }

    //view three winners
    private void viewWinners() {
        Stage stage = new Stage();
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        vbox.setStyle("-fx-background-color: #330000");
        Scene scene = new Scene(vbox, 1000, 350);
        stage.setScene(scene);
        stage.setTitle("Temple Run Game");


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Button addButton = new Button("View All Three Winners Details");
        addButton.setStyle("-fx-background-color: #ff9999");
        gridPane.add(addButton, 2, 1);
        addButton.setOnAction(event -> {
            //create 2d array for 3 buttons
            Button[][] btns = new Button[1][3];

            gridPane.setVisible(true);

            for (int i = 0; i < btns.length; i++) {
                for (int j = 0; j < btns[i].length; j++) {

                    btns[i][0] = new Button("HIGHEST SCORE WINNER--->> ");
                    btns[i][1] = new Button("     DISTANCE WINNER--->> ");
                    btns[i][2] = new Button("        COINS WINNER--->> ");


                    gridPane.setHgap(20);
                    gridPane.setVgap(20);

                    int arrayNumber = i * btns[i].length + j;

                    btns[i][j].setStyle("-fx-background-color:  #ffcccc");

                    // create text are for show three winners details in GUI
                    TextArea area = new TextArea();

                    if ((arrayNumber + 1) == 1) {
                        String[] maxArray = getMax(score);
                        area.setText("\nWinner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Score : " + maxArray[2]);
                        area.setPrefColumnCount(15);
                        area.setPrefHeight(120);
                        area.setPrefWidth(300);
                        gridPane.add(area, 1, 4);


                    } else if ((arrayNumber + 1) == 2) {
                        String[] maxArray = getMax(distance);
                        area.setText("\nWinner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Distance : " + maxArray[2]);
                        area.setPrefColumnCount(15);
                        area.setPrefHeight(120);
                        area.setPrefWidth(300);
                        gridPane.add(area, 2, 4);

                        //maximum gold coins winner's details add to alert box
                    } else {
                        String[] maxArray = getMax(coins);
                        area.setText("\nWinner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Distance : " + maxArray[2]);
                        area.setPrefColumnCount(15);
                        area.setPrefHeight(120);
                        area.setPrefWidth(300);
                        gridPane.add(area, 3, 4);
                    }


                    // show three winners details in CLI
                    if ((arrayNumber + 1) == 1) {  //show score winner details
                        System.out.println("HIGHEST SCORE WINNER:-->\n");
                        String[] maxArray = getMax(score);
                        System.out.println("Winner's Number Is : " + maxArray[0]);
                        System.out.println("Winner's Name Is : " + maxArray[1]);
                        System.out.println("Winner's Score Is : " + maxArray[2]);


                        System.out.println();

                    } else if ((arrayNumber + 1) == 2) { //show distance winner details
                        System.out.println("MAXIMUM DISTANCE WINNER :-->\n");

                        String[] maxArray = getMax(distance);
                        System.out.println("Winner's Number Is : " + maxArray[0]);
                        System.out.println("Winner's Name Is : " + maxArray[1]);
                        System.out.println("Winner's Distance Is : " + maxArray[2]);

                        System.out.println();

                    } else { //show gold coins winner details
                        System.out.println("MAXIMUM GOLD COINS WINNER:-->\n");

                        String[] maxArray = getMax(coins);
                        System.out.println("Winner's Number Is : " + maxArray[0]);
                        System.out.println("Winner's Name Is : " + maxArray[1]);
                        System.out.println("Winner's Coins Is : " + maxArray[2]);

                        System.out.println();
                    }

//                        }
//                    });


                    gridPane.add(btns[i][j], j + 1, i + 3);


                }

            }

        });


        vbox.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.showAndWait();

    }

    //view selected winner
    private void viewSelectedWinner(int[] number) {
        Stage stage = new Stage();
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        vbox.setStyle("-fx-background-color:#293d3d");
        Scene scene = new Scene(vbox, 650, 300);
        stage.setScene(scene);
        stage.setTitle("Temple Run Game");


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Button[][] btns = new Button[1][3];
        gridPane.setVisible(true);

        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {

                btns[i][0] = new Button("HIGHEST SCORE WINNER");
                btns[i][1] = new Button("  DISTANCE WINNER   ");
                btns[i][2] = new Button("  COINS WINNER      ");


                gridPane.setHgap(20);
                gridPane.setVgap(20);

                int arrayNumber = i * btns[i].length + j;

                btns[i][j].setStyle("-fx-background-color:  #b3cccc");


                btns[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {

                        //create alert boxes
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("TEMPLE RUN GAME");

                        //highest score winner's data add to alert box
                        if ((arrayNumber + 1) == 1) {
                            alert.setHeaderText("Highest Score  Winner--> ");
                            String[] maxArray = getMax(score);
                            alert.setContentText("Winner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Score : " + maxArray[2]);
//                            alert.showAndWait();

                            //maximum distance winner's data add to alert box
                        } else if ((arrayNumber + 1) == 2) {
                            alert.setHeaderText("Maximum Distance Winner--> ");
                            String[] maxArray = getMax(distance);
                            alert.setContentText("Winner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Distance : " + maxArray[2]);

                            //maximum gold coins winner's data add to alert box
                        } else {
                            alert.setHeaderText("Maximum Gold Coins Winner--> ");
                            String[] maxArray = getMax(coins);
                            alert.setContentText("Winner's Number : " + maxArray[0] + "\nWinner Name : " + maxArray[1] + "\nWinner's Maximum Coins : " + maxArray[2]);
                        }
                        alert.showAndWait();

                    }
                });


                gridPane.add(btns[i][j], j + 2, i + 3); //fixed size of gridPane


            }

        }


        vbox.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.showAndWait();


    }

}










