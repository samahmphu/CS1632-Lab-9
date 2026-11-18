import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph selectedGraph = null;
        while (true) {
            try {
                System.out.println("\n-- Menu --" +
                        "\n1. Read a file as a graph and run Dijkstra's Algorithm" +
                        "\n2. Exit application");
                String in = sc.next();
                if (Integer.parseInt(in) == 1){
                    while (true) {
                        try {
                            System.out.println("\n-- Read Graph --" +
                                    "\nEnter the filename of your CSV file located in src/TxtFiles, or enter 0 to cancel." +
                                    "\nExample: graph1.csv\n");
                            System.out.print("Enter file name: ");
                            in = sc.next();
                            if (in.equals("0")) {
                                break;
                            }
                            else {
                                selectedGraph = Reader.Read("src/TxtFiles/" + in);
                                String graphName = in;
                                while (true) {
                                    try {
                                        System.out.println("\n-- Dijkstra's Algorithm --" +
                                                "\nList of vertices inside of " + graphName);
                                        for (int i = 0; i < selectedGraph.vertices.size(); i++) {
                                            int num = i+1;
                                            System.out.print("" + num + ". "
                                                    + selectedGraph.vertices.get(i).getName() + "\n");
                                        }
                                        System.out.print("\nEnter the node name to run DA. " +
                                                "Otherwise, enter 0 to cancel: ");
                                        in = sc.next();

                                        if (in.equals("0")) {
                                            break;
                                        }

                                        else {
                                            Vertex selectedNode = selectedGraph.getVertexByName(in);
                                            System.out.println("Selected node: " + selectedNode.getName());
                                            selectedGraph.dAlgo(selectedNode);

                                        }

                                    }
                                    catch (NullPointerException nullPointerException) {
                                        System.out.println("The node could not be found. Please try again.");
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                    }
                }
                else if (Integer.parseInt(in)== 2) {
                    break;
                }
                else {System.out.println("Invalid input");}

            } catch (Exception e) {
                System.out.println("Invalid input");;
            }
        }
    }


}
