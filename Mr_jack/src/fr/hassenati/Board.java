package fr.hassenati;

import java.util.*;

public class Board {
    /*
         0 1 2
     11  .|.|.  3
     10  .|.|.  4
      9  .|.|.  5
         8 7 6

     */

    private ArrayList<ArrayList<District>> board = new ArrayList<>(3);
    private Card mrjackId;
    private ArrayList<Card> deck;
    private ArrayList<Detective> detectives = new ArrayList<>(3);
    private int lapNumber;
    private ArrayList<Jeton> jetons;


    public Board() {
        this.init();
    }

    private void init() {
        //jeton
        jetons = new ArrayList<>(Arrays.asList(Jeton.values()));

        //deck
        deck = new ArrayList<>(Arrays.asList(Card.values()));
        Collections.shuffle(deck);

        //board
        for (int i = 0; i < 3; i++) {
            ArrayList<District> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Direction random = Direction.values()[(int) (Math.random() * 3)];
                row.add(new District(deck.get(3 * i + j), random));
            }
            board.add(row);
        }
        board.get(0).get(0).setOrientation(Direction.WEST);
        board.get(0).get(2).setOrientation(Direction.EAST);
        board.get(2).get(1).setOrientation(Direction.SOUTH);

        //mrJackId
        Collections.shuffle(deck);
        mrjackId = draw();

        //detective pos
        detectives.add(Detective.HOLMES);
        detectives.add(Detective.WATSON);
        detectives.add(Detective.TOBY);

        lapNumber = 1;
    }

    public Board(ArrayList<ArrayList<District>> board, Card mrjackId, ArrayList<Card> deck, ArrayList<Detective> detectives, int lapNumber) {
        this.board = board;
        this.mrjackId = mrjackId;
        this.deck = deck;
        this.detectives = detectives;
        this.lapNumber = lapNumber;
    }

    public Card draw() {
        return deck.remove(deck.size() - 1);
    }

    public boolean isHolmesStarting() {
        return lapNumber % 2 == 1;
    }

    public void endTurn() {
        lapNumber++;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    @Override
    public String toString() {
        StringBuilder boardStr = new StringBuilder("\n");
        for (ArrayList<District> row : board) {
            for (District district : row) {
                boardStr.append(" | ").append(district.getCard()).append(district.getOrientation());
            }
            boardStr.append("|\n");
        }
        return "Board{" +
                "\nboard=" + boardStr +
                ", mrjackId=" + mrjackId +
                ", \ndeck=" + deck +
                ", \ndetectivesPositions=" + detectives +
                ", \nlapNumber=" + lapNumber +
                ", \njetons=" + jetons +
                '}';
    }

    public String show() {
        StringBuilder boardStr = new StringBuilder("\n");
        for (ArrayList<District> row : board) {
            for (int i=0; i<5; i++) {
                if(i>0 && i<4) {
                    boardStr.append(" ").append(row.get(i - 1));
                } else {

                }
            }
            boardStr.append("\n");
        }
        return "Le plateau ressemble a " +
                "board=\n" + boardStr +
                ", detectivesPositions=" + detectives + "\n" +
                ", lapNumber=" + lapNumber + "\n" +
                ", jetons=" + jetons;
    }

    public void moveDetective(Detective detective) {
        System.out.println("De quelle distance le faire avancer");
        int distance = Game.scan.nextInt();
        detective.movePosition(distance);
    }

    public void executeAction(Jeton jeton) {
        if (jeton.isHead()) {
            switch (jeton.ordinal()) {
                case 0:
                    moveDetective(detectives.get(0));
                    break;
                case 1:
                    moveDetective(detectives.get(1));
                    break;
                case 2:
//                    return "exchange";
                    break;
                default:
                    System.out.println("0:Holmes, 1:Watson, 2:Toby");
                    Detective detective = detectives.get(Game.scan.nextInt());
                    moveDetective(detective);
            }

        } else {
            switch (jeton.ordinal()) {
                case 0:
//                    return "draw";
                    break;
                case 1:
                    moveDetective(detectives.get(2));
                    break;
                default:
//                    return "rotate";
            }
        }
    }
}
