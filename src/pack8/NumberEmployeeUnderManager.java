package pack8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Given a dictionary that contains mapping of employee and his manager like this
Dictionary<string, string> employees = new Dictionary<string, string>()
{
{ "A","C" },
{ "B","C" },
{ "C","F" },
{ "D","E" },
{ "E","F" },
{ "F","F" }
};
Write a function to get no of employees under each manager in the hierarchy not just their direct reports.
In the above dictionary the root node/ceo is listed as reporting to himself.
Output should be a Dictionary<string,int> that contains this
A - 0
B - 0
C - 2
D - 0
E - 1
F - 5
 */

/* Approach: This question might be solved differently but i followed this and found interesting, so sharing:
            1. Create a reverse map with Manager->DirectReportingEmployee combination. Offcourse employee will be multiple so Value in Map is List of String.
            2. Now use the given employee-manager map to iterate  and at the same time use newly reverse map to find the count of employees under manager.
            3. Use memorization(Dynamic programming) while finding number of employees under a manager so that we dont need to find number of employees again for any of the subemployee.
*/
public class NumberEmployeeUnderManager {

	public static void main(String[] args) 
	{
		Map<String, String> dataSet = new HashMap<String, String>();
		
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");
		/*
		dataSet.put("A", "A");
		dataSet.put("C", "E");
		dataSet.put("D", "E");
		dataSet.put("E", "A");
		dataSet.put("B", "D");
		dataSet.put("F", "B");
		*/
		populateEmployeeCountMap(dataSet);
		System.out.println("empCountMap= "+empCountMap);

	}
	
	static Map<String,Integer> empCountMap = new HashMap<String,Integer>();
	private static void populateEmployeeCountMap(Map<String, String> dataSet)
	{
		Map<String, List<String>> mngrEmpMap = new HashMap<String, List<String>>();//reverse the original map,each key will have 0 to multiple values
		for(Map.Entry<String,String> entry: dataSet.entrySet())
		{
			String emp=entry.getKey();
			String mngr=entry.getValue();
			if(!emp.equals(mngr))//excluding the ceo-ceo entry
			{
			List<String> directReportList = mngrEmpMap.get(mngr);
			if(directReportList==null)
				directReportList=new ArrayList<String>();
			directReportList.add(emp);
			mngrEmpMap.put(mngr,directReportList);
			//System.out.println("manager: "+mngr);
			//System.out.println("direct reports: "+directReportList);
			}
		}
		
		
		
		//Now use manager-Emp map built above to populate empCountMap with use of helper method
		for(String mngr: dataSet.keySet())//note- we are iterating over original emp-manager map and will use mngr-emp map in helper to get the count
		{
			
			getEmployeeCountMapHelper(mngr,mngrEmpMap);
		}
		
	}
	
	private static int getEmployeeCountMapHelper(String mngr, Map<String, List<String>> mngrEmpMap)
	{
		int count =0;
		if(!mngrEmpMap.containsKey(mngr))//means employee is not a manager of any other employee
		{
			empCountMap.put(mngr,0);
			return 0;
		}	
		else if(empCountMap.containsKey(mngr))
		{
			count = empCountMap.get(mngr);//this employee count already has been done by helper method, so avoid re-computation
		}
		else
		{
			List<String> directReportEmpList = mngrEmpMap.get(mngr);
			count = directReportEmpList.size();
			for(String directReportEmp: directReportEmpList)
			{
					int tmpCount = getEmployeeCountMapHelper(directReportEmp,mngrEmpMap);
					count= count + tmpCount;	
			}
			empCountMap.put(mngr,count);
		}
		return count;
	}


	
}
