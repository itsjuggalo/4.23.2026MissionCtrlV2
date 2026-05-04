package oa;

import java.util.Iterator;
import java.util.Set;
import o7.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f17694b;

    public c(Set set, d dVar) {
        this.f17693a = d(set);
        this.f17694b = dVar;
    }

    public static /* synthetic */ i b(o7.d dVar) {
        return new c(dVar.c(f.class), d.a());
    }

    public static o7.c c() {
        return o7.c.c(i.class).b(q.o(f.class)).f(new o7.g() { // from class: oa.b
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return c.b(dVar);
            }
        }).d();
    }

    public static String d(Set set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb2.append(fVar.b());
            sb2.append('/');
            sb2.append(fVar.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // oa.i
    public String a() {
        if (this.f17694b.b().isEmpty()) {
            return this.f17693a;
        }
        return this.f17693a + ' ' + d(this.f17694b.b());
    }
}
