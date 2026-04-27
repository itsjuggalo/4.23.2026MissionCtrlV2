package P5;

import O5.o;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.c f6467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.b f6470d;

    public static final class a extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f6471e = new a();

        public a() {
            super(o.f6087A, "Function", false, null);
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f6472e = new b();

        public b() {
            super(o.f6118x, "KFunction", true, null);
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f6473e = new c();

        public c() {
            super(o.f6118x, "KSuspendFunction", true, null);
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f6474e = new d();

        public d() {
            super(o.f6113s, "SuspendFunction", false, null);
        }
    }

    public f(q6.c packageFqName, String classNamePrefix, boolean z7, q6.b bVar) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(classNamePrefix, "classNamePrefix");
        this.f6467a = packageFqName;
        this.f6468b = classNamePrefix;
        this.f6469c = z7;
        this.f6470d = bVar;
    }

    public final String a() {
        return this.f6468b;
    }

    public final q6.c b() {
        return this.f6467a;
    }

    public final q6.f c(int i8) {
        q6.f fVarL = q6.f.l(this.f6468b + i8);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return fVarL;
    }

    public String toString() {
        return this.f6467a + com.amazon.a.a.o.c.a.b.f14112a + this.f6468b + 'N';
    }
}
