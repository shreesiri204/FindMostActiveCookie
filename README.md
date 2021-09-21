# Overview
Command line application to parse the Cookie log file and to return most active cookie(s) for given day
# Running the project:
## Command:

      java -jar build/libs/FindActiveCookie-all-1.0.jar -f <CSV path>/cookie_log.csv -d <date>

## Example:

     java -jar build/libs/FindActiveCookie-all-1.0.jar -f C:/Users/kshree/Desktop/data/cookie.csv -d 2018-12-09

# Building locally

Clone the project to your local machine in any directory of your choice.

git clone https://github.com/shreesiri204/FindMostActiveCookie.git

From the cloned directory path, build the project using the commands below. The Jar is created under the $project/build/libs/ folder.

1. cd FindMostActiveCookie/
2. gradle clean
3. gradle fatJar

# Executable Jar 
Built and Executable Jar is also available at- https://github.com/shreesiri204/FindMostActiveCookie 

# Problem Statement
Write a command line program in your preferred language to process the log file and return the most active cookie for a specific day. Please include a -f parameter for the filename to process and a -d parameter to specify the date.

### Assumptions:
● If multiple cookies meet that criteria, please return all of them on separate lines.
● Please only use additional libraries for testing, logging and cli-parsing. There are libraries for most
languages which make this too easy (e.g pandas) and we’d like you to show off your coding skills.
● You can assume -d parameter takes date in UTC time zone.
● You have enough memory to store the contents of the whole file.
● Cookies in the log file are sorted by timestamp (most recent occurrence is the first line of the file).

# Solutions

### 1. Current Approach:
FindActiveCookie application is implemnted to find a most active cookie(s) for a given date and to print on separate lines. Since the data is sorted, for better performance the application is implemnted only to parse the CSV till given date and to break once the Cookie log date is before given input date.

### 2. Alternatives:
a.  For much better performance, we can also read CSV with Binary search logic, since there was no assumption on length of the cookie name and if all cookie names will be of same length, Have implemented the above solution. we can further improve performance with this logic.

b. If Future requiremnets also needs reading multiple dates cookie data and additional parameters, code can be extended or implemented to read complete csv data and then work on those objects. 

