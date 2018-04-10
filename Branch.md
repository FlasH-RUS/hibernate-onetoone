# Branch description
## Overview
- _Parent-Child_ relationship is required: _Parent_ should always have a _Child_.
- _Parent_ and _Child_ share the same ID.

## Implementation
 - _Child_ contains `@OneToOne` with `@Id` for the _parent_ field. No explicit ID therefore.
 - _Parent_ initializes its _child_ field explicitly upon creation.

## Notes
- _Child_ should implement Serializable.
- Can't simply create a `ChildRepository` with _Child-Long_ or _Child-Parent_ generics: results in "This class [class com.example.hibernateplayground.Child] does not define an IdClass" exception
- It's a bidirectional relationship, so both sides should be updated explicitly: a custom `Child(Parent parent)` constructor is required.
- "optional = false" results in NPE when trying to save _Parent_ - the "required" relationship should be enforced by DB then (if DB is not Hibernate-generated).
