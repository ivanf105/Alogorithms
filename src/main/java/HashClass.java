import java.util.HashMap;

public class HashClass {
    HashMap<String,String> hm;
    public void recursion(int count){
        System.out.println(count);
        //base case
        if(count < 1 ){
            return;
        }
        //Counter
        recursion(count -1);
    }
    public void hashMethod(){
       hm = new HashMap<String,String>();
       //Add key & values to hash map
       hm.put("Illinois","Chicago");
       hm.put("Illinois","Dallas");
       hm.put("california","Los Angeles");
        System.out.print(hm.get("Illinois"));
       //Prints values: Chicago, Dallas, Los Angeles
       for(String i:hm.values()){
            System.out.println(i+", ");
       }
       //prints both key value pair
       for(String i: hm.keySet()){
           System.out.println("Key: "+i +" Value: "+ hm.get(i));
       }
    }

    public boolean isomorphicCode(String s,String t){
        //Saving each string is separate char arrays
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //creating 2 different hash maps to map both string characters to each other
        HashMap<Character,Character> h = new HashMap<Character,Character>();
        HashMap<Character,Character> h2 = new HashMap<Character,Character>();
        try{
            //loop through char array
            for(int i =0;i<= ch1.length -1;i++){
                //if there is no mapping to either string character in hash map
                //then it will map each char in string to each other
                if(h.get(ch1[i])==null && h2.get(ch2[i])== null){
                    h.put(ch1[i],ch2[i]);
                    h2.put(ch2[i],ch1[i]);
                    System.out.println("i: "+ i +", "+h.get(ch1[i])+", Char1: "+ ch1[i] +" "+", Char2: "+ ch2[i] );
                }
                // else if mapping from either string char doesn't equal current char in iteration loop,
                // it will return false
                else if(h.get(ch1[i])!= ch2[i] || h2.get(ch2[i])!= ch1[i]){
                    return false;
                }
            }
        //If one key char ONLY is null from either hash map after first null check
            // Then it will throw exception in above else if statement
            //this will catch null comparison and return false
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        //Convert both strings to char arrays
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //total sum will have num of occurences when a
        //character is string 1 meatchs string 2 with the correct order
        int total_sum =0;
        //pointer will belong to string 2 and will only
        //increment j+1 when there is a char match in string1 and string2
        int pointer =0;
        for(int i=0;i<ch1.length;i++){
            //j is set to pointer, which will be the index of string 2 when
            // there is a matching character
            for(int j=pointer;j<ch2.length;j++){
                //if there is a matching character,
                //total sum is incremented
                //and pointer is moved to next index
                //so next loop when checking match for next string1 char,
                //string2 loop will start at pointer
                if(ch1[i]==ch2[j] ){
                    total_sum+=1;
                    pointer=j+1;
                    break;
                }
            }
        }
        //if all string1 chars match correctly to string2
        //It is a subsequence
        if(total_sum==ch1.length){
            return true;
        }
        return false;
    }
}
