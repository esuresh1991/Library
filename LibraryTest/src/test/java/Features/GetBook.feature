@FunctionalTest
Feature: Library Management

@Get_Book
Scenario: Get Book Details by id
Given Create Book entry with Data from Excel
Then Get the book details using Book ids