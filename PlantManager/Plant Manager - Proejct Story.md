# Plant Manager - Project Story

## Inspiration
The idea for the project came about as a result of one of our team member's growing interest in indoor plants as a result of the COVID19 lockdown, and the theraputic nature of the nuturing of the plants. 

As their interest grew, and more plants were added to their collection, the tracking of how to best care for all of these plants became more challenging, and often resulted in some plants being neglected of their needs. 

This, combined with the more *'blog style'* presentation of information lead to a desire to have 1 centralised location for both the tracking and looking for information, regarding the care required of their plants.

<br>

## What it does
The goal for the app is to enable users to add a range of Plants to their collection, with both global attributes (eg. information about the plant and how to care for it), as well as local attributes, such as the plant's age, etc.

With this collection, the user can browse their plant collection, as well as view a simple overview of what is required to care for the plant, using a GUI with icons indicating the plant's required amount of sunlight and water.

The app will then provide notifications and updates to when your plants will need care, based on the last time you provided care for them.

<br>

## How we built it

The app was built for Android using Java, as the majority of us were unfamiliar with Kotlin.

Our team of 4 was split into 2 groups, 1 for the front end, to manage all of the views and connections to the back end, and the other group for the back end.

For the front end team, a basic UI interface was drafted using OneNote drawings, and work was distributed and collaberated where required.

For the back end a basic domain model diagram was drafted and work was done collaberatively, as neither of the backend users had ever worked with android before, so it was a new learning experience for the two.

The app is based around a base `Plant` object, which has its plant breed information fetched from the enum `PlantBreed`. A small sample of plants where included for the prototype of the app.

The Users plants they create are stored locally on a Room Database, called `PlantDB`. Although it would be ideal to use an external database, we did not have access to the resources to enable it.

<br>

## Challenges we ran into
As this is collectively our first hackathon, the time pressure was felt immensely, and was difficult to judge a combination of priorities and how long should be spent on a task before abandoning it, as well as what could be abandoned.

The lack of experience that half the team had working with Android became difficult, especially regarding how the classes that we created would be interacted with on the front end, and what the front end requried.

No members were familiar with how to create and store a database locally on android. The creation and implementation of this into our system gave us quite a headache, and was core the app's functionality.



<br>

## Accomplishments that we're proud of
The project ultimately lead to the entirety of the team learning how Android works, as it was a mostly unfamiliar platform for any of us to work with.