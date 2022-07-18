package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K,V> {

    Object[] Keys;
    Object[] Values;
    int size;

    HashMap(){
        Keys = new Object[100];
        Values = new Object[100];
        size = 0;
    }

    void put(K Key, V Value) {

        if(isContain(Key)){
            int tmpKeyIdx = getKeyIndex(Key);
            Values[tmpKeyIdx] = Value;
            return;

        }


        if(isFull()){
            Object newArr1[] = new Object[Keys.length*2];
            System.arraycopy(Keys, 0, newArr1, 0, Keys.length);
            Keys = newArr1;

            Object newArr2[] = new Object[Values.length*2];
            System.arraycopy(Values, 0, newArr2, 0, Values.length);
            Values = newArr2;
        }

        Keys[size] = Key;
        Values[size] = Value;
        size++;
    }

    public V get(K Key) {
        if(!isContain(Key)) {
            System.out.println("해당 키가 없습니다.");
            return null;
        }


        for(int i = 0; i < size; i++){
            if(Keys[i].equals(Key)) return (V) Values[i];
        }

        return null;

    }

    public void remove(K Key) {
        if(!isContain(Key)){
            System.out.println("삭제할 키가 없습니다.");
            return;
        }

        int tmpKeyIdx = getKeyIndex(Key);

        for(int i = tmpKeyIdx; i < size-1; i++){
            Keys[i] = Keys[i+1];
            Values[i] = Values[i+1];
        }

        Keys[size-1] = null;
        Values[--size] = null;


    }

    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();

        for(int i = 0; i < size; i++) keySet.add((K) Keys[i]);

        return keySet;
    }

    public int size() {
        return size;
    }

    int getKeyIndex(K Key){
        for(int i = 0; i < size; i++){
            if(Keys[i].equals(Key)) return i;
        }

        return -1;
    }

    boolean isFull(){
        if(size == Keys.length-1) return true;
        return false;
    }

    boolean isContain(K Key){

        for(int i = 0; i < size; i++) if(Keys[i].equals(Key)) return true;
        return false;
    }



}

class 원숭이{
    String name;

    원숭이(String name){
        this.name = name;
    }

    void 묘기를_부리다() {
        System.out.println("원숭이가 묘기를 부립니다.");
    }
}

class 사람{
    String name;

    사람(String name){
        this.name = name;
    }

    void 말하다() {
        System.out.println("사람이 말합니다.");
    }
}