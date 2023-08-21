This project contains a test designed in a data driven automation framework structure.
There is 1 test added to the "Tests" package(SeleniumStarterProjects\Selenium_DataDrivenAutomationFramework\src\Tests) which performs actions for multiple departments in amazon by taking input from an excel file.
"AmazonTestCases" - This testcase script performs the following actions-
	1) Login to amazon.com
	2) Navigate to 'Today's Deals'
	3) Select a department 
	4) Click on the first item
	5) Click on the first subitem
	6) Add the item to cart

- The "DataProvider" method "getdata" fetches data from an excel and passes on to the test method in step 3.
	
Note: The xpaths are subject to changes as Amazon website is dynamic and the content changes on daily basis.