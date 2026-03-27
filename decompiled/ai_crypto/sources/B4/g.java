package B4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Intent f834a = new Intent();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f835b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f836a = new Bundle();

        public Bundle a() {
            return this.f836a;
        }

        public void b(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", i7);
        }

        public void c(int i7, D4.a... aVarArr) {
            if (i7 >= aVarArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] (0-based) cannot be higher or equal than aspect ratio options count [count = %d].", Integer.valueOf(i7), Integer.valueOf(aVarArr.length)));
            }
            this.f836a.putInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", i7);
            this.f836a.putParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions", new ArrayList<>(Arrays.asList(aVarArr)));
        }

        public void d(boolean z7) {
            this.f836a.putBoolean("com.yalantis.ucrop.CircleDimmedLayer", z7);
        }

        public void e(Bitmap.CompressFormat compressFormat) {
            this.f836a.putString("com.yalantis.ucrop.CompressionFormatName", compressFormat.name());
        }

        public void f(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CompressionQuality", i7);
        }

        public void g(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropFrameColor", i7);
        }

        public void h(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropFrameStrokeWidth", i7);
        }

        public void i(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropGridColor", i7);
        }

        public void j(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropGridColumnCount", i7);
        }

        public void k(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropGridRowCount", i7);
        }

        public void l(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.CropGridStrokeWidth", i7);
        }

        public void m(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.DimmedLayerColor", i7);
        }

        public void n(boolean z7) {
            this.f836a.putBoolean("com.yalantis.ucrop.FreeStyleCrop", z7);
        }

        public void o(boolean z7) {
            this.f836a.putBoolean("com.yalantis.ucrop.HideBottomControls", z7);
        }

        public void p(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.MaxBitmapSize", i7);
        }

        public void q(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", i7);
        }

        public void r(boolean z7) {
            this.f836a.putBoolean("com.yalantis.ucrop.ShowCropGrid", z7);
        }

        public void s(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.StatusBarColor", i7);
        }

        public void t(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.ToolbarColor", i7);
        }

        public void u(String str) {
            this.f836a.putString("com.yalantis.ucrop.UcropToolbarTitleText", str);
        }

        public void v(int i7) {
            this.f836a.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", i7);
        }
    }

    public g(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.f835b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f835b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    public static Throwable a(Intent intent) {
        return (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error");
    }

    public static Uri c(Intent intent) {
        return (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    }

    public static g d(Uri uri, Uri uri2) {
        return new g(uri, uri2);
    }

    public Intent b(Context context) {
        this.f834a.setClass(context, h.class);
        this.f834a.putExtras(this.f835b);
        return this.f834a;
    }

    public g e(float f7, float f8) {
        this.f835b.putFloat("com.yalantis.ucrop.AspectRatioX", f7);
        this.f835b.putFloat("com.yalantis.ucrop.AspectRatioY", f8);
        return this;
    }

    public g f(int i7, int i8) {
        if (i7 < 10) {
            i7 = 10;
        }
        if (i8 < 10) {
            i8 = 10;
        }
        this.f835b.putInt("com.yalantis.ucrop.MaxSizeX", i7);
        this.f835b.putInt("com.yalantis.ucrop.MaxSizeY", i8);
        return this;
    }

    public g g(a aVar) {
        this.f835b.putAll(aVar.a());
        return this;
    }
}
