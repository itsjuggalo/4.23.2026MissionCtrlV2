package androidx.core.graphics.drawable;

import E0.a;
import android.content.res.ColorStateList;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f11085a = aVar.p(iconCompat.f11085a, 1);
        iconCompat.f11087c = aVar.j(iconCompat.f11087c, 2);
        iconCompat.f11088d = aVar.r(iconCompat.f11088d, 3);
        iconCompat.f11089e = aVar.p(iconCompat.f11089e, 4);
        iconCompat.f11090f = aVar.p(iconCompat.f11090f, 5);
        iconCompat.f11091g = (ColorStateList) aVar.r(iconCompat.f11091g, 6);
        iconCompat.f11093i = aVar.t(iconCompat.f11093i, 7);
        iconCompat.f11094j = aVar.t(iconCompat.f11094j, 8);
        iconCompat.r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.s(aVar.f());
        int i8 = iconCompat.f11085a;
        if (-1 != i8) {
            aVar.F(i8, 1);
        }
        byte[] bArr = iconCompat.f11087c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f11088d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i9 = iconCompat.f11089e;
        if (i9 != 0) {
            aVar.F(i9, 4);
        }
        int i10 = iconCompat.f11090f;
        if (i10 != 0) {
            aVar.F(i10, 5);
        }
        ColorStateList colorStateList = iconCompat.f11091g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f11093i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f11094j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
