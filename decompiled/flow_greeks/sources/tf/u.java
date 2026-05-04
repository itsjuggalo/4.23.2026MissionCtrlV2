package tf;

import fe.g1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bf.a f22056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vf.s f22057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final bf.d f22058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m0 f22059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ze.m f22060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public qf.k f22061m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ef.c fqName, wf.n storageManager, fe.h0 module, ze.m proto, bf.a metadataVersion, vf.s sVar) {
        super(fqName, storageManager, module);
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        this.f22056h = metadataVersion;
        this.f22057i = sVar;
        ze.p pVarO = proto.O();
        kotlin.jvm.internal.t.e(pVarO, "getStrings(...)");
        ze.o oVarN = proto.N();
        kotlin.jvm.internal.t.e(oVarN, "getQualifiedNames(...)");
        bf.d dVar = new bf.d(pVarO, oVarN);
        this.f22058j = dVar;
        this.f22059k = new m0(proto, dVar, metadataVersion, new s(this));
        this.f22060l = proto;
    }

    public static final g1 O0(u uVar, ef.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        vf.s sVar = uVar.f22057i;
        if (sVar != null) {
            return sVar;
        }
        g1 NO_SOURCE = g1.f9483a;
        kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    public static final Collection Q0(u uVar) {
        Collection collectionB = uVar.F0().b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            ef.b bVar = (ef.b) obj;
            if (!bVar.j() && !l.f21980c.a().contains(bVar)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ef.b) it.next()).h());
        }
        return arrayList2;
    }

    @Override // tf.r
    public void L0(n components) {
        kotlin.jvm.internal.t.f(components, "components");
        ze.m mVar = this.f22060l;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f22060l = null;
        ze.l lVarM = mVar.M();
        kotlin.jvm.internal.t.e(lVarM, "getPackage(...)");
        this.f22061m = new vf.m0(this, lVarM, this.f22058j, this.f22056h, this.f22057i, components, "scope of " + this, new t(this));
    }

    @Override // tf.r
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public m0 F0() {
        return this.f22059k;
    }

    @Override // fe.n0
    public qf.k q() {
        qf.k kVar = this.f22061m;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.t.s("_memberScope");
        return null;
    }
}
