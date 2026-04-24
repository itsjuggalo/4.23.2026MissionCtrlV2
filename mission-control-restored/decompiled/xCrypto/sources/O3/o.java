package O3;

import X2.AbstractC0763j;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3346h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f3352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f3353g;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public o() {
        this.f3347a = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        this.f3351e = true;
        this.f3350d = false;
    }

    public final void a() {
        int i4;
        o oVar = this.f3353g;
        if (oVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.r.c(oVar);
        if (oVar.f3351e) {
            int i5 = this.f3349c - this.f3348b;
            o oVar2 = this.f3353g;
            kotlin.jvm.internal.r.c(oVar2);
            int i6 = 8192 - oVar2.f3349c;
            o oVar3 = this.f3353g;
            kotlin.jvm.internal.r.c(oVar3);
            if (oVar3.f3350d) {
                i4 = 0;
            } else {
                o oVar4 = this.f3353g;
                kotlin.jvm.internal.r.c(oVar4);
                i4 = oVar4.f3348b;
            }
            if (i5 > i6 + i4) {
                return;
            }
            o oVar5 = this.f3353g;
            kotlin.jvm.internal.r.c(oVar5);
            f(oVar5, i5);
            b();
            p.b(this);
        }
    }

    public final o b() {
        o oVar = this.f3352f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.f3353g;
        kotlin.jvm.internal.r.c(oVar2);
        oVar2.f3352f = this.f3352f;
        o oVar3 = this.f3352f;
        kotlin.jvm.internal.r.c(oVar3);
        oVar3.f3353g = this.f3353g;
        this.f3352f = null;
        this.f3353g = null;
        return oVar;
    }

    public final o c(o segment) {
        kotlin.jvm.internal.r.f(segment, "segment");
        segment.f3353g = this;
        segment.f3352f = this.f3352f;
        o oVar = this.f3352f;
        kotlin.jvm.internal.r.c(oVar);
        oVar.f3353g = segment;
        this.f3352f = segment;
        return segment;
    }

    public final o d() {
        this.f3350d = true;
        return new o(this.f3347a, this.f3348b, this.f3349c, true, false);
    }

    public final o e(int i4) {
        o oVarC;
        if (i4 <= 0 || i4 > this.f3349c - this.f3348b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i4 >= 1024) {
            oVarC = d();
        } else {
            oVarC = p.c();
            byte[] bArr = this.f3347a;
            byte[] bArr2 = oVarC.f3347a;
            int i5 = this.f3348b;
            AbstractC0763j.f(bArr, bArr2, 0, i5, i5 + i4, 2, null);
        }
        oVarC.f3349c = oVarC.f3348b + i4;
        this.f3348b += i4;
        o oVar = this.f3353g;
        kotlin.jvm.internal.r.c(oVar);
        oVar.c(oVarC);
        return oVarC;
    }

    public final void f(o sink, int i4) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (!sink.f3351e) {
            throw new IllegalStateException("only owner can write");
        }
        int i5 = sink.f3349c;
        if (i5 + i4 > 8192) {
            if (sink.f3350d) {
                throw new IllegalArgumentException();
            }
            int i6 = sink.f3348b;
            if ((i5 + i4) - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f3347a;
            AbstractC0763j.f(bArr, bArr, 0, i6, i5, 2, null);
            sink.f3349c -= sink.f3348b;
            sink.f3348b = 0;
        }
        byte[] bArr2 = this.f3347a;
        byte[] bArr3 = sink.f3347a;
        int i7 = sink.f3349c;
        int i8 = this.f3348b;
        AbstractC0763j.d(bArr2, bArr3, i7, i8, i8 + i4);
        sink.f3349c += i4;
        this.f3348b += i4;
    }

    public o(byte[] data, int i4, int i5, boolean z4, boolean z5) {
        kotlin.jvm.internal.r.f(data, "data");
        this.f3347a = data;
        this.f3348b = i4;
        this.f3349c = i5;
        this.f3350d = z4;
        this.f3351e = z5;
    }
}
