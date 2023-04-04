# Universal-Programming-Techniques-JAVA-
Attached are the coursework done in Java Programming language
The following concepts are used in the various codes of the repository

# README


### UTP1.zad1 - Lambda Expressions and Function Composition

This assignment requires the creation of an `InputConverter` class that can transform input data using functions given as arguments of the `convertBy` method. The `InputConverter` class takes a constructor argument that determines the input data.

### UTP1.zad2 - Maybe Class

This assignment requires the definition of a `Maybe` class with features that provide a safe container that does not raise `NullPointerException` exceptions. The `Maybe` class can be used to facilitate programming in a situation where the variable can be set to null, especially when it is required to further secure processing using lambda expressions or other functions.


### UTP2.zad1 - Java Collections- Anagrams- 
if the file allwords.txt contains the following words:

andes danes deans evil gals lags levi live sedan
slag streets testers uprising veil vile

and wordsToFind.txt file contains words:
evil streets uprising

- and the program (starting execution of a mandatory Main class) should output the following information on the console:

[evil, levi, live, veil, vile]
[andes, danes, deans, sedan]
[gals, lags, slag]
[streets, testers]
[uprising]
************************
evil: [levi, live, veil, vile]
streets: [testers]
uprising: []

### UTP2.zad - Java Collections- XList
Create a class XList, providing additional functionalities to create lists, and operating on them.
In the class should be appropriate constructors and static methodsof, allows creating XList objects from another collections, arrays, and arguments separated by commas.
In addition, auxiliary methods to create a list of strings:
ofChars(string) - returns x-list of given string characters,
ofTokens(string, [ sep ]) - returns x-list of string symbols, separated by sep separators (if lack of sep - use white chars instead).
In addition you should provide methods:
union(any_collection)  -  returns  a new x-list containing elements from both old x-list and collection from the method argument,
diff(any_collection) - returns a x-list containing only those elements of that lists, which are not present in the collection from method argument,
unique() - returns a new x-list, which  contains all unique elements of the list
combine() - returns a x-listę that contains combination of elements of x-list
collect(Function) - zwraca a new x-listę, which elements are results of function applied to elements of the x-list
join([sep]) - returns a string which is concatenation of elements of the list, optionally with the interposition of a given separator
forEachWithIndex(consumer_with_two_arguments: element, index) - for iterating over list with access to elements and it's indexes


### UTP3.zad1 - Input Output Stream - CustomerFinding tree
Searching for customer details from a file and giving out the separated result in the console 

### UTP3.zad2 - Input Output Stream - FileSearch Recursive
Searching for different .txt files in the subdirectories.. Conacting them and giving out the result in one txt file


### UTP4.zad1- MultiThreading - 
Build class Letters, which will be used to run parallel codes, which every second print a letter given in the string passed to the constructor. After creating the object of class Letters in the method main(...) of Main class start all threads in which are to be given printed letters. After you pause the method main(...) for 5 seconds - exit all codes, which print the letters.

### UTP4.zad2 - MultiThreading (Runnable interface) - 
Build class StringTask, simulating long-term calculations, here consisting of the concatenation of strings.

The class constructor receives as argument the string to duplicate, and the number indicating how many times the string is to be amplified.
The object of class StringTask is treated as a task that can be performed in parallel with each other.

The status tasks are:

CREATED - the task created, but not started yet performed,
RUNNING - the task is performed in a separate thread
ABORTED - the task has been interrupted
READY - the task is successful and are ready results.



### UTP4.zad3- MultiThreading- 

Code, in the thread A, reads from a file ../Goods.txt information about the goods in the form of:
id weight
it creates objects of a class Good containing the information read and outputs to the console information about the number of created objects. Information is to be output at 200 facilities in the form:

created 200 objects
created 400 objects
created 600 objects
etc.
The code running in parallel in another thread (B) reaches these objects, sums up the weight of goods and outputs to the console information about conducted summation of 100 objects, eg .:

counted the weight of 100 goods
counted the weight of 200 goods
counted the weight of 300 goods
etc.
at the end gives the total weight of all the goods.


### UTP5.zad1 - JDBC AND GUI


### UTP6.zad1 - Streams - BigDec calculator without if, swich, conditional and while

### UTP6.zad2 - Streams - Anagrams using streams

### UTP6.zad3 - Streams - Recursive File Change using streams
