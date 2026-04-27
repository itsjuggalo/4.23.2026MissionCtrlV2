package R5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G f7195a = new G("InvalidModuleNotifier");

    public static final void a(H h8) {
        AbstractC2304t.f(h8, "<this>");
        android.support.v4.media.session.b.a(h8.f0(f7195a));
        throw new B("Accessing invalid module descriptor " + h8);
    }
}
