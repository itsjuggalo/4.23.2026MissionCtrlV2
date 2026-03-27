package w6;

import F5.AbstractC0551i;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class U {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f25051h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public U f25057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f25058g;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public U() {
        this.f25052a = new byte[8192];
        this.f25056e = true;
        this.f25055d = false;
    }

    public final void a() {
        int i7;
        U u7 = this.f25058g;
        if (u7 == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.r.c(u7);
        if (u7.f25056e) {
            int i8 = this.f25054c - this.f25053b;
            U u8 = this.f25058g;
            kotlin.jvm.internal.r.c(u8);
            int i9 = 8192 - u8.f25054c;
            U u9 = this.f25058g;
            kotlin.jvm.internal.r.c(u9);
            if (u9.f25055d) {
                i7 = 0;
            } else {
                U u10 = this.f25058g;
                kotlin.jvm.internal.r.c(u10);
                i7 = u10.f25053b;
            }
            if (i8 > i9 + i7) {
                return;
            }
            U u11 = this.f25058g;
            kotlin.jvm.internal.r.c(u11);
            g(u11, i8);
            b();
            V.b(this);
        }
    }

    public final U b() {
        U u7 = this.f25057f;
        if (u7 == this) {
            u7 = null;
        }
        U u8 = this.f25058g;
        kotlin.jvm.internal.r.c(u8);
        u8.f25057f = this.f25057f;
        U u9 = this.f25057f;
        kotlin.jvm.internal.r.c(u9);
        u9.f25058g = this.f25058g;
        this.f25057f = null;
        this.f25058g = null;
        return u7;
    }

    public final U c(U segment) {
        kotlin.jvm.internal.r.f(segment, "segment");
        segment.f25058g = this;
        segment.f25057f = this.f25057f;
        U u7 = this.f25057f;
        kotlin.jvm.internal.r.c(u7);
        u7.f25058g = segment;
        this.f25057f = segment;
        return segment;
    }

    public final U d() {
        this.f25055d = true;
        return new U(this.f25052a, this.f25053b, this.f25054c, true, false);
    }

    public final U e(int i7) {
        U uC;
        if (i7 <= 0 || i7 > this.f25054c - this.f25053b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i7 >= 1024) {
            uC = d();
        } else {
            uC = V.c();
            byte[] bArr = this.f25052a;
            byte[] bArr2 = uC.f25052a;
            int i8 = this.f25053b;
            AbstractC0551i.f(bArr, bArr2, 0, i8, i8 + i7, 2, null);
        }
        uC.f25054c = uC.f25053b + i7;
        this.f25053b += i7;
        U u7 = this.f25058g;
        kotlin.jvm.internal.r.c(u7);
        u7.c(uC);
        return uC;
    }

    public final U f() {
        byte[] bArr = this.f25052a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, size)");
        return new U(bArrCopyOf, this.f25053b, this.f25054c, false, true);
    }

    public final void g(U sink, int i7) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (!sink.f25056e) {
            throw new IllegalStateException("only owner can write");
        }
        int i8 = sink.f25054c;
        if (i8 + i7 > 8192) {
            if (sink.f25055d) {
                throw new IllegalArgumentException();
            }
            int i9 = sink.f25053b;
            if ((i8 + i7) - i9 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f25052a;
            AbstractC0551i.f(bArr, bArr, 0, i9, i8, 2, null);
            sink.f25054c -= sink.f25053b;
            sink.f25053b = 0;
        }
        byte[] bArr2 = this.f25052a;
        byte[] bArr3 = sink.f25052a;
        int i10 = sink.f25054c;
        int i11 = this.f25053b;
        AbstractC0551i.d(bArr2, bArr3, i10, i11, i11 + i7);
        sink.f25054c += i7;
        this.f25053b += i7;
    }

    public U(byte[] data, int i7, int i8, boolean z7, boolean z8) {
        kotlin.jvm.internal.r.f(data, "data");
        this.f25052a = data;
        this.f25053b = i7;
        this.f25054c = i8;
        this.f25055d = z7;
        this.f25056e = z8;
    }
}
