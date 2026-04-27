package k6;

import g6.F;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f18226a = new F("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f18227b = new F("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z7) {
        return new b(z7);
    }

    public static /* synthetic */ a b(boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }
}
