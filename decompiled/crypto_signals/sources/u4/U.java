package u4;

import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class U extends W {
    public final V e;

    public U(String str, V v2) {
        super(v2, str, false);
        if (str.endsWith("-bin")) {
            throw new IllegalArgumentException(u0.A("ASCII header is named %s.  Only binary headers may end with %s", str, "-bin"));
        }
        s3.D.j(v2, "marshaller");
        this.e = v2;
    }

    @Override // u4.W
    public final Object a(byte[] bArr) {
        return this.e.h(new String(bArr, U1.d.f3106a));
    }

    @Override // u4.W
    public final byte[] b(Object obj) {
        String strA = this.e.a(obj);
        s3.D.j(strA, "null marshaller.toAsciiString()");
        return strA.getBytes(U1.d.f3106a);
    }
}
