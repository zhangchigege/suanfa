package recursion;

/**
 * @program: suamfa
 * @description: 递归的使用
 * @author: ZhangChi
 * @create: 2019-11-18 15:42
 **/
public class MiGong {

    public static void main(String[] args) {
        // 创建一个二维数组模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用 1 表示墙
        // 先把上下置为 1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右置为 1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;


        setWay(map, 1, 1);
        // 输出地图,判断走过的地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }


    }

    /**
     * @param map 表示地图
     * @param i   表示从什么位置开始
     * @param j
     * @return 找到然会true, 否则返回false
     * 从(1,1)开始到(6,5)结束
     * 约定:当map[i][j]为0表示该点没有走过,为1表示墙,2表示可以通过,3表示该点已经走过,但是走不通
     * 方法: 下->右->上->左
     */
    static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没有走过
                // 按照策略走
                map[i][j] = 2; // 假定该点是可以走通的
                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    // 向右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    // 向上走
                } else if (setWay(map, i - 1, j)) {
                    return true;
                    // 向左走
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 该点走不通,丝路
                    map[i][j] = 3;
                    return false;
                }
                // 如果map[i][j] != 0,可能是1,2,3
            } else {
                return false;
            }
        }
    }

}
