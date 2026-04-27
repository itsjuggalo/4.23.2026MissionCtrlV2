package w4;

import java.util.Arrays;
import u4.C1221c;

/* JADX INFO: renamed from: w4.r1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1368r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1221c f11355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.Z f11356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.internal.G f11357c;

    public C1368r1(com.google.android.gms.common.api.internal.G g2, u4.Z z6, C1221c c1221c) {
        s3.D.j(g2, "method");
        this.f11357c = g2;
        s3.D.j(z6, "headers");
        this.f11356b = z6;
        s3.D.j(c1221c, "callOptions");
        this.f11355a = c1221c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1368r1.class == obj.getClass()) {
            C1368r1 c1368r1 = (C1368r1) obj;
            if (android.support.v4.media.session.a.k(this.f11355a, c1368r1.f11355a) && android.support.v4.media.session.a.k(this.f11356b, c1368r1.f11356b) && android.support.v4.media.session.a.k(this.f11357c, c1368r1.f11357c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11355a, this.f11356b, this.f11357c});
    }

    public final String toString() {
        return "[method=" + this.f11357c + " headers=" + this.f11356b + " callOptions=" + this.f11355a + "]";
    }
}
