/*
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 

Example 1:

Input: url = "https://leetcode.com/problems/design-tinyurl"
Output: "https://leetcode.com/problems/design-tinyurl"

Explanation:
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after decoding it.
*/

/*
Steps:
Use a HashMap to store the mapping between an ID and the original URL.
Maintain an Integer counter that increments with each new URL.
To encode a URL, map it with the current counter value and increment the counter.
To decode, simply retrieve the URL from the HashMap using the ID.
*/

public class Codec {
    private HashMap<Integer, String> map = new HashMap<>();
    private int id = 0;
    private static final String BASE_URL = "http://tinyurl.com/";

    public String encode(String longUrl) {
        // Store the long URL with current id
        map.put(id, longUrl);
        // Create a tiny URL by appending id to base URL and return it
        return BASE_URL + id++;
    }

    public String decode(String shortUrl) {
        // Extract the id from the short URL
        int id = Integer.parseInt(shortUrl.replace(BASE_URL, ""));
        // Get the long URL using the id from the map
        return map.get(id);
    }
}

/*
Time Complexity: O(1) for both encode and decode methods.
Space Complexity: O(N), where N is the number of URLs encoded. We store each URL once.
*/
