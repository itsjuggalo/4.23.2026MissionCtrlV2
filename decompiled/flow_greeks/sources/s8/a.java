package s8;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: s8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0350a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20062b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f20061a = new ArrayList();

        @Override // s8.a.b
        public boolean a(byte[] bArr) {
            this.f20061a.add(bArr);
            this.f20062b += bArr.length;
            return true;
        }

        @Override // s8.a.b
        public g b() {
            byte[] bArr = new byte[this.f20062b];
            int length = 0;
            for (int i10 = 0; i10 < this.f20061a.size(); i10++) {
                byte[] bArr2 = (byte[]) this.f20061a.get(i10);
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return new g(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        boolean a(byte[] bArr);

        g b();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static ThreadLocal f20063c = new C0351a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static ThreadLocal f20064d = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f20065a = new StringBuilder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBuffer f20066b;

        /* JADX INFO: renamed from: s8.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0351a extends ThreadLocal {
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

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

        @Override // s8.a.b
        public boolean a(byte[] bArr) {
            String strC = c(bArr);
            if (strC == null) {
                return false;
            }
            this.f20065a.append(strC);
            return true;
        }

        @Override // s8.a.b
        public g b() {
            if (this.f20066b != null) {
                return null;
            }
            return new g(this.f20065a.toString());
        }

        public final String c(byte[] bArr) {
            try {
                return ((CharsetDecoder) f20063c.get()).decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                return null;
            }
        }
    }

    public static b a(byte b10) {
        return b10 == 2 ? new C0350a() : new c();
    }
}
