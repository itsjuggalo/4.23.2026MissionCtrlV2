package p0;

import java.util.ArrayList;

/* JADX INFO: renamed from: p0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0890b extends t {
    public ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f8994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f8995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f8996h;
    public ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f8997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f8998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f8999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f9000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f9001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f9002o;

    public static void c(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    @Override // p0.t
    public final void a() {
        ArrayList arrayList = this.f8995g;
        int size = arrayList.size() - 1;
        if (size >= 0) {
            a3.d.r(arrayList.get(size));
            throw null;
        }
        ArrayList arrayList2 = this.e;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            if (arrayList2.get(size2) != null) {
                throw new ClassCastException();
            }
            if (this.f9045a != null) {
                throw null;
            }
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f8994f;
        int size3 = arrayList3.size() - 1;
        if (size3 >= 0) {
            arrayList3.get(size3).getClass();
            throw new ClassCastException();
        }
        ArrayList arrayList4 = this.f8996h;
        int size4 = arrayList4.size() - 1;
        if (size4 >= 0) {
            a3.d.r(arrayList4.get(size4));
            throw null;
        }
        arrayList4.clear();
        if (b()) {
            ArrayList arrayList5 = this.f8997j;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                int size6 = arrayList6.size() - 1;
                if (size6 >= 0) {
                    a3.d.r(arrayList6.get(size6));
                    throw null;
                }
            }
            ArrayList arrayList7 = this.i;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                int size8 = arrayList8.size() - 1;
                if (size8 >= 0) {
                    arrayList8.get(size8).getClass();
                    throw new ClassCastException();
                }
            }
            ArrayList arrayList9 = this.f8998k;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                int size10 = arrayList10.size() - 1;
                if (size10 >= 0) {
                    a3.d.r(arrayList10.get(size10));
                    throw null;
                }
            }
            c(this.f9001n);
            c(this.f9000m);
            c(this.f8999l);
            c(this.f9002o);
            ArrayList arrayList11 = this.f9046b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // p0.t
    public final boolean b() {
        return (this.f8994f.isEmpty() && this.f8996h.isEmpty() && this.f8995g.isEmpty() && this.e.isEmpty() && this.f9000m.isEmpty() && this.f9001n.isEmpty() && this.f8999l.isEmpty() && this.f9002o.isEmpty() && this.f8997j.isEmpty() && this.i.isEmpty() && this.f8998k.isEmpty()) ? false : true;
    }
}
