class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
    
def remove_nth_node_from_end(head, n):
    dummy = ListNode(0, head)
    slow = fast = dummy
    
    for _ in range(n+1):
        fast = fast.next
        
    while fast:
        fast = fast.next
        slow = slow.next
        
    slow.next = slow.next.next
    
    return dummy.next

def create(vals):
    dummy = ListNode(0)
    curr = dummy
    for val in vals:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next
    
def print_LinkedList(head):
    vals = []
    while head:
        vals.append(head.val)
        head = head.next
    return vals
    
head = create([1,2,3,4,5])
n = 2
new = remove_nth_node_from_end(head, n)
print(print_LinkedList(new))
    
