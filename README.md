# Vector-3D
# Vector3D Project

A Java implementation of a 3D vector class with comprehensive mathematical operations.

## Project Overview

This project implements a `Vector3D` class that represents a 3-dimensional vector with support for common vector operations used in mathematics and physics. The implementation includes operations such as magnitude calculation, normalization, addition, multiplication, dot product, cross product, and angle calculations.


## Features

### Core Operations
- **Vector Creation**: Initialize vectors with x, y, z components
- **Component Access**: Get individual x, y, z values
- **String Representation**: Formatted output rounded to 2 decimal places
- **Magnitude Calculation**: Compute vector length using Euclidean norm
- **Normalization**: Create unit vectors (with zero vector exception handling)
- **Vector Addition**: Add two vectors component-wise
- **Scalar Multiplication**: Multiply vector by a constant
- **Dot Product**: Calculate scalar product of two vectors
- **Cross Product**: Compute vector perpendicular to two input vectors
- **Angle Calculation**: Find angle between vectors in degrees

### Error Handling
- `IllegalStateException` for operations on zero vectors (normalization, angle calculation)
- Proper exception handling with descriptive error messages

## Project Structure

```
project01/
├── src/
│   └── project01/
│       └── Vector3D.java
└── test/
    └── project01/
        └── Vector3DTest.java
```

## Installation & Usage

### Prerequisites
- Java 8 or higher
- JUnit 5 for running tests

### Running the Code

1. **Compile the project**:
   ```bash
   javac -cp . project01/Vector3D.java
   ```

2. **Run tests**:
   ```bash
   java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
   ```

### Basic Usage Example

```java
import project01.Vector3D;

public class Example {
    public static void main(String[] args) {
        // Create vectors
        Vector3D v1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D v2 = new Vector3D(4.0, 5.0, 6.0);
        
        // Basic operations
        System.out.println("v1: " + v1.toString()); // (1.00, 2.00, 3.00)
        System.out.println("Magnitude: " + v1.getMagnitude()); // 3.74
        
        // Vector operations
        Vector3D sum = v1.add(v2);
        Vector3D scaled = v1.multiply(2.0);
        double dot = v1.dotProduct(v2);
        Vector3D cross = v1.crossProduct(v2);
        
        // Normalization (handle exceptions)
        try {
            Vector3D normalized = v1.normalize();
            System.out.println("Normalized: " + normalized.toString());
        } catch (IllegalStateException e) {
            System.out.println("Cannot normalize zero vector");
        }
    }
}
```

## API Reference

### Constructor
```java
Vector3D(double x, double y, double z)
```
Creates a new 3D vector with specified components.

### Accessor Methods
```java
double getX()          // Returns x component
double getY()          // Returns y component  
double getZ()          // Returns z component
String toString()      // Returns "(x.xx, y.yy, z.zz)" format
```

### Mathematical Operations
```java
double getMagnitude()                    // Returns vector magnitude
Vector3D normalize()                     // Returns unit vector (throws exception for zero vector)
Vector3D add(Vector3D other)            // Returns sum of vectors
Vector3D multiply(double scalar)         // Returns scaled vector
double dotProduct(Vector3D other)        // Returns dot product
Vector3D crossProduct(Vector3D other)    // Returns cross product
double angleBetween(Vector3D other)      // Returns angle in degrees (throws exception for zero vectors)
```

## Testing

The project includes comprehensive JUnit tests covering:

- **Getter Methods**: Verify component access
- **String Formatting**: Check proper decimal formatting
- **Mathematical Operations**: Validate all vector operations
- **Exception Handling**: Test error conditions for zero vectors
- **Edge Cases**: Handle boundary conditions

### Test Coverage
-  Component getters
-  String representation with proper formatting
-  Magnitude calculation
-  Normalization with exception handling
-  Vector addition
-  Scalar multiplication
-  Dot product calculation
-  Cross product calculation
-  Angle calculation with exception handling

## Mathematical Background

### Vector Operations Implemented

1. **Magnitude**: |v| = √(x² + y² + z²)
2. **Normalization**: v̂ = v/|v|
3. **Addition**: v + w = (vₓ + wₓ, vᵧ + wᵧ, vᵤ + wᵤ)
4. **Scalar Multiplication**: cv = (cvₓ, cvᵧ, cvᵤ)
5. **Dot Product**: v · w = vₓwₓ + vᵧwᵧ + vᵤwᵤ
6. **Cross Product**: v × w = (vᵧwᵤ - vᵤwᵧ, vᵤwₓ - vₓwᵤ, vₓwᵧ - vᵧwₓ)
7. **Angle Between Vectors**: θ = arccos((v · w)/(|v||w|))

## Grading Results

**Final Score**: 100/100 points
- All autograder tests passed
- Proper exception handling implemented
- Clean, well-documented code
- Comprehensive test coverage

## Acknowledgments

- **Resources Used**:
  - [Stack Overflow - IllegalStateException usage](https://stackoverflow.com/questions/12698275/whats-the-intended-use-of-illegalstateexception)
  - [Java Math Documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
  - [Angle Between Vectors Reference](https://mathsathome.com/angle-between-two-vectors/)

## License

This project is part of coursework for CS5004 at Northeastern University.

---

*This implementation demonstrates object-oriented design principles, proper exception handling, and comprehensive testing practices in Java.*
