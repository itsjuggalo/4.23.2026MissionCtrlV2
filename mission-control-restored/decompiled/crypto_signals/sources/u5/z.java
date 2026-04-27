package u5;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f10558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10561d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f10562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f10563g;

    public z() {
        this.f10558a = new byte[8192];
        this.e = true;
        this.f10561d = false;
    }

    public final z a() {
        z zVar = this.f10562f;
        if (zVar == this) {
            zVar = null;
        }
        z zVar2 = this.f10563g;
        kotlin.jvm.internal.j.b(zVar2);
        zVar2.f10562f = this.f10562f;
        z zVar3 = this.f10562f;
        kotlin.jvm.internal.j.b(zVar3);
        zVar3.f10563g = this.f10563g;
        this.f10562f = null;
        this.f10563g = null;
        return zVar;
    }

    public final void b(z segment) {
        kotlin.jvm.internal.j.e(segment, "segment");
        segment.f10563g = this;
        segment.f10562f = this.f10562f;
        z zVar = this.f10562f;
        kotlin.jvm.internal.j.b(zVar);
        zVar.f10563g = segment;
        this.f10562f = segment;
    }

    public final z c() {
        this.f10561d = true;
        return new z(this.f10558a, this.f10559b, this.f10560c, true, false);
    }

    public final void d(z sink, int i) {
        kotlin.jvm.internal.j.e(sink, "sink");
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i6 = sink.f10560c;
        int i7 = i6 + i;
        byte[] bArr = sink.f10558a;
        if (i7 > 8192) {
            if (sink.f10561d) {
                throw new IllegalArgumentException();
            }
            int i8 = sink.f10559b;
            if (i7 - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            H4.g.e0(bArr, 0, bArr, i8, i6);
            sink.f10560c -= sink.f10559b;
            sink.f10559b = 0;
        }
        int i9 = sink.f10560c;
        int i10 = this.f10559b;
        H4.g.e0(this.f10558a, i9, bArr, i10, i10 + i);
        sink.f10560c += i;
        this.f10559b += i;
    }

    public z(byte[] data, int i, int i6, boolean z6, boolean z7) {
        kotlin.jvm.internal.j.e(data, "data");
        this.f10558a = data;
        this.f10559b = i;
        this.f10560c = i6;
        this.f10561d = z6;
        this.e = z7;
    }
}
