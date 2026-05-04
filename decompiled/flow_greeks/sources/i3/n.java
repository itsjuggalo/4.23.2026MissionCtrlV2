package i3;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements g3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f11732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f11733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g3.f f11734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f11735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g3.h f11736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11737j;

    public n(Object obj, g3.f fVar, int i10, int i11, Map map, Class cls, Class cls2, g3.h hVar) {
        this.f11729b = c4.k.e(obj);
        this.f11734g = (g3.f) c4.k.f(fVar, "Signature must not be null");
        this.f11730c = i10;
        this.f11731d = i11;
        this.f11735h = (Map) c4.k.e(map);
        this.f11732e = (Class) c4.k.f(cls, "Resource class must not be null");
        this.f11733f = (Class) c4.k.f(cls2, "Transcode class must not be null");
        this.f11736i = (g3.h) c4.k.e(hVar);
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f11729b.equals(nVar.f11729b) && this.f11734g.equals(nVar.f11734g) && this.f11731d == nVar.f11731d && this.f11730c == nVar.f11730c && this.f11735h.equals(nVar.f11735h) && this.f11732e.equals(nVar.f11732e) && this.f11733f.equals(nVar.f11733f) && this.f11736i.equals(nVar.f11736i)) {
                return true;
            }
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        if (this.f11737j == 0) {
            int iHashCode = this.f11729b.hashCode();
            this.f11737j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f11734g.hashCode()) * 31) + this.f11730c) * 31) + this.f11731d;
            this.f11737j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f11735h.hashCode();
            this.f11737j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f11732e.hashCode();
            this.f11737j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f11733f.hashCode();
            this.f11737j = iHashCode5;
            this.f11737j = (iHashCode5 * 31) + this.f11736i.hashCode();
        }
        return this.f11737j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f11729b + ", width=" + this.f11730c + ", height=" + this.f11731d + ", resourceClass=" + this.f11732e + ", transcodeClass=" + this.f11733f + ", signature=" + this.f11734g + ", hashCode=" + this.f11737j + ", transformations=" + this.f11735h + ", options=" + this.f11736i + '}';
    }
}
