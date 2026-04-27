package w3;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public class W extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        int iT;
        int i = 0;
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        aVar.f();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (aVar.B() != 4) {
            String strV = aVar.v();
            iT = aVar.t();
            strV.getClass();
            switch (strV) {
                case "dayOfMonth":
                    i7 = iT;
                    break;
                case "minute":
                    i9 = iT;
                    break;
                case "second":
                    i10 = iT;
                    break;
                case "year":
                    i = iT;
                    break;
                case "month":
                    i6 = iT;
                    break;
                case "hourOfDay":
                    i8 = iT;
                    break;
            }
        }
        aVar.j();
        return new GregorianCalendar(i, i6, i7, i8, i9, i10);
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        if (((Calendar) obj) == null) {
            bVar.m();
            return;
        }
        bVar.g();
        bVar.k("year");
        bVar.s(r4.get(1));
        bVar.k("month");
        bVar.s(r4.get(2));
        bVar.k("dayOfMonth");
        bVar.s(r4.get(5));
        bVar.k("hourOfDay");
        bVar.s(r4.get(11));
        bVar.k("minute");
        bVar.s(r4.get(12));
        bVar.k("second");
        bVar.s(r4.get(13));
        bVar.j();
    }
}
