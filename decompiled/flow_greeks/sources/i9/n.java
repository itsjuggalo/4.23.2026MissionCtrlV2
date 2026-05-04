package i9;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8.c f12088b;

    public n(int i10, g8.c cVar) {
        this.f12087a = i10;
        this.f12088b = cVar;
    }

    public static n a(int i10, Map map) {
        g8.c cVarA = j9.i.a();
        for (Map.Entry entry : map.entrySet()) {
            cVarA = cVarA.q((j9.k) entry.getKey(), ((g1) entry.getValue()).a());
        }
        return new n(i10, cVarA);
    }

    public int b() {
        return this.f12087a;
    }

    public g8.c c() {
        return this.f12088b;
    }
}
