package u4;

import N1.C0094g0;
import a.AbstractC0284a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class I {
    public static final I e = new I(null, null, j0.e, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1240w f10348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D4.r f10349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f10350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10351d;

    public I(AbstractC1240w abstractC1240w, D4.r rVar, j0 j0Var, boolean z6) {
        this.f10348a = abstractC1240w;
        this.f10349b = rVar;
        s3.D.j(j0Var, "status");
        this.f10350c = j0Var;
        this.f10351d = z6;
    }

    public static I a(j0 j0Var) {
        s3.D.f("error status shouldn't be OK", !j0Var.e());
        return new I(null, null, j0Var, false);
    }

    public static I b(AbstractC1240w abstractC1240w, D4.r rVar) {
        s3.D.j(abstractC1240w, "subchannel");
        return new I(abstractC1240w, rVar, j0.e, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof I)) {
            return false;
        }
        I i = (I) obj;
        return android.support.v4.media.session.a.k(this.f10348a, i.f10348a) && android.support.v4.media.session.a.k(this.f10350c, i.f10350c) && android.support.v4.media.session.a.k(this.f10349b, i.f10349b) && this.f10351d == i.f10351d;
    }

    public final int hashCode() {
        Boolean boolValueOf = Boolean.valueOf(this.f10351d);
        return Arrays.hashCode(new Object[]{this.f10348a, this.f10350c, this.f10349b, boolValueOf});
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(this.f10348a, "subchannel");
        c0094g0J.a(this.f10349b, "streamTracerFactory");
        c0094g0J.a(this.f10350c, "status");
        c0094g0J.c("drop", this.f10351d);
        return c0094g0J.toString();
    }
}
