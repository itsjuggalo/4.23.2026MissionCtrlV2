package m7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static h a(String str, String str2) {
        com.google.android.gms.common.internal.s.e(str);
        com.google.android.gms.common.internal.s.e(str2);
        return new j(str, str2);
    }

    public static h b(String str, String str2) {
        if (j.V(str2)) {
            return new j(str, null, str2, null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
