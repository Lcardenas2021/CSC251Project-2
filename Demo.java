import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   
/**
   This program insures the policies for each member
   of the users' selection and provider holder.
*/

class Demo 
{
   public static void main(String[] args) 
   {
      // Read policy information from file
      Policy[] policies = readPoliciesFromFile("CSC251Project/PolicyInformation.txt");
   
      // Display policy information
      for (Policy policy : policies) 
      {
         displayPolicyInformation(policy);
      }
   
      // Display the number of smokers and non-smokers
      int smokerCount = countSmokers(policies);
      int nonSmokerCount = policies.length - smokerCount;
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }

   // Method to read policy information from file
   private static Policy[] readPoliciesFromFile(String filename) 
   {
      Policy[] policies = null;
      try {
         File file = new File(filename);
         Scanner scanner = new Scanner(file);
      
         int policyCount = 0;
         while (scanner.hasNextLine()) 
         {
            scanner.nextLine();
            policyCount++;
         }
      
         scanner.close();
      
         policies = new Policy[policyCount];
         scanner = new Scanner(file);
      
         int index = 0;
         while (scanner.hasNextLine()) 
         {
            int policyNumber = Integer.parseInt(scanner.nextLine());
            String providerName = scanner.nextLine();
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String smokingStatus = scanner.nextLine();
            double height = Double.parseDouble(scanner.nextLine());
            double weight = Double.parseDouble(scanner.nextLine());
         
            policies[index] = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus,
                   height, weight);
         
            index++;
         }
      
         scanner.close();
      } 
      catch (FileNotFoundException e) 
      {
         e.printStackTrace();
      }
   
      return policies;
   }

   // Method to display policy information
   private static void displayPolicyInformation(Policy policy) 
   {
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder's First Name: " + policy.getFirstName());
      System.out.println("Policyholder's Last Name: " + policy.getLastName());
      System.out.println("Policyholder's Age: " + policy.getAge());
      System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
      System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
      System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
      System.out.println("Policyholder's BMI: " + policy.calculateBMI());
      System.out.println("Policy Price: $" + policy.calculatePolicyPrice());
      System.out.println();
   }

   // Method to count the number of smokers
   private static int countSmokers(Policy[] policies) 
   {
      int count = 0;
      for (Policy policy : policies) {
         if (policy.getSmokingStatus().equals("smoker")) 
         {
            count++;
         }
      }
      return count;
   }
}