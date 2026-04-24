package j$.time.chrono;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* JADX INFO: renamed from: j$.time.chrono.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C1555h implements j$.time.temporal.q, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f13150e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f13151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f13152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f13153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f13154d;

    static {
        j$.time.b.b(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    C1555h(l lVar, int i4, int i5, int i6) {
        this.f13151a = lVar;
        this.f13152b = i4;
        this.f13153c = i5;
        this.f13154d = i6;
    }

    public final String toString() {
        l lVar = this.f13151a;
        int i4 = this.f13154d;
        int i5 = this.f13153c;
        int i6 = this.f13152b;
        if (i6 == 0 && i5 == 0 && i4 == 0) {
            return lVar.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lVar.toString());
        sb.append(" P");
        if (i6 != 0) {
            sb.append(i6);
            sb.append('Y');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m p(j$.time.temporal.m mVar) {
        l lVar = (l) mVar.a(j$.time.temporal.s.a());
        l lVar2 = this.f13151a;
        if (lVar == null || lVar2.equals(lVar)) {
            int i4 = this.f13152b;
            int i5 = this.f13153c;
            if (i5 != 0) {
                j$.time.temporal.w wVarU = lVar2.U(j$.time.temporal.a.MONTH_OF_YEAR);
                long jD = (wVarU.g() && wVarU.h()) ? (wVarU.d() - wVarU.e()) + 1 : -1L;
                if (jD > 0) {
                    mVar = mVar.d((((long) i4) * jD) + ((long) i5), j$.time.temporal.b.MONTHS);
                } else {
                    if (i4 != 0) {
                        mVar = mVar.d(i4, j$.time.temporal.b.YEARS);
                    }
                    mVar = mVar.d(i5, j$.time.temporal.b.MONTHS);
                }
            } else if (i4 != 0) {
                mVar = mVar.d(i4, j$.time.temporal.b.YEARS);
            }
            int i6 = this.f13154d;
            return i6 != 0 ? mVar.d(i6, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new j$.time.c("Chronology mismatch, expected: " + lVar2.s() + ", actual: " + lVar.s());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1555h) {
            C1555h c1555h = (C1555h) obj;
            if (this.f13152b == c1555h.f13152b && this.f13153c == c1555h.f13153c && this.f13154d == c1555h.f13154d && this.f13151a.equals(c1555h.f13151a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13151a.hashCode() ^ (Integer.rotateLeft(this.f13154d, 16) + (Integer.rotateLeft(this.f13153c, 8) + this.f13152b));
    }

    protected Object writeReplace() {
        return new E((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f13151a.s());
        objectOutput.writeInt(this.f13152b);
        objectOutput.writeInt(this.f13153c);
        objectOutput.writeInt(this.f13154d);
    }
}
