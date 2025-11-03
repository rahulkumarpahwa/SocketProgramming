# Compile all files :

javac --release 8 SocServer.java SocketClient.java

# Start the Server :

Error: Could not find or load main class SocServerError: Could not find or load main class SocServer

# Start the Client :

java SocketClient

# Procedure :

- Compile the both the files.
- Start the Server.
- Start the client.
- Output will Printed in Server Terminal and connection will close due to .close() method.

# Sending And Recieving Methods:

## Sending Data :

- To Send the data we need OutputStreamWriter in which's object we will pass the s.getOutputStream() as the Socket s has two ends InputStream and OutputStream and this OutputStreamWriter will pass the data to the socket.
- Then we Will create an PrintWriter obj 'out' which will send data to the OutputStreamWriter obj 'os' so we will pass this in it.
- At the end we will call the method println() in which we pass the String to be Send from the either Side.
- Make sure to call the flush method with 'os' so as to force the data to send.

## Recieving Data :

- To recieve, we will need BufferedReader in which we will pass the object of the InputStreamReader and inside it we will pass the socket's input stream with s.getInputStream().
- Then we will get the String at output at the BufferedReader obj bf with call to readLine() method.
- Then print the output on the client terminal.

## No of Apps: 
- there are two inside this repo:
  1. IntroProject : this covers the basic working of sockets with java.
  2. ChatApp : this is an chatApp between the client and server.
