package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import p2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1565a = aVar.p(iconCompat.f1565a, 1);
        iconCompat.f1567c = aVar.j(iconCompat.f1567c, 2);
        iconCompat.f1568d = aVar.r(iconCompat.f1568d, 3);
        iconCompat.f1569e = aVar.p(iconCompat.f1569e, 4);
        iconCompat.f1570f = aVar.p(iconCompat.f1570f, 5);
        iconCompat.f1571g = (ColorStateList) aVar.r(iconCompat.f1571g, 6);
        iconCompat.f1573i = aVar.t(iconCompat.f1573i, 7);
        iconCompat.f1574j = aVar.t(iconCompat.f1574j, 8);
        iconCompat.r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.s(aVar.f());
        int i10 = iconCompat.f1565a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f1567c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1568d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f1569e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f1570f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f1571g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1573i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f1574j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
