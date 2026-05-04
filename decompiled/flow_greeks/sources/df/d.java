package df;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8094b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name, String desc) {
            super(null);
            t.f(name, "name");
            t.f(desc, "desc");
            this.f8093a = name;
            this.f8094b = desc;
        }

        @Override // df.d
        public String a() {
            return e() + ':' + d();
        }

        public final String b() {
            return this.f8093a;
        }

        public final String c() {
            return this.f8094b;
        }

        public String d() {
            return this.f8094b;
        }

        public String e() {
            return this.f8093a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.b(this.f8093a, aVar.f8093a) && t.b(this.f8094b, aVar.f8094b);
        }

        public int hashCode() {
            return (this.f8093a.hashCode() * 31) + this.f8094b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8096b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name, String desc) {
            super(null);
            t.f(name, "name");
            t.f(desc, "desc");
            this.f8095a = name;
            this.f8096b = desc;
        }

        public static /* synthetic */ b c(b bVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bVar.f8095a;
            }
            if ((i10 & 2) != 0) {
                str2 = bVar.f8096b;
            }
            return bVar.b(str, str2);
        }

        @Override // df.d
        public String a() {
            return e() + d();
        }

        public final b b(String name, String desc) {
            t.f(name, "name");
            t.f(desc, "desc");
            return new b(name, desc);
        }

        public String d() {
            return this.f8096b;
        }

        public String e() {
            return this.f8095a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.b(this.f8095a, bVar.f8095a) && t.b(this.f8096b, bVar.f8096b);
        }

        public int hashCode() {
            return (this.f8095a.hashCode() * 31) + this.f8096b.hashCode();
        }
    }

    public /* synthetic */ d(k kVar) {
        this();
    }

    public abstract String a();

    public final String toString() {
        return a();
    }

    public d() {
    }
}
