package q3;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: q3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2631a {

    /* JADX INFO: renamed from: q3.a$a, reason: collision with other inner class name */
    public static class C0382a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22545b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f22544a = new ArrayList();

        @Override // q3.AbstractC2631a.b
        public boolean a(byte[] bArr) {
            this.f22544a.add(bArr);
            this.f22545b += bArr.length;
            return true;
        }

        @Override // q3.AbstractC2631a.b
        public g b() {
            byte[] bArr = new byte[this.f22545b];
            int length = 0;
            for (int i8 = 0; i8 < this.f22544a.size(); i8++) {
                byte[] bArr2 = (byte[]) this.f22544a.get(i8);
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return new g(bArr);
        }
    }

    /* JADX INFO: renamed from: q3.a$b */
    public interface b {
        boolean a(byte[] bArr);

        g b();
    }

    /* JADX INFO: renamed from: q3.a$c */
    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static ThreadLocal f22546c = new C0383a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static ThreadLocal f22547d = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f22548a = new StringBuilder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBuffer f22549b;

        /* JADX INFO: renamed from: q3.a$c$a, reason: collision with other inner class name */
        public class C0383a extends ThreadLocal {
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharsetDecoder initialValue() {
                CharsetDecoder charsetDecoderNewDecoder = Charset.forName("UTF8").newDecoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                charsetDecoderNewDecoder.onMalformedInput(codingErrorAction);
                charsetDecoderNewDecoder.onUnmappableCharacter(codingErrorAction);
                return charsetDecoderNewDecoder;
            }
        }

        /* JADX INFO: renamed from: q3.a$c$b */
        public class b extends ThreadLocal {
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharsetEncoder initialValue() {
                CharsetEncoder charsetEncoderNewEncoder = Charset.forName("UTF8").newEncoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                charsetEncoderNewEncoder.onMalformedInput(codingErrorAction);
                charsetEncoderNewEncoder.onUnmappableCharacter(codingErrorAction);
                return charsetEncoderNewEncoder;
            }
        }

        @Override // q3.AbstractC2631a.b
        public boolean a(byte[] bArr) {
            String strC = c(bArr);
            if (strC == null) {
                return false;
            }
            this.f22548a.append(strC);
            return true;
        }

        @Override // q3.AbstractC2631a.b
        public g b() {
            if (this.f22549b != null) {
                return null;
            }
            return new g(this.f22548a.toString());
        }

        public final String c(byte[] bArr) {
            try {
                return ((CharsetDecoder) f22546c.get()).decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                return null;
            }
        }
    }

    public static b a(byte b8) {
        return b8 == 2 ? new C0382a() : new c();
    }
}
