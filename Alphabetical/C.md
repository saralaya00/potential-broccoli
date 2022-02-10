## Carrots
![[carrots.gif]]
### Class in terms of Inheritance vs Composition
`Class`: a named concept in the domain space, with an optional superclass, defined as a set of fields and methods.  
`Field`: a named property of some type, which may reference another object (see composition)  
`Method`: a named function or procedure, with or without parameters, that implements some behavior for a class.

`Inheritance`: a class may inherit - use by default - the fields and methods of its superclass. Inheritance is transitive, so a class may inherit from another class which inherits from another class, and so on, up to a base class (typically Object, possibly implicit/absent). Subclasses may override some methods and/or fields to alter the default behavior.  
`Composition`: when a Field’s type is a class, the field will hold a reference to another object, thus creating an association relationship between them. Without getting into the nuances of the difference between simple association, aggregation, and composition, let’s intuitively define composition as when the class uses another object to provide some or all of its functionality.  
`Encapsulation`: by interacting with objects instead of directly with the implementation of methods and fields, we hide and protect the implementation of a class. If a consumer does not know anything about an object other than its public interface, then it cannot rely on any internal implementation details.  
[composition-vs-inheritance-how-choose](https://www.thoughtworks.com/insights/blog/composition-vs-inheritance-how-choose)  