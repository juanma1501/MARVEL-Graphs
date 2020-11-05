/** ********************************************************************
 * Class Name: Main
 * Author/s name: Juan Manuel Porrero Almansa, Jose Carlos Gualo Cejudo, Santiago Juan Leon Galán
 * Release/Creation date: 15/12/2019
 * Class description: A class to perform the actions required on a graph.
 *
 ***********************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;

public class Main {
	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		String fileName = "C:\\Users\\usuario\\Desktop\\marvel-unimodal-edges con comillas.csv";

		List<Superhero> superhero_list = new ArrayList<Superhero>();
		Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g = new TreeMapGraph<DecoratedElement<Superhero>, DecoratedElement<Interaction>>();

		g = readfile(fileName, superhero_list);

		System.out.println("********  WELCOME TO OUR MARVEL GRAPH APPLICATION  ********");
		System.out.println();
		System.out.println("*************** CHAPTER A ***********************");
		showGraphStats(g);
		getMostSociable(g);
		getLessSociable(g);
		lessWork(g);
		System.out.println();
		System.out.println("*************** CHAPTER B ***********************");
		path(g);
		System.out.println();
		System.out.println("*************** CHAPTER C ***********************");
		designTeam(g);

	}

	public static void showLists(List<Superhero> a) {
		Iterator<Superhero> iterator = a.iterator();
		while (iterator.hasNext()) {
			System.out.println("[" + iterator.next().getName() + "]");
		}
	}

	/**
	    * ********************************************************************
	    * Method name: readfile
	    * 
	    * Description of the Method: A method to initialize a graph
	    * 
	    *
	    * Calling arguments: the path of the file, and a superhero list
	    * 
	    * Return value: Graph graph
	    *
	    ********************************************************************
	    */
	public static Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> readfile(String fileName,
			List<Superhero> superhero_list) {

		
		File file = new File(fileName);
		FileReader fr;
		Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> gr = new TreeMapGraph<DecoratedElement<Superhero>, DecoratedElement<Interaction>>();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String id;
			int contador = 0;

			DecoratedElement<Superhero> origin_heroDE;
			DecoratedElement<Superhero> target_heroDE;
			DecoratedElement<Interaction> interaccionDE; // 1 y 2 en el vertex y el 3 en el edge.
			Vertex<DecoratedElement<Superhero>> vertex_1, vertex_2;
			Interaction interaccion;

			while ((line = br.readLine()) != null) {
				

				
				if (line.contains("Source,Target,Weight") == false) {

					
					String[] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
					
					for (int i = 0; i < splitted.length; i++) {
						if (splitted[i].contains("\"")) {
							splitted[i] = splitted[i].replace("\"", "").trim();
						}
					}

					String origin = splitted[0];
					Superhero origin_hero = new Superhero(origin);
					String target = splitted[1];
					Superhero target_hero = new Superhero(target);
					interaccion = new Interaction(splitted[2]);

					origin_heroDE = new DecoratedElement<Superhero>(origin, origin_hero);
					target_heroDE = new DecoratedElement<Superhero>(target, target_hero);

					id = "" + contador;
					contador++;

					interaccionDE = new DecoratedElement<Interaction>(id, interaccion);

					vertex_1 = gr.insertVertex(origin_heroDE);
					vertex_2 = gr.insertVertex(target_heroDE);
					gr.insertEdge(vertex_1, vertex_2, interaccionDE);
				}

			}

			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gr;
	}

	public static void showGraphStats(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> graph) {
		System.out.println(
				"Total number of heroes: " + graph.getN() + "\nTotal number of relationships: " + graph.getM() + "\n");
	}

	/**
     * ********************************************************************
     * Method name: getMostSociable
     *
     *
     * Description of the Method: We look for the vertex that has more adjacent vertices
     *
     * Calling arguments: A graph
     *
     * Return value: void. Print on screen the vertex(super hero) with more adjacent vertices
     *
     ********************************************************************
     */
	public static void getMostSociable(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {
		int n = 0;
		List<DecoratedElement<Superhero>> max = new ArrayList<DecoratedElement<Superhero>>();
		Iterator<Vertex<DecoratedElement<Superhero>>> v = g.getVertices();
		while (v.hasNext()) {
			Vertex<DecoratedElement<Superhero>> vertex = v.next();
			int vertex_count = 0;

			Iterator<Edge<DecoratedElement<Interaction>>> e = g.incidentEdges(vertex);

			while (e.hasNext()) {
				e.next();
				vertex_count++;
			}
			if (vertex_count > n) {
				n = vertex_count;
				if (!max.isEmpty()) {
					max.clear();
					max.add(vertex.getElement());
				} 
			}else if (vertex_count == n) {
				n = vertex_count;
				max.add(vertex.getElement());
			}
		}

		System.out.print("The most sociable heroe/s is:  ");

		Iterator<DecoratedElement<Superhero>> iter = max.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().getID());
		}
		System.out.println("\t -------------------> " + n + " connections.");

	}
	
	/**
     * ********************************************************************
     * Method name: getLessSociable
     *
     *
     * Description of the Method: We look for the vertex that has less adjacent vertices
     *
     * Calling arguments: a graph
     *
     * Return value: void. Print on screen the vertex(super hero) with less adjacent vertices
     *
     ********************************************************************
     */
	public static void getLessSociable(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {
		int n = g.getM();
		List<DecoratedElement<Superhero>> max = new ArrayList<DecoratedElement<Superhero>>();
		Iterator<Vertex<DecoratedElement<Superhero>>> v = g.getVertices();
		while (v.hasNext()) {
			Vertex<DecoratedElement<Superhero>> vertex = v.next();
			int vertex_count = 0;

			Iterator<Edge<DecoratedElement<Interaction>>> e = g.incidentEdges(vertex);

			while (e.hasNext()) {
				e.next();
				vertex_count++;
			}
			if (vertex_count < n) {
				n = vertex_count;
				if (!max.isEmpty()) {
					max.clear();
					max.add(vertex.getElement());
				} 
			}else if (vertex_count == n) {
				n = vertex_count;
				max.add(vertex.getElement());
			}
		}

		System.out.print("The most sociable heroe/s is:  ");

		Iterator<DecoratedElement<Superhero>> iter = max.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().getID());
		}
		System.out.println("\t -------------------> " + n + " connections.");

	}
	/**
     * ********************************************************************
     * Method name: lessWork
     *
     *
     * Description of the Method: We look for the vertex whose sum of the all his adjacent vertices is the smallest
     *     
     * Calling arguments: a graph
     *
     * Return value: void. Print on the screen the super hero with less work.
     *
     ********************************************************************
     */
	public static void lessWork(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {
		int n = g.getM();
		List<DecoratedElement<Superhero>> max = new ArrayList<DecoratedElement<Superhero>>();
		Iterator<Vertex<DecoratedElement<Superhero>>> v = g.getVertices();

		Edge<DecoratedElement<Interaction>> e = null;
		DecoratedElement<Interaction> interactions_DE;
		int interactions = 0;

		while (v.hasNext()) {
			Vertex<DecoratedElement<Superhero>> vertex = v.next();

			Iterator<Edge<DecoratedElement<Interaction>>> it = g.incidentEdges(vertex);

			while (it.hasNext()) {
				e = it.next();
				interactions_DE = e.getElement();
				interactions = interactions + interactions_DE.getElement().getNivel();
			}
			if (interactions < n) {
				n = interactions;
				if (!max.isEmpty()) {
					max.clear();
					max.add(vertex.getElement());
				} else if (interactions == n) {
					n = interactions;
					max.add(vertex.getElement());
				}
			}
			interactions = 0;
		}

		System.out.print("The heroe who work less is:  ");

		Iterator<DecoratedElement<Superhero>> iter = max.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next().getID());
		}
		System.out.println("\t -------------------> " + n + " works");

	}
	
	/**
     * ********************************************************************
     * Method name: path
     *
     *
     * Description of the Method: This method is used to draw the shortest path between two characters. 
     *                            The shortest path is formed by characters that have 15 or more level of interaction between them.
     *
     * Calling arguments: a graph
     *
     * Return value: void. Print on screen the shortest path
     *
     ********************************************************************
     */
	public static void path(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {

		String AInicial = ""; // Initial super hero
		String AFinal = ""; // Final super hero
		Vertex<DecoratedElement<Superhero>> VI; // Initial vertex
		Vertex<DecoratedElement<Superhero>> VF; // Final vertex
		

		DecoratedElement<Superhero> node;
		String choose = "";
		boolean keep_going = true; // While is true new search can be done
		boolean keep_going2 = false; // To check invalid options

		do {
			System.out.println("Enter initial superhero: ");
			AInicial = teclado.nextLine();
			System.out.println("Enter final superhero: ");
			AFinal = teclado.nextLine();
			VI = g.getVertex(AInicial); // Initialization of the initial vertex
			VF = g.getVertex(AFinal); // Initialization of the final vertex
			if (VI == null || VF == null) { // Check if these super heros exists
				System.out.println("Please, enter valid superheroes.");
			} else if (VI.getID().equals(VF.getID())) {
				System.out.println("You have arrived ;) \n");
			} else {
				/* We calculate the shortest path using BFS */
				node = pathBFS(g, VI, VF); // We do the BFS 
				shortestPath(node);
				System.out.println();
				rebootGraph(g); // Reboot the graph for future search
				System.out.println();
			}
			
			/*For future search*/
			System.out.println("Do you want to do a new search? \nYES\nNO");
			do {

				choose = teclado.nextLine();
				choose = choose.toUpperCase();
				if (choose.equals("YES")) {
					keep_going = true;
					keep_going2 = false;
				} else if (choose.equals("NO")) {
					keep_going = false;
					keep_going2 = false;
				} else {
					keep_going2 = true;
					System.out.println("Please, insert a valid option. ");
				}

			} while (keep_going2);
		} while (keep_going);

	}

	/**
     * ********************************************************************
     * Method name: shortestPath
     *
     *
     * Description of the Method: This method is used to know the shortest path between two nodes 
     *
     * Calling arguments: a graph
     *
     * Return value: void. Print on screen the shortest path
     *
     ********************************************************************
     */
	public static void shortestPath(DecoratedElement<Superhero> node) {
		Stack<DecoratedElement<Superhero>> sp = new Stack<DecoratedElement<Superhero>>();
		int size;
		if (node.getParent() == null) {
			System.out.println("\nThere is no shortest path");
		} else {
			System.out.println("\nShortest path");
			while (node.getParent() != null) { // While vertex has parent (this mean we are have not arrived to the end)
				sp.push(node);
				node = node.getParent();
			}
			sp.push(node);

			/* Print the path in the list */
			size = sp.size();
			for (int i = 0; i < size - 1; i++) {
				node = sp.pop();
				System.out.print(node.getID() + "    --------->   ");
			}
			node = sp.pop();
			System.out.print(node.getID().toString());
		}

	}

	/**
     * ********************************************************************
     * Method name: pathBFS
     * 
     * Description of the method: From an initial node, then we go to the adjacent ones
     * to the initial and we add them to a list. Following nodes to be evaluated are the adjacent ones
     * to the nodes in the list. We also check that nodes has 15 or more level of relation between them
     *
     * Calling arguments: a graph, an initial vertex, and a final vertex
     * 
     * Return value: DecoratedElement Super hero
     *
     ********************************************************************
     */
	public static DecoratedElement<Superhero> pathBFS(
			Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g, Vertex<DecoratedElement<Superhero>> VI,
			Vertex<DecoratedElement<Superhero>> VF) {

		LinkedList<Vertex<DecoratedElement<Superhero>>> q = new LinkedList<Vertex<DecoratedElement<Superhero>>>();
		boolean noEnd = true; // When we are in the final vertex, noEnd is false
		Vertex<DecoratedElement<Superhero>> u, v = null;
		Edge<DecoratedElement<Interaction>> e = null;
		DecoratedElement<Interaction> interactions_DE;
		int interactions = 0;
		Iterator<Edge<DecoratedElement<Interaction>>> it;

		VI.getElement().setVisited(true);
		q.offer(VI); // We add initial vertex to the list
		while (!q.isEmpty() && noEnd) { // While q is not empty and noEnd
			u = q.poll(); // One element go out 
			it = g.incidentEdges(u); // Adjacent edges to the vertex u
			while (it.hasNext() && noEnd) { // While noEnd is true and it has next 

				e = it.next();
				interactions_DE = e.getElement();
				interactions = interactions_DE.getElement().getNivel();

				v = g.opposite(u, e); // Opposite vertex to u in the edge e 
				if (!(v.getElement()).getVisited() && interactions >= 15) { // If we haven´t visited this vertex yet and has 15 or more level of relation
					(v.getElement()).setVisited(true);
					(v.getElement()).setParent(u.getElement()); // We set parent to parent of this node
					(v.getElement()).setDistance(((u.getElement()).getDistance()) + 1); // distance + 1
																						
					q.offer(v); // Insert v in the list

					noEnd = !(v.getElement().equals(VF.getElement())); //We check that this vertex is not equal to he final vertex
				}
			}
		}
		if (noEnd) {
			v.getElement().setParent(null); // If they are equal we set parent to null
		}
		return v.getElement();
	}

	/**
    * ********************************************************************
    * Method name: pathDFS
    * 
    * Description of the Method: DFS algorithm uses a stack. Given an initial vertex, we add it to the stack.
    * To know which nodes we have to visit, we take out the head of the stack and we calculate his adjacent vertices.
    * From this adjacent vertices, the ones which are not visited are added to the stack. This process is repeated until
    * the stack is empty.
    * 
    *
    * Calling arguments: a graph, an initial vertex, and a final vertex
    * 
    * Return value: DecoratedElement Super hero
    *
    ********************************************************************
    */
	public static boolean pathDFS(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> grafo,
			Vertex<DecoratedElement<Superhero>> VI, Vertex<DecoratedElement<Superhero>> VF,
			Stack<Edge<DecoratedElement<Interaction>>> sp, boolean isCorrect) {

		boolean noEnd = !(VF.getID().equals(VI.getID()));

		Edge<DecoratedElement<Interaction>> e;
		DecoratedElement<Interaction> interactions_DE;
		int interactions;
		Iterator<Edge<DecoratedElement<Interaction>>> it = grafo.incidentEdges(VI); // Adjacent edges to initial vertex
																					
		Vertex<DecoratedElement<Superhero>> w;
		VI.getElement().setVisited(true); // Set initial vertex as visited

		if (isCorrect) {
			System.out.print(VI.getID());
			isCorrect = false;
		}
		while (it.hasNext() && noEnd) { // Edges iterator traversal

			e = it.next();
			interactions_DE = e.getElement();
			interactions = interactions_DE.getElement().getNivel();

			w = grafo.opposite(VI, e);
			if (!w.getElement().getVisited() && (interactions < 10)) {

				System.out.print(" ---" + interactions + "---> " + w.getID());
				sp.push(e);
				noEnd = pathDFS(grafo, w, VF, sp, isCorrect); // Recursive call to DFS
				if (noEnd) {
					sp.pop();
				}
			}
		}
		return noEnd;
	}

	
	/**
	    * ********************************************************************
	    * Method name: rebootGraph
	    * 
	    * Description of the Method: This method is to reboot the graph in order to be useful
	    * when we want to repeat actions like searchings paths in chapters B and C
	    * 
	    *
	    * Calling arguments: a graph
	    * 
	    * Return value: void. 
	    *
	    ********************************************************************
	    */
	public static void rebootGraph(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {
		Vertex<DecoratedElement<Superhero>> V;
		Iterator<Vertex<DecoratedElement<Superhero>>> ITE = g.getVertices();
		while (ITE.hasNext()) { // Vertex iterator traversal
			V = ITE.next();
			V.getElement().setVisited(false); // Vertex as no visited
			V.getElement().setParent(null); // Parent to null
			V.getElement().setDistance(0); // Distance to 0
		}
	}

	
	/**
	    * ********************************************************************
	    * Method name: pathDFS
	    * 
	    * Description of the Method: This method is used to set a team(path) between two nodes(super heros).
	    * This path is formed by super heros that has level of relation under 10. We have used DFS algorithm
	    * 
	    *
	    * Calling arguments: a graph 
	    * 
	    * Return value: void. Print on screen this path.
	    *
	    ********************************************************************
	    */
	public static void designTeam(Graph<DecoratedElement<Superhero>, DecoratedElement<Interaction>> g) {
		rebootGraph(g);
		String AInicial = ""; // Initial super hero
		String AFinal = ""; // Final super hero
		Vertex<DecoratedElement<Superhero>> VI;// Initial vertex
		Vertex<DecoratedElement<Superhero>> VF;// Final vertex
		Stack<Edge<DecoratedElement<Interaction>>> path1 = new Stack<Edge<DecoratedElement<Interaction>>>();
		String choose = "";
		boolean keep_going = true; // While true new search are allowed
		boolean keep_going2 = false; // To check incorrect options
		boolean noPath; // To know if there is path or no
		boolean validHeroes = true;

		do {
			System.out.println("Enter initial superhero: ");
			AInicial = teclado.nextLine();
			System.out.println("Enter final superhero: ");
			AFinal = teclado.nextLine();
			VI = g.getVertex(AInicial); // Initialize initial vertex
			VF = g.getVertex(AFinal); // Initialize final vertex
			if (VI == null || VF == null) { // Check if the super heros exists
				System.out.println("Please, enter valid superheroes.");
			} else if (VI.getID().equals(VF.getID())) { //  If initial super hero is the same as final super hero
				System.out.println("You have arrived ;) \n");
			} else {
				validHeroes = true;
				noPath = pathDFS(g, VI, VF, path1, validHeroes);
				if (noPath) {
					rebootGraph(g); // Reboot the graph for future search
					System.out.println("No path");
				}
			}

			rebootGraph(g);

			System.out.println();
			System.out.println("Do you want to do a new search? \nYES\nNO"); // To do a new search or not
			do {

				choose = teclado.nextLine();
				choose = choose.toUpperCase();
				if (choose.equals("YES")) {
					keep_going = true;
					keep_going2 = false;
				} else if (choose.equals("NO")) {
					keep_going = false;
					keep_going2 = false;
				} else {
					keep_going2 = true;
					System.out.println("Please, insert a valid option. ");
				}

			} while (keep_going2);

		} while (keep_going);

	}

}
