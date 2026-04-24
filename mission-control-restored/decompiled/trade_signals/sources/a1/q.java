package a1;

import a1.n;
import com.bumptech.glide.load.data.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class q implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S.d f9873b;

    public static class a implements com.bumptech.glide.load.data.d, d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f9874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S.d f9875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bumptech.glide.g f9877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.a f9878e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f9879f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f9880g;

        public a(List list, S.d dVar) {
            this.f9875b = dVar;
            AbstractC2628k.c(list);
            this.f9874a = list;
            this.f9876c = 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return ((com.bumptech.glide.load.data.d) this.f9874a.get(0)).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List list = this.f9879f;
            if (list != null) {
                this.f9875b.a(list);
            }
            this.f9879f = null;
            Iterator it = this.f9874a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            ((List) AbstractC2628k.d(this.f9879f)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f9880g = true;
            Iterator it = this.f9874a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return ((com.bumptech.glide.load.data.d) this.f9874a.get(0)).d();
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            this.f9877d = gVar;
            this.f9878e = aVar;
            this.f9879f = (List) this.f9875b.b();
            ((com.bumptech.glide.load.data.d) this.f9874a.get(this.f9876c)).e(gVar, this);
            if (this.f9880g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Object obj) {
            if (obj != null) {
                this.f9878e.f(obj);
            } else {
                g();
            }
        }

        public final void g() {
            if (this.f9880g) {
                return;
            }
            if (this.f9876c < this.f9874a.size() - 1) {
                this.f9876c++;
                e(this.f9877d, this.f9878e);
            } else {
                AbstractC2628k.d(this.f9879f);
                this.f9878e.c(new W0.q("Fetch failed", new ArrayList(this.f9879f)));
            }
        }
    }

    public q(List list, S.d dVar) {
        this.f9872a = list;
        this.f9873b = dVar;
    }

    @Override // a1.n
    public n.a a(Object obj, int i8, int i9, U0.h hVar) {
        n.a aVarA;
        int size = this.f9872a.size();
        ArrayList arrayList = new ArrayList(size);
        U0.f fVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            n nVar = (n) this.f9872a.get(i10);
            if (nVar.b(obj) && (aVarA = nVar.a(obj, i8, i9, hVar)) != null) {
                fVar = aVarA.f9865a;
                arrayList.add(aVarA.f9867c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a(fVar, new a(arrayList, this.f9873b));
    }

    @Override // a1.n
    public boolean b(Object obj) {
        Iterator it = this.f9872a.iterator();
        while (it.hasNext()) {
            if (((n) it.next()).b(obj)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f9872a.toArray()) + '}';
    }
}
