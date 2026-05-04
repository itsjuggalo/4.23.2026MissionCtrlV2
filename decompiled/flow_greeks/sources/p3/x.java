package p3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface x {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.data.k f18292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j3.b f18293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f18294c;

        public b(InputStream inputStream, List list, j3.b bVar) {
            this.f18293b = (j3.b) c4.k.e(bVar);
            this.f18294c = (List) c4.k.e(list);
            this.f18292a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // p3.x
        public int a() {
            return com.bumptech.glide.load.a.b(this.f18294c, this.f18292a.a(), this.f18293b);
        }

        @Override // p3.x
        public Bitmap b(BitmapFactory.Options options) {
            return u.b(this.f18292a.a(), options, this);
        }

        @Override // p3.x
        public boolean c() {
            return com.bumptech.glide.load.a.j(this.f18294c, this.f18292a.a(), this.f18293b);
        }

        @Override // p3.x
        public void d() {
            this.f18292a.c();
        }

        @Override // p3.x
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.f(this.f18294c, this.f18292a.a(), this.f18293b);
        }
    }

    int a();

    Bitmap b(BitmapFactory.Options options);

    boolean c();

    void d();

    ImageHeaderParser.ImageType e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f18289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f18290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j3.b f18291c;

        public a(ByteBuffer byteBuffer, List list, j3.b bVar) {
            this.f18289a = byteBuffer;
            this.f18290b = list;
            this.f18291c = bVar;
        }

        @Override // p3.x
        public int a() {
            return com.bumptech.glide.load.a.c(this.f18290b, c4.a.d(this.f18289a), this.f18291c);
        }

        @Override // p3.x
        public Bitmap b(BitmapFactory.Options options) {
            return u.b(f(), options, this);
        }

        @Override // p3.x
        public boolean c() {
            return com.bumptech.glide.load.a.k(this.f18290b, c4.a.d(this.f18289a), this.f18291c);
        }

        @Override // p3.x
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.g(this.f18290b, c4.a.d(this.f18289a));
        }

        public final InputStream f() {
            return c4.a.g(c4.a.d(this.f18289a));
        }

        @Override // p3.x
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3.b f18295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f18296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f18297c;

        public c(ParcelFileDescriptor parcelFileDescriptor, List list, j3.b bVar) {
            this.f18295a = (j3.b) c4.k.e(bVar);
            this.f18296b = (List) c4.k.e(list);
            this.f18297c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // p3.x
        public int a() {
            return com.bumptech.glide.load.a.a(this.f18296b, this.f18297c, this.f18295a);
        }

        @Override // p3.x
        public Bitmap b(BitmapFactory.Options options) {
            return u.a(this.f18297c.a().getFileDescriptor(), options, this);
        }

        @Override // p3.x
        public boolean c() {
            return com.bumptech.glide.load.a.i(this.f18296b, this.f18297c, this.f18295a);
        }

        @Override // p3.x
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.e(this.f18296b, this.f18297c, this.f18295a);
        }

        @Override // p3.x
        public void d() {
        }
    }
}
