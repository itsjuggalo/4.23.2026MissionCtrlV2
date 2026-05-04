package rb;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f19760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f19763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f19764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f19765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f19768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray f19769j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f19770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f19771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f19772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f19773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f19776g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19777h;

        public z0 a() {
            return new z0(this.f19772c, this.f19773d, this.f19770a, this.f19771b, this.f19776g, this.f19774e, this.f19775f, this.f19777h);
        }

        public b b(String str) {
            this.f19773d = str;
            return this;
        }

        public b c(c cVar) {
            this.f19770a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f19771b = cVar;
            return this;
        }

        public b e(boolean z10) {
            this.f19777h = z10;
            return this;
        }

        public b f(d dVar) {
            this.f19772c = dVar;
            return this;
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        Object a(InputStream inputStream);

        InputStream b(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean a() {
            return this == UNARY || this == SERVER_STREAMING;
        }
    }

    public static String a(String str) {
        int iLastIndexOf = ((String) p6.n.o(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) p6.n.o(str, "fullServiceName")) + "/" + ((String) p6.n.o(str2, "methodName"));
    }

    public static b g() {
        return h(null, null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f19761b;
    }

    public String d() {
        return this.f19762c;
    }

    public d e() {
        return this.f19760a;
    }

    public boolean f() {
        return this.f19767h;
    }

    public Object i(InputStream inputStream) {
        return this.f19764e.a(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f19763d.b(obj);
    }

    public String toString() {
        return p6.h.b(this).d("fullMethodName", this.f19761b).d("type", this.f19760a).e("idempotent", this.f19766g).e("safe", this.f19767h).e("sampledToLocalTracing", this.f19768i).d("requestMarshaller", this.f19763d).d("responseMarshaller", this.f19764e).d("schemaDescriptor", this.f19765f).m().toString();
    }

    public z0(d dVar, String str, c cVar, c cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f19769j = new AtomicReferenceArray(2);
        this.f19760a = (d) p6.n.o(dVar, "type");
        this.f19761b = (String) p6.n.o(str, "fullMethodName");
        this.f19762c = a(str);
        this.f19763d = (c) p6.n.o(cVar, "requestMarshaller");
        this.f19764e = (c) p6.n.o(cVar2, "responseMarshaller");
        this.f19765f = obj;
        this.f19766g = z10;
        this.f19767h = z11;
        this.f19768i = z12;
    }
}
