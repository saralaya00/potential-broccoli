13?76??343

// pass any string input
// replace questions with any number
// that should be divisible by 3
// 13?76??343
// hint: Sum of all digits / 3
// []
String num = args[0] ;
Integer sum = 0;

//List<Integer> questionPos = new ArrayList<>();
for (int i = 0; i < num.length; i++) {
    if (num.indexOf(i) == '?') {
        questionPos.add(i);
    }
}

for (int i = 0; i <= 9; i++) {

}