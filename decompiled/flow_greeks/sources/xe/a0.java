package xe;

import cf.a;
import df.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24814b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24815a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final a0 a(String name, String desc) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(desc, "desc");
            return new a0(name + '#' + desc, null);
        }

        public final a0 b(df.d signature) {
            kotlin.jvm.internal.t.f(signature, "signature");
            if (signature instanceof d.b) {
                d.b bVar = (d.b) signature;
                return d(bVar.e(), bVar.d());
            }
            if (!(signature instanceof d.a)) {
                throw new cd.o();
            }
            d.a aVar = (d.a) signature;
            return a(aVar.e(), aVar.d());
        }

        public final a0 c(bf.c nameResolver, a.c signature) {
            kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.t.f(signature, "signature");
            return d(nameResolver.getString(signature.x()), nameResolver.getString(signature.w()));
        }

        public final a0 d(String name, String desc) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(desc, "desc");
            return new a0(name + desc, null);
        }

        public final a0 e(a0 signature, int i10) {
            kotlin.jvm.internal.t.f(signature, "signature");
            return new a0(signature.a() + '@' + i10, null);
        }

        public a() {
        }
    }

    public /* synthetic */ a0(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    public final String a() {
        return this.f24815a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && kotlin.jvm.internal.t.b(this.f24815a, ((a0) obj).f24815a);
    }

    public int hashCode() {
        return this.f24815a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f24815a + ')';
    }

    public a0(String str) {
        this.f24815a = str;
    }
}
