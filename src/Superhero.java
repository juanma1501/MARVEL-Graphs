
/*********************************************************************
*
* Class Name: Superhero
* Author/s name: José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan Manuel Porrero Almansa
* Release/Creation date: 20/11/2019
* Class version: 1.0
* Class description: 
*
**********************************************************************
*/
import java.util.List;

public class Superhero {

	String name;

	/*********************************************************************
	 *
	 * Method name: Superhero
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is an empty constructor of this class
	 *
	 * Calling arguments: No calling arguments
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public Superhero() {
	}

	/*********************************************************************
	 *
	 * Method name: Interaction
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is a constructor of this class
	 *
	 * Calling arguments: An String called "name", which represents the name of the
	 * super-hero
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public Superhero(String name) {
		this.name = name;
	}

	/*********************************************************************
	 *
	 * Method name: getName
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is a getter of "name" attribute.
	 *
	 * Calling arguments: No calling arguments
	 *
	 * Return value: A string with the value of the variable "name".
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public String getName() {
		return name;
	}

	/*********************************************************************
	 *
	 * Method name: setName
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is a setter of "name attribute", in order to
	 * change the value of the variable
	 *
	 * Calling arguments: A string called "name", which represents the new value of
	 * the variable "name".
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setName(String name) {
		this.name = name;
	}

	/*********************************************************************
	 *
	 * Method name: toString
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This method returns the value of the variable
	 * "name" as a string
	 *
	 * Calling arguments: No calling arguments
	 *
	 * Return value: A string with the value of the variable "name".
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public String toString() {
		return name;
	}

	/*********************************************************************
	 *
	 * Method name: hashCode to recover the hash code assigned
	 *********************************************************************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*********************************************************************
	 *
	 * Method name: equals
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This method compares two objects to see if the are
	 * identical
	 *
	 * Calling arguments: An object called "obj", which represent the object which
	 * will be compared
	 *
	 * Return value: A boolean value which turns true if the compared superheroes
	 * are equal
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superhero other = (Superhero) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*********************************************************************
	 *
	 * Method name: constainsSuperheroInList
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This method is used to check if a superhero is in
	 * the list of superheroes or not
	 *
	 * Calling arguments: A list which contains the superheroes
	 *
	 * Return value: A boolean value which turns true if the superheroe is in the
	 * list
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public boolean constainsSuperheroInList(List<Superhero> superhero_list) {
		boolean isInList = false;
		for (int i = 0; i < superhero_list.size() && isInList == false; i++) {
			if (superhero_list.get(i).getName().equals(this.getName())) {
				isInList = true;
			}
		}
		return isInList;
	}

}
