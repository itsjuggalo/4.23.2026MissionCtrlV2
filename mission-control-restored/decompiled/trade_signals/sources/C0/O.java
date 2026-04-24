package C0;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class O implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f453a;

    public O(View view) {
        this.f453a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof O) && ((O) obj).f453a.equals(this.f453a);
    }

    public int hashCode() {
        return this.f453a.hashCode();
    }
}
