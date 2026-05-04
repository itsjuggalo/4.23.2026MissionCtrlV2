package ke;

import ce.o;
import java.io.InputStream;
import kotlin.jvm.internal.t;
import xe.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f14834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uf.d f14835b;

    public g(ClassLoader classLoader) {
        t.f(classLoader, "classLoader");
        this.f14834a = classLoader;
        this.f14835b = new uf.d();
    }

    @Override // xe.v
    public v.a a(ef.b classId, df.e jvmMetadataVersion) {
        t.f(classId, "classId");
        t.f(jvmMetadataVersion, "jvmMetadataVersion");
        return d(h.b(classId));
    }

    @Override // xe.v
    public v.a b(ve.g javaClass, df.e jvmMetadataVersion) {
        String strA;
        t.f(javaClass, "javaClass");
        t.f(jvmMetadataVersion, "jvmMetadataVersion");
        ef.c cVarE = javaClass.e();
        if (cVarE == null || (strA = cVarE.a()) == null) {
            return null;
        }
        return d(strA);
    }

    @Override // tf.a0
    public InputStream c(ef.c packageFqName) {
        t.f(packageFqName, "packageFqName");
        if (packageFqName.h(o.f3972z)) {
            return this.f14835b.a(uf.a.f22983r.r(packageFqName));
        }
        return null;
    }

    public final v.a d(String str) {
        f fVarA;
        Class clsA = e.a(this.f14834a, str);
        if (clsA == null || (fVarA = f.f14831c.a(clsA)) == null) {
            return null;
        }
        return new v.a.C0458a(fVarA, null, 2, null);
    }
}
