package u7;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c8.j f22228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f22229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r7.a f22230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f22231e = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(c8.j jVar, Thread thread, Throwable th);
    }

    public a0(a aVar, c8.j jVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, r7.a aVar2) {
        this.f22227a = aVar;
        this.f22228b = jVar;
        this.f22229c = uncaughtExceptionHandler;
        this.f22230d = aVar2;
    }

    public boolean a() {
        return this.f22231e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            r7.g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            r7.g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f22230d.c()) {
            return true;
        }
        r7.g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Completed exception processing, but no default exception handler."
            java.lang.String r1 = "Completed exception processing. Invoking default exception handler."
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f22231e
            r3 = 1
            r2.set(r3)
            r2 = 0
            boolean r4 = r7.b(r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            if (r4 == 0) goto L1d
            u7.a0$a r4 = r7.f22227a     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            c8.j r5 = r7.f22228b     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r4.a(r5, r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            goto L26
        L19:
            r4 = move-exception
            goto L55
        L1b:
            r4 = move-exception
            goto L47
        L1d:
            r7.g r4 = r7.g.f()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            java.lang.String r5 = "Uncaught exception will not be recorded by Crashlytics."
            r4.b(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
        L26:
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f22229c
            if (r4 == 0) goto L37
        L2a:
            r7.g r0 = r7.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f22229c
            r0.uncaughtException(r8, r9)
            goto L41
        L37:
            r7.g r8 = r7.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L41:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f22231e
            r8.set(r2)
            return
        L47:
            r7.g r5 = r7.g.f()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "An error occurred in the uncaught exception handler"
            r5.e(r6, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f22229c
            if (r4 == 0) goto L37
            goto L2a
        L55:
            java.lang.Thread$UncaughtExceptionHandler r5 = r7.f22229c
            if (r5 == 0) goto L66
            r7.g r0 = r7.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f22229c
            r0.uncaughtException(r8, r9)
            goto L70
        L66:
            r7.g r8 = r7.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L70:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f22231e
            r8.set(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a0.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
