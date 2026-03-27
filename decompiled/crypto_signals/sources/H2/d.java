package H2;

import F2.g;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d implements G2.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f552g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f557d;
    public static final a e = new a(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f553h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [H2.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [H2.b] */
    static {
        final int i = 0;
        f551f = new F2.f() { // from class: H2.b
            @Override // F2.a
            public final void a(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        ((g) obj2).c((String) obj);
                        break;
                    default:
                        ((g) obj2).d(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i6 = 1;
        f552g = new F2.f() { // from class: H2.b
            @Override // F2.a
            public final void a(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        ((g) obj2).c((String) obj);
                        break;
                    default:
                        ((g) obj2).d(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap map = new HashMap();
        this.f554a = map;
        HashMap map2 = new HashMap();
        this.f555b = map2;
        this.f556c = e;
        this.f557d = false;
        map2.put(String.class, f551f);
        map.remove(String.class);
        map2.put(Boolean.class, f552g);
        map.remove(Boolean.class);
        map2.put(Date.class, f553h);
        map.remove(Date.class);
    }

    public final G2.a a(Class cls, F2.d dVar) {
        this.f554a.put(cls, dVar);
        this.f555b.remove(cls);
        return this;
    }
}
