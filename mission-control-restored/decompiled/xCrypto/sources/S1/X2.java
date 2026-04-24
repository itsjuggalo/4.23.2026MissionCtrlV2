package S1;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class X2 implements zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0554d3 f4280a;

    public X2(C0554d3 c0554d3) {
        Objects.requireNonNull(c0554d3);
        this.f4280a = c0554d3;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i4, String str, List list, boolean z4, boolean z5) {
        int i5 = i4 - 1;
        A2 a2U = i5 != 0 ? i5 != 1 ? i5 != 3 ? i5 != 4 ? this.f4280a.f4245a.a().u() : z4 ? this.f4280a.f4245a.a().s() : !z5 ? this.f4280a.f4245a.a().t() : this.f4280a.f4245a.a().r() : this.f4280a.f4245a.a().w() : z4 ? this.f4280a.f4245a.a().p() : !z5 ? this.f4280a.f4245a.a().q() : this.f4280a.f4245a.a().o() : this.f4280a.f4245a.a().v();
        int size = list.size();
        if (size == 1) {
            a2U.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            a2U.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            a2U.a(str);
        } else {
            a2U.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
