package p7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import q7.C2667z;
import q7.M;
import q7.N;
import q7.Y;
import q7.b0;
import q7.c0;
import q7.f0;
import q7.h0;
import q7.i0;

/* JADX INFO: renamed from: p7.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2609b implements k7.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f22439d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2614g f22440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r7.e f22441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2667z f22442c;

    /* JADX INFO: renamed from: p7.b$a */
    public static final class a extends AbstractC2609b {
        public a() {
            super(new C2614g(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 131071, null), r7.g.a(), null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public AbstractC2609b(C2614g c2614g, r7.e eVar) {
        this.f22440a = c2614g;
        this.f22441b = eVar;
        this.f22442c = new C2667z();
    }

    @Override // k7.i
    public r7.e a() {
        return this.f22441b;
    }

    @Override // k7.l
    public final String b(k7.k serializer, Object obj) {
        AbstractC2304t.f(serializer, "serializer");
        N n8 = new N();
        try {
            M.a(this, n8, serializer, obj);
            return n8.toString();
        } finally {
            n8.h();
        }
    }

    public final Object c(k7.a deserializer, i element) {
        AbstractC2304t.f(deserializer, "deserializer");
        AbstractC2304t.f(element, "element");
        return f0.a(this, element, deserializer);
    }

    public final Object d(k7.a deserializer, String string) {
        AbstractC2304t.f(deserializer, "deserializer");
        AbstractC2304t.f(string, "string");
        b0 b0VarA = c0.a(this, string);
        Object objV = new Y(this, i0.f22883c, b0VarA, deserializer.getDescriptor(), null).v(deserializer);
        b0VarA.v();
        return objV;
    }

    public final i e(k7.k serializer, Object obj) {
        AbstractC2304t.f(serializer, "serializer");
        return h0.d(this, obj, serializer);
    }

    public final C2614g f() {
        return this.f22440a;
    }

    public final C2667z g() {
        return this.f22442c;
    }

    public /* synthetic */ AbstractC2609b(C2614g c2614g, r7.e eVar, AbstractC2296k abstractC2296k) {
        this(c2614g, eVar);
    }
}
