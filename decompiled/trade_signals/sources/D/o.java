package D;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f708g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f710b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f712d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f709a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f711c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f713e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f714f = -1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f721g;

        public a(C.e eVar, z.d dVar, int i8) {
            this.f715a = new WeakReference(eVar);
            this.f716b = dVar.x(eVar.f311O);
            this.f717c = dVar.x(eVar.f312P);
            this.f718d = dVar.x(eVar.f313Q);
            this.f719e = dVar.x(eVar.f314R);
            this.f720f = dVar.x(eVar.f315S);
            this.f721g = i8;
        }
    }

    public o(int i8) {
        int i9 = f708g;
        f708g = i9 + 1;
        this.f710b = i9;
        this.f712d = i8;
    }

    public boolean a(C.e eVar) {
        if (this.f709a.contains(eVar)) {
            return false;
        }
        this.f709a.add(eVar);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f709a.size();
        if (this.f714f != -1 && size > 0) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                o oVar = (o) arrayList.get(i8);
                if (this.f714f == oVar.f710b) {
                    g(this.f712d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f710b;
    }

    public int d() {
        return this.f712d;
    }

    public final String e() {
        int i8 = this.f712d;
        return i8 == 0 ? "Horizontal" : i8 == 1 ? "Vertical" : i8 == 2 ? "Both" : "Unknown";
    }

    public int f(z.d dVar, int i8) {
        if (this.f709a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f709a, i8);
    }

    public void g(int i8, o oVar) {
        for (C.e eVar : this.f709a) {
            oVar.a(eVar);
            int iC = oVar.c();
            if (i8 == 0) {
                eVar.f304I0 = iC;
            } else {
                eVar.f306J0 = iC;
            }
        }
        this.f714f = oVar.f710b;
    }

    public void h(boolean z7) {
        this.f711c = z7;
    }

    public void i(int i8) {
        this.f712d = i8;
    }

    public final int j(z.d dVar, ArrayList arrayList, int i8) {
        int iX;
        C.d dVar2;
        C.f fVar = (C.f) ((C.e) arrayList.get(0)).I();
        dVar.D();
        fVar.g(dVar, false);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            ((C.e) arrayList.get(i9)).g(dVar, false);
        }
        if (i8 == 0 && fVar.f392W0 > 0) {
            C.b.b(fVar, dVar, arrayList, 0);
        }
        if (i8 == 1 && fVar.f393X0 > 0) {
            C.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        this.f713e = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f713e.add(new a((C.e) arrayList.get(i10), dVar, i8));
        }
        if (i8 == 0) {
            iX = dVar.x(fVar.f311O);
            dVar2 = fVar.f313Q;
        } else {
            iX = dVar.x(fVar.f312P);
            dVar2 = fVar.f314R;
        }
        int iX2 = dVar.x(dVar2);
        dVar.D();
        return iX2 - iX;
    }

    public String toString() {
        String str = e() + " [" + this.f710b + "] <";
        Iterator it = this.f709a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((C.e) it.next()).r();
        }
        return str + " >";
    }
}
