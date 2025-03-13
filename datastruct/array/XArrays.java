package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class XArrays {
    public static int[] copy(int[] source) {
        if (source == null) {
            throw new NullPointerException("array is null");
        }
        int[] newArray = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            newArray[i] = source[i];
        }
        return newArray;
    }

    public static <T> T[] copy(T[] source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        T[] newArray = (T[]) Array.newInstance(source.getClass().getComponentType(), source.length);
        for (int i = 0; i < source.length; i++) {
            newArray[i] = source[i];
        }
        return newArray;
    }

    public static int[] copy(int[] source, int startIndex, int length) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        if (startIndex < 0 || startIndex >= source.length) {
            throw new IndexOutOfBoundsException("startIndex out of bounds");
        }
        if (startIndex + length > source.length) {
            throw new IllegalArgumentException("startIndex + length > source.length");
        }
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = source[i + startIndex];
        }
        return newArray;
    }

    public static <T> T[] copy(T[] source, int startIndex, int length) {
        if (source == null) {
            throw new IllegalArgumentException("source is null");
        }
        if (startIndex < 0 || startIndex >= source.length) {
            throw new IndexOutOfBoundsException("startIndex out of bounds");
        }
        if (startIndex + length > source.length) {
            throw new IllegalArgumentException("startIndex + length > source.length");
        }
        T[] newArray = (T[]) Array.newInstance(source.getClass().getComponentType(), length);
        for (int i = 0; i < length; i++) {
            newArray[i] = source[i + startIndex];
        }
        return newArray;
    }

    public static void copy(int[] source, int srcIndex, int[] destination, int destIndex, int length) {
        if (source == null || destination == null) {
            throw new NullPointerException("source or destination is null");
        }
        if (srcIndex < 0 || destIndex < 0  || length < 0) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        if (srcIndex + length > source.length || destIndex + length > destination.length) {
            throw new IllegalArgumentException("index + length > destination.length");
        }

        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            temp[i] = source[i + srcIndex];
        }

        for (int i = 0; i < length; i++) {
            destination[destIndex + i] = temp[i];
        }
    }

    public static <T> void copy(T[] source, int srcIndex, T[] destination, int destIndex, int length) {
        if (source == null || destination == null) {
            throw new NullPointerException("source or destination is null");
        }
        if (srcIndex < 0 || destIndex < 0  || length < 0) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        if (srcIndex + length > source.length || destIndex + length > destination.length) {
            throw new IllegalArgumentException("index + length > destination.length");
        }

        T[] temp = (T[]) Array.newInstance(source.getClass().getComponentType(), length);

        for (int i = 0; i < length; i++) {
            temp[i] = source[i + srcIndex];
        }

        for (int i = 0; i < length; i++) {
            destination[destIndex + i] = temp[i];
        }
    }

    public static int[][] deepCopy(int[][] source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        int[][] newArray = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            newArray[i] = new int[source[i].length];
            for (int j = 0; j < source[i].length; j++) {
                newArray[i][j] = source[i][j];
            }
        }
        return newArray;
    }
    public static <T> T[][] deepCopy(T[][] source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        T[][] newArray = (T[][]) Array.newInstance(source.getClass().getComponentType(), source.length);
        for (int i = 0; i < source.length; i++) {
            newArray[i] = (T[]) Array.newInstance(source[i].getClass().getComponentType(), source[i].length);
            for (int j = 0; j < source[i].length; j++) {
                newArray[i][j] = source[i][j];
            }
        }
        return newArray;
    }
    public static Object[] deepCopy(Object[] source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        Object[] newArray = (Object[]) Array.newInstance(source.getClass().getComponentType(), source.length);
        for (int i = 0; i < source.length; i++) {
            if (source[i] instanceof int[]) {
                newArray[i] = ((int[]) source[i]).clone();  // int[] 배열은 clone()으로 복사
            } else if (source[i] instanceof double[]) {
                newArray[i] = ((double[]) source[i]).clone();  // double[] 배열 복사
            } else if (source[i] instanceof char[]) {
                newArray[i] = ((char[]) source[i]).clone();  // char[] 배열 복사
            } else if (source[i] instanceof byte[]) {
                newArray[i] = ((byte[]) source[i]).clone();  // byte[] 배열 복사
            } else if (source[i] instanceof short[]) {
                newArray[i] = ((short[]) source[i]).clone();  // short[] 배열 복사
            } else if (source[i] instanceof long[]) {
                newArray[i] = ((long[]) source[i]).clone();  // long[] 배열 복사
            } else if (source[i] instanceof float[]) {
                newArray[i] = ((float[]) source[i]).clone();  // float[] 배열 복사
            } else if (source[i] instanceof boolean[]) {
                newArray[i] = ((boolean[]) source[i]).clone();  // boolean[] 배열 복사
            } else if (source[i].getClass().isArray()) {
                newArray[i] = deepCopy((Object[]) source[i]);
            }
            else {
                newArray[i] = source[i];
            }
        }
        return newArray;
    }

//    public static boolean equals(int[] array1, int[] array2) {
//        if (array1 == null || array2 == null) {
//            throw new IllegalArgumentException("array1 or array2 is null");
//        }
//        if (array1.length != array2.length) {
//            return false;
//        }
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] != array2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static <T> boolean equals(T[] array1, T[] array2) {
//        if (array1 == null || array2 == null) {
//            throw new IllegalArgumentException("array1 or array2 is null");
//        }
//        if (array1.length != array2.length) {
//            return false;
//        }
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] != array2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean equals(int[][] array1, int[][] array2) {
//        if (array1 == null || array2 == null) {
//            throw new IllegalArgumentException("array1 or array2 is null");
//        }
//        if (array1.length != array2.length || array1[0].length != array2[0].length) {
//            return false;
//        }
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array1[i].length; j++) {
//                if (array1[i][j] != array2[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static <T> boolean equals(T[][] array1, T[][] array2) {
//        if (array1 == null || array2 == null) {
//            throw new IllegalArgumentException("array1 or array2 is null");
//        }
//        if (array1.length != array2.length || array1[0].length != array2[0].length) {
//            return false;
//        }
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array1[i].length; j++) {
//                if (array1[i][j] != array2[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean equals(Object array1, Object array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("array1 or array2 is null");
        }
        if (array1.getClass().isArray() && array2.getClass().isArray()) {
            Object[] array1Obj = (Object[]) array1;
            Object[] array2Obj = (Object[]) array2;
            if (array1Obj.length != array2Obj.length) {
                return false;
            }
            for (int i = 0; i < array1Obj.length; i++) {
                if (!equals(array1Obj[i], array2Obj[i])) {
                    return false;
                }
            }
            return true;
        }
        else {
            return array1.equals(array2);
        }
    }
}
