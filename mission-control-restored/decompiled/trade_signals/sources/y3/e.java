package y3;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import w3.g;
import w3.h;

/* JADX INFO: loaded from: classes.dex */
public final class e implements w3.f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f24478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24479b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f24480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f24481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f24482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w3.e f24483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24484g;

    public e(Writer writer, Map map, Map map2, w3.e eVar, boolean z7) {
        this.f24480c = new JsonWriter(writer);
        this.f24481d = map;
        this.f24482e = map2;
        this.f24483f = eVar;
        this.f24484g = z7;
    }

    @Override // w3.f
    public w3.f a(w3.d dVar, long j8) {
        return o(dVar.b(), j8);
    }

    @Override // w3.f
    public w3.f b(w3.d dVar, int i8) {
        return n(dVar.b(), i8);
    }

    @Override // w3.f
    public w3.f c(w3.d dVar, boolean z7) {
        return q(dVar.b(), z7);
    }

    @Override // w3.f
    public w3.f d(w3.d dVar, double d8) {
        return m(dVar.b(), d8);
    }

    @Override // w3.f
    public w3.f g(w3.d dVar, Object obj) {
        return p(dVar.b(), obj);
    }

    public e h(double d8) throws IOException {
        y();
        this.f24480c.value(d8);
        return this;
    }

    public e i(int i8) throws IOException {
        y();
        this.f24480c.value(i8);
        return this;
    }

    public e j(long j8) throws IOException {
        y();
        this.f24480c.value(j8);
        return this;
    }

    public e k(Object obj, boolean z7) {
        if (z7 && t(obj)) {
            throw new w3.c(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f24480c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f24480c.value((Number) obj);
            return this;
        }
        int i8 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f24480c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.f24480c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f24480c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        p((String) key, entry.getValue());
                    } catch (ClassCastException e8) {
                        throw new w3.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e8);
                    }
                }
                this.f24480c.endObject();
                return this;
            }
            w3.e eVar = (w3.e) this.f24481d.get(obj.getClass());
            if (eVar != null) {
                return v(eVar, obj, z7);
            }
            g gVar = (g) this.f24482e.get(obj.getClass());
            if (gVar != null) {
                gVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return v(this.f24483f, obj, z7);
            }
            if (obj instanceof f) {
                i(((f) obj).d());
            } else {
                e(((Enum) obj).name());
            }
            return this;
        }
        if (obj instanceof byte[]) {
            return s((byte[]) obj);
        }
        this.f24480c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i8 < length) {
                this.f24480c.value(r6[i8]);
                i8++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i8 < length2) {
                j(jArr[i8]);
                i8++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i8 < length3) {
                this.f24480c.value(dArr[i8]);
                i8++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i8 < length4) {
                this.f24480c.value(zArr[i8]);
                i8++;
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
        this.f24480c.endArray();
        return this;
    }

    @Override // w3.h
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public e e(String str) throws IOException {
        y();
        this.f24480c.value(str);
        return this;
    }

    public e m(String str, double d8) throws IOException {
        y();
        this.f24480c.name(str);
        return h(d8);
    }

    public e n(String str, int i8) throws IOException {
        y();
        this.f24480c.name(str);
        return i(i8);
    }

    public e o(String str, long j8) throws IOException {
        y();
        this.f24480c.name(str);
        return j(j8);
    }

    public e p(String str, Object obj) {
        return this.f24484g ? x(str, obj) : w(str, obj);
    }

    public e q(String str, boolean z7) throws IOException {
        y();
        this.f24480c.name(str);
        return f(z7);
    }

    @Override // w3.h
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e f(boolean z7) throws IOException {
        y();
        this.f24480c.value(z7);
        return this;
    }

    public e s(byte[] bArr) throws IOException {
        y();
        if (bArr == null) {
            this.f24480c.nullValue();
        } else {
            this.f24480c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean t(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void u() {
        y();
        this.f24480c.flush();
    }

    public e v(w3.e eVar, Object obj, boolean z7) throws IOException {
        if (!z7) {
            this.f24480c.beginObject();
        }
        eVar.a(obj, this);
        if (!z7) {
            this.f24480c.endObject();
        }
        return this;
    }

    public final e w(String str, Object obj) throws IOException {
        y();
        this.f24480c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f24480c.nullValue();
        return this;
    }

    public final e x(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        y();
        this.f24480c.name(str);
        return k(obj, false);
    }

    public final void y() throws IOException {
        if (!this.f24479b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f24478a;
        if (eVar != null) {
            eVar.y();
            this.f24478a.f24479b = false;
            this.f24478a = null;
            this.f24480c.endObject();
        }
    }
}
