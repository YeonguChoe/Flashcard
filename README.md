# Flash Card

## App to check how much you know

The Flash Card application will get a number of questions along with answers. Then it will display the questions to the
user.

### Expected *Users* are people...

- who **preparing** for exam
- who wants to **improve** their memory
- who likes to **play** quiz game
- who wants to **test** other people

### Reason that I decided to make this app is...

I like to play board games. However, it is hard to make a real game. Therefore, I decided to make simple quiz game. This
app can be used to *test their knowledge* to prepare for exams. It is said that flash card is an effective way to
improve the memory.

## User Story

- As a user, I want to be able to solve questions.
- As a user, I want to be able to add a question to the GUI question list.
- As a user, I want to add another answer for a question, but user cannot see the answers.
- As a user, I want to be able to delete a question from GUI question list using question code.
- As a user, I want to be able to see the question list in the GUI table.
- As a user, I want to be able to save the questions that I created on the GUI question list.
- As a user, I want to be able to load the questions that I saved previously.
- As a user, I want to be able to check if the answer is correct or incorrect.

## Phase 4: Task 2

- Map interface: In QuestionList class, there is a field called questions. This field stores the Question objects in
  HashMap. It uses the unique code of the Question object as key and Question object itself as value.

## Phase 4: Task 3

If I had more time, I want to make multiple interfaces that has functionality and initialization of each buttons
increasing cohesion. Also, I want to make checked exception manually and use it to prevent some errors.