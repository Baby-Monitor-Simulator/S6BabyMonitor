# Baby Monitor Simulator Project
This is a group project for Fontys and the Eindhoven University of Technology.

## Links
- Scrum Board: https://github.com/orgs/Baby-Monitor-Simulator/projects/1 [**includes** shared tasks]
- Frontend Links:
  - Scrum Board Frontend: https://github.com/orgs/Baby-Monitor-Simulator/projects/3 [does **NOT** include shared tasks]
  - Repository Frontend: https://github.com/Baby-Monitor-Simulator/s6-baby-monitor-simulator-webui
- Contributing Rules: https://github.com/Baby-Monitor-Simulator/S6BabyMonitor/wiki/Contributing-Rules

## Dependencies
### Adding Matlab Engine to Project:
This should be handled automatically by Gradle. If using other package managers, the instructions below may help:

_IntelliJ Idea Instructions_:
- File -> Project Structure
- Libraries
- Click on + to add library
- Add `engine.jar` probably here: `C:\Program Files\MATLAB\R2022b\extern\engines\java\jar`
- Select all projects

## Context
A technique, known as Cardiotocography (CTG), can be used to monitor the fetal heartbeat and the uterine contractions during pregnancy and labour. The interpretation of CTGs can be difficult, with healthcare professionals needing extensive training, to correctly determine the results of a CTG (whether the baby is at risk and proactive action needs to be taken for example). 

A mathematical model has been developed in MATLAB that can be used to describe the physiology of a CTG scan, allowing clinicians to understand how these uterine contractions affect the heartbeat during labour. This model can therefore be used to train learning clinicians, through mimicking realistic measurements and then revealing how these affect the fetal status and related parameters such as brain oxygenation. This is great since in practice, you would not be able to see these variables. 

See https://research.tue.nl/en/publications/a-mathematical-model-for-simulation-of-fetal-heart-rate-decelerat for additional information on this mathematical model. 

__This project will be able to improve the decision-making of healthcare professionals throughout their career, ultimately rendering better outcomes for potential future babies at risk.__

## Project Proposal
**The project is primarily aimed at providing a tool for healthcare professional to train their CTG interpretation skills on.**

### Key Points: 
- The mathematical model has already been fully developed in MATLAB.
  - Fully functional for research users 
  - NOT functional for clinical users 

- This means that our project is **targeted specifically for clinical end users, as a training tool**, and therefore needs: 
  - An **intuitive interface**, easy for clinical users to pick up and use (frontend): 
    - Multiple interfaces are also permitted 
    - It is expected that this **user interface provides graphical representations of the data** from the underlying MATLAB algorithms. 

- This new tool needs to **utilize the existing MATLAB mathematical model** (include MATLAB within the project). 
  - See: https://nl.mathworks.com/products/matlab/matlab-and-other-programming-languages.html 
  - This program is intended to be used as an educational tool rather than in practice. 

- The main data points we need to use are: 

  - **pO2** – *Fetal Blood* (ONLY SIMULATOR) 
  - **MAP** – *Fetal Blood Pressure* (ONLY SIMULATOR) 
  - **FHR** – *Fetal Heart Rate* (ALWAYS AVAILABLE) 
  - **UP** – *Uterine Contractions* (ALWAYS AVAILABLE)
  - `TODO: Missing Variables`

Since some variables are only available in simulator, these should also be more prominent in our UI. These variables can affect each other. **FHR** & **UP** are what form the **CTG**.

## Research Questions
- Investigate how existing MATLAB prototypes can be re-used in a scalable software solution, without altering the existing MATLAB code (see above link). 
- How to create a scalable architecture that can realize cooperation between the different components in real-time for multiple end users  
- How to update graphical representations for the end-user in real-time, while background algorithms are calculating results continuously  
- How should the user interface look like for a “freestyle” version of the simulator?  
- How should the user interface look like for a “pre-defined clinical cases” version of the simulator?  
- How could an e-learning be developed around the CTG simulator to aid in CTG interpretation? 

*Additional documentation can be found on the file repo on Teams.*
