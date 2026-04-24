package X0;

/* JADX INFO: loaded from: classes.dex */
public final class f implements a {
    @Override // X0.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // X0.a
    public int b() {
        return 1;
    }

    @Override // X0.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(byte[] bArr) {
        return bArr.length;
    }

    @Override // X0.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i8) {
        return new byte[i8];
    }
}
