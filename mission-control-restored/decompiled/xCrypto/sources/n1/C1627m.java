package n1;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* JADX INFO: renamed from: n1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1627m implements InterfaceC1628n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f13624b;

    public C1627m(String str, Bundle bundle) {
        this.f13623a = str;
        this.f13624b = bundle;
    }

    @Override // n1.InterfaceC1628n
    public final /* bridge */ /* synthetic */ Object a(IBinder iBinder) throws IOException, C1618d {
        Bundle bundleZzd = zze.zzb(iBinder).zzd(this.f13623a, this.f13624b);
        AbstractC1629o.f(bundleZzd);
        String string = bundleZzd.getString("Error");
        if (bundleZzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new C1618d(string);
    }
}
