/**
 * Observer interface has an update method
 * @author Burhan ELGUN
 *
 */
public interface Observer {
	/**
	 * updates the contents
	 * @param fitnessValue fitness vale
	 * @param versionType version type
	 * @param iteration itereration count
	 */
	public void update(double fitnessValue,String versionType,String iteration);
}
