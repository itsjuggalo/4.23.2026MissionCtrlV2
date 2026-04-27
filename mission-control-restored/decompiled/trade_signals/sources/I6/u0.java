package I6;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M6.p f4471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC0637q f4472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f4473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayDeque f4476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set f4477j;

    public interface a {

        /* JADX INFO: renamed from: I6.u0$a$a, reason: collision with other inner class name */
        public static final class C0054a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f4478a;

            @Override // I6.u0.a
            public void a(Function0 block) {
                AbstractC2304t.f(block, "block");
                if (this.f4478a) {
                    return;
                }
                this.f4478a = ((Boolean) block.invoke()).booleanValue();
            }

            public final boolean b() {
                return this.f4478a;
            }
        }

        void a(Function0 function0);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4479a = new b("CHECK_ONLY_LOWER", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f4480b = new b("CHECK_SUBTYPE_AND_LOWER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4481c = new b("SKIP_LOWER", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ b[] f4482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f4483e;

        static {
            b[] bVarArrA = a();
            f4482d = bVarArrA;
            f4483e = AbstractC2875b.a(bVarArrA);
        }

        public b(String str, int i8) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f4479a, f4480b, f4481c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f4482d.clone();
        }
    }

    public static abstract class c {

        public static abstract class a extends c {
            public a() {
                super(null);
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f4484a = new b();

            public b() {
                super(null);
            }

            @Override // I6.u0.c
            public M6.j a(u0 state, M6.i type) {
                AbstractC2304t.f(state, "state");
                AbstractC2304t.f(type, "type");
                return state.j().H0(type);
            }
        }

        /* JADX INFO: renamed from: I6.u0$c$c, reason: collision with other inner class name */
        public static final class C0055c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0055c f4485a = new C0055c();

            public C0055c() {
                super(null);
            }

            @Override // I6.u0.c
            public /* bridge */ /* synthetic */ M6.j a(u0 u0Var, M6.i iVar) {
                return (M6.j) b(u0Var, iVar);
            }

            public Void b(u0 state, M6.i type) {
                AbstractC2304t.f(state, "state");
                AbstractC2304t.f(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f4486a = new d();

            public d() {
                super(null);
            }

            @Override // I6.u0.c
            public M6.j a(u0 state, M6.i type) {
                AbstractC2304t.f(state, "state");
                AbstractC2304t.f(type, "type");
                return state.j().w0(type);
            }
        }

        public c() {
        }

        public abstract M6.j a(u0 u0Var, M6.i iVar);

        public /* synthetic */ c(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public u0(boolean z7, boolean z8, boolean z9, M6.p typeSystemContext, AbstractC0637q kotlinTypePreparator, r kotlinTypeRefiner) {
        AbstractC2304t.f(typeSystemContext, "typeSystemContext");
        AbstractC2304t.f(kotlinTypePreparator, "kotlinTypePreparator");
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f4468a = z7;
        this.f4469b = z8;
        this.f4470c = z9;
        this.f4471d = typeSystemContext;
        this.f4472e = kotlinTypePreparator;
        this.f4473f = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(u0 u0Var, M6.i iVar, M6.i iVar2, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return u0Var.c(iVar, iVar2, z7);
    }

    public Boolean c(M6.i subType, M6.i superType, boolean z7) {
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque arrayDeque = this.f4476i;
        AbstractC2304t.c(arrayDeque);
        arrayDeque.clear();
        Set set = this.f4477j;
        AbstractC2304t.c(set);
        set.clear();
        this.f4475h = false;
    }

    public boolean f(M6.i subType, M6.i superType) {
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superType, "superType");
        return true;
    }

    public b g(M6.j subType, M6.d superType) {
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superType, "superType");
        return b.f4480b;
    }

    public final ArrayDeque h() {
        return this.f4476i;
    }

    public final Set i() {
        return this.f4477j;
    }

    public final M6.p j() {
        return this.f4471d;
    }

    public final void k() {
        this.f4475h = true;
        if (this.f4476i == null) {
            this.f4476i = new ArrayDeque(4);
        }
        if (this.f4477j == null) {
            this.f4477j = S6.l.f7769c.a();
        }
    }

    public final boolean l(M6.i type) {
        AbstractC2304t.f(type, "type");
        return this.f4470c && this.f4471d.n0(type);
    }

    public final boolean m() {
        return this.f4468a;
    }

    public final boolean n() {
        return this.f4469b;
    }

    public final M6.i o(M6.i type) {
        AbstractC2304t.f(type, "type");
        return this.f4472e.a(type);
    }

    public final M6.i p(M6.i type) {
        AbstractC2304t.f(type, "type");
        return this.f4473f.a(type);
    }

    public boolean q(B5.k block) {
        AbstractC2304t.f(block, "block");
        a.C0054a c0054a = new a.C0054a();
        block.invoke(c0054a);
        return c0054a.b();
    }
}
