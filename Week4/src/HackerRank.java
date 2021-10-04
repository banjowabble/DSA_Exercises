public class HackerRank {
    /**
     * print a linked list to stdout.
     * @param head head of the linked list
     */
    static void printLinkedList(SinglyLinkedListNode head) {
        for (SinglyLinkedListNode p = head; p != null; p = p.next) {
            System.out.println (p.data);
        }
    }

    /**
     * insert a new node at a linked list's tail.
     * @param head head of the linked list
     * @param data data of the new node
     * @return head of the new list
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode p = head;
        if (head != null) {
            for (; p.next != null; p = p.next){}
            SinglyLinkedListNode newtail = new SinglyLinkedListNode(data);
            p.next = newtail;
        }
        else {
            head = new SinglyLinkedListNode (data);
        }
        return head;
    }

    /**
     * insert a new node at head of the linked list.
     * @param llist head of the linked list
     * @param data data of the new node
     * @return head of the new list
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
        newHead.next = llist;
        llist = newHead;
        return llist;
    }

    /**
     * insert a new node at a position in a linked list.
     * @param llist head of the linked list
     * @param data data of the new node
     * @param position position that needs to be added
     * @return head of the new list
     */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode oldPos = llist;
        SinglyLinkedListNode p = llist;
        for (int i = 0; i < position ; i++) {
            oldPos = oldPos.next;
        }
        for (int i = 1; i < position; i++) {
            p = p.next;
        }
        p.next = newNode;
        newNode.next = oldPos;
        return llist;
    }

    /**
     * delete a node at a specific position.
     * @param llist head of the linked list
     * @param position position that needs to be removed
     * @return head of the new list
     */
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (position != 0) {
            SinglyLinkedListNode p = llist;
            SinglyLinkedListNode q = llist;
            for (int i = 0; i < position ; i++) {
                q = q.next;
            }
            for (int i = 0; i < position - 1; i++) {
                p = p.next;
            }
            p.next = q.next;
            return llist;
        }
        else {
            llist = llist.next;
        }
        return llist;
    }

    /**
     * print in reverse a linked list.
     * @param llist head of the linked list
     */
    public static void reversePrint(SinglyLinkedListNode llist) {
        if (llist == null) return;
        reversePrint (llist.next);
        System.out.println(llist.data);
    }

    /**
     * reverse a linked list.
     * @param llist head of the linked list
     * @return head of the new list
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        llist = prev;
        return llist;
    }
}
