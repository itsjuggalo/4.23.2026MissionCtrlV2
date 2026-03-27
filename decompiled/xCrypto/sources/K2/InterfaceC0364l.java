package K2;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: K2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0364l extends InterfaceC0366n, InterfaceC0372u {

    /* JADX INFO: renamed from: K2.l$a */
    public static final class a implements InterfaceC0364l {
        @Override // K2.InterfaceC0366n, K2.InterfaceC0372u
        public String a() {
            return "gzip";
        }

        @Override // K2.InterfaceC0372u
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // K2.InterfaceC0366n
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    /* JADX INFO: renamed from: K2.l$b */
    public static final class b implements InterfaceC0364l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0364l f1213a = new b();

        @Override // K2.InterfaceC0366n, K2.InterfaceC0372u
        public String a() {
            return "identity";
        }

        @Override // K2.InterfaceC0372u
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // K2.InterfaceC0366n
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
