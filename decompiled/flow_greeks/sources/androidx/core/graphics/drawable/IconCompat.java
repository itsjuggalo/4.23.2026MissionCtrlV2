package androidx.core.graphics.drawable;

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
import s0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1564k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f1568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f1571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1574j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static IconCompat a(Object obj) {
            f.d(obj);
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
            iconCompat.f1566b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            }
        }

        public static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            }
        }

        public static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            }
        }

        public static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            }
        }

        public static Icon f(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f1565a) {
                case -1:
                    return (Icon) iconCompat.f1566b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f1566b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.n(), iconCompat.f1569e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f1566b, iconCompat.f1569e, iconCompat.f1570f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f1566b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f1566b, false)) : b.a((Bitmap) iconCompat.f1566b);
                    break;
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.p());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.p());
                        }
                        InputStream inputStreamQ = iconCompat.q(context);
                        if (inputStreamQ == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.p());
                        }
                        if (i10 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.c(BitmapFactory.decodeStream(inputStreamQ), false));
                        } else {
                            iconCreateWithBitmap = b.a(BitmapFactory.decodeStream(inputStreamQ));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f1571g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f1572h;
            if (mode != IconCompat.f1564k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f1565a = -1;
        this.f1567c = null;
        this.f1568d = null;
        this.f1569e = 0;
        this.f1570f = 0;
        this.f1571g = null;
        this.f1572h = f1564k;
        this.f1573i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i10 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i10);
        iconCompat.f1569e = bundle.getInt("int1");
        iconCompat.f1570f = bundle.getInt("int2");
        iconCompat.f1574j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f1571g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f1572h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i10) {
            case -1:
            case 1:
            case 5:
                iconCompat.f1566b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i10);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f1566b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f1566b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        return a.a(icon);
    }

    public static Bitmap c(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f10 = iMin;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Uri uri) {
        s0.b.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        s0.b.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f1566b = str;
        return iconCompat;
    }

    public static IconCompat f(Bitmap bitmap) {
        s0.b.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f1566b = bitmap;
        return iconCompat;
    }

    public static IconCompat g(Uri uri) {
        s0.b.c(uri);
        return h(uri.toString());
    }

    public static IconCompat h(String str) {
        s0.b.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f1566b = str;
        return iconCompat;
    }

    public static IconCompat i(byte[] bArr, int i10, int i11) {
        s0.b.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f1566b = bArr;
        iconCompat.f1569e = i10;
        iconCompat.f1570f = i11;
        return iconCompat;
    }

    public static IconCompat j(Context context, int i10) {
        s0.b.c(context);
        return k(context.getResources(), context.getPackageName(), i10);
    }

    public static IconCompat k(Resources resources, String str, int i10) {
        s0.b.c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f1569e = i10;
        if (resources != null) {
            try {
                iconCompat.f1566b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f1566b = str;
        }
        iconCompat.f1574j = str;
        return iconCompat;
    }

    public static String w(int i10) {
        switch (i10) {
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
        int i10 = this.f1565a;
        if (i10 == -1) {
            Object obj = this.f1566b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f1566b;
        }
        if (i10 == 5) {
            return c((Bitmap) this.f1566b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int m() {
        int i10 = this.f1565a;
        if (i10 == -1) {
            return a.b(this.f1566b);
        }
        if (i10 == 2) {
            return this.f1569e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String n() {
        int i10 = this.f1565a;
        if (i10 == -1) {
            return a.c(this.f1566b);
        }
        if (i10 == 2) {
            String str = this.f1574j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f1566b).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0] : this.f1574j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int o() {
        int i10 = this.f1565a;
        return i10 == -1 ? a.d(this.f1566b) : i10;
    }

    public Uri p() {
        int i10 = this.f1565a;
        if (i10 == -1) {
            return a.e(this.f1566b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f1566b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream q(Context context) {
        Uri uriP = p();
        String scheme = uriP.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriP);
            } catch (Exception e10) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriP, e10);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f1566b));
        } catch (FileNotFoundException e11) {
            Log.w("IconCompat", "Unable to load image from path: " + uriP, e11);
            return null;
        }
    }

    public void r() {
        this.f1572h = PorterDuff.Mode.valueOf(this.f1573i);
        switch (this.f1565a) {
            case -1:
                Parcelable parcelable = this.f1568d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f1566b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1568d;
                if (parcelable2 != null) {
                    this.f1566b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1567c;
                this.f1566b = bArr;
                this.f1565a = 3;
                this.f1569e = 0;
                this.f1570f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1567c, Charset.forName("UTF-16"));
                this.f1566b = str;
                if (this.f1565a == 2 && this.f1574j == null) {
                    this.f1574j = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1566b = this.f1567c;
                return;
        }
    }

    public void s(boolean z10) {
        this.f1573i = this.f1572h.name();
        switch (this.f1565a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f1568d = (Parcelable) this.f1566b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f1568d = (Parcelable) this.f1566b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f1566b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1567c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f1567c = ((String) this.f1566b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1567c = (byte[]) this.f1566b;
                return;
            case 4:
            case 6:
                this.f1567c = this.f1566b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle t() {
        Bundle bundle = new Bundle();
        switch (this.f1565a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f1566b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f1566b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f1566b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f1566b);
                break;
        }
        bundle.putInt("type", this.f1565a);
        bundle.putInt("int1", this.f1569e);
        bundle.putInt("int2", this.f1570f);
        bundle.putString("string1", this.f1574j);
        ColorStateList colorStateList = this.f1571g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f1572h;
        if (mode != f1564k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public String toString() {
        if (this.f1565a == -1) {
            return String.valueOf(this.f1566b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(w(this.f1565a));
        switch (this.f1565a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f1566b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f1566b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f1574j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(m())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f1569e);
                if (this.f1570f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f1570f);
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f1566b);
                break;
        }
        if (this.f1571g != null) {
            sb2.append(" tint=");
            sb2.append(this.f1571g);
        }
        if (this.f1572h != f1564k) {
            sb2.append(" mode=");
            sb2.append(this.f1572h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public Icon u() {
        return v(null);
    }

    public Icon v(Context context) {
        return a.f(this, context);
    }

    public IconCompat(int i10) {
        this.f1567c = null;
        this.f1568d = null;
        this.f1569e = 0;
        this.f1570f = 0;
        this.f1571g = null;
        this.f1572h = f1564k;
        this.f1573i = null;
        this.f1565a = i10;
    }
}
