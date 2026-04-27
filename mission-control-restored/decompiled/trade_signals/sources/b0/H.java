package b0;

import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2775b;
import u5.AbstractC2777d;
import u5.AbstractC2785l;

/* JADX INFO: loaded from: classes.dex */
public final class H implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h7.a f12571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1171b f12572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.d f12573d;

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12576c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12578e;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12576c = obj;
            this.f12578e |= Integer.MIN_VALUE;
            return H.this.c(null, this);
        }
    }

    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12581c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12583e;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12581c = obj;
            this.f12583e |= Integer.MIN_VALUE;
            return H.this.b(null, this);
        }
    }

    public static final class c extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12584a;

        public c(InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b7.e eVar, InterfaceC2707e interfaceC2707e) {
            return ((c) create(eVar, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new c(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2751c.f();
            if (this.f12584a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
            return C2470H.f21956a;
        }
    }

    public H(String filePath) {
        AbstractC2304t.f(filePath, "filePath");
        this.f12570a = filePath;
        this.f12571b = h7.g.b(false, 1, null);
        this.f12572c = new C1171b(0);
        this.f12573d = b7.f.n(new c(null));
    }

    @Override // b0.t
    public Object a(InterfaceC2707e interfaceC2707e) {
        return AbstractC2775b.c(this.f12572c.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b0.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(B5.o r7, s5.InterfaceC2707e r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof b0.H.b
            if (r0 == 0) goto L13
            r0 = r8
            b0.H$b r0 = (b0.H.b) r0
            int r1 = r0.f12583e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12583e = r1
            goto L18
        L13:
            b0.H$b r0 = new b0.H$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f12581c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12583e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            boolean r7 = r0.f12580b
            java.lang.Object r0 = r0.f12579a
            h7.a r0 = (h7.a) r0
            o5.AbstractC2491s.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L57
        L30:
            r8 = move-exception
            goto L61
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            o5.AbstractC2491s.b(r8)
            h7.a r8 = r6.f12571b
            boolean r2 = r8.b(r4)
            java.lang.Boolean r5 = u5.AbstractC2775b.a(r2)     // Catch: java.lang.Throwable -> L5d
            r0.f12579a = r8     // Catch: java.lang.Throwable -> L5d
            r0.f12580b = r2     // Catch: java.lang.Throwable -> L5d
            r0.f12583e = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 != r1) goto L54
            return r1
        L54:
            r0 = r8
            r8 = r7
            r7 = r2
        L57:
            if (r7 == 0) goto L5c
            r0.d(r4)
        L5c:
            return r8
        L5d:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L61:
            if (r7 == 0) goto L66
            r0.d(r4)
        L66:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.H.b(B5.o, s5.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b0.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(B5.k r8, s5.InterfaceC2707e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof b0.H.a
            if (r0 == 0) goto L13
            r0 = r9
            b0.H$a r0 = (b0.H.a) r0
            int r1 = r0.f12578e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12578e = r1
            goto L18
        L13:
            b0.H$a r0 = new b0.H$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f12576c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12578e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.f12574a
            h7.a r8 = (h7.a) r8
            o5.AbstractC2491s.b(r9)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r9 = move-exception
            goto L73
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.f12575b
            h7.a r8 = (h7.a) r8
            java.lang.Object r2 = r0.f12574a
            B5.k r2 = (B5.k) r2
            o5.AbstractC2491s.b(r9)
            r9 = r8
            r8 = r2
            goto L5b
        L49:
            o5.AbstractC2491s.b(r9)
            h7.a r9 = r7.f12571b
            r0.f12574a = r8
            r0.f12575b = r9
            r0.f12578e = r4
            java.lang.Object r2 = r9.a(r5, r0)
            if (r2 != r1) goto L5b
            return r1
        L5b:
            r0.f12574a = r9     // Catch: java.lang.Throwable -> L6f
            r0.f12575b = r5     // Catch: java.lang.Throwable -> L6f
            r0.f12578e = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6f
            if (r8 != r1) goto L68
            return r1
        L68:
            r6 = r9
            r9 = r8
            r8 = r6
        L6b:
            r8.d(r5)
            return r9
        L6f:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L73:
            r8.d(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.H.c(B5.k, s5.e):java.lang.Object");
    }

    @Override // b0.t
    public Object d(InterfaceC2707e interfaceC2707e) {
        return AbstractC2775b.c(this.f12572c.b());
    }

    @Override // b0.t
    public b7.d e() {
        return this.f12573d;
    }
}
