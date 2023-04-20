package org.example;

public class MyArrayList<T>{
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[10];
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
    public void add(int index, T element) {
        // index가 유효한지 확인하고, 필요한 경우 capacity를 늘립니다.
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // index 위치에 element를 추가하고, 뒤쪽의 element들을 한 칸씩 뒤로 이동합니다.
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
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
        Object[] newData = new Object[this.data.length *2];
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

    public int indexOf(T element) {
        for(int i=0; i<this.size; i++){
            if(this.data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element){
        for(int i =0; i<this.size; i++){
            if(this.data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
}