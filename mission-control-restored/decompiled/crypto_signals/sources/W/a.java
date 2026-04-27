package W;

import U.s;
import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3306a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f3307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f3308c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f3308c;
        return cls != null ? new s(cls, charSequence) : super.newEditable(charSequence);
    }
}
