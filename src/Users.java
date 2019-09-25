public class Users {
    private String Name;
    private String CompanyName;
    private int Age;
    private String Email;
    private String Password;

    public String getName(){
        return Name;
    }

    public String getCompanyName(){
        return CompanyName;
    }
    public int getAge(){
        return Age;
    }
    public String getEmail(){
        return Email;
    }
    public String getPassword(){
        return Password;
    }
    public void setName(String name){
        Name=Name;

    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setAge(int age) {
        Age = age;
    }
    public Users(String Name,String CompanyName,int Age){
        this.Name =Name;
        this.CompanyName =CompanyName;
        this.Age =Age;
        this.Email =createUserEmail();
        this.Password =createUserPassword();
    }
    public String createUserEmail(){
        return String.format("%s_%d@%s.com",getName().toLowerCase(),getAge(),getCompanyName().toLowerCase());
    }
    public String createUserPassword(){
        StringBuilder sb=new StringBuilder();

        sb.append(generateRandomCharacter());
        for(int i=0;i<4;i++){
            sb.append(generateRandomIntegerFromLimit(10));
        }
        sb.append(getFirst5CharactersFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();
    }
    public int generateRandomIntegerFromLimit(int limit){
        return (int)(Math.random()*limit);
    }
    private char generateRandomCharacter(){
        int randomNumberupto26=generateRandomIntegerFromLimit(26);
        return (char)('a'+randomNumberupto26);
    }
    private String getFirst5CharactersFromUserName(){
        if(getName().length()<5){
            int difference=5-getName().length();
            StringBuilder tempName=new StringBuilder(getName());
            for(int i=0;i<difference;i++){
                tempName.append("0");
            }
            return tempName.toString();
        }
        else
            return getName().substring(0,5);
    }
    private char generateRandomSpecialSymbol(){
        char[]specialSymbols={'!','@','#','$','%','^','&','*','(',')','{','}','[',']','\\',';',':','?','.','<','>'};
        int randomInteger=generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }
}
class UsersEntry
{
    public static void main(String[] args) {
        Users obj =new Users("Kartik","Microsoft",20);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}
