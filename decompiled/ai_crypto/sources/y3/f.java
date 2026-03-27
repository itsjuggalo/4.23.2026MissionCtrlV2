package y3;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import y3.d;

/* JADX INFO: loaded from: classes.dex */
public final class f implements v3.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f25650f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v3.d f25651g = v3.d.a(SubscriberAttributeKt.JSON_NAME_KEY).b(C2842a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v3.d f25652h = v3.d.a("value").b(C2842a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v3.e f25653i = new v3.e() { // from class: y3.e
        @Override // v3.InterfaceC2766b
        public final void a(Object obj, Object obj2) {
            f.w((Map.Entry) obj, (v3.f) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f25654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f25655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f25656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v3.e f25657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f25658e = new i(this);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25659a;

        static {
            int[] iArr = new int[d.a.values().length];
            f25659a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25659a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25659a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(OutputStream outputStream, Map map, Map map2, v3.e eVar) {
        this.f25654a = outputStream;
        this.f25655b = map;
        this.f25656c = map2;
        this.f25657d = eVar;
    }

    public static ByteBuffer p(int i7) {
        return ByteBuffer.allocate(i7).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static d u(v3.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2;
        }
        throw new v3.c("Field has no @Protobuf config");
    }

    public static int v(v3.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2.tag();
        }
        throw new v3.c("Field has no @Protobuf config");
    }

    public static /* synthetic */ void w(Map.Entry entry, v3.f fVar) {
        fVar.d(f25651g, entry.getKey());
        fVar.d(f25652h, entry.getValue());
    }

    @Override // v3.f
    public v3.f a(v3.d dVar, double d7) {
        return g(dVar, d7, true);
    }

    @Override // v3.f
    public v3.f d(v3.d dVar, Object obj) {
        return i(dVar, obj, true);
    }

    public v3.f g(v3.d dVar, double d7, boolean z7) throws IOException {
        if (z7 && d7 == 0.0d) {
            return this;
        }
        x((v(dVar) << 3) | 1);
        this.f25654a.write(p(8).putDouble(d7).array());
        return this;
    }

    public v3.f h(v3.d dVar, float f7, boolean z7) throws IOException {
        if (z7 && f7 == 0.0f) {
            return this;
        }
        x((v(dVar) << 3) | 5);
        this.f25654a.write(p(4).putFloat(f7).array());
        return this;
    }

    public v3.f i(v3.d dVar, Object obj, boolean z7) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z7 && charSequence.length() == 0) {
                return this;
            }
            x((v(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f25650f);
            x(bytes.length);
            this.f25654a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                i(dVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                r(f25653i, dVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return g(dVar, ((Double) obj).doubleValue(), z7);
        }
        if (obj instanceof Float) {
            return h(dVar, ((Float) obj).floatValue(), z7);
        }
        if (obj instanceof Number) {
            return m(dVar, ((Number) obj).longValue(), z7);
        }
        if (obj instanceof Boolean) {
            return o(dVar, ((Boolean) obj).booleanValue(), z7);
        }
        if (!(obj instanceof byte[])) {
            v3.e eVar = (v3.e) this.f25655b.get(obj.getClass());
            if (eVar != null) {
                return r(eVar, dVar, obj, z7);
            }
            v3.g gVar = (v3.g) this.f25656c.get(obj.getClass());
            return gVar != null ? s(gVar, dVar, obj, z7) : obj instanceof c ? b(dVar, ((c) obj).d()) : obj instanceof Enum ? b(dVar, ((Enum) obj).ordinal()) : r(this.f25657d, dVar, obj, z7);
        }
        byte[] bArr = (byte[]) obj;
        if (z7 && bArr.length == 0) {
            return this;
        }
        x((v(dVar) << 3) | 2);
        x(bArr.length);
        this.f25654a.write(bArr);
        return this;
    }

    @Override // v3.f
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f b(v3.d dVar, int i7) {
        return k(dVar, i7, true);
    }

    public f k(v3.d dVar, int i7, boolean z7) throws IOException {
        if (z7 && i7 == 0) {
            return this;
        }
        d dVarU = u(dVar);
        int i8 = a.f25659a[dVarU.intEncoding().ordinal()];
        if (i8 == 1) {
            x(dVarU.tag() << 3);
            x(i7);
        } else if (i8 == 2) {
            x(dVarU.tag() << 3);
            x((i7 << 1) ^ (i7 >> 31));
        } else if (i8 == 3) {
            x((dVarU.tag() << 3) | 5);
            this.f25654a.write(p(4).putInt(i7).array());
        }
        return this;
    }

    @Override // v3.f
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f c(v3.d dVar, long j7) {
        return m(dVar, j7, true);
    }

    public f m(v3.d dVar, long j7, boolean z7) throws IOException {
        if (z7 && j7 == 0) {
            return this;
        }
        d dVarU = u(dVar);
        int i7 = a.f25659a[dVarU.intEncoding().ordinal()];
        if (i7 == 1) {
            x(dVarU.tag() << 3);
            y(j7);
        } else if (i7 == 2) {
            x(dVarU.tag() << 3);
            y((j7 >> 63) ^ (j7 << 1));
        } else if (i7 == 3) {
            x((dVarU.tag() << 3) | 1);
            this.f25654a.write(p(8).putLong(j7).array());
        }
        return this;
    }

    @Override // v3.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public f e(v3.d dVar, boolean z7) {
        return o(dVar, z7, true);
    }

    public f o(v3.d dVar, boolean z7, boolean z8) {
        return k(dVar, z7 ? 1 : 0, z8);
    }

    public final long q(v3.e eVar, Object obj) throws IOException {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f25654a;
            this.f25654a = bVar;
            try {
                eVar.a(obj, this);
                this.f25654a = outputStream;
                long jH = bVar.h();
                bVar.close();
                return jH;
            } catch (Throwable th) {
                this.f25654a = outputStream;
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

    public final f r(v3.e eVar, v3.d dVar, Object obj, boolean z7) throws IOException {
        long jQ = q(eVar, obj);
        if (z7 && jQ == 0) {
            return this;
        }
        x((v(dVar) << 3) | 2);
        y(jQ);
        eVar.a(obj, this);
        return this;
    }

    public final f s(v3.g gVar, v3.d dVar, Object obj, boolean z7) {
        this.f25658e.b(dVar, z7);
        gVar.a(obj, this.f25658e);
        return this;
    }

    public f t(Object obj) {
        if (obj == null) {
            return this;
        }
        v3.e eVar = (v3.e) this.f25655b.get(obj.getClass());
        if (eVar != null) {
            eVar.a(obj, this);
            return this;
        }
        throw new v3.c("No encoder for " + obj.getClass());
    }

    public final void x(int i7) throws IOException {
        while ((i7 & (-128)) != 0) {
            this.f25654a.write((i7 & 127) | 128);
            i7 >>>= 7;
        }
        this.f25654a.write(i7 & 127);
    }

    public final void y(long j7) throws IOException {
        while (((-128) & j7) != 0) {
            this.f25654a.write((((int) j7) & 127) | 128);
            j7 >>>= 7;
        }
        this.f25654a.write(((int) j7) & 127);
    }
}
