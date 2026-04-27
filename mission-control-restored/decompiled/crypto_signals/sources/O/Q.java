package O;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends K4.j implements R4.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.q f2139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.q f2142d;
    public final /* synthetic */ S e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2143f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f2144k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(kotlin.jvm.internal.q qVar, S s6, Object obj, boolean z6, I4.d dVar) {
        super(2, dVar);
        this.f2142d = qVar;
        this.e = s6;
        this.f2143f = obj;
        this.f2144k = z6;
    }

    @Override // K4.a
    public final I4.d create(Object obj, I4.d dVar) {
        Q q6 = new Q(this.f2142d, this.e, this.f2143f, this.f2144k, dVar);
        q6.f2141c = obj;
        return q6;
    }

    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) {
        return ((Q) create((H0) obj, (I4.d) obj2)).invokeSuspend(G4.l.f540a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r6.a(r3, r7) == r0) goto L16;
     */
    @Override // K4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            J4.a r0 = J4.a.f791a
            int r1 = r7.f2140b
            kotlin.jvm.internal.q r2 = r7.f2142d
            java.lang.Object r3 = r7.f2143f
            O.S r4 = r7.e
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            a.AbstractC0284a.E(r8)
            goto L59
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.jvm.internal.q r1 = r7.f2139a
            java.lang.Object r6 = r7.f2141c
            O.H0 r6 = (O.H0) r6
            a.AbstractC0284a.E(r8)
            goto L43
        L28:
            a.AbstractC0284a.E(r8)
            java.lang.Object r8 = r7.f2141c
            O.H0 r8 = (O.H0) r8
            O.e0 r1 = r4.g()
            r7.f2141c = r8
            r7.f2139a = r2
            r7.f2140b = r6
            java.lang.Object r1 = r1.a(r7)
            if (r1 != r0) goto L40
            goto L58
        L40:
            r6 = r8
            r8 = r1
            r1 = r2
        L43:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f7932a = r8
            r8 = 0
            r7.f2141c = r8
            r7.f2139a = r8
            r7.f2140b = r5
            java.lang.Object r8 = r6.a(r3, r7)
            if (r8 != r0) goto L59
        L58:
            return r0
        L59:
            boolean r8 = r7.f2144k
            if (r8 == 0) goto L71
            Q3.h r8 = r4.f2151h
            O.e r0 = new O.e
            if (r3 == 0) goto L68
            int r1 = r3.hashCode()
            goto L69
        L68:
            r1 = 0
        L69:
            int r2 = r2.f7932a
            r0.<init>(r3, r1, r2)
            r8.J(r0)
        L71:
            G4.l r8 = G4.l.f540a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: O.Q.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
