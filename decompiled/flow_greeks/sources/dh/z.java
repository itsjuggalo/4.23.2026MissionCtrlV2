package dh;

import java.util.Arrays;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f8260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bh.e f8261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f8262c;

    public z(final String serialName, Enum[] values) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(values, "values");
        this.f8260a = values;
        this.f8262c = cd.l.b(new Function0() { // from class: dh.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z.c(this.f8253a, serialName);
            }
        });
    }

    public static final bh.e c(z zVar, String str) {
        bh.e eVar = zVar.f8261b;
        return eVar == null ? zVar.b(str) : eVar;
    }

    public final bh.e b(String str) {
        x xVar = new x(str, this.f8260a.length);
        for (Enum r02 : this.f8260a) {
            j1.q(xVar, r02.name(), false, 2, null);
        }
        return xVar;
    }

    @Override // zg.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        int iX = decoder.x(getDescriptor());
        if (iX >= 0) {
            Enum[] enumArr = this.f8260a;
            if (iX < enumArr.length) {
                return enumArr[iX];
            }
        }
        throw new zg.j(iX + " is not among valid " + getDescriptor().i() + " enum values, values size is " + this.f8260a.length);
    }

    @Override // zg.k
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, Enum value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        int iM = dd.n.M(this.f8260a, value);
        if (iM != -1) {
            encoder.y(getDescriptor(), iM);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(value);
        sb2.append(" is not a valid enum ");
        sb2.append(getDescriptor().i());
        sb2.append(", must be one of ");
        String string = Arrays.toString(this.f8260a);
        kotlin.jvm.internal.t.e(string, "toString(...)");
        sb2.append(string);
        throw new zg.j(sb2.toString());
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return (bh.e) this.f8262c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().i() + '>';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z(String serialName, Enum[] values, bh.e descriptor) {
        this(serialName, values);
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(values, "values");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f8261b = descriptor;
    }
}
