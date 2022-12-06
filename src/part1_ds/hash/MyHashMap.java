package part1_ds.hash;

import java.util.NoSuchElementException;

/**
 * 基于整型的开散列方案的哈希表实现
 */
public class MyHashMap {
    //1.当前哈希表的元素个数
    private int size;
    //2.负载因子，默认取JDK的0。75
    private static final double LOAD_FACTOR = 0.75;

    //3.定义数组储存的链表
    private static class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //4.哈希表储存链表的数组
    private Node[] hashTable;

    //5.构造方法
    private MyHashMap(){
        this(10);
    }
    private MyHashMap(int capacity){
        this.hashTable = new Node[capacity];
        //每次resize（）取模按新的容量取，减少哈希冲突
        this.M = capacity;
    }

    //6.hash方法取模参数M
    private int M;
    public int hash(int key){
        return Math.abs(key) % M;
    }


    public int put(int key,int value){
        // 1.先对key取模，得到当前键值对要放在哪个子链表中~
        int index = hash(key);
        // 2.遍历这个子链表查看，key是否已经存在
        // 子链表的头结点head = hashTable[index]
        for (Node x = hashTable[index]; x != null;x = x.next) {
            if(x.key == key){
                // 此时key已经存在，更新value，返回之前的value值
                int oldValue = x.value;
                x.value = value;
                return oldValue;
            }
        }
        // 3.说明此时整个链表中不存在指定的key，构造新节点头插到当前位置
        Node newNode = new Node(key, value);
        newNode.next = hashTable[index];
        // 更新链表头
        hashTable[index] = newNode;
        size++;
        // 4.新增元素之后，判断是否需要扩容
        if(size >= LOAD_FACTOR * hashTable.length){
            // 触发扩容操作
            resize();
        }
        return value;
    }
    // 哈希表的整体扩容操作,扩容为原数组的一倍
    private void resize() {
        // 1.产生新数组
        Node[] newTable = new Node[hashTable.length << 1];
        // 更新取模数为新数组长度
        this.M = newTable.length;
        // 2.进行原哈希表的搬移操作
        // 每次遍历子链表，将子链表中不为空的节点搬移到新数组中
        // 外层循环就是从第一个子链表开始遍历直到遍历完整个数组
        for (int i = 0; i < hashTable.length; i++) {
            for(Node x = hashTable[i];x != null;){
                //暂存下一个节点的地址
                Node next = x.next;
                //进行x节点的搬移,重新hash到新数组
                int newIndex = hash(x.key);
                // 进行新数组的头插
                x.next = newTable[newIndex];
                newTable[newIndex] = x;
                // x继续走next节点的搬移
                x = next;
            }
        }
        // 原hashTable的所有节点已经搬移结束，一步到位让hashTable指向新数组即可
        hashTable = newTable;
    }

    public boolean containsKey(int key) {
        // 先找到要遍历的子链表
        int index = hash(key);
        for (Node x = hashTable[index];x != null;x = x.next) {
            if (key == x.key) {
                return true;
            }
        }
        return false;
    }

    public int get(int key) {
        // 先找到要遍历的子链表
        int index = hash(key);
        for (Node x = hashTable[index];x != null;x = x.next) {
            if (x.key == key) {
                return x.value;
            }
        }
        throw new NoSuchElementException("hashtable has not this key!");
    }

    public boolean containsValue(int value) {
        // 全表扫描
        for (int i = 0; i < hashTable.length; i++) {
            for (Node x = hashTable[i];x != null;x = x.next) {
                if (x.value == value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据key值删除对应的键值对
     * @param key
     * @return
     */
    public boolean remove(int key) {
        int index = hash(key);
        // 以下就是单链表的删除问题
        Node head = hashTable[index];
        if (head == null) {
            // 不存在该节点
            return false;
        }
        // 判断头节点就是待删除的结点
        if (head.key == key) {
            hashTable[index] = head.next;
            head = head.next = null;
            size --;
            return true;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.key == key) {
                // cur是待删除节点
                Node cur = prev.next;
                prev.next = cur.next;
                cur = cur.next = null;
                size --;
                return true;
            }
        }
        // 压根不存在要删除的键值对
        return false;
    }

}
