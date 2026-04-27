package K2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f945a;

    public l0(double[] dArr) {
        this.f945a = (double[]) dArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l0.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f945a, ((l0) obj).f945a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f945a);
    }
}
