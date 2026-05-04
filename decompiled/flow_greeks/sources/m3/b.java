package m3;

import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0286b f15748a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements o {

        /* JADX INFO: renamed from: m3.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0285a implements InterfaceC0286b {
            public C0285a() {
            }

            @Override // m3.b.InterfaceC0286b
            public Class a() {
                return ByteBuffer.class;
            }

            @Override // m3.b.InterfaceC0286b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // m3.o
        public n d(r rVar) {
            return new b(new C0285a());
        }
    }

    /* JADX INFO: renamed from: m3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0286b {
        Class a();

        Object b(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements o {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements InterfaceC0286b {
            public a() {
            }

            @Override // m3.b.InterfaceC0286b
            public Class a() {
                return InputStream.class;
            }

            @Override // m3.b.InterfaceC0286b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // m3.o
        public n d(r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0286b interfaceC0286b) {
        this.f15748a = interfaceC0286b;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(byte[] bArr, int i10, int i11, g3.h hVar) {
        return new n.a(new b4.b(bArr), new c(bArr, this.f15748a));
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f15750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0286b f15751b;

        public c(byte[] bArr, InterfaceC0286b interfaceC0286b) {
            this.f15750a = bArr;
            this.f15751b = interfaceC0286b;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f15751b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return g3.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            aVar.f(this.f15751b.b(this.f15750a));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
