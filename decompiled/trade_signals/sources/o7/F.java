package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends C2514k0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f22106m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(String name, E generatedSerializer) {
        super(name, generatedSerializer, 1);
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(generatedSerializer, "generatedSerializer");
        this.f22106m = true;
    }

    @Override // o7.C2514k0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof F) {
            m7.e eVar = (m7.e) obj;
            if (AbstractC2304t.b(a(), eVar.a())) {
                F f8 = (F) obj;
                if (f8.isInline() && Arrays.equals(u(), f8.u()) && e() == eVar.e()) {
                    int iE = e();
                    for (int i8 = 0; i8 < iE; i8++) {
                        if (AbstractC2304t.b(h(i8).a(), eVar.h(i8).a()) && AbstractC2304t.b(h(i8).i(), eVar.h(i8).i())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // o7.C2514k0
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // o7.C2514k0, m7.e
    public boolean isInline() {
        return this.f22106m;
    }
}
