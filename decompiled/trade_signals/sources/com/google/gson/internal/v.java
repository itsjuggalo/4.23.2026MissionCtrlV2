package com.google.gson.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16223a = a();

    public static int a() {
        return e(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i8 = 0; i8 < str.length(); i8++) {
                char cCharAt = str.charAt(i8);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c() {
        return f16223a >= 9;
    }

    public static int d(String str) {
        try {
            String[] strArrSplit = str.split("[._]", 3);
            int i8 = Integer.parseInt(strArrSplit[0]);
            return (i8 != 1 || strArrSplit.length <= 1) ? i8 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int e(String str) {
        int iD = d(str);
        if (iD == -1) {
            iD = b(str);
        }
        if (iD == -1) {
            return 6;
        }
        return iD;
    }
}
