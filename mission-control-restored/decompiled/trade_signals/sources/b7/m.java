package b7;

import kotlin.jvm.internal.K;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class m {

    public static final class a implements b7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b7.d f13270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ B5.o f13271b;

        public a(b7.d dVar, B5.o oVar) {
            this.f13270a = dVar;
            this.f13271b = oVar;
        }

        @Override // b7.d
        public Object collect(e eVar, InterfaceC2707e interfaceC2707e) {
            Object objCollect = this.f13270a.collect(new b(new K(), eVar, this.f13271b), interfaceC2707e);
            return objCollect == AbstractC2751c.f() ? objCollect : C2470H.f21956a;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K f13272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f13273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ B5.o f13274c;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13275a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f13276b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f13277c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f13279e;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13277c = obj;
                this.f13279e |= Integer.MIN_VALUE;
                return b.this.emit(null, this);
            }
        }

        public b(K k8, e eVar, B5.o oVar) {
            this.f13272a = k8;
            this.f13273b = eVar;
            this.f13274c = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r7, s5.InterfaceC2707e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof b7.m.b.a
                if (r0 == 0) goto L13
                r0 = r8
                b7.m$b$a r0 = (b7.m.b.a) r0
                int r1 = r0.f13279e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13279e = r1
                goto L18
            L13:
                b7.m$b$a r0 = new b7.m$b$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f13277c
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13279e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                o5.AbstractC2491s.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f13276b
                java.lang.Object r2 = r0.f13275a
                b7.m$b r2 = (b7.m.b) r2
                o5.AbstractC2491s.b(r8)
                goto L6c
            L41:
                o5.AbstractC2491s.b(r8)
                goto L59
            L45:
                o5.AbstractC2491s.b(r8)
                kotlin.jvm.internal.K r8 = r6.f13272a
                boolean r8 = r8.f20466a
                if (r8 == 0) goto L5c
                b7.e r8 = r6.f13273b
                r0.f13279e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L59
                return r1
            L59:
                o5.H r7 = o5.C2470H.f21956a
                return r7
            L5c:
                B5.o r8 = r6.f13274c
                r0.f13275a = r6
                r0.f13276b = r7
                r0.f13279e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                return r1
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.K r8 = r2.f13272a
                r8.f20466a = r5
                b7.e r8 = r2.f13273b
                r2 = 0
                r0.f13275a = r2
                r0.f13276b = r2
                r0.f13279e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L88
                return r1
            L88:
                o5.H r7 = o5.C2470H.f21956a
                return r7
            L8b:
                o5.H r7 = o5.C2470H.f21956a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.m.b.emit(java.lang.Object, s5.e):java.lang.Object");
        }
    }

    public static final class c implements b7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b7.d f13280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ B5.o f13281b;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13282a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13283b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13285d;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13282a = obj;
                this.f13283b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(b7.d dVar, B5.o oVar) {
            this.f13280a = dVar;
            this.f13281b = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(b7.e r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof b7.m.c.a
                if (r0 == 0) goto L13
                r0 = r7
                b7.m$c$a r0 = (b7.m.c.a) r0
                int r1 = r0.f13283b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13283b = r1
                goto L18
            L13:
                b7.m$c$a r0 = new b7.m$c$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f13282a
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13283b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.f13285d
                b7.m$d r6 = (b7.m.d) r6
                o5.AbstractC2491s.b(r7)     // Catch: c7.a -> L2d
                goto L53
            L2d:
                r7 = move-exception
                goto L50
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                o5.AbstractC2491s.b(r7)
                b7.d r7 = r5.f13280a
                b7.m$d r2 = new b7.m$d
                B5.o r4 = r5.f13281b
                r2.<init>(r4, r6)
                r0.f13285d = r2     // Catch: c7.a -> L4e
                r0.f13283b = r3     // Catch: c7.a -> L4e
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch: c7.a -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                c7.j.a(r7, r6)
            L53:
                o5.H r6 = o5.C2470H.f21956a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.m.c.collect(b7.e, s5.e):java.lang.Object");
        }
    }

    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B5.o f13286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f13287b;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13288a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f13289b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f13290c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13292e;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13289b = obj;
                this.f13290c |= Integer.MIN_VALUE;
                return d.this.emit(null, this);
            }
        }

        public d(B5.o oVar, e eVar) {
            this.f13286a = oVar;
            this.f13287b = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(java.lang.Object r8, s5.InterfaceC2707e r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof b7.m.d.a
                if (r0 == 0) goto L13
                r0 = r9
                b7.m$d$a r0 = (b7.m.d.a) r0
                int r1 = r0.f13290c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13290c = r1
                goto L18
            L13:
                b7.m$d$a r0 = new b7.m$d$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f13289b
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13290c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.f13288a
                b7.m$d r8 = (b7.m.d) r8
                o5.AbstractC2491s.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.f13292e
                java.lang.Object r2 = r0.f13288a
                b7.m$d r2 = (b7.m.d) r2
                o5.AbstractC2491s.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                o5.AbstractC2491s.b(r9)
                B5.o r9 = r7.f13286a
                r0.f13288a = r7
                r0.f13292e = r8
                r0.f13290c = r4
                r2 = 6
                kotlin.jvm.internal.r.a(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.r.a(r2)
                if (r9 != r1) goto L60
                return r1
            L60:
                r2 = r9
                r9 = r8
                r8 = r7
            L63:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L7b
                b7.e r2 = r8.f13287b
                r0.f13288a = r8
                r5 = 0
                r0.f13292e = r5
                r0.f13290c = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L7c
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                o5.H r8 = o5.C2470H.f21956a
                return r8
            L81:
                c7.a r9 = new c7.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.m.d.emit(java.lang.Object, s5.e):java.lang.Object");
        }
    }

    public static final b7.d a(b7.d dVar, B5.o oVar) {
        return new a(dVar, oVar);
    }

    public static final b7.d b(b7.d dVar, B5.o oVar) {
        return new c(dVar, oVar);
    }
}
