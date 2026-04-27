package W1;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
