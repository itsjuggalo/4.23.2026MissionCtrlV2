package m3;

import com.bumptech.glide.load.data.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0.c f15811b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements com.bumptech.glide.load.data.d, d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f15812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s0.c f15813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bumptech.glide.g f15815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.a f15816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f15817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15818g;

        public a(List list, s0.c cVar) {
            this.f15813b = cVar;
            c4.k.d(list);
            this.f15812a = list;
            this.f15814c = 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return ((com.bumptech.glide.load.data.d) this.f15812a.get(0)).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List list = this.f15817f;
            if (list != null) {
                this.f15813b.a(list);
            }
            this.f15817f = null;
            Iterator it = this.f15812a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            ((List) c4.k.e(this.f15817f)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f15818g = true;
            Iterator it = this.f15812a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return ((com.bumptech.glide.load.data.d) this.f15812a.get(0)).d();
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            this.f15815d = gVar;
            this.f15816e = aVar;
            this.f15817f = (List) this.f15813b.b();
            ((com.bumptech.glide.load.data.d) this.f15812a.get(this.f15814c)).e(gVar, this);
            if (this.f15818g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Object obj) {
            if (obj != null) {
                this.f15816e.f(obj);
            } else {
                g();
            }
        }

        public final void g() {
            if (this.f15818g) {
                return;
            }
            if (this.f15814c < this.f15812a.size() - 1) {
                this.f15814c++;
                e(this.f15815d, this.f15816e);
            } else {
                c4.k.e(this.f15817f);
                this.f15816e.c(new i3.q("Fetch failed", new ArrayList(this.f15817f)));
            }
        }
    }

    public q(List list, s0.c cVar) {
        this.f15810a = list;
        this.f15811b = cVar;
    }

    @Override // m3.n
    public boolean a(Object obj) {
        Iterator it = this.f15810a.iterator();
        while (it.hasNext()) {
            if (((n) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // m3.n
    public n.a b(Object obj, int i10, int i11, g3.h hVar) {
        n.a aVarB;
        int size = this.f15810a.size();
        ArrayList arrayList = new ArrayList(size);
        g3.f fVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n nVar = (n) this.f15810a.get(i12);
            if (nVar.a(obj) && (aVarB = nVar.b(obj, i10, i11, hVar)) != null) {
                fVar = aVarB.f15803a;
                arrayList.add(aVarB.f15805c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a(fVar, new a(arrayList, this.f15811b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f15810a.toArray()) + '}';
    }
}
