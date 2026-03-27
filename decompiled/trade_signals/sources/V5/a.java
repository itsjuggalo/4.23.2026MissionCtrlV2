package V5;

import R5.w0;
import R5.x0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8949c = new a();

    public a() {
        super("package", false);
    }

    @Override // R5.x0
    public Integer a(x0 visibility) {
        AbstractC2304t.f(visibility, "visibility");
        return Integer.valueOf(this == visibility ? 0 : w0.f7275a.b(visibility) ? 1 : -1);
    }

    @Override // R5.x0
    public String b() {
        return "public/*package*/";
    }

    @Override // R5.x0
    public x0 d() {
        return w0.g.f7284c;
    }
}
