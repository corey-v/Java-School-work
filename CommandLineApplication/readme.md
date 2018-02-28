# Java Command-Line Application

The purpose of this school project was to consolidate a variety of lessons and apply them to building a command-line application. We were given a couple files to start with including ApplicationException.java and BookOptions.java. Book Options includes the use of Apache Commons CLI to process command-line switch options.

The goal was to build the core of a Book Store application which reads data from several files, processes/sorts the data, and prints a formatted report based on the options chosen. Normally this data would usually be held in a database but this project was focused on working with file IO. We also implemented Log4j2 as our application logger.

The project implemented the Builder design pattern in the classes BookReader, CustomerReader, and PurchaseReader as we did not want our classes to be instantiated without some required information. 

The BookStore file is our main driver class, when run it instantiates itself with the CLI args, passes it to BookOptions to process the arguments, then begins generating reports based on the options selected.
