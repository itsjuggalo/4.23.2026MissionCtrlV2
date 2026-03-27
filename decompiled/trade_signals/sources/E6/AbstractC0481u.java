package E6;

import G6.InterfaceC0581s;
import R5.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2427a;
import n6.C2430d;

/* JADX INFO: renamed from: E6.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0481u extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AbstractC2427a f1036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC0581s f1037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C2430d f1038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final M f1039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l6.m f1040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public B6.k f1041m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0481u(q6.c fqName, H6.n storageManager, R5.H module, l6.m proto, AbstractC2427a metadataVersion, InterfaceC0581s interfaceC0581s) {
        super(fqName, storageManager, module);
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(module, "module");
        AbstractC2304t.f(proto, "proto");
        AbstractC2304t.f(metadataVersion, "metadataVersion");
        this.f1036h = metadataVersion;
        this.f1037i = interfaceC0581s;
        l6.p pVarP = proto.P();
        AbstractC2304t.e(pVarP, "getStrings(...)");
        l6.o oVarO = proto.O();
        AbstractC2304t.e(oVarO, "getQualifiedNames(...)");
        C2430d c2430d = new C2430d(pVarP, oVarO);
        this.f1038j = c2430d;
        this.f1039k = new M(proto, c2430d, metadataVersion, new C0479s(this));
        this.f1040l = proto;
    }

    public static final h0 P0(AbstractC0481u abstractC0481u, q6.b it) {
        AbstractC2304t.f(it, "it");
        InterfaceC0581s interfaceC0581s = abstractC0481u.f1037i;
        if (interfaceC0581s != null) {
            return interfaceC0581s;
        }
        h0 NO_SOURCE = h0.f7249a;
        AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    public static final Collection R0(AbstractC0481u abstractC0481u) {
        Collection collectionB = abstractC0481u.H0().b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            q6.b bVar = (q6.b) obj;
            if (!bVar.j() && !C0473l.f992c.a().contains(bVar)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(p5.r.s(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((q6.b) it.next()).h());
        }
        return arrayList2;
    }

    @Override // E6.r
    public void M0(C0475n components) {
        AbstractC2304t.f(components, "components");
        l6.m mVar = this.f1040l;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.f1040l = null;
        l6.l lVarN = mVar.N();
        AbstractC2304t.e(lVarN, "getPackage(...)");
        this.f1041m = new G6.M(this, lVarN, this.f1038j, this.f1036h, this.f1037i, components, "scope of " + this, new C0480t(this));
    }

    @Override // E6.r
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public M H0() {
        return this.f1039k;
    }

    @Override // R5.N
    public B6.k r() {
        B6.k kVar = this.f1041m;
        if (kVar != null) {
            return kVar;
        }
        AbstractC2304t.s("_memberScope");
        return null;
    }
}
