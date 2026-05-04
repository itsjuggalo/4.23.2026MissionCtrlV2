package b4;

import c4.k;
import g3.f;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2936b;

    public b(Object obj) {
        this.f2936b = k.e(obj);
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f2936b.toString().getBytes(f.f10026a));
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f2936b.equals(((b) obj).f2936b);
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        return this.f2936b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f2936b + '}';
    }
}
