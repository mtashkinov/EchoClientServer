import java.net.ServerSocket

/**
 * Created by Mikhail on 21.11.2015.
 */

fun main(args: Array<String>)
{
    val port = 4444
    val serverSocket = ServerSocket(port)

    while (true)
    {
        val clientSocket = serverSocket.accept()
        val reader = clientSocket.inputStream.bufferedReader()
        val writer = clientSocket.outputStream.bufferedWriter()

        var s = reader.readLine()
        while (s != null)
        {
            writer.write(s)
            writer.newLine()
            writer.flush()
            s = reader.readLine()
        }
        reader.close()
        writer.close()
        clientSocket.close()
    }
}