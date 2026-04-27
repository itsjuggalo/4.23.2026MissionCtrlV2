package w2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static Object[] a(Object[] objArr, int i8, int i9, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i8, i9, objArr2.getClass());
    }

    public static Object[] b(Object[] objArr, int i8) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i8);
    }
}
