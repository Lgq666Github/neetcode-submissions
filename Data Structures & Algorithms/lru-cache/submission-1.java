public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {
    private int cap; // 缓存容量
    private HashMap<Integer, Node> cache; // 快速访问节点的哈希表
    private Node left; // 虚拟头节点（表示最久未使用）
    private Node right; // 虚拟尾节点（表示最近使用）
    
    /**
    *创建一个容量为 capacity 的LRU缓存
    *初始化一个虚拟头节点 (left) 和尾节点 (right)，并让它们互相指向对方，使链表初始为空
    **/
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    /**
    *删除节点：将节点的前后节点互相连接起来，跳过 node 本身
    **/
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
    *将新节点插入到链表尾部（right 左边）
    *最近访问的节点总是放在尾部，以保持链表的顺序是按访问时间排序的
    **/
    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    // 获取缓存项的值--将节点移动到链表尾部（更新为最近使用）
    private int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    // 插入或更新缓存项
    public void put(int key, int value) {
        if (cache.containsKey(key)) { // 如果key已存在
            remove(cache.get(key)); // 移除旧节点
        }
        Node newNode = new Node(key, value); // 创建新节点
        cache.put(key, newNode); // 更新哈希表
        insert(newNode); // 插入链表尾部

        if (cache.size() > cap) { // 超出容量
            Node lru = this.left.next; // 找出最久未使用的节点
            remove(lru); // 移除节点
            cache.remove(lru.key); // 从哈希表中删除
        }
    }
}
