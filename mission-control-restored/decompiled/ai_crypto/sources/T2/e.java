package T2;

import android.os.Bundle;
import h2.C1669a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class e implements C1669a.InterfaceC0244a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f4736a;

    public e(f fVar) {
        Objects.requireNonNull(fVar);
        this.f4736a = fVar;
    }

    @Override // i2.InterfaceC1811f4
    public final void a(String str, String str2, Bundle bundle, long j7) {
        if (str == null || !b.c(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j7);
        bundle2.putBundle("params", bundle);
        this.f4736a.a().a(3, bundle2);
    }
}
