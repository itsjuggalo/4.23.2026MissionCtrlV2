package b6;

import F5.AbstractC0556n;

/* JADX INFO: renamed from: b6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1067f {

    /* JADX INFO: renamed from: b6.f$a */
    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f9054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9055e;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f9054d = obj;
            this.f9055e |= Integer.MIN_VALUE;
            return AbstractC1067f.c(null, this);
        }
    }

    /* JADX INFO: renamed from: b6.f$b */
    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f9057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9058c;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f9057b = obj;
            this.f9058c |= Integer.MIN_VALUE;
            return AbstractC1067f.b(null, this);
        }
    }

    public static final Object a(T[] tArr, H5.d dVar) {
        return tArr.length == 0 ? AbstractC0556n.g() : new C1065e(tArr).c(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.Collection r4, H5.d r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof b6.AbstractC1067f.b
            if (r0 == 0) goto L13
            r0 = r5
            b6.f$b r0 = (b6.AbstractC1067f.b) r0
            int r1 = r0.f9058c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9058c = r1
            goto L18
        L13:
            b6.f$b r0 = new b6.f$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f9057b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f9058c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f9056a
            java.util.Iterator r4 = (java.util.Iterator) r4
            E5.q.b(r5)
            goto L3c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            E5.q.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L3c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            b6.w0 r5 = (b6.InterfaceC1101w0) r5
            r0.f9056a = r4
            r0.f9058c = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L3c
            return r1
        L53:
            E5.E r4 = E5.E.f1657a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.AbstractC1067f.b(java.util.Collection, H5.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(b6.InterfaceC1101w0[] r6, H5.d r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof b6.AbstractC1067f.a
            if (r0 == 0) goto L13
            r0 = r7
            b6.f$a r0 = (b6.AbstractC1067f.a) r0
            int r1 = r0.f9055e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9055e = r1
            goto L18
        L13:
            b6.f$a r0 = new b6.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f9054d
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f9055e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.f9053c
            int r2 = r0.f9052b
            java.lang.Object r4 = r0.f9051a
            b6.w0[] r4 = (b6.InterfaceC1101w0[]) r4
            E5.q.b(r7)
            r7 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            E5.q.b(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L42:
            if (r2 >= r6) goto L57
            r4 = r7[r2]
            r0.f9051a = r7
            r0.f9052b = r2
            r0.f9053c = r6
            r0.f9055e = r3
            java.lang.Object r4 = r4.join(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            E5.E r6 = E5.E.f1657a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.AbstractC1067f.c(b6.w0[], H5.d):java.lang.Object");
    }
}
