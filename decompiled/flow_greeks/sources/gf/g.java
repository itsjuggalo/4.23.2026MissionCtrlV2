package gf;

import gf.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f10655b = new g(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10656a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f10657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10658b;

        public a(Object obj, int i10) {
            this.f10657a = obj;
            this.f10658b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10657a == aVar.f10657a && this.f10658b == aVar.f10658b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f10657a) * 65535) + this.f10658b;
        }
    }

    public g() {
        this.f10656a = new HashMap();
    }

    public static g c() {
        return f10655b;
    }

    public static g d() {
        return new g();
    }

    public final void a(i.f fVar) {
        this.f10656a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public i.f b(p pVar, int i10) {
        return (i.f) this.f10656a.get(new a(pVar, i10));
    }

    public g(boolean z10) {
        this.f10656a = Collections.EMPTY_MAP;
    }
}
