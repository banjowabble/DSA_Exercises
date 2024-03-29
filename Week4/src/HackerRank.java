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
        SinglyLinkedListNode prev = llist;
        for (int i = 0; i < position - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
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

    /**
     * compare two linked list.
     * @param head1 head of the first list
     * @param head2 head of the second list
     * @return boolean check
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p1 = head1;
        SinglyLinkedListNode p2 = head2;
        while(p1 != null && p2 != null && p1.data == p2.data) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == p2;
    }

    /**
     * merge two sorted lists.
     * @param head1 head of the first list
     * @param head2 head of the second list
     * @return head of the newly merged list
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode result;
        if (head1 == null) return head2;
        else if (head2 == null) return head1;

        if (head1.data >= head2.data)
        {
            result = head2;
            result.next = mergeLists(head1, head2.next);
        }
        else
        {
            result = head1;
            result.next = mergeLists (head1.next, head2);
        }
        return result;
    }

    /**
     * get data a position counted backwards.
     * @param llist head of the linked list
     * @param positionFromTail position from tail
     * @return data at the desired position
     */
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        int length = 0;
        for (SinglyLinkedListNode p = llist ; p != null; p = p.next)
        {
            length++;
        }
        int positionFromHead = length - 1 - positionFromTail;
        SinglyLinkedListNode pos = llist;
        for (int i = 0; i < positionFromHead; i++)
        {
            pos = pos.next;
        }
        return pos.data;
    }

    /**
     * remove duplicates in a linked list
     * @param llist head of the linked list
     * @return head of the modified list
     */
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) return null;
        SinglyLinkedListNode p = llist;
        while (p.next != null) {
            if (p.data == p.next.data) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }

        return llist;
    }

    /**
     * find the merge point of two linked lists.
     * @param head1 head of the first list
     * @param head2 head of the second list
     * @return data at the merge point
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int mergeData = 0;
        for (SinglyLinkedListNode p = head1 ; p != null; p = p.next)
        {
            for (SinglyLinkedListNode q = head2 ; q != null; q = q.next)
            {
                if (p == q)
                {
                    mergeData = p.data;
                    return mergeData;
                }
            }
        }
        return mergeData;
    }
}
