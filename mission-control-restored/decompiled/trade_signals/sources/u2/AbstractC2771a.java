package u2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: u2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2771a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f23516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f23517b;

    static {
        HashMap map = new HashMap();
        f23516a = map;
        HashMap map2 = new HashMap();
        f23517b = map2;
        map.put(-1, "The Play Store app is either not installed or not the official version.");
        map.put(-2, "Call first requestReviewFlow to get the ReviewInfo.");
        map.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        map2.put(-1, "PLAY_STORE_NOT_FOUND");
        map2.put(-2, "INVALID_REQUEST");
        map2.put(-100, "INTERNAL_ERROR");
    }

    public static String a(int i8) {
        Map map = f23516a;
        Integer numValueOf = Integer.valueOf(i8);
        if (!map.containsKey(numValueOf)) {
            return "";
        }
        return ((String) map.get(numValueOf)) + " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#" + ((String) f23517b.get(numValueOf)) + ")";
    }
}
