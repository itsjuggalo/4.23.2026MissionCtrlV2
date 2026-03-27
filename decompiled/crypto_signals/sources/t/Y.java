package t;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f9801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f9802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9804d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9805f;

    public static Y a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        CharSequence charSequence = bundle.getCharSequence("name");
        IconCompat iconCompatA = bundle2 != null ? IconCompat.a(bundle2) : null;
        String string = bundle.getString("uri");
        String string2 = bundle.getString("key");
        boolean z6 = bundle.getBoolean("isBot");
        boolean z7 = bundle.getBoolean("isImportant");
        Y y = new Y();
        y.f9801a = charSequence;
        y.f9802b = iconCompatA;
        y.f9803c = string;
        y.f9804d = string2;
        y.e = z6;
        y.f9805f = z7;
        return y;
    }

    public final Bundle b() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.f9801a);
        IconCompat iconCompat = this.f9802b;
        if (iconCompat != null) {
            bundle = new Bundle();
            switch (iconCompat.f4427a) {
                case -1:
                    bundle.putParcelable("obj", (Parcelable) iconCompat.f4428b);
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("Invalid icon");
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) iconCompat.f4428b);
                    break;
                case 2:
                case 4:
                case 6:
                    bundle.putString("obj", (String) iconCompat.f4428b);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) iconCompat.f4428b);
                    break;
            }
            bundle.putInt("type", iconCompat.f4427a);
            bundle.putInt("int1", iconCompat.e);
            bundle.putInt("int2", iconCompat.f4431f);
            bundle.putString("string1", iconCompat.f4434j);
            ColorStateList colorStateList = iconCompat.f4432g;
            if (colorStateList != null) {
                bundle.putParcelable("tint_list", colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f4433h;
            if (mode != IconCompat.f4426k) {
                bundle.putString("tint_mode", mode.name());
            }
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f9803c);
        bundle2.putString("key", this.f9804d);
        bundle2.putBoolean("isBot", this.e);
        bundle2.putBoolean("isImportant", this.f9805f);
        return bundle2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Y)) {
            return false;
        }
        Y y = (Y) obj;
        String str = this.f9804d;
        String str2 = y.f9804d;
        return (str == null && str2 == null) ? Objects.equals(Objects.toString(this.f9801a), Objects.toString(y.f9801a)) && Objects.equals(this.f9803c, y.f9803c) && Boolean.valueOf(this.e).equals(Boolean.valueOf(y.e)) && Boolean.valueOf(this.f9805f).equals(Boolean.valueOf(y.f9805f)) : Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.f9804d;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(this.f9801a, this.f9803c, Boolean.valueOf(this.e), Boolean.valueOf(this.f9805f));
    }
}
