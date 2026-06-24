import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 2000;

        HashMap<String, Integer> cardsValue = new HashMap<>();
        cardsValue.put("two", 2);
        cardsValue.put("three", 3);
        cardsValue.put("four", 4);
        cardsValue.put("five", 5);
        cardsValue.put("six", 6);
        cardsValue.put("seven", 7);
        cardsValue.put("eight", 8);
        cardsValue.put("nine", 9);
        cardsValue.put("ten", 10);
        cardsValue.put("J", 10);
        cardsValue.put("Q", 10);
        cardsValue.put("K", 10);
        cardsValue.put("ace", 11);

        ArrayList<Integer> dealrCards = new ArrayList<>();
        dealrCards.add(14);
        dealrCards.add(15);
        dealrCards.add(16);
        dealrCards.add(17);
        dealrCards.add(18);
        dealrCards.add(19);
        dealrCards.add(20);
        dealrCards.add(21);
        dealrCards.add(22);
        dealrCards.add(23);
        dealrCards.add(24);

        System.out.println("*******************************************************************");
        System.out.println("** You got 2000$ and you should make it 10,000$ to win the game! **");
        System.out.println("********************** Good Luck Gambler ^_- **********************");

        while (balance > 0) {
            System.out.print("Place your bet: ");
            int userBet = scanner.nextInt();
            while ((userBet > balance) || (userBet <= 0)) {
                System.out.print("Invalid bet!, place you bet: ");
                userBet = scanner.nextInt();
            }

            ArrayList<String> playerCards = new ArrayList<>();
            playerCards.add(randomCard());
            playerCards.add(randomCard());
            int cardsSum = 0;
            for (String card : playerCards) {
                System.out.print(card + " ");
                cardsSum += cardsValue.get(card);
            }
            System.out.println("Sum of cards is: " + cardsSum);

            System.out.println("Hit or Stand?");
            System.out.print("1-Hit  2-Stand: ");
            int userOption = scanner.nextInt();
            while ((userOption != 1) && (userOption != 2)) {
                System.out.print("Wrong value, Enter 1-Hit or 2-Stand: ");
                userOption = scanner.nextInt();
            }
            while ((userOption == 1) && (cardsSum < 21)) {
                playerCards.add(randomCard());
                cardsSum += cardsValue.get(playerCards.get(playerCards.size() - 1));

                System.out.println("The new card is: " + playerCards.get(playerCards.size() - 1));
                System.out.println("Sum of cards is: " + cardsSum);

                if (cardsSum == 21) {
                    System.out.println("Your new balance is: " + balance);
                    break;
                } else if (cardsSum > 21) {
                    break;
                }
                System.out.println("Hit or Stand?");
                System.out.print("1-Hit  2-Stand: ");
                userOption = scanner.nextInt();
                while ((userOption != 1) && (userOption != 2)) {
                    System.out.println("Wrong value, Enter 1-Hit or 2-Stand");
                    userOption = scanner.nextInt();
                }
            }
            int dealrSum = dealrCards.get(random.nextInt(0, dealrCards.size()));
            if (cardsSum == 21) {
                System.out.println("*******************************************************************");
                System.out.println("***************************!Black Jack!****************************");
                System.out.println("*******************************************************************");
                balance += userBet;
                System.out.println("Your new balance is: " + balance);
            } else if (cardsSum > 21) {
                System.out.println("Bust!");
                balance -= userBet;
                System.out.println("Your new balance is: " + balance);

            } else if (cardsSum > dealrSum || dealrSum > 21 ) {
                System.out.println("Your sum is: " + cardsSum + " " + "Dealr's sum is: " + dealrSum);
                System.out.println("Won!");
                balance += userBet;
                System.out.println("Your new balance is: " + balance);
            } else {
                System.out.println("Your sum is: " + cardsSum + " " + "Dealr's sum is: " + dealrSum);
                System.out.println("Lost!");
                balance -= userBet;
                System.out.println("Your new balance is: " + balance);
            }


            if (balance > 10000) {
                System.out.println("Congrats!, you got your 10k!");
                break;
            } else if (balance <= 0) {
                System.out.println("You are broke!");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static String randomCard() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add("ace");
        cards.add("two");
        cards.add("three");
        cards.add("four");
        cards.add("five");
        cards.add("six");
        cards.add("seven");
        cards.add("eight");
        cards.add("nine");
        cards.add("ten");
        cards.add("J");
        cards.add("Q");
        cards.add("K");
        Integer randomValueCard = random.nextInt(2, 12);
        String randomCard = cards.get(randomValueCard);
        return randomCard;
    }
}