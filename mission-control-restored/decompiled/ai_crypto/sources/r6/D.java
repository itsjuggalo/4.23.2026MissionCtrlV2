package r6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends C2613b0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f22824m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(String name, C generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(generatedSerializer, "generatedSerializer");
        this.f22824m = true;
    }

    @Override // r6.C2613b0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof D) {
            p6.e eVar = (p6.e) obj;
            if (kotlin.jvm.internal.r.b(a(), eVar.a())) {
                D d7 = (D) obj;
                if (d7.isInline() && Arrays.equals(p(), d7.p()) && f() == eVar.f()) {
                    int iF = f();
                    for (int i7 = 0; i7 < iF; i7++) {
                        if (kotlin.jvm.internal.r.b(i(i7).a(), eVar.i(i7).a()) && kotlin.jvm.internal.r.b(i(i7).e(), eVar.i(i7).e())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // r6.C2613b0
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // r6.C2613b0, p6.e
    public boolean isInline() {
        return this.f22824m;
    }
}
