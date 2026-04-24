package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
public final class zzl {
    public static Object zza(Class cls, String str, zzj... zzjVarArr) {
        return zzc(cls, "isIsolated", null, false, zzjVarArr);
    }

    public static Object zzb(String str, String str2, ClassLoader classLoader, zzj... zzjVarArr) {
        return zzc(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", null, false, zzjVarArr);
    }

    private static Object zzc(Class cls, String str, Object obj, boolean z4, zzj... zzjVarArr) {
        int length = zzjVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i4 = 0; i4 < zzjVarArr.length; i4++) {
            zzj zzjVar = zzjVarArr[i4];
            zzjVar.getClass();
            clsArr[i4] = zzjVar.zzc();
            objArr[i4] = zzjVarArr[i4].zzd();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }
}
