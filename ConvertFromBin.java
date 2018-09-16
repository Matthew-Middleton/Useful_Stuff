package useful;
import java.util.LinkedList;
import java.util.HashMap;

public class ConvertFromBin
{
	private String binary, hex, temp1, temp2;
	private LinkedList<String> list;
	private HashMap<String, String> hexMap;
	
	/**Accepts an 8-bit binary as a string
	 * 	More malleable as a string
	 */
	public ConvertFromBin()
	{
		this.binary = "";
		createHexTable();
		list = new LinkedList<String>();
	}
	/**Accepts an 8-bit binary as a string
	 * 	More malleable as a string
	 * @param binary
	 */
	public ConvertFromBin(String binary)
	{
		this.binary = binary;
		createHexTable();
		list = new LinkedList<String>();
	}
	/**Establishes a 4-bit combination which maps to the proper hex value
	 * Key = binary
	 * Value = hex
	 */
	private void createHexTable()
	{
		hexMap = new HashMap<String, String>();
		hexMap.put("0000", "0");
		hexMap.put("0001", "1");
		hexMap.put("0010", "2");
		hexMap.put("0011", "3");
		hexMap.put("0100", "4");
		hexMap.put("0101", "5");
		hexMap.put("0110", "6");
		hexMap.put("0111", "7");
		hexMap.put("1000", "8");
		hexMap.put("1001", "9");
		hexMap.put("1010", "A");
		hexMap.put("1011", "B");
		hexMap.put("1100", "C");
		hexMap.put("1101", "D");
		hexMap.put("1110", "E");
		hexMap.put("1111", "F");
	}
	/**Changes the string into a linked list so it may be more easily manipulated
	 * @param binary
	 * @return
	 */
	private LinkedList<String> toList(String binary)
	{
		for(int i=0; i<binary.length(); i++)
		{
			list.add(binary.substring(i, i+1));
		}
		return list;
	}
	/**Converts the binary representation into hex
	 * @param binary
	 * @return
	 */
	public String toHex(String binary)
	{
		toList(binary);
		hex = "";
		temp1 = "";
		temp2 = "";
		for(int i=0; i<list.size()/2; i++)
			temp1 += list.get(i);		
		for(int j=list.size()/2; j<list.size(); j++)
			temp2 += list.get(j);		
		if(hexMap.containsKey(temp1)&&hexMap.containsKey(temp2))
		{
			hex += hexMap.get(temp1);
			hex += hexMap.get(temp2);
		}
		else
			System.out.println("Invalid Character Input");
		return hex;
	}
	/**Converts the binary representation to decimal
	 * @param binary
	 * @return
	 */
	public String toDecimal(String binary)
	{
		toList(binary);
		int dec = 0;
		for(int i=0; i<list.size(); i++)
		{
			dec += Integer.parseInt(list.get(i))*(Math.pow((double)2, (double)list.size()-(i+1)));
			if(list.size()==i)
				dec += Integer.parseInt(list.get(i))*(Math.pow((double)2, (double)list.size()-i));
		}
		return Integer.toString(dec);
	}
	/**Converts the binary representation to ascii
	 * 	takes decimal string, parses it into an int value, then casts it as a char value, before returning the string representation
	 * @param binary
	 * @return
	 */
	public String toAscii(String binary)
	{
		return Character.toString((char)Integer.parseInt(toDecimal(binary)));
	}
	/**Returns the binary string that was originally entered
	 * @return
	 */
	public String getBinary()
	{
		return this.binary;
	}
}






