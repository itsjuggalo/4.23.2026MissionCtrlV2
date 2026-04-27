package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC1782a abstractC1782a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f6852a = abstractC1782a.p(iconCompat.f6852a, 1);
        iconCompat.f6854c = abstractC1782a.j(iconCompat.f6854c, 2);
        iconCompat.f6855d = abstractC1782a.r(iconCompat.f6855d, 3);
        iconCompat.f6856e = abstractC1782a.p(iconCompat.f6856e, 4);
        iconCompat.f6857f = abstractC1782a.p(iconCompat.f6857f, 5);
        iconCompat.f6858g = (ColorStateList) abstractC1782a.r(iconCompat.f6858g, 6);
        iconCompat.f6860i = abstractC1782a.t(iconCompat.f6860i, 7);
        iconCompat.f6861j = abstractC1782a.t(iconCompat.f6861j, 8);
        iconCompat.r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(true, true);
        iconCompat.s(abstractC1782a.f());
        int i4 = iconCompat.f6852a;
        if (-1 != i4) {
            abstractC1782a.F(i4, 1);
        }
        byte[] bArr = iconCompat.f6854c;
        if (bArr != null) {
            abstractC1782a.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f6855d;
        if (parcelable != null) {
            abstractC1782a.H(parcelable, 3);
        }
        int i5 = iconCompat.f6856e;
        if (i5 != 0) {
            abstractC1782a.F(i5, 4);
        }
        int i6 = iconCompat.f6857f;
        if (i6 != 0) {
            abstractC1782a.F(i6, 5);
        }
        ColorStateList colorStateList = iconCompat.f6858g;
        if (colorStateList != null) {
            abstractC1782a.H(colorStateList, 6);
        }
        String str = iconCompat.f6860i;
        if (str != null) {
            abstractC1782a.J(str, 7);
        }
        String str2 = iconCompat.f6861j;
        if (str2 != null) {
            abstractC1782a.J(str2, 8);
        }
    }
}
