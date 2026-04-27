package A;

import N2.C0162k;
import P2.C0204b;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import s3.B0;
import s3.I0;
import t2.C1118F;
import t2.r0;
import w2.C1278a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9a;

    public /* synthetic */ d(int i) {
        this.f9a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b3 = bArr[i];
                    byte b6 = bArr2[i];
                    if (b3 != b6) {
                        return b3 - b6;
                    }
                }
                return 0;
            case 1:
                C0204b c0204b = (C0204b) obj;
                C0204b c0204b2 = (C0204b) obj2;
                int iA = c0204b.f2427a.compareTo(c0204b2.f2427a);
                return iA != 0 ? iA : Integer.compare(c0204b.f2428b, c0204b2.f2428b);
            case 2:
                C0204b c0204b3 = (C0204b) obj;
                C0204b c0204b4 = (C0204b) obj2;
                int iCompare = Integer.compare(c0204b3.f2428b, c0204b4.f2428b);
                return iCompare != 0 ? iCompare : c0204b3.f2427a.compareTo(c0204b4.f2427a);
            case 3:
                return ((Long) obj2).compareTo((Long) obj);
            case 4:
                Q2.a aVar = (Q2.a) obj;
                Q2.a aVar2 = (Q2.a) obj2;
                int iCompare2 = Long.compare(aVar.f2659d.f2664a, aVar2.f2659d.f2664a);
                return iCompare2 == 0 ? aVar.f2657b.compareTo(aVar2.f2657b) : iCompare2;
            case 5:
                return Integer.compare(((R2.i) obj).f2783a, ((R2.i) obj2).f2783a);
            case 6:
                return ((Q2.h) obj).compareTo((Q2.h) obj2);
            case 7:
                Q2.a aVar3 = (Q2.a) obj;
                Q2.a aVar4 = (Q2.a) obj2;
                int iCompareTo = aVar3.f2657b.compareTo(aVar4.f2657b);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                Iterator it = aVar3.f2658c.iterator();
                Iterator it2 = aVar4.f2658c.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Q2.d dVar = (Q2.d) it.next();
                    Q2.d dVar2 = (Q2.d) it2.next();
                    dVar.getClass();
                    int iD = dVar.f2666a.compareTo(dVar2.f2666a);
                    int iA2 = iD != 0 ? iD : S.i.a(dVar.f2667b, dVar2.f2667b);
                    if (iA2 != 0) {
                        return iA2;
                    }
                }
                return Boolean.compare(it.hasNext(), it2.hasNext());
            case 8:
                return Q2.b.b((Q2.k) obj).compareTo(Q2.b.b((Q2.k) obj2));
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return ((C0162k) obj).f2020c.compareTo(((C0162k) obj2).f2020c);
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 11:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 13:
                return ((C1118F) ((r0) obj)).f9953a.compareTo(((C1118F) ((r0) obj2)).f9953a);
            case 14:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            default:
                String name = ((File) obj).getName();
                int i6 = C1278a.f10715f;
                return name.substring(0, i6).compareTo(((File) obj2).getName().substring(0, i6));
        }
    }
}
