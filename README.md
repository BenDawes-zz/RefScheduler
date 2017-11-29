# RefScheduler
Game and referee scheduling for quidditch tournaments.

# Development Setup Instructions

1) Clone the repo to local
2) Open IntelliJ -> Import Project -> choose pom.xml
3) Right click RefScheduler.iml -> Import Module
4) Delete any extra .iml file created when you imported (probably ref-scheduler.iml)
5) Install postgres
6) Create a database called refscheduler, with a schema called ref_scheduler, and a user with ALL privileges on them with user/password as set in application.properties (default postgres/postgres)
7) Run Main.java
8) Download and start XAMPP
9) Copy everything in the /web/ folder of this project and put it in the folder XAMPP uses to serve its pages
