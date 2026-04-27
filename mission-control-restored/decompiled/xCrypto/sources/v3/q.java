package v3;

import W2.E;
import W2.p;
import b3.AbstractC0866d;
import t3.H;
import t3.InterfaceC1830o;
import t3.L;
import t3.N;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15379d;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15378c = obj;
            this.f15379d |= Integer.MIN_VALUE;
            return q.a(null, null, this);
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1830o f15380a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC1830o interfaceC1830o) {
            super(1);
            this.f15380a = interfaceC1830o;
        }

        public final void a(Throwable th) {
            InterfaceC1830o interfaceC1830o = this.f15380a;
            p.a aVar = W2.p.f5487b;
            interfaceC1830o.resumeWith(W2.p.b(E.f5463a));
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f5463a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(v3.s r4, kotlin.jvm.functions.Function0 r5, Z2.e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof v3.q.a
            if (r0 == 0) goto L13
            r0 = r6
            v3.q$a r0 = (v3.q.a) r0
            int r1 = r0.f15379d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15379d = r1
            goto L18
        L13:
            v3.q$a r0 = new v3.q$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f15378c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15379d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f15377b
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f15376a
            v3.s r4 = (v3.s) r4
            W2.q.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            W2.q.b(r6)
            Z2.i r6 = r0.getContext()
            t3.w0$b r2 = t3.InterfaceC1846w0.f15039M
            Z2.i$b r6 = r6.get(r2)
            if (r6 != r4) goto L7f
            r0.f15376a = r4     // Catch: java.lang.Throwable -> L32
            r0.f15377b = r5     // Catch: java.lang.Throwable -> L32
            r0.f15379d = r3     // Catch: java.lang.Throwable -> L32
            t3.p r6 = new t3.p     // Catch: java.lang.Throwable -> L32
            Z2.e r2 = a3.AbstractC0786b.c(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.A()     // Catch: java.lang.Throwable -> L32
            v3.q$b r2 = new v3.q$b     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.b(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.x()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = a3.AbstractC0787c.e()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            b3.h.c(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            W2.E r4 = W2.E.f5463a
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.q.a(v3.s, kotlin.jvm.functions.Function0, Z2.e):java.lang.Object");
    }

    public static final t b(L l4, Z2.i iVar, int i4, v3.a aVar, N n4, i3.k kVar, i3.o oVar) {
        r rVar = new r(H.e(l4, iVar), g.b(i4, aVar, null, 4, null));
        if (kVar != null) {
            rVar.invokeOnCompletion(kVar);
        }
        rVar.N0(n4, rVar, oVar);
        return rVar;
    }

    public static /* synthetic */ t c(L l4, Z2.i iVar, int i4, v3.a aVar, N n4, i3.k kVar, i3.o oVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = Z2.j.f6012a;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            aVar = v3.a.SUSPEND;
        }
        if ((i5 & 8) != 0) {
            n4 = N.DEFAULT;
        }
        if ((i5 & 16) != 0) {
            kVar = null;
        }
        i3.k kVar2 = kVar;
        return b(l4, iVar, i4, aVar, n4, kVar2, oVar);
    }
}
