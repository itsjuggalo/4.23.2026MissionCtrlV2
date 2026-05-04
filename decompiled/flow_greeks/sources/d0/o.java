package d0;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f7462g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7464b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7466d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f7463a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7465c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7467e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7468f = -1;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f7469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7475g;

        public a(c0.e eVar, z.d dVar, int i10) {
            this.f7469a = new WeakReference(eVar);
            this.f7470b = dVar.x(eVar.O);
            this.f7471c = dVar.x(eVar.P);
            this.f7472d = dVar.x(eVar.Q);
            this.f7473e = dVar.x(eVar.R);
            this.f7474f = dVar.x(eVar.S);
            this.f7475g = i10;
        }
    }

    public o(int i10) {
        int i11 = f7462g;
        f7462g = i11 + 1;
        this.f7464b = i11;
        this.f7466d = i10;
    }

    public boolean a(c0.e eVar) {
        if (this.f7463a.contains(eVar)) {
            return false;
        }
        this.f7463a.add(eVar);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f7463a.size();
        if (this.f7468f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                o oVar = (o) arrayList.get(i10);
                if (this.f7468f == oVar.f7464b) {
                    g(this.f7466d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f7464b;
    }

    public int d() {
        return this.f7466d;
    }

    public final String e() {
        int i10 = this.f7466d;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    public int f(z.d dVar, int i10) {
        if (this.f7463a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f7463a, i10);
    }

    public void g(int i10, o oVar) {
        for (c0.e eVar : this.f7463a) {
            oVar.a(eVar);
            if (i10 == 0) {
                eVar.I0 = oVar.c();
            } else {
                eVar.J0 = oVar.c();
            }
        }
        this.f7468f = oVar.f7464b;
    }

    public void h(boolean z10) {
        this.f7465c = z10;
    }

    public void i(int i10) {
        this.f7466d = i10;
    }

    public final int j(z.d dVar, ArrayList arrayList, int i10) {
        int iX;
        int iX2;
        c0.f fVar = (c0.f) ((c0.e) arrayList.get(0)).I();
        dVar.D();
        fVar.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((c0.e) arrayList.get(i11)).g(dVar, false);
        }
        if (i10 == 0 && fVar.W0 > 0) {
            c0.b.b(fVar, dVar, arrayList, 0);
        }
        if (i10 == 1 && fVar.X0 > 0) {
            c0.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f7467e = new ArrayList();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f7467e.add(new a((c0.e) arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            iX = dVar.x(fVar.O);
            iX2 = dVar.x(fVar.Q);
            dVar.D();
        } else {
            iX = dVar.x(fVar.P);
            iX2 = dVar.x(fVar.R);
            dVar.D();
        }
        return iX2 - iX;
    }

    public String toString() {
        String str = e() + " [" + this.f7464b + "] <";
        Iterator it = this.f7463a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((c0.e) it.next()).r();
        }
        return str + " >";
    }
}
