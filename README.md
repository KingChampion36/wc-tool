# wc-tool

**Coding Challenge:** https://codingchallenges.fyi/challenges/challenge-wc/

## Linux `wc` command

The functional requirements for wc are concisely described by it’s man page - give it a go in your local terminal now:

```shell
man wc
```

### Size of a file

```shell
wc -c test.txt
```

### Number of lines in a file

```shell
wc -l test.txt
```

### Number of words in a file

```shell
wc -w test.txt
```

### Number of characters in a file

```shell
wc -m test.txt
```

## Compile and Run

### Compile

```shell
javac WC.java
```

### Run

#### 1. Size of a file

```shell
java WC -c test.txt
```

#### 2. Number of lines in a file

```shell
java WC -l test.txt
```

#### 3. Number of words in a file

```shell
java WC -w test.txt
```

#### 4. Number of characters in a file

```shell
java WC -m test.txt
```

#### 5. Default option

```shell
java WC test.txt
```

#### 6. No file name is specified (Take user input in this case) and print size

```shell
java WC -c
```

#### 7. No file name is specified (Take user input in this case) and print number of lines

```shell
java WC -l
```

#### 8. No file name is specified (Take user input in this case) and print number of words

```shell
java WC -w
```

#### 9. No file name is specified (Take user input in this case) and print number of characters

```shell
java WC -m
```

#### 10. No file name is specified (Take user input in this case) and default behaviour

```shell
java WC
```
