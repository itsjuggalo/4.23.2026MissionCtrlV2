package z3;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import z3.d;

/* JADX INFO: loaded from: classes.dex */
public final class f implements w3.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f24741f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w3.d f24742g = w3.d.a("key").b(C3005a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final w3.d f24743h = w3.d.a("value").b(C3005a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w3.e f24744i = new w3.e() { // from class: z3.e
        @Override // w3.InterfaceC2923b
        public final void a(Object obj, Object obj2) {
            f.w((Map.Entry) obj, (w3.f) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f24745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f24747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w3.e f24748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f24749e = new i(this);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24750a;

        static {
            int[] iArr = new int[d.a.values().length];
            f24750a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24750a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24750a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(OutputStream outputStream, Map map, Map map2, w3.e eVar) {
        this.f24745a = outputStream;
        this.f24746b = map;
        this.f24747c = map2;
        this.f24748d = eVar;
    }

    public static ByteBuffer p(int i8) {
        return ByteBuffer.allocate(i8).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static d u(w3.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2;
        }
        throw new w3.c("Field has no @Protobuf config");
    }

    public static int v(w3.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2.tag();
        }
        throw new w3.c("Field has no @Protobuf config");
    }

    public static /* synthetic */ void w(Map.Entry entry, w3.f fVar) {
        fVar.g(f24742g, entry.getKey());
        fVar.g(f24743h, entry.getValue());
    }

    @Override // w3.f
    public w3.f d(w3.d dVar, double d8) {
        return f(dVar, d8, true);
    }

    public w3.f f(w3.d dVar, double d8, boolean z7) throws IOException {
        if (z7 && d8 == 0.0d) {
            return this;
        }
        x((v(dVar) << 3) | 1);
        this.f24745a.write(p(8).putDouble(d8).array());
        return this;
    }

    @Override // w3.f
    public w3.f g(w3.d dVar, Object obj) {
        return i(dVar, obj, true);
    }

    public w3.f h(w3.d dVar, float f8, boolean z7) throws IOException {
        if (z7 && f8 == 0.0f) {
            return this;
        }
        x((v(dVar) << 3) | 5);
        this.f24745a.write(p(4).putFloat(f8).array());
        return this;
    }

    public w3.f i(w3.d dVar, Object obj, boolean z7) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z7 && charSequence.length() == 0) {
                return this;
            }
            x((v(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f24741f);
            x(bytes.length);
            this.f24745a.write(bytes);
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
                r(f24744i, dVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return f(dVar, ((Double) obj).doubleValue(), z7);
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
            w3.e eVar = (w3.e) this.f24746b.get(obj.getClass());
            if (eVar != null) {
                return r(eVar, dVar, obj, z7);
            }
            w3.g gVar = (w3.g) this.f24747c.get(obj.getClass());
            return gVar != null ? s(gVar, dVar, obj, z7) : obj instanceof InterfaceC3007c ? b(dVar, ((InterfaceC3007c) obj).d()) : obj instanceof Enum ? b(dVar, ((Enum) obj).ordinal()) : r(this.f24748d, dVar, obj, z7);
        }
        byte[] bArr = (byte[]) obj;
        if (z7 && bArr.length == 0) {
            return this;
        }
        x((v(dVar) << 3) | 2);
        x(bArr.length);
        this.f24745a.write(bArr);
        return this;
    }

    @Override // w3.f
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f b(w3.d dVar, int i8) {
        return k(dVar, i8, true);
    }

    public f k(w3.d dVar, int i8, boolean z7) throws IOException {
        if (z7 && i8 == 0) {
            return this;
        }
        d dVarU = u(dVar);
        int i9 = a.f24750a[dVarU.intEncoding().ordinal()];
        if (i9 == 1) {
            x(dVarU.tag() << 3);
            x(i8);
        } else if (i9 == 2) {
            x(dVarU.tag() << 3);
            x((i8 << 1) ^ (i8 >> 31));
        } else if (i9 == 3) {
            x((dVarU.tag() << 3) | 5);
            this.f24745a.write(p(4).putInt(i8).array());
        }
        return this;
    }

    @Override // w3.f
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f a(w3.d dVar, long j8) {
        return m(dVar, j8, true);
    }

    public f m(w3.d dVar, long j8, boolean z7) throws IOException {
        if (z7 && j8 == 0) {
            return this;
        }
        d dVarU = u(dVar);
        int i8 = a.f24750a[dVarU.intEncoding().ordinal()];
        if (i8 == 1) {
            x(dVarU.tag() << 3);
            y(j8);
        } else if (i8 == 2) {
            x(dVarU.tag() << 3);
            y((j8 >> 63) ^ (j8 << 1));
        } else if (i8 == 3) {
            x((dVarU.tag() << 3) | 1);
            this.f24745a.write(p(8).putLong(j8).array());
        }
        return this;
    }

    @Override // w3.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public f c(w3.d dVar, boolean z7) {
        return o(dVar, z7, true);
    }

    public f o(w3.d dVar, boolean z7, boolean z8) {
        return k(dVar, z7 ? 1 : 0, z8);
    }

    public final long q(w3.e eVar, Object obj) throws IOException {
        C3006b c3006b = new C3006b();
        try {
            OutputStream outputStream = this.f24745a;
            this.f24745a = c3006b;
            try {
                eVar.a(obj, this);
                this.f24745a = outputStream;
                long jA = c3006b.a();
                c3006b.close();
                return jA;
            } catch (Throwable th) {
                this.f24745a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c3006b.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final f r(w3.e eVar, w3.d dVar, Object obj, boolean z7) throws IOException {
        long jQ = q(eVar, obj);
        if (z7 && jQ == 0) {
            return this;
        }
        x((v(dVar) << 3) | 2);
        y(jQ);
        eVar.a(obj, this);
        return this;
    }

    public final f s(w3.g gVar, w3.d dVar, Object obj, boolean z7) {
        this.f24749e.b(dVar, z7);
        gVar.a(obj, this.f24749e);
        return this;
    }

    public f t(Object obj) {
        if (obj == null) {
            return this;
        }
        w3.e eVar = (w3.e) this.f24746b.get(obj.getClass());
        if (eVar != null) {
            eVar.a(obj, this);
            return this;
        }
        throw new w3.c("No encoder for " + obj.getClass());
    }

    public final void x(int i8) throws IOException {
        while ((i8 & (-128)) != 0) {
            this.f24745a.write((i8 & 127) | 128);
            i8 >>>= 7;
        }
        this.f24745a.write(i8 & 127);
    }

    public final void y(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            this.f24745a.write((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        this.f24745a.write(((int) j8) & 127);
    }
}
