package x3;

import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import v3.InterfaceC2765a;
import v3.g;
import v3.h;
import w3.InterfaceC2775a;
import w3.InterfaceC2776b;

/* JADX INFO: renamed from: x3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2823d implements InterfaceC2776b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v3.e f25293e = new v3.e() { // from class: x3.a
        @Override // v3.InterfaceC2766b
        public final void a(Object obj, Object obj2) {
            C2823d.l(obj, (v3.f) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f25294f = new g() { // from class: x3.b
        @Override // v3.InterfaceC2766b
        public final void a(Object obj, Object obj2) {
            ((h) obj2).f((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f25295g = new g() { // from class: x3.c
        @Override // v3.InterfaceC2766b
        public final void a(Object obj, Object obj2) {
            C2823d.n((Boolean) obj, (h) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f25296h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f25297a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f25298b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v3.e f25299c = f25293e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25300d = false;

    /* JADX INFO: renamed from: x3.d$a */
    public class a implements InterfaceC2765a {
        public a() {
        }

        @Override // v3.InterfaceC2765a
        public void a(Object obj, Writer writer) {
            C2824e c2824e = new C2824e(writer, C2823d.this.f25297a, C2823d.this.f25298b, C2823d.this.f25299c, C2823d.this.f25300d);
            c2824e.k(obj, false);
            c2824e.u();
        }

        @Override // v3.InterfaceC2765a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* JADX INFO: renamed from: x3.d$b */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f25302a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f25302a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, h hVar) {
            hVar.f(f25302a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C2823d() {
        p(String.class, f25294f);
        p(Boolean.class, f25295g);
        p(Date.class, f25296h);
    }

    public static /* synthetic */ void l(Object obj, v3.f fVar) {
        throw new v3.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void n(Boolean bool, h hVar) {
        hVar.g(bool.booleanValue());
    }

    public InterfaceC2765a i() {
        return new a();
    }

    public C2823d j(InterfaceC2775a interfaceC2775a) {
        interfaceC2775a.a(this);
        return this;
    }

    public C2823d k(boolean z7) {
        this.f25300d = z7;
        return this;
    }

    @Override // w3.InterfaceC2776b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public C2823d a(Class cls, v3.e eVar) {
        this.f25297a.put(cls, eVar);
        this.f25298b.remove(cls);
        return this;
    }

    public C2823d p(Class cls, g gVar) {
        this.f25298b.put(cls, gVar);
        this.f25297a.remove(cls);
        return this;
    }
}
