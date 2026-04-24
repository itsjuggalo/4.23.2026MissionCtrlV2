package t;

import android.app.Notification;
import android.app.Person;

/* JADX INFO: renamed from: t.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1080B {
    public static Notification.MessagingStyle a(Person person) {
        return new Notification.MessagingStyle(person);
    }

    public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z6) {
        return messagingStyle.setGroupConversation(z6);
    }
}
