public String reverseString (String input){
  char[] chars = input.toCharArray();
  int left = 0;
  int right = chars.length-1;
while(left < right){
  char temp = chars[left];
  chars[left] = chars[right];
  chars[right] = temp;

  left++;
  right--;
}
return new String(chars);
}



public void swapNumbers(int a, int b){    //10, 5
  a = a+b;        //a=15 b = 5
  b=a-b;          //a=15 b=10
  a=a-b;          //a=5, b=10
  System.out.println(a=" +a+ ", "b=" +b);
}


public Map<String, Integer> countWords(String input){
  Map<String, Integer> wordCount = new HashMap<>();
  Sitring[] words = input.split("\\s+");

for (word: words)
{
  wordCount.put(word, wordCount.getorDefault(word,0) + 1);
  }
return wordCount;
}


public void iterateHashMap(Map<String, String> map) { 
// Using advanced for-loop 
for (Map.Entry<String, String> entry : map.entrySet()) { 
System.out.println(entry.getKey() + " -> " + entry.getValue()); 
} 
// Using while-loop with iterator 
Iterator<Map.Entry<String, String>> iterator = 
map.entrySet().iterator(); 
while (iterator.hasNext()) { 
Map.Entry<String, String> entry = iterator.next(); 
System.out.println(entry.getKey() + " -> " + entry.getValue()); 
} 
}


public boolean isPrime(int num) {
  if(num<=1) return false;
for(int i=2; i< Math.sqrt(num); i++){
  if( num % i ==0){
    return false;
  }
}
  return true;
}



public boolean isPalindrome (String input){
  int left = 0; right = input.length-1;
  while(left<right){
    if(input.charAt(left) != input.charAt(right)) {
      return false;
    }
    left++;
    right--;
  }
  return true;
}


public int fibonacci(int num) {
  if(num<=1) return num;
rturn 9fibonacci(num-1) + fibonacci(num-2);


public void findDuplicates(String input){
  HashMap<Character, Integer> charCount = new HashMap<>();
for(char c: input.toCharArray()) {
  charCount.put(char, char.getOrDefault(c, 0) + 1);
}
for(Map.Entry<Character, Integer> entry: charCount.entrySet()){
  if(entry.getValue() > 1){
    System.out.println(entry.getKey() + "Appeared" + entry.getValue() + "times");
  }
}
}


public int secondHighest(int[] nums) { 
int highest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE; 
for (int num : nums) { 
if (num > highest) { 
secondHighest = highest; 
highest = num; 
} else if (num > secondHighest && num != highest) { 
secondHighest = num; 
} 
} 
return secondHighest; 
} 

public String removeWhitespaces(String input) { 
StringBuilder result = new StringBuilder(); 
for (int i = 0; i < input.length(); i++) { 
if (input.charAt(i) != ' ') { 
result.append(input.charAt(i)); 
} 
} 
return result.toString(); 
}
