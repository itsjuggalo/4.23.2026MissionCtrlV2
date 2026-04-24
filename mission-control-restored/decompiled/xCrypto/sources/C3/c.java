package C3;

import y3.F;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f268a = new F("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f269b = new F("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z4) {
        return new b(z4);
    }

    public static /* synthetic */ a b(boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        return a(z4);
    }
}
