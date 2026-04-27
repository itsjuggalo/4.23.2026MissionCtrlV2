package c1;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import d1.r;
import d1.v;

/* JADX INFO: loaded from: classes.dex */
public final class l implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f13329a = v.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0.b f13332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d1.l f13333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f13334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U0.i f13335g;

    public class a implements ImageDecoder$OnPartialImageListener {
        public a() {
        }

        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public l(int i8, int i9, U0.h hVar) {
        this.f13330b = i8;
        this.f13331c = i9;
        this.f13332d = (U0.b) hVar.c(r.f16801f);
        this.f13333e = (d1.l) hVar.c(d1.l.f16796h);
        U0.g gVar = r.f16805j;
        this.f13334f = hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue();
        this.f13335g = (U0.i) hVar.c(r.f16802g);
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named named;
        imageDecoder.setAllocator(this.f13329a.f(this.f13330b, this.f13331c, this.f13334f, false) ? 3 : 1);
        if (this.f13332d == U0.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f13330b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f13331c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f13333e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        U0.i iVar = this.f13335g;
        if (iVar != null) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 28) {
                if (iVar == U0.i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    named = ColorSpace.Named.DISPLAY_P3;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(named));
            }
            if (i8 < 26) {
                return;
            }
            named = ColorSpace.Named.SRGB;
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }
}
