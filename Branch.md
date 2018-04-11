# Branch description
## Overview
- _Parent-Child_ relationship is required: _Parent_ should always have a _Child_.
- _Parent_ and _Child_ use different IDs.
- _Parent-Child_ relationship is LAZY.

## Implementation
 - Generic lazy bidirectional `@OneToOne` with `@JoinColumn`

## Notes
- :exclamation: _Parent_ -> _Child_ is not LAZY. Moreover it issues a separate query for _Child_ when reading _Parent_.
- It's a bidirectional relationship, so both sides should be updated explicitly: a custom `Child(Parent parent)` constructor is required.
- "optional = false" results in a redundant update to Child when cascaded save
