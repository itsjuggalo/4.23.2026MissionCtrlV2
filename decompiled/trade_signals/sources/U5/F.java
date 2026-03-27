package U5;

import R5.H;
import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import U5.I;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import p5.AbstractC2592n;
import p5.AbstractC2595q;
import r6.AbstractC2679a;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends AbstractC0956m implements R5.H {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.n f8195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final O5.i f8196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q6.f f8197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f8198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final I f8199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public B f8200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public R5.O f8201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final H6.g f8203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final InterfaceC2483k f8204l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(q6.f moduleName, H6.n storageManager, O5.i builtIns, AbstractC2679a abstractC2679a) {
        this(moduleName, storageManager, builtIns, abstractC2679a, null, null, 48, null);
        AbstractC2304t.f(moduleName, "moduleName");
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(builtIns, "builtIns");
    }

    private final boolean Q0() {
        return this.f8201i != null;
    }

    public static final C0955l S0(F f8) {
        B b8 = f8.f8200h;
        if (b8 == null) {
            throw new AssertionError("Dependencies of module " + f8.M0() + " were not set before querying module content");
        }
        List listA = b8.a();
        f8.L0();
        listA.contains(f8);
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            ((F) it.next()).Q0();
        }
        ArrayList arrayList = new ArrayList(p5.r.s(listA, 10));
        Iterator it2 = listA.iterator();
        while (it2.hasNext()) {
            R5.O o8 = ((F) it2.next()).f8201i;
            AbstractC2304t.c(o8);
            arrayList.add(o8);
        }
        return new C0955l(arrayList, "CompositeProvider@ModuleDescriptor for " + f8.getName());
    }

    public static final R5.V T0(F f8, q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return f8.f8199g.a(f8, fqName, f8.f8195c);
    }

    public void L0() {
        if (R0()) {
            return;
        }
        R5.C.a(this);
    }

    public final String M0() {
        String string = getName().toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o interfaceC0858o, Object obj) {
        return H.a.a(this, interfaceC0858o, obj);
    }

    public final R5.O N0() {
        L0();
        return O0();
    }

    public final C0955l O0() {
        return (C0955l) this.f8204l.getValue();
    }

    public final void P0(R5.O providerForModuleContent) {
        AbstractC2304t.f(providerForModuleContent, "providerForModuleContent");
        Q0();
        this.f8201i = providerForModuleContent;
    }

    public boolean R0() {
        return this.f8202j;
    }

    public final void U0(B dependencies) {
        AbstractC2304t.f(dependencies, "dependencies");
        this.f8200h = dependencies;
    }

    public final void V0(List descriptors) {
        AbstractC2304t.f(descriptors, "descriptors");
        W0(descriptors, p5.S.d());
    }

    public final void W0(List descriptors, Set friends) {
        AbstractC2304t.f(descriptors, "descriptors");
        AbstractC2304t.f(friends, "friends");
        U0(new C(descriptors, friends, AbstractC2595q.i(), p5.S.d()));
    }

    public final void X0(F... descriptors) {
        AbstractC2304t.f(descriptors, "descriptors");
        V0(AbstractC2592n.k0(descriptors));
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0856m b() {
        return H.a.b(this);
    }

    @Override // R5.H
    public Object f0(R5.G capability) {
        AbstractC2304t.f(capability, "capability");
        Object obj = this.f8198f.get(capability);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override // R5.H
    public O5.i q() {
        return this.f8196d;
    }

    @Override // R5.H
    public boolean s0(R5.H targetModule) {
        AbstractC2304t.f(targetModule, "targetModule");
        if (AbstractC2304t.b(this, targetModule)) {
            return true;
        }
        B b8 = this.f8200h;
        AbstractC2304t.c(b8);
        return p5.z.Q(b8.b(), targetModule) || v0().contains(targetModule) || targetModule.v0().contains(this);
    }

    @Override // U5.AbstractC0956m
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (!R0()) {
            sb.append(" !isValid");
        }
        sb.append(" packageFragmentProvider: ");
        R5.O o8 = this.f8201i;
        sb.append(o8 != null ? o8.getClass().getSimpleName() : null);
        return sb.toString();
    }

    @Override // R5.H
    public R5.V u0(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        L0();
        return (R5.V) this.f8203k.invoke(fqName);
    }

    @Override // R5.H
    public Collection v(q6.c fqName, B5.k nameFilter) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(nameFilter, "nameFilter");
        L0();
        return N0().v(fqName, nameFilter);
    }

    @Override // R5.H
    public List v0() {
        B b8 = this.f8200h;
        if (b8 != null) {
            return b8.c();
        }
        throw new AssertionError("Dependencies of module " + M0() + " were not set");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(q6.f moduleName, H6.n storageManager, O5.i builtIns, AbstractC2679a abstractC2679a, Map capabilities, q6.f fVar) {
        super(S5.h.f7663J.b(), moduleName);
        AbstractC2304t.f(moduleName, "moduleName");
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(builtIns, "builtIns");
        AbstractC2304t.f(capabilities, "capabilities");
        this.f8195c = storageManager;
        this.f8196d = builtIns;
        this.f8197e = fVar;
        if (!moduleName.m()) {
            throw new IllegalArgumentException("Module name must be special: " + moduleName);
        }
        this.f8198f = capabilities;
        I i8 = (I) f0(I.f8215a.a());
        this.f8199g = i8 == null ? I.b.f8218b : i8;
        this.f8202j = true;
        this.f8203k = storageManager.g(new D(this));
        this.f8204l = AbstractC2484l.a(new E(this));
    }

    public /* synthetic */ F(q6.f fVar, H6.n nVar, O5.i iVar, AbstractC2679a abstractC2679a, Map map, q6.f fVar2, int i8, AbstractC2296k abstractC2296k) {
        this(fVar, nVar, iVar, (i8 & 8) != 0 ? null : abstractC2679a, (i8 & 16) != 0 ? p5.M.h() : map, (i8 & 32) != 0 ? null : fVar2);
    }
}
