# Terminal Blackjack Game

A simple terminal-based Blackjack game written in Java.

The player starts with **$2000** and must reach **$10,000** to win the game. Each round, the player places a bet, receives two random cards, and chooses whether to **Hit** or **Stand**.

## Features

* Terminal-based gameplay
* Player betting system
* Random card drawing
* Hit or Stand option
* Dealer random score
* Balance tracking
* Win condition at $10,000
* Lose condition when balance reaches $0

## How the Game Works

1. The player starts with `$2000`.
2. The player places a bet.
3. The player receives two random cards.
4. The player can choose:

   * `1` → Hit
   * `2` → Stand
5. If the player's card sum is:

   * `21` → Blackjack
   * More than `21` → Bust
   * Higher than dealer → Win
   * Lower than dealer → Lose
6. The game continues until:

   * The player reaches `$10,000`
   * The player loses all money

## Requirements

* Java JDK 17 or newer

## How to Run

Compile the program:

```bash
javac Main.java
```

Run the program:

```bash
java Main
```

## Example Gameplay

```text
*******************************************************************
** You got 2000$ and you should make it 10,000$ to win the game! **
********************** Good Luck Gambler ^_- **********************

Place your bet: 500
ace seven
Sum of cards is: 18

Hit or Stand?
1-Hit  2-Stand: 2

Your sum is: 18 Dealr's sum is: 16
Won!
Your new balance is: 2500
```

## Project Structure

```text
Main.java
README.md
```

## Main Java Concepts Used

* `HashMap`
* `ArrayList`
* `Random`
* `Scanner`
* `while` loops
* `for-each` loops
* Methods
* Conditional statements
* `Thread.sleep()`

## Notes

This is a beginner-friendly Blackjack project.
The dealer logic is simplified because the dealer receives a random score instead of drawing cards like a real Blackjack dealer.

## Future Improvements

* Add real dealer card drawing
* Add Ace value logic: `1` or `11`
* Add card suits
* Prevent duplicated cards
* Add replay confirmation
* Improve input validation
* Fix spelling from `dealr` to `dealer`
* Add better Blackjack rules

## Author

Amr K
