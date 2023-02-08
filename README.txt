CSC 369 Lab 2: MapReduce / Hadoop
Michael Cassetti

For my map/reduce implementation, I followed two different processes to complete 
the following tasks:
1. Requests count for each URL path, sorted by request count (ascending)
2. Requests count for each HTTP response code, sorted by response code (ascending)
3. Total bytes sent to the client with a specified hostname or IPv4 address (you may hard code an address)
4. Based on a given URL (hard coded), compute a request count for each client (hostname or IPv4) who accessed that URL, sorted by request count (ascending)
5. Request count for each calendar month and year, sorted chronologically
6. For each calendar day that appears in the file, return total bytes sent. Sort by total bytes in ascending order.

Every task requires at least one map/reduce, while those asking for ascending order
require a second map/reduce, with the first map/reduce's output as the second map/reduce's
input. Every job (task I need to complete) was also added to HadoopApp.java, to make sure
the program knows what job I am trying to complete on the input file.

For task 1, I split each access log by spaces, and went to the 6th index, the URL.
From there, I finished mapping by adding a value of 1 to each key (URL). In the recuce,
I would get the sum of all 1s for each key, and we now have our counts. I would write this 
file as output "task1a" which would be the input for my task1b, which sorts by ascending order.
For the sorting, we made the key the count of the times the URL occured, and because this
map/reduce sorts by key, we get ascending order for our output "task1b"

I followed this similar process for all 6 tasks, indexing to the correct spots in the access log
line split for each task. Some tasks were completed with only 1 map/reduce, while others 
required 2. This means that there would need to be two commands run for those tasks.