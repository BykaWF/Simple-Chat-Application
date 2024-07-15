# Simple Chat Application

## Overview
This repository contains a basic implementation of a chat client-server application using Java. The project demonstrates networking concepts, including socket communication and multithreading.

## Components
1. **Client**: A GUI-based chat client that allows users to send messages to a server.
2. **Server**: A multi-threaded server that accepts connections from multiple clients and handles incoming messages.
3. **ReaderJob**: A Runnable task that reads messages from the client socket and prints them to the console.

## Files
### Client.java
This file contains the implementation of the chat client. The client GUI includes a text field for input and a send button to transmit messages to the server.

Key Features:
- Establishes a connection to the server using a `SocketChannel`.
- Sends messages typed in the text field to the server.
- Utilizes `Swing` components for the GUI.

```java
public class Client {
    // GUI components and networking setup
}
```

### ReaderJob.java
This file defines a Runnable task that reads messages from a BufferedReader and prints them to the console. It is used by the server to handle incoming messages from clients.

Key Features:
- Continuously reads messages from the client socket.
- Closes the reader upon completion or error.

```java
public class ReaderJob implements Runnable {
    // Reads messages from a BufferedReader and prints them
}
```
### Server.java
This file contains the implementation of the chat server. The server listens for incoming client connections and spawns a new ReaderJob thread for each connection to handle message reading.

Key Features:

- Binds to a specified port and accepts client connections.
- Uses a thread pool to manage multiple client connections concurrently.
- Reads messages from clients and can be extended to broadcast messages to all connected clients.

```java
public class Server {
    // Server setup and client connection handling
}
```
## How to Run
### Server:

- Compile and run Server.java.
- The server will start and listen for connections on port 7213.
### Client:

- Compile and run Client.java.
- A GUI window will appear where you can type and send messages.
  
### Dependencies
- Java SE Development Kit (JDK) 8 or higher.

### Future Improvements
- Implement message broadcasting to all connected clients.
- Add a GUI component to display incoming messages on the client side.
- Improve error handling and user feedback in the GUI.
- Enhance security features such as authentication and encryption.

