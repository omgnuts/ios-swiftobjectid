# ios-swiftobjectid

The XCODE interface builder is pretty good. But one thing really bugs me. The object ids are not human readable! Small projects are fine, but once you have to start merging, perform diffs and so on, it really becomes an eye sore.
Here’s small tool I made today to get rid of the oMg-fu-aPL


# What does it do?

Here’s a screenshot of how XCODE object ids look by default (the horror).


And here is how they look like after.


## To use

Copy the jar file above into your project directory. And run it with the following java command

```
java -jar readoi.jar
```
