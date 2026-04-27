package s6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import s6.AbstractC2722i;

/* JADX INFO: renamed from: s6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2720g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2720g f23153b = new C2720g(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23154a;

    /* JADX INFO: renamed from: s6.g$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f23155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23156b;

        public a(Object obj, int i8) {
            this.f23155a = obj;
            this.f23156b = i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f23155a == aVar.f23155a && this.f23156b == aVar.f23156b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f23155a) * 65535) + this.f23156b;
        }
    }

    public C2720g() {
        this.f23154a = new HashMap();
    }

    public static C2720g c() {
        return f23153b;
    }

    public static C2720g d() {
        return new C2720g();
    }

    public final void a(AbstractC2722i.f fVar) {
        this.f23154a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public AbstractC2722i.f b(p pVar, int i8) {
        return (AbstractC2722i.f) this.f23154a.get(new a(pVar, i8));
    }

    public C2720g(boolean z7) {
        this.f23154a = Collections.emptyMap();
    }
}
