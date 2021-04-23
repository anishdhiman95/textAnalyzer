# Text Analyzer

### Documentation
This is a Spring boot application that exposes APIs to analyze text documents. The following computations are supported:

* Number of distinct words in the document
* Number of times each distinct word appeared in the document.
* Number of Sentences in the document
* Number of paragraphs in the document.

### API Definition


> **POST:** /v1/analyze-text

> **Accepts:** Text Document (key="file")

> **Returns:** JSON

### Sample API Call

#### INSTRUCTIONS

**TESTING:**

1. Clone the repository into you local and import it into thee IDEE of your Choice as a Maven Project.
2. Import the "postmanCollection.json" into your postman. There are sample file that are present in "src/test/resources/testFiles" that can be used for the purpose of testing. Upload the file as a key-value pair onto Postman. Make sure to use key name "file". 
3. Run maven clean install in the IDE.
4. Start the application as a Java Application, choosing "TextAnalyzerApplication.java" as the main class.
5. Use Postman to hit the localhost endpoint and Voila!

**EXTENDING FUNCTIONALITY**
Since the code is using a Command Design Pattern, on can implement additional Logic by simply implementing TextProcessor.java Interface and adding it to the processor list.
For the purpose of logging, Aspects have been introduced that mark the start and end of a Proessor class.

#### COVERAGE
This component has >90% UT coverage and heavily relies on the Unit Test Cases for Teesting and Quality. The class TextAnalyzerControllerTest.java has multiple test cases that covers corner cases like Unicode, case sensitivity and repetition.

<img width="1099" alt="Screen Shot 2021-04-23 at 9 13 44 AM" src="https://user-images.githubusercontent.com/20809306/115899923-3aef6200-a414-11eb-9b48-561a406e6373.png">

### Additional Information

#### Design Pattern
Command/Operation Design Pattern

#### Performance:

*Time: O(n)*

*Auxiliary Space: O(n) [worst case]*

#### Libraries Used:
* commons-lang:commons-lang:2.6
* junit:junit:4.13.2
* Spring Framework Libraries


#### Reference
https://www.webtools.services/text-analyzer

