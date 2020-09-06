#WowMarket

This project is an updated version of my other repo DFOPriceWatcher. The purpose of this project is to refamiliarize myself with Java 11 and JavaFX 11, and use the Python World of Warcraft API to update a PostgreSQL server database. A client application will be used to visualize market analytics of auction house listings within each realm of WoW.

#Database Schema:

One table will store the item name associated with the item ID so that I don't have to query it.

Item Info:
    - Item ID (INT) (Primary Key)
    - Item Name (CHAR)

Each realm will have its own table to store historical prices of all items.

Price History:
    - Item ID (INT) (Primary Key)
    - Date/Time (DATETTIME)
    - Price (INT)