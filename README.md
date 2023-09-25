# Heartbeat :heart:

## Introduction :bulb:

This is a simulation of heartbeat tactic. Designed and Created by team 3 for SWEN 755.

There is a receiver and a sender. The sender simulates a program that reads data from a file and operate some calculation. Because it cannot control the data source, there might be random crash. 

The receiver monitors that program in a certain frequency, and if it doesn't hear from the sender for a certain time, it will warn the manager.

## To run the program :boom:
Run **src/HeartbeatReceiver** first, then run **src/HeartbeatSender**. Wrong order wouldn't work.

Observe the console of the **Receiver** which shows the heartbeat process clearly. When the sender crushes, the receiver would report that and pop up a warning window.
