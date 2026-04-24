package t;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* JADX INFO: renamed from: t.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1082D {
    public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j4, Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j4, person);
    }

    public static Parcelable a(Person person) {
        return person;
    }
}
