package v5;

import com.revenuecat.purchases.common.Constants;
import java.io.UnsupportedEncodingException;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static String a(String str, String str2) {
        try {
            return "Basic " + C2795h.A((str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2).getBytes("ISO-8859-1")).a();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
