// Given a list of integers, return a list containing only even numbers. 

List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
List<Integer> evenNumbers = numbers.stream()
                                  .filter(n-> n%2==0)
                                  .collect(Collectors.toList());


//Find the maximum value in a list of integers. 

Optional<Integer> maxNumber = numbers.stream()
                                      .max(Integer::compare);


//Calculate the sum of elements in a list of integers. 
int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

//Convert all strings in a list to uppercase.  
List<String> names = Arrays.asList("Alice", "Bob", "Charlie")
List<String> upperNames = names.stream()
                              .map(String::toUpperCase)
                              .collect(Collectors.toList());

//Sort a list of integers in ascending order.
List<Integer> sortedNumber = numbers.stream()
                                    .sorted()
                                    .collect(Collectors.toList());


//Count the number of elements in a list that are greater than 5.
long count = numbers.stream()
                    .filter(n-> n > 5)
                    .count();

//Reduce a list of integers to their sum.
int total = numbers.stream()
                  .reduce(0,Integer::sum);

//Return any element from a list of integers. 
Optional<Integer> anyElement = numbers.stream().findAny();

//Extract first names from a list of full names. 
List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");
List<String> firstNames = fullNames.stream()
                                    .map(name-> name.spilt(" ")[0])
                                    .collect(Collectors.toList())

//Check if all numbers in a list are positive. 
boolean allPositive = numbers.stream()
                            .allMatch(n-> n>0);

// Check if there are no negative numbers in a list.  
boolean allPositive = numbers.stream()
                            .noneMatch(n-> n>0);

// Find the first element in a list of integers. 
boolean allPositive = numbers.stream()
                            .findFirst();

//Flatten a nested list structure.  

List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
List<Integer> flatList = nestedNumbers.stream()
                                      .flatMap(List::stream)
                                      .collect(Collectors.toList());


//Group users by age.
Map<Integer, List<User>> usersByAge = users.stream()
  .collect(Collectors.groupBy(User::getAge));

//Print elements of a stream during processing without altering the stream. 
List<Integer> printNumbers = numbers.stream()
                                    .peek(Systsem.out::println)
                                    .collect(Collectors.toList());

//Limit the output to the first 3 elements of the list. 
List<Integer> limited = numbers.stream()
                              .limit(3)
                              .collect(Collectors.toList());

//Skip the first 2 elements of a list and return the rest.  
List<Integer> skipped = numbers.stream()
                                .skip(2)
                                .collect(Collectors.toList());

//Convert to Set
List<Integer> convertSet = numbers.stream()
                                  .collect(Collectors.toSet());

// Get summary statistics for a list of integers.  
IntSummaryStatistics stats = numbers.stream() 
                                    .mapToInt(Integer::intValue) 
                                    .summaryStatistics();
