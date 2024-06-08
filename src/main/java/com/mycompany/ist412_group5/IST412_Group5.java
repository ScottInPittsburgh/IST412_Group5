package com.mycompany.ist412_group5;

import com.mycompany.ist412_group5.controller.SchedulingController;
import com.mycompany.ist412_group5.controller.StatisticsController;
import com.mycompany.ist412_group5.controller.TicketController;
import com.mycompany.ist412_group5.controller.UserProfileController;
import com.mycompany.ist412_group5.view.SchedulingView;
import com.mycompany.ist412_group5.view.StatisticsView;
import com.mycompany.ist412_group5.view.TicketView;
import com.mycompany.ist412_group5.view.UserProfileView;

public class IST412_Group5 {
    public static void main(String[] args) {
        
        SchedulingController schedulingController = new SchedulingController();
        StatisticsController statisticsController = new StatisticsController();
        TicketController ticketController = new TicketController();
        UserProfileController userProfileController = new UserProfileController();

        SchedulingView schedulingView = new SchedulingView();
        StatisticsView statisticsView = new StatisticsView();
        TicketView ticketView = new TicketView();
        UserProfileView userProfileView = new UserProfileView();

        // scheduling - test data (move to test package eventually)
        int userId = 314;
        int activityId = 159;
        String bookingTime = "07:34 AM";

        // scheduling - test booking (move to test package eventually)
        boolean bookingSuccess = schedulingController.bookActivity(userId, activityId, bookingTime);
        if (bookingSuccess) {
            schedulingView.displayMessage("Booked! ");
        } else {
            schedulingView.displayMessage("Failed :(");
        }

        // scheduling - test schedule view (move to test package eventually)
        schedulingController.viewScheduledActivities(userId);
        
        // scheduling - test reschedule (move to test package eventually)
        int bookingId = 567;
        String newTime = "12:34 PM";
        boolean updateSuccess = schedulingController.updateBooking(userId, bookingId, newTime);
        if (updateSuccess) {
            schedulingView.displayMessage("Success! ");
        } else {
            schedulingView.displayMessage("Failure! ");
        }

        // scheduling - test cancellation (move to test package eventually)
        boolean cancelSuccess = schedulingController.cancelBooking(userId, bookingId);
        if (cancelSuccess) {
            schedulingView.displayMessage("Booking canceled successfully.");
        } else {
            schedulingView.displayMessage("Failed to cancel booking.");
        }

        
       schedulingController.exampleSchedulingMethod();
       schedulingView.showActivities();

       statisticsController.exampleStatisticsMethod();
       statisticsView.showStatistics();

        ticketController.exampleTicketMethod();
        ticketView.showTickets();

        userProfileController.exampleUserProfileMethod();
        userProfileView.showUserProfile();
    }
}
