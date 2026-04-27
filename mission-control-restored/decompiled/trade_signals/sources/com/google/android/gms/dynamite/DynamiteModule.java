package com.google.android.gms.dynamite;

import Q1.C0795g;
import W1.l;
import a2.AbstractC1061h;
import a2.C1059f;
import a2.C1060g;
import a2.C1062i;
import a2.C1063j;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class DynamiteModule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f15069h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f15070i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f15071j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f15072k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Boolean f15073l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static C1062i f15078q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static C1063j f15079r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15080a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ThreadLocal f15074m = new ThreadLocal();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadLocal f15075n = new C1059f();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b.a f15076o = new com.google.android.gms.dynamite.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f15063b = new com.google.android.gms.dynamite.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f15064c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f15065d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f15066e = new e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f15067f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f15068g = new g();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f15077p = new h();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public /* synthetic */ a(String str, AbstractC1061h abstractC1061h) {
            super(str);
        }

        public /* synthetic */ a(String str, Throwable th, AbstractC1061h abstractC1061h) {
            super(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(Context context, String str, boolean z7);

            int b(Context context, String str);
        }

        /* JADX INFO: renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b, reason: collision with other inner class name */
        public static class C0251b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f15081a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15082b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f15083c = 0;
        }

        C0251b a(Context context, String str, a aVar);
    }

    public DynamiteModule(Context context) {
        AbstractC1294n.j(context);
        this.f15080a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (AbstractC1293m.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e8) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e8.getMessage())));
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0226: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:116:0x0226 */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.dynamite.DynamiteModule e(android.content.Context r18, com.google.android.gms.dynamite.DynamiteModule.b r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$b, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0175 A[Catch: all -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00e9, blocks: (B:3:0x0002, B:64:0x00de, B:66:0x00e4, B:73:0x0108, B:101:0x0167, B:105:0x0175, B:123:0x01c7, B:124:0x01ca, B:118:0x01bf, B:71:0x00ed, B:126:0x01cc, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:62:0x00db, B:21:0x0049, B:45:0x00a0, B:48:0x00a3, B:55:0x00b9, B:63:0x00dd, B:61:0x00bf), top: B:137:0x0002, inners: #1, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[Catch: all -> 0x0036, TryCatch #12 {, blocks: (B:9:0x0026, B:11:0x0032, B:52:0x00b6, B:16:0x003b, B:18:0x0042, B:20:0x0048, B:25:0x004e, B:27:0x0052, B:31:0x005c, B:33:0x0064, B:36:0x006b, B:43:0x0097, B:44:0x009f, B:39:0x0072, B:41:0x0078, B:42:0x0089, B:47:0x00a2, B:50:0x00a5, B:51:0x00ad, B:17:0x003e), top: B:144:0x0026, inners: #4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x01bd -> B:132:0x01c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x01bf -> B:132:0x01c2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x013d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:92:0x013d */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(android.content.Context r12, java.lang.String r13, boolean r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.g(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    public static void i(ClassLoader classLoader) throws a {
        C1063j c1063j;
        AbstractC1061h abstractC1061h = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                c1063j = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                c1063j = iInterfaceQueryLocalInterface instanceof C1063j ? (C1063j) iInterfaceQueryLocalInterface : new C1063j(iBinder);
            }
            f15079r = c1063j;
        } catch (ClassNotFoundException e8) {
            e = e8;
            throw new a("Failed to instantiate dynamite loader", e, abstractC1061h);
        } catch (IllegalAccessException e9) {
            e = e9;
            throw new a("Failed to instantiate dynamite loader", e, abstractC1061h);
        } catch (InstantiationException e10) {
            e = e10;
            throw new a("Failed to instantiate dynamite loader", e, abstractC1061h);
        } catch (NoSuchMethodException e11) {
            e = e11;
            throw new a("Failed to instantiate dynamite loader", e, abstractC1061h);
        } catch (InvocationTargetException e12) {
            e = e12;
            throw new a("Failed to instantiate dynamite loader", e, abstractC1061h);
        }
    }

    public static boolean j(Cursor cursor) {
        C1060g c1060g = (C1060g) f15074m.get();
        if (c1060g == null || c1060g.f9913a != null) {
            return false;
        }
        c1060g.f9913a = cursor;
        return true;
    }

    public static boolean k(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f15073l)) {
            return true;
        }
        boolean z7 = false;
        if (f15073l == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != l.g() ? 0 : 268435456);
            if (C0795g.f().h(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z7 = true;
            }
            f15073l = Boolean.valueOf(z7);
            if (z7 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f15071j = true;
            }
        }
        if (!z7) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z7;
    }

    public static C1062i l(Context context) {
        C1062i c1062i;
        synchronized (DynamiteModule.class) {
            C1062i c1062i2 = f15078q;
            if (c1062i2 != null) {
                return c1062i2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c1062i = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c1062i = iInterfaceQueryLocalInterface instanceof C1062i ? (C1062i) iInterfaceQueryLocalInterface : new C1062i(iBinder);
                }
                if (c1062i != null) {
                    f15078q = c1062i;
                    return c1062i;
                }
            } catch (Exception e8) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e8.getMessage());
            }
            return null;
        }
    }

    public Context b() {
        return this.f15080a;
    }

    public IBinder d(String str) throws a {
        try {
            return (IBinder) this.f15080a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e8) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e8, null);
        }
    }
}
