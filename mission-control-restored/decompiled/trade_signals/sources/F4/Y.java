package F4;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f1702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f1703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray f1708j;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f1709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f1710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f1711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f1715g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1716h;

        public b() {
        }

        public Y a() {
            return new Y(this.f1711c, this.f1712d, this.f1709a, this.f1710b, this.f1715g, this.f1713e, this.f1714f, this.f1716h);
        }

        public b b(String str) {
            this.f1712d = str;
            return this;
        }

        public b c(c cVar) {
            this.f1709a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f1710b = cVar;
            return this;
        }

        public b e(boolean z7) {
            this.f1716h = z7;
            return this;
        }

        public b f(d dVar) {
            this.f1711c = dVar;
            return this;
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

    public Y(d dVar, String str, c cVar, c cVar2, Object obj, boolean z7, boolean z8, boolean z9) {
        this.f1708j = new AtomicReferenceArray(2);
        this.f1699a = (d) AbstractC2848n.o(dVar, "type");
        this.f1700b = (String) AbstractC2848n.o(str, "fullMethodName");
        this.f1701c = a(str);
        this.f1702d = (c) AbstractC2848n.o(cVar, "requestMarshaller");
        this.f1703e = (c) AbstractC2848n.o(cVar2, "responseMarshaller");
        this.f1704f = obj;
        this.f1705g = z7;
        this.f1706h = z8;
        this.f1707i = z9;
    }

    public static String a(String str) {
        int iLastIndexOf = ((String) AbstractC2848n.o(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) AbstractC2848n.o(str, "fullServiceName")) + "/" + ((String) AbstractC2848n.o(str2, "methodName"));
    }

    public static b g() {
        return h(null, null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f1700b;
    }

    public String d() {
        return this.f1701c;
    }

    public d e() {
        return this.f1699a;
    }

    public boolean f() {
        return this.f1706h;
    }

    public Object i(InputStream inputStream) {
        return this.f1703e.a(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f1702d.b(obj);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("fullMethodName", this.f1700b).d("type", this.f1699a).e("idempotent", this.f1705g).e("safe", this.f1706h).e("sampledToLocalTracing", this.f1707i).d("requestMarshaller", this.f1702d).d("responseMarshaller", this.f1703e).d("schemaDescriptor", this.f1704f).m().toString();
    }
}
