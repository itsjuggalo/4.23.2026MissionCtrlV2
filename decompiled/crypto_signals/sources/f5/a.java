package f5;

import a5.w0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f6496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f6497c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f6495a = new t("CLOSED", 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f6498d = new t("NO_THREAD_ELEMENTS", 0);
    public static final I4.b e = new I4.b(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final I4.b f6499f = new I4.b(7);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final I4.b f6500g = new I4.b(8);

    static {
        int i = 0;
        f6496b = new t("UNDEFINED", i);
        f6497c = new t("REUSABLE_CLAIMED", i);
    }

    public static final void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(a3.d.f(i, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(r rVar, long j4, R4.p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            if (rVar.f6531c >= j4 && !rVar.d()) {
                return rVar;
            }
            Object obj = b.f6501a.get(rVar);
            t tVar = f6495a;
            if (obj == tVar) {
                return tVar;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.invoke(Long.valueOf(rVar.f6531c + 1), rVar);
                do {
                    atomicReferenceFieldUpdater = b.f6501a;
                    if (atomicReferenceFieldUpdater.compareAndSet(rVar, null, rVar2)) {
                        if (rVar.d()) {
                            rVar.e();
                        }
                    }
                } while (atomicReferenceFieldUpdater.get(rVar) == null);
            }
            rVar = rVar2;
        }
    }

    public static final r c(Object obj) {
        if (obj != f6495a) {
            return (r) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(I4.i iVar, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = d.f6504a.iterator();
        while (it.hasNext()) {
            try {
                ((b5.b) it.next()).g(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    D1.b.c(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            D1.b.c(th, new e(iVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f6495a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(I4.i iVar, Object obj) {
        if (obj == f6498d) {
            return;
        }
        if (!(obj instanceof w)) {
            Object objFold = iVar.fold(null, f6499f);
            kotlin.jvm.internal.j.c(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            a3.d.r(objFold);
            throw null;
        }
        w wVar = (w) obj;
        w0[] w0VarArr = wVar.f6539b;
        int length = w0VarArr.length - 1;
        if (length < 0) {
            return;
        }
        w0 w0Var = w0VarArr[length];
        kotlin.jvm.internal.j.b(null);
        Object obj2 = wVar.f6538a[length];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[Catch: all -> 0x0074, DONT_GENERATE, TryCatch #2 {all -> 0x0074, blocks: (B:19:0x0054, B:21:0x0062, B:23:0x0068, B:36:0x0098, B:26:0x0076, B:28:0x0084, B:33:0x008f, B:35:0x0095, B:41:0x00a5, B:44:0x00ae, B:43:0x00ab, B:31:0x008a), top: B:57:0x0054, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(I4.d r9, java.lang.Object r10) {
        /*
            boolean r0 = r9 instanceof f5.f
            if (r0 == 0) goto Lb9
            f5.f r9 = (f5.f) r9
            java.lang.Throwable r0 = G4.h.a(r10)
            if (r0 != 0) goto Le
            r1 = r10
            goto L14
        Le:
            a5.w r1 = new a5.w
            r2 = 0
            r1.<init>(r0, r2)
        L14:
            a5.y r0 = r9.f6507d
            K4.c r2 = r9.e
            I4.i r3 = r2.getContext()
            boolean r3 = r0.h(r3)
            r4 = 1
            if (r3 == 0) goto L2f
            r9.f6508f = r1
            r9.f4086c = r4
            I4.i r10 = r2.getContext()
            r0.g(r10, r9)
            return
        L2f:
            a5.V r0 = a5.x0.a()
            long r5 = r0.f4101c
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L51
            r9.f6508f = r1
            r9.f4086c = r4
            H4.f r10 = r0.e
            if (r10 != 0) goto L4d
            H4.f r10 = new H4.f
            r10.<init>()
            r0.e = r10
        L4d:
            r10.addLast(r9)
            goto Lb3
        L51:
            r0.l(r4)
            I4.i r1 = r2.getContext()     // Catch: java.lang.Throwable -> L74
            a5.z r3 = a5.C0318z.f4167b     // Catch: java.lang.Throwable -> L74
            I4.g r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L74
            a5.c0 r1 = (a5.InterfaceC0295c0) r1     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L76
            boolean r3 = r1.isActive()     // Catch: java.lang.Throwable -> L74
            if (r3 != 0) goto L76
            java.util.concurrent.CancellationException r10 = r1.getCancellationException()     // Catch: java.lang.Throwable -> L74
            G4.g r10 = a.AbstractC0284a.d(r10)     // Catch: java.lang.Throwable -> L74
            r9.resumeWith(r10)     // Catch: java.lang.Throwable -> L74
            goto L98
        L74:
            r10 = move-exception
            goto Laf
        L76:
            java.lang.Object r1 = r9.f6509k     // Catch: java.lang.Throwable -> L74
            I4.i r3 = r2.getContext()     // Catch: java.lang.Throwable -> L74
            java.lang.Object r1 = l(r3, r1)     // Catch: java.lang.Throwable -> L74
            f5.t r5 = f5.a.f6498d     // Catch: java.lang.Throwable -> L74
            if (r1 == r5) goto L89
            a5.B0 r5 = a5.C.w(r2, r3, r1)     // Catch: java.lang.Throwable -> L74
            goto L8a
        L89:
            r5 = 0
        L8a:
            r2.resumeWith(r10)     // Catch: java.lang.Throwable -> La2
            if (r5 == 0) goto L95
            boolean r10 = r5.R()     // Catch: java.lang.Throwable -> L74
            if (r10 == 0) goto L98
        L95:
            g(r3, r1)     // Catch: java.lang.Throwable -> L74
        L98:
            boolean r10 = r0.n()     // Catch: java.lang.Throwable -> L74
            if (r10 != 0) goto L98
        L9e:
            r0.j(r4)
            goto Lb3
        La2:
            r10 = move-exception
            if (r5 == 0) goto Lab
            boolean r2 = r5.R()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto Lae
        Lab:
            g(r3, r1)     // Catch: java.lang.Throwable -> L74
        Lae:
            throw r10     // Catch: java.lang.Throwable -> L74
        Laf:
            r9.h(r10)     // Catch: java.lang.Throwable -> Lb4
            goto L9e
        Lb3:
            return
        Lb4:
            r9 = move-exception
            r0.j(r4)
            throw r9
        Lb9:
            r9.resumeWith(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.h(I4.d, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long i(java.lang.String r23, long r24, long r26, long r28) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.a.i(java.lang.String, long, long, long):long");
    }

    public static int j(int i, int i6, String str) {
        return (int) i(str, i, 1, (i6 & 8) != 0 ? com.google.android.gms.common.api.f.API_PRIORITY_OTHER : 2097150);
    }

    public static final Object k(I4.i iVar) {
        Object objFold = iVar.fold(0, e);
        kotlin.jvm.internal.j.b(objFold);
        return objFold;
    }

    public static final Object l(I4.i iVar, Object obj) {
        if (obj == null) {
            obj = k(iVar);
        }
        if (obj == 0) {
            return f6498d;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new w(((Number) obj).intValue(), iVar), f6500g);
        }
        a3.d.r(obj);
        throw null;
    }
}
