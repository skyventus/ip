#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./ACTUAL-UNIX.TXT" ]
then
    rm ACTUAL-UNIX.TXT
fi

# compile the code into the bin folder, terminates if error occurred (olivier)
if ! javac -cp ../src/main/* -Xlint:none -d ../bin ../src/main/java/duke/Duke.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ../bin duke.duke < input.txt > ACTUAL-UNIX.TXT

# convert to UNIX format
cp EXPECTED.TXT EXPECTED-UNIX.TXT
dos2unix ACTUAL-UNIX.TXT
dos2unix EXPECTED-UNIX.TXT

# compare the output to the expected output
diff ACTUAL-UNIX.TXT EXPECTED-UNIX.TXT
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    exit 0
else
    echo "Test result: FAILED"
    exit 1
fi