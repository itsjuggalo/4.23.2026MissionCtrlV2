package o3;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import g3.g;
import g3.h;
import g3.i;
import p3.j;
import p3.p;
import p3.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f17468a = w.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g3.b f17471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f17472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f17474g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ImageDecoder$OnPartialImageListener {
        public a() {
        }

        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public c(int i10, int i11, h hVar) {
        this.f17469b = i10;
        this.f17470c = i11;
        this.f17471d = (g3.b) hVar.c(p.f18262f);
        this.f17472e = (j) hVar.c(j.f18257h);
        g gVar = p.f18266j;
        this.f17473f = hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue();
        this.f17474g = (i) hVar.c(p.f18263g);
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f17468a.f(this.f17469b, this.f17470c, this.f17473f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f17471d == g3.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f17469b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f17470c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f17472e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        i iVar = this.f17474g;
        if (iVar != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((iVar == i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i10 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
