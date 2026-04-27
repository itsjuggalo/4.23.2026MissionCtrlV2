package androidx.core.graphics.drawable;

import G.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f6851k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f6854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f6855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f6858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f6859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6861j;

    public static class a {
        public static IconCompat a(Object obj) {
            e.b(obj);
            int iD = d(obj);
            if (iD == 2) {
                return IconCompat.k(null, c(obj), b(obj));
            }
            if (iD == 4) {
                return IconCompat.g(e(obj));
            }
            if (iD == 6) {
                return IconCompat.d(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f6853b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            }
        }

        public static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon package", e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon package", e6);
                return null;
            }
        }

        public static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e4);
                return -1;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e5);
                return -1;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e6);
                return -1;
            }
        }

        public static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            }
        }

        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f6852a) {
                case -1:
                    return (Icon) iconCompat.f6853b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f6853b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.n(), iconCompat.f6856e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f6853b, iconCompat.f6856e, iconCompat.f6857f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f6853b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f6853b, false)) : b.b((Bitmap) iconCompat.f6853b);
                    break;
                case 6:
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.p());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.p());
                        }
                        InputStream inputStreamQ = iconCompat.q(context);
                        if (inputStreamQ == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.p());
                        }
                        if (i4 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.c(BitmapFactory.decodeStream(inputStreamQ), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamQ));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f6858g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f6859h;
            if (mode != IconCompat.f6851k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f6852a = -1;
        this.f6854c = null;
        this.f6855d = null;
        this.f6856e = 0;
        this.f6857f = 0;
        this.f6858g = null;
        this.f6859h = f6851k;
        this.f6860i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i4 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i4);
        iconCompat.f6856e = bundle.getInt("int1");
        iconCompat.f6857f = bundle.getInt("int2");
        iconCompat.f6861j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f6858g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f6859h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i4) {
            case -1:
            case 1:
            case 5:
                iconCompat.f6853b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i4);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f6853b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f6853b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        return a.a(icon);
    }

    public static Bitmap c(Bitmap bitmap, boolean z4) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f4 = iMin;
        float f5 = 0.5f * f4;
        float f6 = 0.9166667f * f5;
        if (z4) {
            float f7 = 0.010416667f * f4;
            paint.setColor(0);
            paint.setShadowLayer(f7, 0.0f, f4 * 0.020833334f, 1023410176);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.setShadowLayer(f7, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f5, f5, f6, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Uri uri) {
        G.b.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        G.b.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f6853b = str;
        return iconCompat;
    }

    public static IconCompat f(Bitmap bitmap) {
        G.b.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f6853b = bitmap;
        return iconCompat;
    }

    public static IconCompat g(Uri uri) {
        G.b.c(uri);
        return h(uri.toString());
    }

    public static IconCompat h(String str) {
        G.b.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f6853b = str;
        return iconCompat;
    }

    public static IconCompat i(byte[] bArr, int i4, int i5) {
        G.b.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f6853b = bArr;
        iconCompat.f6856e = i4;
        iconCompat.f6857f = i5;
        return iconCompat;
    }

    public static IconCompat j(Context context, int i4) {
        G.b.c(context);
        return k(context.getResources(), context.getPackageName(), i4);
    }

    public static IconCompat k(Resources resources, String str, int i4) {
        G.b.c(str);
        if (i4 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f6856e = i4;
        if (resources != null) {
            try {
                iconCompat.f6853b = resources.getResourceName(i4);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f6853b = str;
        }
        iconCompat.f6861j = str;
        return iconCompat;
    }

    public static String w(int i4) {
        switch (i4) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap l() {
        int i4 = this.f6852a;
        if (i4 == -1) {
            Object obj = this.f6853b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i4 == 1) {
            return (Bitmap) this.f6853b;
        }
        if (i4 == 5) {
            return c((Bitmap) this.f6853b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int m() {
        int i4 = this.f6852a;
        if (i4 == -1) {
            return a.b(this.f6853b);
        }
        if (i4 == 2) {
            return this.f6856e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String n() {
        int i4 = this.f6852a;
        if (i4 == -1) {
            return a.c(this.f6853b);
        }
        if (i4 == 2) {
            String str = this.f6861j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f6853b).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0] : this.f6861j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int o() {
        int i4 = this.f6852a;
        return i4 == -1 ? a.d(this.f6853b) : i4;
    }

    public Uri p() {
        int i4 = this.f6852a;
        if (i4 == -1) {
            return a.e(this.f6853b);
        }
        if (i4 == 4 || i4 == 6) {
            return Uri.parse((String) this.f6853b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream q(Context context) {
        Uri uriP = p();
        String scheme = uriP.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme) || io.flutter.plugins.firebase.crashlytics.Constants.FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriP);
            } catch (Exception e4) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriP, e4);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f6853b));
        } catch (FileNotFoundException e5) {
            Log.w("IconCompat", "Unable to load image from path: " + uriP, e5);
            return null;
        }
    }

    public void r() {
        this.f6859h = PorterDuff.Mode.valueOf(this.f6860i);
        switch (this.f6852a) {
            case -1:
                Parcelable parcelable = this.f6855d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f6853b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f6855d;
                if (parcelable2 != null) {
                    this.f6853b = parcelable2;
                    return;
                }
                byte[] bArr = this.f6854c;
                this.f6853b = bArr;
                this.f6852a = 3;
                this.f6856e = 0;
                this.f6857f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f6854c, Charset.forName("UTF-16"));
                this.f6853b = str;
                if (this.f6852a == 2 && this.f6861j == null) {
                    this.f6861j = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f6853b = this.f6854c;
                return;
        }
    }

    public void s(boolean z4) {
        this.f6860i = this.f6859h.name();
        switch (this.f6852a) {
            case -1:
                if (z4) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f6855d = (Parcelable) this.f6853b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z4) {
                    this.f6855d = (Parcelable) this.f6853b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f6853b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f6854c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f6854c = ((String) this.f6853b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f6854c = (byte[]) this.f6853b;
                return;
            case 4:
            case 6:
                this.f6854c = this.f6853b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle t() {
        Bundle bundle = new Bundle();
        switch (this.f6852a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f6853b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f6853b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f6853b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f6853b);
                break;
        }
        bundle.putInt("type", this.f6852a);
        bundle.putInt("int1", this.f6856e);
        bundle.putInt("int2", this.f6857f);
        bundle.putString("string1", this.f6861j);
        ColorStateList colorStateList = this.f6858g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f6859h;
        if (mode != f6851k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public String toString() {
        if (this.f6852a == -1) {
            return String.valueOf(this.f6853b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(w(this.f6852a));
        switch (this.f6852a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f6853b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f6853b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f6861j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f6856e);
                if (this.f6857f != 0) {
                    sb.append(" off=");
                    sb.append(this.f6857f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f6853b);
                break;
        }
        if (this.f6858g != null) {
            sb.append(" tint=");
            sb.append(this.f6858g);
        }
        if (this.f6859h != f6851k) {
            sb.append(" mode=");
            sb.append(this.f6859h);
        }
        sb.append(")");
        return sb.toString();
    }

    public Icon u() {
        return v(null);
    }

    public Icon v(Context context) {
        return a.g(this, context);
    }

    public IconCompat(int i4) {
        this.f6854c = null;
        this.f6855d = null;
        this.f6856e = 0;
        this.f6857f = 0;
        this.f6858g = null;
        this.f6859h = f6851k;
        this.f6860i = null;
        this.f6852a = i4;
    }
}
