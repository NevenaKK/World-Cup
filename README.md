# World Cup Results Tracker Web Application

This project is a web application developed using Spring Boot, React, and Bootstrap for tracking results of the World Cup matches.

## Introduction

The World Cup Results Tracker application allows users to manage and track results of matches between different national teams participating in the World Cup.

## Entity Structure

The application works with the following entities:

- **Team**:
  - Id - identifier
  - Name - textual value, mandatory, unique
  - Short Name - textual value, mandatory, unique, three-letter abbreviation
  - Players - list of players playing for this team

- **Match**:
  - Id - identifier
  - Team A - reference to the first team
  - Team B - reference to the second team
  - Goals Team A - integer value
  - Goals Team B - integer value

- **Player**:
  - Id - identifier
  - First Name - textual value, mandatory
  - Last Name - textual value, mandatory
  - Goals Scored - integer value

Each match involves two teams, and no match can be between the same team (e.g., SRB vs SRB). Each team can participate in one or more matches, while in each match, a team can only be represented by one instance.

## REST API

The application provides the following REST API endpoints:

- GET /api/players - retrieve all players
- GET /api/teams - retrieve all teams
- GET /api/matches - retrieve all matches (paginated)
- GET /api/matches/{id} - retrieve a match by ID
- POST /api/matches - add a new match
- PUT /api/matches/{id} - update an existing match
- DELETE /api/matches/{id} – delete an existing match

Access to these endpoints is restricted based on user roles:

- user: has access to retrieve, add, and update matches
- admin: has access to delete matches

- **Admin Credentials:**
    - Username: miroslav
    - Password: miroslav

- **User Credentials:**
    - Username: petar
    - Password: petar

## Validation

The following validations are implemented at the API level:

- Name cannot be an empty string
- Short Name must contain exactly 3 characters

## Functionality

### Adding a New Match

Users can navigate to a separate page to add a new match. They select two teams participating in the match, and the number of goals for each team is initially set to 0. After filling in the required fields and clicking the 'Create Match' button, the match is added to the application via the API.

### Deleting Matches

Admin users have the functionality to delete matches. By clicking the 'Delete' button in the table displaying all matches, the selected match is removed from the application and the table.

### Pagination

Pagination functionality is implemented for displaying match data. 'Previous' and 'Next' buttons above the table of matches allow users to navigate between pages. If the user is on the first page, the 'Previous' button is disabled, and if they are on the last page, the 'Next' button is disabled.

### Filtering Matches

Users can filter matches based on Team A and/or Team B using a filtering form. Matches that satisfy the selected criteria are displayed. If the user leaves a field blank, its value is ignored in the search.

### Updating Match Results

Users can update match results by increasing the number of goals scored by each team. After clicking the 'A + 1' or 'B + 1' button, the user is redirected to a page where they can select a player who scored the goal. The number of goals scored by the selected player is then updated in the database.

### Displaying Top Scorer

By clicking the 'Top Scorer' button below the table displaying all matches, users are shown which player has scored the most goals and how many goals they have scored. If multiple players share the top scorer position, any one of them is displayed.

## Authentication and Authorization

The application is secured with both backend and frontend authentication. Only authenticated users can access the application. Users log in to the system via a login page. HTTPS configuration is not required. Endpoint access is restricted based on user roles as defined in the API.

For more details on how to run and use the application, please refer to the project documentation.
