# Java Calculator

A java calculator to learn how to create a interpreter. To try the interpreter, type code in ``test.calc``.
**No error handling**, the interpreter may crash or enter an infinite loop if the syntaxe is incorrect.

## Features

- Basic operators: ``+``, ``-``, ``*``, ``/``, ``=``
- Define and call meta function
- Variables

## Metafunction

A *metafunction* is a function accessible in the langage but defined out of it. 
For example, ``print()`` is a *metafunction* that allow you to write a number in the console.
This function is define in the class ``calculator.environnement.functions.Print``.

To create a *metafunction*, create class that extends ``calculator.nodes.Block``, and override ``Node interpret(Context context)``.

## Context

``Context`` is a class that stores numbers, functions and metafunctions in a map using string as a key. 

## Exemple 

```
test = 5
test = test * 3
print(2 * test)
```