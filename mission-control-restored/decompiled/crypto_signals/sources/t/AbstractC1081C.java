package t;

import android.app.Notification;
import android.net.Uri;

/* JADX INFO: renamed from: t.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1081C {
    public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j4, CharSequence charSequence2) {
        return new Notification.MessagingStyle.Message(charSequence, j4, charSequence2);
    }

    public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
        return message.setData(str, uri);
    }
}
