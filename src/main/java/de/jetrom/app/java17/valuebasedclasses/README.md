# Example of Deprecation warning for Value-Based Classes

Following primitive wrapper classes are designated as value-based classes to encode immutable objects:
* java.lang.Byte
* java.lang.Short
* java.lang.Integer
* java.lang.Long
* java.lang.Float
* java.lang.Double
* java.lang.Boolean
* java.lang.Character

The constructors of these classes are deprecated and should not be used. 

[JEP 390: Warnings for Value-Based Classes](https://openjdk.java.net/jeps/390)
