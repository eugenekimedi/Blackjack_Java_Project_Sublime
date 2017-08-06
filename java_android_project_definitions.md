# Java/Android Project Definitions - Solo Project

## To-Do List

Goal: Practice what we learned in the Java / Android weeks and research how to persist data. 

### MVP
You are required to write an Android app which will allow the user to maintain a task list. The user should be able to enter tasks and display them in a list. The list should only show the bare details of each task. Selecting a task from the list should bring up another screen which shows full details of the task.
Users should also be able to mark tasks as completed.

### Project Extensions

* Allow the user to prioritise and/or categorise tasks
* Use the calendar to set due dates on tasks. 

# Pontoon/Blackjack

Goal: Create a card game.

The goal of this project is to model in Java the elements involved in a game of cards. You are not required to write a Runner to actually play the game, just write and test the models.

These include (but are not limited to): players, cards, hands of cards, cards being dealt, turns being taken.

You will also need to implement the rules of the game. The choice of game is up to you, but one game you may wish to model is Blackjack/Pontoon. (It's probably best to stick to a game which involves each player having only a small number of cards).

Remember to use TDD!

### MVP 

- Deal two cards to the dealer and the player
- Compare the hands
- Determine the winner from who has the highest value hand 

### Project Extension

- Allow the player to "twist" up to 21 or "stick" (you go bust if you exceed this and lose the round).
- Allow the dealer to do the same
- Compare hands once both players have stuck.

###  ***Extreme*** Extension
- Create an Android Application which allows you to play the game where the user is the player and the Computer is the dealer. It does not need to have much or any interaction. The aim is to display the results of the Java logic already written. For example, if you had two players being dealt two cards each your screen might look something like:

```
  Player 1: Ace of Hearts, 9 of Diamonds
  Player 2: 3 of Clubs, 2 of Hearts

  Player 1 Wins!
```

## Fantasy Zoo Manager

Goal: Practice OO modelling  in Java (unit tests, no UI)

You have been asked to create a zoo management app so that we can manage our dragons, unicorns and other mystical beings. 

### MVP

The user must be able to add enclosures, add / remove animals, feed animals and anything else you can dream up!

### Project Extensions
 
* Animals cannot be placed in the same enclosure if they would eat one and other. 
* Animal babies can be sold(!) to other zoos :/
* Visitors can enter / exit the zoo if there are tickets left. 
* View the total income for the zoo.
* Animals can randomly go on a rampage and break out of their enclosures

## Food Tracker

Goal: Practice OO and UI design with what we learned in Java / Android weeks 

### MVP
You are required to write an Android app that allows a user to track the food they eat. Users should be able to enter what they eat and when (date/time) and for what meal. 

### Project Extension
The app should show the user a record of what they have eaten over a given period e.g. In March I drank lots of Irn-Bru.


## Shop

Goal: Practice OO modelling in Java (unit tests, no UI)

You are required to build an app that allows a Shop to sell goods to a Customer. Stock and items are not important. 

### MVP
The Shop must be able to:

* Make a Sale
  - The customer funds go down, shop sales go up
* Give a refund
  - The customer funds go up, shop refunds go up
* Report on income
  - Total sales minus total refunds

The Customer must:

* Have a collection of possible Payment Methods:
  - CreditCard (default), DebitCard
* Be able to select a Payment Method to pay at any Shop
* Be able to select a Payment Method to recieve a refund onto a given Payment Method

(You may find HashMaps useful for this project) 

### Project Extensions

* Add stock tracking


## General Rules (Applies to ALL projects)

* ***DO NOT USE ANY FRAMEWORKS*** - this includes Java Swing and similar packages. If in any doubt ask an instructor.
* There will still be stand-up at 9am every morning (10am on Friday) - you are still expected to be in every day during the project.
* If you have an idea for a project outwith the specs defined above then please discuss this with the instructors before going ahead.