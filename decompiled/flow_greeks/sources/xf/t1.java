package xf;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f25057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f25058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bg.p f25060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f25061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f25062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayDeque f25065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set f25066j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {

        /* JADX INFO: renamed from: xf.t1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0459a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f25067a;

            @Override // xf.t1.a
            public void a(Function0 block) {
                kotlin.jvm.internal.t.f(block, "block");
                if (this.f25067a) {
                    return;
                }
                this.f25067a = ((Boolean) block.invoke()).booleanValue();
            }

            public final boolean b() {
                return this.f25067a;
            }
        }

        void a(Function0 function0);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25068a = new b("CHECK_ONLY_LOWER", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f25069b = new b("CHECK_SUBTYPE_AND_LOWER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f25070c = new b("SKIP_LOWER", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ b[] f25071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ jd.a f25072e;

        static {
            b[] bVarArrA = a();
            f25071d = bVarArrA;
            f25072e = jd.b.a(bVarArrA);
        }

        public b(String str, int i10) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f25068a, f25069b, f25070c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f25071d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static abstract class a extends c {
            public a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f25073a = new b();

            public b() {
                super(null);
            }

            @Override // xf.t1.c
            public bg.j a(t1 state, bg.i type) {
                kotlin.jvm.internal.t.f(state, "state");
                kotlin.jvm.internal.t.f(type, "type");
                return state.j().m(type);
            }
        }

        /* JADX INFO: renamed from: xf.t1$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0460c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0460c f25074a = new C0460c();

            public C0460c() {
                super(null);
            }

            @Override // xf.t1.c
            public /* bridge */ /* synthetic */ bg.j a(t1 t1Var, bg.i iVar) {
                return (bg.j) b(t1Var, iVar);
            }

            public Void b(t1 state, bg.i type) {
                kotlin.jvm.internal.t.f(state, "state");
                kotlin.jvm.internal.t.f(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f25075a = new d();

            public d() {
                super(null);
            }

            @Override // xf.t1.c
            public bg.j a(t1 state, bg.i type) {
                kotlin.jvm.internal.t.f(state, "state");
                kotlin.jvm.internal.t.f(type, "type");
                return state.j().z0(type);
            }
        }

        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }

        public abstract bg.j a(t1 t1Var, bg.i iVar);

        public c() {
        }
    }

    public t1(boolean z10, boolean z11, boolean z12, bg.p typeSystemContext, q kotlinTypePreparator, r kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.t.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f25057a = z10;
        this.f25058b = z11;
        this.f25059c = z12;
        this.f25060d = typeSystemContext;
        this.f25061e = kotlinTypePreparator;
        this.f25062f = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(t1 t1Var, bg.i iVar, bg.i iVar2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return t1Var.c(iVar, iVar2, z10);
    }

    public Boolean c(bg.i subType, bg.i superType, boolean z10) {
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque arrayDeque = this.f25065i;
        kotlin.jvm.internal.t.c(arrayDeque);
        arrayDeque.clear();
        Set set = this.f25066j;
        kotlin.jvm.internal.t.c(set);
        set.clear();
        this.f25064h = false;
    }

    public boolean f(bg.i subType, bg.i superType) {
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return true;
    }

    public b g(bg.j subType, bg.d superType) {
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return b.f25069b;
    }

    public final ArrayDeque h() {
        return this.f25065i;
    }

    public final Set i() {
        return this.f25066j;
    }

    public final bg.p j() {
        return this.f25060d;
    }

    public final void k() {
        this.f25064h = true;
        if (this.f25065i == null) {
            this.f25065i = new ArrayDeque(4);
        }
        if (this.f25066j == null) {
            this.f25066j = hg.l.f11443c.a();
        }
    }

    public final boolean l(bg.i type) {
        kotlin.jvm.internal.t.f(type, "type");
        return this.f25059c && this.f25060d.x0(type);
    }

    public final boolean m() {
        return this.f25057a;
    }

    public final boolean n() {
        return this.f25058b;
    }

    public final bg.i o(bg.i type) {
        kotlin.jvm.internal.t.f(type, "type");
        return this.f25061e.a(type);
    }

    public final bg.i p(bg.i type) {
        kotlin.jvm.internal.t.f(type, "type");
        return this.f25062f.a(type);
    }

    public boolean q(pd.k block) {
        kotlin.jvm.internal.t.f(block, "block");
        a.C0459a c0459a = new a.C0459a();
        block.invoke(c0459a);
        return c0459a.b();
    }
}
