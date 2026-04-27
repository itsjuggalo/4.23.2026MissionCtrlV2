package w3;

import b3.AbstractC0866d;
import kotlin.jvm.internal.F;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class n {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F f15656a;

        public a(F f4) {
            this.f15656a = f4;
        }

        @Override // w3.e
        public Object emit(Object obj, Z2.e eVar) {
            this.f15656a.f13410a = obj;
            throw new x3.a(this);
        }
    }

    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15660d;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15659c = obj;
            this.f15660d |= Integer.MIN_VALUE;
            return f.k(null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F f15661a;

        public c(F f4) {
            this.f15661a = f4;
        }

        @Override // w3.e
        public Object emit(Object obj, Z2.e eVar) {
            this.f15661a.f13410a = obj;
            throw new x3.a(this);
        }
    }

    public static final class d extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15665d;

        public d(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15664c = obj;
            this.f15665d |= Integer.MIN_VALUE;
            return f.l(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(w3.d r4, Z2.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof w3.n.b
            if (r0 == 0) goto L13
            r0 = r5
            w3.n$b r0 = (w3.n.b) r0
            int r1 = r0.f15660d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15660d = r1
            goto L18
        L13:
            w3.n$b r0 = new w3.n$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f15659c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15660d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f15658b
            w3.n$a r4 = (w3.n.a) r4
            java.lang.Object r0 = r0.f15657a
            kotlin.jvm.internal.F r0 = (kotlin.jvm.internal.F) r0
            W2.q.b(r5)     // Catch: x3.a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            W2.q.b(r5)
            kotlin.jvm.internal.F r5 = new kotlin.jvm.internal.F
            r5.<init>()
            y3.F r2 = x3.m.f15775a
            r5.f13410a = r2
            w3.n$a r2 = new w3.n$a
            r2.<init>(r5)
            r0.f15657a = r5     // Catch: x3.a -> L5b
            r0.f15658b = r2     // Catch: x3.a -> L5b
            r0.f15660d = r3     // Catch: x3.a -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: x3.a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            x3.j.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.f13410a
            y3.F r5 = x3.m.f15775a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.n.a(w3.d, Z2.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(w3.d r4, Z2.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof w3.n.d
            if (r0 == 0) goto L13
            r0 = r5
            w3.n$d r0 = (w3.n.d) r0
            int r1 = r0.f15665d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15665d = r1
            goto L18
        L13:
            w3.n$d r0 = new w3.n$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f15664c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15665d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f15663b
            w3.n$c r4 = (w3.n.c) r4
            java.lang.Object r0 = r0.f15662a
            kotlin.jvm.internal.F r0 = (kotlin.jvm.internal.F) r0
            W2.q.b(r5)     // Catch: x3.a -> L31
            goto L5e
        L31:
            r5 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            W2.q.b(r5)
            kotlin.jvm.internal.F r5 = new kotlin.jvm.internal.F
            r5.<init>()
            w3.n$c r2 = new w3.n$c
            r2.<init>(r5)
            r0.f15662a = r5     // Catch: x3.a -> L57
            r0.f15663b = r2     // Catch: x3.a -> L57
            r0.f15665d = r3     // Catch: x3.a -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: x3.a -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r0 = r5
            goto L5e
        L57:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5b:
            x3.j.a(r5, r4)
        L5e:
            java.lang.Object r4 = r0.f13410a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.n.b(w3.d, Z2.e):java.lang.Object");
    }
}
