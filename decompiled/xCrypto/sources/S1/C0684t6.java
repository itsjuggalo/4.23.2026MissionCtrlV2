package S1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: renamed from: S1.t6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0684t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final A f4955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0708w6 f4956d;

    public C0684t6(C0708w6 c0708w6) {
        Objects.requireNonNull(c0708w6);
        this.f4956d = c0708w6;
        this.f4955c = new C0676s6(this, c0708w6.f4245a);
        long jA = c0708w6.f4245a.f().a();
        this.f4953a = jA;
        this.f4954b = jA;
    }

    public final void a(long j4) {
        this.f4956d.h();
        this.f4955c.d();
        this.f4953a = j4;
        this.f4954b = j4;
    }

    public final void b(long j4) {
        this.f4955c.d();
    }

    public final void c() {
        this.f4955c.d();
        long jA = this.f4956d.f4245a.f().a();
        this.f4953a = jA;
        this.f4954b = jA;
    }

    public final boolean d(boolean z4, boolean z5, long j4) {
        C0708w6 c0708w6 = this.f4956d;
        c0708w6.h();
        c0708w6.j();
        if (c0708w6.f4245a.g()) {
            C0658q3 c0658q3 = c0708w6.f4245a;
            c0658q3.x().f4195q.b(c0658q3.f().currentTimeMillis());
        }
        long j5 = j4 - this.f4953a;
        if (!z4 && j5 < 1000) {
            c0708w6.f4245a.a().w().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j5));
            return false;
        }
        if (!z5) {
            j5 = j4 - this.f4954b;
            this.f4954b = j4;
        }
        C0658q3 c0658q32 = c0708w6.f4245a;
        c0658q32.a().w().b("Recording user engagement, ms", Long.valueOf(j5));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j5);
        boolean z6 = !c0658q32.w().N();
        C0658q3 c0658q33 = c0708w6.f4245a;
        l7.k0(c0658q33.I().q(z6), bundle, true);
        if (!z5) {
            c0658q33.B().t("auto", "_e", bundle);
        }
        this.f4953a = j4;
        A a4 = this.f4955c;
        a4.d();
        a4.b(((Long) AbstractC0569f2.f4600r0.b(null)).longValue());
        return true;
    }
}
