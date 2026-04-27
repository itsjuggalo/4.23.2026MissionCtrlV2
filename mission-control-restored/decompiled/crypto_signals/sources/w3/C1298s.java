package w3;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: renamed from: w3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1298s implements t3.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10808b;

    public /* synthetic */ C1298s(Object obj, int i) {
        this.f10807a = i;
        this.f10808b = obj;
    }

    @Override // t3.t
    public final t3.s create(t3.e eVar, A3.a aVar) {
        switch (this.f10807a) {
            case 0:
                if (aVar.f61a == Number.class) {
                    return (C1299t) this.f10808b;
                }
                return null;
            case 1:
                if (aVar.f61a == Object.class) {
                    return new C1300u(eVar, (t3.q) this.f10808b);
                }
                return null;
            default:
                Class cls = aVar.f61a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (W) this.f10808b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f10807a) {
            case 2:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((W) this.f10808b) + "]";
            default:
                return super.toString();
        }
    }
}
