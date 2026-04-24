package F;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static int a(boolean z7, int i7) {
        int i8;
        if (!z7) {
            i8 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i7;
            }
            i8 = 33554432;
        }
        return i7 | i8;
    }

    public static PendingIntent b(Context context, int i7, Intent intent, int i8, boolean z7) {
        return PendingIntent.getActivity(context, i7, intent, a(z7, i8));
    }
}
