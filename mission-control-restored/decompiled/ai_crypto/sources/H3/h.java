package H3;

import G3.v;
import K3.AbstractC0612b;
import com.google.protobuf.AbstractC1240i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f2645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC1240i f2647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r3.c f2648e;

    public h(g gVar, v vVar, List list, AbstractC1240i abstractC1240i, r3.c cVar) {
        this.f2644a = gVar;
        this.f2645b = vVar;
        this.f2646c = list;
        this.f2647d = abstractC1240i;
        this.f2648e = cVar;
    }

    public static h a(g gVar, v vVar, List list, AbstractC1240i abstractC1240i) {
        AbstractC0612b.d(gVar.h().size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(gVar.h().size()), Integer.valueOf(list.size()));
        r3.c cVarC = G3.i.c();
        List listH = gVar.h();
        r3.c cVarJ = cVarC;
        for (int i7 = 0; i7 < listH.size(); i7++) {
            cVarJ = cVarJ.j(((f) listH.get(i7)).g(), ((i) list.get(i7)).b());
        }
        return new h(gVar, vVar, list, abstractC1240i, cVarJ);
    }

    public g b() {
        return this.f2644a;
    }

    public v c() {
        return this.f2645b;
    }

    public r3.c d() {
        return this.f2648e;
    }

    public List e() {
        return this.f2646c;
    }

    public AbstractC1240i f() {
        return this.f2647d;
    }
}
