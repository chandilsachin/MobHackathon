# AirAsia Booking

The idea is to have two tabs one for **Up Coming bookings** and one for **Completed bookings**. 
And ongoing flight booking will be shown on top on tabs and Below Toolbar.


### Technical Architecture / Approach

This app uses MVVM along with Observer pattern. 
This is single activity app using Fragments.
There is are Two fragments:
1. BookingFragment: manages viewPager with UpComing and Completed page.
1. BookingListFragment: shows the list of upcoming or completed bookings.
 a flag is used to trigger upcoming/completed list.

#### Why is this a best solution

This solution lets user check their on going flight on the HomeScreen it self and still can check upComing / completed booking by just taping on tabs.
At max single click is required to check the information user needs.
A very simple and easy to use with simple UI.







### This that i could not completed because of time constraints
1. I wanted to add one more fragment to show all details of a particular booking on taping an item on list with
all break down in segments (for more than one stops).
1. I wanted to add a notification to alert user for upcoming flights.
1. I wanted to add local database where all bookings can be saved, so that later retrieval could be faster.
