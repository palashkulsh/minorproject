package aadhar.main;

/**
	Class for creating tokens
*/
public class Tokens{
	private StringBuffer rtn = new StringBuffer("");
	/**
		String array to hold the tokens
	*/
	private String[] col;
	private String row;
	
	public Tokens(String values)
	{
		row = values;
		row = values.replaceAll(" ","_" );
		col = row.split(",");
	}
	
	/**
		function to append all male related information in a single string
	*/
	private void getMale(){
		/**
			variable:	genAadhar =1 if Aadhar card generated; =0 if Aadhar card not generated 
						age => to store the age of the aadhar user
						emailProvided =1 if user provided his/her email else =0
						mobProvided =1 if user provided his/her mobile number else =0
		*/
		int genAadhar=0;
		int age=0;
		int emailProvided=0;
		int mobProvided=0;
		
		try{
			genAadhar = Integer.parseInt(col[8]);
			age = Integer.parseInt(col[7]);
			emailProvided = Integer.parseInt(col[10]);
			mobProvided = Integer.parseInt(col[11]);
		}catch(Exception e){}
			
		if(col[6].equalsIgnoreCase("M"))
		{
			rtn = rtn.append("Total-M");
			
			if(genAadhar == 1)
			{
				rtn = rtn.append(",Generated-M");

				rtn = rtn.append(",").append(col[2]).append("-M");
				
				if(emailProvided == 1)
				{
					rtn = rtn.append(",").append(col[2]).append("-M-Email");
				}
				
				if(mobProvided == 1)
				{
					rtn = rtn.append(",").append(col[2]).append("-M-Mob");
				}
				
				if(age <= 20)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp1-M");
				}else if(20 < age && age <= 60)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp2-M");
				}else if(60 < age)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp3-M");
				}
			}else
			{
				rtn = rtn.append(",NonGenerated-M");
			}
		}
	}
	
	/**
		function to append all female related information in a single string
	*/
	private void getFemale(){

		/**
			variable:	genAadhar =1 if Aadhar card generated; =0 if Aadhar card not generated 
						age => to store the age of the aadhar user
						emailProvided =1 if user provided his/her email else =0
						mobProvided =1 if user provided his/her mobile number else =0
		*/
		int genAadhar=0;
		int age=0;
		int emailProvided=0;
		int mobProvided=0;
		
		try{
			genAadhar = Integer.parseInt(col[8]);
			age = Integer.parseInt(col[7]);
			emailProvided = Integer.parseInt(col[10]);
			mobProvided = Integer.parseInt(col[11]);
		}catch(Exception e){}
		
		if(col[6].equalsIgnoreCase("F"))
		{
			rtn = rtn.append("Total-F");
			
			if(genAadhar == 1)
			{
				rtn = rtn.append(",Generated-F");
				
				rtn = rtn.append(",").append(col[2]).append("-F");
				
				if(emailProvided == 1)
				{
					rtn = rtn.append(",").append(col[2]).append("-F-Email");
				}
				
				if(mobProvided == 1)
				{
					rtn = rtn.append(",").append(col[2]).append("-F-Mob");
				}
				
				if(age <= 20)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp1-F");
				}else if(20 < age && age <= 60)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp2-F");
				}else if(60 < age)
				{
					rtn = rtn.append(",").append(col[2]).append("-AgeGrp3-F");
				}
			}else
			{
				rtn = rtn.append(",NonGenerated-F");
			}
		}
	}
	
	/**
		function to be called for getting all male and female information in a single string
	*/
	public String getString(){
		getMale();
		getFemale();
		return rtn.toString();
	}
}
