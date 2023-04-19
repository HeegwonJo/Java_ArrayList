package org.example;

public class MyArrayList<T>{
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[0];
        this.size = 0;
    }


    public int size() {
        return this.size;
    }

    public boolean add(T item) {
        if (this.size == this.data.length) {
            this.resize();
        }
        this.data[this.size] = item;
        this.size++;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.data[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        T item = (T) this.data[index];
        for (int i = index; i < this.data.length-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.size--;
        return item;
    }

    private void resize() {
        Object[] newData = new Object[this.data.length + 1];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear(){
        this.data=new Object[0];
        this.size=0;
    }

    public int indexOf(T element1) {
        for(int i=0; i<this.size; i++){
            if(this.data[i].equals(element1)){
                return i;
            }
        }
        return -1;
    }
}