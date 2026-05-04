package d9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f7981a;

    public y1(double[] dArr) {
        this.f7981a = dArr == null ? new double[0] : (double[]) dArr.clone();
    }

    public double[] a() {
        return (double[]) this.f7981a.clone();
    }

    public List b() {
        ArrayList arrayList = new ArrayList(this.f7981a.length);
        int i10 = 0;
        while (true) {
            double[] dArr = this.f7981a;
            if (i10 >= dArr.length) {
                return arrayList;
            }
            arrayList.add(i10, Double.valueOf(dArr[i10]));
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f7981a, ((y1) obj).f7981a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f7981a);
    }
}
