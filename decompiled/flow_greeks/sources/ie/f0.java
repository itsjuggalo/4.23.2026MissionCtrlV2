package ie;

import fe.h0;
import ie.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends m implements fe.h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.n f12307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ce.i f12308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ef.f f12309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f12310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i0 f12311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b0 f12312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fe.o0 f12313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wf.g f12315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cd.k f12316l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f0(ef.f moduleName, wf.n storageManager, ce.i builtIns, ff.a aVar) {
        this(moduleName, storageManager, builtIns, aVar, null, null, 48, null);
        kotlin.jvm.internal.t.f(moduleName, "moduleName");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(builtIns, "builtIns");
    }

    private final boolean P0() {
        return this.f12313i != null;
    }

    public static final l R0(f0 f0Var) {
        b0 b0Var = f0Var.f12312h;
        if (b0Var == null) {
            throw new AssertionError("Dependencies of module " + f0Var.L0() + " were not set before querying module content");
        }
        List listA = b0Var.a();
        f0Var.K0();
        listA.contains(f0Var);
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            ((f0) it.next()).P0();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listA, 10));
        Iterator it2 = listA.iterator();
        while (it2.hasNext()) {
            fe.o0 o0Var = ((f0) it2.next()).f12313i;
            kotlin.jvm.internal.t.c(o0Var);
            arrayList.add(o0Var);
        }
        return new l(arrayList, "CompositeProvider@ModuleDescriptor for " + f0Var.getName());
    }

    public static final fe.u0 S0(f0 f0Var, ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return f0Var.f12311g.a(f0Var, fqName, f0Var.f12307c);
    }

    @Override // fe.h0
    public boolean A0(fe.h0 targetModule) {
        kotlin.jvm.internal.t.f(targetModule, "targetModule");
        if (kotlin.jvm.internal.t.b(this, targetModule)) {
            return true;
        }
        b0 b0Var = this.f12312h;
        kotlin.jvm.internal.t.c(b0Var);
        return dd.a0.R(b0Var.b(), targetModule) || r0().contains(targetModule) || targetModule.r0().contains(this);
    }

    @Override // fe.h0
    public Object B(fe.g0 capability) {
        kotlin.jvm.internal.t.f(capability, "capability");
        Object obj = this.f12310f.get(capability);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override // fe.h0
    public fe.u0 I0(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        K0();
        return (fe.u0) this.f12315k.invoke(fqName);
    }

    public void K0() {
        if (Q0()) {
            return;
        }
        fe.c0.a(this);
    }

    public final String L0() {
        String string = getName().toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    public final fe.o0 M0() {
        K0();
        return N0();
    }

    public final l N0() {
        return (l) this.f12316l.getValue();
    }

    public final void O0(fe.o0 providerForModuleContent) {
        kotlin.jvm.internal.t.f(providerForModuleContent, "providerForModuleContent");
        P0();
        this.f12313i = providerForModuleContent;
    }

    public boolean Q0() {
        return this.f12314j;
    }

    public final void T0(b0 dependencies) {
        kotlin.jvm.internal.t.f(dependencies, "dependencies");
        this.f12312h = dependencies;
    }

    public final void U0(List descriptors) {
        kotlin.jvm.internal.t.f(descriptors, "descriptors");
        V0(descriptors, dd.u0.d());
    }

    public final void V0(List descriptors, Set friends) {
        kotlin.jvm.internal.t.f(descriptors, "descriptors");
        kotlin.jvm.internal.t.f(friends, "friends");
        T0(new c0(descriptors, friends, dd.r.k(), dd.u0.d()));
    }

    public final void W0(f0... descriptors) {
        kotlin.jvm.internal.t.f(descriptors, "descriptors");
        U0(dd.n.z0(descriptors));
    }

    @Override // fe.m
    public fe.m b() {
        return h0.a.b(this);
    }

    @Override // fe.h0
    public ce.i p() {
        return this.f12308d;
    }

    @Override // fe.h0
    public List r0() {
        b0 b0Var = this.f12312h;
        if (b0Var != null) {
            return b0Var.c();
        }
        throw new AssertionError("Dependencies of module " + L0() + " were not set");
    }

    @Override // fe.h0
    public Collection t(ef.c fqName, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        K0();
        return M0().t(fqName, nameFilter);
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return h0.a.a(this, oVar, obj);
    }

    @Override // ie.m
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        if (!Q0()) {
            sb2.append(" !isValid");
        }
        sb2.append(" packageFragmentProvider: ");
        fe.o0 o0Var = this.f12313i;
        sb2.append(o0Var != null ? o0Var.getClass().getSimpleName() : null);
        return sb2.toString();
    }

    public /* synthetic */ f0(ef.f fVar, wf.n nVar, ce.i iVar, ff.a aVar, Map map, ef.f fVar2, int i10, kotlin.jvm.internal.k kVar) {
        this(fVar, nVar, iVar, (i10 & 8) != 0 ? null : aVar, (i10 & 16) != 0 ? dd.o0.h() : map, (i10 & 32) != 0 ? null : fVar2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(ef.f moduleName, wf.n storageManager, ce.i builtIns, ff.a aVar, Map capabilities, ef.f fVar) {
        super(ge.h.L.b(), moduleName);
        kotlin.jvm.internal.t.f(moduleName, "moduleName");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(builtIns, "builtIns");
        kotlin.jvm.internal.t.f(capabilities, "capabilities");
        this.f12307c = storageManager;
        this.f12308d = builtIns;
        this.f12309e = fVar;
        if (moduleName.l()) {
            this.f12310f = capabilities;
            i0 i0Var = (i0) B(i0.f12348a.a());
            this.f12311g = i0Var == null ? i0.b.f12351b : i0Var;
            this.f12314j = true;
            this.f12315k = storageManager.i(new d0(this));
            this.f12316l = cd.l.b(new e0(this));
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }
}
