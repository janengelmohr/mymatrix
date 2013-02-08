/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymatrix;

import java.util.HashMap;
import java.util.Map;
import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author jan
 */
public class MyMatrix<E> implements Matrix<E> {

    private Map<Point, E> m = new HashMap<Point, E>();
    private int numberRows=0;
    private int numberColumns=0;
    
    public MyMatrix() {
    }
    
    public int getRowCount() {
        return numberRows;
    }
    
    public int getColumnCount() {
        return numberColumns;
    }
    
    @Override
    public int getDistinctObjectCount() {
        Collection<E> derp = m.values();
        Set<E> halp = new HashSet<E>();
        for(E object : derp) {
            halp.add(object);
        }
        return halp.size();
    }
    public int getObjectCount() {
        return m.size();
    }
    
    
    public Iterator<E> iterator() {
        return new DepthFirstIterator<E>();
    }
    
    
    public E put(int keyRow, int keyColumn, E object) {
        Point p = new Point(keyRow, keyColumn);
        if(numberRows<keyRow) {
            numberRows = keyRow+1;
        }
        if(numberColumns<keyColumn) {
            numberColumns = keyColumn+1;
        }
        if(m.containsKey(p)) {
            if(m.get(p)!=null) {
                E temp = m.get(p);
                m.put(p, object);
                return temp;
            }
        }
        m.put(p, object);
        return null;
    }
    
    public E get(int keyRow, int keyColumn) throws IllegalArgumentException {
        Point p = new Point(keyRow, keyColumn); 
            if(m.containsKey(p)) {
                return m.get(p);
            }
            else if(keyRow>=numberRows&&keyColumn>=numberColumns) {
                return null;
            }
            else {
        throw new IllegalArgumentException();
            }
    }


    @Override
    public boolean contains(E object) {
        return m.containsValue(object);
    }
    
    public class DepthFirstIterator<E1> implements Iterator<E> {
    
    int x,y;
    E next;
    
    public DepthFirstIterator() {
        x=0;
        y=0;
        next=null;
    }
    
    @Override
    public boolean hasNext() {
       for(;x<numberColumns;x++) {
           for(;y<numberRows;) {
            Point p = new Point(x,y);
                y++;
               if(m.containsKey(p)&&(m.get(p)!=null)) {
                   next = m.get(p);
                   return true;
               }
           }
           y=0;
       }
       return false;
    }
    
    @Override
    public E next() {
        return next;
    }
    
    @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }
    }
    
}