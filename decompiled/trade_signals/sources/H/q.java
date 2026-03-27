package H;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static int a(boolean z7, int i8) {
        int i9;
        if (!z7) {
            i9 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i8;
            }
            i9 = 33554432;
        }
        return i8 | i9;
    }

    public static PendingIntent b(Context context, int i8, Intent intent, int i9, boolean z7) {
        return PendingIntent.getActivity(context, i8, intent, a(z7, i9));
    }
}
