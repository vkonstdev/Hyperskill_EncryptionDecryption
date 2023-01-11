## Encryption-Decryption
This is a training project from JetBrains Academy (Hyperskill).
Application that encrypts or decrypts a file or string using command line arguments and
two symmetric-key algorithms:
* "shift" - to shift the English letters using a rotational cipher by the amount of the key. Other characters (not letters) are not modified.  
* "unicode" - to shift all characters using the Unicode character sequence.
___
### Syntax
```
java Main -alg {shift|unicode} -mode {enc|dec} -key n -data "string data" -in filename -out outputfile
```
All the arguments are optional. The command line options -alg, -mode, -key, -data, -in, -out may be
specified in any order. The notation `-mode {enc|dec}` means that after the `-mode` option the next
argument must be either `enc` or `dec`, without the braces {}.
### Keywords

| Command line <br> parameters |                      Values                      | Default <br> values |
|:----------------------------:|:------------------------------------------------:|:-------------------:|
|             -key             | numbers from 0-2³¹-1 for shifting each character |          0          |
|            -mode             |   "enc" for encryption or "dec" for decryption   |        "enc"        |
|            -data             |          text to be encrypted/decrypted          |         ""          |
|             -in              |   path to input file to be encrypted/decrypted   |                     |
|             -out             |             name of the output file              |                     |
|             -alg             |         algorithm: "unicode" or "shift"          |       "shift"       |

1. If -out is omitted, data will be printed to console.
2. Requires at least one (-data or -in).
3. If there are both -data and -in arguments, the program prefers -data over -in.
___
### Usage examples
#### Example 1 - encryption with the shift algorithm (by default), output to console 
*Command:*
```
java Main -mode enc -key 5 -data "Welcome to hyperskill!"
```
*Output:*
```
Bjqhtrj yt mdujwxpnqq!
```
#### Example 2 - decryption with the shift algorithm (by default), output to console 
*Command:*
```
java Main -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!"
```
*Output:*
```
Welcome to hyperskill!
```
#### Example 3 - encryption with the unicode algorithm, output to console
*Command:*
```
java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
```
*Output:*
```
\jqhtrj%yt%m~ujwxpnqq&
```
#### Example 4 - encryption with the unicode algorithm 
*Command:*
```
java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 10 -alg unicode
```
This command gets data from road_to_treasure.txt,
encrypts the data with the key of 10, create protected.txt, and write ciphertext into it.
