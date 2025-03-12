package array;

public class XArraysEX {
    public static void main(String[] args) {
//        int[] array1= {1, 2, 3};
//        int[] array2= {1, 2, 3};
//        int[] array3= {3, 2, 1};
//
//        System.out.println(array.XArrays.equals(array1, array2));
//            // 출력: true
//        System.out.println(array.XArrays.equals(array1, array3));
//            // 출력: false
//
//        int[][] array11= {
//                {1, 2, 3},
//                {1, 2, 3}
//        };
//
//        int[][] array22= {
//                {1, 2, 3},
//                {1, 2, 3}
//        };
//
//        int[][] array33= {
//                {1, 2, 3},
//                {3, 2, 1}
//        };
//
//        System.out.println(array.XArrays.equals(array11, array22));
//// 출력: true
//        System.out.println(array.XArrays.equals(array11, array33));
//// 출력: false

        Integer[][] array111= {
                {1, 2, 3},
                {1, 2, 3}
        };

        Integer[][] array222= {
                {1, 2, 3},
                {1, 2, 3}
        };

        Integer[][] array333= {
                {1, 2, 3},
                {3, 2, 1}
        };

        String[][] array444= {
                {"a", "b", "c"},
                {"a", "b", "c"}
        };

        System.out.println(XArrays.equals(array111, array222));
// 출력: true
        System.out.println(XArrays.equals(array111, array333));
// 출력: false
        System.out.println(XArrays.equals(array111, array444));
    }
}
