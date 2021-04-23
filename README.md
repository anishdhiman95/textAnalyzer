# Text Analyzer

### Documentation
This is a Spring boot application that exposes APIs to analyze text documents. The following computations are supported:

* Number of distinct words in the document
* Number of times each distinct word appeared in the document.
* Number of Sentences in the document
* Number of paragraphs in the document.

**API Definition:**


> **POST:** /v1/analyze-text

> **Accepts:** Text Document (key="file")

> **Returns:** JSON


###Additional Information

**Design Pattern**
Command/Operation Design Pattern

**Performance:**

*Time: O(n)*

*Auxiliary Space: O(n) [worst case]*

**Libraries Used:** Common-lang

**Repository:** https://github.com/anishdhiman95/textAnalyzer 

**Reference:** https://www.webtools.services/text-analyzer


