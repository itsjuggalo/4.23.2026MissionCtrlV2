package Q3;

import android.app.ActivityManager;
import android.app.Person;
import android.os.Parcelable;
import android.text.PrecomputedText;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ ActivityManager.TaskDescription b(int i, String str) {
        return new ActivityManager.TaskDescription(str, 0, i);
    }

    public static /* bridge */ /* synthetic */ Person c(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ boolean q(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
