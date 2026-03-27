package r0;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class O implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f14347a;

    public O(View view) {
        this.f14347a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof O) && ((O) obj).f14347a.equals(this.f14347a);
    }

    public int hashCode() {
        return this.f14347a.hashCode();
    }
}
