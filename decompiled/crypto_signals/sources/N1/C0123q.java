package N1;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: N1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0123q extends E0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1752d;

    @Override // N1.E0
    public final boolean q() {
        Calendar calendar = Calendar.getInstance();
        this.f1751c = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f1752d = sb.toString();
        return false;
    }

    public final long t() {
        r();
        return this.f1751c;
    }

    public final String u() {
        r();
        return this.f1752d;
    }
}
