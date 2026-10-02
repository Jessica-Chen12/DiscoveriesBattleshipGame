# Architecture
<img width="2200" height="3496" alt="battleship" src="https://github.com/user-attachments/assets/e9f31e77-db54-41b6-a89d-e85bae30f85e" />

---

# Description

This document describes the architecture of the Battleship project based on the UML class diagram.

## Overview

The project uses an object-oriented design that separates the main responsibilities of the game into several classes and interfaces.

The main components are:

* Game — manages the overall game state and statistics.
* Fleet — manages the collection of ships.
* Ship — provides the common representation of a ship.
* Barge, Caravel, Carrack, Frigate, Galleon — concrete ship types extending Ship.
* Position — represents a cell on the game board.
* Compass — defines the possible ship orientations.
* Tasks — stores project-wide constants and configuration values.
* IGame, IFleet, IShip, IPosition — interfaces providing abstractions for the main domain objects.

## Core Architecture

The main relationship between the classes is:

Game → Fleet → Ship → Position

A Game contains a Fleet, the Fleet contains multiple ships, and each ship occupies one or more positions on the board.

The game also maintains a collection of positions representing previously made shots.

## Game

Game is the central class responsible for maintaining the state of a Battleship match.
It implements IGame and contains:

* countRepeatedShots — number of repeated shots.
* countHits — number of successful hits.
* countSinks — number of sunk ships.
* countInvalidShots — number of invalid shots.
* shots — list of positions that have been targeted.
* fleet — the fleet currently being used by the game.

The Game class therefore acts as the main coordinator between the fleet and the board.

## Fleet

Fleet represents the collection of ships belonging to a game.

It implements IFleet and contains:

* ships : List<IShip> — the ships belonging to the fleet.

Using IShip allows the fleet to contain different concrete ship types while treating them through a common interface.

## Ships

Ship is the base implementation for the different ship types and implements IShip.

It contains information such as:

* positions — positions occupied by the ship.
* bearing — the ship's orientation.
* category — the ship category.
* pos — a position associated with the ship.
* Constants identifying the available ship types.

The concrete ship classes are:

* Barge
* Caravel
* Carrack
* Frigate
* Galleon

These classes inherit from Ship and provide their own SIZE and NAME values.

This inheritance structure allows common ship functionality to be maintained in one place while still supporting different types of ships.

## Position

Position represents an individual cell on the Battleship board.

It implements IPosition and contains:

* row — row coordinate.
* column — column coordinate.
* isHit — whether the position has been hit.
* isOccupied — whether the position contains part of a ship.

Positions are used both by ships, to represent where they are located, and by the game, to keep track of shots.

## Compass

Compass is an enumeration used to represent ship orientation.

It contains:

* NORTH
* EAST
* WEST
* SOUTH
* UNKNOWN

A Ship has a bearing of type Compass, allowing its direction on the board to be represented explicitly.

## Interfaces

The project defines interfaces for its main domain concepts:

* IGame — abstraction for the game.
* IFleet — abstraction for a fleet.
* IShip — abstraction for ships.
* IPosition — abstraction for board positions.

The concrete classes implement these interfaces, allowing the system to depend on abstractions rather than specific implementations.

## Design Principles

The architecture makes use of several object-oriented principles:

### Encapsulation

Each class is responsible for its own state. For example, Position manages whether a board cell is occupied or hit, while Game manages game-wide statistics.

### Abstraction

Interfaces such as IGame, IFleet, IShip, and IPosition define contracts for the main components without exposing their concrete implementations.

### Inheritance

The different ship types inherit from Ship, allowing common functionality to be shared between them.

### Polymorphism

The use of IShip allows Fleet to manage different ship types through the same interface.

### Composition

The main game objects are built from other objects: a Game has a Fleet, a Fleet has Ships, and Ships have Positions.

## Summary

The architecture models the Battleship domain through a hierarchy of related objects:

Game manages the game state, Fleet manages the ships, Ship and its subclasses represent the available vessels, and Position represents the board cells occupied by ships or targeted by shots.

The use of interfaces, inheritance, composition, and encapsulation keeps the responsibilities separated and provides a structure that can be extended without significantly changing the existing game model.