package r3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import c4.l;
import com.bumptech.glide.load.ImageHeaderParser;
import g3.j;
import i3.v;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f19287b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimatedImageDrawable f19288a;

        public a(AnimatedImageDrawable animatedImageDrawable) {
            this.f19288a = animatedImageDrawable;
        }

        @Override // i3.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f19288a;
        }

        @Override // i3.v
        public void b() {
            this.f19288a.stop();
            this.f19288a.clearAnimationCallbacks();
        }

        @Override // i3.v
        public int c() {
            return this.f19288a.getIntrinsicWidth() * this.f19288a.getIntrinsicHeight() * l.i(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // i3.v
        public Class d() {
            return Drawable.class;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19289a;

        public b(c cVar) {
            this.f19289a = cVar;
        }

        @Override // g3.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v a(ByteBuffer byteBuffer, int i10, int i11, g3.h hVar) {
            return this.f19289a.b(ImageDecoder.createSource(byteBuffer), i10, i11, hVar);
        }

        @Override // g3.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(ByteBuffer byteBuffer, g3.h hVar) {
            return this.f19289a.d(byteBuffer);
        }
    }

    /* JADX INFO: renamed from: r3.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0335c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19290a;

        public C0335c(c cVar) {
            this.f19290a = cVar;
        }

        @Override // g3.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v a(InputStream inputStream, int i10, int i11, g3.h hVar) {
            return this.f19290a.b(ImageDecoder.createSource(c4.a.b(inputStream)), i10, i11, hVar);
        }

        @Override // g3.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(InputStream inputStream, g3.h hVar) {
            return this.f19290a.c(inputStream);
        }
    }

    public c(List list, j3.b bVar) {
        this.f19286a = list;
        this.f19287b = bVar;
    }

    public static j a(List list, j3.b bVar) {
        return new b(new c(list, bVar));
    }

    public static j f(List list, j3.b bVar) {
        return new C0335c(new c(list, bVar));
    }

    public v b(ImageDecoder.Source source, int i10, int i11, g3.h hVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new o3.c(i10, i11, hVar));
        if (r3.a.a(drawableDecodeDrawable)) {
            return new a(r3.b.a(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.f19286a, inputStream, this.f19287b));
    }

    public boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.f19286a, byteBuffer));
    }

    public final boolean e(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }
}
