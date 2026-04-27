package K3;

import L3.C0401y;
import L3.J;
import L3.K;
import L3.W;
import L3.Z;
import L3.b0;
import L3.c0;
import L3.d0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements F3.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0033a f1326d = new C0033a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M3.e f1328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0401y f1329c;

    /* JADX INFO: renamed from: K3.a$a, reason: collision with other inner class name */
    public static final class C0033a extends a {
        public /* synthetic */ C0033a(AbstractC1585j abstractC1585j) {
            this();
        }

        public C0033a() {
            super(new f(false, false, false, false, false, false, null, false, false, null, false, false, null, 8191, null), M3.g.a(), null);
        }
    }

    public /* synthetic */ a(f fVar, M3.e eVar, AbstractC1585j abstractC1585j) {
        this(fVar, eVar);
    }

    @Override // F3.f
    public M3.e a() {
        return this.f1328b;
    }

    @Override // F3.i
    public final String b(F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        K k4 = new K();
        try {
            J.a(this, k4, serializer, obj);
            return k4.toString();
        } finally {
            k4.h();
        }
    }

    public final Object c(F3.a deserializer, h element) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        kotlin.jvm.internal.r.f(element, "element");
        return b0.a(this, element, deserializer);
    }

    public final Object d(F3.a deserializer, String string) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        kotlin.jvm.internal.r.f(string, "string");
        Z z4 = new Z(string);
        Object objP = new W(this, d0.OBJ, z4, deserializer.getDescriptor(), null).p(deserializer);
        z4.w();
        return objP;
    }

    public final h e(F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        return c0.c(this, obj, serializer);
    }

    public final f f() {
        return this.f1327a;
    }

    public final C0401y g() {
        return this.f1329c;
    }

    public a(f fVar, M3.e eVar) {
        this.f1327a = fVar;
        this.f1328b = eVar;
        this.f1329c = new C0401y();
    }
}
