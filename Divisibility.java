/***************************************************************************************************************\
 * Determines the divisibility of two values by either the greatest common divisor or the least common multiple

 ***************************************************************************************************************/
package useful;
//not complete
public class Divisibility
{
	public Divisibility()
	{
		
	}
	/**Computes the greatest common divisor by the Euclidean Algorithm
	 * @param lowest
	 * @param highest
	 * @return
	 */
	public int gcd(int lowest, int highest)
	{
		while(highest!=0)
		{
			int temp = highest;
			highest = lowest%highest;
			lowest = temp;
		}
		return lowest;
	}
	
	public int gcdRecursive(int lowest, int highest)
	{
		if(highest==0)
			return lowest;
		return gcdRecursive( highest, lowest%highest);
	}
	
	/**Computes the least common multiple
	 * @param lowest
	 * @param highest
	 * @return
	 */
	public int lcm(int lowest, int highest)
	{
		return (lowest*highest)/gcd(lowest, highest);
	}
}
