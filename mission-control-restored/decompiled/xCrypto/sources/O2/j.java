package O2;

import java.net.ProtocolException;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f3292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3294c;

    public j(i iVar, int i4, String str) {
        this.f3292a = iVar;
        this.f3293b = i4;
        this.f3294c = str;
    }

    public static j a(String str) throws ProtocolException {
        i iVar;
        int i4;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i4 = 9;
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
            i4 = 4;
        }
        int i5 = i4 + 3;
        if (str.length() < i5) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i6 = Integer.parseInt(str.substring(i4, i5));
            if (str.length() <= i5) {
                strSubstring = "";
            } else {
                if (str.charAt(i5) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i4 + 4);
            }
            return new j(iVar, i6, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3292a == i.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f3293b);
        if (this.f3294c != null) {
            sb.append(' ');
            sb.append(this.f3294c);
        }
        return sb.toString();
    }
}
