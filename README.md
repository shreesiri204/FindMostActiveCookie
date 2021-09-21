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

