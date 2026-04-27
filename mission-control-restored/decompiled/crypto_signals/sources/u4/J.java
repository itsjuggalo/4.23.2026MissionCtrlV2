package u4;

import N1.C0094g0;
import a.AbstractC0284a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1220b f10353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10354c;

    public J(List list, C1220b c1220b, Object obj) {
        s3.D.j(list, "addresses");
        this.f10352a = Collections.unmodifiableList(new ArrayList(list));
        s3.D.j(c1220b, "attributes");
        this.f10353b = c1220b;
        this.f10354c = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof J)) {
            return false;
        }
        J j4 = (J) obj;
        return android.support.v4.media.session.a.k(this.f10352a, j4.f10352a) && android.support.v4.media.session.a.k(this.f10353b, j4.f10353b) && android.support.v4.media.session.a.k(this.f10354c, j4.f10354c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10352a, this.f10353b, this.f10354c});
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(this.f10352a, "addresses");
        c0094g0J.a(this.f10353b, "attributes");
        c0094g0J.a(this.f10354c, "loadBalancingPolicyConfig");
        return c0094g0J.toString();
    }
}
