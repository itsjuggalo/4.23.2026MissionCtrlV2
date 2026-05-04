package ee;

import dd.a0;
import fe.h0;
import ie.f0;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends ce.i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f8718k = {n0.g(new g0(k.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f8719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0 f8720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wf.i f8721j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8722a = new a("FROM_DEPENDENCIES", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8723b = new a("FROM_CLASS_LOADER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8724c = new a("FALLBACK", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f8725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ jd.a f8726e;

        static {
            a[] aVarArrA = a();
            f8725d = aVarArrA;
            f8726e = jd.b.a(aVarArrA);
        }

        public a(String str, int i10) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f8722a, f8723b, f8724c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f8725d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0 f8727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f8728b;

        public b(h0 ownerModuleDescriptor, boolean z10) {
            kotlin.jvm.internal.t.f(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f8727a = ownerModuleDescriptor;
            this.f8728b = z10;
        }

        public final h0 a() {
            return this.f8727a;
        }

        public final boolean b() {
            return this.f8728b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8729a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.f8722a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.f8723b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.f8724c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8729a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(wf.n storageManager, a kind) {
        super(storageManager);
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(kind, "kind");
        this.f8719h = kind;
        this.f8721j = storageManager.e(new h(this, storageManager));
        int i10 = c.f8729a[kind.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                f(false);
            } else {
                if (i10 != 3) {
                    throw new cd.o();
                }
                f(true);
            }
        }
    }

    public static final u J0(k kVar, wf.n nVar) {
        f0 f0VarS = kVar.s();
        kotlin.jvm.internal.t.e(f0VarS, "getBuiltInsModule(...)");
        return new u(f0VarS, nVar, new j(kVar));
    }

    public static final b K0(k kVar) {
        Function0 function0 = kVar.f8720i;
        if (function0 == null) {
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
        b bVar = (b) function0.invoke();
        kVar.f8720i = null;
        return bVar;
    }

    public static final b O0(h0 h0Var, boolean z10) {
        return new b(h0Var, z10);
    }

    @Override // ce.i
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public List w() {
        Iterable iterableW = super.w();
        kotlin.jvm.internal.t.e(iterableW, "getClassDescriptorFactories(...)");
        wf.n nVarV = V();
        kotlin.jvm.internal.t.e(nVarV, "getStorageManager(...)");
        f0 f0VarS = s();
        kotlin.jvm.internal.t.e(f0VarS, "getBuiltInsModule(...)");
        return a0.r0(iterableW, new g(nVarV, f0VarS, null, 4, null));
    }

    public final u M0() {
        return (u) wf.m.a(this.f8721j, this, f8718k[0]);
    }

    @Override // ce.i
    public he.c N() {
        return M0();
    }

    public final void N0(h0 moduleDescriptor, boolean z10) {
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        P0(new i(moduleDescriptor, z10));
    }

    public final void P0(Function0 computation) {
        kotlin.jvm.internal.t.f(computation, "computation");
        this.f8720i = computation;
    }

    @Override // ce.i
    public he.a g() {
        return M0();
    }
}
