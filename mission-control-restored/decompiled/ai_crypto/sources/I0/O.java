package I0;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class O implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f2731a;

    public O(View view) {
        this.f2731a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof O) && ((O) obj).f2731a.equals(this.f2731a);
    }

    public int hashCode() {
        return this.f2731a.hashCode();
    }
}
