package W0;

import java.security.MessageDigest;
import java.util.Map;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class n implements U0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f9193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f9194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U0.f f9195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f9196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final U0.h f9197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9198j;

    public n(Object obj, U0.f fVar, int i8, int i9, Map map, Class cls, Class cls2, U0.h hVar) {
        this.f9190b = AbstractC2628k.d(obj);
        this.f9195g = (U0.f) AbstractC2628k.e(fVar, "Signature must not be null");
        this.f9191c = i8;
        this.f9192d = i9;
        this.f9196h = (Map) AbstractC2628k.d(map);
        this.f9193e = (Class) AbstractC2628k.e(cls, "Resource class must not be null");
        this.f9194f = (Class) AbstractC2628k.e(cls2, "Transcode class must not be null");
        this.f9197i = (U0.h) AbstractC2628k.d(hVar);
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f9190b.equals(nVar.f9190b) && this.f9195g.equals(nVar.f9195g) && this.f9192d == nVar.f9192d && this.f9191c == nVar.f9191c && this.f9196h.equals(nVar.f9196h) && this.f9193e.equals(nVar.f9193e) && this.f9194f.equals(nVar.f9194f) && this.f9197i.equals(nVar.f9197i);
    }

    @Override // U0.f
    public int hashCode() {
        if (this.f9198j == 0) {
            int iHashCode = this.f9190b.hashCode();
            this.f9198j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f9195g.hashCode()) * 31) + this.f9191c) * 31) + this.f9192d;
            this.f9198j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f9196h.hashCode();
            this.f9198j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f9193e.hashCode();
            this.f9198j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f9194f.hashCode();
            this.f9198j = iHashCode5;
            this.f9198j = (iHashCode5 * 31) + this.f9197i.hashCode();
        }
        return this.f9198j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f9190b + ", width=" + this.f9191c + ", height=" + this.f9192d + ", resourceClass=" + this.f9193e + ", transcodeClass=" + this.f9194f + ", signature=" + this.f9195g + ", hashCode=" + this.f9198j + ", transformations=" + this.f9196h + ", options=" + this.f9197i + '}';
    }
}
