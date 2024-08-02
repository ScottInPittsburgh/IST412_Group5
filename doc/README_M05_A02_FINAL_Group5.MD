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

# Use Case 3 (M05_A02):
The ticketing use case allows the user to purchase tickets to the park. After clicking the "Purchase Tickets" button, the user is presented with a screen that will allow 
them to enter the quantity of tickets, select the payment method (card type), and select the visit date. The price, tax, and total are all calculated and displayed
dynamically based on the quantity of tickets entered. The ticket functionality was also integrated within User Profile where the user can navigate back to see their purchase history
as well as cancel tickets that were purchased.


# Use Case 4 (M05_A02):
The statistics and add/view feedback use case is split based on which user type is logged in. If you log in as a regular user (user/user), you will be able to add feedback via the "Add Feedback" button. 
If you log in as an admin (admin/admin), you will have the ability to view statistics, view users, and view feedback. This login also allows the admin to delete and add their own 
feedback as needed.
