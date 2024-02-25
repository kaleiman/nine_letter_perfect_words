import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class UrlToHashSet {

    public static Set<String> readUrlToHashSet(String fileUrl) throws IOException {
        Set<String> data = new HashSet<>();
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.trim().toLowerCase());
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return data;
    }
}
