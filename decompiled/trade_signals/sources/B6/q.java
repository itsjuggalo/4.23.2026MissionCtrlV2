package B6;

import R5.EnumC0849f;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.Z;
import R5.g0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import p5.AbstractC2595q;
import p5.z;
import u6.AbstractC2793h;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f222f = {O.g(new G(q.class, "functions", "getFunctions()Ljava/util/List;", 0)), O.g(new G(q.class, DiagnosticsEntry.PROPERTIES_KEY, "getProperties()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0848e f223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.i f225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.i f226e;

    public q(H6.n storageManager, InterfaceC0848e containingClass, boolean z7) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(containingClass, "containingClass");
        this.f223b = containingClass;
        this.f224c = z7;
        containingClass.i();
        EnumC0849f enumC0849f = EnumC0849f.f7234b;
        this.f225d = storageManager.e(new o(this));
        this.f226e = storageManager.e(new p(this));
    }

    public static final List j(q qVar) {
        return AbstractC2595q.l(AbstractC2793h.g(qVar.f223b), AbstractC2793h.h(qVar.f223b));
    }

    public static final List p(q qVar) {
        return qVar.f224c ? AbstractC2595q.m(AbstractC2793h.f(qVar.f223b)) : AbstractC2595q.i();
    }

    @Override // B6.l, B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        List listO = o();
        S6.k kVar = new S6.k();
        for (Object obj : listO) {
            if (AbstractC2304t.b(((Z) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // B6.l, B6.n
    public /* bridge */ /* synthetic */ InterfaceC0851h e(q6.f fVar, Z5.b bVar) {
        return (InterfaceC0851h) k(fVar, bVar);
    }

    public Void k(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return null;
    }

    @Override // B6.l, B6.n
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public List g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return z.r0(n(), o());
    }

    @Override // B6.l, B6.k
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public S6.k d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        List listN = n();
        S6.k kVar = new S6.k();
        for (Object obj : listN) {
            if (AbstractC2304t.b(((g0) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    public final List n() {
        return (List) H6.m.a(this.f225d, this, f222f[0]);
    }

    public final List o() {
        return (List) H6.m.a(this.f226e, this, f222f[1]);
    }
}
