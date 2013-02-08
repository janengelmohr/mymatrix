/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymatrix;

import java.util.*;
/**
 *
 * @author jan
 */
public interface Matrix<E> {
    int getRowCount();
    int getColumnCount();
    int getObjectCount();
    int getDistinctObjectCount();
    Iterator<E> iterator();
    E get(int row, int column);
    boolean contains(E object);
    E put(int row, int column, E object);
}
