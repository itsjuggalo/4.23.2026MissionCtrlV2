package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements j$.time.temporal.p, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f13577e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f13578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13581d;

    static {
        j$.time.b.a(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public h(l lVar, int i10, int i11, int i12) {
        this.f13578a = lVar;
        this.f13579b = i10;
        this.f13580c = i11;
        this.f13581d = i12;
    }

    public final String toString() {
        if (this.f13579b == 0 && this.f13580c == 0 && this.f13581d == 0) {
            return this.f13578a.toString() + " P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13578a.toString());
        sb2.append(" P");
        int i10 = this.f13579b;
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('Y');
        }
        int i11 = this.f13580c;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        int i12 = this.f13581d;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('D');
        }
        return sb2.toString();
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        l lVar = (l) mVar.b(j$.time.temporal.r.f13754b);
        if (lVar == null || this.f13578a.equals(lVar)) {
            if (this.f13580c != 0) {
                j$.time.temporal.u uVarY = this.f13578a.y(j$.time.temporal.a.MONTH_OF_YEAR);
                long j10 = (uVarY.f13760a == uVarY.f13761b && uVarY.f13762c == uVarY.f13763d && uVarY.d()) ? (uVarY.f13763d - uVarY.f13760a) + 1 : -1L;
                if (j10 > 0) {
                    mVar = mVar.d((((long) this.f13579b) * j10) + ((long) this.f13580c), j$.time.temporal.b.MONTHS);
                } else {
                    int i10 = this.f13579b;
                    if (i10 != 0) {
                        mVar = mVar.d(i10, j$.time.temporal.b.YEARS);
                    }
                    mVar = mVar.d(this.f13580c, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i11 = this.f13579b;
                if (i11 != 0) {
                    mVar = mVar.d(i11, j$.time.temporal.b.YEARS);
                }
            }
            int i12 = this.f13581d;
            return i12 != 0 ? mVar.d(i12, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new j$.time.c("Chronology mismatch, expected: " + this.f13578a.q() + ", actual: " + lVar.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f13579b == hVar.f13579b && this.f13580c == hVar.f13580c && this.f13581d == hVar.f13581d && this.f13578a.equals(hVar.f13578a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f13581d, 16) + (Integer.rotateLeft(this.f13580c, 8) + this.f13579b)) ^ this.f13578a.hashCode();
    }

    public Object writeReplace() {
        return new e0((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
