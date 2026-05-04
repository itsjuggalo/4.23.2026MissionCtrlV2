package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends ch.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gh.e f9654b;

    public x(a lexer, eh.b json) {
        kotlin.jvm.internal.t.f(lexer, "lexer");
        kotlin.jvm.internal.t.f(json, "json");
        this.f9653a = lexer;
        this.f9654b = json.a();
    }

    @Override // ch.a, ch.e
    public byte D() {
        a aVar = this.f9653a;
        String strQ = aVar.q();
        try {
            return kg.j0.a(strQ);
        } catch (IllegalArgumentException unused) {
            a.x(aVar, "Failed to parse type 'UByte' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    @Override // ch.a, ch.e
    public short F() {
        a aVar = this.f9653a;
        String strQ = aVar.q();
        try {
            return kg.j0.j(strQ);
        } catch (IllegalArgumentException unused) {
            a.x(aVar, "Failed to parse type 'UShort' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    @Override // ch.c
    public gh.e a() {
        return this.f9654b;
    }

    @Override // ch.a, ch.e
    public int j() {
        a aVar = this.f9653a;
        String strQ = aVar.q();
        try {
            return kg.j0.d(strQ);
        } catch (IllegalArgumentException unused) {
            a.x(aVar, "Failed to parse type 'UInt' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    @Override // ch.a, ch.e
    public long q() {
        a aVar = this.f9653a;
        String strQ = aVar.q();
        try {
            return kg.j0.g(strQ);
        } catch (IllegalArgumentException unused) {
            a.x(aVar, "Failed to parse type 'ULong' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    @Override // ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }
}
