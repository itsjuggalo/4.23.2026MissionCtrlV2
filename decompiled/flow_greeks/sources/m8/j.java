package m8;

import com.google.android.gms.common.api.a;
import java.util.Random;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f16101a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f16102b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f16103c = new int[12];

    public static final String a(String str) {
        n.g(str);
        Integer numK = m.k(str);
        if (numK != null) {
            return numK.intValue() == Integer.MIN_VALUE ? "[MIN_NAME]" : String.valueOf(numK.intValue() - 1);
        }
        StringBuilder sb2 = new StringBuilder(str);
        if (sb2.charAt(sb2.length() - 1) == '-') {
            return sb2.length() == 1 ? String.valueOf(a.e.API_PRIORITY_OTHER) : sb2.substring(0, sb2.length() - 1);
        }
        sb2.setCharAt(sb2.length() - 1, "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".indexOf(sb2.charAt(sb2.length() - 1)) - 1));
        sb2.append(new String(new char[786 - sb2.length()]).replace(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, "z"));
        return sb2.toString();
    }

    public static final String b(String str) {
        n.g(str);
        Integer numK = m.k(str);
        if (numK != null) {
            return numK.intValue() == Integer.MAX_VALUE ? String.valueOf('-') : String.valueOf(numK.intValue() + 1);
        }
        StringBuilder sb2 = new StringBuilder(str);
        if (sb2.length() < 786) {
            sb2.append('-');
            return sb2.toString();
        }
        int length = sb2.length() - 1;
        while (length >= 0 && sb2.charAt(length) == 'z') {
            length--;
        }
        if (length == -1) {
            return "[MAX_KEY]";
        }
        int i10 = length + 1;
        sb2.replace(length, i10, String.valueOf("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".indexOf(sb2.charAt(length)) + 1)));
        return sb2.substring(0, i10);
    }
}
