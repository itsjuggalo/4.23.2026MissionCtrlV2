package i2;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: i2.l5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1860l5 {
    public static String a(Context context, String str, String str2) {
        AbstractC1207s.k(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = AbstractC1802e3.a(context);
        }
        return AbstractC1802e3.b("google_app_id", resources, str2);
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        AbstractC1207s.k(strArr);
        AbstractC1207s.k(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i7 = 0; i7 < iMin; i7++) {
            String str2 = strArr[i7];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i7];
            }
        }
        return null;
    }
}
