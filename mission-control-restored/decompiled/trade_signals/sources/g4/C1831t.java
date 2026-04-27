package g4;

import kotlin.jvm.internal.AbstractC2296k;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: renamed from: g4.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1831t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f18213c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18215b;

    /* JADX INFO: renamed from: g4.t$a */
    public static final class a {

        /* JADX INFO: renamed from: g4.t$a$a, reason: collision with other inner class name */
        public static final class C0308a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f18216a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f18217b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f18219d;

            public C0308a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f18217b = obj;
                this.f18219d |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [T3.h] */
        /* JADX WARN: Type inference failed for: r9v0, types: [T3.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(T3.h r9, s5.InterfaceC2707e r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof g4.C1831t.a.C0308a
                if (r0 == 0) goto L13
                r0 = r10
                g4.t$a$a r0 = (g4.C1831t.a.C0308a) r0
                int r1 = r0.f18219d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f18219d = r1
                goto L18
            L13:
                g4.t$a$a r0 = new g4.t$a$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f18217b
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f18219d
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                r5 = 1
                java.lang.String r6 = ""
                if (r2 == 0) goto L48
                if (r2 == r5) goto L3e
                if (r2 != r4) goto L36
                java.lang.Object r9 = r0.f18216a
                java.lang.String r9 = (java.lang.String) r9
                o5.AbstractC2491s.b(r10)     // Catch: java.lang.Exception -> L34
                goto L85
            L34:
                r10 = move-exception
                goto L8c
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f18216a
                T3.h r9 = (T3.h) r9
                o5.AbstractC2491s.b(r10)     // Catch: java.lang.Exception -> L46
                goto L60
            L46:
                r10 = move-exception
                goto L6a
            L48:
                o5.AbstractC2491s.b(r10)
                r10 = 0
                l2.l r10 = r9.a(r10)     // Catch: java.lang.Exception -> L46
                java.lang.String r2 = "getToken(...)"
                kotlin.jvm.internal.AbstractC2304t.e(r10, r2)     // Catch: java.lang.Exception -> L46
                r0.f18216a = r9     // Catch: java.lang.Exception -> L46
                r0.f18219d = r5     // Catch: java.lang.Exception -> L46
                java.lang.Object r10 = i7.b.a(r10, r0)     // Catch: java.lang.Exception -> L46
                if (r10 != r1) goto L60
                return r1
            L60:
                T3.m r10 = (T3.m) r10     // Catch: java.lang.Exception -> L46
                java.lang.String r10 = r10.b()     // Catch: java.lang.Exception -> L46
                r7 = r10
                r10 = r9
                r9 = r7
                goto L71
            L6a:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r3, r2, r10)
                r10 = r9
                r9 = r6
            L71:
                l2.l r10 = r10.getId()     // Catch: java.lang.Exception -> L34
                java.lang.String r2 = "getId(...)"
                kotlin.jvm.internal.AbstractC2304t.e(r10, r2)     // Catch: java.lang.Exception -> L34
                r0.f18216a = r9     // Catch: java.lang.Exception -> L34
                r0.f18219d = r4     // Catch: java.lang.Exception -> L34
                java.lang.Object r10 = i7.b.a(r10, r0)     // Catch: java.lang.Exception -> L34
                if (r10 != r1) goto L85
                return r1
            L85:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L34
                if (r10 != 0) goto L8a
                goto L91
            L8a:
                r6 = r10
                goto L91
            L8c:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r3, r0, r10)
            L91:
                g4.t r10 = new g4.t
                r0 = 0
                r10.<init>(r6, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: g4.C1831t.a.a(T3.h, s5.e):java.lang.Object");
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C1831t(String str, String str2) {
        this.f18214a = str;
        this.f18215b = str2;
    }

    public final String a() {
        return this.f18215b;
    }

    public final String b() {
        return this.f18214a;
    }

    public /* synthetic */ C1831t(String str, String str2, AbstractC2296k abstractC2296k) {
        this(str, str2);
    }
}
