package g2;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            int i4 = b4 & 255;
            sb.append("0123456789abcdef".charAt(i4 / 16));
            sb.append("0123456789abcdef".charAt(i4 % 16));
        }
        return sb.toString();
    }
}
