package androidx.core.graphics.drawable;

import S.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
    public static final PorterDuff.Mode f11084k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f11088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f11091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f11092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11094j;

    public static class a {
        public static IconCompat a(Object obj) {
            g.d(obj);
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
            iconCompat.f11086b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon resource", e8);
                return 0;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon resource", e9);
                return 0;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            }
        }

        public static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon package", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon package", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            }
        }

        public static int d(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e8) {
                e = e8;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e9) {
                e = e9;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e10) {
                e = e10;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        public static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon uri", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon uri", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            }
        }

        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        
            if (r0 >= 26) goto L14;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
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
        this.f11085a = -1;
        this.f11087c = null;
        this.f11088d = null;
        this.f11089e = 0;
        this.f11090f = 0;
        this.f11091g = null;
        this.f11092h = f11084k;
        this.f11093i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i8 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i8);
        iconCompat.f11089e = bundle.getInt("int1");
        iconCompat.f11090f = bundle.getInt("int2");
        iconCompat.f11094j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f11091g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f11092h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i8) {
            case -1:
            case 1:
            case 5:
                iconCompat.f11086b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i8);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f11086b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f11086b = bundle.getByteArray("obj");
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
        float f8 = iMin;
        float f9 = 0.5f * f8;
        float f10 = 0.9166667f * f9;
        if (z7) {
            float f11 = 0.010416667f * f8;
            paint.setColor(0);
            paint.setShadowLayer(f11, 0.0f, f8 * 0.020833334f, 1023410176);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.setShadowLayer(f11, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f9, f9, f10, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Uri uri) {
        S.c.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        S.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f11086b = str;
        return iconCompat;
    }

    public static IconCompat f(Bitmap bitmap) {
        S.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f11086b = bitmap;
        return iconCompat;
    }

    public static IconCompat g(Uri uri) {
        S.c.c(uri);
        return h(uri.toString());
    }

    public static IconCompat h(String str) {
        S.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f11086b = str;
        return iconCompat;
    }

    public static IconCompat i(byte[] bArr, int i8, int i9) {
        S.c.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f11086b = bArr;
        iconCompat.f11089e = i8;
        iconCompat.f11090f = i9;
        return iconCompat;
    }

    public static IconCompat j(Context context, int i8) {
        S.c.c(context);
        return k(context.getResources(), context.getPackageName(), i8);
    }

    public static IconCompat k(Resources resources, String str, int i8) {
        S.c.c(str);
        if (i8 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f11089e = i8;
        if (resources != null) {
            try {
                iconCompat.f11086b = resources.getResourceName(i8);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f11086b = str;
        }
        iconCompat.f11094j = str;
        return iconCompat;
    }

    public static String w(int i8) {
        switch (i8) {
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
        int i8 = this.f11085a;
        if (i8 == -1) {
            Object obj = this.f11086b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i8 == 1) {
            return (Bitmap) this.f11086b;
        }
        if (i8 == 5) {
            return c((Bitmap) this.f11086b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int m() {
        int i8 = this.f11085a;
        if (i8 == -1) {
            return a.b(this.f11086b);
        }
        if (i8 == 2) {
            return this.f11089e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String n() {
        int i8 = this.f11085a;
        if (i8 == -1) {
            return a.c(this.f11086b);
        }
        if (i8 == 2) {
            String str = this.f11094j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f11086b).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0] : this.f11094j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int o() {
        int i8 = this.f11085a;
        return i8 == -1 ? a.d(this.f11086b) : i8;
    }

    public Uri p() {
        int i8 = this.f11085a;
        if (i8 == -1) {
            return a.e(this.f11086b);
        }
        if (i8 == 4 || i8 == 6) {
            return Uri.parse((String) this.f11086b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream q(Context context) {
        StringBuilder sb;
        String str;
        Uri uriP = p();
        String scheme = uriP.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriP);
            } catch (Exception e8) {
                e = e8;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f11086b));
            } catch (FileNotFoundException e9) {
                e = e9;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(uriP);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void r() {
        Parcelable parcelable;
        this.f11092h = PorterDuff.Mode.valueOf(this.f11093i);
        switch (this.f11085a) {
            case -1:
                parcelable = this.f11088d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f11088d;
                if (parcelable == null) {
                    byte[] bArr = this.f11087c;
                    this.f11086b = bArr;
                    this.f11085a = 3;
                    this.f11089e = 0;
                    this.f11090f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f11087c, Charset.forName("UTF-16"));
                this.f11086b = str;
                if (this.f11085a == 2 && this.f11094j == null) {
                    this.f11094j = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f11086b = this.f11087c;
                return;
        }
        this.f11086b = parcelable;
    }

    public void s(boolean z7) {
        this.f11093i = this.f11092h.name();
        switch (this.f11085a) {
            case -1:
                if (z7) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z7) {
                    Bitmap bitmap = (Bitmap) this.f11086b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f11087c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f11087c = ((String) this.f11086b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f11087c = (byte[]) this.f11086b;
                return;
            case 4:
            case 6:
                this.f11087c = this.f11086b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f11088d = (Parcelable) this.f11086b;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle t() {
        /*
            r3 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            int r1 = r3.f11085a
            java.lang.String r2 = "obj"
            switch(r1) {
                case -1: goto L2c;
                case 0: goto Lc;
                case 1: goto L24;
                case 2: goto L1c;
                case 3: goto L14;
                case 4: goto L1c;
                case 5: goto L24;
                case 6: goto L1c;
                default: goto Lc;
            }
        Lc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid icon"
            r0.<init>(r1)
            throw r0
        L14:
            java.lang.Object r1 = r3.f11086b
            byte[] r1 = (byte[]) r1
            r0.putByteArray(r2, r1)
            goto L31
        L1c:
            java.lang.Object r1 = r3.f11086b
            java.lang.String r1 = (java.lang.String) r1
            r0.putString(r2, r1)
            goto L31
        L24:
            java.lang.Object r1 = r3.f11086b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
        L28:
            r0.putParcelable(r2, r1)
            goto L31
        L2c:
            java.lang.Object r1 = r3.f11086b
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            goto L28
        L31:
            java.lang.String r1 = "type"
            int r2 = r3.f11085a
            r0.putInt(r1, r2)
            java.lang.String r1 = "int1"
            int r2 = r3.f11089e
            r0.putInt(r1, r2)
            java.lang.String r1 = "int2"
            int r2 = r3.f11090f
            r0.putInt(r1, r2)
            java.lang.String r1 = "string1"
            java.lang.String r2 = r3.f11094j
            r0.putString(r1, r2)
            android.content.res.ColorStateList r1 = r3.f11091g
            if (r1 == 0) goto L56
            java.lang.String r2 = "tint_list"
            r0.putParcelable(r2, r1)
        L56:
            android.graphics.PorterDuff$Mode r1 = r3.f11092h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.f11084k
            if (r1 == r2) goto L65
            java.lang.String r2 = "tint_mode"
            java.lang.String r1 = r1.name()
            r0.putString(r2, r1)
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.t():android.os.Bundle");
    }

    public String toString() {
        int height;
        if (this.f11085a == -1) {
            return String.valueOf(this.f11086b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(w(this.f11085a));
        switch (this.f11085a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f11086b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f11086b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f11094j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f11089e);
                if (this.f11090f != 0) {
                    sb.append(" off=");
                    height = this.f11090f;
                    sb.append(height);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f11086b);
                break;
        }
        if (this.f11091g != null) {
            sb.append(" tint=");
            sb.append(this.f11091g);
        }
        if (this.f11092h != f11084k) {
            sb.append(" mode=");
            sb.append(this.f11092h);
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

    public IconCompat(int i8) {
        this.f11087c = null;
        this.f11088d = null;
        this.f11089e = 0;
        this.f11090f = 0;
        this.f11091g = null;
        this.f11092h = f11084k;
        this.f11093i = null;
        this.f11085a = i8;
    }
}
