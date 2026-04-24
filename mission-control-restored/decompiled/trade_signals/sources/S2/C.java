package S2;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class C implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3.j f7469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f7470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final P2.a f7471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f7472e = new AtomicBoolean(false);

    public interface a {
        void a(a3.j jVar, Thread thread, Throwable th);
    }

    public C(a aVar, a3.j jVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, P2.a aVar2) {
        this.f7468a = aVar;
        this.f7469b = jVar;
        this.f7470c = uncaughtExceptionHandler;
        this.f7471d = aVar2;
    }

    public boolean a() {
        return this.f7472e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            P2.g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            P2.g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f7471d.b()) {
            return true;
        }
        P2.g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
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
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f7472e
            r3 = 1
            r2.set(r3)
            r2 = 0
            boolean r4 = r7.b(r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            if (r4 == 0) goto L1d
            S2.C$a r4 = r7.f7468a     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            a3.j r5 = r7.f7469b     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r4.a(r5, r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            goto L26
        L19:
            r4 = move-exception
            goto L56
        L1b:
            r4 = move-exception
            goto L47
        L1d:
            P2.g r4 = P2.g.f()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            java.lang.String r5 = "Uncaught exception will not be recorded by Crashlytics."
            r4.b(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
        L26:
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f7470c
            if (r4 == 0) goto L37
        L2a:
            P2.g r0 = P2.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f7470c
            r0.uncaughtException(r8, r9)
            goto L41
        L37:
            P2.g r8 = P2.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L41:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7472e
            r8.set(r2)
            goto L55
        L47:
            P2.g r5 = P2.g.f()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "An error occurred in the uncaught exception handler"
            r5.e(r6, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f7470c
            if (r4 == 0) goto L37
            goto L2a
        L55:
            return
        L56:
            java.lang.Thread$UncaughtExceptionHandler r5 = r7.f7470c
            if (r5 == 0) goto L67
            P2.g r0 = P2.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f7470c
            r0.uncaughtException(r8, r9)
            goto L71
        L67:
            P2.g r8 = P2.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L71:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7472e
            r8.set(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.C.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
