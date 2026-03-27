package t;

import android.app.RemoteInput;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static int a(Object obj) {
        return ((RemoteInput) obj).getEditChoicesBeforeSending();
    }

    public static RemoteInput.Builder b(RemoteInput.Builder builder, int i) {
        return builder.setEditChoicesBeforeSending(i);
    }
}
