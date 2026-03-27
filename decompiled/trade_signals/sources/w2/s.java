package w2;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static Object a(Object obj, int i8) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i8);
    }

    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] c(Object[] objArr, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            a(objArr[i9], i9);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i8) {
        return u.b(objArr, i8);
    }
}
