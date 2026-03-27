package Q1;

import S1.C0540b5;
import S1.C0658q3;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0658q3 f3540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0540b5 f3541b;

    public a(C0658q3 c0658q3) {
        super(null);
        AbstractC0940s.k(c0658q3);
        this.f3540a = c0658q3;
        this.f3541b = c0658q3.B();
    }

    @Override // S1.InterfaceC0548c5
    public final void zza(String str, String str2, Bundle bundle) {
        this.f3541b.p(str, str2, bundle);
    }

    @Override // S1.InterfaceC0548c5
    public final Map zzd(String str, String str2, boolean z4) {
        return this.f3541b.C(str, str2, z4);
    }

    @Override // S1.InterfaceC0548c5
    public final String zzh() {
        return this.f3541b.Q();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzi() {
        return this.f3541b.R();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzj() {
        return this.f3541b.D();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzk() {
        return this.f3541b.D();
    }

    @Override // S1.InterfaceC0548c5
    public final long zzl() {
        return this.f3540a.C().p0();
    }

    @Override // S1.InterfaceC0548c5
    public final void zzm(String str) {
        C0658q3 c0658q3 = this.f3540a;
        c0658q3.M().i(str, c0658q3.f().a());
    }

    @Override // S1.InterfaceC0548c5
    public final void zzn(String str) {
        C0658q3 c0658q3 = this.f3540a;
        c0658q3.M().j(str, c0658q3.f().a());
    }

    @Override // S1.InterfaceC0548c5
    public final void zzo(Bundle bundle) {
        this.f3541b.M(bundle);
    }

    @Override // S1.InterfaceC0548c5
    public final void zzp(String str, String str2, Bundle bundle) {
        this.f3540a.B().O(str, str2, bundle);
    }

    @Override // S1.InterfaceC0548c5
    public final List zzq(String str, String str2) {
        return this.f3541b.P(str, str2);
    }

    @Override // S1.InterfaceC0548c5
    public final int zzr(String str) {
        this.f3541b.L(str);
        return 25;
    }
}
