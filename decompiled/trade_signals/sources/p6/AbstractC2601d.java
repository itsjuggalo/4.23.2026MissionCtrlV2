package p6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2601d {

    /* JADX INFO: renamed from: p6.d$a */
    public static final class a extends AbstractC2601d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22405b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name, String desc) {
            super(null);
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            this.f22404a = name;
            this.f22405b = desc;
        }

        @Override // p6.AbstractC2601d
        public String a() {
            return e() + ':' + d();
        }

        public final String b() {
            return this.f22404a;
        }

        public final String c() {
            return this.f22405b;
        }

        public String d() {
            return this.f22405b;
        }

        public String e() {
            return this.f22404a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC2304t.b(this.f22404a, aVar.f22404a) && AbstractC2304t.b(this.f22405b, aVar.f22405b);
        }

        public int hashCode() {
            return (this.f22404a.hashCode() * 31) + this.f22405b.hashCode();
        }
    }

    /* JADX INFO: renamed from: p6.d$b */
    public static final class b extends AbstractC2601d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22407b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name, String desc) {
            super(null);
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            this.f22406a = name;
            this.f22407b = desc;
        }

        public static /* synthetic */ b c(b bVar, String str, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = bVar.f22406a;
            }
            if ((i8 & 2) != 0) {
                str2 = bVar.f22407b;
            }
            return bVar.b(str, str2);
        }

        @Override // p6.AbstractC2601d
        public String a() {
            return e() + d();
        }

        public final b b(String name, String desc) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            return new b(name, desc);
        }

        public String d() {
            return this.f22407b;
        }

        public String e() {
            return this.f22406a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2304t.b(this.f22406a, bVar.f22406a) && AbstractC2304t.b(this.f22407b, bVar.f22407b);
        }

        public int hashCode() {
            return (this.f22406a.hashCode() * 31) + this.f22407b.hashCode();
        }
    }

    public AbstractC2601d() {
    }

    public abstract String a();

    public final String toString() {
        return a();
    }

    public /* synthetic */ AbstractC2601d(AbstractC2296k abstractC2296k) {
        this();
    }
}
