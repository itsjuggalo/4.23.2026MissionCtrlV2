package u7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;

/* JADX INFO: loaded from: classes2.dex */
public final class P {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f23594h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f23595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f23600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public P f23601g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public P() {
        this.f23595a = new byte[8192];
        this.f23599e = true;
        this.f23598d = false;
    }

    public final void a() {
        int i8;
        P p8 = this.f23601g;
        if (p8 == this) {
            throw new IllegalStateException("cannot compact".toString());
        }
        AbstractC2304t.c(p8);
        if (p8.f23599e) {
            int i9 = this.f23597c - this.f23596b;
            P p9 = this.f23601g;
            AbstractC2304t.c(p9);
            int i10 = 8192 - p9.f23597c;
            P p10 = this.f23601g;
            AbstractC2304t.c(p10);
            if (p10.f23598d) {
                i8 = 0;
            } else {
                P p11 = this.f23601g;
                AbstractC2304t.c(p11);
                i8 = p11.f23596b;
            }
            if (i9 > i10 + i8) {
                return;
            }
            P p12 = this.f23601g;
            AbstractC2304t.c(p12);
            f(p12, i9);
            b();
            Q.b(this);
        }
    }

    public final P b() {
        P p8 = this.f23600f;
        if (p8 == this) {
            p8 = null;
        }
        P p9 = this.f23601g;
        AbstractC2304t.c(p9);
        p9.f23600f = this.f23600f;
        P p10 = this.f23600f;
        AbstractC2304t.c(p10);
        p10.f23601g = this.f23601g;
        this.f23600f = null;
        this.f23601g = null;
        return p8;
    }

    public final P c(P segment) {
        AbstractC2304t.f(segment, "segment");
        segment.f23601g = this;
        segment.f23600f = this.f23600f;
        P p8 = this.f23600f;
        AbstractC2304t.c(p8);
        p8.f23601g = segment;
        this.f23600f = segment;
        return segment;
    }

    public final P d() {
        this.f23598d = true;
        return new P(this.f23595a, this.f23596b, this.f23597c, true, false);
    }

    public final P e(int i8) {
        P pC;
        if (i8 <= 0 || i8 > this.f23597c - this.f23596b) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i8 >= 1024) {
            pC = d();
        } else {
            pC = Q.c();
            byte[] bArr = this.f23595a;
            byte[] bArr2 = pC.f23595a;
            int i9 = this.f23596b;
            AbstractC2590l.i(bArr, bArr2, 0, i9, i9 + i8, 2, null);
        }
        pC.f23597c = pC.f23596b + i8;
        this.f23596b += i8;
        P p8 = this.f23601g;
        AbstractC2304t.c(p8);
        p8.c(pC);
        return pC;
    }

    public final void f(P sink, int i8) {
        AbstractC2304t.f(sink, "sink");
        if (!sink.f23599e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i9 = sink.f23597c;
        if (i9 + i8 > 8192) {
            if (sink.f23598d) {
                throw new IllegalArgumentException();
            }
            int i10 = sink.f23596b;
            if ((i9 + i8) - i10 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f23595a;
            AbstractC2590l.i(bArr, bArr, 0, i10, i9, 2, null);
            sink.f23597c -= sink.f23596b;
            sink.f23596b = 0;
        }
        byte[] bArr2 = this.f23595a;
        byte[] bArr3 = sink.f23595a;
        int i11 = sink.f23597c;
        int i12 = this.f23596b;
        AbstractC2590l.e(bArr2, bArr3, i11, i12, i12 + i8);
        sink.f23597c += i8;
        this.f23596b += i8;
    }

    public P(byte[] data, int i8, int i9, boolean z7, boolean z8) {
        AbstractC2304t.f(data, "data");
        this.f23595a = data;
        this.f23596b = i8;
        this.f23597c = i9;
        this.f23598d = z7;
        this.f23599e = z8;
    }
}
