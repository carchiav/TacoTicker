# Taco Ticker!!!!!
The point of the game is to accumulate as many tacos as possible via exponential growth. Ticking the big taco image on the canvas once gives 1 taco. The player can spend the tacos they have earned to buy producers and upgrades that increase the automatic TPS (Tacos per Second). Producers are sources of additional tacos, while upgrades scale up the TPS of existing producers. Upgrades can only be bought once. Producers can be bought multiple times, but each time the cost scales up by 20%. 

A saving function will be implemented which writes the data to a text file and pulls it into the player variables when the game starts. A count of total tacos, along with current Tacos Per Second will be shown. There will be menus flanking the taco to allow the purchase of upgrades and producers.

Dhilan will work on graphics (Jframe) and updating the display with the most recent game data. Jonah will work on most of the various game objects and relevant methods, including upgrades/producers, etc. and how they deduct from your taco balance and increase TPS. Carson will work on the driver and player classes that bring together all of the game objects and call their methods accordingly to make the game work (including saving).

![taco-cartoon-vector-25493208](https://user-images.githubusercontent.com/57341597/168159836-99a55c94-536e-4786-b14a-41fb90b1d353.jpg)
![image](https://user-images.githubusercontent.com/57341597/168159994-4c5ccfc3-8e17-4dab-b56d-22d610aaa2da.png)

# Code Outline

TacoTickerDriver class:

Public static void main()
Public void startGame()

Player class:

int tacoCount
int tacosPerTick
int TPS //tacos per second

Int[7] producers //Index 0 = # of StreetStands, Index 1 = # of TacoShops… for saving to file
arrayList<Producer> //Arraylist to insert the producers into
int[9]  upgrades //1 or 0 for each upgrade

public player() //constructor called when a player instance is created at game startup. Initializes producers and upgrades arrays to be all 0, then calls loadGame. Then initializes the correct number and type of producers based on the updated arrays.

public int calcTPS(Player p)
/*
This is where most of the code logic goes. Each second, the player main method will run this method (which sums up TPS of producers and scales by upgrades) and add the returned value to the total taco count
*/

public void changeTPS(int i) //increases TPS by i, may or may not actually need this depending on how calcTPS ends up working
public void removeTacos(int i) //used for buying producers
public void addTacos(int i)
//getters for the class variables

public saveGame() (write to .txt)
public loadGame() //Populates producer and boolean arrays if there is a save. 

Graphics class (Extends JFrame):

These will be two very large methods:
public void drawDisplay() //draws the canvas with graphics and buttons. Call on startup.
public void updateDisplay() //gets data from player class and updates the displayed values

Producer class:

int TPS;
int cost;

public void upgradeTPS() //may or may not need depending on how calcTPS() accounts for upgrades
public void buy() //scales cost
//getters for class variables

StreetStand IS A Producer
Produces one taco every ten seconds
Costs 12 tacos
TacoShop IS A Producer
Produces one taco per second
Costs 100 tacos
Restaurant IS A Producer
Produces 5 tacos per second
Costs 1000 tacos
Factory IS A Producer
Produces 50 tacos per second
Costs 15,000 tacos
Conglomerate IS A Producer
Produces 250 tacos per second
Costs 100,000 tacos
TacoTown IS A Producer
Produces 1500 tacos per second
Costs 1,000,000 tacos
PlanetTaco IS A Producer
Produces 10,000 tacos per second
Costs 10,000,000 tacos

Upgrade class:

int cost;

public void buy()
//getters for class variables

Megaphone IS A Upgrade
Doubles TPS of StreetStand
Costs 200 tacos
TortillaPress IS A Upgrade
Doubles TPS of TacoShop
Costs 1000
HotSauce IS A Upgrade
Doubles TPS of Restaurant
Costs 10,000
AssemblyLine IS A Upgrade
Doubles TPS of Factory
Costs 75,000
BoardRoom IS A Upgrade
Doubles TPS of Conglomerate
Costs 500,000
Constitution IS A Upgrade
Doubles TPS of TacoTown
Costs 10,000,000
LettuceLand IS A Upgrade
Doubles TPS of PlanetTaco
Costs 200,000,000
Bell IS A Upgrade
Doubles all Taco production
Costs 10,000 + 600 x current TPS
TacoMakingGloves IS A Upgrade
Scales tacosPerTick to a percentage of TPS
Costs 1,000 + 300 x current TPS

Depending on how the canvas software works, may need extra classes for buttons/on-screen displays
