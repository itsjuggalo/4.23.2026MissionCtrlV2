package u4;

import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import s3.AbstractC1024h;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public abstract class W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BitSet f10367d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10370c;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c6 = '0'; c6 <= '9'; c6 = (char) (c6 + 1)) {
            bitSet.set(c6);
        }
        for (char c7 = 'a'; c7 <= 'z'; c7 = (char) (c7 + 1)) {
            bitSet.set(c7);
        }
        f10367d = bitSet;
    }

    public W(Object obj, String str, boolean z6) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        s3.D.j(lowerCase, "name");
        s3.D.f("token must have at least 1 tchar", !lowerCase.isEmpty());
        if (lowerCase.equals("connection")) {
            Z.f10371c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        for (int i = 0; i < lowerCase.length(); i++) {
            char cCharAt = lowerCase.charAt(i);
            if ((!z6 || cCharAt != ':' || i != 0) && !f10367d.get(cCharAt)) {
                throw new IllegalArgumentException(u0.A("Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), lowerCase));
            }
        }
        this.f10368a = lowerCase;
        this.f10369b = lowerCase.getBytes(U1.d.f3106a);
        this.f10370c = obj;
    }

    public abstract Object a(byte[] bArr);

    public abstract byte[] b(Object obj);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10368a.equals(((W) obj).f10368a);
    }

    public final int hashCode() {
        return this.f10368a.hashCode();
    }

    public final String toString() {
        return AbstractC1024h.d(new StringBuilder("Key{name='"), this.f10368a, "'}");
    }
}
