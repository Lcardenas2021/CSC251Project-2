import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Policy 
{
    // Policy fields
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Constructor
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, 
                  String smokingStatus, double height, double weight)
        {
           this.policyNumber = policyNumber;
           this.providerName = providerName;
           this.firstName = firstName;
           this.lastName = lastName;
           this.age = age;
           this.smokingStatus = smokingStatus;
           this.height = height;
           this.weight = weight;
       }

    // Getters for policy fields
    public int getPolicyNumber()
     {
        return policyNumber;
    }

    public String getProviderName() 
    {
        return providerName;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public int getAge() 
    {
        return age;
    }

    public String getSmokingStatus()
     {
        return smokingStatus;
    }

    public double getHeight() 
    {
        return height;
    }

    public double getWeight() 
    {
        return weight;
    }

    // Method to calculate BMI
    public double calculateBMI() 
    {
        double heightInMeters = height * 0.0254; // Convert height from inches to meters
        return weight / (heightInMeters * heightInMeters);
    }

    // Method to calculate policy price
    public double calculatePolicyPrice() 
    {
        double basePrice = 500.0;
        if (smokingStatus.equals("smoker")) 
        {
            return basePrice + 200.0;
        } 
        else 
        {
            return basePrice;
        }
    }
}
