package t;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* JADX INFO: renamed from: t.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1108v {
    public static Notification.Builder a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Parcelable b(Person person) {
        return person;
    }
}
