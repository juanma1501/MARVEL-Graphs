
/*********************************************************************
*
* Class Name: DecoratedElement
* Author/s name: José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan Manuel Porrero Almansa
* Release/Creation date: 20/11/2019
* Class version: 1.0
* Class description: This class is used to asign values and attributes to the different elements
*
**********************************************************************
*/
import graphsDSESIUCLM.Element;

public class DecoratedElement<T> implements Element {
	private T element;
	private String id;
	private DecoratedElement<T> parent;
	private boolean visited;
	private int distance;

	/*********************************************************************
	 *
	 * Method name:DecoratedElement
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the constructor of this class
	 *
	 * Calling arguments: A string that represents the id of the element called
	 * "id", and th type of the decorated element called "Element"
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public DecoratedElement(String id, T element) {
		this.element = element;
		this.id = id;
		visited = false;
		parent = null;
		distance = 1;
	}

	/*********************************************************************
	 *
	 * Method getID
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the getter of the id attribute.
	 *
	 * Calling arguments: No calling arguments
	 * 
	 * Return value: A string which represents the id of the decorated element
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	@Override
	public String getID() {
		return this.id;
	}

	/*********************************************************************
	 *
	 * Method name: setID
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the setter of the id attribute.
	 *
	 * Calling arguments: A string that represents the new id of the element called
	 * "id".
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setID(String id) {
		this.id = id;
	}

	/*********************************************************************
	 *
	 * Method name:DecoratedElement
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is a different constructor of this class
	 *
	 * Calling arguments: The type of the decorated element called "Element"
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public DecoratedElement(T element) {
		this.id = element.toString();
		this.element = element;
	}

	/*********************************************************************
	 *
	 * Method name: getElement
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the getter of the "element" attribute.
	 *
	 * Calling arguments: No calling arguments
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public T getElement() {
		return this.element;
	}

	/*********************************************************************
	 *
	 * Method name: getParent
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: A getter of the parent of the type.
	 *
	 * Calling arguments: A string that represents the id of the element called
	 * "id", and th type of the decorated element called "Element"
	 *
	 * Return value: A decorated element of any type.
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public DecoratedElement<T> getParent() {
		return this.parent;
	}

	/*********************************************************************
	 *
	 * Method name: setParent
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the setter of the parent type of the
	 * decorated element
	 *
	 * Calling arguments: A decorated element of any type called parent
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setParent(DecoratedElement<T> parent) {
		this.parent = parent;
	}

	/*********************************************************************
	 *
	 * Method name: getVisited
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the constructor of this class
	 *
	 * Calling arguments: No calling arguments
	 *
	 * Return value: A boolean called "visited", which represents if it has been
	 * visited or not.
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public boolean getVisited() {
		return this.visited;
	}

	/*********************************************************************
	 *
	 * Method name: setVisited
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the setter of the visited attribute.
	 *
	 * Calling arguments: A boolean called "v", which represents the new state
	 * (visited or not), of the decorated element
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setVisited(boolean v) {
		this.visited = v;
	}

	/*********************************************************************
	 *
	 * Method name: getDistance
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the getter of the distance attribute
	 *
	 * Calling arguments: No calling arguments
	 * 
	 * Return value: An integer called distance.
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public int getDistance() {
		return this.distance;
	}

	/*********************************************************************
	 *
	 * Method name: setDistance
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the setter of the distance attribute
	 *
	 * Calling arguments: An integer called "distance" which represents the new
	 * distance of the decorated element
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/*********************************************************************
	 *
	 * Method name: equals
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This method is used to check if two vertices are
	 * equal or not. The element and the id must be the same. We use a cast.
	 *
	 * Calling arguments: An object n
	 * 
	 * Return value: A boolean variable that represents if the object is the same or
	 * not.
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public boolean equals(Object n) {
		return (id.equals(((DecoratedElement) n).getID())
				&& element.equals(((DecoratedElement<Element>) n).getElement()));

	}

}