package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import u0.AbstractC1198a;
import u0.b;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC1198a abstractC1198a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4427a = abstractC1198a.f(iconCompat.f4427a, 1);
        byte[] bArr = iconCompat.f4429c;
        if (abstractC1198a.e(2)) {
            Parcel parcel = ((b) abstractC1198a).e;
            int i = parcel.readInt();
            if (i < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f4429c = bArr;
        iconCompat.f4430d = abstractC1198a.g(iconCompat.f4430d, 3);
        iconCompat.e = abstractC1198a.f(iconCompat.e, 4);
        iconCompat.f4431f = abstractC1198a.f(iconCompat.f4431f, 5);
        iconCompat.f4432g = (ColorStateList) abstractC1198a.g(iconCompat.f4432g, 6);
        String string = iconCompat.i;
        if (abstractC1198a.e(7)) {
            string = ((b) abstractC1198a).e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.f4434j;
        if (abstractC1198a.e(8)) {
            string2 = ((b) abstractC1198a).e.readString();
        }
        iconCompat.f4434j = string2;
        iconCompat.f4433h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f4427a) {
            case -1:
                Parcelable parcelable = iconCompat.f4430d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f4428b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f4430d;
                if (parcelable2 != null) {
                    iconCompat.f4428b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f4429c;
                iconCompat.f4428b = bArr3;
                iconCompat.f4427a = 3;
                iconCompat.e = 0;
                iconCompat.f4431f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f4429c, Charset.forName("UTF-16"));
                iconCompat.f4428b = str;
                if (iconCompat.f4427a == 2 && iconCompat.f4434j == null) {
                    iconCompat.f4434j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f4428b = iconCompat.f4429c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        iconCompat.i = iconCompat.f4433h.name();
        switch (iconCompat.f4427a) {
            case -1:
                iconCompat.f4430d = (Parcelable) iconCompat.f4428b;
                break;
            case 1:
            case 5:
                iconCompat.f4430d = (Parcelable) iconCompat.f4428b;
                break;
            case 2:
                iconCompat.f4429c = ((String) iconCompat.f4428b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f4429c = (byte[]) iconCompat.f4428b;
                break;
            case 4:
            case 6:
                iconCompat.f4429c = iconCompat.f4428b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f4427a;
        if (-1 != i) {
            abstractC1198a.j(i, 1);
        }
        byte[] bArr = iconCompat.f4429c;
        if (bArr != null) {
            abstractC1198a.i(2);
            int length = bArr.length;
            Parcel parcel = ((b) abstractC1198a).e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f4430d;
        if (parcelable != null) {
            abstractC1198a.k(parcelable, 3);
        }
        int i6 = iconCompat.e;
        if (i6 != 0) {
            abstractC1198a.j(i6, 4);
        }
        int i7 = iconCompat.f4431f;
        if (i7 != 0) {
            abstractC1198a.j(i7, 5);
        }
        ColorStateList colorStateList = iconCompat.f4432g;
        if (colorStateList != null) {
            abstractC1198a.k(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            abstractC1198a.i(7);
            ((b) abstractC1198a).e.writeString(str);
        }
        String str2 = iconCompat.f4434j;
        if (str2 != null) {
            abstractC1198a.i(8);
            ((b) abstractC1198a).e.writeString(str2);
        }
    }
}
