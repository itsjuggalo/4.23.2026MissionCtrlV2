package e2;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static Object a(Class cls, String str, h... hVarArr) {
        return c(cls, "isIsolated", null, false, hVarArr);
    }

    public static Object b(String str, String str2, ClassLoader classLoader, h... hVarArr) {
        return c(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", null, false, hVarArr);
    }

    public static Object c(Class cls, String str, Object obj, boolean z7, h... hVarArr) {
        int length = hVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i8 = 0; i8 < hVarArr.length; i8++) {
            h hVar = hVarArr[i8];
            hVar.getClass();
            clsArr[i8] = hVar.b();
            objArr[i8] = hVarArr[i8].c();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }
}
