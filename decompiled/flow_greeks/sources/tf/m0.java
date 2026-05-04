package tf;

import fe.g1;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.c f21989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf.a f21990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f21991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f21992d;

    public m0(ze.m proto, bf.c nameResolver, bf.a metadataVersion, pd.k classSource) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(classSource, "classSource");
        this.f21989a = nameResolver;
        this.f21990b = metadataVersion;
        this.f21991c = classSource;
        List listJ = proto.J();
        kotlin.jvm.internal.t.e(listJ, "getClass_List(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(listJ, 10)), 16));
        for (Object obj : listJ) {
            linkedHashMap.put(l0.a(this.f21989a, ((ze.c) obj).E0()), obj);
        }
        this.f21992d = linkedHashMap;
    }

    @Override // tf.j
    public i a(ef.b classId) {
        kotlin.jvm.internal.t.f(classId, "classId");
        ze.c cVar = (ze.c) this.f21992d.get(classId);
        if (cVar == null) {
            return null;
        }
        return new i(this.f21989a, cVar, this.f21990b, (g1) this.f21991c.invoke(classId));
    }

    public final Collection b() {
        return this.f21992d.keySet();
    }
}
