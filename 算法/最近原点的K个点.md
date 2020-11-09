### 最近原点的K个点

**题目描述：**

我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的

**示例：**

```java
输入：points = [[1,3],[-2,2]], K = 1
输出：[[-2,2]]
解释： 
(1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
```

**思路：**

由题可知，到【0，0】原点最近，等价与两个数的平方和最小，要求k个最小数，那就对其从小到大排序，然后取前k个即可，最直观的可以利用java的工具类Arrays结合Comparetor自定义排序规则，对数组排序，再取前k个。

**我的代码：**

```java
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            /*直接利用对二维数组的排序，只不过要自定义排序规则，就是平方和的大小升序*/
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1]) - (o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
}
```

