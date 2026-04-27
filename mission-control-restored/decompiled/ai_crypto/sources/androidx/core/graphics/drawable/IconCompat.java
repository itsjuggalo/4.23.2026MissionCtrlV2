package androidx.core.graphics.drawable;

import P.f;
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
    public static final PorterDuff.Mode f7259k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f7262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f7263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f7266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f7267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7269j;

    public static class a {
        public static IconCompat a(Object obj) {
            f.g(obj);
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
            iconCompat.f7261b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon resource", e8);
                return 0;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon resource", e9);
                return 0;
            }
        }

        public static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon package", e8);
                return null;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon package", e9);
                return null;
            }
        }

        public static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e7);
                return -1;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e8);
                return -1;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e9);
                return -1;
            }
        }

        public static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            } catch (NoSuchMethodException e8) {
                Log.e("IconCompat", "Unable to get icon uri", e8);
                return null;
            } catch (InvocationTargetException e9) {
                Log.e("IconCompat", "Unable to get icon uri", e9);
                return null;
            }
        }

        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f7260a) {
                case -1:
                    return (Icon) iconCompat.f7261b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f7261b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.n(), iconCompat.f7264e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f7261b, iconCompat.f7264e, iconCompat.f7265f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f7261b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f7261b, false)) : b.b((Bitmap) iconCompat.f7261b);
                    break;
                case 6:
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.p());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.p());
                        }
                        InputStream inputStreamQ = iconCompat.q(context);
                        if (inputStreamQ == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.p());
                        }
                        if (i7 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.c(BitmapFactory.decodeStream(inputStreamQ), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamQ));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f7266g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f7267h;
            if (mode != IconCompat.f7259k) {
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
        this.f7260a = -1;
        this.f7262c = null;
        this.f7263d = null;
        this.f7264e = 0;
        this.f7265f = 0;
        this.f7266g = null;
        this.f7267h = f7259k;
        this.f7268i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i7 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i7);
        iconCompat.f7264e = bundle.getInt("int1");
        iconCompat.f7265f = bundle.getInt("int2");
        iconCompat.f7269j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f7266g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f7267h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i7) {
            case -1:
            case 1:
            case 5:
                iconCompat.f7261b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i7);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f7261b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f7261b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        return a.a(icon);
    }

    public static Bitmap c(Bitmap bitmap, boolean z7) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f7 = iMin;
        float f8 = 0.5f * f7;
        float f9 = 0.9166667f * f8;
        if (z7) {
            float f10 = 0.010416667f * f7;
            paint.setColor(0);
            paint.setShadowLayer(f10, 0.0f, f7 * 0.020833334f, 1023410176);
            canvas.drawCircle(f8, f8, f9, paint);
            paint.setShadowLayer(f10, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f8, f8, f9, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f8, f8, f9, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Uri uri) {
        P.b.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        P.b.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f7261b = str;
        return iconCompat;
    }

    public static IconCompat f(Bitmap bitmap) {
        P.b.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f7261b = bitmap;
        return iconCompat;
    }

    public static IconCompat g(Uri uri) {
        P.b.c(uri);
        return h(uri.toString());
    }

    public static IconCompat h(String str) {
        P.b.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f7261b = str;
        return iconCompat;
    }

    public static IconCompat i(byte[] bArr, int i7, int i8) {
        P.b.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f7261b = bArr;
        iconCompat.f7264e = i7;
        iconCompat.f7265f = i8;
        return iconCompat;
    }

    public static IconCompat j(Context context, int i7) {
        P.b.c(context);
        return k(context.getResources(), context.getPackageName(), i7);
    }

    public static IconCompat k(Resources resources, String str, int i7) {
        P.b.c(str);
        if (i7 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f7264e = i7;
        if (resources != null) {
            try {
                iconCompat.f7261b = resources.getResourceName(i7);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f7261b = str;
        }
        iconCompat.f7269j = str;
        return iconCompat;
    }

    public static String w(int i7) {
        switch (i7) {
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
        int i7 = this.f7260a;
        if (i7 == -1) {
            Object obj = this.f7261b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i7 == 1) {
            return (Bitmap) this.f7261b;
        }
        if (i7 == 5) {
            return c((Bitmap) this.f7261b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int m() {
        int i7 = this.f7260a;
        if (i7 == -1) {
            return a.b(this.f7261b);
        }
        if (i7 == 2) {
            return this.f7264e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String n() {
        int i7 = this.f7260a;
        if (i7 == -1) {
            return a.c(this.f7261b);
        }
        if (i7 == 2) {
            String str = this.f7269j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f7261b).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0] : this.f7269j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int o() {
        int i7 = this.f7260a;
        return i7 == -1 ? a.d(this.f7261b) : i7;
    }

    public Uri p() {
        int i7 = this.f7260a;
        if (i7 == -1) {
            return a.e(this.f7261b);
        }
        if (i7 == 4 || i7 == 6) {
            return Uri.parse((String) this.f7261b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream q(Context context) {
        Uri uriP = p();
        String scheme = uriP.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriP);
            } catch (Exception e7) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriP, e7);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f7261b));
        } catch (FileNotFoundException e8) {
            Log.w("IconCompat", "Unable to load image from path: " + uriP, e8);
            return null;
        }
    }

    public void r() {
        this.f7267h = PorterDuff.Mode.valueOf(this.f7268i);
        switch (this.f7260a) {
            case -1:
                Parcelable parcelable = this.f7263d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f7261b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f7263d;
                if (parcelable2 != null) {
                    this.f7261b = parcelable2;
                    return;
                }
                byte[] bArr = this.f7262c;
                this.f7261b = bArr;
                this.f7260a = 3;
                this.f7264e = 0;
                this.f7265f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f7262c, Charset.forName("UTF-16"));
                this.f7261b = str;
                if (this.f7260a == 2 && this.f7269j == null) {
                    this.f7269j = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f7261b = this.f7262c;
                return;
        }
    }

    public void s(boolean z7) {
        this.f7268i = this.f7267h.name();
        switch (this.f7260a) {
            case -1:
                if (z7) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f7263d = (Parcelable) this.f7261b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z7) {
                    this.f7263d = (Parcelable) this.f7261b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f7261b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f7262c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f7262c = ((String) this.f7261b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f7262c = (byte[]) this.f7261b;
                return;
            case 4:
            case 6:
                this.f7262c = this.f7261b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle t() {
        Bundle bundle = new Bundle();
        switch (this.f7260a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f7261b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f7261b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f7261b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f7261b);
                break;
        }
        bundle.putInt("type", this.f7260a);
        bundle.putInt("int1", this.f7264e);
        bundle.putInt("int2", this.f7265f);
        bundle.putString("string1", this.f7269j);
        ColorStateList colorStateList = this.f7266g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f7267h;
        if (mode != f7259k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public String toString() {
        if (this.f7260a == -1) {
            return String.valueOf(this.f7261b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(w(this.f7260a));
        switch (this.f7260a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f7261b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f7261b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f7269j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f7264e);
                if (this.f7265f != 0) {
                    sb.append(" off=");
                    sb.append(this.f7265f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f7261b);
                break;
        }
        if (this.f7266g != null) {
            sb.append(" tint=");
            sb.append(this.f7266g);
        }
        if (this.f7267h != f7259k) {
            sb.append(" mode=");
            sb.append(this.f7267h);
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

    public IconCompat(int i7) {
        this.f7262c = null;
        this.f7263d = null;
        this.f7264e = 0;
        this.f7265f = 0;
        this.f7266g = null;
        this.f7267h = f7259k;
        this.f7268i = null;
        this.f7260a = i7;
    }
}
