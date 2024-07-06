# Project Team #5

## Team Members

- Scott St Clair
- Bright Darko
- Frank Imbrunone
- Jed Galvo

# SW Configuration

- Netbeans Version: 22
- IntelliJ Version: 2023.2.7
- Project Type: Maven

## Class Descriptions and High-Level Overview

The use cases include a user interface with user profile management, user and admin login functionality,
user feedback submission and viewing, and admin access to statistical reports.

`HomeView` renders the main application window after login, displaying action buttons and updating the main content
panel based on user actions.
`UserProfileManager` handles user profile operations, including authentication, registration, deletion, and data
persistence.
`LoginView` manages the login interface, authenticating users and directing them to `HomeView` upon success.
`StatisticsView` displays park statistics for the admin user. `FeedbackController` manages adding and retrieving
feedback through `StatisticsManager`.
`FeedbackView` provides the interface for users to submit feedback. `AdminView` allows admin users to manage user
accounts and view feedback.
`UserProfileController` handles user profile actions and updates the profile view.
`IST412_Group5` is the main entry point, initializing the necessary managers and controllers before
launching `LoginView`.

# Logins

Admin:
User ID: admin
Password: admin

User:
User ID: user
Password: user



