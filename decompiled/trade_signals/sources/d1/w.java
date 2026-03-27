package d1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import q1.AbstractC2618a;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public interface w {

    public static final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.data.k f16829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final X0.b f16830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f16831c;

        public b(InputStream inputStream, List list, X0.b bVar) {
            this.f16830b = (X0.b) AbstractC2628k.d(bVar);
            this.f16831c = (List) AbstractC2628k.d(list);
            this.f16829a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // d1.w
        public int a() {
            return com.bumptech.glide.load.a.b(this.f16831c, this.f16829a.a(), this.f16830b);
        }

        @Override // d1.w
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f16829a.a(), null, options);
        }

        @Override // d1.w
        public void c() {
            this.f16829a.c();
        }

        @Override // d1.w
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.f(this.f16831c, this.f16829a.a(), this.f16830b);
        }
    }

    int a();

    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f16827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final X0.b f16828c;

        public a(ByteBuffer byteBuffer, List list, X0.b bVar) {
            this.f16826a = byteBuffer;
            this.f16827b = list;
            this.f16828c = bVar;
        }

        @Override // d1.w
        public int a() {
            return com.bumptech.glide.load.a.c(this.f16827b, AbstractC2618a.d(this.f16826a), this.f16828c);
        }

        @Override // d1.w
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // d1.w
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.g(this.f16827b, AbstractC2618a.d(this.f16826a));
        }

        public final InputStream e() {
            return AbstractC2618a.g(AbstractC2618a.d(this.f16826a));
        }

        @Override // d1.w
        public void c() {
        }
    }

    public static final class c implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X0.b f16832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f16833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f16834c;

        public c(ParcelFileDescriptor parcelFileDescriptor, List list, X0.b bVar) {
            this.f16832a = (X0.b) AbstractC2628k.d(bVar);
            this.f16833b = (List) AbstractC2628k.d(list);
            this.f16834c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // d1.w
        public int a() {
            return com.bumptech.glide.load.a.a(this.f16833b, this.f16834c, this.f16832a);
        }

        @Override // d1.w
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f16834c.a().getFileDescriptor(), null, options);
        }

        @Override // d1.w
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.f16833b, this.f16834c, this.f16832a);
        }

        @Override // d1.w
        public void c() {
        }
    }
}
