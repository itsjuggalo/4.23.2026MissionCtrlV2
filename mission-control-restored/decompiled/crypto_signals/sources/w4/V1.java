package w4;

import N1.C0094g0;
import a.AbstractC0284a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class V1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.N f11136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11137b;

    public V1(u4.N n6, Object obj) {
        this.f11136a = n6;
        this.f11137b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && V1.class == obj.getClass()) {
            V1 v12 = (V1) obj;
            if (android.support.v4.media.session.a.k(this.f11136a, v12.f11136a) && android.support.v4.media.session.a.k(this.f11137b, v12.f11137b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11136a, this.f11137b});
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(this.f11136a, "provider");
        c0094g0J.a(this.f11137b, "config");
        return c0094g0J.toString();
    }
}
