package a9;

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
import y8.g;
import y8.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements z8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y8.e f362e = new y8.e() { // from class: a9.a
        @Override // y8.b
        public final void a(Object obj, Object obj2) {
            d.c(obj, (y8.f) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f363f = new g() { // from class: a9.b
        @Override // y8.b
        public final void a(Object obj, Object obj2) {
            ((h) obj2).f((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f364g = new g() { // from class: a9.c
        @Override // y8.b
        public final void a(Object obj, Object obj2) {
            ((h) obj2).g(((Boolean) obj).booleanValue());
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f365h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f366a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f367b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y8.e f368c = f362e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f369d = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements y8.a {
        public a() {
        }

        @Override // y8.a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f366a, d.this.f367b, d.this.f368c, d.this.f369d);
            eVar.k(obj, false);
            eVar.u();
        }

        @Override // y8.a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f371a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f371a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        @Override // y8.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, h hVar) {
            hVar.f(f371a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f363f);
        m(Boolean.class, f364g);
        m(Date.class, f365h);
    }

    public static /* synthetic */ void c(Object obj, y8.f fVar) {
        throw new y8.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public y8.a i() {
        return new a();
    }

    public d j(z8.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z10) {
        this.f369d = z10;
        return this;
    }

    @Override // z8.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public d a(Class cls, y8.e eVar) {
        this.f366a.put(cls, eVar);
        this.f367b.remove(cls);
        return this;
    }

    public d m(Class cls, g gVar) {
        this.f367b.put(cls, gVar);
        this.f366a.remove(cls);
        return this;
    }
}
