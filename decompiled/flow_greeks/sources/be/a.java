package be;

import dd.r;
import ef.b;
import ef.c;
import fe.g1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k0;
import kotlin.jvm.internal.t;
import oe.h0;
import oe.i0;
import xe.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3305a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f3306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f3307c;

    static {
        List listN = r.n(i0.f17981a, i0.f17992l, i0.f17993m, i0.f17984d, i0.f17986f, i0.f17989i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = b.f8779d;
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(aVar.c((c) it.next()));
        }
        f3306b = linkedHashSet;
        b.a aVar2 = b.f8779d;
        c REPEATABLE_ANNOTATION = i0.f17990j;
        t.e(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        f3307c = aVar2.c(REPEATABLE_ANNOTATION);
    }

    public final b a() {
        return f3307c;
    }

    public final Set b() {
        return f3306b;
    }

    public final boolean c(x klass) {
        t.f(klass, "klass");
        k0 k0Var = new k0();
        klass.d(new C0059a(k0Var), null);
        return k0Var.f14943a;
    }

    /* JADX INFO: renamed from: be.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0059a implements x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f3308a;

        public C0059a(k0 k0Var) {
            this.f3308a = k0Var;
        }

        @Override // xe.x.c
        public x.a b(b classId, g1 source) {
            t.f(classId, "classId");
            t.f(source, "source");
            if (!t.b(classId, h0.f17975a.a())) {
                return null;
            }
            this.f3308a.f14943a = true;
            return null;
        }

        @Override // xe.x.c
        public void a() {
        }
    }
}
