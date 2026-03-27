package b7;

import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: b7.a$a, reason: collision with other inner class name */
    public static final class C0224a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13221b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13223d;

        public C0224a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13221b = obj;
            this.f13223d |= Integer.MIN_VALUE;
            return a.this.collect(null, this);
        }
    }

    public abstract Object c(e eVar, InterfaceC2707e interfaceC2707e);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(b7.e r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof b7.a.C0224a
            if (r0 == 0) goto L13
            r0 = r7
            b7.a$a r0 = (b7.a.C0224a) r0
            int r1 = r0.f13223d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13223d = r1
            goto L18
        L13:
            b7.a$a r0 = new b7.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f13221b
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13223d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f13220a
            c7.o r6 = (c7.o) r6
            o5.AbstractC2491s.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            o5.AbstractC2491s.b(r7)
            c7.o r7 = new c7.o
            s5.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f13220a = r7     // Catch: java.lang.Throwable -> L55
            r0.f13223d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.c(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            o5.H r6 = o5.C2470H.f21956a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.a.collect(b7.e, s5.e):java.lang.Object");
    }
}
