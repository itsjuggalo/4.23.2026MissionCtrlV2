package K2;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f1119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f1120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray f1125j;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f1126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f1127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f1128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f1132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1133h;

        public a0 a() {
            return new a0(this.f1128c, this.f1129d, this.f1126a, this.f1127b, this.f1132g, this.f1130e, this.f1131f, this.f1133h);
        }

        public b b(String str) {
            this.f1129d = str;
            return this;
        }

        public b c(c cVar) {
            this.f1126a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f1127b = cVar;
            return this;
        }

        public b e(boolean z4) {
            this.f1133h = z4;
            return this;
        }

        public b f(d dVar) {
            this.f1128c = dVar;
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
        int iLastIndexOf = ((String) Z1.m.o(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) Z1.m.o(str, "fullServiceName")) + RemoteSettings.FORWARD_SLASH_STRING + ((String) Z1.m.o(str2, "methodName"));
    }

    public static b g() {
        return h(null, null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f1117b;
    }

    public String d() {
        return this.f1118c;
    }

    public d e() {
        return this.f1116a;
    }

    public boolean f() {
        return this.f1123h;
    }

    public Object i(InputStream inputStream) {
        return this.f1120e.a(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f1119d.b(obj);
    }

    public String toString() {
        return Z1.g.b(this).d("fullMethodName", this.f1117b).d("type", this.f1116a).e("idempotent", this.f1122g).e("safe", this.f1123h).e("sampledToLocalTracing", this.f1124i).d("requestMarshaller", this.f1119d).d("responseMarshaller", this.f1120e).d("schemaDescriptor", this.f1121f).m().toString();
    }

    public a0(d dVar, String str, c cVar, c cVar2, Object obj, boolean z4, boolean z5, boolean z6) {
        this.f1125j = new AtomicReferenceArray(2);
        this.f1116a = (d) Z1.m.o(dVar, "type");
        this.f1117b = (String) Z1.m.o(str, "fullMethodName");
        this.f1118c = a(str);
        this.f1119d = (c) Z1.m.o(cVar, "requestMarshaller");
        this.f1120e = (c) Z1.m.o(cVar2, "responseMarshaller");
        this.f1121f = obj;
        this.f1122g = z4;
        this.f1123h = z5;
        this.f1124i = z6;
    }
}
