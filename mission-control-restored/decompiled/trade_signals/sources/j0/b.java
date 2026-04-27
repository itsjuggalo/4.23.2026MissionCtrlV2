package j0;

import android.text.Editable;
import h0.i;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19920a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f19921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f19922c;

    public b() {
        try {
            f19922c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f19921b == null) {
            synchronized (f19920a) {
                try {
                    if (f19921b == null) {
                        f19921b = new b();
                    }
                } finally {
                }
            }
        }
        return f19921b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f19922c;
        return cls != null ? i.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
