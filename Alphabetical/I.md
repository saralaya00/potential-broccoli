## I
![[d70c5e3e-709c-4ddd-93e1-95dfcc3d0739.gif]]
### Interfaces form a contract between the class and the outside world
Implementing an interface allows a class to become more formal about the behavior it promises to provide. Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler. If your class claims to implement an interface, all methods defined by that interface must appear in its source code before the class will successfully compile.  
[docs.oracle.com - interface](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)  

### The purpose of inheritance
Inheritance serves two purposes, semantics and mechanics.  
`Inheritance Semantics `: Inheritance captures semantics (meaning) in a classification hierarchy (a taxonomy), arranging concepts from generalized to specialized, grouping related concepts in subtrees, and so on. The semantics of a class are mostly captured in its interface, the set of messages to which it responds, but a portion of the semantics also resides in the set of messages that the class sends.

`Inheritance Mechanics`: Inheritance captures mechanics by encoding the representation of the data (fields) and behavior (methods) of a class and making it available for reuse and augmentation in subclasses. Mechanically, the subclass will inherit the implementation of the superclass and thus also its interface.  
[composition-vs-inheritance-how-choose](https://www.thoughtworks.com/insights/blog/composition-vs-inheritance-how-choose)  


### Misuse of Inheritance
`How to Misuse Inheritance - Example 1`  
Author shows a Stack implementation with Stack class extending ArrayList can become bloated with methods inherited from ArrayList.  
`Semantic misuse`: where stack is supposed to be conceptual constraint of Last In First Out on a Data Structure  
`Mechanic misuse`: using ArrayList to hold the stack’s object collection is an implementation choice that should be hidden from consumers  

[composition-vs-inheritance-how-choose](https://www.thoughtworks.com/insights/blog/composition-vs-inheritance-how-choose)  