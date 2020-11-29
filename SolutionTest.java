public class SolutionTest{
	public static void main(String[] args) { 
    Solution<String,Integer> show = new Solution<String,Integer>();
        show.put("ABDUL",1);
        System.out.println(show.get("ABDUL"));
        show.put("HRITHIK",2);
        show.put("SAI",3);
        show.put("SAMAL",6);
        System.out.println(show.get("SAI"));
        show.put("TASHI",4);
        System.out.println("Size Of The Tree is " + show.size());
        System.out.println("Minimum Key From The key is " + show.min());
        System.out.println(show.floor("HRITHIK"));
        System.out.println(show.floor("HAHA"));
        System.out.println(show.keys("ABDUL","TASHI"));
        show.put("CHIMI",5);
        show.put("SAMAL",4);
        System.out.println(show.get("SAMAL"));
        show.put("NIMA",7);
        System.out.println("Size Of The Tree is " + show.size());
        System.out.println(show.floor("CHIMA"));
      
        show.put("SONAM",8);
        System.out.println(show.keys("ABDUL","TASHI"));

        
        
        

       

       
    }
}