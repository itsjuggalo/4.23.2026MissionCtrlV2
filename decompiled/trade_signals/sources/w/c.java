package w;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static Object[] a(Object[] objArr, int i8) {
        if (objArr.length < i8) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i8);
        }
        if (objArr.length > i8) {
            objArr[i8] = null;
        }
        return objArr;
    }
}
