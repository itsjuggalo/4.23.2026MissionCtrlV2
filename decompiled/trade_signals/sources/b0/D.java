package b0;

import Y6.AbstractC1036x;
import Y6.InterfaceC1034v;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7.a f12550a = h7.g.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1034v f12551b = AbstractC1036x.b(null, 1, null);

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12554c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12556e;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12554c = obj;
            this.f12556e |= Integer.MIN_VALUE;
            return D.this.c(this);
        }
    }

    public final Object a(InterfaceC2707e interfaceC2707e) {
        Object objO = this.f12551b.O(interfaceC2707e);
        return objO == AbstractC2751c.f() ? objO : C2470H.f21956a;
    }

    public abstract Object b(InterfaceC2707e interfaceC2707e);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(s5.InterfaceC2707e r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof b0.D.a
            if (r0 == 0) goto L13
            r0 = r7
            b0.D$a r0 = (b0.D.a) r0
            int r1 = r0.f12556e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12556e = r1
            goto L18
        L13:
            b0.D$a r0 = new b0.D$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f12554c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12556e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f12553b
            h7.a r1 = (h7.a) r1
            java.lang.Object r0 = r0.f12552a
            b0.D r0 = (b0.D) r0
            o5.AbstractC2491s.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L8b
        L35:
            r7 = move-exception
            goto L96
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3f:
            java.lang.Object r2 = r0.f12553b
            h7.a r2 = (h7.a) r2
            java.lang.Object r4 = r0.f12552a
            b0.D r4 = (b0.D) r4
            o5.AbstractC2491s.b(r7)
            r7 = r2
            goto L6a
        L4c:
            o5.AbstractC2491s.b(r7)
            Y6.v r7 = r6.f12551b
            boolean r7 = r7.i0()
            if (r7 == 0) goto L5a
            o5.H r7 = o5.C2470H.f21956a
            return r7
        L5a:
            h7.a r7 = r6.f12550a
            r0.f12552a = r6
            r0.f12553b = r7
            r0.f12556e = r4
            java.lang.Object r2 = r7.a(r5, r0)
            if (r2 != r1) goto L69
            return r1
        L69:
            r4 = r6
        L6a:
            Y6.v r2 = r4.f12551b     // Catch: java.lang.Throwable -> L78
            boolean r2 = r2.i0()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            o5.H r0 = o5.C2470H.f21956a     // Catch: java.lang.Throwable -> L78
            r7.d(r5)
            return r0
        L78:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L96
        L7c:
            r0.f12552a = r4     // Catch: java.lang.Throwable -> L78
            r0.f12553b = r7     // Catch: java.lang.Throwable -> L78
            r0.f12556e = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r4.b(r0)     // Catch: java.lang.Throwable -> L78
            if (r0 != r1) goto L89
            return r1
        L89:
            r1 = r7
            r0 = r4
        L8b:
            Y6.v r7 = r0.f12551b     // Catch: java.lang.Throwable -> L35
            o5.H r0 = o5.C2470H.f21956a     // Catch: java.lang.Throwable -> L35
            r7.X(r0)     // Catch: java.lang.Throwable -> L35
            r1.d(r5)
            return r0
        L96:
            r1.d(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.D.c(s5.e):java.lang.Object");
    }
}
