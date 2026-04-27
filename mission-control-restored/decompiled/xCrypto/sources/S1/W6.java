package S1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class W6 implements k7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7 f4276a;

    public W6(b7 b7Var) {
        Objects.requireNonNull(b7Var);
        this.f4276a = b7Var;
    }

    @Override // S1.k7
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f4276a.b().t(new U6(this, str, str2, bundle));
            return;
        }
        b7 b7Var = this.f4276a;
        if (b7Var.w0() != null) {
            b7Var.w0().a().o().b("AppId not known when logging event", str2);
        }
    }
}
