package a2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static Object[] a(Object[] objArr, int i4, int i5, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i4, i5, objArr2.getClass());
    }

    public static Object[] b(Object[] objArr, int i4) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i4);
    }
}
