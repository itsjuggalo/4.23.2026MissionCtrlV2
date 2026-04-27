package S1;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class D extends U3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3897d;

    public D(C0658q3 c0658q3) {
        super(c0658q3);
    }

    @Override // S1.U3
    public final boolean i() {
        Calendar calendar = Calendar.getInstance();
        this.f3896c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f3897d = sb.toString();
        return false;
    }

    public final long o() {
        l();
        return this.f3896c;
    }

    public final String p() {
        l();
        return this.f3897d;
    }
}
