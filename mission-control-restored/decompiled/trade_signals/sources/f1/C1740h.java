package f1;

import W0.v;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import q1.AbstractC2618a;
import q1.AbstractC2629l;

/* JADX INFO: renamed from: f1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1740h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.b f17377b;

    /* JADX INFO: renamed from: f1.h$a */
    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimatedImageDrawable f17378a;

        public a(AnimatedImageDrawable animatedImageDrawable) {
            this.f17378a = animatedImageDrawable;
        }

        @Override // W0.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f17378a;
        }

        @Override // W0.v
        public void b() {
            this.f17378a.stop();
            this.f17378a.clearAnimationCallbacks();
        }

        @Override // W0.v
        public int c() {
            return this.f17378a.getIntrinsicWidth() * this.f17378a.getIntrinsicHeight() * AbstractC2629l.i(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // W0.v
        public Class d() {
            return Drawable.class;
        }
    }

    /* JADX INFO: renamed from: f1.h$b */
    public static final class b implements U0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1740h f17379a;

        public b(C1740h c1740h) {
            this.f17379a = c1740h;
        }

        @Override // U0.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v a(ByteBuffer byteBuffer, int i8, int i9, U0.h hVar) {
            return this.f17379a.b(ImageDecoder.createSource(byteBuffer), i8, i9, hVar);
        }

        @Override // U0.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(ByteBuffer byteBuffer, U0.h hVar) {
            return this.f17379a.d(byteBuffer);
        }
    }

    /* JADX INFO: renamed from: f1.h$c */
    public static final class c implements U0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1740h f17380a;

        public c(C1740h c1740h) {
            this.f17380a = c1740h;
        }

        @Override // U0.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v a(InputStream inputStream, int i8, int i9, U0.h hVar) {
            return this.f17380a.b(ImageDecoder.createSource(AbstractC2618a.b(inputStream)), i8, i9, hVar);
        }

        @Override // U0.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(InputStream inputStream, U0.h hVar) {
            return this.f17380a.c(inputStream);
        }
    }

    public C1740h(List list, X0.b bVar) {
        this.f17376a = list;
        this.f17377b = bVar;
    }

    public static U0.j a(List list, X0.b bVar) {
        return new b(new C1740h(list, bVar));
    }

    public static U0.j f(List list, X0.b bVar) {
        return new c(new C1740h(list, bVar));
    }

    public v b(ImageDecoder.Source source, int i8, int i9, U0.h hVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new c1.l(i8, i9, hVar));
        if (AbstractC1734b.a(drawableDecodeDrawable)) {
            return new a(AbstractC1735c.a(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.f17376a, inputStream, this.f17377b));
    }

    public boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.f17376a, byteBuffer));
    }

    public final boolean e(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }
}
