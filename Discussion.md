Solutions Considered
Naive Approach Read Entire File into Memory

Description: The simplest approach would be to read the entire 1 TB log file into memory, filter for the specified date, and write the results to an output file.
Challenges:
Memory Overhead: Loading the entire log file into memory is not feasible for large files, especially when the file size is around 1 TB. This could lead to memory overflow or significant slowdowns.
Inefficient for Large Files: Processing the file in its entirety would also waste resources for situations where only a small portion of the log file is required.
Use of Multiple Threads for Parallel Processing

Description: Split the log file into chunks and use multiple threads to process different chunks concurrently, allowing for faster extraction of logs from a specific date.
Challenges:
Complexity: This approach introduces the need for managing multiple threads, synchronization, and partitioning the file efficiently. Additionally, concurrent writes to the output file could result in race conditions.
File Boundaries: The log file has structured data where each log entry begins with a timestamp. Splitting the file at arbitrary locations might cause incomplete log entries, especially at file boundaries.
Efficient Sequential Processing (Final Solution)

Description: The most efficient solution for this task is to process the file sequentially line by line. For each line, the timestamp is extracted, and if it matches the specified date, the log is written to an output file.
Advantages:
Memory Efficiency: The file is processed line by line, meaning only one log entry is stored in memory at any given time, which keeps memory usage very low.
Simplicity: This approach avoids the complexity of parallel processing or complex file partitioning. It is simple and easy to implement while being efficient for extracting specific log entries.
Scalability: This solution is easily scalable for large log files (up to 1 TB or more). The time complexity remains O(n), where n is the number of lines in the file.
Challenges: The main challenge is ensuring that the program runs efficiently for files of up to 1 TB in size, which we overcome by reading the file line by line.

Final Solution Summary
The final solution processes the log file sequentially to extract logs for a given date. This approach is chosen because it:

Minimizes Memory Usage: By processing the file line by line, the program only keeps one log entry in memory at any given time, which ensures low memory usage even for very large files.
Simple and Effective: It avoids the complexities of parallelization and file partitioning, and is simple to implement while still being efficient.
Handles Large Files Efficiently: The solution is designed to handle log files as large as 1 TB or more without requiring large amounts of memory. It scales well because it reads the file sequentially, processing each line in constant time.
The time complexity is O(n), where n is the number of lines in the log file, and the space complexity is O(1) since we only store one log entry in memory at a time.

Download test file using:
curl -L -o test_logs.log "https://limewire.com/d/90794bb3-6831-4e02-8a59-ffc7f3b8b2a3#X1xnzrH5s4H_DKEkT_dfBuUT1mFKZuj4cFWNoMJGX98"

Compile the Java Program:
javac ExtractLogs.java

Run the Program:
To extract logs for a specific date (e.g., 2024-12-01):

java ExtractLogs 2024-12-01
Check Output:

The logs for the specified date will be saved in output/output_YYYY-MM-DD.txt.
