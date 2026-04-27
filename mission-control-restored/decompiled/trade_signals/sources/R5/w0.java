package R5;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f7275a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f7276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f7277c;

    public static final class a extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7278c = new a();

        public a() {
            super("inherited", false);
        }
    }

    public static final class b extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f7279c = new b();

        public b() {
            super("internal", false);
        }
    }

    public static final class c extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f7280c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    public static final class d extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f7281c = new d();

        public d() {
            super("local", false);
        }
    }

    public static final class e extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f7282c = new e();

        public e() {
            super("private", false);
        }
    }

    public static final class f extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f7283c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // R5.x0
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f7284c = new g();

        public g() {
            super("protected", true);
        }
    }

    public static final class h extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f7285c = new h();

        public h() {
            super("public", true);
        }
    }

    public static final class i extends x0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f7286c = new i();

        public i() {
            super(FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, false);
        }
    }

    static {
        Map mapC = p5.L.c();
        mapC.put(f.f7283c, 0);
        mapC.put(e.f7282c, 0);
        mapC.put(b.f7279c, 1);
        mapC.put(g.f7284c, 1);
        h hVar = h.f7285c;
        mapC.put(hVar, 2);
        f7276b = p5.L.b(mapC);
        f7277c = hVar;
    }

    public final Integer a(x0 first, x0 second) {
        AbstractC2304t.f(first, "first");
        AbstractC2304t.f(second, "second");
        if (first == second) {
            return 0;
        }
        Map map = f7276b;
        Integer num = (Integer) map.get(first);
        Integer num2 = (Integer) map.get(second);
        if (num == null || num2 == null || AbstractC2304t.b(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(x0 visibility) {
        AbstractC2304t.f(visibility, "visibility");
        return visibility == e.f7282c || visibility == f.f7283c;
    }
}
