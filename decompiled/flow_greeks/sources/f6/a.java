package f6;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import m5.f;
import m5.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f9357a = f.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f9358b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f9359c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f9360d = false;

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r12) {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.s.l(r12, r0)
            m5.f r0 = f6.a.f9357a
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.k(r12, r1)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = f6.a.f9358b
            monitor-enter(r2)
            boolean r3 = f6.a.f9360d     // Catch: java.lang.Throwable -> L28
            r4 = 0
            if (r3 != 0) goto L47
            java.lang.String r3 = "Failed to load providerinstaller module: "
            com.google.android.gms.dynamite.DynamiteModule$b r5 = com.google.android.gms.dynamite.DynamiteModule.f5817f     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.a -> L2b
            java.lang.String r6 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.e(r12, r5, r6)     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.a -> L2b
            android.content.Context r3 = r5.b()     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.a -> L2b
            goto L3e
        L28:
            r12 = move-exception
            goto La7
        L2b:
            r5 = move-exception
            java.lang.String r6 = "ProviderInstaller"
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r3.concat(r5)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r6, r3)     // Catch: java.lang.Throwable -> L28
            r3 = r4
        L3e:
            if (r3 == 0) goto L47
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            b(r3, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            goto L97
        L47:
            boolean r3 = f6.a.f9360d     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "Failed to report request stats: "
            android.content.Context r6 = m5.j.d(r12)     // Catch: java.lang.Throwable -> L28
            if (r6 != 0) goto L52
            goto L8f
        L52:
            r4 = 1
            f6.a.f9360d = r4     // Catch: java.lang.Throwable -> L28
            if (r3 != 0) goto L8e
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.String r3 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r9 = "reportRequestStats2"
            java.lang.ClassLoader r10 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            com.google.android.gms.internal.common.zzi r11 = com.google.android.gms.internal.common.zzi.zzb(r11, r12)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r0 = com.google.android.gms.internal.common.zzh.zza(r0)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r1 = com.google.android.gms.internal.common.zzh.zza(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7 = 3
            com.google.android.gms.internal.common.zzi[] r7 = new com.google.android.gms.internal.common.zzi[r7]     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r8 = 0
            r7[r8] = r11     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7[r4] = r0     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r0 = 2
            r7[r0] = r1     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzj.zzb(r3, r9, r10, r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            goto L8e
        L80:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r5.concat(r0)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L28
        L8e:
            r4 = r6
        L8f:
            if (r4 == 0) goto L98
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            b(r4, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
        L97:
            return
        L98:
            java.lang.String r12 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r12, r0)     // Catch: java.lang.Throwable -> L28
            m5.g r12 = new m5.g     // Catch: java.lang.Throwable -> L28
            r0 = 8
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L28
            throw r12     // Catch: java.lang.Throwable -> L28
        La7:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a.a(android.content.Context):void");
    }

    public static void b(Context context, Context context2, String str) throws g {
        try {
            if (f9359c == null) {
                f9359c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f9359c.invoke(null, context);
        } catch (Exception e10) {
            Throwable cause = e10.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e10.toString() : cause.toString())));
            }
            throw new g(8);
        }
    }
}
