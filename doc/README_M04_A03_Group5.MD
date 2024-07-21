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

MAIN Class for execution: `IST412_Group5` is MAIN. This class instantiates the model, controller, and view classes that are called to start the application via LoginView.

# Use Case 1 (from M03_A05):
The application launches to `LoginView` (now fixed size so the user cannot shrink or enlarge the window). 
The user/admin can log in with credentials listed below which will bring them to the `HomeView` screen.
The "Update Profile" button can be pressed to bring the user to a screen that will allow them to view/update their information. 
Pressing "Update" will enable editable fields that can be saved.
Updates will persist on subsequent application runs.

# Logins 
Admin:
User ID: admin
Password: admin

User:
User ID: user
Password: user

# Use Case 2 (M04_A03):
After logging in (Use Case 1), the user can click the "Schedule Activities" button.
This will update the interface and allow the user to select an activity, select a date, and select a time for their activity they would like to book.
Upon clicking "Book Activity" after selections are made, the information is then displayed in adjacent window.
The fields are selectable and able to be cancelled or updated via buttons below the data window.

