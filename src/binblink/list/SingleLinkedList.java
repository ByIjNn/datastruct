package binblink.list;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SingleLinkedList<T> {

    private Node<T> firstNode;

    private  Node<T> lastNode;

     int size;

    public SingleLinkedList(){

    }

    public int size(){
        return size;
    }
    private class Node<T>{

        T element;
        Node<T> nextNode;

        Node(T element,Node<T> nextnode){
            this.element = element;
            this.nextNode = nextnode;
        }
    }

    public void add(T e){
        linkNode(e);
    }

    public boolean remove(T e){
        Node<T> prenode = firstNode;
        if(e == null){
            for (Node<T> x = firstNode; x != null; x = x.nextNode) {
                if (x.element == null) {
                    prenode  = x;
                }
            }
            unlinkNode(prenode);
            return true;
        }
        for (Node<T> x = firstNode; x != null; x = x.nextNode) {
                if (e.equals(x.element)) {
                    prenode = x ;
                }
        }
        unlinkNode(prenode);
        return true;

    }

    public boolean havenext(T e){
        boolean has = false;
        for (Node<T> x = firstNode; x != null; x = x.nextNode) {
            if (e.equals(x.element)) {
                if(x.nextNode != null){
                    has = true;
                }
            }
        }
        return has;
    }

    public  T getnext(T e){

        T ele = null;
        for (Node<T> x = firstNode; x != null; x = x.nextNode) {
            if (e.equals(x.element)) {
                if(havenext(x.element)){
                    ele = x.nextNode.element;
                }
            }
        }
        if(ele == null){
            throw new NoSuchElementException();
        }
        return ele;
    }

    public T get(int index){

        checkIndex(index);

        return getNode(index).element;
    }

    private Node<T> getNode(int index){

            Node<T> n = firstNode;

            for (int i = 1; i <index ; i++) {
                n = n.nextNode;
            }
            return n;


    }


    public T getFirst(){

        final  Node<T> f = firstNode;
        if(f == null){
           throw new NoSuchElementException();
        }
        return f.element;
    }


    private void checkIndex(int index){
        if(index<=0||index>size){
            throw new IndexOutOfBoundsException();
        }
    }




    private void linkNode(T e){

         final  Node<T> tempNode = lastNode;

         final Node<T> newNode = new Node<T>(e,null);

         lastNode = newNode;

         if(firstNode == null){
                firstNode = newNode;
         }else {
             tempNode.nextNode = newNode;
         }
         size++;
    }

    private void unlinkNode(Node<T> prenode){

        if(prenode == firstNode){
            firstNode = null;
            return ;
        }
        Node<T> tempNode = prenode.nextNode;
        prenode.nextNode = prenode.nextNode.nextNode;
        tempNode = null;
        size--;
    }

    private void insertNode(Node<T> prenode,T e){

        Node<T> node = new Node<T>(e,null);
        Node<T> tempnode = prenode.nextNode;
        prenode.nextNode = node;
        node.nextNode = tempnode;
    }


}
