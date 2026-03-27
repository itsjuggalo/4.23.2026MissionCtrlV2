package J3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class D extends C0327b0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f867m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(String name, C generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(generatedSerializer, "generatedSerializer");
        this.f867m = true;
    }

    @Override // J3.C0327b0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        H3.e eVar = (H3.e) obj;
        if (!kotlin.jvm.internal.r.b(a(), eVar.a())) {
            return false;
        }
        D d4 = (D) obj;
        if (!d4.isInline() || !Arrays.equals(p(), d4.p()) || f() != eVar.f()) {
            return false;
        }
        int iF = f();
        for (int i4 = 0; i4 < iF; i4++) {
            if (!kotlin.jvm.internal.r.b(i(i4).a(), eVar.i(i4).a()) || !kotlin.jvm.internal.r.b(i(i4).e(), eVar.i(i4).e())) {
                return false;
            }
        }
        return true;
    }

    @Override // J3.C0327b0
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // J3.C0327b0, H3.e
    public boolean isInline() {
        return this.f867m;
    }
}
