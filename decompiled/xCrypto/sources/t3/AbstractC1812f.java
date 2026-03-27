package t3;

import X2.AbstractC0769p;
import b3.AbstractC0866d;

/* JADX INFO: renamed from: t3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1812f {

    /* JADX INFO: renamed from: t3.f$a */
    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f14993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f14996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14997e;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f14996d = obj;
            this.f14997e |= Integer.MIN_VALUE;
            return AbstractC1812f.c(null, this);
        }
    }

    /* JADX INFO: renamed from: t3.f$b */
    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f14998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15000c;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f14999b = obj;
            this.f15000c |= Integer.MIN_VALUE;
            return AbstractC1812f.b(null, this);
        }
    }

    public static final Object a(T[] tArr, Z2.e eVar) {
        return tArr.length == 0 ? AbstractC0769p.g() : new C1810e(tArr).c(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.Collection r4, Z2.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof t3.AbstractC1812f.b
            if (r0 == 0) goto L13
            r0 = r5
            t3.f$b r0 = (t3.AbstractC1812f.b) r0
            int r1 = r0.f15000c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15000c = r1
            goto L18
        L13:
            t3.f$b r0 = new t3.f$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f14999b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15000c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f14998a
            java.util.Iterator r4 = (java.util.Iterator) r4
            W2.q.b(r5)
            goto L3c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            W2.q.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L3c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            t3.w0 r5 = (t3.InterfaceC1846w0) r5
            r0.f14998a = r4
            r0.f15000c = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L3c
            return r1
        L53:
            W2.E r4 = W2.E.f5463a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.AbstractC1812f.b(java.util.Collection, Z2.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(t3.InterfaceC1846w0[] r6, Z2.e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof t3.AbstractC1812f.a
            if (r0 == 0) goto L13
            r0 = r7
            t3.f$a r0 = (t3.AbstractC1812f.a) r0
            int r1 = r0.f14997e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14997e = r1
            goto L18
        L13:
            t3.f$a r0 = new t3.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f14996d
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f14997e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.f14995c
            int r2 = r0.f14994b
            java.lang.Object r4 = r0.f14993a
            t3.w0[] r4 = (t3.InterfaceC1846w0[]) r4
            W2.q.b(r7)
            r7 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            W2.q.b(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L42:
            if (r2 >= r6) goto L57
            r4 = r7[r2]
            r0.f14993a = r7
            r0.f14994b = r2
            r0.f14995c = r6
            r0.f14997e = r3
            java.lang.Object r4 = r4.join(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            W2.E r6 = W2.E.f5463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.AbstractC1812f.c(t3.w0[], Z2.e):java.lang.Object");
    }
}
