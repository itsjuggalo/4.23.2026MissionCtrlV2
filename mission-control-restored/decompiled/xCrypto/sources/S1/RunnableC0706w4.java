package S1;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.w4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0706w4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f5017b;

    public RunnableC0706w4(C0540b5 c0540b5, long j4) {
        this.f5016a = j4;
        Objects.requireNonNull(c0540b5);
        this.f5017b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f5017b;
        c0540b5.h();
        c0540b5.j();
        C0658q3 c0658q3 = c0540b5.f4245a;
        c0658q3.a().v().a("Resetting analytics data (FE)");
        C0658q3 c0658q32 = c0540b5.f4245a;
        C0708w6 c0708w6Z = c0658q32.z();
        c0708w6Z.h();
        c0708w6Z.f5022f.c();
        c0658q32.L().p();
        boolean z4 = !c0540b5.f4245a.g();
        Q2 q2X = c0658q3.x();
        q2X.f4184f.b(this.f5016a);
        C0658q3 c0658q33 = q2X.f4245a;
        if (!TextUtils.isEmpty(c0658q33.x().f4201w.a())) {
            q2X.f4201w.b(null);
        }
        q2X.f4195q.b(0L);
        q2X.f4196r.b(0L);
        if (!c0658q33.w().L()) {
            q2X.y(z4);
        }
        q2X.f4202x.b(null);
        q2X.f4203y.b(0L);
        q2X.f4204z.b(null);
        c0658q32.J().p();
        c0658q32.z().f5021e.a();
        c0540b5.f4370s = z4;
        c0658q32.J().q(new AtomicReference());
    }
}
