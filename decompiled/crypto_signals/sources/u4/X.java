package u4;

import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class X extends W {
    public final Y e;

    public X(String str, boolean z6, Y y) {
        super(y, str, z6);
        if (str.endsWith("-bin")) {
            throw new IllegalArgumentException(u0.A("ASCII header is named %s.  Only binary headers may end with %s", str, "-bin"));
        }
        this.e = y;
    }

    @Override // u4.W
    public final Object a(byte[] bArr) {
        return this.e.d(bArr);
    }

    @Override // u4.W
    public final byte[] b(Object obj) {
        byte[] bArrMo4a = this.e.mo4a(obj);
        s3.D.j(bArrMo4a, "null marshaller.toAsciiString()");
        return bArrMo4a;
    }
}
