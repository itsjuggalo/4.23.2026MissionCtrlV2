package k9;

import j9.v;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f14783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f14784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.protobuf.i f14786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g8.c f14787e;

    public h(g gVar, v vVar, List list, com.google.protobuf.i iVar, g8.c cVar) {
        this.f14783a = gVar;
        this.f14784b = vVar;
        this.f14785c = list;
        this.f14786d = iVar;
        this.f14787e = cVar;
    }

    public static h a(g gVar, v vVar, List list, com.google.protobuf.i iVar) {
        n9.b.d(gVar.h().size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(gVar.h().size()), Integer.valueOf(list.size()));
        g8.c cVarC = j9.i.c();
        List listH = gVar.h();
        g8.c cVarQ = cVarC;
        for (int i10 = 0; i10 < listH.size(); i10++) {
            cVarQ = cVarQ.q(((f) listH.get(i10)).g(), ((i) list.get(i10)).b());
        }
        return new h(gVar, vVar, list, iVar, cVarQ);
    }

    public g b() {
        return this.f14783a;
    }

    public v c() {
        return this.f14784b;
    }

    public g8.c d() {
        return this.f14787e;
    }

    public List e() {
        return this.f14785c;
    }

    public com.google.protobuf.i f() {
        return this.f14786d;
    }
}
