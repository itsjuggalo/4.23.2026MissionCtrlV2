package i2;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzcn;

/* JADX INFO: renamed from: i2.w6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1949w6 extends AbstractC1833i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f16178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1941v6 f16180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1925t6 f16181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1909r6 f16182g;

    public C1949w6(C1898q3 c1898q3) {
        super(c1898q3);
        this.f16179d = true;
        this.f16180e = new C1941v6(this);
        this.f16181f = new C1925t6(this);
        this.f16182g = new C1909r6(this);
    }

    @Override // i2.AbstractC1833i2
    public final boolean m() {
        return false;
    }

    public final void o(boolean z7) {
        h();
        this.f16179d = z7;
    }

    public final boolean p() {
        h();
        return this.f16179d;
    }

    public final /* synthetic */ void r(long j7) {
        h();
        q();
        C1898q3 c1898q3 = this.f15404a;
        c1898q3.a().w().b("Activity resumed, time", Long.valueOf(j7));
        if (c1898q3.w().H(null, AbstractC1809f2.f15704V0)) {
            if (c1898q3.w().N() || this.f16179d) {
                this.f16181f.a(j7);
            }
        } else if (c1898q3.w().N() || c1898q3.x().f15357t.a()) {
            this.f16181f.a(j7);
        }
        this.f16182g.a();
        C1941v6 c1941v6 = this.f16180e;
        C1949w6 c1949w6 = c1941v6.f16166a;
        c1949w6.h();
        if (c1949w6.f15404a.g()) {
            c1941v6.b(c1949w6.f15404a.f().a(), false);
        }
    }

    public final /* synthetic */ void s(long j7) {
        h();
        q();
        C1898q3 c1898q3 = this.f15404a;
        c1898q3.a().w().b("Activity paused, time", Long.valueOf(j7));
        this.f16182g.b(j7);
        if (c1898q3.w().N()) {
            this.f16181f.b(j7);
        }
    }

    public final /* synthetic */ Handler t() {
        return this.f16178c;
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final void q() {
        h();
        if (this.f16178c == null) {
            this.f16178c = new zzcn(Looper.getMainLooper());
        }
    }
}
