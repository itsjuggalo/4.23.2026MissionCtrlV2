package G1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Method f478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Method f479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Boolean f480j;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        Class cls = Integer.TYPE;
        f471a = Process.myUid();
        try {
            method = WorkSource.class.getMethod("add", cls);
        } catch (Exception unused) {
            method = null;
        }
        f472b = method;
        try {
            method2 = WorkSource.class.getMethod("add", cls, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f473c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f474d = method3;
        try {
            method4 = WorkSource.class.getMethod(com.amazon.a.a.o.b.au, cls);
        } catch (Exception unused4) {
            method4 = null;
        }
        f475e = method4;
        try {
            method5 = WorkSource.class.getMethod("getName", cls);
        } catch (Exception unused5) {
            method5 = null;
        }
        f476f = method5;
        if (m.f()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e4) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e4);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f477g = method6;
        if (m.f()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", cls, String.class);
            } catch (Exception e5) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e5);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f478h = method7;
        if (m.f()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", new Class[0]);
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
        f479i = method8;
        f480j = null;
    }

    public static void a(WorkSource workSource, int i4, String str) {
        Method method = f473c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i4), str);
                return;
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                return;
            }
        }
        Method method2 = f472b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i4));
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = I1.f.a(context).c(str, 0);
                if (applicationInfoC == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i4 = applicationInfoC.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i4, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static synchronized boolean c(Context context) {
        Boolean bool = f480j;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        boolean z4 = AbstractC1909a.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
        f480j = Boolean.valueOf(z4);
        return z4;
    }
}
