
#!/bin/sh

# play a match
# input : t_id, game_number
# output : none

echo "Input Tournament ID"
read first
first='NA8A202103'
echo "Input GameNumber(integer)"
read second

echo "Let's start game!"

# java -cp /Users/shotamiyawaki/ProgramDev/JDBC/mysql-connector-java-8.0.21.jar: OneMatch $first $second
java -cp /Users/shotamiyawaki/ProgramDev/JDBC/mysql-connector-java-8.0.21.jar: OneMatchKai $first $second
