## FinalProject - BARBEQUUGLE
​
## Overview
​
This is the final project for the Skill Distillery Java Full-Stack Bootcamp.  This is a team collaboration utilizing all technologies taught throughout the 16-week course.  Using a MySQL database, a Spring back-end, and Angular on the front-end, this application allows users to locate and review BBQ restaurants throughout the United States.
​
## Project Team Members
​
* David Daniels - Software Development, Github Repository Management
* Chris Hiles - DataBase/MySQL Administrator, Software Development
* Jason Redmond - SCRUM Master, Software Development
​
## API Paths Utilized
 "*" Login Required
​
| Return Type        | Route                                                 | Functionality                                                                                           |
|------------------- |-------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `List<Restaurant>` | GET api/restaurants                                   | Shows list of restaurants                                                                               |
| `Restaurant`       | GET api/restaurants/{restaurantId}*                   | Shows single restaurant by ID                                                                           |
| `List<Restaurant>` | GET api/restaurants/search/{state}*                   | Shows list of restaurants by state abbreviation                                                         |
| `List<Restaurant>` | GET api/restaurants/search{state}/name/{name}*        | Shows list of restaurants by state abbreviation and name                                                |
| `List<Restaurant>` | GET api/restaurants/search{state}/meat/{meatType}*    | Shows list of restaurants by state abbreviation and meat type ('pork, beef, etc')                       |
| `List<Restaurant>` | GET api/restaurants/search{state}/sideDish/{sideDish}*| Shows list of restaurants by state abbreviation and side dishes (wildcards allowed)                     |  
| `List<Restaurant>` | GET api/restaurants/search{state}/style/{style}*      | Shows list of restaurants by state abbreviation and style (integer number for corresponding style in DB)|
| `List<Restaurant>` | GET api/restaurants/search{state}/mainDish/{mainDish}*| Shows list of restaurants by state abbreviation and main dish ('ribs', etc)                             |
| `Restaurant`       | POST api/restaurants*                                 | Add restaurant to database                                                                              |
| `Restaurant`       | PUT api/restaurants/{restaurantId}*                   | update restaurant in database                                                                           |
| `List<Review>`     | GET api/reviews/{restId}*                             | Shows reviews for a restaurant based on restaurant ID                                                   |
| `Review`           | POST api/reviews/{restId}/{userId}*                   | Adds review to a restaurant based on the restaurant ID and the ID of the user adding the review.        |
| `Review`           | PUT api/reviews/{restId}/{revId}*                     | Updates a review to a restaurant based on the restaurant ID and review ID.                              |
| `void`             | DELETE api/reviews/{restId}/{revId}*                  | Deletes specific review of specific restaurant                                                          |
​
​
## Instructions
​
Upon arrival to the web page you will be greeted with the search bar and the ability to login/sign-up.  Signing up or logging in is highly recommended, as the website is highly restricted for non-members.  
​
I. To Sign Up, click on the 'Sign Up!' button and put in the necessary information.  a username and password will be minimally required.  Click sign-in at the bottom, and you will immediately be assigned privileges to utilize the site!
​
II. If you have an existing account, you may just type the information in the username/password portion in the navbar and select 'Login'.  You will be logged in immediately and able to access all aspects of the site reserved for members.
​
III. To utilize the search bar, please select the state which you want to search (required), and then select the type of search you wish to perform:
* State - Show all restaurants by the state.  No additional search terms are necessary and the user may just click the search button.
* Style - In 'Search Term', select the number of the BBQ style you wish to search for in the requested state:
  * 1 - Texas
  * 2 - Kansas City
  * 3 - Memphis
  * 4 - Georgia
* Meat Type - In 'Search Term', input the basic meat type you are interested in (e.g., 'pork', 'chicken', 'beef').
* Main Dish - In 'Search Term', input a main dish you are interested in.
* Name - In 'Search Term', input part of a name of a restaurant you are looking for.
* Side Dish - In 'Search Term', input a side dish or element of a side dish you are interested in.
​
IV. If no restaurants meet the search terms given, no results will be given.  Otherwise, a list of restaurants will be presented meeting the basic criteria.  The restaurants will be listed in order of highest ranking to lowest ranking based on previous restaurant reviews.  If a user wants to see more information on the restaurant, they just need to click on the name.  
​
V. Clicking on the restaurant name will take user to a restaurant info page that will give them information about the restaurant's address, telephone number, website, operating hours, and whether dine-in is available.  To the right of this info a user will be given the opportunity to learn 'about' the restaurant, as well as any main dishes or side dishes the restaurant is known for.  Additional tabs to the right will also allow a user to read reviews, and (optionally) the restaurant's pitmaster (if one is on file).
​
VI. If a user clicks on the 'Reviews' tab, they will be given an opportunity to scroll through the restaurant's reviews, and see the restaurant's score based on user reviews.  A registered user will also be allowed to add their own review to contribute to the database.  Any review(s) added by the user will be specifically flagged with additional buttons to allow them to update their review or delete it outright.
​
VI. Since this site is based on community input, registered users will have the ability to add restaurants to expand the database.  To do so, a user merely need to click 'Add Restaurant' in the navbar, and enter the pertinent information.  Upon clicking the 'Add' button, the user's submission will be sent to the administrators for review.  If approved, the restaurant will be enabled and added for future listing and review.
​
VII. Although not publicly available, administrators currently have the ability to update restaurants as they deem necessary, as well as enable/disable restaurants and users in the database.
​
VIII. Have Fun!    
​
## Technologies Used
​
* Angular,
* JavaScript/JavaType,
* Visual Studio,
* Java,
* HTML/CSS
* Bootstrap
* Document Object Models(DOMs),
* Gradle,
* Spring Tool Suite,
* SpringBoot / Spring Data JPA,
* Spring REST / API,
* AWS / EC2,
* Tomcat,
* MYSQL,
* MYSQL Workbench,
* JSON,
* Postman,
* Linux,
* Git / GitHub
​
## Lessons Learned
​
1.  This final project taught the team the importance of continual communication, as this multi-faceted program required frequent modification of front-end and back-end components.  This utilization of continual communication and transparency allowed for minimal merge conflicts and better-defined developer roles.
2.  The team was given an opportunity to fully realize and experience the modern requirements of working remotely,  and utilize the necessary modern technologies to meet these challenges (i.e. Zoom, Slack, Trello, et. al).
3.  The team was able to experience the complex relationships found in real-world databases and the necessary steps taken to adequately manipulate the data within the ongoing constraints of parent and child relationships.  
