package k3;

import java.util.Random;

/* JADX INFO: renamed from: k3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2276j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f20376a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f20377b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f20378c = new int[12];

    public static final String a(String str) {
        AbstractC2280n.g(str);
        Integer numK = AbstractC2279m.k(str);
        if (numK != null) {
            return numK.intValue() == Integer.MIN_VALUE ? "[MIN_NAME]" : String.valueOf(numK.intValue() - 1);
        }
        StringBuilder sb = new StringBuilder(str);
        if (sb.charAt(sb.length() - 1) == '-') {
            return sb.length() == 1 ? String.valueOf(Integer.MAX_VALUE) : sb.substring(0, sb.length() - 1);
        }
        sb.setCharAt(sb.length() - 1, "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".indexOf(sb.charAt(sb.length() - 1)) - 1));
        sb.append(new String(new char[786 - sb.length()]).replace("\u0000", "z"));
        return sb.toString();
    }

    public static final String b(String str) {
        AbstractC2280n.g(str);
        Integer numK = AbstractC2279m.k(str);
        if (numK != null) {
            return numK.intValue() == Integer.MAX_VALUE ? String.valueOf('-') : String.valueOf(numK.intValue() + 1);
        }
        StringBuilder sb = new StringBuilder(str);
        if (sb.length() < 786) {
            sb.append('-');
            return sb.toString();
        }
        int length = sb.length() - 1;
        while (length >= 0 && sb.charAt(length) == 'z') {
            length--;
        }
        if (length == -1) {
            return "[MAX_KEY]";
        }
        int i8 = length + 1;
        sb.replace(length, i8, String.valueOf("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".indexOf(sb.charAt(length)) + 1)));
        return sb.substring(0, i8);
    }
}
