import java.io.File

var text: String = ""
var longestPal = ""
var length = 0

fun findPal(cur: String, start: Int, end: Int): String {

	if(end >= text.length || start < 0)
		return cur

	var newPal: String
	if(text[start] == text[end])                    // (Step 3.1)
		newPal = findPal(text[start] + cur + text[end], start - 1, end + 1)         // (Step 3.2)
	else
		return cur                                  // Returns the last found palindrome
	return newPal                                   //
}


fun findLongest() {

	if(text.isNotEmpty())
		longestPal = "" + text[0]
	else
		return

	/*
		There are 2 possibilities
		To find all palindromes the following method is applied
		Example: aba  The middle is b

		For palindromes with a final length that is odd
		1) Select 1 char starting from text[0] to text[text.length-1]
		3.1) and check if after adding the char to the left and right the new string is still a palindrome
		3.2) If it is then keep adding more chars
		4) Else check if the new palindrome is the longest currently found palindrome

		For palindromes with a final length that is even
		There must be 2 chars in the middle
		Example abba  The middle is bb

		2.1) Selects the ith and i+1th char in text where 0 <= i < text.length-2
		2.2) Check if the ith and i+1th char are the same, else they can not form the middle of the palindrome
		3) Follow step 3 through 4 from above


	Repeat until all potential middles have been tried

	 */


	for(i in 1..text.length) {
		if(i + 1 < text.length){                                  //  If the palindrom's middle is 1 char
			var attempt = findPal("" + text[i], i - 1, i + 1)           // (Step 1)
			if(attempt.length > length) {                          // Step 4
				length = attempt.length
				longestPal = attempt
			}
		}
		if(i <= text.length - 2) {              //  If the palindrom to be's middle is 2 chars
			if(text[i] == text[i + 1]) {        //  Then it checks the word             (Step 2.1 and 2.2)
				var attempt = findPal("" + text[i] + text[i + 1], i - 1, i + 2)
				if(attempt.length > length) {                   // Step 4
					length = attempt.length
					longestPal = attempt
				}
			}
		}

	}

	return
}

fun main(args: Array<String>) {
	val fileName: String = "C:\\Users\\Sancho Jimenez\\IdeaProjects\\School Code\\Palindrome\\src\\tom-sawyer.txt"

	text = File(fileName).readText(Charsets.UTF_8)
	var regex = Regex("[^a-zA-Z]")
	text = text.replace(regex, "").toLowerCase()

	findLongest()
	println("started")
	println(longestPal)
}