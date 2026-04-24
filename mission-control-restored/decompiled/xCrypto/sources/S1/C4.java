package S1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C4 implements k7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3893a;

    public C4(C0540b5 c0540b5) {
        Objects.requireNonNull(c0540b5);
        this.f3893a = c0540b5;
    }

    @Override // S1.k7
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f3893a.p("auto", "_err", bundle);
        } else {
            this.f3893a.w("auto", "_err", bundle, str);
        }
    }
}
