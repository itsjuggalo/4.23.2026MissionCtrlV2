package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import x.AbstractC1394b;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f4426k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f4429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f4430d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f4432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f4433h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4434j;

    public IconCompat() {
        this.f4427a = -1;
        this.f4429c = null;
        this.f4430d = null;
        this.e = 0;
        this.f4431f = 0;
        this.f4432g = null;
        this.f4433h = f4426k;
        this.i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i);
        iconCompat.e = bundle.getInt("int1");
        iconCompat.f4431f = bundle.getInt("int2");
        iconCompat.f4434j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f4432g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f4433h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i) {
            case -1:
            case 1:
            case 5:
                iconCompat.f4428b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f4428b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f4428b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        icon.getClass();
        int iC = AbstractC1394b.c(icon);
        if (iC == 2) {
            return e(null, AbstractC1394b.b(icon), AbstractC1394b.a(icon));
        }
        if (iC == 4) {
            Uri uriD = AbstractC1394b.d(icon);
            uriD.getClass();
            String string = uriD.toString();
            string.getClass();
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.f4428b = string;
            return iconCompat;
        }
        if (iC != 6) {
            IconCompat iconCompat2 = new IconCompat(-1);
            iconCompat2.f4428b = icon;
            return iconCompat2;
        }
        Uri uriD2 = AbstractC1394b.d(icon);
        uriD2.getClass();
        String string2 = uriD2.toString();
        string2.getClass();
        IconCompat iconCompat3 = new IconCompat(6);
        iconCompat3.f4428b = string2;
        return iconCompat3;
    }

    public static Bitmap c(Bitmap bitmap, boolean z6) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f6 = iMin;
        float f7 = 0.5f * f6;
        float f8 = 0.9166667f * f7;
        if (z6) {
            float f9 = 0.010416667f * f6;
            paint.setColor(0);
            paint.setShadowLayer(f9, 0.0f, f6 * 0.020833334f, 1023410176);
            canvas.drawCircle(f7, f7, f8, paint);
            paint.setShadowLayer(f9, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f7, f7, f8, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f7, f7, f8, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f4428b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Resources resources, String str, int i) {
        str.getClass();
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        if (resources != null) {
            try {
                iconCompat.f4428b = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f4428b = str;
        }
        iconCompat.f4434j = str;
        return iconCompat;
    }

    public final int f() {
        int i = this.f4427a;
        if (i == -1) {
            return AbstractC1394b.a(this.f4428b);
        }
        if (i == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri g() {
        int i = this.f4427a;
        if (i == -1) {
            return AbstractC1394b.d(this.f4428b);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.f4428b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f4427a == -1) {
            return String.valueOf(this.f4428b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f4427a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f4427a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f4428b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f4428b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f4434j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(f())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f4431f != 0) {
                    sb.append(" off=");
                    sb.append(this.f4431f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f4428b);
                break;
        }
        if (this.f4432g != null) {
            sb.append(" tint=");
            sb.append(this.f4432g);
        }
        if (this.f4433h != f4426k) {
            sb.append(" mode=");
            sb.append(this.f4433h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f4429c = null;
        this.f4430d = null;
        this.e = 0;
        this.f4431f = 0;
        this.f4432g = null;
        this.f4433h = f4426k;
        this.i = null;
        this.f4427a = i;
    }
}
