package de;

import ce.o;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.c f8065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ef.b f8068d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8069e = new a();

        public a() {
            super(o.A, "Function", false, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f8070e = new b();

        public b() {
            super(o.f3970x, "KFunction", true, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f8071e = new c();

        public c() {
            super(o.f3970x, "KSuspendFunction", true, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f8072e = new d();

        public d() {
            super(o.f3965s, "SuspendFunction", false, null);
        }
    }

    public f(ef.c packageFqName, String classNamePrefix, boolean z10, ef.b bVar) {
        t.f(packageFqName, "packageFqName");
        t.f(classNamePrefix, "classNamePrefix");
        this.f8065a = packageFqName;
        this.f8066b = classNamePrefix;
        this.f8067c = z10;
        this.f8068d = bVar;
    }

    public final String a() {
        return this.f8066b;
    }

    public final ef.c b() {
        return this.f8065a;
    }

    public final ef.f c(int i10) {
        ef.f fVarK = ef.f.k(this.f8066b + i10);
        t.e(fVarK, "identifier(...)");
        return fVarK;
    }

    public String toString() {
        return this.f8065a + com.amazon.a.a.o.c.a.b.f4610a + this.f8066b + 'N';
    }
}
