package F4;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: F4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0498l extends InterfaceC0500n, InterfaceC0506u {

    /* JADX INFO: renamed from: F4.l$a */
    public static final class a implements InterfaceC0498l {
        @Override // F4.InterfaceC0500n, F4.InterfaceC0506u
        public String a() {
            return "gzip";
        }

        @Override // F4.InterfaceC0506u
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // F4.InterfaceC0500n
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    /* JADX INFO: renamed from: F4.l$b */
    public static final class b implements InterfaceC0498l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0498l f1851a = new b();

        @Override // F4.InterfaceC0500n, F4.InterfaceC0506u
        public String a() {
            return "identity";
        }

        @Override // F4.InterfaceC0506u
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // F4.InterfaceC0500n
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
