# WowMarket

This project is an updated version of my other repo DFOPriceWatcher. The purpose of this project is to refamiliarize myself with Java 11 and JavaFX 11, and connect to a Postgresql database. This application will visualize the historical price data gathered from the wowDB python script from my other repository.

# Database Schema:

Each realm will have its own table to store historical prices of all items.

Item Info:
    - interval TIMEZONE
    - item_id INTEGER
    - quantity INTEGER
    - avg_unit_price BIGINT
    - high_price BIGINT
    - low_price BIGINT