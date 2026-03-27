package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class W implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f6962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f6964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6965d;

    public W(J j4, String str, Object[] objArr) {
        this.f6962a = j4;
        this.f6963b = str;
        this.f6964c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f6965d = cCharAt;
            return;
        }
        int i4 = cCharAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.f6965d = i4 | (cCharAt2 << i5);
                return;
            } else {
                i4 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public boolean a() {
        return (this.f6965d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public J b() {
        return this.f6962a;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public T c() {
        int i4 = this.f6965d;
        return (i4 & 1) != 0 ? T.PROTO2 : (i4 & 4) == 4 ? T.EDITIONS : T.PROTO3;
    }

    public Object[] d() {
        return this.f6964c;
    }

    public String e() {
        return this.f6963b;
    }
}
