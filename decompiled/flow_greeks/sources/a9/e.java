package a9;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import y8.g;
import y8.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements y8.f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f373b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y8.e f377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f378g;

    public e(Writer writer, Map map, Map map2, y8.e eVar, boolean z10) {
        this.f374c = new JsonWriter(writer);
        this.f375d = map;
        this.f376e = map2;
        this.f377f = eVar;
        this.f378g = z10;
    }

    @Override // y8.f
    public y8.f a(y8.d dVar, boolean z10) {
        return q(dVar.b(), z10);
    }

    @Override // y8.f
    public y8.f b(y8.d dVar, double d10) {
        return m(dVar.b(), d10);
    }

    @Override // y8.f
    public y8.f c(y8.d dVar, int i10) {
        return n(dVar.b(), i10);
    }

    @Override // y8.f
    public y8.f d(y8.d dVar, long j10) {
        return o(dVar.b(), j10);
    }

    @Override // y8.f
    public y8.f e(y8.d dVar, Object obj) {
        return p(dVar.b(), obj);
    }

    public e h(double d10) throws IOException {
        y();
        this.f374c.value(d10);
        return this;
    }

    public e i(int i10) throws IOException {
        y();
        this.f374c.value(i10);
        return this;
    }

    public e j(long j10) throws IOException {
        y();
        this.f374c.value(j10);
        return this;
    }

    public e k(Object obj, boolean z10) {
        if (z10 && t(obj)) {
            throw new y8.c(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f374c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f374c.value((Number) obj);
            return this;
        }
        int i10 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f374c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.f374c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f374c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        p((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new y8.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f374c.endObject();
                return this;
            }
            y8.e eVar = (y8.e) this.f375d.get(obj.getClass());
            if (eVar != null) {
                return v(eVar, obj, z10);
            }
            g gVar = (g) this.f376e.get(obj.getClass());
            if (gVar != null) {
                gVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return v(this.f377f, obj, z10);
            }
            if (obj instanceof f) {
                i(((f) obj).d());
                return this;
            }
            f(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return s((byte[]) obj);
        }
        this.f374c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                this.f374c.value(r6[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                j(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f374c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f374c.value(zArr[i10]);
                i10++;
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
        this.f374c.endArray();
        return this;
    }

    @Override // y8.h
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public e f(String str) throws IOException {
        y();
        this.f374c.value(str);
        return this;
    }

    public e m(String str, double d10) throws IOException {
        y();
        this.f374c.name(str);
        return h(d10);
    }

    public e n(String str, int i10) throws IOException {
        y();
        this.f374c.name(str);
        return i(i10);
    }

    public e o(String str, long j10) throws IOException {
        y();
        this.f374c.name(str);
        return j(j10);
    }

    public e p(String str, Object obj) {
        return this.f378g ? x(str, obj) : w(str, obj);
    }

    public e q(String str, boolean z10) throws IOException {
        y();
        this.f374c.name(str);
        return g(z10);
    }

    @Override // y8.h
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e g(boolean z10) throws IOException {
        y();
        this.f374c.value(z10);
        return this;
    }

    public e s(byte[] bArr) throws IOException {
        y();
        if (bArr == null) {
            this.f374c.nullValue();
            return this;
        }
        this.f374c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    public final boolean t(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void u() {
        y();
        this.f374c.flush();
    }

    public e v(y8.e eVar, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f374c.beginObject();
        }
        eVar.a(obj, this);
        if (!z10) {
            this.f374c.endObject();
        }
        return this;
    }

    public final e w(String str, Object obj) throws IOException {
        y();
        this.f374c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f374c.nullValue();
        return this;
    }

    public final e x(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        y();
        this.f374c.name(str);
        return k(obj, false);
    }

    public final void y() throws IOException {
        if (!this.f373b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f372a;
        if (eVar != null) {
            eVar.y();
            this.f372a.f373b = false;
            this.f372a = null;
            this.f374c.endObject();
        }
    }
}
