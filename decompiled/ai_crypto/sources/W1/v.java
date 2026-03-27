package W1;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static StrictMode.VmPolicy.Builder a(StrictMode.VmPolicy.Builder builder) {
        return builder.permitUnsafeIntentLaunch();
    }
}
