package b9;

import b9.d;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements y8.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f3042f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y8.d f3043g = y8.d.a("key").b(b9.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y8.d f3044h = y8.d.a("value").b(b9.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y8.e f3045i = new y8.e() { // from class: b9.e
        @Override // y8.b
        public final void a(Object obj, Object obj2) {
            f.f((Map.Entry) obj, (y8.f) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f3046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y8.e f3049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f3050e = new i(this);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3051a;

        static {
            int[] iArr = new int[d.a.values().length];
            f3051a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3051a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3051a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(OutputStream outputStream, Map map, Map map2, y8.e eVar) {
        this.f3046a = outputStream;
        this.f3047b = map;
        this.f3048c = map2;
        this.f3049d = eVar;
    }

    public static /* synthetic */ void f(Map.Entry entry, y8.f fVar) {
        fVar.e(f3043g, entry.getKey());
        fVar.e(f3044h, entry.getValue());
    }

    public static ByteBuffer p(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static d u(y8.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2;
        }
        throw new y8.c("Field has no @Protobuf config");
    }

    public static int v(y8.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2.tag();
        }
        throw new y8.c("Field has no @Protobuf config");
    }

    @Override // y8.f
    public y8.f b(y8.d dVar, double d10) {
        return m(dVar, d10, true);
    }

    @Override // y8.f
    public y8.f e(y8.d dVar, Object obj) {
        return o(dVar, obj, true);
    }

    @Override // y8.f
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public f c(y8.d dVar, int i10) {
        return h(dVar, i10, true);
    }

    public f h(y8.d dVar, int i10, boolean z10) throws IOException {
        if (!z10 || i10 != 0) {
            d dVarU = u(dVar);
            int i11 = a.f3051a[dVarU.intEncoding().ordinal()];
            if (i11 == 1) {
                w(dVarU.tag() << 3);
                w(i10);
                return this;
            }
            if (i11 == 2) {
                w(dVarU.tag() << 3);
                w((i10 << 1) ^ (i10 >> 31));
                return this;
            }
            if (i11 == 3) {
                w((dVarU.tag() << 3) | 5);
                this.f3046a.write(p(4).putInt(i10).array());
                return this;
            }
        }
        return this;
    }

    @Override // y8.f
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public f d(y8.d dVar, long j10) {
        return j(dVar, j10, true);
    }

    public f j(y8.d dVar, long j10, boolean z10) throws IOException {
        if (!z10 || j10 != 0) {
            d dVarU = u(dVar);
            int i10 = a.f3051a[dVarU.intEncoding().ordinal()];
            if (i10 == 1) {
                w(dVarU.tag() << 3);
                x(j10);
                return this;
            }
            if (i10 == 2) {
                w(dVarU.tag() << 3);
                x((j10 >> 63) ^ (j10 << 1));
                return this;
            }
            if (i10 == 3) {
                w((dVarU.tag() << 3) | 1);
                this.f3046a.write(p(8).putLong(j10).array());
                return this;
            }
        }
        return this;
    }

    @Override // y8.f
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f a(y8.d dVar, boolean z10) {
        return l(dVar, z10, true);
    }

    public f l(y8.d dVar, boolean z10, boolean z11) {
        return h(dVar, z10 ? 1 : 0, z11);
    }

    public y8.f m(y8.d dVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        w((v(dVar) << 3) | 1);
        this.f3046a.write(p(8).putDouble(d10).array());
        return this;
    }

    public y8.f n(y8.d dVar, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        w((v(dVar) << 3) | 5);
        this.f3046a.write(p(4).putFloat(f10).array());
        return this;
    }

    public y8.f o(y8.d dVar, Object obj, boolean z10) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z10 || charSequence.length() != 0) {
                    w((v(dVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f3042f);
                    w(bytes.length);
                    this.f3046a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    o(dVar, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    r(f3045i, dVar, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    return m(dVar, ((Double) obj).doubleValue(), z10);
                }
                if (obj instanceof Float) {
                    return n(dVar, ((Float) obj).floatValue(), z10);
                }
                if (obj instanceof Number) {
                    return j(dVar, ((Number) obj).longValue(), z10);
                }
                if (obj instanceof Boolean) {
                    return l(dVar, ((Boolean) obj).booleanValue(), z10);
                }
                if (!(obj instanceof byte[])) {
                    y8.e eVar = (y8.e) this.f3047b.get(obj.getClass());
                    if (eVar != null) {
                        return r(eVar, dVar, obj, z10);
                    }
                    y8.g gVar = (y8.g) this.f3048c.get(obj.getClass());
                    return gVar != null ? s(gVar, dVar, obj, z10) : obj instanceof c ? c(dVar, ((c) obj).d()) : obj instanceof Enum ? c(dVar, ((Enum) obj).ordinal()) : r(this.f3049d, dVar, obj, z10);
                }
                byte[] bArr = (byte[]) obj;
                if (!z10 || bArr.length != 0) {
                    w((v(dVar) << 3) | 2);
                    w(bArr.length);
                    this.f3046a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    public final long q(y8.e eVar, Object obj) throws IOException {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f3046a;
            this.f3046a = bVar;
            try {
                eVar.a(obj, this);
                this.f3046a = outputStream;
                long jB = bVar.b();
                bVar.close();
                return jB;
            } catch (Throwable th) {
                this.f3046a = outputStream;
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

    public final f r(y8.e eVar, y8.d dVar, Object obj, boolean z10) throws IOException {
        long jQ = q(eVar, obj);
        if (z10 && jQ == 0) {
            return this;
        }
        w((v(dVar) << 3) | 2);
        x(jQ);
        eVar.a(obj, this);
        return this;
    }

    public final f s(y8.g gVar, y8.d dVar, Object obj, boolean z10) {
        this.f3050e.b(dVar, z10);
        gVar.a(obj, this.f3050e);
        return this;
    }

    public f t(Object obj) {
        if (obj == null) {
            return this;
        }
        y8.e eVar = (y8.e) this.f3047b.get(obj.getClass());
        if (eVar != null) {
            eVar.a(obj, this);
            return this;
        }
        throw new y8.c("No encoder for " + obj.getClass());
    }

    public final void w(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f3046a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f3046a.write(i10 & 127);
    }

    public final void x(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f3046a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f3046a.write(((int) j10) & 127);
    }
}
