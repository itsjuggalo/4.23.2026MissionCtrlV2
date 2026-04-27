package S1;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzcn;

/* JADX INFO: renamed from: S1.w6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0708w6 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f5019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0700v6 f5021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0684t6 f5022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0668r6 f5023g;

    public C0708w6(C0658q3 c0658q3) {
        super(c0658q3);
        this.f5020d = true;
        this.f5021e = new C0700v6(this);
        this.f5022f = new C0684t6(this);
        this.f5023g = new C0668r6(this);
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return false;
    }

    public final void o(boolean z4) {
        h();
        this.f5020d = z4;
    }

    public final boolean p() {
        h();
        return this.f5020d;
    }

    public final /* synthetic */ void r(long j4) {
        h();
        q();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().w().b("Activity resumed, time", Long.valueOf(j4));
        if (c0658q3.w().H(null, AbstractC0569f2.f4545V0)) {
            if (c0658q3.w().N() || this.f5020d) {
                this.f5022f.a(j4);
            }
        } else if (c0658q3.w().N() || c0658q3.x().f4198t.a()) {
            this.f5022f.a(j4);
        }
        this.f5023g.a();
        C0700v6 c0700v6 = this.f5021e;
        C0708w6 c0708w6 = c0700v6.f5007a;
        c0708w6.h();
        if (c0708w6.f4245a.g()) {
            c0700v6.b(c0708w6.f4245a.f().currentTimeMillis(), false);
        }
    }

    public final /* synthetic */ void s(long j4) {
        h();
        q();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().w().b("Activity paused, time", Long.valueOf(j4));
        this.f5023g.b(j4);
        if (c0658q3.w().N()) {
            this.f5022f.b(j4);
        }
    }

    public final /* synthetic */ Handler t() {
        return this.f5019c;
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final void q() {
        h();
        if (this.f5019c == null) {
            this.f5019c = new zzcn(Looper.getMainLooper());
        }
    }
}
