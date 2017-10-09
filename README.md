# X-factor-training
X-factor game
## Part 1 ##
1. Create an X-factor application
-	Application may need the following objects:
	-	Participant(s), who can be a Person. Each Participant can have
		-	Quality(s) like singing, dancing, playing an instrument<br/>
***Note!* The Participant can have NO qualities**


		- Others
	- Stage(s) – кръгове. Each Stage will need
		- Max number of participants
		- Participants who took place in the stage
		- Participants who qualified<br/>***Note!* A validation will be required so the participants will not exceed the allowed number<br/>*Exception *case will be, when the Judge adds someone with a preference (see next point)**<br/>
	- Judge(s) who are also (Person(s)). The Judge can have:
		- Maximum number of Favorites
		- Favorites – Participant, who will continue the Stage no matter what (even if there is no place for him in the Stage)

***Note! How you can engage the Judge favorites to the Stage’s participants
Favorites may change during the show***

***Estimation** - 4 days*
## Part 2 ##
1.	Create a DB where you will save your data about the show *(MySql  or Cassandra)*
2.	Create classes that can add each of the objects *(use DAOs – you may use an entity framework)*
3.	Create **remove** functionality in the DAOs
4.	Create **update** functionality in the DAOs

*DB client - DBeaver*<br/>
*what is Entity framework*<br/><br/>
***Estimation:***

- 2 days 
- 2days set up
- 1 day connect classes to db
- 1 week add logic
## Part 3 ##
1.	Add Spring to the project and use MVC model for your project
2.	Create Controller classes which will be called using REST services
	-	Add/Update/Delete object (One type of object per class)
	-	Select object (you may need to modify the DAOs)
3.	Create Service classes with which the Controllers will communicate to make modifications on the database


***Estimation:***

- 2 days reading
- 1 day Make project Maven Project
- 2 days set up and modify project structure to match MVC
- 1 week make functionalities 
## Part 4 ##
WEB UI for X-factor

***Estimation:***
1 week
