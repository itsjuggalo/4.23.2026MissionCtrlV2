package ee;

import ce.o;
import dd.a0;
import dd.t0;
import dd.u0;
import fe.e0;
import fe.g1;
import fe.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements he.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ef.f f8708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ef.b f8709h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f8710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f8711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f8712c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f8706e = {n0.g(new g0(g.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8705d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ef.c f8707f = ce.o.A;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final ef.b a() {
            return g.f8709h;
        }

        public a() {
        }
    }

    static {
        ef.d dVar = o.a.f3979d;
        f8708g = dVar.j();
        f8709h = ef.b.f8779d.c(dVar.m());
    }

    public g(wf.n storageManager, h0 moduleDescriptor, pd.k computeContainingDeclaration) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(computeContainingDeclaration, "computeContainingDeclaration");
        this.f8710a = moduleDescriptor;
        this.f8711b = computeContainingDeclaration;
        this.f8712c = storageManager.e(new e(this, storageManager));
    }

    public static final ce.c d(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        List listJ = module.I0(f8707f).J();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ) {
            if (obj instanceof ce.c) {
                arrayList.add(obj);
            }
        }
        return (ce.c) a0.Z(arrayList);
    }

    public static final ie.k h(g gVar, wf.n nVar) {
        ie.k kVar = new ie.k((fe.m) gVar.f8711b.invoke(gVar.f8710a), f8708g, e0.f9464e, fe.f.f9474c, dd.q.e(gVar.f8710a.p().i()), g1.f9483a, false, nVar);
        kVar.K0(new ee.a(nVar, kVar), u0.d(), null);
        return kVar;
    }

    @Override // he.b
    public fe.e a(ef.b classId) {
        kotlin.jvm.internal.t.f(classId, "classId");
        if (kotlin.jvm.internal.t.b(classId, f8709h)) {
            return i();
        }
        return null;
    }

    @Override // he.b
    public Collection b(ef.c packageFqName) {
        kotlin.jvm.internal.t.f(packageFqName, "packageFqName");
        return kotlin.jvm.internal.t.b(packageFqName, f8707f) ? t0.c(i()) : u0.d();
    }

    @Override // he.b
    public boolean c(ef.c packageFqName, ef.f name) {
        kotlin.jvm.internal.t.f(packageFqName, "packageFqName");
        kotlin.jvm.internal.t.f(name, "name");
        return kotlin.jvm.internal.t.b(name, f8708g) && kotlin.jvm.internal.t.b(packageFqName, f8707f);
    }

    public final ie.k i() {
        return (ie.k) wf.m.a(this.f8712c, this, f8706e[0]);
    }

    public /* synthetic */ g(wf.n nVar, h0 h0Var, pd.k kVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(nVar, h0Var, (i10 & 4) != 0 ? f.f8704a : kVar);
    }
}
