package j0;

import android.text.Editable;
import h0.i;

/* JADX INFO: renamed from: j0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2042b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f17342a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f17343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f17344c;

    public C2042b() {
        try {
            f17344c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C2042b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f17343b == null) {
            synchronized (f17342a) {
                try {
                    if (f17343b == null) {
                        f17343b = new C2042b();
                    }
                } finally {
                }
            }
        }
        return f17343b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f17344c;
        return cls != null ? i.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
