package useful;
import java.util.LinkedList;
import java.util.HashMap;

public class ConvertFromBin
{
	private String binary, hex, decimal, temp1, temp2;
	private LinkedList<String> list;
	private HashMap<String, String> hexMap, decimalMap;
	
	/**Accepts an 8-bit binary as a string
	 * 	More malleable as a string
	 */
	public ConvertFromBin()
	{
		this.binary = "";
		createHexTable();
		createDecimalTable();
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
		createDecimalTable();
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
	/**Establishes a 4-bit combination which maps to the proper decimal value
	 */
	private void createDecimalTable()
	{
		decimalMap = new HashMap<String, String>();
		decimalMap.put("0000", "0");
		decimalMap.put("0001", "1");
		decimalMap.put("0010", "2");
		decimalMap.put("0011", "3");
		decimalMap.put("0100", "4");
		decimalMap.put("0101", "5");
		decimalMap.put("0110", "6");
		decimalMap.put("0111", "7");
		decimalMap.put("1000", "8");
		decimalMap.put("1001", "9");
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
		String temp1 = "";
		String temp2 = "";
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
		decimal = "";
		temp1 = "";
		temp2 = "";
		for(int i=0; i<list.size()/2; i++)
			temp1 += list.get(i);		
		for(int j=list.size()/2; j<list.size(); j++)
			temp2 += list.get(j);
		if(decimalMap.containsKey(temp1)&&decimalMap.containsKey(temp2))
		{
			decimal += decimalMap.get(temp1);
			decimal += decimalMap.get(temp2);
		}
		else
			System.out.println("Invalid Character Input");
		return decimal;
	}
	/**Converts the binary representation to ascii
	 * @param binary
	 * @return
	 */
	public String toAscii(String binary)
	{
		decimal = toDecimal(binary);
		int tempNum = Integer.parseInt(decimal);
		char ascii = (char)tempNum;
		return Character.toString(ascii);
	}
	
	public String getBinary()
	{
		return this.binary;
	}
}






