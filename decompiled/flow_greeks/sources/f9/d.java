package f9;

import d9.w0;
import j9.k;
import j9.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f9412b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f9417g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f9413c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g8.c f9415e = j9.i.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f9414d = new HashMap();

    public d(a aVar, e eVar) {
        this.f9411a = aVar;
        this.f9412b = eVar;
    }

    public w0 a(c cVar, long j10) {
        x.a(!(cVar instanceof e), "Unexpected bundle metadata element.", new Object[0]);
        int size = this.f9415e.size();
        if (cVar instanceof j) {
            this.f9413c.add((j) cVar);
        } else if (cVar instanceof h) {
            h hVar = (h) cVar;
            this.f9414d.put(hVar.b(), hVar);
            this.f9417g = hVar;
            if (!hVar.a()) {
                this.f9415e = this.f9415e.q(hVar.b(), r.r(hVar.b(), hVar.d()).v(hVar.d()));
                this.f9417g = null;
            }
        } else if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f9417g == null || !bVar.b().equals(this.f9417g.b())) {
                throw new IllegalArgumentException("The document being added does not match the stored metadata.");
            }
            this.f9415e = this.f9415e.q(bVar.b(), bVar.a().v(this.f9417g.d()));
            this.f9417g = null;
        }
        this.f9416f += j10;
        if (size != this.f9415e.size()) {
            return new w0(this.f9415e.size(), this.f9412b.e(), this.f9416f, this.f9412b.d(), null, w0.a.RUNNING);
        }
        return null;
    }

    public g8.c b() {
        x.a(this.f9417g == null, "Bundled documents end with a document metadata element instead of a document.", new Object[0]);
        x.a(this.f9412b.a() != null, "Bundle ID must be set", new Object[0]);
        x.a(this.f9415e.size() == this.f9412b.e(), "Expected %s documents, but loaded %s.", Integer.valueOf(this.f9412b.e()), Integer.valueOf(this.f9415e.size()));
        g8.c cVarA = this.f9411a.a(this.f9415e, this.f9412b.a());
        Map mapC = c();
        for (j jVar : this.f9413c) {
            this.f9411a.b(jVar, (g8.e) mapC.get(jVar.b()));
        }
        this.f9411a.c(this.f9412b);
        return cVarA;
    }

    public final Map c() {
        HashMap map = new HashMap();
        Iterator it = this.f9413c.iterator();
        while (it.hasNext()) {
            map.put(((j) it.next()).b(), k.h());
        }
        for (h hVar : this.f9414d.values()) {
            for (String str : hVar.c()) {
                map.put(str, ((g8.e) map.get(str)).e(hVar.b()));
            }
        }
        return map;
    }
}
