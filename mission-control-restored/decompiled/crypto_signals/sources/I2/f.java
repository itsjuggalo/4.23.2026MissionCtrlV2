package I2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f implements F2.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f630f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f631g = new F2.c(k0.a.h(k0.a.g(e.class, new a(1))), "key");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f632h = new F2.c(k0.a.h(k0.a.g(e.class, new a(2))), "value");
    public static final H2.a i = new H2.a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H2.a f636d;
    public final h e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, H2.a aVar) {
        this.f633a = byteArrayOutputStream;
        this.f634b = map;
        this.f635c = map2;
        this.f636d = aVar;
    }

    public static int j(F2.c cVar) {
        e eVar = (e) ((Annotation) cVar.f510b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f626a;
        }
        throw new F2.b("Field has no @Protobuf config");
    }

    @Override // F2.e
    public final F2.e a(F2.c cVar, Object obj) {
        h(cVar, obj, true);
        return this;
    }

    @Override // F2.e
    public final F2.e b(F2.c cVar, double d4) throws IOException {
        c(cVar, d4, true);
        return this;
    }

    public final void c(F2.c cVar, double d4, boolean z6) throws IOException {
        if (z6 && d4 == 0.0d) {
            return;
        }
        k((j(cVar) << 3) | 1);
        this.f633a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d4).array());
    }

    public final void d(F2.c cVar, int i6, boolean z6) {
        if (z6 && i6 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f510b.get(e.class));
        if (eVar == null) {
            throw new F2.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f626a << 3);
        k(i6);
    }

    @Override // F2.e
    public final F2.e e(F2.c cVar, boolean z6) {
        d(cVar, z6 ? 1 : 0, true);
        return this;
    }

    @Override // F2.e
    public final F2.e f(F2.c cVar, long j4) throws IOException {
        if (j4 == 0) {
            return this;
        }
        e eVar = (e) ((Annotation) cVar.f510b.get(e.class));
        if (eVar == null) {
            throw new F2.b("Field has no @Protobuf config");
        }
        k(((a) eVar).f626a << 3);
        l(j4);
        return this;
    }

    @Override // F2.e
    public final F2.e g(F2.c cVar, int i6) {
        d(cVar, i6, true);
        return this;
    }

    public final void h(F2.c cVar, Object obj, boolean z6) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z6 && charSequence.length() == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f630f);
            k(bytes.length);
            this.f633a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                h(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                i(i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            c(cVar, ((Double) obj).doubleValue(), z6);
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z6 && fFloatValue == 0.0f) {
                return;
            }
            k((j(cVar) << 3) | 5);
            this.f633a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z6 && jLongValue == 0) {
                return;
            }
            e eVar = (e) ((Annotation) cVar.f510b.get(e.class));
            if (eVar == null) {
                throw new F2.b("Field has no @Protobuf config");
            }
            k(((a) eVar).f626a << 3);
            l(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            d(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z6);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z6 && bArr.length == 0) {
                return;
            }
            k((j(cVar) << 3) | 2);
            k(bArr.length);
            this.f633a.write(bArr);
            return;
        }
        F2.d dVar = (F2.d) this.f634b.get(obj.getClass());
        if (dVar != null) {
            i(dVar, cVar, obj, z6);
            return;
        }
        F2.f fVar = (F2.f) this.f635c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.e;
            hVar.f638a = false;
            hVar.f640c = cVar;
            hVar.f639b = z6;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            d(cVar, ((c) obj).a(), true);
        } else if (obj instanceof Enum) {
            d(cVar, ((Enum) obj).ordinal(), true);
        } else {
            i(this.f636d, cVar, obj, z6);
        }
    }

    public final void i(F2.d dVar, F2.c cVar, Object obj, boolean z6) throws IOException {
        b bVar = new b();
        bVar.f627a = 0L;
        try {
            OutputStream outputStream = this.f633a;
            this.f633a = bVar;
            try {
                dVar.a(obj, this);
                this.f633a = outputStream;
                long j4 = bVar.f627a;
                bVar.close();
                if (z6 && j4 == 0) {
                    return;
                }
                k((j(cVar) << 3) | 2);
                l(j4);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f633a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void k(int i6) throws IOException {
        while ((i6 & (-128)) != 0) {
            this.f633a.write((i6 & 127) | 128);
            i6 >>>= 7;
        }
        this.f633a.write(i6 & 127);
    }

    public final void l(long j4) throws IOException {
        while (((-128) & j4) != 0) {
            this.f633a.write((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        this.f633a.write(((int) j4) & 127);
    }
}
