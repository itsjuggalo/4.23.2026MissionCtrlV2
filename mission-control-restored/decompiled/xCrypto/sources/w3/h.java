package w3;

import W2.E;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f15597e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15598f;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15597e = obj;
            this.f15598f |= Integer.MIN_VALUE;
            return h.c(null, null, false, this);
        }
    }

    public static final Object b(e eVar, v3.t tVar, Z2.e eVar2) throws Throwable {
        Object objC = c(eVar, tVar, true, eVar2);
        return objC == AbstractC0787c.e() ? objC : E.f5463a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r2.emit(r9, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(w3.e r6, v3.t r7, boolean r8, Z2.e r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof w3.h.a
            if (r0 == 0) goto L13
            r0 = r9
            w3.h$a r0 = (w3.h.a) r0
            int r1 = r0.f15598f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15598f = r1
            goto L18
        L13:
            w3.h$a r0 = new w3.h$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f15597e
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15598f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f15596d
            java.lang.Object r6 = r0.f15595c
            v3.f r6 = (v3.f) r6
            java.lang.Object r7 = r0.f15594b
            v3.t r7 = (v3.t) r7
            java.lang.Object r2 = r0.f15593a
            w3.e r2 = (w3.e) r2
            W2.q.b(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.f15596d
            java.lang.Object r6 = r0.f15595c
            v3.f r6 = (v3.f) r6
            java.lang.Object r7 = r0.f15594b
            v3.t r7 = (v3.t) r7
            java.lang.Object r2 = r0.f15593a
            w3.e r2 = (w3.e) r2
            W2.q.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            W2.q.b(r9)
            w3.f.j(r6)
            v3.f r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f15593a = r6     // Catch: java.lang.Throwable -> L3c
            r0.f15594b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f15595c = r9     // Catch: java.lang.Throwable -> L3c
            r0.f15596d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f15598f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            goto L93
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.f15593a = r2     // Catch: java.lang.Throwable -> L3c
            r0.f15594b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f15595c = r6     // Catch: java.lang.Throwable -> L3c
            r0.f15596d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f15598f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
        L93:
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            v3.k.a(r7, r6)
        L9a:
            W2.E r6 = W2.E.f5463a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            v3.k.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.h.c(w3.e, v3.t, boolean, Z2.e):java.lang.Object");
    }
}
