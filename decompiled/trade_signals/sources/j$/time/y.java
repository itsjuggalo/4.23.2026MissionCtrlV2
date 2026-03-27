package j$.time;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class y extends ZoneId {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f19876d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient j$.time.zone.f f19878c;

    y(String str, j$.time.zone.f fVar) {
        this.f19877b = str;
        this.f19878c = fVar;
    }

    static y U(String str, boolean z7) {
        j$.time.zone.f fVarB;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length < 2) {
            throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
        }
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i8 == 0) && ((cCharAt < '0' || cCharAt > '9' || i8 == 0) && ((cCharAt != '~' || i8 == 0) && ((cCharAt != '.' || i8 == 0) && ((cCharAt != '_' || i8 == 0) && ((cCharAt != '+' || i8 == 0) && (cCharAt != '-' || i8 == 0))))))))) {
                throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
            }
        }
        try {
            fVarB = j$.time.zone.j.b(str, true);
        } catch (j$.time.zone.g e8) {
            if (z7) {
                throw e8;
            }
            fVarB = null;
        }
        return new y(str, fVarB);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 7, this);
    }

    @Override // j$.time.ZoneId
    final void R(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f19877b);
    }

    final void X(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f19877b);
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f19877b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f q() {
        j$.time.zone.f fVar = this.f19878c;
        return fVar != null ? fVar : j$.time.zone.j.b(this.f19877b, false);
    }
}
