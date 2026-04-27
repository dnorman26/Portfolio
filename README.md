Project Summary

Created a C++ program that shows 12-hour and 24-hour clocks simultaneously, allowing users to add hours, minutes, and seconds via a menu.


What I Did Well

Implemented modular functions for menu handling, time incrementing, and formatted display.


Areas for Improvement

Improve input validation and adding real-time clock updates would enhance functionality.


Challenges and Solutions

Managing time increments and rollovers was challenging. I solved this by creating cascading functions where adding seconds triggers minute increments, and so on.


Transferable skills

Strengthened skills in modular programming, reference parameters, formatted output, and managing program state will be useful for larger projects.


Maintainability, Readability, and Adaptability

Code is broken into clear, single-purpose functions with comments for clarity. This makes it easy to maintain and extend.

**How do I interpret user needs and implement them into a program? How does creating “user stories” help with this?**
  Interpreting user needs involves actively listening, asking clarifying questions, and translating requirements into actionable tasks. 
  Creating user stories helps by breaking down these needs into specific, testable features that guide development.

**How do I approach developing programs? What Agile processes do I hope to incorporate into my future development work?**
  I approach developing programs iteratively, starting with small, testable components and building functionality step by step. 
  I hope to incorporate Agile processes like sprints, regular stand-ups, and continuous feedback to ensure adaptability and consistent progress.

**What does it mean to be a good team member in software development?**
  Being a good team member means communicating clearly, supporting others, and contributing actively to group goals. 
  It also involves being open to feedback and collaborating effectively to solve problems.

**CS 230 Project: Draw It or Lose It**

**Client and Requirements:**
The Gaming Room wanted to extend Draw It or Lose It from Android to a web-based, cross-platform application. Key requirements included support for multiple teams and players, unique game and team names, a single active game instance, and scalable, real-time multiuser gameplay.

**Strengths in Documentation:**
The design document clearly communicated technical decisions using OOP principles, design patterns, and a domain model, balancing depth with readability for both clients and developers.

**Helpful Aspects for Coding:**
Defining the domain model, constraints, and architecture upfront guided class design, logic implementation, and considerations for scalability, concurrency, and performance.

**Potential Revision:**
The System Architecture View could include diagrams of the three-tier frontend-backend-database structure and distributed components to improve clarity.

**Interpreting User Needs:**
User needs were implemented through scalable structures, unique identifiers, and memory management. Prioritizing user requirements ensures usability, satisfaction, and adoption.

**Design Approach:**
I captured requirements, defined constraints, modeled the domain, and evaluated platforms, tools, and security considerations. For future projects, I would add prototypes, risk assessments, and early automated testing to validate designs. 

**CS 255 DriverPass Project Reflection**

**Briefly summarize the DriverPass project. Who was the client? What type of system did they want you to design?**
The client was DriverPass who wanted a website to help students study for driving tests. The system included exams, scheduling features, and different user roles like students, instructors, and admins.

**What did you do particularly well?**
I did a good job writing clear business requirements based on what the client wanted. I also created a system design that matched those requirements and showed how the system would work.

**If you could choose one part of your work on these documents to revise, what would you pick? How would you improve it?**
If I could change one thing, I would add more detail to the system design. This would make it easier for developers to build the system later.

**How did you interpret the user's needs and implement them into your system design? Why is it so important to consider the user's needs when designing?**
I used the client's requirements to decide what features the system needed. Thinking about user needs is important since software should be easy to use and be able to solve the user's problem.

**How do you approach designing software? What techniques or strategies would you use in the future to analyze and design a system?**
I start by figuring out what the user wants before designing the system. In the future, I will keep using diagrams and feedback to design systems that are clear and easy to understand.

**CS 300 Journal**

**What was the problem you were solving in the projects for this course?**
The main problem I was solving in this course was figuring out how to store, sort, and display course data effieciently. This included analyzing run-time and memory usage for different data structures and writing code to sort Computer Science courses in alphanumeric order.

**How did you approach the problem? Consider why data structures are important to understand.**
Understanding data structures is important due to how they affect how fast a program runs and how much memory is uses.

**How did you overcome any roadblocks you encountered while going through the activities or project?**
I ran into roadblocks with sorting logic and understanding why some data structures performed better than others. I overcame these issues by breaking the problem into smaller steps, testing often, and reviewing examples until the logic made sense.

**How has your work on this project expanded your approach to designing software and developing programs?**
This project has helped on how I choose data structures in development. I now focus more on effieciency and planning instead of just making the code work.

**How has your work on this project evolved the way you write programs that are maintainable, readable, and adaptable?**
I pay more attention to clear variable names, comments, and writing code that can be easily updated or reused later.

**CS 305**

**Briefly summarize your client, Artemis Financial, and its software requirements. Who was the client? What issues did the company want you to address?**
Artemis Financial is a financial services company that needed its web application reviewed for security weaknesses. The company wanted to identify vulnerabilities and improve secure communication to protect sensitive client financial data.

**What did you do well when you found your client's software security vulnerabilities? Why is important to code securely? What value does software security add to a company's overall well-being?**
I successfully identified security gaps and implemented HTTPS with SSL/TLS encryption to protect data in transit. Secure coding is important since it prevents data breaches, protects customer information, and strengthens a company's reputation and trustworthiness.

**Which part of the vulnerability assessment was challenging or helpful to you?**
The most challenging part was analyzing the different types of vulnerabilities and understanding how they connected to the overall system architecture. However, this process was helpful since it improved my understanding of how security must be built into every layer of an application.

**How did you increase layers of security? In the future, what would you use to asses vulnerabilities and decide which mitigation techniques to use?**
I increased security by adding SSL encryption, redirecting HTTP to HTTPS, improving input validation, and using SHA-256 hashing. In the future, I would use automated tools such as static code analyzers and dependency checkers to identify vulnerabilities and determine the best mitigation strategies.

**How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?**
I tested the application after refactoring to confirm HTTPS was working and verified that all endpoints functioned correctly. I also ran a dependency-check scan to identify any vulnerable libraries and ensure that no new security issues were introduced during the update.

**What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?**
I used Spring Boot configuration, Java keytool, SSL certificates, SHA-256 hashing, and secure coding best practices. These tools and practices wil be helpful in future software development and security-focused projects.

**Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?**
I would show employers my completed vulnerability assessment report and secure software refactoring work to demonstrate my ability to identify risks, apply security controls, and implement secure coding practices in a real-world scenario.

**CS 330 Module Eight Journal Reflection**

**How do I approach designing software?**  
I approach designing software by first understanding the requirements and then planning the structure before writing code. I break the project into smaller components to make it easier to build, test, and debug.

**What new design skills has your work on the project helped you to craft?**  
This project helped me improve my ability to design and manage a 3D scene using OpenGL. I gained experience working with textures, lighting, and transformations to build a complete visual environment.

**What design process did you follow for your project work?**  
I followed an iterative design process where I built the scene step by step across each milestone. I started with basic shapes and progressively added textures, lighting, and final refinements.

**How could tactics from your design approach be applied in future work?**  
My design approach can be applied to future projects by breaking complex systems into smaller, manageable parts. This makes development more organized and easier to debug and maintain.

**How do I approach developing programs?**  
I approach developing programs by writing small sections of code, testing frequently, and correcting issues as they appear. I also rely on debugging tools to verify program behavior.

**What new development strategies did you use while working on your 3D scene?**  
I used shader-based lighting, texture mapping, and transformation matrices to construct the 3D scene. I also learned how to properly manage lighting effects and object placement in OpenGL.

**How did iteration factor into your development?**  
Iteration was essential because each milestone built upon the previous one. I continuously refined the scene by adjusting lighting, textures, and object positioning.

**How has your approach to developing code evolved throughout the milestones, which led you to the project’s completion?**  
My approach became more structured and intentional throughout the milestones. I improved my planning before coding and became more efficient at debugging graphical issues.

**How can computer science help me in reaching my goals?**  
Computer science helps me reach my goals by strengthening my problem-solving and programming skills. These skills are valuable for software development and technical career paths.

**How do computational graphics and visualizations give you new knowledge and skills that can be applied in your future educational pathway?**  
Computational graphics taught me how 3D rendering, lighting models, and transformations work. This knowledge will support future coursework involving simulations, visualization, and graphics programming.

**How do computational graphics and visualizations give you new knowledge and skills that can be applied in your future professional pathway?**  
These skills apply to professional fields such as game development, simulation systems, and software engineering. Understanding 3D graphics pipelines provides practical experience for real-world applications.
