import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static Graph Read(String filename) {
        Graph adjList = new AdjacencyList();

        String[] StringArray;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    StringArray = line.split(" ");
                    adjList.addEdge(StringArray[0], StringArray[1], Double.parseDouble(StringArray[2]));
                }
            } catch (IOException e) {
                System.out.println("There was a problem reading the text.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file name.");
            return null;
        }
        System.out.println("Successfully read the file.");

        return adjList;

    }
}
