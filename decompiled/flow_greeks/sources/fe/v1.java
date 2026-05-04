package fe;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f9525a = new v1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f9526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f9527c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9528c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f9529c = new b();

        public b() {
            super("internal", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f9530c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f9531c = new d();

        public d() {
            super("local", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f9532c = new e();

        public e() {
            super("private", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f9533c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // fe.w1
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f9534c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f9535c = new h();

        public h() {
            super("public", true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends w1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f9536c = new i();

        public i() {
            super(FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, false);
        }
    }

    static {
        Map mapC = dd.n0.c();
        mapC.put(f.f9533c, 0);
        mapC.put(e.f9532c, 0);
        mapC.put(b.f9529c, 1);
        mapC.put(g.f9534c, 1);
        h hVar = h.f9535c;
        mapC.put(hVar, 2);
        f9526b = dd.n0.b(mapC);
        f9527c = hVar;
    }

    public final Integer a(w1 first, w1 second) {
        kotlin.jvm.internal.t.f(first, "first");
        kotlin.jvm.internal.t.f(second, "second");
        if (first == second) {
            return 0;
        }
        Map map = f9526b;
        Integer num = (Integer) map.get(first);
        Integer num2 = (Integer) map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.t.b(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(w1 visibility) {
        kotlin.jvm.internal.t.f(visibility, "visibility");
        return visibility == e.f9532c || visibility == f.f9533c;
    }
}
