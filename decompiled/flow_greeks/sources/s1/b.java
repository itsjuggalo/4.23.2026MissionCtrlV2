package s1;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19934a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f19935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f19936c;

    public b() {
        try {
            f19936c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f19935b == null) {
            synchronized (f19934a) {
                try {
                    if (f19935b == null) {
                        f19935b = new b();
                    }
                } finally {
                }
            }
        }
        return f19935b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f19936c;
        return cls != null ? q1.h.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
