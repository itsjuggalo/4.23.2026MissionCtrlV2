package t;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public abstract class O {
    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z6) {
        return builder.setAuthenticationRequired(z6);
    }

    public static Notification.Builder b(Notification.Builder builder, int i) {
        return builder.setForegroundServiceBehavior(i);
    }
}
