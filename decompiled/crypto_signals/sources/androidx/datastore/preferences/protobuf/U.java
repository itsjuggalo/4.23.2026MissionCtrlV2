package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0339v f4515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f4517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4518d;

    public U(AbstractC0339v abstractC0339v, String str, Object[] objArr) {
        this.f4515a = abstractC0339v;
        this.f4516b = str;
        this.f4517c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f4518d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i6 = 1;
        int i7 = 13;
        while (true) {
            int i8 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.f4518d = i | (cCharAt2 << i7);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i7;
                i7 += 13;
                i6 = i8;
            }
        }
    }

    public final int a() {
        int i = this.f4518d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
