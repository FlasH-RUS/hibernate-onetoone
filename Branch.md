# Branch description
## Overview
- _Parent-Child_ relationship is required: _Parent_ should always have a _Child_.
- _Parent_ and _Child_ use different IDs.
- _Parent-Child_ relationship is LAZY.

## Implementation
 - Generic lazy bidirectional `@OneToOne` with `@JoinColumn`

## Notes
- It's a bidirectional relationship, so both sides should be updated explicitly: a custom `Child(Parent parent)` constructor is required.
- "optional = false" results in a redundant update to Child when cascaded save
