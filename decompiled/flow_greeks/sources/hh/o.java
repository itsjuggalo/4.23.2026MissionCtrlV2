package hh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f11494h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f11500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f11501g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public o() {
        this.f11495a = new byte[8192];
        this.f11499e = true;
        this.f11498d = false;
    }

    public final void a() {
        int i10;
        o oVar = this.f11501g;
        if (oVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.t.c(oVar);
        if (oVar.f11499e) {
            int i11 = this.f11497c - this.f11496b;
            o oVar2 = this.f11501g;
            kotlin.jvm.internal.t.c(oVar2);
            int i12 = 8192 - oVar2.f11497c;
            o oVar3 = this.f11501g;
            kotlin.jvm.internal.t.c(oVar3);
            if (oVar3.f11498d) {
                i10 = 0;
            } else {
                o oVar4 = this.f11501g;
                kotlin.jvm.internal.t.c(oVar4);
                i10 = oVar4.f11496b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            o oVar5 = this.f11501g;
            kotlin.jvm.internal.t.c(oVar5);
            f(oVar5, i11);
            b();
            p.b(this);
        }
    }

    public final o b() {
        o oVar = this.f11500f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.f11501g;
        kotlin.jvm.internal.t.c(oVar2);
        oVar2.f11500f = this.f11500f;
        o oVar3 = this.f11500f;
        kotlin.jvm.internal.t.c(oVar3);
        oVar3.f11501g = this.f11501g;
        this.f11500f = null;
        this.f11501g = null;
        return oVar;
    }

    public final o c(o segment) {
        kotlin.jvm.internal.t.f(segment, "segment");
        segment.f11501g = this;
        segment.f11500f = this.f11500f;
        o oVar = this.f11500f;
        kotlin.jvm.internal.t.c(oVar);
        oVar.f11501g = segment;
        this.f11500f = segment;
        return segment;
    }

    public final o d() {
        this.f11498d = true;
        return new o(this.f11495a, this.f11496b, this.f11497c, true, false);
    }

    public final o e(int i10) {
        o oVarC;
        if (i10 <= 0 || i10 > this.f11497c - this.f11496b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i10 >= 1024) {
            oVarC = d();
        } else {
            oVarC = p.c();
            byte[] bArr = this.f11495a;
            byte[] bArr2 = oVarC.f11495a;
            int i11 = this.f11496b;
            dd.l.i(bArr, bArr2, 0, i11, i11 + i10, 2, null);
        }
        oVarC.f11497c = oVarC.f11496b + i10;
        this.f11496b += i10;
        o oVar = this.f11501g;
        kotlin.jvm.internal.t.c(oVar);
        oVar.c(oVarC);
        return oVarC;
    }

    public final void f(o sink, int i10) {
        kotlin.jvm.internal.t.f(sink, "sink");
        if (!sink.f11499e) {
            throw new IllegalStateException("only owner can write");
        }
        int i11 = sink.f11497c;
        if (i11 + i10 > 8192) {
            if (sink.f11498d) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.f11496b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f11495a;
            dd.l.i(bArr, bArr, 0, i12, i11, 2, null);
            sink.f11497c -= sink.f11496b;
            sink.f11496b = 0;
        }
        byte[] bArr2 = this.f11495a;
        byte[] bArr3 = sink.f11495a;
        int i13 = sink.f11497c;
        int i14 = this.f11496b;
        dd.l.e(bArr2, bArr3, i13, i14, i14 + i10);
        sink.f11497c += i10;
        this.f11496b += i10;
    }

    public o(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.f(data, "data");
        this.f11495a = data;
        this.f11496b = i10;
        this.f11497c = i11;
        this.f11498d = z10;
        this.f11499e = z11;
    }
}
