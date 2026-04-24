package F3;

import java.util.Map;

/* JADX INFO: renamed from: F3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0516n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r3.c f2223b;

    public C0516n(int i7, r3.c cVar) {
        this.f2222a = i7;
        this.f2223b = cVar;
    }

    public static C0516n a(int i7, Map map) {
        r3.c cVarA = G3.i.a();
        for (Map.Entry entry : map.entrySet()) {
            cVarA = cVarA.j((G3.k) entry.getKey(), ((C0499h0) entry.getValue()).a());
        }
        return new C0516n(i7, cVarA);
    }

    public int b() {
        return this.f2222a;
    }

    public r3.c c() {
        return this.f2223b;
    }
}
