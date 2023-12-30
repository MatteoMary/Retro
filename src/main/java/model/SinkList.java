package model;

public class SinkList<J> {
    private SeaNode<J> head; //reference to first node of list.
    private SeaNode<J> tail; //reference to last node of list.
    private int size; //represents the size of the list.

    public SinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(J value) {//J is generic, can be int, String etc. value is parameter.
        SeaNode<J> newSeaNode = new SeaNode<>(value);//creates new SeaNode with given value.
        if (head == null) { //if list is empty,
            head = newSeaNode;//sets head to newSeaNode.
        } else { //if not empty,
            tail.setNext(newSeaNode);//sets next field of tail node to newSeaNode,
            newSeaNode.setPrevious(tail);//and previous field of newSeaNode to tail.
        }
        tail = newSeaNode;//updates tail to newSeaNode.
        size++;//increment by 1.
    }

    public boolean remove(J value) {
        SeaNode<J> current = head; //initializes a SeaNode object "current" to head of list.
        while (current != null) {
            if (current.getValue().equals(value)) {
                SeaNode<J> prev = current.getPrevious(); //updates pointers of next/previous nodes
                SeaNode<J> next = current.getNext();//to remove the current node from the list.

                if (prev != null) {//if current node is not first node in list.
                    prev.setNext(next);//sets next pointer of prev node to the next node.
                } else {
                    head = next;//updates the head of the list to be the next node.
                }

                if (next != null) {//if current node is not the last node.
                    next.setPrevious(prev);//sets the previous pointer of the next node to the prev node.
                } else {
                    tail = prev;//updates the tail of the list to be the prev node.
                }
                size--;// size -1
                return true;
            }
            current = current.getNext();//updates current pointer to the next node in the list.
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean contains(J value) {
        SeaNode<J> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public J getHeadValue() {
        return (head!=null) ? head.getValue() : null;//"?" shorthand for if-else statement.
    }

    public J getNextValue(J currentValue) {
        SeaNode<J> current=head;
        while (current!=null) {
            if (current.getValue().equals(currentValue) && current.getNext()!=null) {
                return current.getNext().getValue();
            }
            current=current.getNext();
        }
        return null;
    }

    /**
     * SeaNode - nested static class
     * @param <J> generic value
     */
    private static class SeaNode<J>{
        private final J value; //marked as final means value held by the node cannot be changed.
        private SeaNode<J> next; //reference to the next node.
        private SeaNode<J> previous; //reference to the previous node.

        public SeaNode(J value) {
            this.value=value;
        }//the constructor

        public J getValue() {
            return value;
        }

        public SeaNode<J> getNext() {
            return next;
        }

        public SeaNode<J> getPrevious(){
            return previous;
        }

        public void setNext(SeaNode<J> next) {
            this.next=next;
        }

        public void setPrevious(SeaNode<J> previous) {
            this.previous=previous;
        }
    }


}
