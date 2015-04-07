# Barista-App
A simulator of an automatic coffee dispensing machine, called the Baristamatic.

Inventory Singleton:
 A shop can create only one instance of th inventory. Contains functions to initialize inventory items. Inventory items attributes are provided in a separate class InventoryItem. 

Menu Singleton:
 A shop can create only one instance of th menu. Contains functions to initialize menu items. Attributes of menu items are provided in a class MenuItem. Each MenuItem will have distinct recipe which is given in a separate class DrinkList.
It has major functionaities like displaying menu and inventory, get cost for each drink, checking drink availability, dispensing drink and refilling stock.

BaristamaticApp:
 The class which has the main function. It creates the single instance of menu and runs the application.
  
BaristaTest:
 It contains JUnit test cases for major functionalities of the application.
  
 
