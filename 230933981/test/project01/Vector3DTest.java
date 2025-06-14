package project01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector3DTest {

    @Test
    void testGetters(){
        Vector3D v = new Vector3D(3.0,2.0, 4.0);
        assertEquals(3.0, v.getX());
        assertEquals(2.0, v.getY());
        assertEquals(4.0, v.getZ());
    }

    @Test
    void testToString() {
        Vector3D v = new Vector3D(3.34545, 2.3345, 4.5643);
        assertEquals("(3.35, 2.33, 4.56)",v.toString());
    }

    @Test
    void testGetMagnitude() {
        Vector3D v = new Vector3D(2.0,2.0,1.0);
        assertEquals(3.0, v.getMagnitude());
    }

    @Test
    void testNormalize() {
        Vector3D v = new Vector3D(0.0,0.0,0.0);
        /*Vector3D normalized = v.normalize();
        assertEquals(2.0/3.0, normalized.getX()); */
        try {
            Vector3D normalized = v.normalize();
        } catch (IllegalStateException e) {
            System.out.println("Caught an IllegalStateException: " + e.getMessage());
        }

    }

    @Test
    void testAdd() {
        Vector3D v1 = new Vector3D(1.0,2.0,2.0);
        Vector3D v2 = new Vector3D(2.0,3.0,4.0);
        Vector3D sum = v1.add(v2);
        assertEquals(3.0, sum.getX());
        assertEquals(5.0, sum.getY());
        assertEquals(6.0, sum.getZ());
    }

    @Test
    void testMultiply() {
        Vector3D v = new Vector3D(1.0, 2.0,3.0);
        Vector3D constant = v.multiply(3.0);
        assertEquals(3.0,constant.getX());
        assertEquals(6.0,constant.getY());
        assertEquals(9.0,constant.getZ());
    }

    @Test
    void testDotProduct() {
        Vector3D v1 = new Vector3D(1.0,2.0,2.0);
        Vector3D v2 = new Vector3D(2.0,3.0,4.0);
        double dotProduct = v1.dotProduct(v2);
        assertEquals(16.0, dotProduct);
    }

    @Test
    void testAngleBetween() {
        Vector3D v1 = new Vector3D(0.0,0.0,0.0);
        Vector3D v2 = new Vector3D(0.0,1.0,1.0);
        /*double angle = v1.angleBetween(v2);
        System.out.println( "degree: " + angle );
        assertEquals(60.0, angle, 0.00001);
        public static void main(String[] args) {
            Vector3D v1 = new Vector3D(0, 0, 0);
            Vector3D v2 = new Vector3D(0, 0, 0); */
            try {
                double angle = v1.angleBetween(v2);
            } catch (IllegalStateException e) {
                System.out.println("Caught an IllegalStateException: " + e.getMessage());
            }
        }




    @Test
    void testCrossProduct() {
        Vector3D v1 = new Vector3D(1.0,1.0,0.0);
        Vector3D v2 = new Vector3D(0.0,1.0,1.0);
        Vector3D crossProduct = v1.crossProduct(v2);
        System.out.println("cross product: " + crossProduct.toString());
        assertEquals(1.0, crossProduct.getX());
        assertEquals(-1.0,crossProduct.getY());
        assertEquals(1.0,crossProduct.getZ());
    }


}

