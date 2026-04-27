package x3;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import v3.g;
import v3.h;

/* JADX INFO: renamed from: x3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2824e implements v3.f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2824e f25303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25304b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f25305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f25306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f25307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v3.e f25308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f25309g;

    public C2824e(Writer writer, Map map, Map map2, v3.e eVar, boolean z7) {
        this.f25305c = new JsonWriter(writer);
        this.f25306d = map;
        this.f25307e = map2;
        this.f25308f = eVar;
        this.f25309g = z7;
    }

    @Override // v3.f
    public v3.f a(v3.d dVar, double d7) {
        return m(dVar.b(), d7);
    }

    @Override // v3.f
    public v3.f b(v3.d dVar, int i7) {
        return n(dVar.b(), i7);
    }

    @Override // v3.f
    public v3.f c(v3.d dVar, long j7) {
        return o(dVar.b(), j7);
    }

    @Override // v3.f
    public v3.f d(v3.d dVar, Object obj) {
        return p(dVar.b(), obj);
    }

    @Override // v3.f
    public v3.f e(v3.d dVar, boolean z7) {
        return q(dVar.b(), z7);
    }

    public C2824e h(double d7) throws IOException {
        y();
        this.f25305c.value(d7);
        return this;
    }

    public C2824e i(int i7) throws IOException {
        y();
        this.f25305c.value(i7);
        return this;
    }

    public C2824e j(long j7) throws IOException {
        y();
        this.f25305c.value(j7);
        return this;
    }

    public C2824e k(Object obj, boolean z7) {
        if (z7 && t(obj)) {
            throw new v3.c(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f25305c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f25305c.value((Number) obj);
            return this;
        }
        int i7 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f25305c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.f25305c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f25305c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        p((String) key, entry.getValue());
                    } catch (ClassCastException e7) {
                        throw new v3.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e7);
                    }
                }
                this.f25305c.endObject();
                return this;
            }
            v3.e eVar = (v3.e) this.f25306d.get(obj.getClass());
            if (eVar != null) {
                return v(eVar, obj, z7);
            }
            g gVar = (g) this.f25307e.get(obj.getClass());
            if (gVar != null) {
                gVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return v(this.f25308f, obj, z7);
            }
            if (obj instanceof InterfaceC2825f) {
                i(((InterfaceC2825f) obj).d());
            } else {
                f(((Enum) obj).name());
            }
            return this;
        }
        if (obj instanceof byte[]) {
            return s((byte[]) obj);
        }
        this.f25305c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i7 < length) {
                this.f25305c.value(r6[i7]);
                i7++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i7 < length2) {
                j(jArr[i7]);
                i7++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i7 < length3) {
                this.f25305c.value(dArr[i7]);
                i7++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i7 < length4) {
                this.f25305c.value(zArr[i7]);
                i7++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                k(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                k(obj2, false);
            }
        }
        this.f25305c.endArray();
        return this;
    }

    @Override // v3.h
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public C2824e f(String str) throws IOException {
        y();
        this.f25305c.value(str);
        return this;
    }

    public C2824e m(String str, double d7) throws IOException {
        y();
        this.f25305c.name(str);
        return h(d7);
    }

    public C2824e n(String str, int i7) throws IOException {
        y();
        this.f25305c.name(str);
        return i(i7);
    }

    public C2824e o(String str, long j7) throws IOException {
        y();
        this.f25305c.name(str);
        return j(j7);
    }

    public C2824e p(String str, Object obj) {
        return this.f25309g ? x(str, obj) : w(str, obj);
    }

    public C2824e q(String str, boolean z7) throws IOException {
        y();
        this.f25305c.name(str);
        return g(z7);
    }

    @Override // v3.h
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public C2824e g(boolean z7) throws IOException {
        y();
        this.f25305c.value(z7);
        return this;
    }

    public C2824e s(byte[] bArr) throws IOException {
        y();
        if (bArr == null) {
            this.f25305c.nullValue();
        } else {
            this.f25305c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean t(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void u() {
        y();
        this.f25305c.flush();
    }

    public C2824e v(v3.e eVar, Object obj, boolean z7) throws IOException {
        if (!z7) {
            this.f25305c.beginObject();
        }
        eVar.a(obj, this);
        if (!z7) {
            this.f25305c.endObject();
        }
        return this;
    }

    public final C2824e w(String str, Object obj) throws IOException {
        y();
        this.f25305c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f25305c.nullValue();
        return this;
    }

    public final C2824e x(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        y();
        this.f25305c.name(str);
        return k(obj, false);
    }

    public final void y() throws IOException {
        if (!this.f25304b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        C2824e c2824e = this.f25303a;
        if (c2824e != null) {
            c2824e.y();
            this.f25303a.f25304b = false;
            this.f25303a = null;
            this.f25305c.endObject();
        }
    }
}
