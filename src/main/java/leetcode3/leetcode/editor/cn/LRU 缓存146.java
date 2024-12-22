//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics设计 | 哈希表 | 链表 | 双向链表 
//
// 👍 3336, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode3.leetcode.editor.cn;

import java.util.LinkedHashMap;

/**
 * 146:LRU 缓存
 */
public class LRU 缓存146 {
    public static void main(String[] args) {
        Solution solution = new LRU 缓存146().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private int capacity;
        private LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            linkedHashMap = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!linkedHashMap.containsKey(key)) {
                return -1;
            }
            Integer value = linkedHashMap.get(key);
            makeRecent(key, value);
            return value;
        }

        public void put(int key, int value) {
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.put(key, value);
                makeRecent(key, value);
                return;
            }
            if (linkedHashMap.size() < capacity) {
                linkedHashMap.put(key, value);
                return;
            }

            Integer firstKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(firstKey);
            linkedHashMap.put(key, value);
        }

        private void makeRecent(int key, int value) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}