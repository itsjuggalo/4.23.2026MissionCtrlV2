package h7;

import d7.D;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f18726a = new D("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f18727b = new D("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z7) {
        return new f(z7);
    }

    public static /* synthetic */ a b(boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }
}
