package j$.time;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements j$.time.temporal.q, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f13292d = new r(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13295c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        b.b(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public static r b(int i4) {
        if (i4 == 0) {
            return f13292d;
        }
        return new r(0, 0, i4);
    }

    private r(int i4, int i5, int i6) {
        this.f13293a = i4;
        this.f13294b = i5;
        this.f13295c = i6;
    }

    public final int a() {
        return this.f13295c;
    }

    public final long d() {
        return (((long) this.f13293a) * 12) + ((long) this.f13294b);
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m p(j$.time.temporal.m mVar) {
        j$.time.chrono.l lVar = (j$.time.chrono.l) mVar.a(j$.time.temporal.s.a());
        if (lVar == null || j$.time.chrono.s.f13177d.equals(lVar)) {
            if (this.f13294b == 0) {
                int i4 = this.f13293a;
                if (i4 != 0) {
                    mVar = mVar.d(i4, j$.time.temporal.b.YEARS);
                }
            } else {
                long jD = d();
                if (jD != 0) {
                    mVar = mVar.d(jD, j$.time.temporal.b.MONTHS);
                }
            }
            int i5 = this.f13295c;
            return i5 != 0 ? mVar.d(i5, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new c("Chronology mismatch, expected: ISO, actual: " + lVar.s());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f13293a == rVar.f13293a && this.f13294b == rVar.f13294b && this.f13295c == rVar.f13295c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f13295c, 16) + Integer.rotateLeft(this.f13294b, 8) + this.f13293a;
    }

    public final String toString() {
        if (this == f13292d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i4 = this.f13293a;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('Y');
        }
        int i5 = this.f13294b;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        int i6 = this.f13295c;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.f13293a);
        objectOutput.writeInt(this.f13294b);
        objectOutput.writeInt(this.f13295c);
    }

    static r c(ObjectInput objectInput) throws IOException {
        int i4 = objectInput.readInt();
        int i5 = objectInput.readInt();
        int i6 = objectInput.readInt();
        if ((i4 | i5 | i6) == 0) {
            return f13292d;
        }
        return new r(i4, i5, i6);
    }
}
