package T2;

import I2.m;
import android.os.Bundle;
import h2.C1669a;
import i2.AbstractC1779b4;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c implements C1669a.InterfaceC0244a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4731a;

    public c(d dVar) {
        Objects.requireNonNull(dVar);
        this.f4731a = dVar;
    }

    @Override // i2.InterfaceC1811f4
    public final void a(String str, String str2, Bundle bundle, long j7) {
        d dVar = this.f4731a;
        if (dVar.f4732a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            m mVar = b.f4725a;
            String strA = AbstractC1779b4.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            bundle2.putString("events", str2);
            dVar.a().a(2, bundle2);
        }
    }
}
