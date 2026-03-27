package w3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: renamed from: w3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1288h extends t3.s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1285e f10756c = new C1285e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1287g f10757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10758b;

    public C1288h(AbstractC1287g abstractC1287g) {
        ArrayList arrayList = new ArrayList();
        this.f10758b = arrayList;
        Objects.requireNonNull(abstractC1287g);
        this.f10757a = abstractC1287g;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (v3.h.f10619a >= 9) {
            arrayList.add(new SimpleDateFormat(a3.d.k("MMM d, yyyy", " ", "h:mm:ss a"), locale));
        }
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        Date dateB;
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        synchronized (this.f10758b) {
            try {
                Iterator it = this.f10758b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        try {
                            dateB = x3.a.b(strZ, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder sbP = a3.d.p("Failed parsing '", strZ, "' as Date; at path ");
                            sbP.append(aVar.n());
                            throw new t3.i(sbP.toString(), e);
                        }
                    }
                    DateFormat dateFormat = (DateFormat) it.next();
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strZ);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f10757a.a(dateB);
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.m();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f10758b.get(0);
        synchronized (this.f10758b) {
            str = dateFormat.format(date);
        }
        bVar.v(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f10758b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
