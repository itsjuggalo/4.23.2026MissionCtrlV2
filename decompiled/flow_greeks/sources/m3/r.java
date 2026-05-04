package m3;

import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f15819e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f15820f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f15822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f15823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0.c f15824d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements n {
        @Override // m3.n
        public boolean a(Object obj) {
            return false;
        }

        @Override // m3.n
        public n.a b(Object obj, int i10, int i11, g3.h hVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f15825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f15826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f15827c;

        public b(Class cls, Class cls2, o oVar) {
            this.f15825a = cls;
            this.f15826b = cls2;
            this.f15827c = oVar;
        }

        public boolean a(Class cls) {
            return this.f15825a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.f15826b.isAssignableFrom(cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public q a(List list, s0.c cVar) {
            return new q(list, cVar);
        }
    }

    public r(s0.c cVar) {
        this(cVar, f15819e);
    }

    public static n f() {
        return f15820f;
    }

    public final void a(Class cls, Class cls2, o oVar, boolean z10) {
        b bVar = new b(cls, cls2, oVar);
        List list = this.f15821a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    public synchronized void b(Class cls, Class cls2, o oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized List c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f15821a) {
                if (!this.f15823c.contains(bVar) && bVar.a(cls)) {
                    this.f15823c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f15823c.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public synchronized n d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b bVar : this.f15821a) {
                if (this.f15823c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f15823c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f15823c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f15822b.a(arrayList, this.f15824d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z10) {
                throw new h.c(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f15823c.clear();
            throw th;
        }
    }

    public final n e(b bVar) {
        return (n) c4.k.e(bVar.f15827c.d(this));
    }

    public synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f15821a) {
            if (!arrayList.contains(bVar.f15826b) && bVar.a(cls)) {
                arrayList.add(bVar.f15826b);
            }
        }
        return arrayList;
    }

    public r(s0.c cVar, c cVar2) {
        this.f15821a = new ArrayList();
        this.f15823c = new HashSet();
        this.f15824d = cVar;
        this.f15822b = cVar2;
    }
}
