package tb;

import com.google.firebase.analytics.FirebaseAnalytics;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends r0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.c f21790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.y0 f21791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.z0 f21792c;

    public v1(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar) {
        this.f21792c = (rb.z0) p6.n.o(z0Var, FirebaseAnalytics.Param.METHOD);
        this.f21791b = (rb.y0) p6.n.o(y0Var, "headers");
        this.f21790a = (rb.c) p6.n.o(cVar, "callOptions");
    }

    @Override // rb.r0.g
    public rb.c a() {
        return this.f21790a;
    }

    @Override // rb.r0.g
    public rb.y0 b() {
        return this.f21791b;
    }

    @Override // rb.r0.g
    public rb.z0 c() {
        return this.f21792c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v1.class == obj.getClass()) {
            v1 v1Var = (v1) obj;
            if (p6.j.a(this.f21790a, v1Var.f21790a) && p6.j.a(this.f21791b, v1Var.f21791b) && p6.j.a(this.f21792c, v1Var.f21792c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p6.j.b(this.f21790a, this.f21791b, this.f21792c);
    }

    public final String toString() {
        return "[method=" + this.f21792c + " headers=" + this.f21791b + " callOptions=" + this.f21790a + "]";
    }
}
