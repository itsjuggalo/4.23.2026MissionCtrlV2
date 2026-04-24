package t3;

import java.io.IOException;

/* JADX INFO: renamed from: t3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1180b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10234a;

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        switch (this.f10234a) {
            case 0:
                if (aVar.B() != 9) {
                    return Double.valueOf(aVar.s());
                }
                aVar.x();
                return null;
            case 1:
                if (aVar.B() != 9) {
                    return Float.valueOf((float) aVar.s());
                }
                aVar.x();
                return null;
            default:
                aVar.H();
                return null;
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        switch (this.f10234a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    e.a(dDoubleValue);
                    bVar.r(dDoubleValue);
                } else {
                    bVar.m();
                }
                break;
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    e.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    bVar.u(numberValueOf);
                } else {
                    bVar.m();
                }
                break;
            default:
                bVar.m();
                break;
        }
    }

    public String toString() {
        switch (this.f10234a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
