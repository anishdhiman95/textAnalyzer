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

