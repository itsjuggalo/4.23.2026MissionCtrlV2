package n6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static final boolean a(AbstractC2427a version) {
        AbstractC2304t.f(version, "version");
        return (version.a() == 1 && version.b() >= 4) || version.a() > 1;
    }

    public static final boolean b(AbstractC2427a version) {
        AbstractC2304t.f(version, "version");
        return a(version);
    }
}
