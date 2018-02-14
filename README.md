# AirAsia Booking

This app is made in **Kotlin**.

The idea is to have two tabs one for **Up Coming bookings** and one for **Completed bookings**. 
And ongoing flight booking will be shown on top of tabs and Below Toolbar. 
This will enable users to check their ongoing flights on home screen with all required details.


### Technical Architecture / Approach

This app uses MVVM along with Observer pattern. 
This is single activity app using Fragments.
There is are Two fragments:
1. BookingFragment: manages viewPager with UpComing and Completed page.
1. BookingListFragment: shows the list of upcoming or completed bookings.
 a flag is used to trigger upcoming/completed list.
1. BookingDetailsFragment: displays details of journey, passengers and flights.

#### Why is this a best solution

This solution lets user check their on going flight on the HomeScreen it self and still can check upComing / completed booking by just taping on tabs.
At max single click is required to check the information user needs.
A very simple and easy to use UI.



### To do
1. Notification to alert user for upcoming flights.

## Used Libraries
1. Android Architecture Components
1. RxJava2
1. GSON