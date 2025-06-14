/**
 * Yunyu Guo 5004 Project1 Jan 20 2024
 * Acknowledge: Q5. https://stackoverflow.com/questions/12698275/whats-the-intended-use-of-illegalstateexception
 * Q9 https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
 * https://mathsathome.com/angle-between-two-vectors/
 */

package project01;

/**
 * Write a class Vector3D that represents a 3D vector.
 */
public class Vector3D {
    private double x,y,z;

    /**
     * 1.A constructor that takes in x, y, z components of the vector.
     * Each parameter is of type double.
     */
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 2.Methods to get the values of individual components
     */
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }

    /**
     * 3.A toString method that returns a string that describes this vector.
     * This string should be of the form “(x, y, z)” replacing the letters with their values.
     * Each component should be formatted to round to exactly two decimal places.
     */
    public String toString(){
        return String.format("(%.2f, %.2f, %.2f)", this.x, this.y, this.z);
    }

    /**
     * 4.A method getMagnitude that returns its magnitude.
     * Magnitude: for vector v this is denoted as|v| = square root of (x^2 + y^2 + z^2)
     */
    public double getMagnitude(){
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     * 5.A method normalize that returns a normalized version of this vector.
     * It should throw an IllegalStateException object if this operation cannot be completed.
     * Normalizing a vector: this is a vector that is obtained by dividing each component of a vector
     * by its magnitude.
     */
    public Vector3D normalize(){
        double magnitude = getMagnitude();
        if (magnitude == 0.0){
            throw new IllegalStateException("cannot divided by 0");
        }
        return new Vector3D(this.x/magnitude, this.y/magnitude, this.z/magnitude);
    }

    /**
     * 6.A method add that returns the result of adding this vector to another vector.
     * It should not change the vectors that are being added.
     */
    public Vector3D add(Vector3D v){
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    /**
     * 7.A method multiply that returns the result of multiplying this vector by a constant.
     * It should not change the vector that is being multiplied.
     */
    public Vector3D multiply(double constant){
        return new Vector3D(this.x * constant, this.y * constant, this.z * constant);
    }

    /**
     * 8.A method dotProduct that returns the dot product of this vector and another vector.
     * It should not change the two vectors
     * Dot product: The dot product of two vectors v * w = vx * wx + vy * wy + vz * wz
     */

    public double dotProduct(Vector3D w) {
        return this.x * w.x + this.y * w.y + this.z * w.z;
    }

    /**
     * 9.A method angleBetween that returns the angle between two vectors in degrees.
     * It should not change the two vectors.
     * It should throw an IllegalStateException if this operation cannot be completed.
     * Angle between two vectors: cos() = v*w/|v|*|w|.
     *  Technically, given two vectors, there are two angles between them.
     *  This returns the smaller of the two angles.
     */
    public double angleBetween (Vector3D w) {
        double dotProduct = this.dotProduct(w);
        double magnitudes = this.getMagnitude() * w.getMagnitude();
        if (magnitudes == 0.0) {
            throw new IllegalStateException("cannot divided by 0 magnitude");
        }
        double radian = Math.acos(dotProduct / magnitudes);//Math.acos gives the angle in radians.
        double degree = Math.toDegrees(radian);
        return Math.min(degree, 360 - degree);
    }

    /**
     * 10.A method crossProduct that returns the cross product of this vector and another vector.
     * It should not change the two vectors.
     * ux = vywz - vzwy
     * uy = vzwx - vxwz
     * uz = vxwy - vywx
     */
    public Vector3D crossProduct(Vector3D w){
        return new Vector3D(
                this.y * w.z - this.z * w.y,
                this.z * w.x - this.x * w.z,
                this.x * w.y - this.y * w.x
                );

    }


}