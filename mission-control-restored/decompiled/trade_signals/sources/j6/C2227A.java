package j6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n6.InterfaceC2429c;
import o5.C2487o;
import o6.AbstractC2492a;
import p6.AbstractC2601d;

/* JADX INFO: renamed from: j6.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2227A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20120b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20121a;

    /* JADX INFO: renamed from: j6.A$a */
    public static final class a {
        public a() {
        }

        public final C2227A a(String name, String desc) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            return new C2227A(name + '#' + desc, null);
        }

        public final C2227A b(AbstractC2601d signature) {
            AbstractC2304t.f(signature, "signature");
            if (signature instanceof AbstractC2601d.b) {
                AbstractC2601d.b bVar = (AbstractC2601d.b) signature;
                return d(bVar.e(), bVar.d());
            }
            if (!(signature instanceof AbstractC2601d.a)) {
                throw new C2487o();
            }
            AbstractC2601d.a aVar = (AbstractC2601d.a) signature;
            return a(aVar.e(), aVar.d());
        }

        public final C2227A c(InterfaceC2429c nameResolver, AbstractC2492a.c signature) {
            AbstractC2304t.f(nameResolver, "nameResolver");
            AbstractC2304t.f(signature, "signature");
            return d(nameResolver.b(signature.y()), nameResolver.b(signature.x()));
        }

        public final C2227A d(String name, String desc) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(desc, "desc");
            return new C2227A(name + desc, null);
        }

        public final C2227A e(C2227A signature, int i8) {
            AbstractC2304t.f(signature, "signature");
            return new C2227A(signature.a() + '@' + i8, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2227A(String str) {
        this.f20121a = str;
    }

    public final String a() {
        return this.f20121a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2227A) && AbstractC2304t.b(this.f20121a, ((C2227A) obj).f20121a);
    }

    public int hashCode() {
        return this.f20121a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f20121a + ')';
    }

    public /* synthetic */ C2227A(String str, AbstractC2296k abstractC2296k) {
        this(str);
    }
}
