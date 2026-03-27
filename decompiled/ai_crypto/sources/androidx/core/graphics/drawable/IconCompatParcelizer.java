package androidx.core.graphics.drawable;

import K0.a;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f7260a = aVar.p(iconCompat.f7260a, 1);
        iconCompat.f7262c = aVar.j(iconCompat.f7262c, 2);
        iconCompat.f7263d = aVar.r(iconCompat.f7263d, 3);
        iconCompat.f7264e = aVar.p(iconCompat.f7264e, 4);
        iconCompat.f7265f = aVar.p(iconCompat.f7265f, 5);
        iconCompat.f7266g = (ColorStateList) aVar.r(iconCompat.f7266g, 6);
        iconCompat.f7268i = aVar.t(iconCompat.f7268i, 7);
        iconCompat.f7269j = aVar.t(iconCompat.f7269j, 8);
        iconCompat.r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.s(aVar.f());
        int i7 = iconCompat.f7260a;
        if (-1 != i7) {
            aVar.F(i7, 1);
        }
        byte[] bArr = iconCompat.f7262c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f7263d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i8 = iconCompat.f7264e;
        if (i8 != 0) {
            aVar.F(i8, 4);
        }
        int i9 = iconCompat.f7265f;
        if (i9 != 0) {
            aVar.F(i9, 5);
        }
        ColorStateList colorStateList = iconCompat.f7266g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f7268i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f7269j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
