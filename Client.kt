import java.net.Socket

/**
 * Created by Mikhail on 21.11.2015.
 */

fun main(args: Array<String>)
{
    val hostName = "localhost"
    val port = 4444

    val socket = Socket(hostName, port)
    val reader = socket.inputStream.bufferedReader()
    val writer = socket.outputStream.bufferedWriter()

    print("You: ")
    var userInput = readLine()
    while (!userInput.equals(""))
    {
        writer.write(userInput)
        writer.newLine()
        writer.flush()
        println("Server: ${reader.readLine()}")
        print("You: ")
        userInput = readLine()
    }

    reader.close()
    writer.close()
    socket.close()
}