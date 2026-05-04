package vb;

import com.revenuecat.purchases.common.Constants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static String a(String str, String str2) {
        try {
            return "Basic " + hh.g.u((str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2).getBytes("ISO-8859-1")).a();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
