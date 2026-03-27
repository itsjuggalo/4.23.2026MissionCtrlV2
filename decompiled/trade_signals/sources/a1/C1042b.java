package a1;

import a1.n;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p1.C2543b;

/* JADX INFO: renamed from: a1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1042b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0166b f9810a;

    /* JADX INFO: renamed from: a1.b$a */
    public static class a implements o {

        /* JADX INFO: renamed from: a1.b$a$a, reason: collision with other inner class name */
        public class C0165a implements InterfaceC0166b {
            public C0165a() {
            }

            @Override // a1.C1042b.InterfaceC0166b
            public Class a() {
                return ByteBuffer.class;
            }

            @Override // a1.C1042b.InterfaceC0166b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1042b(new C0165a());
        }
    }

    /* JADX INFO: renamed from: a1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0166b {
        Class a();

        Object b(byte[] bArr);
    }

    /* JADX INFO: renamed from: a1.b$d */
    public static class d implements o {

        /* JADX INFO: renamed from: a1.b$d$a */
        public class a implements InterfaceC0166b {
            public a() {
            }

            @Override // a1.C1042b.InterfaceC0166b
            public Class a() {
                return InputStream.class;
            }

            @Override // a1.C1042b.InterfaceC0166b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1042b(new a());
        }
    }

    public C1042b(InterfaceC0166b interfaceC0166b) {
        this.f9810a = interfaceC0166b;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(byte[] bArr, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(bArr), new c(bArr, this.f9810a));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(byte[] bArr) {
        return true;
    }

    /* JADX INFO: renamed from: a1.b$c */
    public static class c implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f9812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0166b f9813b;

        public c(byte[] bArr, InterfaceC0166b interfaceC0166b) {
            this.f9812a = bArr;
            this.f9813b = interfaceC0166b;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f9813b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            aVar.f(this.f9813b.b(this.f9812a));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
