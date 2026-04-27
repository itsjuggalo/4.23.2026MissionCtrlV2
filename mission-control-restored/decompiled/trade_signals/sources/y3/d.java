package y3;

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
import w3.InterfaceC2922a;
import w3.g;
import w3.h;
import x3.InterfaceC2956a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements x3.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w3.e f24468e = new w3.e() { // from class: y3.a
        @Override // w3.InterfaceC2923b
        public final void a(Object obj, Object obj2) {
            d.l(obj, (w3.f) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f24469f = new g() { // from class: y3.b
        @Override // w3.InterfaceC2923b
        public final void a(Object obj, Object obj2) {
            ((h) obj2).e((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f24470g = new g() { // from class: y3.c
        @Override // w3.InterfaceC2923b
        public final void a(Object obj, Object obj2) {
            d.n((Boolean) obj, (h) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f24471h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24472a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24473b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w3.e f24474c = f24468e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24475d = false;

    public class a implements InterfaceC2922a {
        public a() {
        }

        @Override // w3.InterfaceC2922a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f24472a, d.this.f24473b, d.this.f24474c, d.this.f24475d);
            eVar.k(obj, false);
            eVar.u();
        }

        @Override // w3.InterfaceC2922a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f24477a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f24477a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        @Override // w3.InterfaceC2923b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, h hVar) {
            hVar.e(f24477a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        p(String.class, f24469f);
        p(Boolean.class, f24470g);
        p(Date.class, f24471h);
    }

    public static /* synthetic */ void l(Object obj, w3.f fVar) {
        throw new w3.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void n(Boolean bool, h hVar) {
        hVar.f(bool.booleanValue());
    }

    public InterfaceC2922a i() {
        return new a();
    }

    public d j(InterfaceC2956a interfaceC2956a) {
        interfaceC2956a.a(this);
        return this;
    }

    public d k(boolean z7) {
        this.f24475d = z7;
        return this;
    }

    @Override // x3.b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public d a(Class cls, w3.e eVar) {
        this.f24472a.put(cls, eVar);
        this.f24473b.remove(cls);
        return this;
    }

    public d p(Class cls, g gVar) {
        this.f24473b.put(cls, gVar);
        this.f24472a.remove(cls);
        return this;
    }
}
