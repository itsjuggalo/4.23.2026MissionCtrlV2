package B1;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static StrictMode.VmPolicy.Builder a(StrictMode.VmPolicy.Builder builder) {
        return builder.permitUnsafeIntentLaunch();
    }
}
