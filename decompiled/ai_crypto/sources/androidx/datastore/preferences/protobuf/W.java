package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class W implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f7370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7373d;

    public W(J j7, String str, Object[] objArr) {
        this.f7370a = j7;
        this.f7371b = str;
        this.f7372c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f7373d = cCharAt;
            return;
        }
        int i7 = cCharAt & 8191;
        int i8 = 13;
        int i9 = 1;
        while (true) {
            int i10 = i9 + 1;
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 55296) {
                this.f7373d = i7 | (cCharAt2 << i8);
                return;
            } else {
                i7 |= (cCharAt2 & 8191) << i8;
                i8 += 13;
                i9 = i10;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public boolean a() {
        return (this.f7373d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public J b() {
        return this.f7370a;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public T c() {
        int i7 = this.f7373d;
        return (i7 & 1) != 0 ? T.PROTO2 : (i7 & 4) == 4 ? T.EDITIONS : T.PROTO3;
    }

    public Object[] d() {
        return this.f7372c;
    }

    public String e() {
        return this.f7371b;
    }
}
