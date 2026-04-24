package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import okhttp3.internal.Util;
import u5.C1250g;
import u5.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {

    public static final class BomAwareReader extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i, int i6) throws IOException {
            throw new IOException("Stream closed");
        }
    }

    public static ResponseBody d(byte[] bArr) {
        C1250g c1250g = new C1250g();
        c1250g.y(bArr);
        return new ResponseBody(bArr.length, c1250g) { // from class: okhttp3.ResponseBody.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C1250g f8818a;

            {
                this.f8818a = c1250g;
            }

            @Override // okhttp3.ResponseBody
            public final i f() {
                return this.f8818a;
            }
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Util.b(f());
    }

    public abstract i f();
}
