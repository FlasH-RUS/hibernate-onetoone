# Branch description
## Overview
- _Parent-Child_ relationship is optional: _Parent_ may have no corresponding _Child_.
- _Parent_ and _Child_ share the same ID.

## Implementation
 - _Child_ contains `@OneToOne` with `@MapsId` for the _parent_ field + a standalone _id_ field.

## Notes
- It's a bidirectional relationship, so both sides should be updated explicitly: a custom `Parent.setChild(..)` method is required.
