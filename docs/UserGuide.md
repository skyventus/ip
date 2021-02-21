# User Guide
Welcome to Olivier's TIC4001 Duke's Taskmanager individual project.
For this simple project, you will be able to save the task that you want to be reminded of 
and refer to them anytime. (as long you have access to the jar)

## Getting started

At the directory of the Duke.jar, open cmd and run 

```bash
Java -jar Duke.jar
```

## Features 

##### Storage -> Data/Duke.txt
This is the directory where you list of task is saved. You can edit the textfile
if you like. 

##### Create / Delete Tasks
You can create the task in the form of (Todo/Deadline/Event). 

###### Todo
Contains the description of your tasks and the status of the task.

###### Deadline
Contains everything that Todo has with a deadline to the tasks.

###### Event
Contains everything that todo has with a time period to the tasks. 

###### Sort

Return a list of sorted tasks with the deadline being sorted. 

###### Delete

Delete a specific task.

###### Find

Find a task relating to the keyword.

###### List

List out all the tasks that the user has entered to the system.

###### Save

Save all the tasks to a text file. 

## Available Keywords

### `Todo` - Create todo task into the systems.

Insert your tasks into the systems. 

Example of usage: 

`todo Submit TIC4001 IP`

Expected outcome:

`Got it. I've added this task:`  
`[T][✘] Submit TIC4001 IP`  
`Now you have 4 tasks in the list`  

### `Deadline` - Create todo task with a deadline into the systems.

Insert your tasks with deadline into the systems. 

Example of usage: 

`deadline Submit TIC4001 IP /by 25-09-2020`

Expected outcome:

`Got it. I've added this task:`  
`[D][✘] submit tic4001 ip (by: 25-09-2020)`  
`Now you have 4 tasks in the list`  

### `event` - Create todo task with a timing into the systems.

Insert your tasks with deadline into the systems. 

Example of usage: 

`event Submit TIC4001 IP /at 12pm`

Expected outcome:

`Got it. I've added this task:`  
`[E][✘] submit tic4001 ip (at: 12pm)`  
`Now you have 4 tasks in the list`  

### `List` - Listing all the tasks that you have input to the system.

Retrieve all the tasks that you have saved so far. 

Example of usage: 

`list`

Expected outcome:

`1.[T][✘] submit tic4001 ip`  
`2.[D][✓] submit tic4001 ip (by: 25-09-2020)`  
`3.[E][✘] submit tic4001 ip (at: 12pm)`

### `find ` - Finding tasks that contains the keyword that you input.

finding the tasks using the keywords that you have input into the systems

Example of usage: 

`find tic4001`

Expected outcome:

`1.[T][✘] submit tic4001 ip`  
`2.[D][✓] submit tic4001 ip (by: 25-09-2020)`  
`3.[E][✘] submit tic4001 ip (at: 12pm)`

### `delete ` - Delete task.

Retrieve all the tasks that you have saved so far. 

Example of usage: 

`delete 1`

Expected outcome:

`Noted. I've removed this task: `  
`[T][✘] submit tic4001 ip`  
`Now you have 2 tasks in the list`

### `done` - Set a task to completed.

Once you have completed a task, you can set it to done. 

Example of usage: 

`done 1`

Expected outcome:

`Nice! I've marked this task as done: `  
`[D][✓] submit tic4001 ip (by: 25-09-2020)`  

### `save` - save tasks (auto)

Upon closing the application or you key in save as the command.

Example of usage: 

`save`

Expected outcome:

`Your file has been saved to data/Duke.txt directory`  

### `find` - finding tasks 

You will be able to find the tasks that match your keywords. 

Example of usage: 

`find tic4002`

Expected outcome:

`1.[T][✘] submit tic4002 ip (by: 21-02-2021)`    
`2.[E][✘] submit tic4002 tp (at: 12pm)`