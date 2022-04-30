import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderAndWriter {

    public static String readerByte(String address) {
        StringBuilder result = new StringBuilder();
        Path file = Path.of(address);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result.toString();
    }

    public static void writerByte(String address, String str) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(address, "rw");
             FileChannel channel = randomAccessFile.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(str.getBytes().length);
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
