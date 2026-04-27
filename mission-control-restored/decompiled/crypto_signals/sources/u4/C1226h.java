package u4;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import w4.C1324c1;
import w4.C1374t1;
import x4.C1412h;

/* JADX INFO: renamed from: u4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1226h implements InterfaceC1227i, Y, h0, V {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1226h f10411b = new C1226h(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f10412c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10413a;

    public /* synthetic */ C1226h(int i) {
        this.f10413a = i;
    }

    @Override // u4.V
    public String a(Object obj) {
        return (String) obj;
    }

    @Override // u4.InterfaceC1227i
    public InputStream b(C1374t1 c1374t1) {
        switch (this.f10413a) {
            case 0:
                return c1374t1;
            default:
                return new GZIPInputStream(c1374t1);
        }
    }

    @Override // u4.InterfaceC1227i
    public OutputStream c(C1324c1 c1324c1) {
        switch (this.f10413a) {
            case 0:
                return c1324c1;
            default:
                return new GZIPOutputStream(c1324c1);
        }
    }

    @Override // u4.Y
    public Object d(byte[] bArr) {
        int i;
        byte b3;
        switch (this.f10413a) {
            case 1:
                for (int i6 = 0; i6 < bArr.length; i6++) {
                    byte b6 = bArr[i6];
                    if (b6 < 32 || b6 >= 126 || (b6 == 37 && i6 + 2 < bArr.length)) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
                        int i7 = 0;
                        while (i7 < bArr.length) {
                            if (bArr[i7] == 37 && i7 + 2 < bArr.length) {
                                try {
                                    byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i7 + 1, 2, U1.d.f3106a), 16));
                                    i7 += 3;
                                } catch (NumberFormatException unused) {
                                    byteBufferAllocate.put(bArr[i7]);
                                    i7++;
                                }
                            }
                            byteBufferAllocate.put(bArr[i7]);
                            i7++;
                        }
                        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), U1.d.f3107b);
                    }
                }
                return new String(bArr, 0);
            default:
                char c6 = 0;
                if (bArr.length == 1 && bArr[0] == 48) {
                    return j0.e;
                }
                int length = bArr.length;
                if (length != 1) {
                    if (length == 2 && (b3 = bArr[0]) >= 48 && b3 <= 57) {
                        i = (b3 - 48) * 10;
                        c6 = 1;
                    }
                    return j0.f10437g.g("Unknown code ".concat(new String(bArr, U1.d.f3106a)));
                }
                i = 0;
                byte b7 = bArr[c6];
                if (b7 >= 48 && b7 <= 57) {
                    int i8 = (b7 - 48) + i;
                    List list = j0.f10435d;
                    if (i8 < list.size()) {
                        return (j0) list.get(i8);
                    }
                }
                return j0.f10437g.g("Unknown code ".concat(new String(bArr, U1.d.f3106a)));
        }
    }

    @Override // u4.h0
    public boolean e(Object obj) {
        switch (this.f10413a) {
            case 6:
                ((N) obj).getClass();
                break;
            case 7:
                ((Q) obj).getClass();
                break;
            default:
                ((e0) obj).getClass();
                break;
        }
        return true;
    }

    @Override // u4.h0
    public int f(Object obj) {
        switch (this.f10413a) {
            case 6:
                ((N) obj).getClass();
                break;
            case 7:
                ((C1412h) ((Q) obj)).getClass();
                try {
                    Class.forName("android.app.Application", false, C1412h.class.getClassLoader());
                }
                break;
            default:
                ((e0) obj).getClass();
                break;
        }
        return 5;
    }

    @Override // u4.InterfaceC1227i
    public String g() {
        switch (this.f10413a) {
            case 0:
                return "identity";
            default:
                return "gzip";
        }
    }

    public String toString() {
        switch (this.f10413a) {
            case 5:
                return "internal:health-check-consumer-listener";
            default:
                return super.toString();
        }
    }

    public C1226h(SSLSession sSLSession) {
        this.f10413a = 4;
        sSLSession.getCipherSuite();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            Certificate certificate = localCertificates[0];
        }
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates != null) {
                Certificate certificate2 = peerCertificates[0];
            }
        } catch (SSLPeerUnverifiedException e) {
            C1218A.f10331d.log(Level.FINE, "Peer cert not available for peerHost=" + sSLSession.getPeerHost(), (Throwable) e);
        }
    }

    @Override // u4.Y
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo4a(Object obj) {
        switch (this.f10413a) {
            case 1:
                byte[] bytes = ((String) obj).getBytes(U1.d.f3107b);
                int i = 0;
                while (i < bytes.length) {
                    byte b3 = bytes[i];
                    if (b3 < 32 || b3 >= 126 || b3 == 37) {
                        byte[] bArr = new byte[((bytes.length - i) * 3) + i];
                        if (i != 0) {
                            System.arraycopy(bytes, 0, bArr, 0, i);
                        }
                        int i6 = i;
                        while (i < bytes.length) {
                            byte b6 = bytes[i];
                            if (b6 < 32 || b6 >= 126 || b6 == 37) {
                                bArr[i6] = 37;
                                byte[] bArr2 = f10412c;
                                bArr[i6 + 1] = bArr2[(b6 >> 4) & 15];
                                bArr[i6 + 2] = bArr2[b6 & 15];
                                i6 += 3;
                            } else {
                                bArr[i6] = b6;
                                i6++;
                            }
                            i++;
                        }
                        return Arrays.copyOf(bArr, i6);
                    }
                    i++;
                }
                return bytes;
            default:
                return ((j0) obj).f10446a.f10432b;
        }
    }

    @Override // u4.V
    public Object h(String str) {
        return str;
    }
}
