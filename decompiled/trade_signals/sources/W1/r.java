package W1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9268a = Process.myUid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f9269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f9270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f9271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f9272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f9273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f9274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Method f9275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Method f9276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Boolean f9277j;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f9269b = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f9270c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", null);
        } catch (Exception unused3) {
            method3 = null;
        }
        f9271d = method3;
        try {
            method4 = WorkSource.class.getMethod(com.amazon.a.a.o.b.au, Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        f9272e = method4;
        try {
            method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
            method5 = null;
        }
        f9273f = method5;
        if (l.f()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", null);
            } catch (Exception e8) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e8);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f9274g = method6;
        if (l.f()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e9) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e9);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f9275h = method7;
        if (l.f()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", null);
                try {
                    method8.setAccessible(true);
                } catch (Exception unused6) {
                }
            } catch (Exception unused7) {
                method8 = null;
            }
        } else {
            method8 = null;
        }
        f9276i = method8;
        f9277j = null;
    }

    public static void a(WorkSource workSource, int i8, String str) {
        Method method = f9270c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i8), str);
                return;
            } catch (Exception e8) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e8);
                return;
            }
        }
        Method method2 = f9269b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i8));
            } catch (Exception e9) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e9);
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        String str2;
        ApplicationInfo applicationInfoC;
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            applicationInfoC = Y1.f.a(context).c(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "Could not find package: ";
        }
        if (applicationInfoC == null) {
            str2 = "Could not get applicationInfo from package: ";
            Log.e("WorkSourceUtil", str2.concat(str));
            return null;
        }
        int i8 = applicationInfoC.uid;
        WorkSource workSource = new WorkSource();
        a(workSource, i8, str);
        return workSource;
    }

    public static synchronized boolean c(Context context) {
        Boolean bool = f9277j;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        boolean z7 = I.a.a(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
        f9277j = Boolean.valueOf(z7);
        return z7;
    }
}
