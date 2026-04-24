package O2;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b7 : bArr) {
            int i7 = b7 & 255;
            sb.append("0123456789abcdef".charAt(i7 / 16));
            sb.append("0123456789abcdef".charAt(i7 % 16));
        }
        return sb.toString();
    }
}
