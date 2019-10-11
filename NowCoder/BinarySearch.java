package NowCoder;

public class BinarySearch {
    //最常规的二分查找
    public int bsearch(int[] a, int target, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int target, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || (a[mid - 1] != target)) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public int bsearch2(int[] a, int target, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == length - 1 || (a[mid + 1] != target)) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public int bsearch3(int[] a, int target, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= target) {
                if (mid == 0 || (a[mid - 1] < target)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public int bsearch4(int[] a, int target, int length) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == length - 1 || (a[mid + 1] > target)) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
