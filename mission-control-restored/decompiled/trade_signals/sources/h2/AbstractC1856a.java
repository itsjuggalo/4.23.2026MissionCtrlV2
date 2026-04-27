package h2;

import Q1.C0795g;
import Q1.C0796h;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: h2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1856a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0795g f18386a = C0795g.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f18387b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f18388c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f18389d = false;

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x001a, B:14:0x0041, B:15:0x0046, B:17:0x0048, B:28:0x0092, B:29:0x0097, B:31:0x0099, B:32:0x00a7, B:20:0x0052, B:22:0x0056, B:25:0x0080, B:12:0x002b), top: B:39:0x0015, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[Catch: all -> 0x0027, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x001a, B:14:0x0041, B:15:0x0046, B:17:0x0048, B:28:0x0092, B:29:0x0097, B:31:0x0099, B:32:0x00a7, B:20:0x0052, B:22:0x0056, B:25:0x0080, B:12:0x002b), top: B:39:0x0015, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: all -> 0x0027, TryCatch #2 {, blocks: (B:4:0x0015, B:7:0x001a, B:14:0x0041, B:15:0x0046, B:17:0x0048, B:28:0x0092, B:29:0x0097, B:31:0x0099, B:32:0x00a7, B:20:0x0052, B:22:0x0056, B:25:0x0080, B:12:0x002b), top: B:39:0x0015, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r11) {
        /*
            r0 = 1
            java.lang.String r1 = "Context must not be null"
            com.google.android.gms.common.internal.AbstractC1294n.k(r11, r1)
            Q1.g r1 = h2.AbstractC1856a.f18386a
            r2 = 11925000(0xb5f608, float:1.6710484E-38)
            r1.k(r11, r2)
            long r1 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r3 = h2.AbstractC1856a.f18387b
            monitor-enter(r3)
            boolean r4 = h2.AbstractC1856a.f18389d     // Catch: java.lang.Throwable -> L27
            r5 = 0
            if (r4 != 0) goto L48
            com.google.android.gms.dynamite.DynamiteModule$b r4 = com.google.android.gms.dynamite.DynamiteModule.f15067f     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.a -> L2a
            java.lang.String r6 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r4 = com.google.android.gms.dynamite.DynamiteModule.e(r11, r4, r6)     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.a -> L2a
            android.content.Context r4 = r4.b()     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.a -> L2a
            goto L3f
        L27:
            r11 = move-exception
            goto La8
        L2a:
            r4 = move-exception
            java.lang.String r6 = "ProviderInstaller"
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L27
            java.lang.String r7 = "Failed to load providerinstaller module: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = r7.concat(r4)     // Catch: java.lang.Throwable -> L27
            android.util.Log.w(r6, r4)     // Catch: java.lang.Throwable -> L27
            r4 = r5
        L3f:
            if (r4 == 0) goto L48
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            b(r4, r11, r0)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            return
        L48:
            boolean r4 = h2.AbstractC1856a.f18389d     // Catch: java.lang.Throwable -> L27
            r4 = r4 ^ r0
            android.content.Context r6 = Q1.AbstractC0799k.d(r11)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L52
            goto L90
        L52:
            h2.AbstractC1856a.f18389d = r0     // Catch: java.lang.Throwable -> L27
            if (r4 == 0) goto L8f
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            java.lang.String r7 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r8 = "reportRequestStats2"
            java.lang.ClassLoader r9 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            e2.h r10 = e2.h.a(r10, r11)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            e2.g r1 = e2.g.d(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            e2.g r2 = e2.g.d(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            r4 = 3
            e2.h[] r4 = new e2.h[r4]     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            r4[r0] = r1     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            r0 = 2
            r4[r0] = r2     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            e2.j.b(r7, r8, r9, r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L7f
            goto L8f
        L7f:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = "Failed to report request stats: "
            java.lang.String r0 = r2.concat(r0)     // Catch: java.lang.Throwable -> L27
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L27
        L8f:
            r5 = r6
        L90:
            if (r5 == 0) goto L99
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            b(r5, r11, r0)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            return
        L99:
            java.lang.String r11 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r11, r0)     // Catch: java.lang.Throwable -> L27
            Q1.h r11 = new Q1.h     // Catch: java.lang.Throwable -> L27
            r0 = 8
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L27
            throw r11     // Catch: java.lang.Throwable -> L27
        La8:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.AbstractC1856a.a(android.content.Context):void");
    }

    public static void b(Context context, Context context2, String str) throws C0796h {
        try {
            if (f18388c == null) {
                f18388c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f18388c.invoke(null, context);
        } catch (Exception e8) {
            Throwable cause = e8.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e8.toString() : cause.toString())));
            }
            throw new C0796h(8);
        }
    }
}
