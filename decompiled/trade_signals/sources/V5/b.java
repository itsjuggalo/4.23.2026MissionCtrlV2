package V5;

import R5.w0;
import R5.x0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8950c = new b();

    public b() {
        super("protected_and_package", true);
    }

    @Override // R5.x0
    public Integer a(x0 visibility) {
        AbstractC2304t.f(visibility, "visibility");
        if (AbstractC2304t.b(this, visibility)) {
            return 0;
        }
        if (visibility == w0.b.f7279c) {
            return null;
        }
        return Integer.valueOf(w0.f7275a.b(visibility) ? 1 : -1);
    }

    @Override // R5.x0
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // R5.x0
    public x0 d() {
        return w0.g.f7284c;
    }
}
