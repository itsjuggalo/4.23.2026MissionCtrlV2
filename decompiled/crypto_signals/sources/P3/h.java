package P3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class h extends View implements io.flutter.embedding.engine.renderer.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageReader f2544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Image f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f2546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.k f2547d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2548f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, int i, int i6, int i7) {
        super(context, null);
        ImageReader imageReaderF = f(i, i6);
        this.f2548f = false;
        this.f2544a = imageReaderF;
        this.e = i7;
        setAlpha(0.0f);
    }

    public static ImageReader f(int i, int i6) {
        if (i <= 0) {
            Locale locale = Locale.US;
            Log.w("FlutterImageView", "ImageReader width must be greater than 0, but given width=" + i + ", set width=1");
            i = 1;
        }
        if (i6 <= 0) {
            Locale locale2 = Locale.US;
            Log.w("FlutterImageView", "ImageReader height must be greater than 0, but given height=" + i6 + ", set height=1");
            i6 = 1;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i, i6, 1, 3, 768L) : ImageReader.newInstance(i, i6, 1, 3);
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void a() {
        if (this.f2548f) {
            setAlpha(0.0f);
            e();
            this.f2546c = null;
            Image image = this.f2545b;
            if (image != null) {
                image.close();
                this.f2545b = null;
            }
            invalidate();
            this.f2548f = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void c(io.flutter.embedding.engine.renderer.k kVar) {
        if (S.i.c(this.e) == 0) {
            Surface surface = this.f2544a.getSurface();
            kVar.f7072c = surface;
            kVar.f7070a.onSurfaceWindowChanged(surface);
        }
        setAlpha(1.0f);
        this.f2547d = kVar;
        this.f2548f = true;
    }

    public final boolean e() {
        if (!this.f2548f) {
            return false;
        }
        Image imageAcquireLatestImage = this.f2544a.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            Image image = this.f2545b;
            if (image != null) {
                image.close();
                this.f2545b = null;
            }
            this.f2545b = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void g(int i, int i6) {
        if (this.f2547d == null) {
            return;
        }
        if (i == this.f2544a.getWidth() && i6 == this.f2544a.getHeight()) {
            return;
        }
        Image image = this.f2545b;
        if (image != null) {
            image.close();
            this.f2545b = null;
        }
        this.f2544a.close();
        this.f2544a = f(i, i6);
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public io.flutter.embedding.engine.renderer.k getAttachedRenderer() {
        return this.f2547d;
    }

    public ImageReader getImageReader() {
        return this.f2544a;
    }

    public Surface getSurface() {
        return this.f2544a.getSurface();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Image image = this.f2545b;
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                this.f2546c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
                hardwareBuffer.close();
            } else {
                Image.Plane[] planes = image.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.f2545b.getHeight();
                    Bitmap bitmap = this.f2546c;
                    if (bitmap == null || bitmap.getWidth() != rowStride || this.f2546c.getHeight() != height) {
                        this.f2546c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.rewind();
                    this.f2546c.copyPixelsFromBuffer(buffer);
                }
            }
        }
        Bitmap bitmap2 = this.f2546c;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i7, int i8) {
        if (!(i == this.f2544a.getWidth() && i6 == this.f2544a.getHeight()) && this.e == 1 && this.f2548f) {
            g(i, i6);
            io.flutter.embedding.engine.renderer.k kVar = this.f2547d;
            Surface surface = this.f2544a.getSurface();
            kVar.f7072c = surface;
            kVar.f7070a.onSurfaceWindowChanged(surface);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void b() {
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void d() {
    }
}
