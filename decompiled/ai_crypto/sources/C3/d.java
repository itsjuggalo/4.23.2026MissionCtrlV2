package C3;

import A3.X;
import G3.k;
import G3.r;
import K3.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1034b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f1039g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1035c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r3.c f1037e = G3.i.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f1036d = new HashMap();

    public d(a aVar, e eVar) {
        this.f1033a = aVar;
        this.f1034b = eVar;
    }

    public X a(c cVar, long j7) {
        z.a(!(cVar instanceof e), "Unexpected bundle metadata element.", new Object[0]);
        int size = this.f1037e.size();
        if (cVar instanceof j) {
            this.f1035c.add((j) cVar);
        } else if (cVar instanceof h) {
            h hVar = (h) cVar;
            this.f1036d.put(hVar.b(), hVar);
            this.f1039g = hVar;
            if (!hVar.a()) {
                this.f1037e = this.f1037e.j(hVar.b(), r.s(hVar.b(), hVar.d()).w(hVar.d()));
                this.f1039g = null;
            }
        } else if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f1039g == null || !bVar.b().equals(this.f1039g.b())) {
                throw new IllegalArgumentException("The document being added does not match the stored metadata.");
            }
            this.f1037e = this.f1037e.j(bVar.b(), bVar.a().w(this.f1039g.d()));
            this.f1039g = null;
        }
        this.f1038f += j7;
        if (size != this.f1037e.size()) {
            return new X(this.f1037e.size(), this.f1034b.e(), this.f1038f, this.f1034b.d(), null, X.a.RUNNING);
        }
        return null;
    }

    public r3.c b() {
        z.a(this.f1039g == null, "Bundled documents end with a document metadata element instead of a document.", new Object[0]);
        z.a(this.f1034b.a() != null, "Bundle ID must be set", new Object[0]);
        z.a(this.f1037e.size() == this.f1034b.e(), "Expected %s documents, but loaded %s.", Integer.valueOf(this.f1034b.e()), Integer.valueOf(this.f1037e.size()));
        r3.c cVarC = this.f1033a.c(this.f1037e, this.f1034b.a());
        Map mapC = c();
        for (j jVar : this.f1035c) {
            this.f1033a.a(jVar, (r3.e) mapC.get(jVar.b()));
        }
        this.f1033a.b(this.f1034b);
        return cVarC;
    }

    public final Map c() {
        HashMap map = new HashMap();
        Iterator it = this.f1035c.iterator();
        while (it.hasNext()) {
            map.put(((j) it.next()).b(), k.h());
        }
        for (h hVar : this.f1036d.values()) {
            for (String str : hVar.c()) {
                map.put(str, ((r3.e) map.get(str)).c(hVar.b()));
            }
        }
        return map;
    }
}
