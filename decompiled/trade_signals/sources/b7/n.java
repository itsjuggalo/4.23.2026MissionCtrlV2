package b7;

import kotlin.jvm.internal.N;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class n {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f13293a;

        public a(N n8) {
            this.f13293a = n8;
        }

        @Override // b7.e
        public Object emit(Object obj, InterfaceC2707e interfaceC2707e) {
            this.f13293a.f20469a = obj;
            throw new c7.a(this);
        }
    }

    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13297d;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13296c = obj;
            this.f13297d |= Integer.MIN_VALUE;
            return f.l(null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f13298a;

        public c(N n8) {
            this.f13298a = n8;
        }

        @Override // b7.e
        public Object emit(Object obj, InterfaceC2707e interfaceC2707e) {
            this.f13298a.f20469a = obj;
            throw new c7.a(this);
        }
    }

    public static final class d extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13302d;

        public d(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13301c = obj;
            this.f13302d |= Integer.MIN_VALUE;
            return f.m(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(b7.d r4, s5.InterfaceC2707e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof b7.n.b
            if (r0 == 0) goto L13
            r0 = r5
            b7.n$b r0 = (b7.n.b) r0
            int r1 = r0.f13297d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13297d = r1
            goto L18
        L13:
            b7.n$b r0 = new b7.n$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13296c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13297d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f13295b
            b7.n$a r4 = (b7.n.a) r4
            java.lang.Object r0 = r0.f13294a
            kotlin.jvm.internal.N r0 = (kotlin.jvm.internal.N) r0
            o5.AbstractC2491s.b(r5)     // Catch: c7.a -> L31
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
            o5.AbstractC2491s.b(r5)
            kotlin.jvm.internal.N r5 = new kotlin.jvm.internal.N
            r5.<init>()
            d7.D r2 = c7.m.f13599a
            r5.f20469a = r2
            b7.n$a r2 = new b7.n$a
            r2.<init>(r5)
            r0.f13294a = r5     // Catch: c7.a -> L5b
            r0.f13295b = r2     // Catch: c7.a -> L5b
            r0.f13297d = r3     // Catch: c7.a -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: c7.a -> L5b
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
            c7.j.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.f20469a
            d7.D r5 = c7.m.f13599a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.n.a(b7.d, s5.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(b7.d r4, s5.InterfaceC2707e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof b7.n.d
            if (r0 == 0) goto L13
            r0 = r5
            b7.n$d r0 = (b7.n.d) r0
            int r1 = r0.f13302d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13302d = r1
            goto L18
        L13:
            b7.n$d r0 = new b7.n$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13301c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13302d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f13300b
            b7.n$c r4 = (b7.n.c) r4
            java.lang.Object r0 = r0.f13299a
            kotlin.jvm.internal.N r0 = (kotlin.jvm.internal.N) r0
            o5.AbstractC2491s.b(r5)     // Catch: c7.a -> L31
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
            o5.AbstractC2491s.b(r5)
            kotlin.jvm.internal.N r5 = new kotlin.jvm.internal.N
            r5.<init>()
            b7.n$c r2 = new b7.n$c
            r2.<init>(r5)
            r0.f13299a = r5     // Catch: c7.a -> L57
            r0.f13300b = r2     // Catch: c7.a -> L57
            r0.f13302d = r3     // Catch: c7.a -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: c7.a -> L57
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
            c7.j.a(r5, r4)
        L5e:
            java.lang.Object r4 = r0.f20469a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.n.b(b7.d, s5.e):java.lang.Object");
    }
}
