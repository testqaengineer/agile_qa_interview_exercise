# GIVEN -->> github expectations for Interview Exercise (Agile QA role)
Clone this repo in your private git space. Once done, please add github username: shilpa-sethi as a collaborator/ reviewer.
While submitting please ensure to add a README explaining how to run the test and all related info.

## GIVEN -->> Testing Task
Product Owner wants a feature as described below. The developer has added the code and share with you as a QA for review/ testing.

### GIVEN -->> Feature
As a user I want to be able to add a list of strings.
I want to see the number of vowels in each of the strings that I have entered.

### GIVEN -->> Acceptance Criteria
1. I should see the number of vowels and consonant for each string in the order they are keyed in.
2. I should be able to add up to 4 strings at once.

### DONE -->> Reviewed the user story and prepared a list of questions/ assumptions.
-- FeatureDescription::
As a user I want to be able to add a list of strings. I want to see the number of vowels
in each of the strings that I have entered.
-- Acceptance Criteria::
I should see the number of vowels and consonant for each string in the order they are keyed in.
I should be able to add up to 4 strings at once.

CommonInfoDescription::
==>> Need add Lombok Plugin to IDEA and enable it
==>> AC - AcceptanceCriteria
==>> US - UserStory
==>> B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, X, and Z. - cons
==>> vowels in English: A, E, I, O, U, and sometimes W and Y. https://bit.ly/3wyktkX

COLLECTED List of questions/assumptions::
1) What does it mean in US TO_SEE "I want to see the number of vowels" - is it console only?? System.out ONLY or other ways? -- clarification of requirements?
2) What does it mean in US TO_ADD "to be able to add a list of strings" - where to add? reader/writer?? -- additional requirements?
3) Is it matter - List<String> listStr or String[] strings because in one place of AC I see
   "As a user I want to be able to add a list of strings" in other place of AC I see "each string array passed" BECAUSE 
   for List<String> listStr and for String[] strArr we should have diff methods -- clarification of requirements?
4) We have problem with Y&W requirements because -- as minimum absent clarification, so
   what should we do with Y and even W for cases when it is like Vowel and when it is like Consonant -- additional requirements?
5) What about other languages? Not only English? We have diff numbers of vowels and consonants in other languages.. -- additional requirements?
6) What about additional requirements -- punctuation marks, special characters, line feeds, and similar in every string
7) ""if (args.length >= 4)"" is it correct?? Because in AC I see "I should be able to add up to 4 strings at once" 
What we expect - exception? or just log.info that we have more strings then 4 -- clarification of requirements?
8) Requirements for strings length? My assumptions it can be long
9) Can be this strings as a sentences/poems/books like several words with spaces/spec.symbols between words in every string?
10) Should we check it if String null.. -- additional requirements?

### Reviewed the code and provided feedback/ improvements.
1) IMPROVED added lombok and annotations for the class CountResult
2) IMPROVED added JUnit5 and removed Main/main Class/methood
3) IMPROVED added @Slf4j and log.info instead system.out.. (we can see in class CountExecutor)
4) IMPROVED added builder to class CountResult and change methods of class VowelCounter
5) IMPROVED changed logic of getStringsWithNumbersOfVowelAndConsonant(String[] args) to map and collect
6) IMPROVED added assertJ libs and asserAll JUnit possibilities in tests to do it like softAssertations

### Extended the program to return the number of consonants for each string array passed.
1) Added and improved code getConsonantCount(String input) 
2) Make this and similar methods so that it return long

### Used BDD/ Cucumber additional layer for both vowels and consonants.

### Reported any bugs you find. Include as much information as necessary and add the feedback 
### as a file to the repo along with the Cucumber Test Report.
1) REGEX_BUG because this regex caseSensitive -- we should change regex aeiou to aeiouAEIOU - FIXED and I added 
   as assumption Y and R additionally
2) CODE_DEFECT - why we need wrapper Integer type - I change it to long everywhere FIXED
3) CODE_DEFECT Anyway return null if (args.length >= 4) - it is wrong; Best way to use -- new ArrayList<>() 
   as EmptyList -->> FIXED I added throw new RuntimeException

### Bonus points if you can add failing test cases for the bugs you find.*/
1) Exist for Y and W cases
2) Exist with string which contains special characters
3) Exist for String which null

## Evaluation Points
1. Use of Git.
2. Use of BDD/TDD/Cucumber.
3. Code Review skills.
4. Coding skills.
5. Test Case Coverage.

