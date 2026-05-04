package vf;

import bf.h;
import dd.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class m0 extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fe.n0 f23469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f23470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ef.c f23471i;

    public m0(fe.n0 packageDescriptor, ze.l proto, bf.c nameResolver, bf.a metadataVersion, s sVar, tf.n components, String debugName, Function0 classNames) {
        kotlin.jvm.internal.t.f(packageDescriptor, "packageDescriptor");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(components, "components");
        kotlin.jvm.internal.t.f(debugName, "debugName");
        kotlin.jvm.internal.t.f(classNames, "classNames");
        ze.t tVarV = proto.V();
        kotlin.jvm.internal.t.e(tVarV, "getTypeTable(...)");
        bf.g gVar = new bf.g(tVarV);
        h.a aVar = bf.h.f3348b;
        ze.w wVarW = proto.W();
        kotlin.jvm.internal.t.e(wVarW, "getVersionRequirementTable(...)");
        tf.p pVarA = components.a(packageDescriptor, nameResolver, gVar, aVar.a(wVarW), metadataVersion, sVar);
        List listO = proto.O();
        kotlin.jvm.internal.t.e(listO, "getFunctionList(...)");
        List listR = proto.R();
        kotlin.jvm.internal.t.e(listR, "getPropertyList(...)");
        List listU = proto.U();
        kotlin.jvm.internal.t.e(listU, "getTypeAliasList(...)");
        super(pVarA, listO, listR, listU, classNames);
        this.f23469g = packageDescriptor;
        this.f23470h = debugName;
        this.f23471i = packageDescriptor.e();
    }

    @Override // qf.l, qf.n
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public List g(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        Collection collectionM = m(kindFilter, nameFilter, ne.d.f17046m);
        Iterable iterableL = s().c().l();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterableL.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList, ((he.b) it.next()).b(this.f23471i));
        }
        return dd.a0.s0(collectionM, arrayList);
    }

    public void C(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        me.a.b(s().c().p(), location, this.f23469g, name);
    }

    @Override // vf.w, qf.l, qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        C(name, location);
        return super.e(name, location);
    }

    @Override // vf.w
    public void j(Collection result, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
    }

    @Override // vf.w
    public ef.b p(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return new ef.b(this.f23471i, name);
    }

    public String toString() {
        return this.f23470h;
    }

    @Override // vf.w
    public Set v() {
        return u0.d();
    }

    @Override // vf.w
    public Set w() {
        return u0.d();
    }

    @Override // vf.w
    public Set x() {
        return u0.d();
    }

    @Override // vf.w
    public boolean z(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        if (super.z(name)) {
            return true;
        }
        Iterable iterableL = s().c().l();
        if ((iterableL instanceof Collection) && ((Collection) iterableL).isEmpty()) {
            return false;
        }
        Iterator it = iterableL.iterator();
        while (it.hasNext()) {
            if (((he.b) it.next()).c(this.f23471i, name)) {
                return true;
            }
        }
        return false;
    }
}
