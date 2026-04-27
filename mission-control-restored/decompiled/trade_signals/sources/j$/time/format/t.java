package j$.time.format;

import j$.time.temporal.TemporalAccessor;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TemporalAccessor f19787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DateTimeFormatter f19788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19789c;

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    t(j$.time.temporal.TemporalAccessor r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.t.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }

    final void a() {
        this.f19789c--;
    }

    final w b() {
        return this.f19788b.b();
    }

    final Locale c() {
        return this.f19788b.c();
    }

    final TemporalAccessor d() {
        return this.f19787a;
    }

    final Long e(j$.time.temporal.r rVar) {
        int i8 = this.f19789c;
        TemporalAccessor temporalAccessor = this.f19787a;
        if (i8 <= 0 || temporalAccessor.f(rVar)) {
            return Long.valueOf(temporalAccessor.g(rVar));
        }
        return null;
    }

    final Object f(C2195a c2195a) {
        TemporalAccessor temporalAccessor = this.f19787a;
        Object objB = temporalAccessor.b(c2195a);
        if (objB != null || this.f19789c != 0) {
            return objB;
        }
        throw new j$.time.c("Unable to extract " + c2195a + " from temporal " + temporalAccessor);
    }

    final void g() {
        this.f19789c++;
    }

    public final String toString() {
        return this.f19787a.toString();
    }
}
