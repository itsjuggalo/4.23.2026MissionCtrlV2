package X0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements a {
    @Override // X0.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // X0.a
    public int b() {
        return 4;
    }

    @Override // X0.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(int[] iArr) {
        return iArr.length;
    }

    @Override // X0.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i8) {
        return new int[i8];
    }
}
