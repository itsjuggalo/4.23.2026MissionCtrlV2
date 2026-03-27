package L3;

import W2.C0739g;

/* JADX INFO: renamed from: L3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0402z extends I3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0378a f1547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M3.e f1548b;

    public C0402z(AbstractC0378a lexer, K3.a json) {
        kotlin.jvm.internal.r.f(lexer, "lexer");
        kotlin.jvm.internal.r.f(json, "json");
        this.f1547a = lexer;
        this.f1548b = json.a();
    }

    @Override // I3.a, I3.e
    public byte C() {
        AbstractC0378a abstractC0378a = this.f1547a;
        String strS = abstractC0378a.s();
        try {
            return r3.H.a(strS);
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'UByte' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }

    @Override // I3.a, I3.e
    public short F() {
        AbstractC0378a abstractC0378a = this.f1547a;
        String strS = abstractC0378a.s();
        try {
            return r3.H.j(strS);
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'UShort' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }

    @Override // I3.c
    public M3.e a() {
        return this.f1548b;
    }

    @Override // I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // I3.a, I3.e
    public int l() {
        AbstractC0378a abstractC0378a = this.f1547a;
        String strS = abstractC0378a.s();
        try {
            return r3.H.d(strS);
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'UInt' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }

    @Override // I3.a, I3.e
    public long r() {
        AbstractC0378a abstractC0378a = this.f1547a;
        String strS = abstractC0378a.s();
        try {
            return r3.H.g(strS);
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'ULong' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }
}
