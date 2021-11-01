
#!/bin/sh

# play a match
# input : t_id, game_number
# output : none

echo "Input Tournament ID"
read first
echo "Input GameNumber"
read second

echo "Let's start game!"

java -cp /Users/shotamiyawaki/ProgramDev/JDBC/mysql-connector-java-8.0.21.jar: OneMatch $first $second