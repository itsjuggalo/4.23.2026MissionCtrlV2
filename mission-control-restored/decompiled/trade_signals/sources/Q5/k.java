package Q5;

import R5.H;
import U5.F;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import o5.C2487o;
import p5.z;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends O5.i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f6769k = {O.g(new G(k.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f6770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0 f6771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final H6.i f6772j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6773a = new a("FROM_DEPENDENCIES", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6774b = new a("FROM_CLASS_LOADER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f6775c = new a("FALLBACK", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f6776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f6777e;

        static {
            a[] aVarArrA = a();
            f6776d = aVarArrA;
            f6777e = AbstractC2875b.a(aVarArrA);
        }

        public a(String str, int i8) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f6773a, f6774b, f6775c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f6776d.clone();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H f6778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f6779b;

        public b(H ownerModuleDescriptor, boolean z7) {
            AbstractC2304t.f(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f6778a = ownerModuleDescriptor;
            this.f6779b = z7;
        }

        public final H a() {
            return this.f6778a;
        }

        public final boolean b() {
            return this.f6779b;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6780a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.f6773a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.f6774b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.f6775c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6780a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(H6.n storageManager, a kind) {
        super(storageManager);
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(kind, "kind");
        this.f6770h = kind;
        this.f6772j = storageManager.e(new h(this, storageManager));
        int i8 = c.f6780a[kind.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                f(false);
            } else {
                if (i8 != 3) {
                    throw new C2487o();
                }
                f(true);
            }
        }
    }

    public static final u J0(k kVar, H6.n nVar) {
        F fS = kVar.s();
        AbstractC2304t.e(fS, "getBuiltInsModule(...)");
        return new u(fS, nVar, new j(kVar));
    }

    public static final b K0(k kVar) {
        Function0 function0 = kVar.f6771i;
        if (function0 == null) {
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
        b bVar = (b) function0.invoke();
        kVar.f6771i = null;
        return bVar;
    }

    public static final b O0(H h8, boolean z7) {
        return new b(h8, z7);
    }

    @Override // O5.i
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public List w() {
        Iterable iterableW = super.w();
        AbstractC2304t.e(iterableW, "getClassDescriptorFactories(...)");
        H6.n nVarV = V();
        AbstractC2304t.e(nVarV, "getStorageManager(...)");
        F fS = s();
        AbstractC2304t.e(fS, "getBuiltInsModule(...)");
        return z.q0(iterableW, new g(nVarV, fS, null, 4, null));
    }

    public final u M0() {
        return (u) H6.m.a(this.f6772j, this, f6769k[0]);
    }

    @Override // O5.i
    public T5.c N() {
        return M0();
    }

    public final void N0(H moduleDescriptor, boolean z7) {
        AbstractC2304t.f(moduleDescriptor, "moduleDescriptor");
        P0(new i(moduleDescriptor, z7));
    }

    public final void P0(Function0 computation) {
        AbstractC2304t.f(computation, "computation");
        this.f6771i = computation;
    }

    @Override // O5.i
    public T5.a g() {
        return M0();
    }
}
