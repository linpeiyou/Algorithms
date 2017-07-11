/******************************************************************************
 *  Compilation:  javac DrawListener.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  Interface that accompanies Draw.java.
 ******************************************************************************/
package com.algo.util;

public interface DrawListener {
    void mousePressed(double x, double y);
    void mouseDragged(double x, double y);
    void mouseReleased(double x, double y);
    void keyTyped(char c);
}
