## About
This repository contains all the reference implementations of the different locks and principles needed for the PProg exam.

## How to use
Compile using:
```sh
javac *.java
```
Then you can run the concepts with their respective concept name:
```sh
java <ConceptName>
```

To see the outcome of the DataRace concept the commands would be the following:
```sh
javac *.java
java DataRace
```
## Concepts

### Basics

#### - ThreadCreation:
Using two different methods to create threads, extending Thread and implementing Runnable.

#### - MeasureTime:
Learning how to measure the time of executing threads using System.nanoTime().

#### - RandomOrder:
Demonstrating the random order of parallel thread execution.

#### - DataRace:
Showing the non-deterministic outcome when modifying the same data in parallel without any locks.

#### - Synchronized:
Ensuring the correct execution of the DataRace program by using the synchronized keyword.

### Locks

#### - Dekker's Lock:
Using this lock algorithm to ensure correct outcome of parallel modification of data. This algorithm only works when using the volatile keyword to prevent instruction reordering.

#### - Peterson Lock:
Using this lock algorithm to ensure correct outcome of parallel modification of data. This algorithm only works when using AtomicIntegerArrays.
