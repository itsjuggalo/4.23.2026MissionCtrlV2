package le;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends u implements ve.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f15619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation[] f15620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15622d;

    public g0(e0 type, Annotation[] reflectAnnotations, String str, boolean z10) {
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(reflectAnnotations, "reflectAnnotations");
        this.f15619a = type;
        this.f15620b = reflectAnnotations;
        this.f15621c = str;
        this.f15622d = z10;
    }

    @Override // ve.b0
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public e0 getType() {
        return this.f15619a;
    }

    @Override // ve.b0
    public boolean a() {
        return this.f15622d;
    }

    @Override // ve.b0
    public ef.f getName() {
        String str = this.f15621c;
        if (str != null) {
            return ef.f.i(str);
        }
        return null;
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g0.class.getName());
        sb2.append(": ");
        sb2.append(a() ? "vararg " : "");
        sb2.append(getName());
        sb2.append(": ");
        sb2.append(getType());
        return sb2.toString();
    }

    @Override // ve.d
    public g b(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return k.a(this.f15620b, fqName);
    }

    @Override // ve.d
    public List getAnnotations() {
        return k.b(this.f15620b);
    }
}
