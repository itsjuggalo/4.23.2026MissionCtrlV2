package Q5;

import O5.o;
import R5.E;
import R5.EnumC0849f;
import R5.H;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import R5.h0;
import U5.C0954k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import p5.AbstractC2594p;
import p5.Q;
import p5.S;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements T5.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q6.f f6759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q6.b f6760h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f6761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f6762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.i f6763c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f6757e = {O.g(new G(g.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f6756d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q6.c f6758f = O5.o.f6087A;

    public static final class a {
        public a() {
        }

        public final q6.b a() {
            return g.f6760h;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        q6.d dVar = o.a.f6168d;
        f6759g = dVar.j();
        f6760h = q6.b.f22655d.c(dVar.m());
    }

    public g(H6.n storageManager, H moduleDescriptor, B5.k computeContainingDeclaration) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(moduleDescriptor, "moduleDescriptor");
        AbstractC2304t.f(computeContainingDeclaration, "computeContainingDeclaration");
        this.f6761a = moduleDescriptor;
        this.f6762b = computeContainingDeclaration;
        this.f6763c = storageManager.e(new e(this, storageManager));
    }

    public static final O5.c d(H module) {
        AbstractC2304t.f(module, "module");
        List listJ = module.u0(f6758f).J();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ) {
            if (obj instanceof O5.c) {
                arrayList.add(obj);
            }
        }
        return (O5.c) z.Y(arrayList);
    }

    public static final C0954k h(g gVar, H6.n nVar) {
        C0954k c0954k = new C0954k((InterfaceC0856m) gVar.f6762b.invoke(gVar.f6761a), f6759g, E.f7200e, EnumC0849f.f7235c, AbstractC2594p.e(gVar.f6761a.q().i()), h0.f7249a, false, nVar);
        c0954k.L0(new Q5.a(nVar, c0954k), S.d(), null);
        return c0954k;
    }

    @Override // T5.b
    public InterfaceC0848e a(q6.b classId) {
        AbstractC2304t.f(classId, "classId");
        if (AbstractC2304t.b(classId, f6760h)) {
            return i();
        }
        return null;
    }

    @Override // T5.b
    public boolean b(q6.c packageFqName, q6.f name) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(name, "name");
        return AbstractC2304t.b(name, f6759g) && AbstractC2304t.b(packageFqName, f6758f);
    }

    @Override // T5.b
    public Collection c(q6.c packageFqName) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        return AbstractC2304t.b(packageFqName, f6758f) ? Q.c(i()) : S.d();
    }

    public final C0954k i() {
        return (C0954k) H6.m.a(this.f6763c, this, f6757e[0]);
    }

    public /* synthetic */ g(H6.n nVar, H h8, B5.k kVar, int i8, AbstractC2296k abstractC2296k) {
        this(nVar, h8, (i8 & 4) != 0 ? f.f6755a : kVar);
    }
}
