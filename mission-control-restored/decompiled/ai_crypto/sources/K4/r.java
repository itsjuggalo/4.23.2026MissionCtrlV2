package K4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class r extends View implements io.flutter.embedding.engine.renderer.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageReader f3621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Image f3622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f3623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f3624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f3625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3626f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3627a;

        static {
            int[] iArr = new int[b.values().length];
            f3627a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3627a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        background,
        overlay
    }

    public r(Context context, int i7, int i8, b bVar) {
        this(context, h(i7, i8), bVar);
    }

    public static ImageReader h(int i7, int i8) {
        int i9;
        int i10;
        if (i7 <= 0) {
            j("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i7));
            i9 = 1;
        } else {
            i9 = i7;
        }
        if (i8 <= 0) {
            j("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i8));
            i10 = 1;
        } else {
            i10 = i8;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i9, i10, 1, 3, 768L) : ImageReader.newInstance(i9, i10, 1, 3);
    }

    public static void j(String str, Object... objArr) {
        J4.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void b(FlutterRenderer flutterRenderer) {
        if (a.f3627a[this.f3625e.ordinal()] == 1) {
            flutterRenderer.C(this.f3621a.getSurface());
        }
        setAlpha(1.0f);
        this.f3624d = flutterRenderer;
        this.f3626f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void d() {
        if (this.f3626f) {
            setAlpha(0.0f);
            e();
            this.f3623c = null;
            f();
            invalidate();
            this.f3626f = false;
        }
    }

    public boolean e() {
        if (!this.f3626f) {
            return false;
        }
        Image imageAcquireLatestImage = this.f3621a.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            f();
            this.f3622b = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void f() {
        Image image = this.f3622b;
        if (image != null) {
            image.close();
            this.f3622b = null;
        }
    }

    public void g() {
        this.f3621a.close();
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public FlutterRenderer getAttachedRenderer() {
        return this.f3624d;
    }

    public ImageReader getImageReader() {
        return this.f3621a;
    }

    public Surface getSurface() {
        return this.f3621a.getSurface();
    }

    public final void i() {
        setAlpha(0.0f);
    }

    public void k(int i7, int i8) {
        if (this.f3624d == null) {
            return;
        }
        if (i7 == this.f3621a.getWidth() && i8 == this.f3621a.getHeight()) {
            return;
        }
        f();
        g();
        this.f3621a = h(i7, i8);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f3622b.getHardwareBuffer();
            this.f3623c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f3622b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f3622b.getHeight();
        Bitmap bitmap = this.f3623c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f3623c.getHeight() != height) {
            this.f3623c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f3623c.copyPixelsFromBuffer(buffer);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3622b != null) {
            l();
        }
        Bitmap bitmap = this.f3623c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        if (!(i7 == this.f3621a.getWidth() && i8 == this.f3621a.getHeight()) && this.f3625e == b.background && this.f3626f) {
            k(i7, i8);
            this.f3624d.C(this.f3621a.getSurface());
        }
    }

    public r(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f3626f = false;
        this.f3621a = imageReader;
        this.f3625e = bVar;
        i();
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void a() {
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void c() {
    }
}
