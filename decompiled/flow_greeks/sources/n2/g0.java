package n2;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f16544a;

    public g0(View view) {
        this.f16544a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g0) && ((g0) obj).f16544a.equals(this.f16544a);
    }

    public int hashCode() {
        return this.f16544a.hashCode();
    }
}
