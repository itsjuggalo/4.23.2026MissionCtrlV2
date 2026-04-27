package r5;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f22606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f22609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f22610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f22611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f22613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f22614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray f22615j;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f22616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f22617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f22618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f22619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f22620e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22621f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f22622g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f22623h;

        public a0 a() {
            return new a0(this.f22618c, this.f22619d, this.f22616a, this.f22617b, this.f22622g, this.f22620e, this.f22621f, this.f22623h);
        }

        public b b(String str) {
            this.f22619d = str;
            return this;
        }

        public b c(c cVar) {
            this.f22616a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f22617b = cVar;
            return this;
        }

        public b e(boolean z7) {
            this.f22623h = z7;
            return this;
        }

        public b f(d dVar) {
            this.f22618c = dVar;
            return this;
        }

        public b() {
        }
    }

    public interface c {
        Object a(InputStream inputStream);

        InputStream b(Object obj);
    }

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
        int iLastIndexOf = ((String) H2.m.o(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) H2.m.o(str, "fullServiceName")) + "/" + ((String) H2.m.o(str2, "methodName"));
    }

    public static b g() {
        return h(null, null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f22607b;
    }

    public String d() {
        return this.f22608c;
    }

    public d e() {
        return this.f22606a;
    }

    public boolean f() {
        return this.f22613h;
    }

    public Object i(InputStream inputStream) {
        return this.f22610e.a(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f22609d.b(obj);
    }

    public String toString() {
        return H2.g.b(this).d("fullMethodName", this.f22607b).d("type", this.f22606a).e("idempotent", this.f22612g).e("safe", this.f22613h).e("sampledToLocalTracing", this.f22614i).d("requestMarshaller", this.f22609d).d("responseMarshaller", this.f22610e).d("schemaDescriptor", this.f22611f).m().toString();
    }

    public a0(d dVar, String str, c cVar, c cVar2, Object obj, boolean z7, boolean z8, boolean z9) {
        this.f22615j = new AtomicReferenceArray(2);
        this.f22606a = (d) H2.m.o(dVar, "type");
        this.f22607b = (String) H2.m.o(str, "fullMethodName");
        this.f22608c = a(str);
        this.f22609d = (c) H2.m.o(cVar, "requestMarshaller");
        this.f22610e = (c) H2.m.o(cVar2, "responseMarshaller");
        this.f22611f = obj;
        this.f22612g = z7;
        this.f22613h = z8;
        this.f22614i = z9;
    }
}
