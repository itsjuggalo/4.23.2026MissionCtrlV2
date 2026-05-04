package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public p b(Context context, String str, Bundle bundle) {
        return p.instantiate(context, str, bundle);
    }

    public abstract View c(int i10);

    public abstract boolean d();
}
