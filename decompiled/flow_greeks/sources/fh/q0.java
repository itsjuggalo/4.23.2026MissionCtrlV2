package fh;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fh.a f9610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9613d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.k implements pd.p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f9615c;

        public a(gd.e eVar) {
            super(3, eVar);
        }

        @Override // pd.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(cd.c cVar, cd.h0 h0Var, gd.e eVar) {
            a aVar = q0.this.new a(eVar);
            aVar.f9615c = cVar;
            return aVar.invokeSuspend(cd.h0.f3852a);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f9614b;
            if (i10 == 0) {
                cd.s.b(obj);
                cd.c cVar = (cd.c) this.f9615c;
                byte bF = q0.this.f9610a.F();
                if (bF == 1) {
                    return q0.this.j(true);
                }
                if (bF == 0) {
                    return q0.this.j(false);
                }
                if (bF != 6) {
                    if (bF == 8) {
                        return q0.this.f();
                    }
                    fh.a.x(q0.this.f9610a, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new cd.h();
                }
                q0 q0Var = q0.this;
                this.f9614b = 1;
                obj = q0Var.i(cVar, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return (eh.i) obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f9618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f9620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f9621e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9623g;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f9621e = obj;
            this.f9623g |= Integer.MIN_VALUE;
            return q0.this.i(null, this);
        }
    }

    public q0(eh.g configuration, fh.a lexer) {
        kotlin.jvm.internal.t.f(configuration, "configuration");
        kotlin.jvm.internal.t.f(lexer, "lexer");
        this.f9610a = lexer;
        this.f9611b = configuration.q();
        this.f9612c = configuration.d();
    }

    public final eh.i e() {
        byte bF = this.f9610a.F();
        if (bF == 1) {
            return j(true);
        }
        if (bF == 0) {
            return j(false);
        }
        if (bF == 6) {
            int i10 = this.f9613d + 1;
            this.f9613d = i10;
            this.f9613d--;
            return i10 == 200 ? g() : h();
        }
        if (bF == 8) {
            return f();
        }
        fh.a.x(this.f9610a, "Cannot read Json element because of unexpected " + fh.b.c(bF), 0, null, 6, null);
        throw new cd.h();
    }

    public final eh.i f() {
        byte bJ = this.f9610a.j();
        if (this.f9610a.F() == 4) {
            fh.a.x(this.f9610a, "Unexpected leading comma", 0, null, 6, null);
            throw new cd.h();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f9610a.e()) {
            arrayList.add(e());
            bJ = this.f9610a.j();
            if (bJ != 4) {
                fh.a aVar = this.f9610a;
                boolean z10 = bJ == 9;
                int i10 = aVar.f9544a;
                if (!z10) {
                    fh.a.x(aVar, "Expected end of the array or comma", i10, null, 4, null);
                    throw new cd.h();
                }
            }
        }
        if (bJ == 8) {
            this.f9610a.k((byte) 9);
        } else if (bJ == 4) {
            if (!this.f9612c) {
                c0.h(this.f9610a, "array");
                throw new cd.h();
            }
            this.f9610a.k((byte) 9);
        }
        return new eh.c(arrayList);
    }

    public final eh.i g() {
        return (eh.i) cd.b.b(new cd.a(new a(null)), cd.h0.f3852a);
    }

    public final eh.i h() {
        byte bK = this.f9610a.k((byte) 6);
        if (this.f9610a.F() == 4) {
            fh.a.x(this.f9610a, "Unexpected leading comma", 0, null, 6, null);
            throw new cd.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.f9610a.e()) {
                break;
            }
            String strQ = this.f9611b ? this.f9610a.q() : this.f9610a.o();
            this.f9610a.k((byte) 5);
            linkedHashMap.put(strQ, e());
            bK = this.f9610a.j();
            if (bK != 4) {
                if (bK != 7) {
                    fh.a.x(this.f9610a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new cd.h();
                }
            }
        }
        if (bK == 6) {
            this.f9610a.k((byte) 7);
        } else if (bK == 4) {
            if (!this.f9612c) {
                c0.i(this.f9610a, null, 1, null);
                throw new cd.h();
            }
            this.f9610a.k((byte) 7);
        }
        return new eh.c0(linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0096 -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(cd.c r20, gd.e r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fh.q0.i(cd.c, gd.e):java.lang.Object");
    }

    public final eh.e0 j(boolean z10) {
        String strQ = (this.f9611b || !z10) ? this.f9610a.q() : this.f9610a.o();
        return (z10 || !kotlin.jvm.internal.t.b(strQ, "null")) ? new eh.v(strQ, z10, null, 4, null) : eh.z.INSTANCE;
    }
}
