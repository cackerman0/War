# War Card Game

A Java implementation of the classic card game **War** using object-oriented programming principles.

## Description

This project simulates the card game War between two players. The program creates a standard deck of cards, shuffles it, deals cards to each player, compares cards each round, handles ties through war logic, and determines a winner when one player runs out of cards.

## Features

- Standard 52-card deck
- Deck shuffling
- Card dealing between two players
- Round-by-round card comparison
- War handling when cards have the same value
- Player hand management
- Winner detection

## Classes

- `Card` - Represents a single playing card with a rank, suit, and value
- `Deck` - Creates, stores, shuffles, and deals cards
- `Player` - Stores each player's cards and handles adding or removing cards
- `Game` - Controls the main game logic and round-by-round flow
- `Main` - Starts the program
