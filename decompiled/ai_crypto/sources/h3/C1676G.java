package h3;

import e3.C1478g;
import e3.InterfaceC1472a;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: h3.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1676G implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p3.j f14747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f14748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC1472a f14749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f14750e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h3.G$a */
    public interface a {
        void a(p3.j jVar, Thread thread, Throwable th);
    }

    public C1676G(a aVar, p3.j jVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, InterfaceC1472a interfaceC1472a) {
        this.f14746a = aVar;
        this.f14747b = jVar;
        this.f14748c = uncaughtExceptionHandler;
        this.f14749d = interfaceC1472a;
    }

    public boolean a() {
        return this.f14750e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            C1478g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            C1478g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f14749d.b()) {
            return true;
        }
        C1478g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
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
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f14750e
            r3 = 1
            r2.set(r3)
            r2 = 0
            boolean r4 = r7.b(r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            if (r4 == 0) goto L1d
            h3.G$a r4 = r7.f14746a     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            p3.j r5 = r7.f14747b     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            r4.a(r5, r8, r9)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            goto L26
        L19:
            r4 = move-exception
            goto L56
        L1b:
            r4 = move-exception
            goto L47
        L1d:
            e3.g r4 = e3.C1478g.f()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
            java.lang.String r5 = "Uncaught exception will not be recorded by Crashlytics."
            r4.b(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1b
        L26:
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f14748c
            if (r4 == 0) goto L37
        L2a:
            e3.g r0 = e3.C1478g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f14748c
            r0.uncaughtException(r8, r9)
            goto L41
        L37:
            e3.g r8 = e3.C1478g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L41:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f14750e
            r8.set(r2)
            goto L55
        L47:
            e3.g r5 = e3.C1478g.f()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "An error occurred in the uncaught exception handler"
            r5.e(r6, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f14748c
            if (r4 == 0) goto L37
            goto L2a
        L55:
            return
        L56:
            java.lang.Thread$UncaughtExceptionHandler r5 = r7.f14748c
            if (r5 == 0) goto L67
            e3.g r0 = e3.C1478g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f14748c
            r0.uncaughtException(r8, r9)
            goto L71
        L67:
            e3.g r8 = e3.C1478g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L71:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f14750e
            r8.set(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.C1676G.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
