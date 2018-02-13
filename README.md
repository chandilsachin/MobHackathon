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

#### Why is this a best solution

This solution lets user check their on going flight on the HomeScreen it self and still can check upComing / completed booking by just taping on tabs.
At max single click is required to check the information user needs.
A very simple and easy to use UI.



### Things i could not completed because of time constraints
1. I wanted to add one more fragment to show all details of a particular booking on taping an item on list with
all break down in segments (for more than one stops).
1. I wanted to add a notification to alert user for upcoming flights.
1. I wanted to add local database where all bookings can be saved, so that later retrieval could be faster.
1. A simple message if upcoming or completed flights are not available.


## Used Libraries
1. Android Architecture Components
1. RxJava2
1. GSON










# MobHackathon

**First FORK the repository**

**Fill & submit Google Form and along with forked git URL **

https://docs.google.com/forms/d/e/1FAIpQLSfC7zUyO8IfbMbFxeU8x6869o6SU68cC2gjjGz3oxq7ciVjYA/viewform

You challenge in the hack folder!! Please read README in hack for instructions!! 

All the very best!!!

**Please ensure to commit code in frequent intervals**

**Only the last commit before or at the end of 4.5 hours will be considered for evalaution** 

# You have 4.5 hours to finish ? Are you Ready ? 
