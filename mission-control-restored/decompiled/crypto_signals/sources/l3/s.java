package l3;

import O.InterfaceC0187j;
import a5.C;
import i3.l0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f8143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0187j f8144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f8145c;

    public s(I4.i backgroundDispatcher, l0 timeProvider, InterfaceC0187j sessionConfigsDataStore) {
        kotlin.jvm.internal.j.e(backgroundDispatcher, "backgroundDispatcher");
        kotlin.jvm.internal.j.e(timeProvider, "timeProvider");
        kotlin.jvm.internal.j.e(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.f8143a = timeProvider;
        this.f8144b = sessionConfigsDataStore;
        this.f8145c = new AtomicReference();
        C.p(C.b(backgroundDispatcher), new o(this, null));
    }

    public final j a() throws Throwable {
        AtomicReference atomicReference = this.f8145c;
        if (atomicReference.get() == null) {
            Object objT = C.t(new p(this, null));
            while (!atomicReference.compareAndSet(null, objT) && atomicReference.get() == null) {
            }
        }
        Object obj = atomicReference.get();
        kotlin.jvm.internal.j.d(obj, "get(...)");
        return (j) obj;
    }

    public final boolean b() throws Throwable {
        Integer num;
        j jVarA = a();
        j jVarA2 = a();
        Long l6 = jVarA.e;
        if (l6 == null || (num = jVarA2.f8125d) == null) {
            return true;
        }
        return this.f8143a.a().f6980c - l6.longValue() >= ((long) num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(l3.j r6, K4.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof l3.q
            if (r0 == 0) goto L13
            r0 = r7
            l3.q r0 = (l3.q) r0
            int r1 = r0.f8141c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8141c = r1
            goto L18
        L13:
            l3.q r0 = new l3.q
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8139a
            J4.a r1 = J4.a.f791a
            int r2 = r0.f8141c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            a.AbstractC0284a.E(r7)     // Catch: java.io.IOException -> L27
            goto L58
        L27:
            r6 = move-exception
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            a.AbstractC0284a.E(r7)
            O.j r7 = r5.f8144b     // Catch: java.io.IOException -> L27
            l3.r r2 = new l3.r     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L27
            r0.f8141c = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = r7.a(r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L58
            return r1
        L45:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to update config values: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L58:
            G4.l r6 = G4.l.f540a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.s.c(l3.j, K4.c):java.lang.Object");
    }
}
