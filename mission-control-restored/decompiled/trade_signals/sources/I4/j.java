package I4;

import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f4278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4280c;

    public j(i iVar, int i8, String str) {
        this.f4278a = iVar;
        this.f4279b = i8;
        this.f4280c = str;
    }

    public static j a(String str) throws ProtocolException {
        i iVar;
        int i8;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i8 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                iVar = i.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                iVar = i.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            iVar = i.HTTP_1_0;
            i8 = 4;
        }
        int i9 = i8 + 3;
        if (str.length() < i9) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i10 = Integer.parseInt(str.substring(i8, i9));
            if (str.length() <= i9) {
                strSubstring = "";
            } else {
                if (str.charAt(i9) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i8 + 4);
            }
            return new j(iVar, i10, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4278a == i.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4279b);
        if (this.f4280c != null) {
            sb.append(' ');
            sb.append(this.f4280c);
        }
        return sb.toString();
    }
}
