# Developer Guide
* [Setting Up and Getting Started](#Setting-Up-and-Getting-Started)
* [Design](#Design)
  * [Architecture](#Architecture)
  * [UI component](#Component)
  * [Storage component](#Storage-Component)
  * [Common classes](#Component)
* [Implementation](#Implementation)
* [Appendix: Requirements](#Appendix:-Requirements)
  * [Product scope](#Product-scope)
  * [User stories](#User-Stories)
  * [User Cases](#Use-Cases)
  * [Non-Functional Requirements](#Non-Functional-Requirements)
  * [Glossary](#Glossary)


## Setting Up and Getting Started
**Caution** Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.

First, **fork** this repo, and **clone** the fork into your computer.
If you plan to use Intellij IDEA (highly recommended):

1. **Configure the JDK:**
  * Ensure you have the correct JDK version installed in your computer.
  * Open IntelliJ (if you are not in the welcome screen, click File → Close Project to close the existing project dialog first).
  * Set up the correct JDK version for Gradle.
   * Click Configure → Project Defaults → Project Structure
   * Click New…​ and set it to the directory of the JDK.
2. **Import the project as a Gradle project:**
  * IntelliJ IDEA by default has the Gradle plugin installed. If you have disabled it, go to File → Settings → Plugins to re-enable them.
  * If your project involves GUI programming, similarly ensure the JavaFX plugin has not been disabled.
  * Click Import Project (or Open or Import in newer version of Intellij).
  * Locate the `build.gradle` file (not the root folder as you would do in a normal importing) and select it. Click OK.
  * If asked, choose to Open as Project (not Open as File).
  * Click OK to accept the default settings but do ensure that the selected version of Gradle JVM matches the JDK being used for the project.
  * Wait for the importing process to finish (could take a few minutes).
  * :heavy_exclamation_mark: **Note**: Importing a Gradle project is slightly different from importing a normal Java project.
3. **Verify the setup:**
  * Run the `main.java` and the Ui will be loaded.
  
## Design

##### Architecture
![Sample - Architecture](images/Architecture.png)

The ***Architecture Diagram*** shown gives an overview of the high-level design.

`Main` has one class named `NusExpenses`. It would perform the following functions:

- At launch: Initialize the components in the correct sequence, and connect them up with each other.
- At shut down / Exit: Shuts down the components and invokes save / cleanup methods where necessary.

`Constants` holds a collection of frequently used static messages used by multiple other components.

The application then consists of four other components:

- `UI`: The user interface for the Duke Tracker.
- `Duke`: The class that contains the logic. 
- `Model`: Hold the data of NET in memory.
- `Storage`: Read data from, and writes data to the hard disk.

One example would be the `Storage` component which defines its API in `Storage.java` as well as exposes its functionality using the same class.

##### Component
[TBC]

##### Storage Component
###### Storage(Load)
![StorageComponent](images/storageDecodedDiagram.png)

###### Storage(save)
![StorageComponent](images/storageEncodedDiagram.png)

API:  ```Storage.java```

The Storage Component,
* Load function will read the text file and passing the list of string in the file
to the decoding class. 

* Saving function will Encode the transaction detail and pass it back to storage
to save to the file. 

The *Sequence Diagram* below shows how the components interact with each other in the scenario where the user issues the command ```search keyword```

###### Search Command Sequence Diagram
![SearchCommand Sequence Diagram](images/SearchSequenceDiagram.png)

The following *Object Diagram* gives an overview of which objects are accessed and associated with the execution of the `Search` command.

###### Search Command Object Diagram
![SearchCommand Object Diagram](images/SearchCommandObjectDiagram.png)

The following *Sequence Diagram* shows how the components interact in the scenario where the user issues the `total` command.

## Appendix: Requirements
### Product scope
##### Target user profile

* Has a need to manage his/her tasks
* Is able to use the GUI and key in the commands
* Can type fast
* Prefers interaction with a graphical user interface (GUI)
* Is comfortable using command keywords to execute certain tasks. 

##### Value proposition: 
To be able to keep track of my tasks and having a GUI to display all those necessary information. 

### User Stories
###### *Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`*

|Priority|Version| As a ... | I want to ... | So that I can ...|
|--------|--------|----------|---------------|------------------|
|`* * *`|v1.0|Student|Add the tasks that I need to do in the systems |keep track of what I need to do|
|`* * *`|v1.0|Student|Add a tasks with deadline | I can keep track of the deadline |
|`* * *`|v1.0|Student|Add a tasks with event timing | I can keep track of the timing for that tasks |
|`* * *`|v1.0|Student|view all my tasks in the system|be aware of what I have added|
|`* * *`|v1.0|Student|remove my tasks in the system|remove the unwanted tasks|
|`* * *`|v1.0|Student|search for an tasks with keyword in the system|filter out the tasks that I want to see|
|`* * *`|v2.0|Student|Save all transactions to a readable text file and load from it|I can have a copy of transaction history.|
|`* * `|v2.0|Student|sort the tasks by deadline in the systems|know which tasks needs my attention first|

### Use Cases

###### Use Case Diagram
[TBC]

### Non Functional Requirements

1. Should work on any mainstream OS as long it has Java ```11``` or above installed.
2. User will be able to interact with the systems with regular english text.
3. Will be able to handle up to 1000 expenses without noticeable slowness in performance for typical usage.
4. User will be able to interact with their expenses.txt if they wish to make amendment. 
5. User will be able to interact with the GUI to key in the commands.

### Glossary

- *MainStream OS* - Windows, Linux, Unix, OS-X
- NET - NUS Expenses Tracker
- Regex - Regular Expressions
- JDK - Java Development Kit - [Java SE](https://www.oracle.com/sg/java/technologies/javase-downloads.html "Java SE Downloads")
- Gradle - Gradle Build Tool - [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html "Build Automation Tool - Docs")
- Intellij / IDE - Intellij Integrated Development Environment - [IntelliJ IDEA](https://www.jetbrains.com/idea/ "JVM IDE") 
- Plugin - IDE Plugins - [Intellij IDEA Plugins](https://www.jetbrains.com/help/idea/managing-plugins.html "Manage plugins")