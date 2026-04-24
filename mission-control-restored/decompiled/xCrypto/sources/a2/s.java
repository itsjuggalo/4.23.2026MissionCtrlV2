package a2;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static Object a(Object obj, int i4) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i4);
    }

    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] c(Object[] objArr, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            a(objArr[i5], i5);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i4) {
        return u.b(objArr, i4);
    }
}
