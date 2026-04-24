package q6;

import V6.n;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22673a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f22674b = new n("[^\\p{L}\\p{Digit}]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f22675c = "$context_receiver";

    public static final f a(int i8) {
        f fVarL = f.l(f22675c + '_' + i8);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return fVarL;
    }

    public static final String b(String name) {
        AbstractC2304t.f(name, "name");
        return f22674b.c(name, "_");
    }
}
