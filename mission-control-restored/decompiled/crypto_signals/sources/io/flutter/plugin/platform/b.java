package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f7137a;

    public b(c cVar) {
        this.f7137a = cVar;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Image imageAcquireLatestImage;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (IllegalStateException e) {
            Log.e("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e.toString());
            imageAcquireLatestImage = null;
        }
        if (imageAcquireLatestImage == null) {
            return;
        }
        this.f7137a.f7138a.pushImage(imageAcquireLatestImage);
    }
}
