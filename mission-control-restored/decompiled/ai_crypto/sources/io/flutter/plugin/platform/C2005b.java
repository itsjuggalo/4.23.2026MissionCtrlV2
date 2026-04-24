package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* JADX INFO: renamed from: io.flutter.plugin.platform.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2005b implements InterfaceC2018o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRegistry.ImageTextureEntry f16734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageReader f16735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16736c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16737d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f16738e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageReader.OnImageAvailableListener f16739f = new a();

    /* JADX INFO: renamed from: io.flutter.plugin.platform.b$a */
    public class a implements ImageReader.OnImageAvailableListener {
        public a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireLatestImage;
            try {
                imageAcquireLatestImage = imageReader.acquireLatestImage();
            } catch (IllegalStateException e7) {
                J4.b.b("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e7.toString());
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return;
            }
            C2005b.this.f16734a.pushImage(imageAcquireLatestImage);
        }
    }

    public C2005b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f16734a = imageTextureEntry;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void a(int i7, int i8) {
        if (this.f16735b != null && this.f16736c == i7 && this.f16737d == i8) {
            return;
        }
        c();
        this.f16736c = i7;
        this.f16737d = i8;
        this.f16735b = d();
    }

    public final void c() {
        if (this.f16735b != null) {
            this.f16734a.pushImage(null);
            this.f16735b.close();
            this.f16735b = null;
        }
    }

    public ImageReader d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            return f();
        }
        if (i7 >= 29) {
            return e();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public ImageReader e() {
        ImageReader imageReaderNewInstance = ImageReader.newInstance(this.f16736c, this.f16737d, 34, 4, 256L);
        imageReaderNewInstance.setOnImageAvailableListener(this.f16739f, this.f16738e);
        return imageReaderNewInstance;
    }

    public ImageReader f() {
        io.flutter.embedding.engine.renderer.h.a();
        ImageReader.Builder builderA = io.flutter.embedding.engine.renderer.g.a(this.f16736c, this.f16737d);
        builderA.setMaxImages(4);
        builderA.setImageFormat(34);
        builderA.setUsage(256L);
        ImageReader imageReaderBuild = builderA.build();
        imageReaderBuild.setOnImageAvailableListener(this.f16739f, this.f16738e);
        return imageReaderBuild;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getHeight() {
        return this.f16737d;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public long getId() {
        return this.f16734a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public Surface getSurface() {
        return this.f16735b.getSurface();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getWidth() {
        return this.f16736c;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void release() {
        c();
        this.f16734a = null;
    }
}
