/*********************************************************************
 *
 * Class Name: Interaction Author/s name: José Carlos Gualo Cejudo, Santiago
 * Juan León Galán, Juan Manuel Porrero Almansa Release/Creation date:
 * 20/11/2019 Class version: 1.0 Class description: This class is used to
 * represent the level of relationship keept in the edges
 *
 **********************************************************************
 */
public class Interaction {
	private int nivel;

	/*********************************************************************
	 *
	 * Method name: Interaction
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the constructor of this class
	 *
	 * Calling arguments: An integer called "nivel", which represent the level of
	 * interactions between the heroes
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public Interaction(String nivel) {
		this.nivel = toInt(nivel);
	}

	/*********************************************************************
	 *
	 * Method name: getNivel
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the getter of the nivel attribute
	 *
	 * Calling arguments: No calling arguments
	 * 
	 * Return value: An integer of the "nivel" attribute
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public int getNivel() {
		return nivel;
	}

	/*********************************************************************
	 *
	 * Method name: setNivel
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This is the setter of the nivel attribute
	 *
	 * Calling arguments: An integer called "nivel", which represents the level of
	 * interactions between heroes
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/*********************************************************************
	 *
	 * Method name: toInt
	 *
	 * Name of the original author (if the module author is different than the
	 * author of the file): José Carlos Gualo Cejudo, Santiago Juan León Galán, Juan
	 * Manuel Porrero Almansa
	 *
	 * Description of the Method: This method is used to pass from a string to an
	 * integer
	 *
	 * Calling arguments: A string that represents the string of text that we want
	 * to transform to integer called "texto"
	 *
	 * Return value: An integer called result, that represent the number already
	 * transformed
	 *
	 * Required Files: No files required
	 *
	 * No checked exceptions
	 *
	 *********************************************************************/
	public int toInt(String texto) {
		int result = 0;
		for (int i = 0; i < texto.length(); i++) {
			result = result * 10 + texto.charAt(i) - '0';
		}

		return result;
	}
}
