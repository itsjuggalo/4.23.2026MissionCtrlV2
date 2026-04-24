package io.flutter.plugin.platform;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry$ImageTextureEntry;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRegistry$ImageTextureEntry f7138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageReader f7139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7140c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7141d = 0;
    public final Handler e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f7142f = new b(this);

    public c(TextureRegistry$ImageTextureEntry textureRegistry$ImageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f7138a = textureRegistry$ImageTextureEntry;
    }

    @Override // io.flutter.plugin.platform.g
    public final void a(int i, int i6) {
        ImageReader imageReaderNewInstance;
        ImageReader imageReader = this.f7139b;
        if (imageReader != null && this.f7140c == i && this.f7141d == i6) {
            return;
        }
        if (imageReader != null) {
            this.f7138a.pushImage(null);
            this.f7139b.close();
            this.f7139b = null;
        }
        this.f7140c = i;
        this.f7141d = i6;
        int i7 = Build.VERSION.SDK_INT;
        Handler handler = this.e;
        b bVar = this.f7142f;
        if (i7 >= 33) {
            E.c.p();
            ImageReader.Builder builderH = E.c.h(this.f7140c, this.f7141d);
            builderH.setMaxImages(4);
            builderH.setImageFormat(34);
            builderH.setUsage(256L);
            imageReaderNewInstance = builderH.build();
            imageReaderNewInstance.setOnImageAvailableListener(bVar, handler);
        } else {
            if (i7 < 29) {
                throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
            }
            imageReaderNewInstance = ImageReader.newInstance(i, i6, 34, 4, 256L);
            imageReaderNewInstance.setOnImageAvailableListener(bVar, handler);
        }
        this.f7139b = imageReaderNewInstance;
    }

    @Override // io.flutter.plugin.platform.g
    public final long b() {
        return this.f7138a.id();
    }

    @Override // io.flutter.plugin.platform.g
    public final int getHeight() {
        return this.f7141d;
    }

    @Override // io.flutter.plugin.platform.g
    public final Surface getSurface() {
        return this.f7139b.getSurface();
    }

    @Override // io.flutter.plugin.platform.g
    public final int getWidth() {
        return this.f7140c;
    }

    @Override // io.flutter.plugin.platform.g
    public final void release() {
        if (this.f7139b != null) {
            this.f7138a.pushImage(null);
            this.f7139b.close();
            this.f7139b = null;
        }
        this.f7138a = null;
    }
}
