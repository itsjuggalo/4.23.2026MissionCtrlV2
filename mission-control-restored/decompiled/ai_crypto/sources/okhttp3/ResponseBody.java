package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import w6.C2792e;
import w6.InterfaceC2794g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {

    public static final class BomAwareReader extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2794g f20654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Charset f20655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Reader f20657d;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f20656c = true;
            Reader reader = this.f20657d;
            if (reader != null) {
                reader.close();
            } else {
                this.f20654a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) throws IOException {
            if (this.f20656c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f20657d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f20654a.v0(), Util.c(this.f20654a, this.f20655b));
                this.f20657d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i7, i8);
        }
    }

    public static ResponseBody A(MediaType mediaType, byte[] bArr) {
        return i(mediaType, bArr.length, new C2792e().a0(bArr));
    }

    public static ResponseBody i(final MediaType mediaType, final long j7, final InterfaceC2794g interfaceC2794g) {
        if (interfaceC2794g != null) {
            return new ResponseBody() { // from class: okhttp3.ResponseBody.1
                @Override // okhttp3.ResponseBody
                public InterfaceC2794g G() {
                    return interfaceC2794g;
                }

                @Override // okhttp3.ResponseBody
                public long h() {
                    return j7;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public abstract InterfaceC2794g G();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.f(G());
    }

    public abstract long h();
}
