package entities;

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
    public SalariedEmployee(String firstName, String lastName,  
    		 String socialSecurityNumber, double weeklySalary) { 
      super(firstName, lastName, socialSecurityNumber);  
      if (weeklySalary < 0.0) 
    	  throw new IllegalArgumentException( 
    			  "Weekly salary must be >= 0.0"); 
 this.weeklySalary = weeklySalary; 
   }  // configura o sal?rio 
    public void setWeeklySalary(double weeklySalary){
	   if (weeklySalary < 0.0) 
		   throw new IllegalArgumentException( 
				   "Weekly salary must be >= 0.0"); 
	   this.weeklySalary = weeklySalary;     } 
   // retorna o sal?rio 
   public double getWeeklySalary() { 
	   return weeklySalary; 
	   }  
   // calcula os rendimentos; sobrescreve o m?todo earnings em Employee  
   @Override                                                         
   public double earnings()                                          
   {                   
	  return getWeeklySalary();    
	
   }                                                                  
 // retorna a representa??o String do objeto SalariedEmployee 
   @Override                                                    
   public String toString()                                    
   {                                                          
	      return String.format("salaried employee: %s%n%s: $%,.2f", 
	    		  super.toString(), "weekly salary", getWeeklySalary());
	      }

}
