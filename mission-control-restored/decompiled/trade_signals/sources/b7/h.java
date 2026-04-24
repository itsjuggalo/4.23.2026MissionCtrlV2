package b7;

import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class h {

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f13232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f13234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13235f;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13234e = obj;
            this.f13235f |= Integer.MIN_VALUE;
            return h.c(null, null, false, this);
        }
    }

    public static final Object b(e eVar, a7.w wVar, InterfaceC2707e interfaceC2707e) throws Throwable {
        Object objC = c(eVar, wVar, true, interfaceC2707e);
        return objC == AbstractC2751c.f() ? objC : C2470H.f21956a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(b7.e r6, a7.w r7, boolean r8, s5.InterfaceC2707e r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof b7.h.a
            if (r0 == 0) goto L13
            r0 = r9
            b7.h$a r0 = (b7.h.a) r0
            int r1 = r0.f13235f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13235f = r1
            goto L18
        L13:
            b7.h$a r0 = new b7.h$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f13234e
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13235f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f13233d
            java.lang.Object r6 = r0.f13232c
            a7.i r6 = (a7.i) r6
            java.lang.Object r7 = r0.f13231b
            a7.w r7 = (a7.w) r7
            java.lang.Object r2 = r0.f13230a
            b7.e r2 = (b7.e) r2
            o5.AbstractC2491s.b(r9)     // Catch: java.lang.Throwable -> L3c
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
            boolean r8 = r0.f13233d
            java.lang.Object r6 = r0.f13232c
            a7.i r6 = (a7.i) r6
            java.lang.Object r7 = r0.f13231b
            a7.w r7 = (a7.w) r7
            java.lang.Object r2 = r0.f13230a
            b7.e r2 = (b7.e) r2
            o5.AbstractC2491s.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            o5.AbstractC2491s.b(r9)
            b7.f.k(r6)
            a7.i r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f13230a = r6     // Catch: java.lang.Throwable -> L3c
            r0.f13231b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f13232c = r9     // Catch: java.lang.Throwable -> L3c
            r0.f13233d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f13235f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            return r1
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
            r0.f13230a = r2     // Catch: java.lang.Throwable -> L3c
            r0.f13231b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f13232c = r6     // Catch: java.lang.Throwable -> L3c
            r0.f13233d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f13235f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            a7.n.a(r7, r6)
        L9a:
            o5.H r6 = o5.C2470H.f21956a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            a7.n.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.h.c(b7.e, a7.w, boolean, s5.e):java.lang.Object");
    }
}
