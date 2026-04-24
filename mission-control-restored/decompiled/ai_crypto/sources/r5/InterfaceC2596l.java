package r5;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: r5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2596l extends InterfaceC2598n, InterfaceC2604u {

    /* JADX INFO: renamed from: r5.l$a */
    public static final class a implements InterfaceC2596l {
        @Override // r5.InterfaceC2598n, r5.InterfaceC2604u
        public String a() {
            return "gzip";
        }

        @Override // r5.InterfaceC2604u
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // r5.InterfaceC2598n
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    /* JADX INFO: renamed from: r5.l$b */
    public static final class b implements InterfaceC2596l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC2596l f22703a = new b();

        @Override // r5.InterfaceC2598n, r5.InterfaceC2604u
        public String a() {
            return "identity";
        }

        @Override // r5.InterfaceC2604u
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // r5.InterfaceC2598n
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
