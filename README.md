# SimpleEncoding

## Overview

`EncodeUtil` provides a simple **run-length encoding** function for strings.

The `encode()` function replaces consecutive occurrences of the same character with the character followed by the number of consecutive occurrences.

For example:

```
Input:  wwwwaaadeexxxxxx
Output: w4a3d1e2x6
```

The encoding is designed so that the original value can be recreated if a corresponding decoding function is implemented.

## Encoding Rules

### Regular characters

Each character is followed by the number of consecutive occurrences.

For example:

```
Input:  aaabbc
Output: a3b2c1
```

The groups are:

```
aaa → a3
bb  → b2
c   → c1
```

### Digits

Digits require special handling because the encoded format uses numbers to represent the number of occurrences.

A digit is therefore prefixed with `dg`.

For example:

```
Input:  112233
Output: dg12dg22dg32
```

This means:

```
dg1 2
dg2 2
dg3 2
```

The `dg` prefix makes it possible to distinguish the original digit from the occurrence count.

### Mixed input

For example:

```
Input:  aa111bb22
Output: a2dg13b2dg22
```

This represents:

```
aa   → a2
111  → dg13
bb   → b2
22   → dg22
```

## Examples

| Input | Output |
| --- | --- |
| `wwwwaaadexxxxxx` | `w4a3d1e1x6` |
| `aaabbc` | `a3b2c1` |
| `112233` | `dg12dg22dg32` |
| `aa111bb22` | `a2dg13b2dg22` |
| `a` | `a1` |
| `aaaaa` | `a5` |
| `abcd` | `a1b1c1d1` |
| `""` | `""` |
| `null` | `""` |