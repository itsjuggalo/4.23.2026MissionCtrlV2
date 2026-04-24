package E1;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f1611b;

    public m(String str, Bundle bundle) {
        this.f1610a = str;
        this.f1611b = bundle;
    }

    @Override // E1.n
    public final /* bridge */ /* synthetic */ Object a(IBinder iBinder) throws d, IOException {
        Bundle bundleZzd = zze.zzb(iBinder).zzd(this.f1610a, this.f1611b);
        o.f(bundleZzd);
        String string = bundleZzd.getString("Error");
        if (bundleZzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new d(string);
    }
}
