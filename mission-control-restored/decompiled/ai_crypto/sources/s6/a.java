package s6;

import kotlin.jvm.internal.AbstractC2148j;
import t6.C2734y;
import t6.J;
import t6.K;
import t6.W;
import t6.Z;
import t6.b0;
import t6.c0;
import t6.d0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements n6.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0359a f23013d = new C0359a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f23014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u6.e f23015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2734y f23016c;

    /* JADX INFO: renamed from: s6.a$a, reason: collision with other inner class name */
    public static final class C0359a extends a {
        public /* synthetic */ C0359a(AbstractC2148j abstractC2148j) {
            this();
        }

        public C0359a() {
            super(new f(false, false, false, false, false, false, null, false, false, null, false, false, null, 8191, null), u6.g.a(), null);
        }
    }

    public /* synthetic */ a(f fVar, u6.e eVar, AbstractC2148j abstractC2148j) {
        this(fVar, eVar);
    }

    @Override // n6.f
    public u6.e a() {
        return this.f23015b;
    }

    @Override // n6.i
    public final String b(n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        K k7 = new K();
        try {
            J.a(this, k7, serializer, obj);
            return k7.toString();
        } finally {
            k7.h();
        }
    }

    public final Object c(n6.a deserializer, h element) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        kotlin.jvm.internal.r.f(element, "element");
        return b0.a(this, element, deserializer);
    }

    public final Object d(n6.a deserializer, String string) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        kotlin.jvm.internal.r.f(string, "string");
        Z z7 = new Z(string);
        Object objL = new W(this, d0.OBJ, z7, deserializer.getDescriptor(), null).l(deserializer);
        z7.w();
        return objL;
    }

    public final h e(n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        return c0.c(this, obj, serializer);
    }

    public final f f() {
        return this.f23014a;
    }

    public final C2734y g() {
        return this.f23016c;
    }

    public a(f fVar, u6.e eVar) {
        this.f23014a = fVar;
        this.f23015b = eVar;
        this.f23016c = new C2734y();
    }
}
