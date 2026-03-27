package b7;

import kotlin.jvm.internal.AbstractC2296k;
import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final B5.o f13224e;

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13226b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13228d;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13226b = obj;
            this.f13228d |= Integer.MIN_VALUE;
            return b.this.e(null, this);
        }
    }

    public b(B5.o oVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        super(oVar, interfaceC2711i, i8, aVar);
        this.f13224e = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b7.c, c7.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(a7.v r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof b7.b.a
            if (r0 == 0) goto L13
            r0 = r6
            b7.b$a r0 = (b7.b.a) r0
            int r1 = r0.f13228d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13228d = r1
            goto L18
        L13:
            b7.b$a r0 = new b7.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13226b
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13228d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f13225a
            a7.v r5 = (a7.v) r5
            o5.AbstractC2491s.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            o5.AbstractC2491s.b(r6)
            r0.f13225a = r5
            r0.f13228d = r3
            java.lang.Object r6 = super.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.o()
            if (r5 == 0) goto L4c
            o5.H r5 = o5.C2470H.f21956a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.b.e(a7.v, s5.e):java.lang.Object");
    }

    @Override // b7.c, c7.e
    public c7.e f(InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        return new b(this.f13224e, interfaceC2711i, i8, aVar);
    }

    public /* synthetic */ b(B5.o oVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar, int i9, AbstractC2296k abstractC2296k) {
        this(oVar, (i9 & 2) != 0 ? C2712j.f23116a : interfaceC2711i, (i9 & 4) != 0 ? -2 : i8, (i9 & 8) != 0 ? a7.a.f10173a : aVar);
    }
}
