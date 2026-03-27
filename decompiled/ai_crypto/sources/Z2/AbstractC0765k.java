package Z2;

import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: Z2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0765k {
    public static AbstractC0759h a(String str, String str2) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        return new C0763j(str, str2);
    }

    public static AbstractC0759h b(String str, String str2) {
        if (C0763j.E(str2)) {
            return new C0763j(str, null, str2, null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
